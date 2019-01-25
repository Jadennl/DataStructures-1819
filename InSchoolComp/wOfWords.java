import java.util.*;
public class wOfWords {
    private static int weight, numLetters;
    private static String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h"
            , "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u"
            , "v", "w", "x", "y", "z"};
    public static void main( String[] args ) {
        Scanner in = new Scanner( System.in );
        numLetters = in.nextInt();
        weight = in.nextInt();
        String returned = "";
        int blah = weight / numLetters;
        if ( blah > 26 ) {
            System.out.println( "impossible" );
        } else {
            for ( int i = 0; i < blah; i++ ) {
                returned = returned + letters[blah];
            }
            returned = returned + letters[weight % numLetters];
            System.out.println( returned );
        }
    }
}
