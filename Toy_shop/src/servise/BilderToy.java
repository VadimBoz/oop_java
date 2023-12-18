package servise;

import model.*;
import model.enums.AgeRange;
import model.enums.County;
import model.enums.KindToy;

import java.util.ArrayList;

public class BilderToy {
    private Toy toy;
    private ArrayList<Toy> toyList;

    public  BilderToy() {}


    public void createToy(KindToy kindToy, String name, County madeIn,
                               AgeRange ageRange, Double cost, boolean remoteControl, int countItem) {
        if (toyList == null) toyList = new ArrayList<>();

        switch (kindToy) {
            case ToyLego -> toyList.add(new ToyLego(getToyID(), name, madeIn, ageRange, cost, remoteControl, countItem));
            case ToyWoodKonstrukory -> toyList.add(new ToyWoodKonstrukory(getToyID(), name, madeIn, ageRange, cost, remoteControl, countItem));
            case ToyMagnetikKonstruktory -> toyList.add(new ToyMagneticKonstruktory(getToyID(), name, madeIn, ageRange, cost, remoteControl, countItem));
            case ToySoft -> toyList.add(new ToySoft(getToyID(), name, madeIn, ageRange, cost, remoteControl));
            case ToyRaillWay -> toyList.add(new ToyRaillWay(getToyID(), name, madeIn, ageRange, cost, remoteControl));
            case ToyAirPlane -> toyList.add(new ToyAirPlane(getToyID(), name, madeIn, ageRange, cost, remoteControl));
            default -> throw new IllegalArgumentException("задан несуществующий тип игрушки");
        }
    }

    public ArrayList<Toy> getToyList() {
        return toyList;
    }


    public ArrayList<Toy> getToyListByKind(KindToy kindToy) {
        ArrayList<Toy> res = new ArrayList<>();
        for (Toy item : toyList) {
            if (item.getClass().getSimpleName().equals(kindToy.name())) {
                res.add(item);
            }
        }
        if (res.size() == 0) System.out.println("Игрушек данного типа не найдено");
        return res;
    }

    public ArrayList<Toy> getToyListByBaseKind(KindToy kindToy) {
        ArrayList<Toy> res = new ArrayList<>();
        for (Toy item : toyList) {
            switch (kindToy) {
                case ToyTransport:
                    if (item instanceof ToyTransport)
                        res.add(item);
                    break;
                case ToyKonstruktory:
                    if (item instanceof ToyKonstruktory)
                        res.add(item);
                    break;
                default:
                    throw new IllegalArgumentException("задан несуществующий базовый тип игрушки");
            }
        }
        if (res.size() == 0) System.out.println("Игрушек данного типа не найдено");
        return res;
    }



    public void setToyList(ArrayList<Toy> toyList) {
        this.toyList = toyList;
    }



    private long getToyID() {
            if (toyList == null || toyList.size() == 0)
                return 1;
            else return toyList.size() + 1;
    }





}
