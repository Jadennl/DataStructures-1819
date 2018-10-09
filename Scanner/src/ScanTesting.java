import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScanTesting {
    
    public static void main(String[] args) {
        Scanner fileRead = null;
        try {
            File f = new File("C:\\Users\\jnleo\\DataStructures-1819\\Scanner" +
                    "\\src\\Food FACTS.txt");
            fileRead = new Scanner( f );
            String s = bestFood( fileRead );
            System.out.println( s );
        }
        catch ( FileNotFoundException e) {
        
        }
        finally {
            if (fileRead != null) {
                fileRead.close();
            }
        }
    }
    
    public static String bestFood(Scanner s) {
        int total = 0;
        int timesEaten = 0;
        double highestRating = Double.MIN_VALUE;
        String bestFood = "";
        String current;
        while ( s.hasNext() ) {
            current = s.nextLine();
            int eat = s.nextInt();
            total += eat;
            double rating = s.nextDouble();
            if ( rating > highestRating) {
                bestFood = current;
                timesEaten = eat;
                highestRating = rating;
            }
        }
        double percent = (double) timesEaten / total;
        return "You like " + bestFood + " the most. You ate it " + percent +
                "% of the time.";
    }
}
