package src;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jnleo
 * @version 2018-09-13
 * f
 */
public class StringUtilitiesTest {

    private StringUtilities default1;
    private StringUtilities default2;
    private StringUtilities default3;
    private StringUtilities default4;
    private StringUtilities default5;
    
    /**
     * ddd
     */
    @Before
    public void setUp()
    {
        default1 = new StringUtilities();
        default2 = new StringUtilities("Hello, World!");
        default3 = new StringUtilities("");
        default4 = new StringUtilities("foobar");
        default5 = new StringUtilities("vvvvvv");
    }
    
    /**
     * sss
     */
    @After
    public void tearDown()
    {
        default1 = null;
        default2 = null;
        default3 = null;
        default4 = null;
        default5 = null;
        
    }
    
    
    /**
     * ssssss
     */
    @Test(expected = NullPointerException.class)
    public void testReverseWithNull() {
        assertNull(default1.toString());
        default1.reverse();
    }
    
    /**
     * sssss
     */
    @Test
    public void testReverseWithSingleChar() {
        StringUtilities s = new StringUtilities("z");
        assertEquals("z", s.reverse());

    }
    
    /**
     * ssssdd
     */
    @Test
    public void testReverseWithDoubleSameChar() {
        StringUtilities s = new StringUtilities("zz");
        assertEquals("zz", s.reverse());

    }
    
    
    /**
     * ewwqqq
     */
    @Test
    public void testReverseWithDoubleDifferentChar() {
        StringUtilities s = new StringUtilities("az");
        assertEquals("za", s.reverse());

    }
    
    /**
     * wwwwww
     */
    @Test
    public void testReverseWithRandomStuff() {
        StringUtilities s = new StringUtilities("oaew dda\n");
        assertEquals("\nadd weao", s.reverse());

    }
    
    /**
     * wweeeww
     */
    @Test
    public void testReverseWithValidIndexes() {
        StringUtilities s = new StringUtilities("WANABEEE");
        assertEquals("EBAN", s.reverse(2, 6));
    }
    
    /**
     * adsdsadsad
     */
    @Test
    public void testReverseWithSameIndexes() {
        assertEquals("", default2.reverse(0, 0));
    }
    
    /**
     * weewqrqerqer
     */
    @Test
    public void testNumberWithDecimal() {
        StringUtilities nums = new StringUtilities(".12455");
        assertTrue(nums.isNumber());
    }
    
    /**
     * wewewqwrwqr
     */
    @Test
    public void testNumberWithNegativeInvalid() {
        StringUtilities nums = new StringUtilities("45-3");
        assertFalse(nums.isNumber());
    }
    
    /**
     * weweefdfd
     */
    @Test
    public void testReturnNull() {
        assertNull( default1.toString() );
    }
    
    /**
     * ewewqwdefa
     */
    @Test
    public void testCaps() {
        StringUtilities s = new StringUtilities("WAKE UP !!");
        assertTrue(s.isAllUpper());
    }
    
    /**
     * ewqewqd
     */
    @Test
    public void setString() {
        default3.setString(default2.toString());
        assertEquals(default2.toString(), default3.toString() );
    }
    
    /**
     * ewewasdad
     */
    @Test
    public void testIsAllLower() {
        assertTrue( default4.isAllLower() );
    }
    
    /**
     * ewewsadad
     */
    @Test
    public void containsNumbersTrue() {
        StringUtilities s = new StringUtilities("F00die");
        assertTrue(s.containsNumbers());
    }
    
    /**
     * ewqeqwdsdsadasd
     */
    @Test
    public void containsNumbersFalse() {
        assertFalse(default5.containsNumbers());
    }
    
    /**
     * dwqwewqdsd
     */
    @Test
    public void isNumberTrue() {
        StringUtilities s = new StringUtilities("9978");
        assertTrue(s.isNumber());
    }
    
    /**
     * dsadaxas
     */
    @Test
    public void numConsecutiveDuplicates() {
        assertEquals(5, default5.numConsecutiveDuplicates());
    }
    
    /**
     * ewasdad
     */
    @Test
    public void numMatchesChar() {
        assertEquals(3, default2.numMatches('l'));
    }
    
    /**
     * saadadx
     */
    @Test
    public void numMatchesString() {
        StringUtilities s = new StringUtilities("ManManBoyManMan");
        assertEquals(4, s.numMatches("Man"));
    }
    
    /**
     * eqwdsdasd
     */
    @Test
    public void numMatchesStringSameName() {
        assertEquals(3, default5.numMatches("vv"));
    }
    
    /**
     * ewdsdasd
     */
    @Test
    public void asArray() {
        char[] ch = default2.toString().toCharArray();
        assertArrayEquals(ch, default2.asArray());
    }
    
    /**
     * ewsdadasdas
     */
    @Test
    public void testIsNumberWithDate() {
        StringUtilities s = new StringUtilities("05.04.2003");
        assertFalse(s.isNumber());
    }
}
