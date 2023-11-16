import Controller.DepartamentController;
import Controller.StudentGroupController;
import data.Department;
import data.Disciplines;
import data.Teacher;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentGroupController controler = new StudentGroupController();
        controler.create("5","5", "5");
        controler.create("2","2", "2");
        controler.create("3","3", "3");
//        List<Student> studentList= List.of(new Student[]{student1, student2, student3});
//        controler.createStudentGroup(studentList);
        controler.print();
        System.out.println("Cортировка(SrBall)...");
        controler.print(controler.sortedStudentGroupBySrBall());
        System.out.println("Cортировка(FIO)...");
        controler.print(controler.sortedStudentGroupByFIO());
        System.out.println("-------------------------------------------------");

        DepartamentController departamentController = new DepartamentController();
        departamentController.createTeacher("a", "b", "c",
                LocalDate.of(1971, 3,4), List.of(Disciplines.Mathematics) );
        departamentController.createTeacher("a", "b", "c2",
                LocalDate.of(1980, 3,4), List.of(Disciplines.Mathematics, Disciplines.Combinatorics, Disciplines.Physics));
        departamentController.createTeacher("a2", "b2", "c3",
                LocalDate.of(1968, 3,4), List.of(Disciplines.Mathematics, Disciplines.Combinatorics) );

        departamentController.printDepartament();
        System.out.println("-------------------------------------------------");
        departamentController.printDepartament(departamentController.sortedTeacherByFIO());
        System.out.println("-------------------------------------------------");
        departamentController.printDepartament(departamentController.sortedTeacherByCountDisciplines());

    }
}