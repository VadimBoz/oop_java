package data;

import java.util.Iterator;
import java.util.List;

public class DepartamentIterator extends UserGroupIterator<Teacher> implements Iterator<Teacher> {

//    private int counter;
    private List<Teacher> teacherList;

    public DepartamentIterator(Department department) {
        super(department);
        this.teacherList = department.getListUser();
    }



}
