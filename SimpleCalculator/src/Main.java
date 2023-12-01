
import controller.Controller;
import controller.IController;

public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.util.logging.config.file"));
        IController controller = new Controller();
        controller.startProg();
    }
}

