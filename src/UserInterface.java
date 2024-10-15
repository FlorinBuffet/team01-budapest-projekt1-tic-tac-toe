import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Represents the user interface and user interaction for Tic Tac Toe.
 *
 * @author Florin Buffet
 * @version 1.3
 */
public class UserInterface {
    /**
     * The current language of the user interface.
     */
    private String selectedLanguage;
    private Map<String, Map<String, String>> textOutputs;
    private Game game;
    private Board board;
    private Scanner scan;
    private boolean nextGame;

    public UserInterface(Game game, Board board) {
        clearTerminal();
        Scanner scan = new Scanner(System.in);
        createLanguageMap();
        selectedLanguage = "de";
        System.out.println(textOutputs.get(selectedLanguage).get("initialLanguageSelection"));
        String input = scan.nextLine();
        if (!input.equals(""))
            changeLanguage(input);
        this.game = game;
        this.board = board;
        this.scan = scan;
    }

    /**
     * The text outputs for the user interface.
     */

    public void newGame() {
        nextGame = false;
        System.out.println(textOutputs.get(selectedLanguage).get("welcomeToTheGame"));
        while (game.getRoundsPlayed() < 9) {
            clearTerminal();
            makeMove(board, game);
            if (game.checkWinner())
                break;
        }
        clearTerminal();
        printBoard(board);
        displayResult();
        System.out.println(textOutputs.get(selectedLanguage).get("displayNextGame"));
        while(true){
            String input = scan.nextLine().toLowerCase();
            if ("Y".equals(input)||"J".equals(input)){
                nextGame = true;
                break;
            }else if ("N".equals(input)){
                break;
            }
            System.out.println(textOutputs.get(selectedLanguage).get("invalidInput"));
        }
    }

    /**
     * Handles language change requests of the user until succeeded.
     * 
     * @param language inputs the requested language from the input scanner
     * @param scan     inputs the scanner for further questions regarding the
     *                 selected language
     */
    public void changeLanguage(String language) {
        while (!language.equals("")) {
            if (textOutputs.containsKey(language)) {
                selectedLanguage = language;
                return;
            } else {
                clearTerminal();
                System.out.println(textOutputs.get(selectedLanguage).get("languageNotFound"));
                language = scan.nextLine();
            }
        }
    }

    /**
     * Makes a move on the game board.
     */
    public void makeMove(Board board, Game game) {
        printBoard(board);
        if (game.getRoundsPlayed() % 2 == 0)
            System.out.println(textOutputs.get(selectedLanguage).get("moveX"));
        else
            System.out.println(textOutputs.get(selectedLanguage).get("moveO"));
        String input = scan.nextLine();
        while (true) {
            if (textOutputs.containsKey(input)) {
                changeLanguage(input);
                System.out.println(textOutputs.get(selectedLanguage).get("languageChanged"));
            }else if (processMakeMove(input))
                break;
            else {
                System.out.println(textOutputs.get(selectedLanguage).get("invalidInput"));
            }
            input = scan.nextLine();
        }
    }

    /**
     * Process Input of MakeMove and return true if done, else return false.
     */
    public boolean processMakeMove(String input) {
        if (input.length() > 3 || input.length() < 1) {
            return false;
        }
        input = input.toLowerCase().replaceAll("\\s", "");
        char[] charArray = input.toCharArray();
        Arrays.sort(charArray);
        if (charArray[0] > '3' || charArray[0] < '1' || charArray[1] > 'c' || charArray[1] < 'a') {
            return false;
        }
        if (board.isOccupied(charArray[0] - '1', charArray[1] - 'a')) {
            return false;
        } else {
            board.setField(charArray[0] - '1', charArray[1] - 'a', (game.getRoundsPlayed() % 2) + 1);
            game.increaseRoundsPlayed();
            return true;
        }
    }

    /**
     * Displays the result of the game.
     */
    public void displayResult() {
        if (game.getRoundsPlayed()==9){
            System.out.println(textOutputs.get(selectedLanguage).get("displayDraw"));
        }else if (game.getRoundsPlayed() % 2 == 0){
            System.out.println(textOutputs.get(selectedLanguage).get("displayWinnerO"));
        }else{
            System.out.println(textOutputs.get(selectedLanguage).get("displayWinnerX"));
        }
    }

    /**
     * Clears the current terminal.
     */
    private void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Prints the current state of the game board.
     * 
     * @param board the board that should be printed
     */
    public void printBoard(Board board) {
        printFilledLine(0, 'a', 'b', 'c');
        printSpacer();
        for (int i = 0; i < 3; i++) {
            printFilledLine(
                    i + 1,
                    convertFieldStatusToChar(board.getField(i, 0)),
                    convertFieldStatusToChar(board.getField(i, 1)),
                    convertFieldStatusToChar(board.getField(i, 2)));
            printSpacer();
        }
    }

