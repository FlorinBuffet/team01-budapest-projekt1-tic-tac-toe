# Tic Tac Toe Project

## Contributors

- Chiara Baer
- Florin Buffet
- Midas Pavia Dominguez
- Leo Widmer


## Class Responsibilities

### Board
- **Responsibility**: Manages the game board.
- **Data**: Contains a 2D integer array representing the game board.
- **Interaction**: Provides methods to set and get the value of a field, and to check if a field is playable.

### Game
- **Responsibility**: Contains the main game logic.
- **Data**: Holds the game board and tracks the number of rounds played.
- **Interaction**: Interacts with the `Board` class to update the game state and check for a winner.

### UserInterface
- **Responsibility**: Handles user interaction.
- **Data**: Manages language settings and user inputs.
- **Interaction**: Interacts with the `Game` and `Board` classes to make moves, print the board, and display results.

### TicTacToe
- **Responsibility**: Contains the main method to start the game.
- **Interaction**: Initializes the `Board`, `Game`, and `UserInterface` classes and starts the game.

## General Workflow

The game is started by calling the main Method in the class `TicTacToe`. The is initialized by creating instances of `Board`, `Game` and `UserInterface`.Players make moves through the `UserInterface`, which updates the `Board` and checks for a winner. The language can be changed after each round through the `UserInterface`.
The `Game` checks for a winner or a draw after each move. As soon as the field is full or a player has won, the game ends and the result is displayed.

## Detailed Elements

### Game Board
- **Responsible Class**: `Board`
- **Status Storage**: The status of the game board is stored in a 2D integer array.
- **Display**: The `UserInterface` class is responsible for displaying the game board.

### Players
- **Representation**: Players are represented by integers (1 for 'X' and 2 for 'O').
- **Management**: The `UserInterface` class manages the players.
- **Current Player**: The current player is determined by the number of rounds played.

### Control Functions
- **Invalid Moves**: The `Board` class has methods to check if a move is valid.
- **Game End Detection**: The `Game` class contains methods to detect a winner or a draw.

### User Input
- **Handling**: The `UserInterface` class handles user input.
- **Evaluation**: User input is evaluated to make moves and update the game state.

### Language Switching
- **Responsible Class**: `UserInterface`
- **Text Storage**: Text messages are stored in a map of maps for different languages.
- **Current Language**: The current language is stored in the `UserInterface` class.
- **Switching**: The language can be switched independently of the game logic.

## Class Diagram
The class diagram below provides a visual representation of the relationships between the classes in this project.

[Mermaid](https://github.zhaw.ch/PM1-IT24aZH-wahl-fame-lieh-dihl-pasu/team01-budapest-projekt1-tic-tac-toe/blob/main/doc/classStructure.md)

## Testing
- [Test Concept](https://github.zhaw.ch/PM1-IT24aZH-wahl-fame-lieh-dihl-pasu/team01-budapest-projekt1-tic-tac-toe/blob/main/doc/testkonzept.md)
- [Test Protocol](https://github.zhaw.ch/PM1-IT24aZH-wahl-fame-lieh-dihl-pasu/team01-budapest-projekt1-tic-tac-toe/blob/main/doc/Testprotokoll.docx)
