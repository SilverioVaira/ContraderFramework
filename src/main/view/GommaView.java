package main.view;
import main.MainDispatcher;
import main.controller.Request;
import main.model.Gomma;
import main.dao.GommaDAO;
import main.service.GommaService;

import java.util.List;
import java.util.Scanner;

public class GommaView implements View {

    private GommaService gommaService;
    private String mode;
    private String role;

  public GommaView () {
      this.gommaService = new GommaService();
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
            case "all": {
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
                gommaService.insertGomma(new Gomma(null, model, manufacturer, price, width, height, diameter, weight, speed, season, vehicle));
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
