package main.view;

import main.MainDispatcher;
import main.controller.Request;
import main.model.User;
import main.service.UserService;

import java.util.List;
import java.util.Scanner;

public class UserView implements View {

    private UserService userService;
    private String mode;
    private String role;

    public UserView(){
        this.userService = new UserService();
    }
    
    

    public void showResults (Request request) {

        this.mode  = (String) request.get("mode");
        role = request.get("role").toString();

    }


    public void showOptions () {

        switch (mode) {
            case "all": {
                List<User> gomme = userService.getAllUsers();
                System.out.println("----- Lista Utenti -----");
                System.out.println();
                gomme.forEach(user -> System.out.println(user));
                break;
            }

            case "reg": {

                System.out.println("-----REGISTRAZIONE-----");
                System.out.println("UserName:");
                String username = getInput();
                System.out.println("Password:");
                String password = getInput();
                System.out.println("Nome:");
                String firstName = getInput();
                System.out.println("Cognome:");
                String lastName = getInput();
                System.out.println("Codice Fiscale:");
                String fiscalCode = getInput();
                System.out.println("Data di Nascita:");
                String dateOfBirth = getInput();
                System.out.println("Ragione Sociale:");
                String businessName = getInput();
                System.out.println("Partita IVA:");
                String vat = getInput();
                System.out.println("Città:");
                String town = getInput();
                System.out.println("Provincia:");
                String city = getInput();
                System.out.println("CAP:");
                String postCode = getInput();
                System.out.println("Indirizzo:");
                String address = getInput();
                System.out.println("Recapito Telefonico:");
                String telephone = getInput();

                userService.insertUser(new User(null, username, password, firstName, lastName, fiscalCode, dateOfBirth, businessName, vat, town, postCode, city, address, telephone, "user"));

                break;
            }
        }
        
    }

    public void submit() {
        switch (mode) {
            case "all": {
                Request request = new Request();
                request.put("role", role);
                MainDispatcher.getInstance().callAction("Home", "doControl", request);
                break;
            }

            case "reg": {
                MainDispatcher.getInstance().callAction("Login", "doControl", null);
                break;
            }

        }
    }


    public String getInput () {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    protected void send () {
    }
}
