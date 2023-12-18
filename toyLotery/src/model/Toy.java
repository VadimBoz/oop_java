package model;

public class Toy implements Comparable<Toy> {
    int toyId;
    double statWeight;
    String toyName;


    public Toy(int toyId, double statWeight, String toyName) {
        this.toyId = toyId;
        this.statWeight = statWeight;
        this.toyName = toyName;
    }


    public int getToyId() {
        return toyId;
    }

    public void setToyId(int toyId) {
        this.toyId = toyId;
    }

    public double getStatWeight() {
        return statWeight;
    }

    public void setStatWeight(double statWeight) {
        this.statWeight = statWeight;
    }

    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    @Override
    public String toString() {
        return "Toy {" +
                "toyId=" + toyId +
                ", statWeight=" + statWeight +
                ", toyName='" + toyName + '\'' +
                "}";
    }

    public String toCrvString() {
        return toyId + ";" + statWeight + ";" + toyName;
    }


    @Override
    public int compareTo(Toy toy) {
        double res = statWeight - toy.statWeight;
        if (res > 0) return 1;
        else if (res < 0) return -1;
        else return 0;
    }
}
