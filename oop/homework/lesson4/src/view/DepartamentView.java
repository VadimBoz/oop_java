package view;

import data.Teacher;

import java.util.List;

public class DepartamentView {
    public void printDepartament(List<Teacher> teachers) {
        for (Teacher teacher: teachers) {
            System.out.println(teacher);
        }
    }


}
