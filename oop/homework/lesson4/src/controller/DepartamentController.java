package Controller;

import data.Disciplines;
import data.Teacher;
import service.DepartamentServise;
import view.DepartamentView;

import java.time.LocalDate;
import java.util.List;

public class DepartamentController {

    DepartamentServise departamentServise = new DepartamentServise();
    DepartamentView departamentView = new DepartamentView();

    public void createDepartament(String nameDepartament, List<Teacher> teacherList) {
        departamentServise.createDepartament(nameDepartament, teacherList);
    }

    public Teacher createTeacher(String firstName, String secondName, String lastName, LocalDate localDate, List<Disciplines> disciplinesList) {
        return  departamentServise.createTeacher(firstName,  secondName,  lastName, localDate, disciplinesList);
    }

   public  List<Teacher> sortedTeacherByFIO() {
        return  departamentServise.getSortedTeachersFIO();
   }

    public  List<Teacher> sortedTeacherByCountDisciplines() {
        return  departamentServise.getSortedTeachersByCountDisciplines();
    }

    public void printDepartament() {
        departamentView.printDepartament(departamentServise.getDepartment().getListUser());
    }

    public void printDepartament(List<Teacher> teacherList) {
        departamentView.printDepartament(teacherList);
    }





}
