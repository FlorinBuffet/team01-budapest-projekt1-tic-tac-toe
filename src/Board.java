/**
 * Represents the game board for Tic Tac Toe.
 *
 * @author Chiara Baer
 */
public class Board {
    /**
     * The game board represented as a 2D char array.
     * ' ' = empty, 'X' = player X, 'O' = player O
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
     * Error messages are printed if the mark is not 'X' or 'O', or if the field is already marked and an overwrite is attempted.
     * Else it sets the board field to X or O if else
     */
    public void setField(int row, int col, int mark) throws IllegalArgumentException{
        if(mark < 0 || mark > 2) {
            throw new IllegalArgumentException("This field value does not exist");
        }
        if(row<0 || row>= board.length || col<0 || col>= board[0].length) {
            throw new IllegalArgumentException("This field does not exist");
        }
        board[row][col] = mark;

    }
    /**
     * Checks if a specific field on the board is occupied.
     *
     * @param row the row index of the field
     * @param col the column index of the field
     * @return true if the field is occupied, false otherwise
     */
    public boolean isOccupied (int row, int col) throws IllegalArgumentException{
        if(row<0 || row>= board.length || col<0 || col>= board[0].length) {
            throw new IllegalArgumentException("This field does not exist");
        }
        if(board[row][col] !=0) {
            return true;
        }
        return false;
    }

    /**
     * Gets the mark of a specific field on the board.
     *
     * @param row the row index of the field
     * @param col the column index of the field
     * @return the mark of the field (0 = ' ', 1 = 'X', 2 = 'O')
     * Error message is printed if row or column is out of bounds.
     */
    public int getField(int row, int col) throws IllegalArgumentException{
        if(row<0 || row>= board.length || col<0 || col>= board[0].length) {
            throw new IllegalArgumentException("This field does not exist");
        }
        return board[row][col];
    }
}