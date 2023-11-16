import Controller.GroupController;
import Controller.UserController;
import model.StudentGroupType;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserController userController = new UserController("UserList.ser");
        GroupController groupController  = new GroupController("UserList.ser");

        userController.createStudent("1", "1", "1");
        userController.createStudent("2", "2", "2");
        userController.createTeacher("t1", "t1", "t1");
        userController.createStudent("3", "3", "3");
        userController.createTeacher("t2", "t2", "t2");
        userController.createStudent("4", "4", "4");
        System.out.println("-------------------- Students List -----------------");
        userController.printAllStudents();
        System.out.println();
        System.out.println("----------    ------- Teacher List -------  --------");
        userController.printAllTeachers();


        System.out.println();
        System.out.println("----------------------------- HOME WORK ----------------------------------");

        groupController.createGroupStudents(List.of(1, 2), 1, StudentGroupType.IT101);
        groupController.createGroupStudents(List.of(1, 2, 3), 2, StudentGroupType.IT102);
        groupController.printAllgroups();
        System.out.println("\n--------------");
        groupController.printStudentGroups(StudentGroupType.IT101);






    }
}