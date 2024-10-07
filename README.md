# Tic Tac Toe Project

## Contributors

Florin Buffet
Widmer Leo
Chiara Baer
Midas Pavia Dominguez

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

## General Workflow
1. **Initialization**: The game is initialized by creating instances of `Board`, `Game`, and `UserInterface`.
2. **Game Start**: The `startNewGame` method in the `Game` class resets the board and rounds played.
3. **Gameplay**: Players make moves through the `UserInterface`, which updates the board and checks for a winner.
4. **Game End**: The game checks for a winner or a draw after each move.

## Detailed Elements

### Game Board
- **Responsible Class**: `Board`
- **Status Storage**: The status of the game board is stored in a 2D integer array.
- **Display**: The `UserInterface` class is responsible for displaying the game board.

### Game Logic
- **Responsible Class**: `Game`
- **Game Start**: The game is started by calling the `startNewGame` method, which initializes the board and resets the round counter.

### Players
- **Representation**: Players are represented by integers (1 for 'X' and 2 for 'O').
- **Management**: The `Game` class manages the players.
- **Current Player**: The current player is determined by the number of rounds played.

### Control Functions
- **Invalid Moves**: The `Board` class has methods to check if a move is valid.
- **Game End Detection**: The `Game` class contains methods to detect a winner or a draw.

### User Input
- **Handling**: The `UserInterface` class handles user input.
- **Evaluation**: User input is evaluated to make moves and update the game state.

### Language Switching
- **Responsible Class**: `UserInterface`
- **Text Storage**: Text messages are stored in a list of maps for different languages.
- **Current Language**: The current language is stored in the `UserInterface` class.
- **Switching**: The language can be switched independently of the game logic.

## Class Diagram
The class diagram below provides a visual representation of the relationships between the classes in this project.

![Class Diagram](ClassDiagramm.png)
[Mermaid](https://github.zhaw.ch/PM1-IT24aZH-wahl-fame-lieh-dihl-pasu/team01-budapest-projekt1-tic-tac-toe/blob/main/classStructure.md)
