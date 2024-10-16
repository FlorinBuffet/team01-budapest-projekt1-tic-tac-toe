import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Represents the user interface and user interaction for Tic Tac Toe.
 *
 * @author Florin Buffet
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
        game.startNewGame();
        scan = new Scanner(System.in);
        createLanguageMap();
        selectedLanguage = "de";
        System.out.println(textOutputs.get(selectedLanguage).get("initialLanguageSelection"));
        String input = scan.nextLine();
        if (!input.equals(""))
            changeLanguage(input);
        this.game = game;
        this.board = board;
    }

    /**
     * The text outputs for the user interface.
     */

    public void newGame() {
        nextGame = false;
        game.startNewGame();
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
        while (true) {
            String input = scan.nextLine().toLowerCase();
            if ("y".equals(input) || "j".equals(input) || "o".equals(input)) {
                nextGame = true;
                return;
            } else if ("n".equals(input)) {
                clearTerminal();
                return;
            }
            System.out.println(textOutputs.get(selectedLanguage).get("invalidInput"));
        }
    }

    /**
     * Handles language change requests of the user until succeeded.
     * 
     * @param language inputs the requested language from the input scanner
     */
    private void changeLanguage(String language) {
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
    private void makeMove(Board board, Game game) {
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
            } else if (processMakeMove(input))
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
    private boolean processMakeMove(String input) {
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
    private void displayResult() {
        if (game.getRoundsPlayed() == 9) {
            System.out.println(textOutputs.get(selectedLanguage).get("displayDraw"));
        } else if (game.getRoundsPlayed() % 2 == 0) {
            System.out.println(textOutputs.get(selectedLanguage).get("displayWinnerO"));
        } else {
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
    private void printBoard(Board board) {
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
        Map<String, String> fr = new HashMap<>();
        de.put("initialLanguageSelection",
                "Sie haben aktuell Deutsch gewählt, falls Sie die Sprache ändern möchten, geben Sie bitte das zweistellige\nSprachenkürzel ein, falls Sie Deutsch behalten möchten, drücken Sie Enter.");
        en.put("initialLanguageSelection",
                "You have currently selected English, if you want to change the language, please enter the two-digit\nlanguage code, if you want to keep English, press Enter.");
        fr.put("initialLanguageSelection",
                "Vous avez actuellement sélectionné l'anglais, si vous souhaitez changer de langue, veuillez saisir le\ncode de langue à deux chiffres, si vous souhaitez conserver l'anglais, appuyez sur Enter.");
        de.put("languageNotFound",
                "Leider wurde diese Sprache nicht gefunden, zur Auswahl stehen:\nde - Deutsch\nen - Englisch\nfr - Französisch\nBitte wählen Sie erneut oder drücken Sie Enter um mit Deutsch fortzufahren.");
        en.put("languageNotFound",
                "Unfortunately this language was not found, you can choose from:\nde - German\nen - English\nfr - French\nPlease select again or press Enter to continue with English.");
        fr.put("languageNotFound",
                "Désolé, cette langue n'a pas été trouvée, vous avez le choix entre:\nde - Allemand\nen - Anglais\nfr - Français\nVeuillez sélectionner à nouveau ou appuyer sur Entrée pour continuer avec l'allemand.");
        de.put("welcomeToTheGame",
                "Willkommen bei Tic Tac Toe, gemäss den Konventionen beginnt immer X. Sie können die Sprache vor jedem Zug ändern, wenn Sie dies wünschen.");
        en.put("welcomeToTheGame",
                "Welcome to Tic Tac Toe, according to the conventions, X always begins. You can change the language before each move if you wish.");
        fr.put("welcomeToTheGame",
                "Bienvenue dans Tic Tac Toe, selon les conventions, commence toujours par X. Vous pouvez changer la langue avant chaque coup si vous le souhaitez.");
        de.put("moveX",
                "Spieler X ist an der Reihe, bitte geben Sie das gewünschte Feld mit Spalte und Zeile an.\nMit einem Sprachkürzel können Sie die Sprache wechseln.");
        en.put("moveX",
                "It is player X's turn, please enter the desired field with column and row.\nYou can change the language with a language abbreviation.");
        fr.put("moveX",
                "C'est au tour du joueur X, veuillez indiquer le champ souhaité avec la colonne et la ligne.\nUn raccourci de langue vous permet de changer de langue.");
        de.put("moveO",
                "Spieler O ist an der Reihe, bitte geben Sie das gewünschte Feld mit Spalte und Zeile an.\nMit einem Sprachkürzel können Sie die Sprache wechseln.");
        en.put("moveO",
                "It is player O's turn, please enter the desired field with column and row.\nYou can change the language with a language abbreviation.");
        fr.put("moveO",
                "C'est au tour du joueur O, veuillez indiquer le champ souhaité avec la colonne et la ligne.\nUn raccourci de langue vous permet de changer de langue.");
        de.put("invalidInput",
                "Leider konnte der Input nicht erkannt werden, bitte geben Sie Ihn erneut ein.");
        en.put("invalidInput",
                "Unfortunately the input could not be recognized, please enter it again.");
        fr.put("invalidInput",
                "Malheureusement, l'entrée n'a pas pu être reconnue, veuillez la saisir à nouveau.");
        de.put("languageChanged",
                "Die Sprache wurde gewechselt, bitte geben Sie Ihren Zug ein.");
        en.put("languageChanged",
                "The language has been changed, please enter your move.");
        fr.put("languageChanged",
                "La langue a été changée, veuillez saisir votre jeu.");
        de.put("displayDraw",
                "Leider endet das Spiel unentschieden. Geben Sie sich das nächste Mal mehr Mühe.");
        en.put("displayDraw",
                "Unfortunately, the game ends in a draw. Try harder next time.");
        fr.put("displayDraw",
                "Malheureusement, le match se termine par un match nul. Faites un effort la prochaine fois.");
        de.put("displayWinnerX",
                "Herzliche Gratulation. Spieler X hat das Spiel gewonnen.");
        en.put("displayWinnerX",
                "Congratulations. Player X has won the game.");
        fr.put("displayWinnerX",
                "Toutes nos félicitations. Le joueur X a gagné le match.");
        de.put("displayWinnerO",
                "Herzliche Gratulation. Spieler O hat das Spiel gewonnen.");
        en.put("displayWinnerO",
                "Congratulations. Player O has won the game.");
        fr.put("displayWinnerO",
                "Toutes nos félicitations. Le joueur O a gagné la partie.");
        de.put("displayNextGame",
                "Möchten Sie eine neue Partie starten? J/N");
        en.put("displayNextGame",
                "Would you like to start a new game? Y/N");
        fr.put("displayNextGame",
                "Vous voulez commencer une nouvelle partie ? O/N");

        textOutputs = new HashMap<String, Map<String, String>>();
        textOutputs.put("de", de);
        textOutputs.put("en", en);
        textOutputs.put("fr", fr);
    }

    public boolean getNextGame() {
        return nextGame;
    }

}