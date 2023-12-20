package view;

import model.Toy;

import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ToyView {


    Scanner scanner = new Scanner(System.in);


    public void startMenu() {
        System.out.println();
        System.out.println("---------  Программа розыгрыша игрушек в магазине   ---------------");
        System.out.println();
        System.out.println("""  
                     1. Добавить игрушки для розыгрыша (3 и более)...\s
                     2. Провести розыгрыш...\s
                     3. Вручить призовую игрушку покупателю\s
                     4. Записать результаты розыгрыша в файл\s
                     5. Загрузить результаты розыгрыша из файла\s
                     6. Выйти из программы
                     
                     Введите пункт меню >
                """);
    }


    public void addToyMenu() {
        System.out.println();
        System.out.println("""  
                     1. Добавить игрушку (от 3 шт.)\s
                     2. Завершить добавление и вернуться в главное меню...\s
                """);
    }

    public void sweepstakes() {
        System.out.println();
        System.out.println("""  
                     1. Ввести количество требуемых призов\s
                     2. Вернуться в главное меню...\s
                """);
    }


    public void printToConsoleToyList(PriorityQueue<Toy> toyList) {
        System.out.println("__________________________________");
        for (Toy toy : toyList) {
            System.out.println(toy);
        }
        System.out.println("__________________________________");
    }

    public void printToConsoleToyList(List<Toy> toyList) {
        System.out.println("__________________________________");
        for (Toy item : toyList) {
            System.out.println(item);
        }
        System.out.println("__________________________________");
    }

}
