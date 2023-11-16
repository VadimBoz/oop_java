package view;

import model.StudentGroup;

import java.util.List;

public class StudentGroupsView {

    public void printOnConsoleAllStudentGroup(List<StudentGroup> studentGroups) {
        for (StudentGroup item: studentGroups) {
            System.out.println(item);
        }
    }


    public void printOnConsoleStudentGroup(StudentGroup studentGroup) {
        System.out.println(studentGroup.getStudentList());
    }
}
