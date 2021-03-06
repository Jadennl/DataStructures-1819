import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * YES !!!!
 *
 * @author jnleo
 * @version 10/20/18
 */
public class MyLinkedListTest {
    private MyLinkedList<Integer> intList;
    private MyLinkedList<String> stringList;
    private MyLinkedList<Character> charList;

    /**
     * rt
     */
    @Before
    public void setUp() {
        stringList = new MyLinkedList<>();
        intList = new MyLinkedList<>();
        stringList.add("I'm");
        stringList.add("NOT");
        stringList.add("Babby");
        intList.add(0);
        intList.add(1);
        intList.add(3);
        intList.add(4);
        charList = new MyLinkedList<>();
        charList.add('a');
        charList.add('b');
        charList.add('c');
        charList.add('d');
        charList.add('e');
        charList.add('f');
        charList.add('g');
        charList.add('h');
    }

    /**
     * rr
     */
    @After
    public void tearDown() {
        intList = null;
        stringList = null;
        charList = null;
    }

    /**
     * rrr
     */
    @Test
    public void testAdd() {
        stringList.add("I'M");
        stringList.add("NOT");
        assertEquals("NOT", stringList.get(1));
    }

    /**
     * ddd
     */
    @Test
    public void testGetsPastOne() {
        assertEquals("a", charList.get(0).toString());
        assertEquals("b", charList.get(1).toString());
        assertEquals("c", charList.get(2).toString());
        assertEquals("d", charList.get(3).toString());
        assertEquals("h",
                charList.get(charList.size() - 1).toString());
    }

    /**
     * fgfgf
     */
    @Test
    public void testAddAll() {
        List<Integer> primes = new ArrayList<>();
        primes.add(1);
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);
        primes.add(11);
        MyLinkedList<Integer> babby = new MyLinkedList<>(primes);
        assertEquals("[1, 2, 3, 5, 7, 11]", babby.toString());
    }

    /**
     * dddd
     */
    @Test
    public void testAddIndex() {
        intList.add(2, 2);
        assertEquals("[0, 1, 2, 3, 4]", intList.toString());
    }

    /**
     * ww
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void failGet() {
        assertFalse(intList.isEmpty());
        intList.get(10);
    }
    
    /**
     * ww
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void failGet2() {
        assertFalse(intList.isEmpty());
        intList.get(-1);
    }

    /**
     * ww
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void failSet() {
        assertFalse(intList.isEmpty());
        intList.set(12, 20);
    }
    
    /**
     * ww
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void failSet2() {
        assertFalse(intList.isEmpty());
        intList.set(-1, 20);
    }

    /**
     * eee
     */
    @Test
    public void testSet() {
        stringList.set(1, "a");
        assertEquals("a", stringList.get(1));
    }

    /**
     * dd
     */
    @Test
    public void testIndex() {
        assertEquals(2, intList.indexOf(3));
        assertEquals(-1, intList.indexOf(10));
    }

    /**
     * e
     */
    @Test
    public void testLastRemove() {
        assertEquals("Babby",
                stringList.remove(stringList.size() - 1));
    }

    /**
     * dffdg
     */
    @Test
    public void testRemoveIndex() {
        assertEquals("NOT", stringList.remove(1));
        assertEquals("[I'm, Babby]", stringList.toString());
    }

    /**
     * wewer
     */
    @Test
    public void testRemoveObject() {
        assertTrue(stringList.remove("NOT"));
        assertEquals("[I'm, Babby]", stringList.toString());
        assertFalse(stringList.remove("NOT"));
    }

    /**
     * def
     */
    @Test
    public void testClear() {
        stringList.clear();
        assertTrue(stringList.isEmpty());
    }


    /**
     * et
     */
    @Test
    public void testEquals() {
        MyLinkedList<Integer> clone;
        clone = new MyLinkedList<>(Arrays.asList(0, 1, 3, 4));
        assertTrue(intList.equals(clone));
        assertFalse(intList.equals(charList));
        clone.set(2, 7);
        assertFalse(intList.equals(clone));
        clone = intList;
        assertTrue(intList.equals(clone));
        assertFalse(stringList.equals("g"));
    }

    /**
     * wew
     */
    @Test
    public void testToStringEmptyArr() {
        MyLinkedList<Object> objects = new MyLinkedList<>();
        assertEquals("[]", objects.toString());
    }

    /**
     * w
     */
    @Test
    public void testContains() {
        assertTrue(stringList.contains("NOT"));
        assertFalse(stringList.contains("im"));
    }

    /**
     * ree
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void failRemove() {
        assertEquals(4, intList.size());
        intList.remove(6);
    }
    
    /**
     * ree
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void failRemove2() {
        assertEquals(4, intList.size());
        intList.remove(-1);
    }

    /**
     * eret
     */
    @Test
    public void testRemoveRange() {
        charList.removeRange(2, 5);
        assertEquals("[a, b, f, g, h]", charList.toString());
    }

    /**
     * wrrr
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void failRemoveRange() {
        assertEquals(Character.toString('a'),
                charList.get(0).toString());
        intList.removeRange(4, 2);
    }
    
    /**
     * wrrr
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void failRemoveRange2() {
        assertEquals(Character.toString('a'),
                charList.get(0).toString());
        intList.removeRange(-1, 3);
    }
    
    /**
     * wrrr
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void failRemoveRange3() {
        assertEquals(Character.toString('a'),
                charList.get(0).toString());
        intList.removeRange(1, 11);
    }

    /**
     * ss
     */
    @Test
    public void testToArray() {
        Object[] babby = {"I'm", "NOT", "Babby"};
        assertArrayEquals(babby, stringList.toArray());
    }

    /**
     * dd
     */
    @Test
    public void testLastIndex() {
        assertEquals(2, intList.lastIndexOf(3));
        assertEquals(-1, intList.lastIndexOf(10));
    }

    /**
     * fugo
     */
    @Test
    public void removeOneItem() {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("h");
        assertEquals("h", list.remove(0));
    }

    /**
     * fugo
     */
    @Test
    public void removeAtZero() {
        stringList.remove(0);
        assertEquals("NOT", stringList.get(0));
    }

    /**
     * fugo
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void failAdd() {
        assertFalse(intList.isEmpty());
        intList.add(9, 4);
    }
    
    /**
     * fugo
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void failAdd2() {
        assertFalse(intList.isEmpty());
        intList.add(-1, 4);
    }

    /**
     * fugo
     */
    @Test
    public void addIndexSize() {
        stringList.add(stringList.size(), "g");
        assertEquals("g", stringList.get(stringList.size() - 1));
    }
    
    /**
     * fugo
     */
    @Test
    public void addRemoveAdd() {
        charList.add( 0, 'x' );
        assertEquals("x", charList.get(0).toString());
        charList.add(charList.remove( 0 ));
        assertEquals( "[a, b, c, d, e, f, g, h, x]",
                charList.toString() );
    }
}