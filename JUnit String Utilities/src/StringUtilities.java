package src;

/**
 * A class that performs simple calculates on a given stored String
 * @author MeermaBR and <Your Name>
 * @version 9/4/18
 */
public class StringUtilities
{
    private String string;

    /**
     * Builds an empty (null) StringUtilities
     */
    public StringUtilities()
    {
        string = null;
    }

    /**
     * Builds a StringUtilities with the given String value
     * @param string The string to be stored for manipulation
     */
    public StringUtilities( String string )
    {
        this.string = string;
    }

    /**
     * Changes the stored String
     * @param string The new value for the String to become
     */
    public void setString( String string )
    {
        this.string = string;
    }

    /**
     * Returns the value of the String
     * @return The value of the String or null if the String is null
     */
    public String toString()
    {
        return string;
    }

    /**
     * Calculates a reversed value of the stored String
     * @return A new String with all values reversed
     * @throws NullPointerException if the original String is null
     */
    public String reverse()
    {
        StringBuilder ans = new StringBuilder();
        for ( int i = string.length() - 1; i >= 0; i-- )
        {
            ans.append( string.charAt(i) );
        }
        return ans.toString();
    }

    /**
     * Calculates a reversed value of a subsection of the String
     * @param from The index to begin at (inclusive)
     * @param to The index to stop at (exclusive)
     * @return A new String with all values reversed between index
     * from (inclusive) and to (exclusive)
     * @throws NullPointerException if the original String is null
     * @throws IllegalArgumentException if the given indices are not valid
     */
    public String reverse(int from, int to)
    {
        string.length();
        if (from < 0 || from >= string.length() ||
                to < 0 || to >= string.length() )
        {
            throw new IllegalArgumentException();
        }
        
        StringBuilder ans = new StringBuilder();
        for (int i = to - 1; i >= from; i--)
        {
            ans.append(string.charAt(i));
        }
        return ans.toString();
    }

    /**
     * Determines if all the alpha-characters in the string are Uppercase
     * @return True if all alpha-characters in the string are Uppercase
     * @throws NullPointerException if the original String is null
     */
    public boolean isAllUpper()
    {
        return string.equals(string.toUpperCase());
    }

    /**
     * Determines if all the alpha-characters in the string are Lowercase
     * @return True if all alpha-characters in the string are Lowercase
     * @throws NullPointerException if the original String is null
     */
    public boolean isAllLower()
    {
        return string.equals(string.toLowerCase());
    }

    /**
     * Determines if any of the characters in the string are numeric (0-9)
     * @return True if any 0-9 character is in the string
     * @throws NullPointerException if the original String is null
     */
    public boolean containsNumbers()
    {
        for ( char c : string.toCharArray()) {
            if (Character.isDigit(c))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Determines if the String itself is storing a number.
     * A number can start with a negative sign (-), may
     * contains one period (.), and otherwise is made only
     * of digits from 0-9.
     * @return True if the entire string is a number
     * @throws NullPointerException if the original String is null
     */
    public boolean isNumber()
    {
        int numPeriods = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (i == 0 && !Character.isDigit(c)
                    && c != '-' && c != '.' )
            {
                return false;
            }
            else if ( c == '.' )
            {
                numPeriods++;
                if (numPeriods > 1) { return false; }
            }
            else if ( !Character.isDigit(c) ) { return false; }
        }
        return true;
    }

    /**
     * Counts the number of characters which have the same value
     * next to them. ie: Meow = 0, Moo = 1, Shhhh! = 3
     * @return The number of consecutive duplicates found
     * @throws NullPointerException if the original String is null
     */
    public int numConsecutiveDuplicates()
    {
        int consec = 0;
        char prev = '\u0000';
        for (char c : string.toCharArray()) {
            if ( c == prev ) { consec++; }
            prev = c;
        }
        return consec;
    }

    /**
     * Counts the number of times a given char is in the String
     * @param c The char to be counted
     * @return The number of times the char is in the String
     * @throws NullPointerException if the original String is null
     */
    public int numMatches( char c )
    {
        int match = 0;
        for ( char ch : string.toCharArray()) {
            if ( ch == c ) { match++; }
        }
        return match;
    }

    /**
     * Counts the number of times a given String is found in the original
     * @param other The string to be looked for
     * @return The number of times other is in the original String
     * @throws NullPointerException if either the original or other string are null
     */
    public int numMatches( String other )
    {
        int match = 0;
        for (int i = 0; i < string.length() - other.length() + 1; i ++ ) {
            if ( string.substring(i, i + other.length()).equals(other) ) {
                match++;
                i += other.length() - 1;
            }
        }
        return match;
    }

    /**
     * Calculates an array version of the String, with each slot a char
     * @return An array conversion of the String
     * @throws NullPointerException if the String is null.
     */
    public char [] asArray()
    {
        return string.toCharArray();
    }
}