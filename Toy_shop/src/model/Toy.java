package model;

import model.enums.AgeRange;
import model.enums.County;

public  abstract class Toy implements ToyItem, Comparable<Toy> {
    private long toyId;
    private String name;
    private AgeRange ageRange;
    private Double cost;
    boolean remoteControl;
    County madeIn;
    String description = "*******";
    double weight;    //   (вес в % от 100)
    static int amount;


    public Toy() {

    }
    public Toy(long toyId, String name, AgeRange ageRange, Double cost) {
        this(toyId, name, County.DEFAULT, ageRange, cost, false);
    }


    public Toy(long toyId, String name, County madeIn, AgeRange ageRange, Double cost) {
        this(toyId, name, madeIn, ageRange, cost, false);
    }


    public Toy(long toyId, String name, County madeIn, AgeRange ageRange, Double cost, boolean remoteControl) {
        this.name = name;
        this.ageRange = ageRange;
        this.cost = cost;
        this.toyId = toyId;
        this.remoteControl = remoteControl;
        this.madeIn = madeIn;
//        this.description = "";
    }






    @Override
    public long getToyId() {
        return toyId;
    }

    @Override
    public void setToyId(long id) {
        this.toyId = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public AgeRange getEgeRange() {
        return ageRange;
    }

    @Override
    public void setEgeRange(AgeRange ageRange) {
        this.ageRange = ageRange;
    }

    @Override
    public Double getCost() {
        return cost;
    }

    @Override
    public void setCost(Double cost) {
        this.cost = cost;
    }


    @Override
    public boolean isRemoteControl() {
        return remoteControl;
    }

    @Override
    public void setRemoteControl(boolean remoteControl) {
        this.remoteControl = remoteControl;
    }

    @Override
    public String getMadeIn() {
        return madeIn.getCountry();
    }

    @Override
    public void setMadeIn(County madeIn) {
        this.madeIn = madeIn;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public int compareTo(Toy o) {

        return Long.compare(this.toyId, o.toyId);
    }





    @Override
    public String toString() {
        return
                " toyId = " + toyId +
                "; name = " + name +
                "; ageRange = " + ageRange.getAgeRane()  +
                "; cost = " + cost +
                "; remoteControl = " + remoteControl +
                "; madeIn = " + madeIn +
                "; description = " + description + "\n";
    }
}
