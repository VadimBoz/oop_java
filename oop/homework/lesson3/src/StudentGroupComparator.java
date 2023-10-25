import java.util.Comparator;

public class StudentGroupComparator implements Comparator<StudentGroup> {
    @Override
    public int compare(StudentGroup o1, StudentGroup o2) {
        return Integer.compare(o1.getCountStudents(), o2.getCountStudents());
    }
}
