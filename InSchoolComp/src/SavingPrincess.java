import java.util.*;
public class SavingPrincess {
    
    public static void  main(String args[]) {
        Scanner in = new Scanner(System.in);
        int numObs = in.nextInt();
        List<Integer> obsMissed = new ArrayList<>( numObs );
        int obsFound = in.nextInt();
        
        for ( int i = 0; i < numObs; i++) {
            obsMissed.add(i);
        }
        for (int i = 0; i < obsFound; i++) {
            obsMissed.remove( (Integer)in.nextInt() );
        }
        for (Integer i : obsMissed) {
            System.out.println(i);
        }
        int actual = numObs - obsMissed.size();
        System.out.println("Mario got " + actual + " of the dangerous " +
                "obstacles.");
    }
    
   
}
