
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StudentGroupService {
//    private StudentGroup studentGroup;

//    public void createStudentGroup(Teacher teacher, List<Student> students) {
//        this.studentGroup = new StudentGroup(teacher, students);
//    }

    public static StudentGroup createStudentGroup(EnumStream nameStream, EnumGroup nameGroup, Teacher teacher, List<Student> students) {
        List<Student> studentList = new ArrayList<>();
        for (Student item : students) {
            if (item instanceof  Student) {
                if (item.getNameStream().name().equals(nameStream.name())
                        && item.getGroupNumber().name().equals(nameGroup.name())){
                    studentList.add(item);
                }
            }
        }
//        studentGroup = new StudentGroup(nameStream, nameGroup, teacher, studentList);
        System.out.printf("создана группа %s  потока  %s из %d студентов \n", nameGroup, nameStream, studentList.size());
        return new StudentGroup(nameStream, nameGroup, teacher, studentList);
    }



    public static Student getStudentFromStreams(String firstName, String secondName, List<Student> studentList){
        Iterator<Student> iterator = studentList.iterator();
        List<Student> result = new ArrayList<>();
        while (iterator.hasNext()){
            Student student = iterator.next();
            if(student.getFirstName().equalsIgnoreCase(firstName)
               && student.getSecondName().equalsIgnoreCase(secondName)){
                result.add(student);
            }
        }
        if(result.size() == 0){
            throw new IllegalStateException(
                    String.format("Студент с именем %s и фамилией %s не найден", firstName, secondName)
            );
        }
        if(result.size() != 1){
            throw new IllegalStateException("Найдено более одного студента с указанными именем и фамилией");
        }
        return result.get(0);
    }


    public static List<Student> getSortedIDStudentGroup(EnumGroup groupName, List<Student> students){
        List<Student> resStudents = new ArrayList<>();
        for (Student currentStudent: students) {
            if(currentStudent.getGroupNumber().name().equals(groupName.name())) {
                resStudents.add(currentStudent);
            }
        }
        Collections.sort(resStudents);
        return resStudents;
    }

    public static List<Student> getSortedByFIOStudentGroup(EnumGroup groupName,  List<Student> studentList){
        List<Student> students = new ArrayList<>();
        for (Student student: studentList) {
            if(student.getGroupNumber().name().equals(groupName.name())) {
                students.add(student);
            }
        }
        students.sort(new StudentComparator());
        return students;
    }

    public static String getInfoGroup(EnumGroup groupName, List<StudentGroup> studentGroupList) {
        for (StudentGroup studentGroup: studentGroupList) {
            if(studentGroup.getNameGroup().equals(groupName.name())) {
                return studentGroup.getGroupInfo();
            }
        }
        return "такой группы нет";
    }

}
