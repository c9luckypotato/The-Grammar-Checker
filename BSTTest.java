package proj5;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class BSTTest {


    private BST<Integer, Integer> bst;
    private BST<String, LinkedList<String>>bst2;

    @Before
    public void setUp() throws Exception {
        bst = new BST();
        bst2 = new BST();
    }

    @After
    public void tearDown() throws Exception {
        bst = null;
        bst2 = null;
    }


    @Test
    public void testBST(){
        LinkedList<String> ll = new LinkedList<>();
        bst2.insert("H", ll);
        assertEquals("H - {}\n", bst2.toString());
        bst2.insert("C", ll);
        assertEquals("C - {}\nH - {}\n", bst2.toString());
        bst2.insert("Z",ll);
        assertEquals("C - {}\nH - {}\nZ - {}\n", bst2.toString());
        bst2.insert("B",ll);
        assertEquals("B - {}\nC - {}\nH - {}\nZ - {}\n", bst2.toString());
        bst2.remove("Z");
        assertEquals("B - {}\nC - {}\nH - {}\n", bst2.toString());
        bst2.insert("Z",ll);
        assertEquals("B - {}\nC - {}\nH - {}\nZ - {}\n", bst2.toString());
        bst2.remove("C");
        assertEquals("B - {}\nH - {}\nZ - {}\n", bst2.toString());


    }


    @Test
    public void testSetDataAtKey(){
        bst.insert(5, 5);
        assertEquals(bst.toString(), "5 ");
        bst.insert(4, 4);
        bst.insert(3, 3);
        bst.insert(2, 2);
        bst.insert(1, 1);
        assertEquals("1 2 3 4 5 ", bst.toString());
        bst.setDataAtKey(3, 6);
        assertEquals("1 2 6 4 5 ", bst.toString());
        bst.setDataAtKey(1, 5);
        bst.setDataAtKey(2, 4);
        bst.setDataAtKey(4, 2);
        bst.setDataAtKey(5, 1);
        assertEquals("5 4 6 2 1 ", bst.toString());
    }

    @Test
    public void testBST_std(){
        bst.insert(75, 75);
        assertEquals(bst.toString(), "75 ");
        bst.insert(40, 40);
        bst.insert(22, 22);
        bst.insert(16, 16);
        bst.insert(14, 14);
        assertEquals(bst.toString(), "14 16 22 40 75 ");
        bst.insert(20, 20);
        bst.insert(100, 100);
        bst.insert(92, 92);
        bst.insert(95, 95);
        assertEquals(bst.toString(), "14 16 20 22 40 75 92 95 100 ");
        bst.insert(1, 1);
        assertEquals(bst.size(), 10);
        bst.insert(1, 1);
        assertEquals(bst.toString(), "1 1 14 16 20 22 40 75 92 95 100 ");
        assertEquals(bst.size(), 11);
        assertEquals(bst.find(99), null);
        assertEquals(bst.find(100), new Integer(100));
        assertEquals(bst.find(16), new Integer(16));
        assertEquals(bst.find(75), new Integer(75));
        assertEquals(bst.remove(16), new Integer(16));
        assertEquals(bst.toString(), "1 1 14 20 22 40 75 92 95 100 ");
        assertEquals(bst.remove(15), null);
        assertEquals(bst.toString(), "1 1 14 20 22 40 75 92 95 100 ");
        assertEquals(bst.size(), 10);
        assertEquals(bst.remove(33), null);
        assertEquals(bst.size(), 10);
        assertEquals(bst.remove(75), new Integer(75));
        assertEquals(bst.toString(), "1 1 14 20 22 40 92 95 100 ");
        assertEquals(bst.size(), 9);

    }



    @Test
    public void testRemove(){
        bst.insert(5, 5);
        assertEquals(bst.toString(), "5 ");
        bst.insert(4, 4);
        bst.insert(3, 3);
        bst.insert(2, 2);
        bst.insert(1, 1);
        assertEquals("1 2 3 4 5 ", bst.toString());
        bst.remove(5);
        assertEquals("1 2 3 4 ", bst.toString());
        bst.remove(3);
        assertEquals("1 2 4 ", bst.toString());
        bst.insert(6, 6);
        assertEquals("1 2 4 6 ", bst.toString());
    }
}
