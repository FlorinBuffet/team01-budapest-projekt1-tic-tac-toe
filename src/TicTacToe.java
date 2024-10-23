/**
 * Initialises and starts the Tic Tac Toe game
 *
 * @author Widmer Leo
 */
public class TicTacToe {
    /**
     * Creates Board, Game and UserInterface objects and starts the game loop
     */
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(board);
        UserInterface ui = new UserInterface(game, board);
        do {
            ui.newGame();
        } while (ui.getNextGame());

    }
}