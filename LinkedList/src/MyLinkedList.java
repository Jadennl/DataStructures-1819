import java.util.Collection;

/**
 * This is my version of the LinkedList Class.
 *
 * @param <E> element specified for the entire scope of the LinkedList.
 *
 * @author Jaden Leonard
 * @version 10/03/18
 */
public class MyLinkedList<E> {
    private int size;
    private Node<E> head;
    
    /**
     * Creates an empty list
     */
    public MyLinkedList() {
        size = 0;
        head = null;
    }
    
    /**
     * Creates an LinkedList that imports objects from the collection defined in
     * the parameter.
     *
     * @param c The collection to be added.
     */
    public MyLinkedList( Collection<E> c ) {
        head = null;
        addAll( c );
    }
    
    /**
     * Returns the size of the list.
     *
     * @return the size of the list.
     */
    public int size() {
        return size;
    }
    
    /**
     * Returns true if the list is empty
     * @return whether list is empty
     */
    public boolean isEmpty() {
       return size == 0;
    }
    
    /**
     * Adds an element to the end of the LinkedList.
     *
     * @param e element to be added
     *
     * @return boolean equal to if the element was added.
     */
    public boolean add( E e ) {
        size++;
        if ( head == null ) {
            head = new Node( e );
        } else {
            toEnd( head ).next = new Node( e );
        }
        return true;
    }
    
    /**
     * Adds an element to the given index. The data in the index previously
     * is shifted to the right.
     * @param index the index to insert in.
     * @param e element to be added
     */
    public void add( int index, E e ) {
        if ( index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) { add( e ); }
        else {
            size++;
            Node prev = get(index - 1, head);
            Node old = get(index, head);
            Node n = new Node(e, old);
            prev.next = n;
        }
    }
    
    /**
     * Adds all the elements in a given collection to the LinkedList.
     *
     * @param c collection to be added.
     */
    public void addAll( Collection<E> c ) {
        for ( E e : c ) {
            add( e );
        }
    }
    
    public boolean remove( E e ) {
        int i = indexOf( e );
        if (i == -1 ) {
            return false;
        }
        remove(i);
        return true;
    }
    
    public E remove( int index ) {
        //TODO: finish
        if ( index >= size || index < 0 ) {
            throw new IndexOutOfBoundsException();
        }
        E removed = get( index );
        if (index == 0 && size > 1 ) {
            head = head.next;
            size--;
        }
        else if (index == 0) {
            size--;
            head = null;
        }
        else if (index == size - 1) {
            size--;
            get(size -  2, head).next = null;
        }
        else {
            size--;
            get( index - 1, head ).next = get( index, head ).next;
        }
        return removed;
    }
    
    /**
     * Gets the element contained in the given index.
     *
     * @param index the index to go to.
     *
     * @return element in said index.
     *
     * @throws IndexOutOfBoundsException when 0 > index > size.
     */
    public E get( int index ) {
        if ( index < 0 || index > size ) {
            throw new IndexOutOfBoundsException();
        }
        return (E) get( index, head ).data;
    }
    
    public E set( int index, E e ) {
        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
        Node n = get( index, head );
        E old = ( E ) n.data;
        n.data = e;
        return old;
    }
    
    public int indexOf( E e ) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(e)) {
                return i;
            }
        }
        return -1;
    }
    
    public int lastIndexOf(E e) {
        //TODO: finish
        return -1;
    }
    
    public String toString() {
        if ( size == 0 ) {
            return "[]";
        }
        StringBuilder s = new StringBuilder("]");
        for ( int i = 0; i < size - 1; i++ ) {
            s.insert( s.length() - 1, get( i ) + ", "  );
        }
        s.insert(s.length() - 1, get( size - 1 ));
        s.insert(0, "[");
        return s.toString();
    }
    
    private Node toEnd( Node current ) {
        if ( current.next != null ) {
            return toEnd( current.next );
        }
        return current;
    }
    
    private Node get( int index, Node n ) {
        if ( index > 0 ) {
            return get( index - 1, n.next );
        }
        return n;
    }
    
    class Node<E> {
        E data;
        Node next;
        
        Node( E data, Node next ) {
            this.data = data;
            this.next = next;
        }
        
        Node( E data ) {
            this( data, null );
        }
    }
}
