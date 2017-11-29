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
                        request.put("mode", "all");
                        break;
                }

                break;

            case "user" :
                switch (choice) {
                    case 1:
                        request.put("mode", "gommeForBrand");
                        break;
                    case 2:
                        request.put("mode", "all");
                        break;
                }

                break;
        }
        MainDispatcher.getInstance().callView("Gomma", request);

    }
}
