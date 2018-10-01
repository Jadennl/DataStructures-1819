import java.util.Collection;

/**
 * This is my version of the ArrayList class. This was created so I would have a
 * better understanding of how an ArrayList works.
 *
 * @author Jaden Leonard
 * @version 08/31/18
 * @param <E> element specified for the entire scope of the ArrayList.
 */
public class MyArrayList<E> {
    private int size;
    private Object[] values;
    private int maxCapacity;
    
    /**
     *Standard constructor that builds an empty ArrayList with an initial
     *capacity of 8.
     */
    public MyArrayList() {
        maxCapacity = 8;
        size = 0;
        values = new Object[maxCapacity];
    }
    
    /**
     * Creates an ArrayList that builds an empty ArrayList with an initial
     * capacity defined in the parameter.
     * @param capacity The initial capacity of the array.
     */
    public MyArrayList( int capacity ) {
        maxCapacity = capacity;
        size = 0;
        values = new Object[maxCapacity];
    }
    
    /**
     * Creates an ArrayList that imports objects from the collection defined
     * in the parameter.
     * @param c The collection to be imported to the ArrayList.
     */
    public MyArrayList( Collection<E> c ) {
        this( c.size() );
        addAll( c );
    }
    
    /**
     * Adds an element to the ArrayList.
     * @param obj The element to be added to the ArrayList.
     *
     * @return boolean if the element is successfully added.
     */
    public boolean add( E obj ) {
        size++;
        if ( size > maxCapacity ) {  ensureCapacity(size * 2 ); }
        values[size - 1] = obj;
        return true;
    }
    
    /**
     * Adds an object to the ArrayList at a specified index and moves the
     * previous value to the next slot.
     * @param index The index where the object is added.
     * @param obj The element to be added to the ArrayList.
     * @throws IndexOutOfBoundsException if the index is not inside the
     * current list.
     */
    public void add( int index, E obj ) {
        if ( index > size || index < 0 ) {
            throw new IndexOutOfBoundsException();
        }
        if ( index == size ) {
            add( obj );
        }
        else {
            size++;
            if ( size > maxCapacity ) {
                ensureCapacity(size * 2 );
            }
            for ( int i = size - 2; i >= index; i-- ) {
                values[i + 1]  = values[i];
            }
            values[index] = obj;
        }
    }
    
    /**
     * Adds all items in the given collection to the ArrayList.
     * @param c Collection to be added.
     */
    public void addAll( Collection<E> c ) {
        ensureCapacity(c.size());
        for ( E o : c ) {
            add( o );
        }
    }
    
