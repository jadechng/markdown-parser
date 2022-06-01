import static org.junit.Assert.*;
import org.junit.*;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;


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
        Path fileName = Path.of("failedfile2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        //expected.add("https://www.google.com/");
        //expected.add("https://www.image.com/");
        assertEquals(expected, links);
    }

    @Test
    public void getLinkstestOne() throws IOException{
        Path fileName = Path.of("snippet1.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("`google.com");
        expected.add("google.com");
        expected.add("ucsd.edu");
        assertEquals(expected, links);
    }

    @Test
    public void getLinkstestTwo() throws IOException{
        Path fileName = Path.of("snippet2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("a.com");
        expected.add("a.com(())");
        expected.add("example.com");
        assertEquals(expected, links);
    }
    
    @Test
    public void getLinkstestThree() throws IOException{
        Path fileName = Path.of("snippet3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        assertEquals(expected, links);
    }



}
