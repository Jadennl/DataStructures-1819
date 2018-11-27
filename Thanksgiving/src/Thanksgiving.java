import java.util.*;
import java.io.*;

public class Thanksgiving {
    private static Map<String, Integer> foods = new TreeMap<>();
    public static void main(String[] args) {
        Scanner fileRead = null;
        try {
            File f = new File("Thanksgiving/Foods.txt");
            fileRead = new Scanner(f);
            printFreq(fileRead);
            printPop( foods );
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
            if ( !foods.containsKey( food ) ) {
                foods.put(food, 1);
            }
            else {
                foods.replace( food, foods.get( food ) + 1 );
            }
        }
         for (String food : foods.keySet()) {
             System.out.printf( "%-40s %d%n",food,foods.get(food) );
         }
    }
    
    public static void printPop(Map<String, Integer> m) {
        Map<Integer, TreeSet<String>> ratings = new TreeMap<>();
        for (String food : m.keySet()) {
            TreeSet<String> bucket = ratings.get(foods.get(food));
            if ( bucket == null ) {
                bucket = new TreeSet<String>();
            }
            bucket.add( food );
            ratings.put( foods.get(food), bucket);
        }
        
        for(int i : ratings.keySet()) {
            StringBuilder list = new StringBuilder("[");
            for (String s : ratings.get( i )) {
                list.append( s + ", ");
            }
            list.replace(list.length() - 2, list.length(), "]" );
            System.out.printf( "%-10d %s%n", i, list );
        }
    }
    
}
