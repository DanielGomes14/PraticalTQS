/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * @author ico0
 */
public class SetOfNaturalsTest {
    private SetOfNaturals setA;
    private SetOfNaturals setB;
    private SetOfNaturals setC;
    private SetOfNaturals setD;

    @BeforeEach
    public void setUp() {
        setA = new SetOfNaturals();
        setB = SetOfNaturals.fromArray(new int[]{10, 20, 30, 40, 50, 60});

        setC = new SetOfNaturals();
        for (int i = 5; i < 50; i++) {
            setC.add(i * 10);
        }
        setD = SetOfNaturals.fromArray(new int[]{30, 40, 50, 60, 10, 20});
    }

    @AfterEach
    public void tearDown() {
        setA = setB = setC = setD = null;
    }

    @Test
    public void testAddElement() {

        setA.add(99);
        assertTrue(setA.contains(99), "add: added element not found in set.");
        assertEquals(1, setA.size());

        setB.add(11);
        assertTrue(setB.contains(11), "add: added element not found in set.");
        assertEquals(7, setB.size(), "add: elements count not as expected.");
    }

    @Test
    public void testAddBadArray() {
        int[] elems = new int[]{10, 20, -30};

        // must fail with exception
        assertThrows(IllegalArgumentException.class, () -> setA.add(elems));
    }

    // Tests Added:

    @Test
    // Verify if a valid array contains duplicates for an existent set
    public void testAddDuplicateArray() {
        int[] arr1 = {10, 20, 30};

        assertThrows(IllegalArgumentException.class, () -> setB.add(arr1));
    }

    @Test
    //Verify if the size method returns the correct numbers of elements
    public  void testSize(){
        assertEquals(6,setB.size(),
                () -> "size of the set is not correct");
    }

    @Test
    //Verify if the Set rejects to add any duplicate element to it.
    public void testAddDuplicateElem() {
        assertThrows(IllegalArgumentException.class, () -> setC.add(50));

    }

    @Test
    //Verify if two Sets that don't have any common element do not intersect each other
    public void testIntersectForNoIntersection() {
        assertFalse(setA.intersects(setB), "no intersection but was reported as existing");

    }

    @Test
    //Reverse Case of the previous unitary test.
    public void testIntersectDifferentSets() {
        assertTrue(setB.intersects(setC), "intersection exists, but was reported as non-existing");

    }





}
