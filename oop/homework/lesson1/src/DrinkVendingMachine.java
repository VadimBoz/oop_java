import java.util.ArrayList;
import java.util.List;

public class DrinkVendingMachine implements VendingMachine{
    private List<HotDrink> drinkList;


    public DrinkVendingMachine(List<HotDrink> drinkList) {
        this.drinkList = drinkList;
    }

    public DrinkVendingMachine() {
        this.drinkList = new ArrayList<>();
    }

    public List<HotDrink> getDrinks() {
        return drinkList;
    }

    public void setDrinks(List<HotDrink> drinkList) {
        this.drinkList = drinkList;
    }

    @Override
    public Product getProduct(String name) {
        for (HotDrink hotdrink : drinkList) {
            if (hotdrink.getName().equals(name)) return hotdrink;
        }
        return null;
    }

    @Override
    public Product getProduct(String name, double volume) {
        for (HotDrink hotdrink: drinkList ) {
             if (hotdrink.getName().equals(name) && hotdrink.getVolume() == volume)
                 return hotdrink;
        }
        return null;
    }


    public Product getProduct(String name, double volume, int temperature) {
        for (HotDrink hotdrink: drinkList ) {
            if (hotdrink.getName().equals(name) && hotdrink.getVolume() == volume
            && hotdrink.getTemperature() == temperature)
                return hotdrink;
        }
        return null;
    }

    public void addDrink(HotDrink  hotDrink){
        this.drinkList.add(hotDrink);
    }


}
