import controller.Controller;
import view.ReadWriteUser;
import model.User;
import view.PrintToConsole;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;


public class MainEx {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Controller controller = new Controller();
        controller.Start();

//        System.out.println(("Воро-Сина".matches("^[A-ZА-я][a-zа-я-]+(-[A-ZА-я])*[a-zа-я]*")));
////                                        matches("^[A-ZА-я][a-zа-я-]+(-[A-ZА-я])*[a-zа-я]*")
//
//        System.out.println(("Вороина".matches("^[A-ZА-я][a-zа-я-]+")));

//        Воро-Сина Светлана Марковна 01.02.1989 +7(905)456-45-32 ж
    }


}