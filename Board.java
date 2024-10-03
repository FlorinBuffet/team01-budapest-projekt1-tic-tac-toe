/**
 * Represents the game board for Tic Tac Toe.
 *
 * @author Chiara Baer
 * @version 1.0
 */
public class Board {
    /**
     * The game board represented as a 2D array.
     * 0 = ' ', 1 = 'X', 2 = 'O'
     */
    private int[][] board;

    /**
     * Constructor of Board, should create board as 3x3.
     */
    public Board(){

    }

    /**
     * Sets the status of a specific field on the board.
     *
     * @param row the row index of the field
     * @param col the column index of the field
     * @param status the status to set (0 = ' ', 1 = 'X', 2 = 'O')
     */
    public void setField(int row, int col, int status) {
        // TODO: Implement this method
    }

    /**
     * Gets the status of a specific field on the board.
     *
     * @param row the row index of the field
     * @param col the column index of the field
     * @return the status of the field (0 = ' ', 1 = 'X', 2 = 'O')
     */
    public int getField(int row, int col) {
        // TODO: Implement this method
        return 0; // Placeholder return value
    }
}