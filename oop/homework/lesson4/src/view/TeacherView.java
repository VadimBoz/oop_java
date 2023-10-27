package view;

import data.Teacher;

import java.util.List;

public class TeacherView implements UserView<Teacher> {

    public void sendOnConsoleTeacherInfo(Teacher teacher) {
        System.out.println(teacher.getDisciplinesList());

    }
    @Override
    public void sendOnconsole(List<Teacher> list) {
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }
    }
}
