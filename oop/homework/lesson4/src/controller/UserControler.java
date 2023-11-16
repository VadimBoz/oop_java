package Controller;

import data.User;

public interface UserControler <T extends User>{
    T create(String firstName, String secondName, String lastName);


}
