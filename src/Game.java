/**
 * Represents the game logic for Tic Tac Toe.
 *
 * @author Widmer Leo
 */
public class Game {

    private int roundsPlayed;
    private Board board; 

    /**
     * Constructs a new instance of a Tic Tac Toe game.
     * 
     * @param board the board object that the game is played on
     */
    public Game(Board board) {
        roundsPlayed = 0;
        this.board = board;
    }

    /**
     * Starts a new game by resetting the board and rounds played.
     */
    public void startNewGame() {
        roundsPlayed = 0;
        
        for( int i = 0; i < 3; i++ ) {
            board.setField(0, i, 0);
            board.setField(1, i, 0);
            board.setField(2, i, 0);
        }
    }

    /**
     * Checks if there is a winner on the board.
     *
     * @return true if there is a winner, false otherwise
     */
    public boolean checkWinner() {
        
        if(roundsPlayed < 5) { // Winning before the 5th turn is impossible
            return false; 
        }

        for(int i = 0; i < 3; i++) { // Check rows and columns
            if(isWinningLine(board.getField(i, 0), board.getField(i, 1), board.getField(i, 2))) {
                return true;
            }
            if(isWinningLine(board.getField(0, i), board.getField(1, i), board.getField(2, i))) {
                return true;
            }
        }
        // Check diagonals
        if(isWinningLine(board.getField(0, 0), board.getField(1, 1), board.getField(2, 2))) {
            return true;
        }
        return isWinningLine(board.getField(2, 0), board.getField(1, 1), board.getField(0, 2));
    }

    /**
    * Checks if three given fields result in a win.
    *
    * @param field1 first field
    * @param field2 second field
    * @param field3 third field
    * @return true if all fields match and are not 0, false otherwise
    */
    private boolean isWinningLine(int field1, int field2, int field3) {
        return (field1 != 0 && field1 == field2 && field1 == field3);
    }

    /**
     * Increases the round counter by 1
     *
     */
    public void increaseRoundsPlayed() {
        roundsPlayed++;
    }

    /**
     * Returns roundsPlayed.
     *
     * @return returns roundsPlayed
     */
    public int getRoundsPlayed() {
        return roundsPlayed;
    }
}