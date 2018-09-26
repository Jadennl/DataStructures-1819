import java.util.Collection;

/**
 * This is my version of the ArrayList class. This was created so I would have a
 * better understanding of how an ArrayList works.
 *
 * @author Jaden Leonard
 * @version 08/31/18
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
     * Adds an object to the ArrayList.
     * @param obj The object to be added to the ArrayList.
     *
     * @return boolean if the object is successfully added.
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
     * @param obj The object to be added to the ArrayList.
     * @throws IndexOutOfBoundsException if the index is not inside the
     * current list.
     */
    public void add( int index, E obj ) {
        if ( index > size ) { throw new IndexOutOfBoundsException(); }
        if ( index == size ) { add( obj ); }
        else {
            size++;
            if ( size > maxCapacity ) {  ensureCapacity(size * 2 ); }
            for ( int i = size - 2; i > index; i-- ) {
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
    
    public boolean remove( Object obj ) {
        //TODO finish
        return false;
    }
    
    public Object remove( int index ) {
        //TODO finish
        return null;
    }
    
    public Object get( int index ) {
        if ( index < 0 || index >= size() ) {
            throw new IndexOutOfBoundsException();
        } else {
            return values[index];
        }
    }
    
    public void set( int index, Object obj ) {
        //TODO finish
    }
    
    public int indexOf( Object o ) {
        for ( int i = 0; i < size; i++ ) {
            if ( values[i].equals( o ) ) {
                return i;
            }
        }
        return -1;
    }
    
    public int lastIndexOf( Object o ) {
        for ( int i = size - 1; i <= 0; i-- ) {
            if ( values[i].equals( o ) ) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Checks whether the ArrayList contains the given object.
     *
     * @param obj Object to check is inside the object.
     *
     * @return boolean equal to whether the object is contained in the
     * ArrayList.
     */
    public boolean contains( Object obj ) {
        for ( int i = 0; i < size; i++ ) {
            if ( obj == values[i] ) return true;
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
    
    public void ensureCapacity( int minCapacity ) {
        if ( minCapacity < 0 ) { minCapacity = Integer.MAX_VALUE; }
        if ( maxCapacity < minCapacity ) {
            Object[] rmyArray = new Object[minCapacity];
            for ( int i = 0; i < values.length; i++ ) {
                rmyArray[i] = values[i];
            }
            values = rmyArray;
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
}
