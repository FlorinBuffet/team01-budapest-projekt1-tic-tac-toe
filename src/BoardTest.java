import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

/**
 * Test class for the Board class.
 * Contains unit tests to verify the functionality of the Board class.
 *
 * @author Midas Pavia Dominguez and Florin Buffet
 * @version 1.5
 */

public class BoardTest {

    private Board board;

    /**
     * Sets up the test environment before each test.
     * Initializes the Board and Game objects.
     */
    @Before
    public void setup() {
        board = new Board();
    }

    /**
     * Test 1
     * Tests the setField method to ensure it correctly sets and gets a field on the
     * board.
     */
    @Test
    public void testSetFieldGetField1() {
        board.setField(1, 1, 0);
        assertEquals(0, board.getField(1, 1));
    }

    /**
     * Test 2
     * Tests the setField method to ensure it correctly sets and gets a field on the
     * board.
     */
    @Test
    public void testSetFieldGetField2() {
        board.setField(1, 1, 1);
        assertEquals(1, board.getField(1, 1));
    }

    /**
     * Test 3
     * Tests the setField method to ensure it correctly sets and gets a field on the
     * board.
     */
    @Test
    public void testSetFieldGetField3() {
        board.setField(1, 1, 2);
        assertEquals(2, board.getField(1, 1));
    }

    /**
     * Test 4
     * Tests the setField method to ensure it correctly fails to set a field on the
     * board.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetField1() {
        board.setField(1, 1, -1);
    }

    /**
     * Test 5
     * Tests the setField method to ensure it correctly fails to set a field on the
     * board.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetField2() {
        board.setField(1, 1, 3);
    }

    /**
     * Test 6
     * Tests the setField method to ensure it correctly fails to set a field on the
     * board.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetField3() {
        board.setField(0, 6, 1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetField4() {
        board.setField(0, -1, 1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetField5() {
        board.setField(6, 0, 1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetField6() {
        board.setField(-1, 0, 1);
    }

    /**
     * Test 7
     * Tests the getField method to ensure it correctly fails to get a field off the
     * board.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetField1() {
        board.getField(0, 6);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetField2() {
        board.getField(0, -1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetField3() {
        board.getField(6, 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testGetField4() {
        board.getField(-1, 0);
    }

    /**
     * Test 8
     * Tests the isOccupied method to ensure it correctly checks if a field is
     * occupied.
     */
    @Test
    public void testIsOccupied1() {
        board.setField(0, 0, 1);
        assertTrue(board.isOccupied(0, 0));
    }

    /**
     * Test 9
     * Tests the isOccupied method to ensure it correctly checks if a field is
     * occupied.
     */
    @Test
    public void testIsOccupied2() {
        assertFalse(board.isOccupied(0, 0));
    }

    /**
     * Test 10
     * Tests the isOccupied method to ensure it correctly checks if a field is
     * occupied.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testIsOccupied3() {
        board.isOccupied(6, 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIsOccupied4() {
        board.isOccupied(-1, 0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIsOccupied5() {
        board.isOccupied(0, 6);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testIsOccupied6() {
        board.isOccupied(0, -1);
    }
}