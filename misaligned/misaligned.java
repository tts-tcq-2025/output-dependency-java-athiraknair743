import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

public class MisalignedTest {

    @Test
    public void testColorMapping() {
        // Capture the printed output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the buggy method
        Misaligned.printColorMap();

        // Restore standard output
        System.setOut(System.out);

        String[] majorColors = {"White", "Red", "Black", "Yellow", "Violet"};
        String[] minorColors = {"Blue", "Orange", "Green", "Brown", "Slate"};

        // Split printed lines
        String[] lines = outContent.toString().trim().split("\n");

        // Check that each line matches the expected major and minor colors
        int lineIndex = 0;
        for (int i = 0; i < majorColors.length; i++) {
            for (int j = 0; j < minorColors.length; j++) {
                String expected = String.format("%d | %s | %s", lineIndex, majorColors[i], minorColors[j]);
                assertEquals("Mismatch at index " + lineIndex, expected, lines[lineIndex].trim());
                lineIndex++;
            }
        }
    }
}
