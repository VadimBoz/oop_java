import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        UserController controler = new UserController();

        Teacher teacher1 = new Teacher("12", "12", "12", LocalDate.of(1970, 1,18));

        controler.createStudent("z","5", "5", LocalDate.of(1980, 1,18), EnumStream.IT01, EnumGroup.GROUP101);
        controler.createStudent("a","2", "2", LocalDate.of(1980, 4,15), EnumStream.IT01, EnumGroup.GROUP101);
        controler.createStudent("f","3", "3", LocalDate.of(1980, 12,10), EnumStream.IT01, EnumGroup.GROUP101 );

        controler.createStudent("z1","5", "5", LocalDate.of(1980, 1,18), EnumStream.IT01, EnumGroup.GROUP102);
        controler.createStudent("a1","2", "2", LocalDate.of(1980, 4,15), EnumStream.IT01, EnumGroup.GROUP102);
        controler.createStudent("f1","3", "3", LocalDate.of(1980, 12,10), EnumStream.IT01, EnumGroup.GROUP102 );

        controler.createStudent("z2","5", "5", LocalDate.of(1980, 1,18), EnumStream.IT02, EnumGroup.GROUP103);
        controler.createStudent("a2","2", "2", LocalDate.of(1980, 4,15), EnumStream.IT02, EnumGroup.GROUP103);
        controler.createStudent("f2","3", "3", LocalDate.of(1980, 12,10), EnumStream.IT02, EnumGroup.GROUP103 );

        controler.createStudent("z3","5", "5", LocalDate.of(1980, 1,18), EnumStream.IT02, EnumGroup.GROUP104);
        controler.createStudent("a3","2", "2", LocalDate.of(1980, 4,15), EnumStream.IT02, EnumGroup.GROUP104);
        controler.createStudent("f3","3", "3", LocalDate.of(1980, 12,10), EnumStream.IT02, EnumGroup.GROUP104 );

        controler.createStudent("f4","3", "3", LocalDate.of(1980, 12,10), EnumStream.IT03, EnumGroup.GROUP105 );
        controler.createStudent("f5","3", "3", LocalDate.of(1980, 12,10), EnumStream.IT02, EnumGroup.GROUP106 );
        // -----------------------------------------------------------------

        controler.createStudentGroup(EnumStream.IT01, EnumGroup.GROUP101, teacher1);
        controler.createStudentGroup(EnumStream.IT01, EnumGroup.GROUP102, teacher1);

        controler.createStudentGroup(EnumStream.IT02, EnumGroup.GROUP103, teacher1);
        controler.createStudentGroup(EnumStream.IT02, EnumGroup.GROUP104, teacher1);
        controler.createStudentGroup(EnumStream.IT03, EnumGroup.GROUP105, teacher1);
        controler.createStudentGroup(EnumStream.IT02, EnumGroup.GROUP106, teacher1);


        controler.createStreamGroup(EnumStream.IT01);
        controler.createStreamGroup(EnumStream.IT02);
        controler.createStreamGroup(EnumStream.IT03);
        System.out.println("____1_______");
        controler.printStudentGroup(EnumStream.IT01, EnumGroup.GROUP101);
        System.out.println("____2_______");
        controler.printStreamList(EnumStream.IT01);
        System.out.println("____3_______");
        controler.getStudent("z2", "5");
        System.out.println("____4_______");
        controler.printGroupInfo(EnumGroup.GROUP102);
        System.out.println("____5_______");
        controler.printListStudentsAll(controler.getSortedListByFIOStudentFromStudentGroup(EnumGroup.GROUP102));
        System.out.println("____6_______");
        controler.printListStudentsAll(controler.getSortedListStudentByIDFromGroup(EnumGroup.GROUP102));
        System.out.println("____7_______");
        controler.printSortedStreamByCount();
        System.out.println("____8_______");
    }
}