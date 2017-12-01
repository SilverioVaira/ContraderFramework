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
                System.out.println("2) Visualizza tutte le gomme disponibili");
                System.out.println("3) Visualizza elenco degli utenti");
                System.out.println("4) Logout");
                this.choice = Integer.parseInt(getInput());
                break;

            case "user":
                System.out.println("Benvenuto in ContraderFramework User");
                System.out.println("");
                System.out.println("-------MENU-------");
                System.out.println("");
                System.out.println("1) Cerca gomme per Brand");
                System.out.println("2) Visualizza tutte le gomme disponibili");
                System.out.println("3) Cerca gomme per dimensione");
                System.out.println("4) Logout");
                this.choice = Integer.parseInt(getInput());
                break;
        }

    }

    public void submit() {

        switch (role) {

            case "admin":


                if (choice < 1 || choice > 4) {
                    Request request = new Request();
                    request.put("role", role);
                    MainDispatcher.getInstance().callAction("Home", "doControl", request);
                } else if (choice == 4)
                    MainDispatcher.getInstance().callView("Access", null);
                else if (choice == 3) {
                    Request request = new Request();
                    request.put("choice", choice);
                    request.put("role", role);
                    MainDispatcher.getInstance().callAction("User", "doControl", request);
                }
                else {
                    Request request = new Request();
                    request.put("choice", choice);
                    request.put("role", role);
                    MainDispatcher.getInstance().callAction("Gomma", "doControl", request);
                }
                break;

            case "user":
                if (choice < 1 || choice > 4) {
                    Request request = new Request();
                    request.put("role", role);
                    MainDispatcher.getInstance().callAction("Home", "doControl", request);
                } else if (choice == 4)
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
