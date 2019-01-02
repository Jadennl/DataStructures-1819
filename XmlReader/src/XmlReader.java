/*
import java.io.IOException;
import java.util.*;
public class XmlReader {
    public static void main( String [] args ) {
        String contents = getFileContents( "./src/strings.xml" );
       // String answer = do a lot of work before getting here;
        writeFileContents("./src/translateStrings.txt");
    }
    
    private static String getFileContents( String filename )
            throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
    
    private static void writeFileContents( String filename, String data )
            throws IOException {
        FileWriter fw = new FileWriter(new File(filename));
        fw.write( data );
        fw.close();
    }
    
    private static String xmlParse(String xml) {
        Queue<String> q = new LinkedList<>();
        return "";
    }
    
}
*/
