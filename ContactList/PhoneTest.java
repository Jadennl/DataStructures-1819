import org.junit.*;
import java.util.*;
import static org.junit.Assert.*;

public class PhoneTest {
    private List<Contact> c1,c2,c3;
    private List<List<Contact>> lists = new ArrayList<>();
    
    @Before
    public void setUp() throws Exception {
        c1 = new ArrayList<>();
        c2 = new Stack<>();
        c3 = new LinkedList<>();
        c1.add(new Contact("Shannan Mcmanus", "7431726425"));
        c2.add(new Contact("Bodhi Morin", "3557238158"));
        c3.add(new Contact("Angela Bravo", "8150976057"));
        c1.add(new Contact("Rueben Bailey", "4620830487"));
        c2.add(new Contact("Reegan Sandoval", "7056432982"));
        c3.add(new Contact("Alena Reyes", "6185357412"));
        c1.add(new Contact("Alaina Snider", "5797293476"));
        c2.add(new Contact("Ashwin House", "9658182598"));
        c3.add(new Contact("Marek Emery", "4535406393"));
        c1.add(new Contact("Alessia Noel", "5932860778"));
        c2.add(new Contact("Blythe Millar", "8591273644"));
        c3.add(new Contact("Shivam Hyde", "3523989887"));
        c1.add(new Contact("Tommie Odom", "1416880212"));
        c2.add(new Contact("Dylan Hall", "8619680397"));
        c3.add(new Contact("Mirza Bellamy", "2337564313"));
        c1.add(new Contact("Eathan Tomlinson", "1298589616"));
        c2.add(new Contact("Reegan Sandoval", "7405188109"));
        c3.add(new Contact("Chandni Wagstaff", "1298589616"));
        c1.add(new Contact("Cinar Sykes", "9489521506"));
        c2.add(new Contact("Maison Appleton", "7273207072"));
        c3.add(new Contact("Khaleesi Villarreal", "9022618593"));
        c1.add(new Contact("Jevon Wade", "7660707400"));
        c2.add(new Contact("Destiny Milner", "9763432622"));
        c3.add(new Contact("Alessia Noel", "5932860778"));
        c1.add(new Contact("Regina Pearce", "7073059778"));
        c2.add(new Contact("Leo Cooley", "6973572916"));
        c3.add(new Contact("Alaina Snider", "5797293476"));
        c1.add(new Contact("Eathan Tomlinson", "8862723507"));
        c2.add(new Contact("Talia Winter", "6289412006"));
        c3.add(new Contact("Mirza Bellamy", "2337564313"));
        c1.add(new Contact("Vincent Pope", "1895254918"));
        c2.add(new Contact("Blythe Millar", "7252368867"));
        c3.add(new Contact("Kayley Lindsey", "6829669726"));
        c1.add(new Contact("Amara O'Moore", "2449830348"));
        c2.add(new Contact("Sultan Ali", "5893064206"));
        c3.add(new Contact("Lillia Houghton", "5245632344"));
        c1.add(new Contact("Hadiya Schroeder", "1298589616"));
        c2.add(new Contact("Shivam Hyde", "4496603083"));
        c3.add(new Contact("Naya Graves", "8304858646"));
        c1.add(new Contact("Leo Cooley", "3214631456"));
        c2.add(new Contact("Talia Winter", "6289412006"));
        c3.add(new Contact("Darcey Trujillo", "3327385708"));
        c1.add(new Contact("Ruby-Leigh Vu", "9135161880"));
        c2.add(new Contact("Lillia Houghton", "5801264237"));
        c3.add(new Contact("Penny Rollins", "4408998692"));
        c1.add(new Contact("Maison Appleton", "7273207072"));
        c2.add(new Contact("Renee Mccarthy", "3300464975"));
        c3.add(new Contact("Debbie Noel", "5932860778"));
        c1.add(new Contact("Chandni Wagstaff", "9022618593"));
        c2.add(new Contact("Frances Valentine", "1199344511"));
        c3.add(new Contact("Renzo Meadows", "1922143461"));
        c1.add(new Contact("Enzo Chapman", "4185674706"));
        c2.add(new Contact("Emeli Davenport", "9010509849"));
        c3.add(new Contact("Klara Daugherty", "3557238158"));
        c1.add(new Contact("Abi Rennie", "9111208716"));
        c2.add(new Contact("Elsie-May Devlin", "6973572916"));
        c3.add(new Contact("Brian Garrett", "1040739667"));
        c1.add(new Contact("Beau O'Moore", "2449830348"));
        c2.add(new Contact("Umer Tyson", "8653074815"));
        c3.add(new Contact("Ilyas Foster", "3500003349"));
        c1.add(new Contact("Lillie-Mae Matthams", "1406143950"));
        c2.add(new Contact("Giorgia Eaton", "2101554762"));
        c3.add(new Contact("Saif Frost", "2284827483"));
        c1.add(new Contact("Joshua Pittman", "3409784294"));
        c2.add(new Contact("Ollie Craft", "4258605022"));
        c3.add(new Contact("Marek Emery", "6893962136"));
        c1.add(new Contact("Youssef Quintana", "8875718515"));
        c2.add(new Contact("Brian Garrett", "1040739667"));
        c3.add(new Contact("Alena Reyes", "9600750950"));
        lists.add( c1 );
        lists.add( c2 );
        lists.add( c3 );
    }
    
    @After
    public void tearDown() throws Exception {
        c1 = null;
        c2 = null;
        c3 = null;
        lists = null;
    }
    
    @Test
    public void mergeContacts() {
        Phone p = new Phone();
        TreeSet<Contact> c = p.mergeContacts(lists);
        assertEquals( 63, c.size() );
    }
}