package controller;

import view.Menu;
import view.MenuI;

import java.io.IOException;
import java.util.Scanner;

public class Controller {

    MenuI menu = new Menu();
    ServiceUserI serviceUser  = new ServiceUser();



    public void Start() {
        int flaf = 1;
        String key;
        try (Scanner in = new Scanner(System.in)) {
            while (flaf != 0) {
                menu.startMainMenu();
                System.out.println("> ");
                key = in.nextLine();

                switch (key) {
                    case "1":
                        serviceUser.findAllUserFilesToConsole();
                        key = menu.toContinue();
                        break;
                    case "2":
                        String newUser = menu.addUserMenu();
                        serviceUser.addUser(newUser);
                        serviceUser.writeCurrentUser();
                        key = menu.toContinue();
                        break;
                    case "3":
                        key = menu.readUserFromFile();
                        serviceUser.readUserFile(key);
                        key = menu.toContinue();
                        break;
                    case "4":
                        flaf = 0;
                        break;
                    default:
                        System.out.println("Такой команды нет\n");
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}