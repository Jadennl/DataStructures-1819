import java.util.*;
import java.io.*;

public class Thanksgiving {
    private static Map<String,Integer> foods = new TreeMap<>();
    public static void main(String[] args) {
        Scanner fileRead = null;
        
        try {
            File f = new File("Thanksgiving/Foods.txt");
            fileRead = new Scanner(f);
        }
        catch(FileNotFoundException e) {
        
        }
        finally {
            if (fileRead != null) {
                fileRead.close();
            }
        }
    }
    
    public static void printFreq(Scanner s) {
        while (s.hasNext()) {
            String food = s.nextLine();
            if (foods.containsKey( food ) == false ) {
                foods.put(food, 1);
            }
            else {
                foods.replace( food, foods.get( food ) + 1 );
            }
        }
         for (String food : foods.keySet()) {
             System.out.printf( "%s: %d",food, foods.get(food) );
         }
    }
    
    
}
