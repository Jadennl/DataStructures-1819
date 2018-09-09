import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StringUtilitiesTest {

    private StringUtilities default1;
    private StringUtilities default2;
    private StringUtilities default3;
    private StringUtilities default4;
    private StringUtilities default5;

    @Before
    public void setup()
    {
        default1 = new StringUtilities();
        default2 = new StringUtilities("Hello, World!");
	default3 = new StringUtilities("");
    }

    @After
    public void tearDown()
    {
        default1 = null;
        default2 = null;
    }


    @Test(expected=NullPointerException.class)
    public void testReverseWithNull()
    {
        default1.reverse();
    }

    @Test
    public void testReverseWithSingleChar()
    {
        StringUtilities s = new StringUtilities( "z" );
        assertEquals( "z", s.reverse() );

    }

    @Test
    public void testReverseWithDoubleSameChar()
    {
        StringUtilities s = new StringUtilities( "zz" );
        assertEquals( "zz", s.reverse() );

    }


    @Test
    public void testReverseWithDoubleDifferentChar()
    {
        StringUtilities s = new StringUtilities( "az" );
        assertEquals( "za", s.reverse() );

    }

    @Test
    public void testReverseWithRandomStuff()
    {
        StringUtilities s = new StringUtilities( "╥æ±B è\n" );
        assertEquals( "\nè B±æ╥", s.reverse() );

    }

    @Test
    public void testReverseWithValidIndexes() {
        StringUtilities s = new StringUtilities("WANABEEE");
        assertEquals("EBAN", s.reverse(2,6));
    }

    @Test
    public void testReverseWithSameIndexes() {
        assertEquals("", default2.reverse(0,0));
    }
}
