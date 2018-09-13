package src;

import com.sun.source.tree.AssertTree;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * f
 */
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
        default4 = new StringUtilities("foobar");
        default5 = new StringUtilities("vvvvvv");
    }
    
    @After
    public void tearDown()
    {
        default1 = null;
        default2 = null;
        default3 = null;
        default4 = null;
        default5 = null;
        
    }
    
    
    @Test(expected = NullPointerException.class)
    public void testReverseWithNull() {
        assertNull(default1.toString());
        default1.reverse();
    }

    @Test
    public void testReverseWithSingleChar() {
        StringUtilities s = new StringUtilities("z");
        assertEquals("z", s.reverse());

    }

    @Test
    public void testReverseWithDoubleSameChar() {
        StringUtilities s = new StringUtilities("zz");
        assertEquals("zz", s.reverse());

    }


    @Test
    public void testReverseWithDoubleDifferentChar() {
        StringUtilities s = new StringUtilities("az");
        assertEquals("za", s.reverse());

    }

    @Test
    public void testReverseWithRandomStuff() {
        StringUtilities s = new StringUtilities("oaew dda\n");
        assertEquals("\nadd weao", s.reverse());

    }

    @Test
    public void testReverseWithValidIndexes() {
        StringUtilities s = new StringUtilities("WANABEEE");
        assertEquals("EBAN", s.reverse(2, 6));
    }

    @Test
    public void testReverseWithSameIndexes() {
        assertEquals("", default2.reverse(0, 0));
    }
    
    @Test
    public void testNumberWithDecimal() {
        StringUtilities nums = new StringUtilities("1245.5");
        assertTrue(nums.isNumber());
    }

    @Test
    public void testNumberWithNegativeInvalid() {
        StringUtilities nums = new StringUtilities("45-3");
        assertFalse(nums.isNumber());
    }
    
    @Test
    public void testReturnNull() {
        assertNull( default1.toString() );
    }
    
    @Test
    public void testCaps(){
        StringUtilities s = new StringUtilities("WAKE UP !!");
        assertTrue(s.isAllUpper());
    }

    @Test
    public void setString() {
        default3.setString(default2.toString());
        assertEquals(default2.toString(), default3.toString() );
    }

    @Test
    public void testIsAllLower() {
        assertTrue( default4.isAllLower() );
    }

    @Test
    public void containsNumbersTrue() {
        StringUtilities s = new StringUtilities("F00die");
        assertTrue(s.containsNumbers());
    }

    @Test
    public void containsNumbersFalse() {
        assertFalse(default5.containsNumbers());
    }

    @Test
    public void isNumberTrue() {
        StringUtilities s = new StringUtilities("9978");
        assertTrue(s.isNumber());
    }

    @Test
    public void numConsecutiveDuplicates() {
        assertEquals(5, default5.numConsecutiveDuplicates());
    }

    @Test
    public void numMatchesChar() {
        assertEquals(3, default2.numMatches('l'));
    }

    @Test
    public void numMatchesString() {
        StringUtilities s = new StringUtilities("ManManBoyManMan");
        assertEquals(4, s.numMatches("Man"));
    }

    @Test
    public void numMatchesStringSameName() {
        assertEquals(3, default5.numMatches("vv"));
    }

    @Test
    public void asArray() {
        char[] ch = default2.toString().toCharArray();
        assertArrayEquals(ch, default2.asArray());
    }
}
