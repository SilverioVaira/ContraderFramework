package main.controller;

import main.MainDispatcher;

public class UserController implements Controller {


    @Override
    public void doControl(Request request) {

        int choice = (int) request.get("choice");
        String role = request.get("role").toString();

        switch (role) {
            case "admin" :
                switch (choice) {
                    case 3:
                        request.put("mode", "all");
                        break;
                }

                break;

            case "user" :

                break;
        }
        MainDispatcher.getInstance().callView("User", request);



    }
}
