package model;

import model.enums.AgeRange;
import model.enums.County;

public class ToyMagneticKonstruktory extends ToyKonstruktory {

    public ToyMagneticKonstruktory(long toyId, String name, County madeIn, AgeRange ageRange, Double cost,
                                   boolean remoteControl, int countItem) {
        super(toyId, name, madeIn, ageRange, cost, remoteControl, countItem);
    }


}
