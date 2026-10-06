# Kaffee-Kontor

Semesterprojekt **Programmierung 1** — Wirtschaftsinformatik, DHBW.

Du führst eine Kaffeerösterei über 30 Runden und versuchst, am Ende möglichst viel Geld in der
Kasse zu haben. Mit jeder Vorlesungseinheit kommt ein Stück dazu — vom ersten Rechenschritt bis
zum eigenen Bot, der am Semesterende im Turnier gegen die der anderen antritt.

**Wichtig:** Dies ist das *einzige* Projekt für das ganze Semester. Du öffnest es einmal und
arbeitest darin weiter. Es gibt keinen Grund, jemals ein zweites Projekt anzulegen.

---

## Einrichtung

Es gibt zwei gleichwertige Wege. Beide funktionieren, in der Vorlesung wird IntelliJ gezeigt.

**Kurzentscheidung:** Wenn du auf deinem Rechner nichts installieren darfst — etwa weil es ein
Firmenlaptop ist — nimm **Eclipse**. Es kommt als ZIP-Datei, bringt sein eigenes Java mit und
braucht keine Administratorrechte. Sonst nimm IntelliJ.

### Weg A: Eclipse (ohne Installation, ohne Adminrechte)

1. *Eclipse IDE for Java Developers* als **ZIP** herunterladen:
   <https://www.eclipse.org/downloads/packages/> — nicht den *Installer*, sondern in der Liste
   darunter das Paket für dein Betriebssystem.
2. ZIP in einen Ordner entpacken, in dem du Schreibrechte hast, z. B. `C:\eclipse` oder in
   dein Benutzerverzeichnis. `eclipse.exe` (bzw. `Eclipse.app`) direkt von dort starten.
   Ein Java und die Maven-Unterstützung sind bereits enthalten.
3. Projekt importieren über *File → Import → Maven → Existing Maven Projects*, dann den Ordner
   `kaffee-kontor` auswählen.
4. Tests ausführen: Rechtsklick auf `RundeTest` → *Run As → JUnit Test*.
   Programm starten: Rechtsklick auf `Start` → *Run As → Java Application*.

### Weg B: IntelliJ IDEA Community Edition

1. IntelliJ IDEA **Community Edition** herunterladen und installieren:
   <https://www.jetbrains.com/idea/download/> — der Community-Abschnitt steht weiter unten auf
   der Seite, nicht der große Knopf oben.
2. Projektordner `kaffee-kontor` öffnen über *File → Open*. **Den Ordner auswählen, nicht die
   `pom.xml`.** IntelliJ erkennt das Maven-Projekt von selbst und lädt einmalig die benötigten
   Bibliotheken herunter (dauert beim ersten Mal ein bis zwei Minuten).
3. Falls unten rechts *"No JDK"* oder eine ähnliche Warnung erscheint:
   *File → Project Structure → Project → SDK → Download JDK* → Version **21**, Anbieter
   *Eclipse Temurin*. IntelliJ lädt und konfiguriert es selbst — du musst nichts installieren
   und nichts am System einstellen.

### Weg C: VS Code

Möglich, aber der umständlichste Weg: Du brauchst ein separat installiertes JDK *und* das
*Extension Pack for Java*. Wenn du dich damit auskennst, gern — sonst nimm A oder B.

### Wenn Eclipse die pom.xml rot anzeigt

Das kommt vor und bedeutet meistens nichts. Eclipse markiert Maven-Konfigurationen, mit denen
sein Editor nichts anfangen kann, auch dann als Fehler, wenn das Projekt einwandfrei baut.
**Prüfe im Zweifel auf der Kommandozeile mit `mvn test`** — wenn dort `BUILD SUCCESS` steht,
ist alles in Ordnung. Oder: Rechtsklick auf das Projekt → *Maven → Update Project* mit
angehaktem *Force Update*. Das räumt die meisten dieser Anzeigen weg.

### Ohne IDE, nur Kommandozeile

```
mvn test          # alle Tests ausführen
mvn exec:java     # das Programm starten
```

---

## Läuft alles?

Führe einmal aus:

```
mvn -P pruefe-setup test
```

Die Ausgabe sagt im Klartext, ob Java-Version, Sprache und Zeichenkodierung stimmen. Wenn dort
etwas nicht passt, bring die Ausgabe mit in die Vorlesung — das ist in zwei Minuten geklärt.

---

## Womit du arbeitest

| Ordner | Inhalt |
|---|---|
| `src/main/java/de/dhbw/prog1/kern/` | **Rahmenwerk.** Fertig, wird nicht verändert. Konsole, Marktdaten, Spielregeln, Geldrechnung. |
| `src/main/java/de/dhbw/prog1/ue02/` | **Deine Übung.** Für jede Einheit gibt es ein eigenes Paket, `ue02` bis `ue14`. |
| `src/test/java/…` | **Tests.** Deine Selbstkontrolle. Ebenfalls nicht verändern. |
| `loesungen/` | Musterlösungen. Anfangs nur fürs Training. Nach jeder Einheit gibt es in Moodle ein ZIP wie `loesung_ue05.zip` — darin den Ordner `ue05` (aus `loesungen/`) in den Ordner `loesungen` deines Projekts ziehen. Nicht den ganzen Ordner `loesungen` ziehen — auf dem Mac ersetzt das die vorhandenen Lösungen. |
| `src/main/java/de/dhbw/prog1/training/` | **Training.** 205 kleine Aufgaben zum Üben einzelner Themen, unabhängig vom Kaffee-Kontor. Übersicht in [`TRAINING.md`](TRAINING.md). |

