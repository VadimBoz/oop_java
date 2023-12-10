package model;

public class ToyComporatorAge implements ToyComporator<ToyItem> {

    @Override
    public int compare(ToyItem o1, ToyItem o2) {
        int age1 = o1.getEgeRange().ageStart;
        int age2 = o2.getEgeRange().ageStart;
        return Integer.compare(age1, age2);
    }
}
