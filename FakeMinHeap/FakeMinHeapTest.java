import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FakeMinHeapTest {
    private FakeMinHeap h;
    private FakeMinHeap h2;
    
    @Before
    public void setUp() throws Exception {
        h = new FakeMinHeap();
        h.add( 6 );
        h.add( 8 );
        h.add( 10 );
        h.add( 8 );
        h.add(4);
        h2 = new FakeMinHeap();
        h2.add( 10 );
        h2.add( 14 );
        h2.add( 16 );
        h2.add( 20 );
        
    }
    
    @After
    public void tearDown() throws Exception {
        h = null;
        h2 = null;
    }
    
    @Test
    public void testAdd() {
        h.add( 1 );
        assertEquals( "[1, 6, 4, 8, 8, 10]", h.toString() );
    }
    
    @Test
    public void testRemove() {
        h.add( 2 );
        h.remove();
        assertEquals( "[4, 6, 10, 8, 8]", h.toString() );
    }
    
    @Test
    public void testRemove2() {
        h2.add(30);
        h2.remove();
        assertEquals( "[14, 30, 16, 20]", h2.toString() );
    }
    
    @Test
    public void testRemove3() {
        FakeMinHeap h3 = new FakeMinHeap();
        h3.add(14);
        h3.add(30);
        h3.add(16);
        h3.add(20);
        h3.remove();
        assertEquals( "[16, 20, 30]", h3.toString() );
    }
    
    @Test
    public void testRemove4() {
        FakeMinHeap h4 = new FakeMinHeap();
        h4.add(1);
        h4.add(3);
        h4.add(5);
        h4.remove();
        assertEquals( "[3, 5]", h4.toString() );
    }
}