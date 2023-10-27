package data;

import java.util.Iterator;
import java.util.List;

public class Department extends UserGroup<Teacher> implements Iterable<Teacher> {

    private String DepartmentName;
    public Department(String departmentName, List<Teacher> teacherList) {
        super(departmentName, teacherList);
    }


    @Override
    public Iterator<Teacher> iterator() {
        return new DepartamentIterator(this) ;
    }
}
