import java.util.Comparator;

public class StreamGroupComarator implements Comparator<StreamStudentGroup> {


    @Override
    public int compare(StreamStudentGroup o1, StreamStudentGroup o2) {
        return Integer.compare(o1.getCountGroups(), o2.getCountGroups());
    }
}
