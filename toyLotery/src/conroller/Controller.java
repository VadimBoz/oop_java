package conroller;

import model.ToySet;
import view.ReadWriteToySetFile;
import view.ToyView;

import java.util.Objects;
import java.util.Scanner;

public class Controller {

    ToyView toyView = new ToyView();
    ReadWriteToySetFile rwToySet = new ReadWriteToySetFile();
    ToySet toySet = new ToySet();
    ToyService toyService;





    String key = "";
    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (!Objects.equals(key, "6")) {
               toyView.startMenu();
               key =  scanner.nextLine().trim();
               switch (key) {
                   case "1":
                       addToy();
                       break;
                   case "2":
                       sweepstakesDo();
                       break;
                   case "3":
                       toPresentAward();
                       break;
                   case "4":
                       try {
                           rwToySet.writeToySetToFile(toyService.getSweepstakes());
                       } catch (Exception ex) {
                           System.out.println(ex.getMessage());
                       }
                       break;
                   case "5":
                       try {
                           toyService  = new ToyService(rwToySet.readToysFromFile(), 1);
                           toyView.printToConsoleToyList(toyService.getSweepstakes());

                       } catch (Exception e) {
                           System.out.println(e.getMessage());
                       }
                       break;
                   default:
                       System.out.println("Такой команды нет\n");
                       break;

               }
        }

    }


    private void addToy() {
        Scanner scanner1 = new Scanner(System.in);
        int flag1 = 0;
        while ( flag1 != 1) {
            toyView.addToyMenu();
            System.out.println("Выберете пункт меню: ");
            String key1 = scanner1.nextLine();
            switch (key1) {
                case "1":
                    System.out.println("Ведите название игрушки и статистический вес через пробел ");
                    try {
                        toySet.addToy(scanner1.nextLine());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Всего добавлено игрушек " + toySet.getCount());
                    break;
                case "2":
                    flag1 = 1;
                    break;
                default:
                    System.out.println("Такой команды нет\n");
                    break;
            }
        }

    }

    private void sweepstakesDo() {
        Scanner scanner2 = new Scanner(System.in);
        int flag2 = 0;
        while ( flag2 != 1) {
            toyView.sweepstakes();
            System.out.println("Выберете пункт меню: ");
            String key1 = scanner2.nextLine();
            switch (key1) {
                case "1":
                    System.out.println("Введите количество игрушек для розыгрыша");
                    String count = scanner2.nextLine();

                    try {
//                        if (toyService == null) {
                            toyService =  new ToyService(toySet.getToyList());
//                        } else toyService.setToyList(toySet.getToyList());

                        toyService.sweepstake(count);
                        System.out.println("Случайный список призовых игрушек сформирован");
                        toyView.printToConsoleToyList(toyService.getSweepstakes());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case "2":
                    flag2 = 1;
                    break;
                default:
                    System.out.println("Такой команды нет\n");
                    break;
            }
        }

    }

    public void  toPresentAward() {
        System.out.println("Игрушка вручена покупателю ");
        System.out.println(toyService.getSweepstakes().poll());
        System.out.println("В призовом фонде осталось игрушек " + toyService.getSweepstakes().size());
    }


}
