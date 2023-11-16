package service;

import model.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataService implements Serializable {
    private List<User> userList;
    private String fileName;

    public DataService(String fileName) {

        this.userList = new ArrayList<>();
        this.fileName = fileName;
    }

    public void createUser(String firstName, String secondName, String lastName, Type type) {
        if (type  == Type.STUDENT ) {
            userList.add(new Student(firstName, secondName, lastName, getFreeID(type)));
        } else if (type == Type.TEACHER) {
            userList.add(new Teacher(firstName, secondName, lastName, getFreeID(type)));
        }
        saveUserList();
    }

    private int getFreeID(Type type) {

        for (int i = userList.size() - 1; i >= 0 ; i--) {
            User user = userList.get(i);
            if (user instanceof Student && type == Type.STUDENT) {
                return  ((Student) user).getStudentId() + 1;
            } else if (user instanceof Teacher && type == Type.TEACHER) {
                return  ((Teacher) user).getTeacherId() + 1;
            }
        }
        return 1;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<User> getStudetList() {
        return userList.stream().filter(u -> u instanceof Student).collect(Collectors.toList());
    }

    public List<User> getTeacherList() {
        return userList.stream().filter(u -> u instanceof Teacher).collect(Collectors.toList());
    }

    private void saveUserList()  {
        try (FileOutputStream outputStream = new FileOutputStream(fileName);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {

            objectOutputStream.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
