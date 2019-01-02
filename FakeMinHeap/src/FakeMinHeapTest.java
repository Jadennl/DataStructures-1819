import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FakeMinHeapTest {
    private FakeMinHeap h;
    
    @Before
    public void setUp() throws Exception {
        h = new FakeMinHeap();
        h.add( 6 );
        h.add( 8 );
        h.add( 10 );
        h.add( 8 );
    }
    
    @After
    public void tearDown() throws Exception {
        h = null;
    }
    
    @Test
    public void testAdd() {
        h.add( 1 );
        assertEquals( "[1, 6, 10, 8, 8]", h.toString() );
    }
}