    /**
     * Removes the specified element from the ArrayList.
     * @param obj element to be removed.
     *
     * @return boolean whether the object was successfully removed.
     */
    public boolean remove( E obj ) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals( obj )) {
                remove( i );
                return true;
            }
        }
        return false;
    }
    
    /**
     * Removes the element at the specified index.
     * @param index the index of the element to be removed.
     *
     * @return the element that was removed.
     */
    public E remove( int index ) {
        if ( index >= size || index < 0 ) {
            throw new IndexOutOfBoundsException();
        }
        E removed = (E) values[index];
        if (index == size - 1 ) {
            values[size - 1] = null;
            size--;
            return removed;
        }
        else {
            for (int i = index; i < size - 1; i++ ) {
                values[i] = values[i + 1];
            }
            size--;
            return removed;
        }
    }
    
    /**
     * Gets the element contained in the given index.
     * @param index the index in which an element is contained in.
     *
     * @return the element inside the given index.
     * @throws IndexOutOfBoundsException if the given index is greater than
     * the size or less than 0.
     */
    public E get( int index ) {
        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
        else {
            E get = (E) values[index];
            return get;
        }
    }
    
    /**
     * Sets the given index to the specified element.
     * @param index the index to be replaced.
     * @param obj the element to be set to the index.
     * @throws IndexOutOfBoundsException if the given index is greater than
     * @return the element previously at the specified index.
     * the size or less than 0.
     */
    public E set( int index, E obj ) {
        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
        E old = (E) values[index];
        values[index] = obj;
        return old;
    }
    
    /**
     * Looks for the given element starting at the begining of the ArrayList.
     * @param o the element to look for.
     *
     * @return integer equal to the location of the element. returns -1 if
     * the element is not present.
     */
    public int indexOf( E o ) {
        for ( int i = 0; i < size; i++ ) {
            if ( values[i].equals( o ) ) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Looks for the given element starting at the end of the ArrayList.
     * @param o the element to look for.
     *
     * @return integer equal to the location of the element. returns -1 if
     * the element is not present.
     */
    public int lastIndexOf( E o ) {
        for ( int i = size - 1; i >= 0; i-- ) {
            if ( values[i].equals( o ) ) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Checks whether the ArrayList contains the given object.
     *
     * @param obj Element to check is inside the list.
     *
     * @return boolean equal to whether the object is contained in the
     * ArrayList.
     */
    public boolean contains( E obj ) {
        for ( int i = 0; i < size; i++ ) {
            if ( obj == values[i] ) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * This method returns the current size of the ArrayList.
     *
     * @return size The size of the ArrayList
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns whether the current array is empty or not.
     *
     * @return Returns true if the size of the array is 0.
     */
    public boolean isEmpty() {
        return size <= 0;
    }

    /**
     * returns the Arraylist in a "[value1, value2,... valueN] format.
     * @return string format of ArrayList
     */
    public String toString() {
        if ( size == 0 ) {
            return "[]";
        }
        StringBuilder s = new StringBuilder("]");
        for ( int i = 0; i < size - 1; i++ ) {
            s.insert( s.length( ) - 1, values[i] + ", "  );
        }
        s.insert(s.length() - 1, values[size - 1]);
        s.insert(0, "[");
        return s.toString();
    }

    /**
     * Ensures the background array can hold the given capacity.
     * @param minCapacity the minimum amount of space the array should hold.
     */
    public void ensureCapacity( int minCapacity ) {
        if ( minCapacity < 0 ) { minCapacity = Integer.MAX_VALUE; }
        if ( maxCapacity < minCapacity ) {
            Object[] rmyArray = new Object[minCapacity];
            for ( int i = 0; i < values.length; i++ ) {
                rmyArray[i] = values[i];
            }
            values = rmyArray;
            maxCapacity = rmyArray.length;
        }
    }
    
    /**
     * Removes all values of the ArrayList and sets the size of the list to 0.
     */
    public void clear() {
        for ( int i = 0; i < values.length; i++ ) {
            values[i] = null;
        }
        size = 0;
    }

    /**
     * Removes all values starting at fromIndex, then ending before toIndex.
     *
     * @param fromIndex index of first element to be removed.
     * @param toIndex index after last element to be removed.
     * @throws IndexOutOfBoundsException if fromIndex or
     * toIndex is out of range.
     */
    public void removeRange( int fromIndex, int toIndex) {
        if ( fromIndex < 0 || toIndex > size || fromIndex > toIndex ) {
            throw new IndexOutOfBoundsException();
        }
        int x = 0;
        while ( x < toIndex - fromIndex ) {
            remove(fromIndex);
            x++;
        }
    }
    
    /**
     * Returns the ArrayList as an array, in the order the elements belong in.
     * @return Object array containing all elements inside the array.
     */
    public Object[] toArray() {
        Object[] temp = new Object[size];
        for (int i = 0; i < size; i++ ) {
            temp[i] = values[i];
        }
        return temp;
    }
    
    /**
     * Trims the background array to the current size of the array.
     */
    public void trimToSize() {
        values = toArray();
        size = values.length;
    }
    
    /**
     * Compares the given object to the ArrayList.
     * @param o Object to compare
     * @return if the object is equal
     */
    public boolean equals( Object o) {
        if ( o == this ) {
            return true;
        }
        if ( ! (o instanceof MyArrayList ) ) {
            return false;
        }
        MyArrayList other = (MyArrayList)o;
        if ( size() == other.size() ) {
            for (int i = 0; i < size; i++ ) {
                if ( values[i] != other.values[i] ) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
