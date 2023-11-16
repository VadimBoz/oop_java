package view;

import model.User;

import java.util.List;

public class UserView {

    public void printOnConsoleStudentList(List<User> user) {
        user.forEach(System.out::println);
    }

    public void printOnConsoleTeacherList(List<User> user) {
        user.forEach(System.out::println);
    }


    public void printOnConsoleAllUser(List<User> user) {
        user.forEach(System.out::println);
    }



}
