import java.util.Collection;

public class MyArrayList{
	private int size;
	private Object [] myArray;
	private int maxCapacity;
	

public MyArrayList() {
    maxCapacity = 8;
    size = 0;
    myArray = new Object[maxCapacity];
}

public MyArrayList(int capacity) {
    maxCapacity = capacity;
    size = 0;
    myArray = new Object[maxCapacity];
}

/* public MymyArrayList(Collection c) {
   //TODO unfinished
    maxCapacity  = c.size();
    myArray = c.tomyArray();
    size = c.size();
    
} */

public Object get(int index){
    if  (index < 0 || index >= size()) {
        throw new IndexOutOfBoundsException();
    }
    else {
        return myArray[index];
    }
}

public int indexOf(Object o) {
    for (int i = 0; i < size; i++) {
        if (myArray[i].equals(o)) {
            return i;
        }
    }
    return -1;
}

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
        myArray = rmyArray;
    }
}


}
