package view;

import model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;

public class Menu  implements MenuI{

    @Override
    public void startMainMenu() {
        System.out.println("---------------------START-----------------------");
        System.out.println("Выберете пункт меню:");
        System.out.println("1. Вывести список файлов в базе данных");
        System.out.println("2. Добавить нового пользователя");
        System.out.println("3. Вывести данные из файла о пользователе");
        System.out.println("4. Выход");
    }

    @Override
    public String addUserMenu() throws IOException {
        System.out.println("Введите строку включающую данные о пользователе через пробел \n " +
                "Фамилия, Имя, Отчество, Дата рождения (дд.мм.гггг), телефон (8-ххх-ххх-хх-хх),  \n" +
                "пол (м или ж) \n> ");
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String res = bufferRead.readLine();
        return res;
    }

    @Override
    public String toContinue() throws IOException {
        System.out.println("Для продолжения нажмите Enter");
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String res = null;
        res = bufferRead.readLine();
//        bufferRead.close();
        return res;
    }


    public String readUserFromFile() throws IOException {
        System.out.println("Введите фамилию пользователя > ");
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String res = null;
        res = bufferRead.readLine();
        return res;
    }

}
