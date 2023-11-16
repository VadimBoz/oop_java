package Controller;

import model.Type;
import model.User;
import service.DataServise;
import view.UserView;

import java.util.List;

public class UserController {
    private  final DataServise servise;
    private  final UserView groupView;


    public UserController(String fileName) {
        servise = new DataServise(fileName);
        groupView = new UserView();

    }

    public  void  createStudent(String firstName, String secondName, String lastName) {
        servise.createUser(firstName, secondName, lastName, Type.STUDENT);
        servise.saveUserList();

    }

    public  void  createTeacher(String firstName, String secondName, String lastName) {
        servise.createUser(firstName, secondName, lastName, Type.TEACHER);
        servise.saveUserList();
    }

    public void printAllStudents() {
        groupView.printOnConsoleStudentList(servise.getStudetList());
    }

    public void printAllTeachers() {
        groupView.printOnConsoleStudentList(servise.getTeacherList());
    }

    public void printAllUser() {
        groupView.printOnConsoleAllUser(servise.getUserList());
    }

    public void saveUserInFile() {
        servise.saveUserList();
    }

//    public UserController getUserController() {
//        return this;
//
    public List<User> getUserList() {
        return servise.getUserList();
    }

}
