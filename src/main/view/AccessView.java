package main.view;

import com.sun.org.apache.regexp.internal.RE;
import main.MainDispatcher;
import main.controller.Request;

import java.util.Scanner;

public class AccessView implements View {

    private int access;
    boolean check = false;

    public void showResults (Request request){}

    public void showOptions (){

        System.out.println("\nBenvenuto in ContraderFramework\n");
        System.out.println("1 -> Accedi || 2 -> Registrati\n");
        try {
            access = Integer.parseInt(getInput());
        }
        catch (NumberFormatException e){
            check = true;
        }


    }

    public void submit(){

        if (access < 1 | access > 2 | check) MainDispatcher.getInstance().callView("Access" , null);
        if (access == 1) {
            MainDispatcher.getInstance().callAction("Login", "doControl", null);
        }
        else {
            Request request = new Request();
            request.put("mode" , "reg");
            request.put("role" , "reg");
            MainDispatcher.getInstance().callView("User" , request);

        }

    }

    public String getInput (){

        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
