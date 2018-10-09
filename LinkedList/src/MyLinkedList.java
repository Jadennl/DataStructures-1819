import java.util.Collection;

/**
 * This is my version of the LinkedList Class.
 *
 * @author Jaden Leonard
 * @version 10/03/18
 * @param <E> element specified for the entire scope of the LinkedList.
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
     * Creates an LinkedList that imports objects from the collection defined
     * in the parameter.
     * @param c The collection to be added.
     */
    public MyLinkedList( Collection<E> c ) {
        size = c.size();
        addAll(c);
    }
    
    private Node toEnd(Node current) {
        if ( current.next != null ){
            return toEnd(current.next);
        }
        return current;
    }
    
    /**
     * Adds an element to the end of the LinkedList.
     * @param e element to be added
     *
     * @return boolean equal to if the element was added.
     */
    public boolean add(E e) {
        size++;
        if (head == null ) {
            head = new Node( e );
        }
        else {
            toEnd( head ).next = new Node( e );
        }
        return true;
    }
    
    public void addAll( Collection<E> c ) {
        for ( E e: c) {
            add( e );
        }
    }
    
    /**
     * Gets the element contained in the given index.
     *
     * @param index the index to go to.
     *
     * @return element in said index.
     * @throws IndexOutOfBoundsException when 0 > index > size.
     */
    public E get(int index) {
        if ( index < 0 || index > size ) {
            throw new IndexOutOfBoundsException();
        }
        return (E) get(index, head).data;
    }
    
    private Node get(int index, Node n) {
        if (index > 0 ) {
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
