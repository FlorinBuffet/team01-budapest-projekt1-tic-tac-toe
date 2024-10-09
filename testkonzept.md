# Testkonzept Budapest
## Testingstrategie
Der vom Team geschriebene Code wird mittels Unit Tests auf korrekte Funktionalität geprüft. Hierfür wird die jUnit Library verwendet.
Für jede Klasse wird eine Testklasse nach dem Schema {Klassenname}Test erstellt. Das finale Produkt soll auf Windows und MacOS lauffähig sein, andere Betriebsysteme werden nicht unterstützt.

## Zuständigkeiten
Hauptverantwortliche für das Erstellen der Tests sind Midas Pavia Dominguez und Chiara Bär. Zu vermeiden ist, dass der Autor einer Klasse auch den Test zu dieser Klasse schreibt, um unabhägige Tests zu ermöglichen.

## Timeline
Die Tests werden gleichzeitig während des Programmierens geschrieben. Somit können Klassen und Methoden geprüft werden, sobald sie implementiert wurden. Für gewisse Klassen ist es eventuell erst möglich nach der Implementation geeignete Testfälle zu schreiben.
## Mögliche Schwierigkeiten
Sämtliche Methoden, welche einen visuelle Rückgabe(z.B das Spielbrett) besitzen, können nur schwer durch automatisierte Tests geprüft werden. Hier muss der Output vom Tester auf Korrektheit überprüft werden. 
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
- Test ob Feld korrekt gelesen wird