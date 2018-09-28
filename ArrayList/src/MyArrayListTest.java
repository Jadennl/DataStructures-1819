import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * YES
 * @author jnleo
 * @version 9999
 */
public class MyArrayListTest {
    private MyArrayList<String> stringList;
    private MyArrayList<Integer> intList;
    
    /**
     * j
     */
    @Before
    public void setUp() {
        stringList = new MyArrayList<>();
        intList = new MyArrayList<>();
        stringList.add( "I'm" );
        stringList.add( "NOT" );
        stringList.add( "Babby" );
        intList.add( 0 );
        intList.add( 1 );
        intList.add( 3 );
        intList.add( 4 );
    }
    
    /**
     * s
     */
    @After
    public void tearDown() {
        stringList = null;
        intList = null;
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
     * dd
     */
    @Test
    public void testLastIndex() {
        assertEquals(2, intList.lastIndexOf(3) );
        assertEquals(-1, intList.lastIndexOf(10));
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
        MyArrayList<Integer> babby = new MyArrayList<>( primes );
        assertEquals( "1\t2\t3\t5\t7\t11\t", printAr(babby) );
    }
    
    /**
     * dffdg
     */
    @Test
    public void testRemoveIndex() {
        assertEquals( "NOT", stringList.remove( 1 ) );
        assertEquals( "I'm\tBabby\t", printAr( stringList ) );
    }
    
    /**
     * wewer
     */
    @Test
    public void testRemoveObject() {
        assertTrue( stringList.remove( "NOT" ) );
        assertEquals( "I'm\tBabby\t", printAr( stringList ) );
        assertFalse( stringList.remove("NOT") );
    }
    
    /**
     * f
     */
    @Test
    public void testDefaultArrayList() {
        assertEquals( 3, stringList.size() );
    }
    
    /**
     * def
     */
    @Test
    public void testClear() {
        stringList.clear();
        assertTrue( stringList.isEmpty() );
    }

    /**
     * e
     */
    @Test
    public void testLastRemove() {
        assertEquals("Babby", stringList.remove(stringList.size() - 1) );
    }

    /**
     * weeeeee
     */
    @Test
    public void testAdd() {
        intList.add( 1 );
        assertEquals( 5, intList.size() );
    }
    
    /**
     * dddd
     */
    @Test
    public void testAddIndex() {
        intList.add( 2, 2 );
        assertEquals( "0\t1\t2\t3\t4\t", printAr( intList ));
    }

    /**
     * eee
     */
    @Test
    public void testEnsureIndirectly() {
        MyArrayList<Character> grr = new MyArrayList<>(14);
        for ( char c : "ThisisnotME!ok?".toCharArray() ) {
            grr.add(c);
        }
        assertEquals( 30, grr.size() );
    }

    /**
     * w
     */
    @Test
    public void testContains() {
        assertTrue( stringList.contains("NOT") );
        assertFalse( stringList.contains("im") );
    }

    /**
     * ww
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void failGet() {
        intList.get(10);
    }

    /**
     * ww
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void failSet() {
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
     * Returns the values in the list in a string
     * @param list ArrayList to be added
     *
     * @return string of values inside the ArrayList
     */
    private String printAr(MyArrayList list) {
        StringBuilder s = new StringBuilder( "" );
        for ( int i = 0; i < list.size(); i++ ) {
            s.append( list.get( i ) + "\t" );
        }
        return s.toString();
    }
}
