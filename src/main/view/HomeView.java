package main.view;

import main.MainDispatcher;
import main.controller.Request;
import sun.applet.Main;

import java.util.Scanner;

public class HomeView implements View {

    private int choice;
    private String role;

    public void showResults(Request request) {

        role = request.get("role").toString();
    }

    public void showOptions() {


        switch (role){

            case "admin" :
                System.out.println("Benvenuto in ContraderFramework Admin");
                System.out.println("");
                System.out.println("-------MENU-------");
                System.out.println("");
                System.out.println("1) Inserisci gomma");
                System.out.println("2) Visualizza gomme disponibili");
                System.out.println("3) Logout");
                System.out.println("4) Visualizza brand per tipologia del veicolo:");
                this.choice = Integer.parseInt(getInput());
                break;

            case "user":
                System.out.println("Benvenuto in ContraderFramework User");
                System.out.println("");
                System.out.println("-------MENU-------");
                System.out.println("");
                System.out.println("2) Visualizza gomme disponibili");
                System.out.println("4) Visualizza brand per tipologia del veicolo:");
                System.out.println("3) Logout");
                this.choice = Integer.parseInt(getInput());
                break;
        }

    }

    public void submit() {
        if (choice < 1 || choice > 4) {
            Request request = new Request();
            request.put("role", role);
            MainDispatcher.getInstance().callAction("Home", "doControl", request);
        }
        else if (choice == 3)
            MainDispatcher.getInstance().callAction("Login", "doControl", null);
        else {
            Request request = new Request();
            request.put("choice", choice);
            request.put("role", role);
            MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
        }
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
