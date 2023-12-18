package model;

import java.util.ArrayList;
import java.util.List;

public class ToySet {
    int count;
    private List<Toy> toyList;

    public ToySet(List<Toy> toyList) {
        this.toyList = toyList;
    }

    public ToySet() {
    }

    public ToySet addToy(Toy toy) {
        if (toyList == null || toyList.size() == 0) {
            toyList = new ArrayList<>();
            count++;
            toyList.add(toy);
        } else {
            toyList.add(toy);
            count++;
        }
        return this;
    }


    public ToySet addToy(String str) {

        String[] strArray = str.trim().split(" +");
        if (strArray.length != 2)
            throw new IllegalArgumentException("В строке должно быть два аргумента через пробел, название игрушки и статистический вес");
        String nameToy = strArray[0];
        if (!strArray[1].matches("\\d*[.,]?\\d*"))
            throw new IllegalArgumentException("Вторым аргументом должно быть число");
        double weightStat = Double.parseDouble(strArray[1]);
        return addToy(new Toy(count, weightStat, nameToy));
    }

    public List<Toy> getToyList() {
        if (toyList == null || toyList.size() < 3)
            throw new IllegalArgumentException("Игрушек менее 3, добавьте еще игрушек");
        return toyList;
    }

    public void setToyList(List<Toy> toyList) {
        this.toyList = toyList;
    }

    public int getCount() {
        return count;
    }


}
