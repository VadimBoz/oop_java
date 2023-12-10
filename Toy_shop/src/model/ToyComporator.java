package model;

import java.util.Comparator;

public interface ToyComporator<T extends ToyItem> extends Comparator<T> {
    public int compare(T o1, T o2);
}


