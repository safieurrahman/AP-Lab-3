package Lab;
import static org.junit.Assert.*;

public class Test {
           
    public void testGetName() {
        Record rec = new Record("Safie", "Hello", 1);
        String temp = "Safie";
        String result = rec.getName();
        assertEquals(temp, result);
       
    }

    
    public void testGetNotes() {
        Record rec = new Record("Safie", "Hello", 1);
        String temp = "Hello";
        String result = rec.getNotes();
        assertEquals(temp, result);
    }
    
}
