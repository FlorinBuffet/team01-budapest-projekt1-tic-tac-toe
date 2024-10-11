# Testkonzept Budapest
## Testingstrategie
Der vom Team geschriebene Code wird mittels Unit Tests auf korrekte Funktionalität geprüft. Hierfür wird die jUnit Library verwendet.
Für jede Klasse(ausser UserInterface) wird eine Testklasse nach dem Schema {Klassenname}Test erstellt. Das finale Produkt soll auf Windows und MacOS lauffähig sein, andere Betriebsysteme werden nicht unterstützt. Klassen, die nicht mit Unit Tests geprüft werden können, werden manuell getestet.
## Zuständigkeiten
Hauptverantwortliche für das Erstellen der Unit Tests sind Midas Pavia Dominguez und Chiara Bär. Für das manuelle Testing ist Chiara Bär verantwortlich. Die Resultate werden im Testprotokoll festgehalten.

## Timeline
Die Tests werden gleichzeitig während des Programmierens geschrieben. Somit können Klassen und Methoden geprüft werden, sobald sie implementiert wurden. Für gewisse Klassen ist es eventuell nötig nach der Implementation weitere geeignete Testfälle zu schreiben, um die Testabdeckung zu erhöhen.

## Mögliche Schwierigkeiten
Sämtliche Methoden, welche einen visuelle Rückgabe(z.B das Spielbrett) besitzen, können nur schwer durch automatisierte Tests geprüft werden. Hier muss der Output vom Tester auf Korrektheit überprüft werden. 