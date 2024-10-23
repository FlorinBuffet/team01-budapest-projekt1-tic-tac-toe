# Testkonzept Budapest
## Testingstrategie
Alle öffentlichen Methoden werden, wo möglich, mittels Unit Tests auf korrekte Funktionalität geprüft. Hierfür wird die jUnit Library verwendet. Die Testklassen werden nach dem Schema {Klassenname}Test erstellt und sind im Verzeichnis /test gespeichert.
Klassen, die nicht mit Unit Tests geprüft werden können, da sie auf Konsoleneingaben basieren oder eine visuelle Ausgabe erzeugen, werden manuell getestet. Hierfür wird ein Testprotkoll mit allen relevanten Fällen erstellt.
Das finale Produkt soll auf Windows und MacOS lauffähig sein, andere Betriebsysteme werden nicht unterstützt.

## Zuständigkeiten
Hauptverantwortliche für das Erstellen der Unit Tests sind Midas Pavia Dominguez (für die Klasse Board) und Chiara Bär (für die Klasse Game), da diese nicht von ihnen programmiert wurden und somit auch Fälle geprüft werden, an welche der Entwickler nicht gedacht haben könnte.
Das Testprotokoll wird von Leo Widmer erstellt, da dieses hauptsächlich die Klasse UserInterface manuell testet und er da ebenfalls nicht an der Entwicklung beteiligt ist. Wenn jemandem ein fehlender Test auffällt, wird dieser entsprechend ergänzt.
Für das manuelle Testing gemäss Testprotokoll ist Chiara Bär verantwortlich. Die Resultate werden im Testprotokoll festgehalten.

## Timeline
Die Tests und das Testprokotoll werden gleichzeitig während des Programmierens geschrieben. Damit können Klassen und Methoden geprüft werden, sobald sie implementiert wurden. Für gewisse Klassen ist es nötig nach der Implementation weitere geeignete Testfälle zu schreiben, um die Testabdeckung zu erhöhen. Die manuellen Tests werden während des Programmierens bei Bedarf ausgeführt. Für das Testprotokoll werden nach Fertigstellung des Programmes die Tests alle nochmals durchgeführt und dokumentiert.

## Mögliche Schwierigkeiten
Sämtliche Methoden, welche einen visuelle Rückgabe(z.B das Spielbrett) besitzen, können nur schwer durch automatisierte Tests geprüft werden. Hier muss der Output vom Tester auf Korrektheit überprüft werden. 

## Tests
Alle Tests hier aufzuführen würde die Übersichtlichkeit einschränken. Daher werden diese im Testprotokoll festgelegt:
[Test Protocol](https://github.zhaw.ch/PM1-IT24aZH-wahl-fame-lieh-dihl-pasu/team01-budapest-projekt1-tic-tac-toe/blob/main/doc/Testprotokoll.pdf)