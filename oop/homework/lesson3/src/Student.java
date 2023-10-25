
import java.time.LocalDate;

public class Student extends User implements Comparable<Student>{
    private int studentId;
    private EnumGroup groupNumber;
    private EnumStream nameStream;
    private static int count;

//    public Student(Long studentId, String firstName, String secondName, String patronymic, LocalDate dateOfBirth,
//                   EnumStream nameStream, EnumGroup groupNumber) {
//        super(firstName, secondName, patronymic, dateOfBirth);
//        this.studentId = studentId;
//        this.groupNumber = groupNumber;
//        this.nameStream = nameStream;
//    }

    public Student(String firstName, String secondName, String patronymic, LocalDate dateOfBirth,
                   EnumStream nameStream, EnumGroup groupNumber) {
        super(firstName, secondName, patronymic, dateOfBirth);
        this.studentId = ++count;
        this.groupNumber = groupNumber;
        this.nameStream = nameStream;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


    public EnumGroup getGroupNumber() {
        return groupNumber;
    }

    public EnumStream getNameStream() {
        return nameStream;
    }

    @Override
    public String toString() {
        return "Student {" +
                "Id = " + studentId  +
                " Stream = " + this.nameStream +
                " Group = " +  this.groupNumber +
                ", firstName = " + super.getFirstName()  +
                ", secondName = " + super.getSecondName()  +
                ", patronymic = " + super.getPatronymic()  +
                ", dateOfBirth = " + super.getDateOfBirth() + '}';
    }

    @Override
    public int compareTo(Student o) {
        return Long.compare(this.studentId, o.studentId);
    }
}
