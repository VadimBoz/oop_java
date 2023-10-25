


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataService {

    private List<Student> users;

    public DataService() {
        this.users = new ArrayList<>();
    }

    public List<Student> getAll(){
        return  this.users;
    }

//    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth, EnumStream streamNumber, EnumGroup groupNumber) {
//        Long countMaxId = 0L;
//        for (User user: this.users){
//            if(user instanceof Student){
//                if (((Student) user).getStudentId() > countMaxId){
//                    countMaxId = ((Student) user).getStudentId();
//                }
//            }
//        }
//
//        countMaxId++;
//
//        this.users.add(new Student(firstName, secondName, patronymic, dateOfBirth, countMaxId, streamNumber, groupNumber));
//    }
}
