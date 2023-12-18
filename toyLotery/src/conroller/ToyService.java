package conroller;

import model.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class ToyService {

    private  List<Toy> toyList;
    private PriorityQueue<Toy> sweepstakes;
    int[] ranges;
    Random random = new Random();



    public ToyService(List<Toy> toyList) {
        if (toyList.size() < 3) throw new IllegalArgumentException("игрушек для розыгрыша слишком мало");
//        Collections.sort(toyList);
        this.toyList = toyList;
        recalcWeight();
        ranges = rangesWeight();
    }

    public ToyService(List<Toy> toyList, int flag) {
        this.sweepstakes = new PriorityQueue<>(toyList);

    }



    public void sweepstake(String countStr) { // добавляем в PriorityQueue игрушку соответствующую диапазону в который попало случайное число
        if (!countStr.matches("\\d+")) throw new IllegalArgumentException("Введено недопустимое число");
        int count = Integer.parseInt(countStr);
        if (count > 50) throw new IllegalArgumentException("Количество игрушек для розыгрыша слишком большое, не более 50");
        if (toyList == null) throw new IllegalArgumentException("Не введены игрушки для розыгрыша");
        sweepstakes = new PriorityQueue<>();
        for (int j = 0; j < count; j++) {
            int currentRnd = random.nextInt(0, 101);
            for (int i = 0; i < ranges.length - 1 ; i++) {
                if (currentRnd >= ranges[i]  &&  currentRnd < ranges[i+1]) {
                    sweepstakes.add(toyList.get(i));
                    break;
                }
            }
        }
    }

    private int[] rangesWeight() {  // формирование диапазонов соответствующих статистическим весам игрушек, ширина диапазона равно весу игрушки
        int[] res = new int[toyList.size()+1];
        res[0] = 0;
        for (int i = 1; i < res.length; i++) {
            res[i] = (int) (res[i - 1] + toyList.get(i - 1).getStatWeight());
        }
        res[toyList.size()] = 100;
        return res;
    }

    private void recalcWeight() {    //пересчет весов по отношению к 100%
        double sumWeight = 0;
        for (Toy item: toyList) {
            sumWeight += item.getStatWeight();
        }

        for (Toy item: toyList) {
            double tempWeight = item.getStatWeight();
            item.setStatWeight((int)(tempWeight * 100 / sumWeight));
        }
    }

    public PriorityQueue<Toy> getSweepstakes() {
        if (sweepstakes == null) return new PriorityQueue<>();
        return sweepstakes;
    }

    public void setSweepstakes(List<Toy> toyList) {
        this. sweepstakes = new PriorityQueue<>(toyList);

    }

    public void setToyList(List<Toy> toyList) {
        this.toyList = toyList;
    }

    public List<Toy> getToyList() {
        return toyList;
    }
}
