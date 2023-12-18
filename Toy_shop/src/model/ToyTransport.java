package model;

import model.enums.AgeRange;
import model.enums.County;

public abstract class ToyTransport extends Toy {

    public ToyTransport(long toyId, String name, County madeIn, AgeRange ageRange, Double cost,
                        boolean remoteControl) {
        super(toyId, name, madeIn, ageRange, cost, remoteControl);

    }

}
