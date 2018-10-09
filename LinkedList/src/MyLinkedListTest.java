import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

/**
 * YES !!!!
 */
public class MyLinkedListTest {
    private MyLinkedList<Integer> intList;
    private MyLinkedList<String> stringList;
    
    @Before
    public void setUp() {
        stringList = new MyLinkedList<>();
        intList = new MyLinkedList<>();
    }
    
    @After
    public void tearDown() {
        intList = null;
        stringList = null;
    }
    
    @Test
    public void testAdd() {
        stringList.add( "I'M" );
        stringList.add( "NOT" );
        assertEquals("NOT",stringList.get(1));
    }
}