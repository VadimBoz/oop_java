
import controller.Controller;

import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        System.out.println(System.getProperty("java.util.logging.config.file"));
        Controller controller = new Controller();
        controller.startProg();
    }
}

