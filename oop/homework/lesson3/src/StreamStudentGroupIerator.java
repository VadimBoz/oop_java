import java.util.Iterator;
import java.util.List;

public class StreamStudentGroupIerator implements Iterator<StudentGroup>{

    private int counter;
    private final List<StudentGroup> streamStudentGroups;


    public StreamStudentGroupIerator(StreamStudentGroup streamStudentGroups) {
        this.streamStudentGroups = streamStudentGroups.getStudentGroupList();
        this.counter = 0;
    }


    @Override
    public boolean hasNext() {
        return counter < streamStudentGroups.size() ;
    }


    @Override
    public StudentGroup next() {
        if (!hasNext()){
            return null;
        }
        return streamStudentGroups.get(counter++);
    }
}
