package data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserGroup<T extends User> implements Iterable<T> {

    private int count;
    private List<T> list;
    private String groupName;

    public UserGroup(String groupName, List<T> list) {
        this.list = list;
        this.groupName = groupName;
    }

    public void addUser(T user) {
        if (list == null) list = new ArrayList<>();
        list.add(user);
    }

    public List<T> getListUser() {
        return list;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

//    public List<T>  getList(){
//        return this.list;
//    }


    public Iterator<T> iterator() {

        return new UserGroupIterator<T>(this);
    }
}
