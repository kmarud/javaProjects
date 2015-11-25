import org.junit.*;


import static org.junit.Assert.*;

public class JunitTest {
    MyCustomList<Integer> testObject;

    @Before
    public void setUp() {
        testObject = new MyCustomList<>();
       // System.out.println("@Before - setUp");
    }

    @Test
    public void testAddition() {            //ok
        assertEquals(0,testObject.size());
        testObject.add(0);
        assertEquals(1,testObject.size());
    }

    @Test
    public void testGetting() {
        //assertEquals(0,testObject.size());
        testObject.add(1);
        assertEquals(1,(int)testObject.get(0));
    }
    @Test
    public void testBadGetting() {
        //assertEquals(0,testObject.size());
        testObject.add(1);
        assertNull(testObject.get(1));
    }

    @Test
    public void testRemovingIndex() {
        //assertEquals(0,testObject.size());
        testObject.add(1);
        testObject.add(2);
        testObject.removeIndex(0);
        assertEquals(2,(int)testObject.get(0));
        assertEquals(1,testObject.size());
    }


    @Test
    public void testReplacing() {
        testObject.add(1);
        testObject.add(2);
        assertFalse(testObject.replace(2,3));
        assertFalse(testObject.replace(-1,0));
        assertTrue(testObject.replace(0,1));
    }

    @Test
    public void testReplacing2() {
        testObject.add(1);
        testObject.add(2);
        testObject.replace(0,1);
        assertEquals(2,(int)testObject.get(0));
        assertEquals(1,(int)testObject.get(1));
    }

    @Test
    public void testFinding() {
        testObject.add(1);
        testObject.add(3);
        assertEquals(-1,testObject.findFirst(2));
        assertEquals(0,testObject.findFirst(1));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoving() {
        testObject.remove(2);
    }



   /* @Ignore("not yet")
    @Test
    public void returnTest1() {
        testObject.add(234);
        assertEquals(null,testObject.get(3));
        //System.out.println("@Test - testEmptyCollection");
    }*/
}
