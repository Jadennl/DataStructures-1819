import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * YES !!!!
 */
public class MyLinkedListTest {
    private MyLinkedList<Integer> intList;
    
    @Before
    public void setUp() {
        intList = new MyLinkedList<>();
    }
    
    @After
    public void tearDown() {
        intList = null;
    }
    
    @Test
    public void fail() {
        fail();
    }
}