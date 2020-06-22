package proj5;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class WordCounterTest {

    private WordCounter wC;

    @Before
    public void setUp() throws Exception {
        wC = new WordCounter();
    }

    @Test
    public void testWordCounter_std(){
        wC.findFrequencies("src/proj5/lamb.txt");
        System.out.println(wC);
    }

    @Test
    public void testWordCounter_std2(){
        wC.findFrequencies("src/proj5/test1.txt");
        assertEquals("a: 4\nb: 3\nc: 3\nhello: 3\nhi: 3\n", wC.toString());
    }

    @Test
    public void testWordCounter_getFreq(){
        wC.findFrequencies("src/proj5/test1.txt");
        assertEquals(0, wC.getFrequency("plane"));
    }
}
