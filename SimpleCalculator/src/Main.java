
import controller.Controller;
import controller.IController;

import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        System.out.println(System.getProperty("java.util.logging.config.file"));
        IController controller = new Controller();
        controller.startProg();
    }
}

