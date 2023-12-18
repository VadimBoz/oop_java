import conroller.Controller;
import conroller.ToyService;
import model.Toy;
import model.ToySet;
import view.ToyView;

public class app {
    public static void main(String[] args) {
//        Toy t1 = new Toy(1, 1, "111111");
//        Toy t2 = new Toy(2, 1, "222222");
//        Toy t3 = new Toy(3, 10, "333333");
//        Toy t4 = new Toy(4, 5, "444444");
//        Toy t5 = new Toy(5, 1, "555555");
//
//        ToySet toys = (new ToySet());
//         toys.addToy(t1).addToy(t2).addToy(t3).addToy(t4).addToy("ewdwede 10").addToy(t5);
//
//        System.out.println(toys.getToyList());
//
//        ToyService toyServise = new ToyService(toys.getToyList());
//        for (int i = 0; i < 20; i++) {
//            toyServise.sweepstake();
//            System.out.println(toyServise.getSweepstakes().poll());
//        }
//        System.out.println(toyServise.getToyList());
//        System.out.println(toyServise.getSweepstakes());
//
//
//        ToyView tv = new ToyView();
//        tv.StartMenu();
        Controller controller = new Controller();
        controller.start();

    }
}
