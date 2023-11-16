package service;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentGroupService {

    List<StudentGroup> studentGroups;
    private List<User> userList;
    private String fileName;

    public StudentGroupService(String fileName) {
        this.fileName = fileName;
//        readUsersFromFile(fileName);
        this.studentGroups = new ArrayList<>();
    }

    public void createStudentGroup(List<Integer> studentIDList,
                                   int teacherID, StudentGroupType studentGroupName) {
        List<Student> studentList = new ArrayList<>();
        int groupID = getGroupID();
        readUsersFromFile(fileName);
        if (userList == null || userList.size() ==0)  throw new RuntimeException("Нет данных в списке пользователей");
        for (Integer studentID : studentIDList ) {
            for (User user : userList) {
                if (user instanceof Student && ((Student) user).getStudentId() == studentID) {
                    studentList.add((Student) user);
                    break;
                }
            }
        }

        Teacher teacher = null;
        for (User user : userList) {
            if (user instanceof Teacher && ((Teacher) user).getTeacherId() == teacherID) {
                teacher = (Teacher) user;
                break;
            }
        }

        if (teacher == null) {
            throw new RuntimeException("не найден ID учителя");
        }
        studentGroups.add(new StudentGroup(groupID, studentGroupName, studentList, teacher));
    }


    public List<StudentGroup> getStudentGroups() {

        return studentGroups;
    }


    public StudentGroup getStudentGroup(StudentGroupType studentGroupName) {
        for (StudentGroup studentGroup : studentGroups) {
            if (studentGroup.getGroupName().equals(studentGroupName)) {
                return studentGroup;
            }
        }
        return null;
    }



    private int getGroupID() {
        if (studentGroups != null) {
         return studentGroups.size() +1;
        }
        return 1;
    }


    public void readUsersFromFile(String fileName) {
        try (FileInputStream inputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)){
            DataService ds = (DataService) objectInputStream.readObject();
            userList = ds.getUserList();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
