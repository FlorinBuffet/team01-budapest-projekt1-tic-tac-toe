import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Represents the user interface and user interaction for Tic Tac Toe.
 *
 * @author Florin Buffet
 * @version 1.1
 */
public class UserInterface {
    /**
     * The current language of the user interface.
     */
    private String selectedLanguage;

    /**
     * The text outputs for the user interface.
     */
    private Map<String, Map<String, String>> textOutputs;

    public void newGame() {
        Scanner scan = new Scanner(System.in);
        createLanguageMap();
        selectedLanguage = "de";
        System.out.println(textOutputs.get(selectedLanguage).get("initialLanguageSelection"));
        String input = scan.nextLine();
        if (!input.equals(""))
            changeLanguage(input, scan);
        System.out.println(textOutputs.get(selectedLanguage).get("welcomeToTheGame"));
        Board board = new Board();
        Game game = new Game(board);
        while (game.getRoundsPlayed() < 9) {
            makeMove(board, game);
        }
    }

    /**
     * Handles language change requests of the user until succeeded.
     * 
     * @param language inputs the requested language from the input scanner
     * @param scan     inputs the scanner for further questions regarding the
     *                 selected language
     */
    public void changeLanguage(String language, Scanner scan) {
        while (!language.equals("")) {
            if (textOutputs.containsKey(language)) {
                selectedLanguage = language;
                return;
            } else {
                System.out.println(textOutputs.get(selectedLanguage).get("languageNotFound"));
                language = scan.nextLine();
            }
        }
    }

    /**
     * Makes a move on the game board.
     */
    public void makeMove(Board board, Game game) {
        if (game.getRoundsPlayed() % 2 == 0)
            System.out.println(textOutputs.get(selectedLanguage).get("moveX"));
        else
            System.out.println(textOutputs.get(selectedLanguage).get("moveO"));
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        if (textOutputs.containsKey(input))
            changeLanguage(input, scan);
        else{
            if (input.length()>=3){
                
            }
        }
        scan.close();
    }

    /**
     * Displays the result of the game.
     */
    public void displayResult() {
        // TODO: Implement this method
    }

    /**
     * Prints the current state of the game board.
     * 
     * @param board the board that should be printed
     */
    public void printBoard(Board board) {
        printFilledLine(' ', 'a', 'b', 'c');
        printSpacer();
        printFilledLine(
                '1',
                convertFieldStatusToChar(board.getField(0, 0)),
                convertFieldStatusToChar(board.getField(0, 1)),
                convertFieldStatusToChar(board.getField(0, 2)));
        printSpacer();
        printFilledLine(
                '2',
                convertFieldStatusToChar(board.getField(1, 0)),
                convertFieldStatusToChar(board.getField(1, 1)),
                convertFieldStatusToChar(board.getField(1, 3)));
        printSpacer();
        printFilledLine(
                '3',
                convertFieldStatusToChar(board.getField(2, 0)),
                convertFieldStatusToChar(board.getField(2, 1)),
                convertFieldStatusToChar(board.getField(2, 2)));
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
    private void printFilledLine(char rowName, char field1, char field2, char field3) {
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
                "Spieler X ist an der Reihe, bitte geben Sie das gewünschte Feld mit Spalte und Zeile an. Mit einem Sprachkürzel können Sie die Sprache wechseln.");
        en.put("moveX",
                "It is player X's turn, please enter the desired field with column and row. You can change the language with a language abbreviation.");
        de.put("moveO",
                "Spieler O ist an der Reihe, bitte geben Sie das gewünschte Feld mit Spalte und Zeile an. Mit einem Sprachkürzel können Sie die Sprache wechseln.");
        en.put("moveO",
                "It is player O's turn, please enter the desired field with column and row. You can change the language with a language abbreviation.");

        textOutputs = new HashMap<String, Map<String, String>>();
        textOutputs.put("de", de);
        textOutputs.put("en", en);
    }
}