
import java.util.ArrayList;
import java.util.List;

public class StudentGroup implements Iterable<Student>{
    private List<Student> students;
    private Teacher teacher;
    private int IDgroup;
    private static int count; //для вычисления ID группы
    private EnumGroup nameGroup;
    private EnumStream nameStream;

    public StudentGroup(EnumStream nameStream, EnumGroup nameGroup, Teacher teacher, List<Student> students) {
        this.students = new ArrayList<>();
        for (Student student: students) {
             if (student.getGroupNumber().name().equals(nameGroup.name()) &&
                student.getNameStream().name().equals(nameStream.name())) {
                     this.students.add(student);
             }
        }
        if (students.size() == 0) System.out.println("не добавлено ни одного студента в группу");
        this.teacher = teacher;
        this.nameGroup  = nameGroup;
        this.nameStream = nameStream;
        this.IDgroup  = ++count;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getIDGroup() {
        return IDgroup;
    }

    public int getCountStudents() {

        return students.size();
    }


    public String getNameGroup() {
        return nameGroup.name();
    }

    public EnumStream getNameStream() {
        return nameStream;
    }

    public  String getGroupInfo() {
        return  String.format("StreamName - %s, Group name %s, Id - %05d students count  - %d",
                nameStream.name(), nameGroup.name(), IDgroup, getCountStudents());
    }


    @Override
    public String toString() {
        return "Group ID = " + IDgroup +
               ", teacher = " + teacher +
                ", StreamName =  "+ nameStream +
                ", GroupName = " + nameGroup +
                " { " +
                "students = " + students +
               " }";
    }

    @Override
    public StudentGroupIterator iterator() {

        return new StudentGroupIterator(this);
    }
}
