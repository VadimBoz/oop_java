package controller;

import model.User;

public interface ServiceUserI {

    void findAllUserFilesToConsole();
    void addUser(String str);
    void writeCurrentUser();
    void readUserFile(String secondName);
    User getUser();

}