    /**
     * This method prints an empty spacer of the board
     */
    private void printSpacer() {
        System.out.println("---+---+---+---+");
    }

    /**
     * This method prints a filled row of the board with row number and content.
     * 
     * @param rowName the row number to print at the start of the line
     * @param field1  the content for the first board column as integer
     * @param field2  the content for the second board column as integer
     * @param field3  the content for the third board column as integer
     */
    private void printFilledLine(int row, char field1, char field2, char field3) {
        String rowName = row == 0 ? " " : "" + row;
        System.out.println(" " + rowName + " | " + field1 + " | "
                + field2 + " | " + field3 + " |");
    }

    /**
     * This method converts the field integer to a char to print it
     * 
     * @param fieldInt the integer that represents the field value
     * @return the char that represents the field value
     */
    private char convertFieldStatusToChar(int fieldInt) {
        if (fieldInt == 0)
            return ' ';
        else if (fieldInt == 1)
            return 'X';
        else
            return 'O';
    }

    /**
     * This method fills in our "language Database", which would be in a separate
     * file in a live application.
     */
    private void createLanguageMap() {
        Map<String, String> de = new HashMap<>();
        Map<String, String> en = new HashMap<>();
        de.put("initialLanguageSelection",
                "Sie haben aktuell Deutsch gewählt, falls Sie die Sprache ändern möchten, geben Sie bitte das zweistellige Sprachenkürzel ein, falls Sie Deutsch behalten möchten, drücken Sie Enter.");
        en.put("initialLanguageSelection",
                "You have currently selected English, if you want to change the language, please enter the two-digit language code, if you want to keep English, press Enter.");
        de.put("languageNotFound",
                "Leider wurde diese Sprache nicht gefunden, zur Auswahl stehen:\nde - Deutsch\nen - Englisch\nBitte wählen Sie erneut oder drücken Sie Enter um mit Deutsch fortzufahren.");
        en.put("languageNotFound",
                "Unfortunately this language was not found, you can choose from:\nde - German\nen - English\nPlease select again or press Enter to continue with English.");
        de.put("welcomeToTheGame",
                "Willkommen bei Tic Tac Toe, gemäss den Konventionen beginnt immer X. Sie können die Sprache vor jedem Zug ändern, wenn Sie dies wünschen.");
        en.put("welcomeToTheGame",
                "Welcome to Tic Tac Toe, according to the conventions, X always begins. You can change the language before each move if you wish.");
        de.put("moveX",
                "Spieler X ist an der Reihe, bitte geben Sie das gewünschte Feld mit Spalte und Zeile an.\nMit einem Sprachkürzel können Sie die Sprache wechseln.");
        en.put("moveX",
                "It is player X's turn, please enter the desired field with column and row.\nYou can change the language with a language abbreviation.");
        de.put("moveO",
                "Spieler O ist an der Reihe, bitte geben Sie das gewünschte Feld mit Spalte und Zeile an.\nMit einem Sprachkürzel können Sie die Sprache wechseln.");
        en.put("moveO",
                "It is player O's turn, please enter the desired field with column and row.\nYou can change the language with a language abbreviation.");
        de.put("invalidInput",
                "Leider konnte der Input nicht erkannt werden, bitte geben Sie Ihn erneut ein.");
        en.put("invalidInput",
                "Unfortunately the input could not be recognized, please enter it again.");
        de.put("languageChanged",
                "Die Sprache wurde gewechselt, bitte geben Sie Ihren Zug ein.");
        en.put("languageChanged",
                "The language has been changed, please enter your train.");
        de.put("displayDraw",
                "Leider endet das Spiel unentschieden. Geben Sie sich das nächste Mal mehr Mühe.");
        en.put("displayDraw",
                "Unfortunately, the game ends in a draw. Try harder next time.");
        de.put("displayWinnerX",
                "Herzliche Gratulation. Spieler X hat das Spiel gewonnen.");
        en.put("displayWinnerX",
                "Congratulations. Player X has won the game.");
        de.put("displayWinnerO",
                "Herzliche Gratulation. Spieler O hat das Spiel gewonnen.");
        en.put("displayWinnerO",
                "Congratulations. Player O has won the game.");
        de.put("displayNextGame",
                "Möchten Sie eine neue Partie starten? J/N");
        en.put("displayNextGame",
                "Would you like to start a new game? Y/N");

        textOutputs = new HashMap<String, Map<String, String>>();
        textOutputs.put("de", de);
        textOutputs.put("en", en);
    }

    public boolean getNextGame(){
        return nextGame;
    }

}