package model;

import model.enums.AgeRange;
import model.enums.County;

public class ToyConstructors extends Toy {

    int countItem;

    public ToyConstructors(long toyId, String name, County madeIn, AgeRange ageRange, Double cost,
                           boolean remoteControl, int countItem) {
        super(toyId, name, madeIn, ageRange, cost, remoteControl);
        this.countItem = countItem;
    }


}
