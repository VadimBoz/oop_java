package view;

import model.User;

import java.io.IOException;

public interface MenuI {
    void startMainMenu();
    String addUserMenu() throws IOException;
    String toContinue() throws IOException;
    String readUserFromFile() throws IOException;

}
