package UI;

public class StartMenu {

    private static StartMenu startMenu;
    private StartMenu() {

    }


    public static void createStartMenu() {
        if (startMenu == null) {
            startMenu =  new StartMenu();
            System.out.println();
            System.out.println("-----------------------Simple Calculator------------------------");
            System.out.println();
            System.out.println("Enter an expression like a + b. Acceptable operations: '+', '-', '*', '/', ':'.");
        }

    }


}
