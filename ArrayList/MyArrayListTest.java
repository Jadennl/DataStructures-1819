import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
    private MyArrayList<Character> charList;
    
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
        charList = new MyArrayList<>();
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
        assertEquals( "[1, 2, 3, 5, 7, 11]", babby.toString() );
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
    
    /**
     * f
     */
    @Test
    public void testDefaultArrayList() {
        assertEquals( 3,
                stringList.size() );
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
        assertEquals("Babby",
                stringList.remove(stringList.size() - 1) );
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
        assertEquals( "[0, 1, 2, 3, 4]", intList.toString() );
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
        assertEquals( 15, grr.size() );
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
     * ree
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void failRemove() {
        assertEquals(4, intList.size());
        intList.remove(6);
    }
    
    /**
     * eret
     */
    @Test
    public void testRemoveRange() {
        charList.removeRange( 2, 5 );
        assertEquals( "[a, b, f, g, h]", charList.toString() );
    }
    
    /**
     * wrrr
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void failRemoveRange() {
        assertEquals( Character.toString( 'a' ),
                charList.get(0).toString() );
        intList.removeRange( 4, 2 );
    }
    
    /**
     * ss
     */
    @Test
    public void testToArray() {
        Object[] babby = {"I'm", "NOT", "Babby" };
        assertArrayEquals( babby, stringList.toArray() );
    }
    
    /**
     * gr
     */
    @Test
    public void testTrimToSize() {
        MyArrayList<Character> grr = new MyArrayList<>(14);
        for ( char c : "ThisisnotME!ok?".toCharArray() ) {
            grr.add(c);
        }
        grr.trimToSize();
        assertEquals( 15, grr.size() );
    }
    
    /**
     * et
     */
    @Test
    public void testEquals() {
        MyArrayList<Integer> clone;
        clone = new MyArrayList<>(Arrays.asList(0, 1, 3, 4));
        assertTrue(intList.equals(clone));
        assertFalse(intList.equals( charList));
    }

    /**
     * wew
     */
    @Test
    public void testToStringEmptyArr() {
        MyArrayList<Object> objects = new MyArrayList<>();
        assertEquals("[]",  objects.toString());
    }

    /**
     * ere
     */
    @Test
    public void testTrimAdd() {
        charList.add('i');
        charList.trimToSize();
        charList.add('j');
        assertEquals("[a, b, c, d, e, f, g, h, i, j]", charList.toString());
    }
}
