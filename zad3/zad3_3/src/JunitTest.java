import org.junit.*;

import static org.junit.Assert.*;

public class JunitTest {
    MyCustomList<Integer> testObject;

    @Before
    public void setUp() {
        testObject = new MyCustomList<>();
    }

    @Test
    public void testAddition() {
        assertEquals(0,testObject.size());
        testObject.add(0);
        assertEquals(1,testObject.size());
    }

    @Test
    public void testGetting() {
        testObject.add(1);
        assertEquals(1,(int)testObject.get(0));
    }
    @Test
    public void testBadGetting() {
        testObject.add(1);
        assertNull(testObject.get(10));
        assertNull(testObject.get(-1));
    }

    @Test
    public void testRemoving() {
        testObject.add(1);
        testObject.add(2);
        testObject.remove(1);
        assertEquals(2, (int)testObject.get(0));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testBadRemoving() {
        testObject.remove(2);
    }

    @Test
    public void testRemovingIndex() {
        testObject.add(1);
        testObject.add(2);
        testObject.removeIndex(0);
        assertEquals(2,(int)testObject.get(0));
        assertEquals(1,testObject.size());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testBadRemovingIndexEmptyTable() {
        testObject.removeIndex(2);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testBadRemovingIndex() {
        testObject.add(1);
        testObject.removeIndex(2);
    }

    @Test
    public void testFinding() {
        testObject.add(1);
        testObject.add(3);
        assertEquals(-1,testObject.findFirst(2));
        assertEquals(0,testObject.findFirst(1));
    }


    @Test
    public void testReplacing() {
        testObject.add(1);
        testObject.add(2);
        assertFalse(testObject.replace(2,3));
        assertFalse(testObject.replace(-1,0));
    }

    @Test
    public void testReplacing2() {
        testObject.add(1);
        testObject.add(2);
        assertTrue(testObject.replace(0, 1));
        assertEquals(2, (int) testObject.get(0));
        assertEquals(1, (int) testObject.get(1));
    }
}
