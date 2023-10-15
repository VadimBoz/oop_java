import java.util.ArrayList;
import java.util.Arrays;

public class MainLesson1 {
    public static void main(String[] args) {
        BottleOfWatter b1 = new BottleOfWatter("lesson1", 1, 1);
        BottleOfWatter b2 = new BottleOfWatter("2", 2, 2);
        BottleOfWatter b3 = new BottleOfWatter("5", 4, 3);
        BottleOfWatter b4 = new BottleOfWatter("15", 123, 1);
        BottleOfWatter b5 = new BottleOfWatter("20", 6, 5);


        BottleOfWaterVendingMachine vendingMachine = new BottleOfWaterVendingMachine(new ArrayList<>());
        vendingMachine.addBottleOfWater(b1);
        vendingMachine.addBottleOfWater(b2);
        vendingMachine.addBottleOfWater(b3);
        vendingMachine.addBottleOfWater(b4);
        vendingMachine.addBottleOfWater(b5);

        System.out.println(vendingMachine.getProduct("20", 5));
        System.out.println(vendingMachine.getProduct("20", 100));
        for (BottleOfWatter b : vendingMachine.getBottleOfWatters()) {
            System.out.println(b);
        }




        HotDrink hotDrink1 = new HotDrink("Americano", 80, 130, 90);
        HotDrink hotDrink2 = new HotDrink("Cappuccino", 85, 130, 90);
        HotDrink hotDrink3 = new HotDrink("Americano", 80, 130, 60);
        HotDrink hotDrink4 = new HotDrink("Americano", 80, 180, 60);
        HotDrink hotDrink5 = new HotDrink("Cappuccino", 85, 180, 85);

        DrinkVendingMachine drinkVendingMachine = new DrinkVendingMachine();
        drinkVendingMachine.addDrink(hotDrink1);
        drinkVendingMachine.addDrink(hotDrink2);
        drinkVendingMachine.addDrink(hotDrink3);
        drinkVendingMachine.addDrink(hotDrink4);
        drinkVendingMachine.addDrink(hotDrink5);

        ArrayList<HotDrink> hotDrinkArrayList = new ArrayList<>(Arrays.asList(hotDrink3,
                hotDrink4, hotDrink2, hotDrink1, hotDrink5));
        DrinkVendingMachine drinkVendingMachine2 = new DrinkVendingMachine(hotDrinkArrayList);



        System.out.println("__________________");
        System.out.println(drinkVendingMachine.getProduct("amerikano", 180,60));
        System.out.println("__________________");
        for (HotDrink hd : drinkVendingMachine.getDrinks()) {
            System.out.println(hd);
        }

        System.out.println("__________________");
        for (HotDrink hd : drinkVendingMachine2.getDrinks()) {
            System.out.println(hd);
        }

    }
}

