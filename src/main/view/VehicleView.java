package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.Vehicle;
import main.service.VehicleService;

import java.util.List;
import java.util.Scanner;

public class VehicleView implements View {

    private VehicleService vehicleService;
    private String mode;
    private String role;

    public VehicleView(){
        this.vehicleService = new VehicleService();
    }

    @Override
    public void showResults(Request request) {
        mode = request.get("mode").toString();
        role = request.get("role").toString();

    }

    @Override
    public void showOptions() {

        switch (mode) {

            case "allVehicle": {
                List<Vehicle> vehicles = vehicleService.getAllVehicle();
                System.out.println("----- Lista Veicoli -----");
                System.out.println();
                vehicles.forEach(vehicle -> System.out.println(vehicle));
                break;
            }

            case "insert": {
                System.out.println("Inserisci Marca:");
                String brand = getInput();
                System.out.println("Inserisci Modello:");
                String model = getInput();
                System.out.println("Inserisci Alimentazione:");
                String fuel = getInput();
                System.out.println("Inserisci Versione:");
                String version = getInput();
                System.out.println("Inserisci Cilindrata:");
                String capacity = getInput();

                vehicleService.insert(new Vehicle(null, brand, model, fuel, version, capacity));

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
        switch (mode) {
            case "allVehicle": {
                Request request = new Request();
                request.put("role", role);
                MainDispatcher.getInstance().callAction("Home", "doControl", request);
                break;
            }

            case "insert": {
                Request request = new Request();
                request.put("role", role);
                MainDispatcher.getInstance().callAction("Home", "doControl", request);
                break;
            }
        }
    }


}
