
import java.util.List;
import java.util.logging.Logger;

public class UserView {

    Logger logger = Logger.getLogger(UserView.class.getName());

    public void sendOnConsole(List<User> userList){
        for(User user: userList){
            logger.info(user.toString());
        }
    }

    public void sendOnConsoleStudent (Student student) {
        logger.info(student.toString());
    }

    public void sendOnConsoleUserGroup(StudentGroup studentGroup){
        logger.info(studentGroup.toString());
    }

    public void sendOnConsoleStudentGroupInfo(StudentGroup studentGroup) {
        System.out.println(studentGroup.getGroupInfo());
    }

    public void sendOnConsoleListStudent(EnumStream enumStream, EnumGroup enumGroup, List<Student> students){
        for (Student item : students) {
            if (item.getNameStream().name().equals(enumStream.name()) &&
                item.getGroupNumber().name().equals(enumGroup.name()))
            System.out.println(item);
        }
//        logger.info(students.toString());
    }

    public void sendOnConsoleListStudentAll(List<Student> students){
        for (Student item : students) {
                System.out.println(item);
        }
//        logger.info(students.toString());
    }




}
