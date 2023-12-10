package model;

import java.util.Comparator;

public class ToyComporatorCost implements ToyComporator<ToyItem> {

    @Override
    public int compare(ToyItem o1, ToyItem o2) {
        return o1.getCost().compareTo(o2.getCost());
    }

}

