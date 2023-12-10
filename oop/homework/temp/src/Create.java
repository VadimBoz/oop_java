import java.util.Scanner;

public class Create {

        public static void main(String[] args) {


        }


    class ConsoleWriter implements Printer, Notifier {
        public void greeting() {
            Printer.super.greeting();
        }
        // override greeting method according to Printer default implementation
    }

    interface Printer {
        default void greeting() {
            System.out.println("Printer is ready");
        }
    }

    interface Notifier {
        default void greeting() {
            System.out.println("Notifier is ready");
        }
    }


}

