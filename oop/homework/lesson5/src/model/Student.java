package model;

import java.io.Serializable;

public class Student extends User implements Serializable {
    private int studentId;

    public Student() {
        super();
        this.studentId = 0;
    }
    public Student(String firstName, String secondName, String lastName, int studentId) {
        super(firstName, secondName, lastName);
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student {" +
                "studentId= '" + studentId  + '\'' +
                ", firstName= '" + super.getFirstName() + '\'' +
                ", secondName= '" + super.getSecondName() + '\'' +
                ", lastName= '" + super.getLastName() + '\'' +
                " }";
    }
}
