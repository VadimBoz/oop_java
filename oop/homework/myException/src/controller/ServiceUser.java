package controller;

import model.User;
import model.ValidatorInput;
import view.PrintToConsole;
import view.ReadWriteUser;

import java.io.IOException;
import java.util.ArrayList;

public class ServiceUser implements ServiceUserI{

    private User user;
    PrintToConsole printToConsole = new PrintToConsole();
    ReadWriteUser readWriteUser  = new ReadWriteUser();


    public void findAllUserFilesToConsole() {
        printToConsole.printListCRV(readWriteUser.fundAllFiles());
    }


    public void addUser(String str) {
        user = null;
        ValidatorInput validatorInput;
        try {
            validatorInput = new ValidatorInput(str);
            user = new User(validatorInput.getOutData());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        if (!(user == null)) {
            printToConsole.printUser(user);
        }
        else
            System.out.println("пользователь не создан по каким-то причинам");
    }

    public void writeCurrentUser() {
        if (user != null) {
            try {
                readWriteUser.writeUserToFile(user);
                System.out.println("Данные записаны");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } else
            System.out.println("Пользователь еще не создан");
    }

    public void readUserFile(String secondName) {
        ArrayList<User> users;
        try {
            users = readWriteUser.readUserFromFile(secondName);
            printToConsole.printUser(users);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }



    public User getUser() {
        return user;
    }
}
