import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the Board class.
 * Contains unit tests to verify the functionality of the Board class.
 *
 * @author Midas Pavia Dominguez
 * @version 1.4
 */

public class BoardTest {
    /**
     * Tests the setField method to ensure it correctly sets a field on the board.
     */
    @Test
    public void testSetField() {
        Board board = new Board();
        board.setField(1, 2, 1);
        board.setField(0, 0, 2);
        assertEquals(1, board.getField(1, 2));
        assertEquals(2, board.getField(0, 0));
    }

    /**
     * Tests the getField method to ensure it correctly retrieves the mark of a field on the board.
     */
    @Test
    public void testGetField() {
        Board board = new Board();
        board.setField(1, 2, 1);
        board.setField(0, 0, 2);
        assertEquals(1, board.getField(1, 2)); //ASCII value of 'X'
        assertEquals(2, board.getField(0, 0)); //ASCII value of 'Y'
    }

    /**
     * Tests the isOccupied method to ensure it correctly checks if a field is occupied.
     */
    @Test
    public void testIsOccupied() {
        Board board = new Board();
        board.setField(1, 2, 1);
        assertTrue(board.isOccupied(1, 2));
        assertFalse(board.isOccupied(0, 0));
    }
}
