import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * YES !!!!
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
        stringList.add( "I'm" );
        stringList.add( "NOT" );
        stringList.add( "Babby" );
        intList.add( 0 );
        intList.add( 1 );
        intList.add( 3 );
        intList.add( 4 );
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
        stringList.add( "I'M" );
        stringList.add( "NOT" );
        assertEquals("NOT",stringList.get(1));
    }
    
    /**
     * ddd
     */
    @Test
    public void testGetsPastOne() {
        assertEquals( "a", charList.get( 0 ).toString() );
        assertEquals( "b", charList.get( 1 ).toString() );
        assertEquals( "c", charList.get( 2 ).toString() );
        assertEquals( "d", charList.get( 3 ).toString() );
        assertEquals( "h",
                charList.get( charList.size() - 1 ).toString() );
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
        MyLinkedList<Integer> babby = new MyLinkedList<>( primes );
        assertEquals( "[1, 2, 3, 5, 7, 11]", babby.toString() );
    }
    
    /**
     * dddd
     */
    @Test
    public void testAddIndex() {
        intList.add( 2, 2 );
        assertEquals( "[0, 1, 2, 3, 4]", intList.toString() );
    }
    
    /**
     * ww
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void failGet() {
        assertFalse(intList.isEmpty());
        intList.get(10);
    }
    
    /**
     * ww
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void failSet() {
        assertFalse(intList.isEmpty());
        intList.set( 12, 20);
    }
    
    /**
     *eee
     */
    @Test
    public void testSet() {
        stringList.set(1, "a");
        assertEquals("a", stringList.get(1) );
    }
    
    /**
     * dd
     */
    @Test
    public void testIndex() {
        assertEquals(2, intList.indexOf(3) );
        assertEquals(-1, intList.indexOf(10));
    }
    
    /**
     * e
     */
    @Test
    public void testLastRemove() {
        assertEquals("Babby",
                stringList.remove(stringList.size() - 1) );
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
        assertTrue( stringList.remove( "NOT" ) );
        assertEquals( "[I'm, Babby]", stringList.toString() );
        assertFalse( stringList.remove("NOT") );
    }
    
}