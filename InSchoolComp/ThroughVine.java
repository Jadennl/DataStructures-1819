import java.util.*;

public class ThroughVine {
    
    public static void main( String args[] ) {
        List<Person> people = new ArrayList<>();
        Scanner in = new Scanner( System.in );
        int numPeople, numConnect, numDays;
        numPeople = in.nextInt();
        numConnect = in.nextInt();
        numDays = in.nextInt();
        
        for (int i = 0; i < numPeople; i++) {
            people.add(new Person(in.next(), in.nextInt()));
        }
        for (int i = 0; i < numConnect; i++);
    }
    
    static class Person {
        private String name;
        private int skept;
        private Map<String, Integer> rumor;
        public Person(String n, int s) {
            name = n;
            skept = s;
        }
    }
}
