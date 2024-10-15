/**
 * Initialises and starts the Tic Tac Toe game
 *
 * @author Widmer Leo
 * @version 1.0
 */
public class TicTacToe {
    /**
     * Creates Board, Game and UserInterface objects and starts a new game
     */
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(board);
        UserInterface ui = new UserInterface(game,board);
        ui.newGame();
    }
}