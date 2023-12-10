package model;

import javax.naming.Name;
import java.util.ArrayList;
import java.util.List;

public class Toys extends Toy {
    List<Toy> listToys;
    long lastToyID;
    Brand rb;


    void addToy(Toy toy) {
        if (listToys == null) {
            listToys = new ArrayList<>();
            lastToyID = 1L;
            toy.setToyId(lastToyID);
        } else {
            toy.setToyId(findLastToyID());
            listToys.add(toy);
        }
    }

    int findLastToyID() {
        return listToys.size();
    }

    public List<Toy> getListToys() {
        return listToys;
    }

    public void setListToys(List<Toy> listToys) {
        this.listToys = listToys;
    }



}
