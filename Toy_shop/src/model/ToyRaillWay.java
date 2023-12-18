package model;

import model.enums.AgeRange;
import model.enums.County;

public class ToyRaillWay extends ToyTransport {

    public ToyRaillWay(long toyId, String name, County madeIn, AgeRange ageRange, Double cost,
                       boolean remoteControl) {
        super(toyId, name, madeIn, ageRange, cost, remoteControl);

    }
}
