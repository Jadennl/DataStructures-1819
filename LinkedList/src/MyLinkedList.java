import java.util.Collection;

/**
 * This is my version of the LinkedList Class.
 *
 * @param <E> element specified for the entire scope of the LinkedList.
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
    public MyLinkedList(Collection<E> c) {
        head = null;
        addAll(c);
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
     *
     * @return whether list is empty
     */
    public boolean isEmpty() {
        return size <= 0;
    }

    /**
     * Adds an element to the end of the LinkedList.
     *
     * @param e element to be added
     * @return boolean equal to if the element was added.
     */
    public boolean add(E e) {
        size++;
        if (head == null) {
            head = new Node(e);
        } else {
            toEnd(head).next = new Node(e);
        }
        return true;
    }

    /**
     * Adds an element to the given index. The data in the index previously
     * is shifted to the right.
     *
     * @param index the index to insert in.
     * @param e     element to be added
     * @throws IndexOutOfBoundsException if 0 > index > size
     */
    public void add(int index, E e) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(e);
        } else {
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
    public void addAll(Collection<E> c) {
        for (E e : c) {
            add(e);
        }
    }

    /**
     * Removes the specified element from the LinkedList.
     *
     * @param e element to be removed.
     * @return boolean whether the object was successfully removed.
     */
    public boolean remove(E e) {
        int i = indexOf(e);
        if (i == -1) {
            return false;
        }
        remove(i);
        return true;
    }

    /**
     * Removes the element at the specified index.
     *
     * @param index the index of the element to be removed.
     * @return the element that was removed.
     * @throws IndexOutOfBoundsException if 0 > index >= size
     */
    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        E removed = get(index);
        if (index == 0 && size > 1) {
            head = head.next;
            size--;
        } else if (index == 0) {
            size--;
            head = null;
        } else if (index == size - 1) {
            size--;
            get(size - 2, head).next = null;
        } else {
            size--;
            get(index - 1, head).next = get(index, head).next;
        }
        return removed;
    }

    /**
     * Gets the element contained in the given index.
     *
     * @param index the index to go to.
     * @return element in said index.
     * @throws IndexOutOfBoundsException when 0 > index >= size.
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) get(index, head).data;
    }

    /**
     * Sets the given index to the specified element.
     *
     * @param index the index to be replaced.
     * @param e the element to be set to the index.
     * @return the element previously at the specified index.
     * the size or less than 0.
     * @throws IndexOutOfBoundsException if the given index is greater than
     * or equal to the size or less than zero.
     */
    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node n = get(index, head);
        E old = (E) n.data;
        n.data = e;
        return old;
    }

    /**
     * Looks for the given element starting at the beginning of the LinkedList.
     *
     * @param e the element to look for.
     * @return integer equal to the location of the element. returns -1 if
     * the element is not present.
     */
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Looks for the given element starting at the end of the LinkedList.
     *
     * @param e the element to look for.
     * @return integer equal to the location of the element. returns -1 if
     * the element is not present.
     */
    public int lastIndexOf(E e) {
        for (int i = size - 1; i >= 0; i--) {
            if (get(i).equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Checks whether the LinkedList contains the given object.
     *
     * @param obj Element to check is inside the list.
     * @return boolean equal to whether the object is contained in the
     * LinkedList.
     */
    public boolean contains(E obj) {
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * returns the LinkedList in a "[value1, value2,... valueN] format.
     *
     * @return string format of LinkedList
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder s = new StringBuilder("]");
        for (int i = 0; i < size - 1; i++) {
            s.insert(s.length() - 1, get(i) + ", ");
        }
        s.insert(s.length() - 1, get(size - 1));
        s.insert(0, "[");
        return s.toString();
    }

    /**
     * Removes all values of the LinkedList and sets the size of the list to 0.
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Removes all values starting at fromIndex, then ending before toIndex.
     *
     * @param fromIndex index of first element to be removed.
     * @param toIndex   index after last element to be removed.
     * @throws IndexOutOfBoundsException if fromIndex or
     *                                   toIndex is out of range.
     */
    public void removeRange(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex > size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        int x = 0;
        while (x < toIndex - fromIndex) {
            remove(fromIndex);
            x++;
        }
    }

    /**
     * Returns the LinkedList as an array, in the order the elements belong in.
     *
     * @return Object array containing all elements inside the array.
     */
    public Object[] toArray() {
        Object[] temp = new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = get(i);
        }
        return temp;
    }

    /**
     * Compares the given object to the LinkedList.
     *
     * @param o Object to compare
     * @return if the object is equal
     */
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MyLinkedList)) {
            return false;
        }
        MyLinkedList other = (MyLinkedList) o;
        if (size() == other.size()) {
            for (int i = 0; i < size; i++) {
                if (this.get(i) != other.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * grabs the last node
     *
     * @param current
     * @return node at end of list
     */
    private Node toEnd(Node current) {
        if (current.next != null) {
            return toEnd(current.next);
        }
        return current;
    }

    /**
     * Grabs node index ahead of given node.
     * This will always start with head. 
     *
     * @param index index to count down to
     * @param n current node
     * @return node at index
     */
    private Node get(int index, Node n) {
        if (index > 0) {
            return get(index - 1, n.next);
        }
        return n;
    }

    /**
     * Class that stores a value and the node after it
     *
     * @param <E> object type to be stored
     */
    class Node<E> {
        E data;
        Node next;

        Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(E data) {
            this(data, null);
        }
    }
}
