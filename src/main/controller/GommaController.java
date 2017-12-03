package main.controller;

import main.MainDispatcher;

public class GommaController implements Controller {


    @Override
    public void doControl(Request request) {
        int choice = (int) request.get("choice");
        String role = request.get("role").toString();

        switch (role) {
            case "admin" :
                switch (choice) {
                    case 1:
                        request.put("mode", "insert");
                        break;
                    case 2:
                        request.put("mode", "allGomme");
                        break;
                }

                break;

            case "user" :
                switch (choice) {
                    case 1:
                        request.put("mode", "gommeForBrand");
                        break;
                    case 2:
                        request.put("mode", "allGomme");
                        break;
                    case 3:
                        request.put("mode", "gommeForSize");
                        break;
                    case 4:
                        request.put("mode", "gommeById");
                        break;
                }

                break;
        }
        MainDispatcher.getInstance().callView("Gomma", request);

    }
}
