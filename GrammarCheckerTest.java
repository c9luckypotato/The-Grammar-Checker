package proj5;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class GrammarCheckerTest {
    private GrammarChecker Gc;

    @Before
    public void setUp() throws Exception {
        Gc = new GrammarChecker("src/proj5/bigThesaurus.txt", 1);
    }

    @Test
    public void testWordCounter_std(){
        Gc.improveGrammar("src/proj5/lamb.txt");
//        System.out.println(wC);
        String w = "Wo,d";
        Character c = w.charAt(0);
        assertEquals(true, c.isLetter(c));
        assertEquals(true, c.isUpperCase(c));

        c = w.charAt(1);
        assertEquals(true, c.isLetter(c));
        assertEquals(false, c.isUpperCase(c));
        c = w.charAt(2);
        assertEquals(false, c.isLetter(c));
        assertEquals(false, c.isUpperCase(c));

        Gc.improveGrammar("src/proj5/apartment.txt");
    }
}
