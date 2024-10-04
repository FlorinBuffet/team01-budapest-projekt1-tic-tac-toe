import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for the Board class.
 * Contains unit tests to verify the functionality of the Board class.
 *
 * @author
 * @version 1.0
 */

public class BoardTest {
    /**
     * Tests the setField method to ensure it correctly sets a field on the board.
     */
    @Test
    public void testSetField() {
        Board board = new Board();
        board.setField(1,2,1);
        assertEquals(1, board.getField(1,2));
    }

    /**
     * Tests the setField method to ensure it throws an IllegalArgumentException
     * when the row or column index is out of bounds.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetFieldOutOfBounds() {
        // Test implementation
    }

    /**
     * Tests the setField method to ensure it throws an IllegalArgumentException
     * when an invalid mark value is provided.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetFieldInvalidMark() {
        // Test implementation
    }

    /**
     * Tests the setField method to ensure it throws an IllegalArgumentException
     * when attempting to overwrite an already marked field.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetFieldAlreadyMarked() {
        // Test implementation
    }

    /**
     * Tests the getField method to ensure it correctly retrieves the mark of a field on the board.
     */
    @Test
    public void testGetField() {
        // Test implementation
    }

    /**
     * Tests the getField method to ensure it throws an IllegalArgumentException
     * when the row or column index is out of bounds.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetFieldOutOfBounds() {
        // Test implementation
    }
}
