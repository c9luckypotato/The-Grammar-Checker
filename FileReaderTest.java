package proj5;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class FileReaderTest {
    @Rule
    public Timeout timeout = Timeout.millis(100);

    private LineReader lR;

    private LineReader lR2;

    @Before
    public void setUp() throws Exception {
        lR = new LineReader("src/proj5/lamb.txt", " ");
        lR2 = new LineReader("src/proj5/smallThesaurus.txt", ",");
    }

//    @After
//    public void tearDown() throws Exception {
//        lR = null;
//        lR2 = null;
//    }

    @Test
    public void testLineReader_std(){
        String[] s = lR.getNextLine();;
        while (s != null) {
            for (String t : s) {
                System.out.println(t);
            }
            s = lR.getNextLine();
        }
    }
}
