import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScanTesting {
    
    public static void main(String[] args) {
        Scanner fileRead = null;
        try {
            File f = new File("Scanner/Food FACTS.txt");
            fileRead = new Scanner( f );
            bestFood( fileRead );
        }
        catch ( FileNotFoundException e) {
        
        }
        finally {
            if (fileRead != null) {
                fileRead.close();
            }
        }
    }
    
    public static void bestFood(Scanner s) {
        int total = 0;
        int timesEaten = 0;
        double highestRating = Double.MIN_VALUE;
        String bestFood = "";
        while ( s.hasNext() ) {
            StringBuilder current = new StringBuilder(s.next());
            while ( !s.hasNextInt() )
            {
                current.append( " " ).append( s.next() );
            }
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
        System.out.printf("You like %s the most. %nYou ate it %.3f%% of the " +
                        "time.", bestFood, percent);
    }
}
