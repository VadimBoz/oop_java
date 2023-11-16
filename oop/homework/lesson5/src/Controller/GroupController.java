package Controller;

import model.StudentGroup;
import model.StudentGroupType;
import model.User;
import service.StudentGroupService;
import view.StudentGroupsView;

import java.util.List;

public class GroupController {

    private final StudentGroupService studentGroupServise;
    private final StudentGroupsView studentGroupsView;



    public GroupController(String filename) {
        studentGroupServise = new StudentGroupService(filename);
        studentGroupsView  = new StudentGroupsView();

    }

    public  void  createGroupStudents(List<Integer> studentIDList,
                                      int teacherID, StudentGroupType studentGroupName) {
      studentGroupServise.createStudentGroup( studentIDList, teacherID, studentGroupName);
    }

    public void printAllgroups() {
        studentGroupsView.printOnConsoleAllStudentGroup(studentGroupServise.getStudentGroups());
    }

    public void printStudentGroups(StudentGroupType studentGroupName) {
        StudentGroup sg = studentGroupServise.getStudentGroup(studentGroupName);
        studentGroupsView.printOnConsoleStudentGroup(sg);
    }

}


