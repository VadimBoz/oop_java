import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StreamStudentGroup implements Iterable<StudentGroup> {
    private List<StudentGroup> studentGroupList;
    private EnumStream streamName;
    private int IdSteameGroup;

    private static int countStreams;

    public StreamStudentGroup(EnumStream streamName, List<StudentGroup> studentGroupList) {
        this.studentGroupList = studentGroupList;
        this.IdSteameGroup  = ++countStreams;
        this.streamName  = streamName;
    }

    public void addGroupToStream(StudentGroup studentGroup) {
        studentGroupList.add(studentGroup);
    }

    public String getNameStreameGoup() {
        return streamName.name();
    }

    public int getIdSteameGroup() {
        return IdSteameGroup;
    }

    public List<StudentGroup> getStudentGroupList() {
        return studentGroupList;
    }

    public int getCountGroups(){
        return studentGroupList.size();
    }

    @Override
    public String toString() {
        return "StreamStudentGroup{" +
                ", IdSteameGroup=" + IdSteameGroup +
                ", nameStreameGoup='" + streamName.name() + '\'' +
                "studentGroupList=" + studentGroupList +
                '}';
    }

    @Override
    public StreamStudentGroupIerator iterator() {

        return new StreamStudentGroupIerator(this);
    }
}
