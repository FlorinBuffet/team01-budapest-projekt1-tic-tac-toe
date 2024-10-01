# Testkonzept Budapest
## Klasse User Interface
### changeLanguage()
- Test mit existierender Sprache
- Test mit aktuell gewählter Sprache
- Test mit nicht vorhandener Sprache
### makeMove()
- Test mit validem Move
- Test mit Move ausserhalb des Boards
- Test mit Move auf bereits besetzte Position
## Klasse Game
### startNewGame()
- Test ob die Felder korrekt gelöscht werden
- Test ob die Rundenanzahl korrekt gelöscht wird
### checkWinner()
- Test ob der Gewinner korrekt festgestellt werden kann
- Test ob ein Draw erkennt wird
## Klasse Board
### isFieldPlayable()
- Test mit validem Feld
- Test mit Feld ausserhalb des Boards
- Test mit Feld auf bereits besetzte Position
### setField()
- Test ob Feld korrekt gesetzt wird
### getField()
- Tes ob Feld korrekt gelesen wird