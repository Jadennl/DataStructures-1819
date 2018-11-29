import java.io.*;
import java.util.*;

public class Shiritori {
    private static int iter;
    private static TreeSet<String> words = new TreeSet<>();
    //private static List<String> words = new ArrayList<>();
    private static String firstWord, prevWord = "";
    
    public static void main( String args[] ) {
        Scanner input = new Scanner( System.in );
        iter = input.nextInt();
        input.nextLine();
        System.out.println(play( iter, input ));
        
    }
    
    public static String play( int time, Scanner input ) {
        for ( int i = 0; i < time; i++ ) {
            firstWord = input.nextLine();
            if (prevWord != "" && firstWord.charAt(0) != prevWord.charAt(prevWord.length() - 1 ) ) {
                return "Player " + ((i % 2) + 1) + " lost";
            }
            else if ( !words.add( firstWord ) ) {
                 return "Player " + ((i % 2) + 1) + " lost";
            }
            prevWord = firstWord;
        }
        return "Fair Game";
    }
    
}
