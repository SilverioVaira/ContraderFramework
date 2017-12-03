package main.view;

import main.MainDispatcher;
import main.controller.Request;
import sun.applet.Main;

import java.util.Scanner;

public class HomeView implements View {

    private int choice;
    private String role;
    boolean check = false;

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
                System.out.println("2) Visualizza tutte le gomme disponibili");
                System.out.println("3) Visualizza elenco degli utenti");
                System.out.println("4) Inserisci veicolo");
                System.out.println("5) Visualizza elenco dei veicoli");
                System.out.println("6) Logout");

                break;

            case "user":
                System.out.println("Benvenuto in ContraderFramework User");
                System.out.println("");
                System.out.println("-------MENU-------");
                System.out.println("");
                System.out.println("1) Cerca gomme per Brand");
                System.out.println("2) Visualizza tutte le gomme disponibili");
                System.out.println("3) Cerca gomme per dimensione");
                System.out.println("4) Cerca gomme compatibili all'auto");
                System.out.println("5) Logout");

                break;
        }

        try {
            this.choice = Integer.parseInt(getInput());
        }
        catch (NumberFormatException e){
            check = true;
        }

    }

    public void submit() {

        switch (role) {

            case "admin":


                if (choice < 1 || choice > 6 || check) {
                    Request request = new Request();
                    request.put("role", role);
                    MainDispatcher.getInstance().callAction("Home", "doControl", request);
                } else if (choice == 6)
                    MainDispatcher.getInstance().callView("Access", null);
                else if (choice == 3) {
                    Request request = new Request();
                    request.put("choice", choice);
                    request.put("role", role);
                    MainDispatcher.getInstance().callAction("User", "doControl", request);
                }
                else if (choice == 4 | choice == 5){
                    Request request = new Request();
                    request.put("choice", choice);
                    request.put("role", role);
                    MainDispatcher.getInstance().callAction("Vehicle", "doControl", request);
                }
                else {
                    Request request = new Request();
                    request.put("choice", choice);
                    request.put("role", role);
                    MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
                }
                break;

            case "user":
                if (choice < 1 || choice > 5) {
                    Request request = new Request();
                    request.put("role", role);
                    MainDispatcher.getInstance().callAction("Home", "doControl", request);
                } else if (choice == 5)
                    MainDispatcher.getInstance().callView("Access", null);
                else {
                    Request request = new Request();
                    request.put("choice", choice);
                    request.put("role", role);
                    MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
                }
                break;
        }
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
