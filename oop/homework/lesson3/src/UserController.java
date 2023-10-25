

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class UserController {

    private final DataService dataService = new DataService();

    private final UserView userView = new UserView();

    private List<Student> studentList = new ArrayList<>();
    private List<StudentGroup> studentGroups = new ArrayList<>();
    private List<StreamStudentGroup> streamStudentGroups = new ArrayList<>();



    public void createStudent(String firstName, String secondName, String patronymic, LocalDate dateOfBirth,
                                                                EnumStream streamName, EnumGroup groupNumber) {
        studentList.add(new Student(firstName, secondName, patronymic, dateOfBirth, streamName, groupNumber));
    }

    public void createStudentGroup(EnumStream nameStream, EnumGroup nameGroup, Teacher teacher) {
        studentGroups.add(StudentGroupService.createStudentGroup(nameStream, nameGroup, teacher, studentList));
    }

    public void createStreamGroup(EnumStream nameStream) {
        streamStudentGroups.add(StreamGroupServise.createStreamGroup(nameStream, studentGroups));

    }

    public void getStudent(String firstName, String secondName){
        userView.sendOnConsoleStudent(StudentGroupService.getStudentFromStreams(firstName, secondName, studentList));
    }

    public List<Student> getSortedListStudentByIDFromGroup(EnumGroup groupName){
        return StudentGroupService.getSortedIDStudentGroup(groupName, studentList);
    }

    public List<Student> getSortedListByFIOStudentFromStudentGroup(EnumGroup groupName){
        return StudentGroupService.getSortedByFIOStudentGroup(groupName, studentList);
    }



    public void printStudentGroup(EnumStream streamName, EnumGroup groupName) {
        userView.sendOnConsoleListStudent(streamName, groupName, studentList);
    }

   public  void printGroupInfo(EnumGroup groupName) {
       System.out.println(StudentGroupService.getInfoGroup(groupName, studentGroups));
   }



    public  void printStreamList(EnumStream streamName) {
        System.out.println(StreamGroupServise.getListGroupInSteam(streamName,streamStudentGroups));

    }

   public void printListStudentsAll(List<Student> studentList) {
        userView.sendOnConsoleListStudentAll(studentList);

   }

//   public void printSortedStreamByAlphabetical

    public void printSortedStreamByCount() {
        System.out.println(StreamGroupServise.getSortedStreamsByCount(streamStudentGroups));

    }

}
