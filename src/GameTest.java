import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Game class.
 * Contains unit tests to verify the functionality of the Game class.
 */
public class GameTest {

    private Game game;
    private Board board;

    /**
     * Sets up the test environment before each test.
     * Initializes the Board and Game objects.
     */
    @BeforeEach
    public void setup() {
        board = new Board();
        game = new Game(board);
    }

    /**
     * Tests the startNewGame method to ensure it correctly resets the game.
     */
    @Test
    public void testStartGame() {
        game.startNewGame();
        assertEquals(0, game.getRoundsPlayed(), "Rounds played should be reset to 0");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(0, board.getField(i, j), "All board fields should be reset to 0");
            }
        }
    }

    /**
     * Tests the increaseRoundsPlayed method to ensure it correctly increments the rounds played.
     */
    @Test
    public void testIncreaseRoundsPlayed() {
        game.increaseRoundsPlayed();
        assertEquals(1, game.getRoundsPlayed(), "Rounds played should be incremented by 1");
    }

    /**
     * Tests the checkWinner method to detect a horizontal win.
     */
    @Test
    public void testCheckWinnerWithHorizontalWin() {
        board.setField(0, 0, 1);
        board.setField(0, 1, 1);
        board.setField(0, 2, 1);
        for (int i = 0; i < 5; i++) {
            game.increaseRoundsPlayed();
        }
        assertTrue(game.checkWinner(), "Should detect horizontal win");
    }

    /**
     * Tests the checkWinner method to detect a vertical win.
     */
    @Test
    public void testCheckWinnerWithVerticalWin() {
        board.setField(0, 0, 1);
        board.setField(1, 0, 1);
        board.setField(2, 0, 1);
        for (int i = 0; i < 5; i++) {
            game.increaseRoundsPlayed();
        }
        assertTrue(game.checkWinner(), "Should detect vertical win");
    }

    /**
     * Tests the checkWinner method to detect a main diagonal win.
     */
    @Test
    public void testCheckWinnerWithDiagonalWin1() {
        board.setField(0, 0, 2);
        board.setField(1, 1, 2);
        board.setField(2, 2, 2);
        for (int i = 0; i < 5; i++) {
            game.increaseRoundsPlayed();
        }
        assertTrue(game.checkWinner(), "Should detect a main diagonal win");
    }

    /**
     * Tests the checkWinner method to detect an anti-diagonal win.
     */
    @Test
    public void testCheckWinnerWithDiagonalWin2() {
        board.setField(0, 2, 1);
        board.setField(1, 1, 1);
        board.setField(2, 0, 1);
        for (int i = 0; i < 5; i++) {
            game.increaseRoundsPlayed();
        }
        assertTrue(game.checkWinner(), "Should detect an anti-diagonal win");
    }

    /**
     * Tests the checkWinner method to ensure no win is detected with a full board.
     */
    @Test
    public void testNoWinner() {
        board.setField(0, 0, 1);
        board.setField(0, 1, 2);
        board.setField(0, 2, 1);
        board.setField(1, 0, 2);
        board.setField(1, 1, 1);
        board.setField(1, 2, 2);
        board.setField(2, 0, 2);
        board.setField(2, 1, 1);
        for (int i = 0; i < 5; i++) {
            game.increaseRoundsPlayed();
        }
        assertFalse(game.checkWinner(), "Should not detect a win with a full board.");
    }

    /**
     * Tests the checkWinner method to detect a draw condition.
     */
    @Test
    public void testDrawCondition() {
        int[] moves = {1, 2, 1, 2, 2, 1, 1, 1, 2};
        int moveCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.setField(i, j, moves[moveCount++]);
            }
        }
        for (int i = 0; i < 9; i++) {
            game.increaseRoundsPlayed();
        }
        assertFalse(game.checkWinner(), "Should detect a draw with no winning lines");
    }

    /**
     * Tests the startNewGame method to ensure it correctly resets the game after some rounds have been played.
     */
    @Test
    public void testResetGame() {
        game.startNewGame();
        game.increaseRoundsPlayed();
        game.increaseRoundsPlayed();
        game.startNewGame(); // Resetting the game
        assertEquals(0, game.getRoundsPlayed(), "Rounds should be reset to 0");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(0, board.getField(i, j), "Board should be reset to empty");
            }
        }
    }
}