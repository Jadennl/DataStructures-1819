import java.sql.SQLSyntaxErrorException;
import java.util.Scanner;

public class CircularArray {
    private static int time;
    private int hour;
    private String hours[] = {"1 o clock ", "2 o clock", "3 o clock", "4 o clock",
            "5 o clock", "6 o clock",
            "7 o clock", "8 o clock",
            "9 o clock", "10 o clock", "11 o clock", "12 o clock"};
    private final int hourMult = 12;
    
    public CircularArray( int hour ) {
        if( hour == 0) {
            this.hour = hourMult;
        }
        else {
            this.hour = hour;
        }
    }
    
    public static void main( String[] args ) {
        Scanner s = new Scanner( System.in );
        System.out.println( "What is the time?" );
        time = s.nextInt();
        CircularArray clock = new CircularArray( time );
        
        do {
            System.out.println( "Time: " + clock.getHour() );
            System.out.println( "Increment time: " );
            int time = s.nextInt();
            clock.increaseHour( time );
        } while ( true );
        
    }
    
    public String getHour() {
        if (hour == 0) {
            hour = hourMult;
        }
        return hours[hour - 1];
    }
    
    public void increaseHour( int amt ) {
        boolean neg = false;
        if ( amt < 0 ) neg = true;
        if ( amt >= hourMult || amt <= -hourMult ) {
            amt = Math.abs( amt ) % hourMult;
            if ( neg ) amt *= -1;
        }
    
        if ( !neg ) {
            hour += amt;
            if ( hour > hourMult ) {
                hour = hour % hourMult;
            }
        } else {
            hour +=  amt;
            if ( hour > hourMult ) {
                hour = hour % hourMult;
            }
        }
    }
}
