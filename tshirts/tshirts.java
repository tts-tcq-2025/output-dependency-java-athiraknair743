import static org.junit.Assert.*;
import org.junit.Test;

public class TshirtsTest {

    @Test
    public void testTshirtSizes() {
        // Existing cases (should still pass)
        assertEquals("S", Tshirts.size(37));
        assertEquals("M", Tshirts.size(40));
        assertEquals("L", Tshirts.size(43));

        // Boundary case — currently buggy
        assertEquals("M", Tshirts.size(38)); 
        // This will FAIL with current code because size(38) returns "L"
    }
}
