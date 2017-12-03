package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Gomma;
import main.dao.GommaDAO;
import main.service.GommaService;
import main.service.VehicleService;

import java.util.List;
import java.util.Scanner;

public class GommaView implements View {

    private GommaService gommaService;
    private VehicleService vehicleService;
    private String mode;
    private String role;

  public GommaView () {
      this.gommaService = new GommaService();
      this.vehicleService = new VehicleService();
      this.mode = "all";
  }

    @Override
    public void showResults(Request request) {
       this.mode  = (String) request.get("mode");
       role = request.get("role").toString();
    }

    @Override
    public void showOptions() {
        switch (mode) {
            case "allGomme": {
                List<Gomma> gomme = gommaService.getAllGomme();
                System.out.println("----- Gomme disponibili -----");
                System.out.println();
                gomme.forEach(gomma -> System.out.println(gomma));
                break;
            }
            case "insert": {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Inserisci i dati della nuova gomma:");
                System.out.println("Modello:");
                String model = getInput();
                System.out.println("Produttore:");
                String manufacturer = getInput();
                System.out.println("Prezzo:");
                double price = Double.parseDouble(getInput());
                System.out.println("Larghezza:");
                double width = Double.parseDouble(getInput());
                System.out.println("Altezza:");
                double height = Double.parseDouble(getInput());
                System.out.println("Diametro:");
                double diameter = Double.parseDouble(getInput());
                System.out.println("Carico:");
                double weight = Double.parseDouble(getInput());
                System.out.println("Velocità:");
                String speed = getInput();
                System.out.println("Stagione:");
                String season = getInput();
                System.out.println("Tipo Veicolo:");
                String vehicle = getInput();
                System.out.println("Quantità:");
                int quantity = Integer.parseInt(getInput());
                gommaService.insertGomma(new Gomma(null, model, manufacturer, price, width, height, diameter, weight, speed, season, vehicle, quantity));
                break;
            }

            case "gommeForBrand": {
                System.out.println("Scegli il tipo di veicolo: (auto | moto | commerciale)");
                String typeVehicle = getInput();
                System.out.println("\n------Elenco Brand-------\n");
                List<String> brands = gommaService.getAllManufacturerForType(typeVehicle);

                if (!brands.isEmpty())
                    brands.forEach(brand -> System.out.println(brand));
                else {
                    System.out.println("\nNon ci sono gomme per il tipo di veicolo!!");
                    break;
                }

                System.out.println("");
                System.out.println("Scegli il brand dall'elenco");
                String brand = getInput();
                List<Gomma> gomme = gommaService.getAllGommeForManufacturer(brand, typeVehicle);

                if (!gomme.isEmpty())
                gomme.forEach(gomma -> System.out.println(gomma));
                else System.out.println("\nNon ci sono gomme per il brand!!");

                break;
            }

            case "gommeForSize": {
                List<Gomma> gomme = null;
                String typeVehicle;
                do {
                    System.out.println("Scegli il tipo di veicolo: (auto | moto | commerciale)");
                    typeVehicle = getInput();
                } while(!typeVehicle.equals("auto") & !typeVehicle.equals("moto") & !typeVehicle.equals("commerciale"));

                System.out.println("Inserisci Larghezza:");
                double pWidth = Double.parseDouble(getInput());
                System.out.println("Inserisci Altezza:");
                double pHeight = Double.parseDouble(getInput());
                System.out.println("Inserisci Diametro:");
                double pDiameter = Double.parseDouble(getInput());

                if (typeVehicle.equals("auto")) {
                    System.out.println("Inserisci Stagione:");
                    String pSeason = getInput();

                    gomme = gommaService.getGommeForSize(pWidth, pHeight, pDiameter, pSeason, -1, null, typeVehicle);
                }

                else if (typeVehicle.equals("moto") | typeVehicle.equals("commerciale")) {
                    System.out.println("Inserisci Carico:");
                    double pWeight = Double.parseDouble(getInput());
                    System.out.println("Inserisci Velocità:");
                    String pSpeed = getInput();

                    gomme = gommaService.getGommeForSize(pWidth, pHeight, pDiameter, null, pWeight, pSpeed, typeVehicle);
                }

                if (!gomme.isEmpty())
                    gomme.forEach(gomma -> System.out.println(gomma));
                else
                    System.out.println("\nNon ci sono gomme per la dimensione cercata!!");

                break;


            }

            case "gommeById": {
                System.out.println("Inserisci Marca: ");
                String brand = getInput();
                System.out.println("Inserisci Modello: ");
                String model = getInput();
                System.out.println("Inserisci Alimentazione: ");
                String fuel = getInput();
                System.out.println("Inserisci Versione: ");
                String version = getInput();
                System.out.println("Inserisci Cilindrata: ");
                String capacity = getInput();

                Integer idVehicle = vehicleService.getIdVehicle(brand,model,fuel,version,capacity);
                if (idVehicle == null) {
                    System.out.println("\nNon ci auto di questo tipo nel DB!!");
                    break;

                }

                List<Integer> idGomme = gommaService.getCompatibilyGommeId(idVehicle);
                if (!idGomme.isEmpty()) {
                    for (Integer idGomma : idGomme) {
                        Gomma gomma = gommaService.getGommeById(idGomma);
                        System.out.println(gomma);
                    }
                }
                else
                    System.out.println("\nNon ci sono gomme compatibili con questo veicolo!!");

                break;

            }

        }


    }

    @Override
    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
  }

    @Override
    public void submit() {
        Request request = new Request();
        request.put("role", role);
        MainDispatcher.getInstance().callAction("Home", "doControl", request);
    }



}
