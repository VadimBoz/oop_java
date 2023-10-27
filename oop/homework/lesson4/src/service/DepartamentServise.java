package service;

import data.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DepartamentServise {

    private Department department;

    public void createDepartament(String departamentName, List<Teacher> teacherList) {
        this.department = new Department(departamentName, teacherList);
    }

    public Teacher createTeacher(String firstName, String secondName, String lastName, LocalDate dateOfBirth,
                              List<Disciplines> disciplines) {
        if (department == null) {
            department = new Department("departamentName", null);
        }
        Teacher teacher = new Teacher(firstName, secondName, lastName, dateOfBirth);
        teacher.setDisciplinesList(disciplines);
        department.addUser(teacher);
        return teacher;
    }




    public List<Teacher> getSortedTeachersFIO(){
        List<Teacher> teacherList = new ArrayList<>(department.getListUser());
        teacherList.sort(new UserComporator());
        return teacherList;

    }

    public List<Teacher> getSortedTeachersByCountDisciplines(){
        List<Teacher> teacherList = new ArrayList<>(department.getListUser());
        teacherList.sort(new TeacherCopmorator());
//        teacherList.sort(Comparator.comparingInt(Teacher::getCountDisciplines));

        return teacherList;

    }


    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


}