## Wie du eine Übung bearbeitest

1. Öffne die Klasse im Paket der aktuellen Einheit, z. B. `ue02/Runde.java`.
2. Ersetze die `TODO`-Stellen durch deinen Code. Die Kommentare darüber sagen dir, was gefragt ist.
3. Führe die Tests aus — in IntelliJ mit dem grünen Dreieck neben der Testklasse, sonst mit
   `mvn test`.
4. Bei Rot: **lies die Fehlermeldung**. Sie sagt im Klartext, was erwartet wurde und was
   herauskam. Das ist keine Schelte, das ist deine wichtigste Informationsquelle.
5. Jede Übung hat drei Stufen. **Basis** schafft jeder — das ist das Ziel für die Einheit.
   **Kern** ist der Stoff, der in der Klausur drankommt. **Kür** ist freiwillig.

**Zum Nachschlagen:** Wie `if`, `while`, ein Konstruktor oder eine `Map` geschrieben wird, steht
im Heft **Java zum Nachschlagen** (`JAVA_REFERENZ.pdf` in Moodle, Einheit 1) — thematisch
geordnet, mit Beispiel und typischer Falle zu jedem Stichwort.

---

## Nicht fertig geworden? So holst du auf

Die meisten Übungen stehen für sich. **An drei Stellen baut aber eine Übung auf einer früheren
auf** — dort kommst du nur weiter, wenn die frühere funktioniert:

| Du willst | dafür muss funktionieren |
|---|---|
| Übung 3 (`Entscheidung`) | Übung 2 — `ue02/Runde.java` |
| Übung 4 (`Schleifen`) | Übung 2 und 3 — `ue02/Runde.java`, `ue03/Entscheidung.java` |
| deinen Turnier-Bot gegen die Vergleichsbots testen | Übung 11 Teil 1 und 2 — `ue11/FesterPreis.java`, `ue11/SaisonStrategie.java` |

Du erkennst es daran, dass in Übung 3 und 4 der **erste Test „Voraussetzung"** rot ist. Bei
allen anderen Übungen musst du nichts übernehmen — lies die Musterlösung dann einfach zum
Vergleich.

**So übernimmst du eine Musterlösung** (Beispiel Übung 2):

1. Die Lösung muss schon im Projekt liegen: `loesungen/ue02/Runde.java`. Wenn nicht, erst das
   ZIP aus Moodle holen (siehe `loesungen/` in der Tabelle oben).
2. **Deinen eigenen Versuch sichern**, wenn du ihn behalten willst: `src/main/java/de/dhbw/prog1/ue02/Runde.java`
   auf den Desktop kopieren. (Nicht innerhalb von `src` umbenennen — zwei Klassen gleichen
   Namens verträgt der Compiler nicht.)
3. Im Dateimanager die **Datei** `Runde.java` aus `kaffee-kontor/loesungen/ue02/` kopieren und in
   `kaffee-kontor/src/main/java/de/dhbw/prog1/ue02/` einfügen. Die Frage nach dem Ersetzen mit
   **Ja** beantworten — hier ist das gewollt.
4. **Eclipse:** Projekt anklicken, **F5**. **IntelliJ:** erkennt es von selbst.
5. Die Tests der alten Übung laufen lassen: Sie müssen jetzt grün sein. Danach ist auch der
   Voraussetzungstest der neuen Übung grün.

> **Immer einzelne Dateien kopieren, nie einen Ordner ziehen.** Auf dem Mac ersetzt der Finder
> einen gleichnamigen Ordner komplett — dann sind auch deine anderen Dateien darin weg.

> Nur die Dateien übernehmen, die es in deinem Paket schon gibt. `loesungen/ue08/Roesterei.java`
> zum Beispiel ist die Kür zum Nachlesen — kopierst du sie mit, ist das harmlos, aber nicht nötig.

Übernehmen ist keine Schande, sondern der vorgesehene Weg, um wieder mitzukommen. Schreib die
Übung trotzdem später noch einmal selbst — erst dann sitzt sie.

---

## Zwei Dinge, die dir sonst Zeit kosten

**Geld ist immer `int` in Cent, nie `double`.** Tippe einmal `System.out.println(0.1 + 0.2);`
und sieh dir an, was herauskommt. Kommazahlen sind im Rechner nicht exakt; bei Geld summieren
sich diese Fehler zu echten Differenzen. 4,50 € sind bei uns also `450`.

**Der Rechner deiner Kommilitonin rechnet genauso wie deiner.** Das Projekt ist so eingerichtet,
dass Sprache, Zeichenkodierung und Zeilenenden auf Windows, macOS und Linux identisch sind.
Wenn ein Test bei dir rot und bei jemand anderem grün ist, liegt es fast sicher am Code und
nicht am System. Ein Hinweis trotzdem: Unter macOS und Linux ist Groß- und Kleinschreibung bei
Dateinamen entscheidend, unter Windows nicht. Eine Klasse `KaffeeSorte` muss in einer Datei
`KaffeeSorte.java` stehen — sonst läuft es zwar auf deinem Windows-Laptop, aber nicht auf dem
Mac deines Teampartners.
