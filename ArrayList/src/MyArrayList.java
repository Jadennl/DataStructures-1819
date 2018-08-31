import java.util.Collection;

/**
 * The 
 * @author Jaden Leonard
 * @version 08/31/18
 */
public class MyArrayList{
	private int size;
	private Object [] values;
	private int maxCapacity;
	

public MyArrayList() {
    maxCapacity = 8;
    size = 0;
    values = new Object[maxCapacity];
}

public MyArrayList(int capacity) {
    maxCapacity = capacity;
    size = 0;
    values = new Object[maxCapacity];
}

/* public MymyArrayList(Collection c) {
   //TODO unfinished
    maxCapacity  = c.size();
    values = c.tomyArray();
    size = c.size();
    
} */

public boolean add(Object obj) {
    //TODO finish
    return true;
}

public void add( int index, Object obj ) {
    //TODO finish
}

public boolean remove(Object obj) {
    //TODO finish
    return false;
}

public Object remove(int index) {
    //TODO finish
    return null;
}

public Object get(int index){
    if  (index < 0 || index >= size()) {
        throw new IndexOutOfBoundsException();
    }
    else {
        return values[index];
    }
}

public void set( int index, Object obj) {
    //TODO finish
}

public int indexOf(Object o) {
    for (int i = 0; i < size; i++) {
        if (values[i].equals(o)) {
            return i;
        }
    }
    return -1;
}

public int lastIndexOf(Object o) {
    for (int i = size - 1; i <= 0; i--) {
        if (values[i].equals(o)) {
            return i;
        }
    }
    return -1;
}

public boolean contains(Object obj) {
    for(int i = 0; i < size; i++) {
        if (obj == values[i]) return true;
    }
    return false;
}

/*private void checkSize(int index) {
    
}*/

public int size() {
    return size;
}

public boolean isEmpty() {
    return size <= 0;
}

public void ensureCapacity(int minCapacity) {
    //TODO add the elements
    if (maxCapacity < minCapacity) {
        Object [] rmyArray = new Object[minCapacity];
        for(int i = 0; i < values.length; i++) {
            rmyArray[i] = values[i];
        }
    }
}

/**
 * Removes all values of the ArrayList and sets the size of the list to 0.
 * 
 */
public void clear() {
    for (int i = 0; i < values.length; i++) {
        values[i] = null;
    }
    size = 0;
    }
}
