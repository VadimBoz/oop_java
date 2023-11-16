package model;

import java.io.Serializable;
import java.util.List;

public class StudentGroup implements Serializable {
    int groupID;
    StudentGroupType groupName;

    List<Student> studentList;
    Teacher teacher;


    public StudentGroup(int groupID, StudentGroupType groupName, List<Student> studentList, Teacher teacher) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.studentList = studentList;
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public StudentGroupType getGroupName() {
        return groupName;
    }

    public void setGroupName(StudentGroupType groupName) {
        this.groupName = groupName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "StudentGroup{" +
                "groupID=" + groupID +
                ", groupName='" + groupName + '\'' +
                ", studentscount=" + studentList.size() +
                ", teacher=" + teacher +
                '}';
    }
}
