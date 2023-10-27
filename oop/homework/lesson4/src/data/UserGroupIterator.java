package data;

import java.util.Iterator;
import java.util.List;

public class UserGroupIterator<T extends User> implements Iterator<T> {
    private int counter;
    private List<T> list;

    public UserGroupIterator(UserGroup<T> group) {
        this.list = group.getListUser();
        counter = 0;
    }

    @Override
    public boolean hasNext() {
        return counter < list.size();
    }

    @Override
    public T next() {
        if(!hasNext())
            return null;
        return list.get(counter++);
    }

    @Override
    public void remove() {
        list.remove(counter);
    }
}


