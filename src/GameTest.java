import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
    @Before
    public void setup() {
        board = new Board();
        game = new Game(board);
    }

    /**
     * Test 11
     * Tests the startNewGame method to ensure it correctly resets the game.
     */
    @Test
    public void testStartGame() {
        game.startNewGame();
        assertEquals(0, game.getRoundsPlayed());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(0, board.getField(i, j));
            }
        }
    }

    /**
     * Test 12
     * Tests the increaseRoundsPlayed method to ensure it correctly increments the rounds played.
     */
    @Test
    public void testIncreaseRoundsPlayed() {
        game.increaseRoundsPlayed();
        assertEquals(1, game.getRoundsPlayed());
    }

    /**
     * Test 13
     * Tests the checkWinner method on an empty board.
     */
    @Test
    public void testCheckWinnerWithEmptyBoard() {
        assertFalse(game.checkWinner());
    }

    /**
     * Test 14
     * Tests the checkWinner method to detect a vertical win.
     */
    @Test
    public void testCheckWinnerWithVerticalWin() {
        board.setField(0, 0, 1);
        board.setField(0, 1, 2);
        board.setField(1, 1, 2);
        board.setField(1, 2, 1);
        board.setField(2, 1, 2);
        board.setField(2, 2, 1);
        for (int i = 0; i < 5; i++) {
            game.increaseRoundsPlayed();
        }
        assertTrue(game.checkWinner());
    }

    /**
     * Test 15
     * Tests the checkWinner method to detect a horizontal win.
     */
    @Test
    public void testCheckWinnerWithHorizontalWin() {
        board.setField(0, 0, 2);
        board.setField(0, 1, 2);
        board.setField(1, 0, 2);
        board.setField(1, 1, 1);
        board.setField(1, 2, 2);
        board.setField(2, 0, 1);
        board.setField(2, 1, 1);
        board.setField(2, 2, 1);
        for (int i = 0; i < 5; i++) {
            game.increaseRoundsPlayed();
        }
        assertTrue(game.checkWinner());
    }

    /**
     * Test 16
     * Tests the checkWinner method to detect an anti-diagonal win.
     */
    @Test
    public void testCheckWinnerWithDiagonalWin1() {
        board.setField(0, 0, 1);
        board.setField(0, 2, 2);
        board.setField(1, 0, 2);
        board.setField(1, 1, 1);
        board.setField(1, 2, 1);
        board.setField(2, 1, 2);
        board.setField(2, 2, 1);
        for (int i = 0; i < 5; i++) {
            game.increaseRoundsPlayed();
        }
        assertTrue(game.checkWinner());
    }

    /**
     * Test 16
     * Tests the checkWinner method to detect a main diagonal win.
     */
    @Test
    public void testCheckWinnerWithDiagonalWin2() {
        board.setField(0, 0, 1);
        board.setField(0, 1, 1);
        board.setField(0, 2, 2);
        board.setField(1, 0, 1);
        board.setField(1, 1, 2);
        board.setField(2, 0, 2);
        board.setField(2, 2, 1);
        for (int i = 0; i < 5; i++) {
            game.increaseRoundsPlayed();
        }
        assertTrue(game.checkWinner());
    }

    /**
     * Test 17
     * Tests the checkWinner method to ensure no win is detected.
     */
    @Test
    public void testNoWinner() {
        board.setField(0, 0, 1);
        board.setField(0, 1, 2);
        board.setField(1, 0, 2);
        board.setField(1, 1, 1);
        board.setField(1, 2, 2);
        board.setField(2, 0, 1);
        board.setField(2, 1, 1);
        board.setField(2, 1, 2);
        for (int i = 0; i < 5; i++) {
            game.increaseRoundsPlayed();
        }
        assertFalse(game.checkWinner());
    }

    /**
     * Test 18
     * Tests the checkWinner method to ensure no win is detected with less than 5 rounds played.
     */
    @Test
    public void testNoWinnerNotEnoughRounds() {
        board.setField(0, 0, 1);
        board.setField(0, 1, 1);
        board.setField(0, 2, 1);
        for (int i = 0; i < 3; i++) {
            game.increaseRoundsPlayed();
        }
        assertFalse(game.checkWinner());
    }

    /**
     * Test 19
     * Tests the startNewGame method to ensure it correctly resets the field after it has been set.
     */
    @Test
    public void testResetGameField() {
        board.setField(0, 0, 1);
        game.startNewGame(); // Resetting the game
        assertEquals(0, board.getField(0, 0));
    }

    /**
     * Test 20
     * Tests the startNewGame method to ensure it correctly resets the roundsPlayed Counter after it has been increased.
     */
    @Test
    public void testResetGameRoundsPlayed() {
        game.increaseRoundsPlayed();
        game.startNewGame(); // Resetting the game
        assertEquals(0, game.getRoundsPlayed());
    }
}