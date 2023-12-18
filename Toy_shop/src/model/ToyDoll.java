package model;

import model.enums.AgeRange;
import model.enums.County;

public class ToyDoll extends Toy {

    public ToyDoll(long toyId, String name, County madeIn, AgeRange ageRange, Double cost,
                   boolean remoteControl, int countItem) {
        super(toyId, name, madeIn, ageRange, cost, remoteControl);
    }



}
