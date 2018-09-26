import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
     * f
     */
    @Test
    public void testDefaultArrayList() {
        assertEquals( 0,
                stringList.size() );
    }
    
    @Test
    public void testAdd() {
        assertEquals( 0, intList.size() );
        intList.add( 1 );
        assertEquals( 1, intList.size() );
    }
    
    @Test
    public void testAddIndex() {
        intList.add( 0 );
        intList.add( 1 );
        intList.add( 3 );
        intList.add( 4 );
        intList.add( 2, 3 );
        assertEquals( 0, intList.get( 0 ) );
        assertEquals( 1, intList.get( 1 ) );
        assertEquals( 2, intList.get( 2 ) );
        assertEquals( 3, intList.get( 3 ) );
        assertEquals( 4, intList.get( 4 ) );
    }
}
