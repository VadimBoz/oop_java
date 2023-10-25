import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StreamGroupServise {

    StreamStudentGroup streamStudentGroup;


    public StreamGroupServise(StreamStudentGroup streamStudentGroup) {

        this.streamStudentGroup = streamStudentGroup;
    }

    public static StreamStudentGroup createStreamGroup(EnumStream nameStream, List<StudentGroup> studentGroupsList) {
        List<StudentGroup> studentGroups = new ArrayList<>();
        for (StudentGroup item : studentGroupsList) {
            if (item.getNameStream().name().equals(nameStream.name())) {
                studentGroups.add(item);
            }
        }
        System.out.printf("создан поток %s из %d групп \n", nameStream.name(), studentGroups.size());
        return new StreamStudentGroup(nameStream, studentGroups);
    }

    public static List<StreamStudentGroup> getSortedStreamGroups(List<StreamStudentGroup> streamStudentGroups) {
        List<StreamStudentGroup> streamGroupList = new ArrayList<>(streamStudentGroups);
        Collections.sort(streamGroupList, new StreamGroupComarator());
        return streamGroupList;
    }


    public String getInfoStream() {
        return streamStudentGroup.toString();
    }

    public static List<String> getListGroupInSteam(EnumStream streamName, List<StreamStudentGroup> streamStudentGroups) {
        List<String> resStr = new ArrayList<>();
        for (StreamStudentGroup currentStream : streamStudentGroups) {
            if (currentStream.getNameStreameGoup().equals(streamName.name())) {
                for (StudentGroup studentGroup : currentStream) {
                    resStr.add(studentGroup.getNameGroup());
                }
            }
        }
        return resStr;
    }

    public static List<String> getSortedStreamsByCount(List<StreamStudentGroup> streamStudentGroups) {
        List<StreamStudentGroup> resStreamStudentGroups = new ArrayList<>(streamStudentGroups);
        resStreamStudentGroups.sort(new StreamGroupComarator());
        List<String> enumStreams  = new ArrayList<>();
        for (StreamStudentGroup item: resStreamStudentGroups) {
            enumStreams.add(item.getNameStreameGoup() + " count " + item.getCountGroups());
        }
        return enumStreams;
    }


}
