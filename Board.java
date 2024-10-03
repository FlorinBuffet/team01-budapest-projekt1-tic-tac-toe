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
     * Constructs a new Board instance, initializing a 3x3 Tic Tac Toe board.
     * Each cell of the board is set to 0, indicating that it is empty.
     * The board is used to keep track of the marks 'X' and 'O' placed by the players,
     * with 0 representing an empty cell, 1 representing 'X', and 2 representing 'O'.
     */
    public Board() {
        board = new int[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = 0;
            }
        }
    }

    /**
     * Sets the mark of a specific field on the board.
     *
     * @param row the row index of the field
     * @param col the column index of the field
     * @param mark the symbol to set (0 = ' ', 1 = 'X', 2 = 'O')
     * @throws IllegalArgumentException if the row or column index is out of bounds,
     * if the mark is not 1 or 2, or if the field is already marked and an overwrite is attempted.
     */
    public void setField(int row, int col, int mark) {
        if(row<0 || row>= board.length || col<0 || col>= board.length[0]) {
            throw new IllegalArrugmentException("Row or column index out of bounds");
        }
        if(mark !=1 && mark !=2) {
            throw new IllegalArgumentException("Invalid mark value. Only use 1 for X or 2 for O.")
        }

        if(board[row][col] != 0) {
            throw new IlegalArgumentExcpetion("Field is already marked. It's not allowed to overwrite.")
        }
    }

    /**
     * Gets the mark of a specific field on the board.
     *
     * @param row the row index of the field
     * @param col the column index of the field
     * @return the mark of the field (0 = ' ', 1 = 'X', 2 = 'O')
     * @throws IllegalArgumentException if the row or column index is out of bounds
     */
    public int getField(int row, int col) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            throw new IllegalArgumentException("Row or column index out of bounds");
        }
        return board[row][col];
    }
}