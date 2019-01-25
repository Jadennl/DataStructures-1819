import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlReader {
    public static void main( String[] args ) {
        String contents = null;
        try {
            contents = getFileContents( "XmlReader/sample.xml" );
            String answer = xmlParse( contents );
            writeFileContents( "./src/translateStrings.txt", answer );
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        
    }
    
    private static String getFileContents( String filename ) throws IOException {
        return new String( Files.readAllBytes( Paths.get( filename ) ) );
    }
    
    private static void writeFileContents( String filename, String data ) throws IOException {
        FileWriter fw = new FileWriter( new File( filename ) );
        fw.write( data );
        fw.close();
    }
    
    private static String xmlParse( String xml ) {
        Queue<String> q = new LinkedList<>();
        Pattern p = Pattern.compile( "<.+\"([0-9A-Za-z_]+)\">(([0-9A-Za-z_]+ " +
                "?)+)<.+>" );
        Matcher m = p.matcher( xml );
        while ( !m.hitEnd() ) {
            q.add( m.group(0) );
        }
        return "";
    }
    
}
