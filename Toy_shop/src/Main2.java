import model.Toy;
import model.ToyComporatorAge;
import model.ToyComporatorCost;
import model.enums.AgeRange;
import model.enums.County;
import model.enums.KindToy;
import servise.BilderToy;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {

//        long toyId, String name, County madeIn, AgeRange ageRange, Double cost,
//        boolean remoteControl, int countItem)
        BilderToy bilderToy = new BilderToy();

        bilderToy.createToy(KindToy.ToyLego, "Lego1" , County.SPAIN, AgeRange.AgeRange_1y_3y,
                120D, false, 0);

        bilderToy.createToy(KindToy.ToyLego, "Lego2" , County.SPAIN, AgeRange.AgeRange_1y_3y,
                130D, false, 0);

        bilderToy.createToy(KindToy.ToyAirPlane, "AirPlane-Ту134" , County.RUSSIAN_FEDERATION, AgeRange.AgeRange_12y_16y,
                100D, true, 0);

        bilderToy.createToy(KindToy.ToyWoodKonstrukory, "WoodKonstrukory1" , County.RUSSIAN_FEDERATION, AgeRange.AgeRange_12y_16y,
                220D, false, 0);

        bilderToy.createToy(KindToy.ToyRaillWay, "RaillWay1" , County.RUSSIAN_FEDERATION, AgeRange.AgeRange_12y_16y,
                320D, true, 0);
        bilderToy.createToy(KindToy.ToyRaillWay, "RaillWay2" , County.CHINA, AgeRange.AgeRange_12y_16y,
                330D, false, 0);

        bilderToy.createToy(KindToy.ToyMagnetikKonstruktory, "MagnetikKonstruktor2" , County.CHINA, AgeRange.AgeRange_12y_16y,
                180D, false, 0);

        bilderToy.createToy(KindToy.ToySoft, "Soft1" , County.CHINA, AgeRange.AgeRange_12y_16y,
                180D, false, 0);




        KindToy tt = KindToy.ToyLego;
//        Collections.sort(bilderToy.getToyListByKind(KindToy.ToyAirPlane), ToyComporatorAge);
//        item.getClass().getName().equals(kindToy.name())
//        System.out.println(tt.name());
//        System.out.println("item".getClass());
//        System.out.println(Arrays.toString(new List[]{bilderToy.getToyListByKind(KindToy.ToyLego)}));
//        System.out.println(Arrays.toString(bilderToy.getToyListByBaseKind(KindToy.ToyLego).toArray()));

//        ArrayList<Toy> arrays = bilderToy.getToyList();
//        arrays.sort(new ToyComporatorCost());
//        arrays.sort(new );
//        System.out.println(arrays);



    }




}

