import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class MarkdownParseTest {
    static ArrayList<String> test; 

    @Before 
    public void setUp() {
        test = new ArrayList<String>();
        test.add("https://something.com");
        test.add ("some-thing.html");
    }

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void getLinkstest() throws IOException{
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("https://www.google.com/");
        expected.add("https://www.image.com/");
        assertEquals(expected, links);
    }
}
