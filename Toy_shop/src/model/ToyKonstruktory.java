package model;

import model.enums.AgeRange;
import model.enums.County;

public abstract class ToyKonstruktory extends Toy {
    int countItem;

    public ToyKonstruktory(long toyId, String name, County madeIn, AgeRange ageRange, Double cost,
                        boolean remoteControl, int countItem) {
        super(toyId, name, madeIn, ageRange, cost, remoteControl);
        this.countItem = countItem;

    }

}
