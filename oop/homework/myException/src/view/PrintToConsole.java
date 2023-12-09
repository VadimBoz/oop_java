package view;

import model.User;

import java.io.File;
import java.util.ArrayList;

public class PrintToConsole {

    public void printListCRV(File[] files) {
        String separator = System.getProperty("file.separator");
        if (separator.equals("\\")) {
            separator = "\\\\";
        }

        for (File item: files) {
            String f[]  = item.toString().split(separator);
            System.out.println(f[f.length -1]);
        }
        System.out.println();
    }

    public void printUser(User user) {
        System.out.println();
        System.out.println(user.toTableView());
    }

    public void printUser(ArrayList<User> users) {
        System.out.println();
        for (User item: users) {
            System.out.println(item.toTableView());
            System.out.println();
        }
    }
}
