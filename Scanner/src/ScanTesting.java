import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScanTesting {
    
    public static void main(String[] args) {
        Scanner fileRead = null;
        try {
            File f = new File("Scanner/Food FACTS.txt");
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
        while ( s.hasNext() ) {
            StringBuilder current = new StringBuilder(s.next());
            while (s.hasNextInt() == false ) { current.append(" " + s.next()); }
            int eat = s.nextInt();
            total += eat;
            double rating = s.nextDouble();
            if ( rating > highestRating) {
                bestFood = current.toString();
                timesEaten = eat;
                highestRating = rating;
            }
        }
        double percent = (double) timesEaten / total * 100;
        return "You like " + bestFood + " the most. You ate it " + percent +
                "% of the time.";
    }
}
