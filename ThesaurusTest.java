package proj5;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class ThesaurusTest {
    private Thesaurus thesaurus;

    @Before
    public void setUp() throws Exception {
        thesaurus = new Thesaurus("src/proj5/smallThesaurus.txt");
    }

    @Test
    public void testThesaurus_insert(){
//        assertEquals();
        thesaurus = new Thesaurus();
        String[] s = {"a", "b", "c", "d"};
        String s1 = "alpha";
        thesaurus.insert(s1,s);
        assertEquals("alpha - {a, b, c, d}\n", thesaurus.toString());
        s1 = "aaa";
        thesaurus.insert(s1,s);
        assertEquals("aaa - {a, b, c, d}\nalpha - {a, b, c, d}\n", thesaurus.toString());
        String[] s2 = {"h", "f", "g"};
        thesaurus.insert(s1, s2);
        assertEquals("aaa - {a, b, c, d, h, f, g}\nalpha - {a, b, c, d}\n", thesaurus.toString());
        thesaurus.insert("c", s);
        thesaurus.insert("b", s);
        assertEquals("aaa - {a, b, c, d, h, f, g}\nalpha - {a, b, c, d}\nb - {a, b, c, d}\nc - {a, b, c, d}\n", thesaurus.toString());
    }

    @Test
    public void testThesaurus_delete(){
        thesaurus = new Thesaurus();
        String[] s = {"a", "b", "c", "d"};
        String s1 = "alpha";
        thesaurus.insert(s1,s);
        assertEquals("alpha - {a, b, c, d}\n", thesaurus.toString());
        s1 = "aaa";
        thesaurus.insert(s1,s);
        assertEquals("aaa - {a, b, c, d}\nalpha - {a, b, c, d}\n", thesaurus.toString());
        String[] s2 = {"h", "f", "g"};
        thesaurus.insert(s1, s2);
        assertEquals("aaa - {a, b, c, d, h, f, g}\nalpha - {a, b, c, d}\n", thesaurus.toString());
        thesaurus.delete("beta");
        assertEquals("aaa - {a, b, c, d, h, f, g}\nalpha - {a, b, c, d}\n", thesaurus.toString());
        thesaurus.delete("aaa");
        assertEquals("alpha - {a, b, c, d}\n", thesaurus.toString());
    }

    @Test
    public void testThesaurus_std(){
        System.out.println(thesaurus);
    }

    @Test
    public void testThesaurus_getSyn(){
        String s = thesaurus.getSynonymFor("very");
        System.out.println(s);
    }
}
