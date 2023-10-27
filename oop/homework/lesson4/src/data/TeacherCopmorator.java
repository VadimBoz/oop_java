package data;

import java.util.Comparator;

public class TeacherCopmorator implements Comparator<Teacher> {

    @Override
    public int compare(Teacher o1, Teacher o2) {
        return Integer.compare(o1.getCountDisciplines(), o2.getCountDisciplines());
    }

}
