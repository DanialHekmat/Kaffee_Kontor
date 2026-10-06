# Training — üben, bis es sitzt

Die Übungen in der Vorlesung bauen am Kaffee-Kontor. Das Training daneben ist etwas anderes:
**205 kleine, voneinander unabhängige Aufgaben** — rund zwanzig je Thema, jede übt genau eine
Sache. Keine Rösterei, kein Spiel, keine Vorgeschichte — nur das Konzept.

Gedacht für zu Hause und vor der Klausur. Die Aufgaben haben denselben Zuschnitt wie die
Klausuraufgaben: eine Methode, eine klare Beschreibung, ein Test, der dir sagt, ob es stimmt.

---

## So arbeitest du

1. Such dir unten das Thema aus, das noch wackelt.
2. Öffne die Klasse in `src/main/java/de/dhbw/prog1/training/`.
3. Ersetze die `TODO`-Stellen. **Die Reihenfolge ist egal** — jede Aufgabe steht für sich. Die ersten
   Aufgaben einer Klasse sind die leichteren, unter „Weitere Aufgaben" wird es anspruchsvoller.
4. Lass die zugehörige Testklasse laufen:
   - **IntelliJ:** grünes Dreieck neben der Testklasse
   - **Eclipse:** Rechtsklick auf die Testklasse → *Run As → JUnit Test*
   - **Kommandozeile:** `mvn test -Dtest=T05ArraysTest`
5. Rot? **Lies die Meldung.** Bei den typischen Fehlern sagt sie dir, woran es liegt.

Die Musterlösungen liegen in `loesungen/training/`. **Schau erst hinein, wenn du es selbst
versucht hast** — sonst übst du Lesen, nicht Schreiben.

> **Der wirksamste Trick:** Löse eine Aufgabe, lösch deine Lösung am nächsten Tag und schreib
> sie neu. Wer eine Methode zweimal geschrieben hat, kann sie.

---

## Was du üben willst → welche Klasse

| Thema | Klasse | Aufgaben | passt zu Einheit |
|---|---|---|---|
| Variablen, Rechnen, Ganzzahldivision | `T01VariablenRechnen` | 20 | 2 |
| `if`, `else`, `switch`, boolesche Logik | `T02Verzweigungen` | 20 | 3 |
| Grenzwerte: „ab" oder „mehr als"? | `T03Grenzwerte` | 20 | 3 |
| `for`, `while`, Zeichen in Texten | `T04Schleifen` | 20 | 4 |
| Arrays, auch zweidimensional | `T05Arrays` | 20 | 6 |
| Methoden zerlegen, wiederverwenden, überladen | `T06Methoden` | 20 | 5 |
| Klassen, Konstruktor, `this`, `toString` | `T07Zaehler`, `T07Rechteck`, `T07Konto`, `T07Punkt` | 22 | 8 |
| Vererbung, abstrakte Klasse, Polymorphie | `T08Form` und Unterklassen, `T08Formen`; `T08Mitarbeiter` und Unterklassen, `T08Personal` | 25 | 10, 11 |
| Ausnahmen werfen, fangen, eigene Ausnahme | `T09Exceptions`, `T09UngueltigeEingabeException` | 20 | 12 |
| `List`, `Set`, `Map` | `T10Collections` | 20 | 13 |
| | | **205** | |

Die Testklassen heißen jeweils wie das Thema mit `Test` am Ende — `T07KlassenTest`,
`T08VererbungTest` und so weiter.

---

## Du kennst deine Schwachstelle schon?

Die häufigsten Fallen des Semesters, und wo du sie gezielt üben kannst:

| Die Falle | Hier üben |
|---|---|
| Ganzzahldivision — `7 / 2` ist `3` | `T01.durchschnitt`, `T01.celsiusZuFahrenheit`, `T01.prozentAnteil`, `T05.durchschnitt`, `T06.durchschnitt` |
| Aufrunden mit Ganzzahlen | `T01.rundeAufZehnerAuf`, `T01.anzahlKisten` |
| `int` läuft über | `T01.sekundenInJahren` |
| Negativer Rest — `-7 % 2` ist `-1` | `T01.istGerade`, `T01.letzteZiffer` |
| `<` oder `<=` an der Grenze | alle Aufgaben in `T03Grenzwerte`, besonders `rabattProzent`, `parkgebuehr`, `windstaerke`, `liegtImHalboffenenBereich` |
| Texte mit `==` statt `equals` | `T02.gleicherText`, `T02.ampel` |
| `&&` und `\|\|` ohne Klammern | `T02.hatZugang` |
| Reihenfolge von `if`-Zweigen | `T02.fizzBuzz`, `T03.note`, `T03.temperaturStufe` |
| Schleife um eins daneben | `T04.summeBis`, `T04.zaehleZeichen`, `T05.istSortiert`, `T05.letzterIndexVon` |
| Text in der falschen Richtung zusammengesetzt | `T04.binaer`, `T04.umkehren` |
| Startwert `0` bei Maximum oder Minimum | `T05.maximum`, `T05.minimum`, `T05.maximumInMatrix`, `T10.groessteZahl` |
| Das Original versehentlich verändert | `T05.verdoppelt`, `T05.umgekehrt`, `T10.sortiertNachLaenge`, `T10.schnittmenge` |
| Das Original *soll* verändert werden | `T05.vertausche`, `T10.entferneKurze` |
| Dieselbe Rechnung zweimal geschrieben | `T06.summeDerQuadrate`, `T06.begruessung`, `T06.kgV`, `T06.kapitalNachJahren`, `T06.formatiereName` |
| Objekt vergisst, was es wissen muss | `T07Zaehler.zuruecksetzen` |
| Objekt lässt Unsinn zu | `T07Konto.einzahlen`, `T07Konto.abheben` |
| `static` bei Objektattributen | `T07Punkt` |
| `toString` in jeder Unterklasse neu geschrieben | `T08Form.toString`, `T08Mitarbeiter.jahresgehalt` |
| `super.methode()` vergessen | `T08Fuehrungskraft.monatsgehalt` |
| Gleichstand: `>` oder `>=`? | `T08Personal.bestbezahlt` |
| Division durch null nicht abgefangen | `T06.kgV`, `T06.istTeilerVon`, `T09.teile`, `T09.mittelwert` |
| Absturz bei `null` | `T02.gleicherText`, `T04.umkehren`, `T09.zahlOderNull`, `T09.pruefeNichtLeer`, `T09.zeichenOderFragezeichen` |
| Ausnahme verschluckt statt weitergereicht | `T09.summeStreng`, `T09.tagAusDatum` |
| Zähler in der Map überschrieben statt erhöht | `T10.haeufigkeiten`, `T10.nachAnfangsbuchstabe` |
| `HashSet` hat keine Reihenfolge | `T10.ohneDoppelteGeordnet`, `T10.schluesselMitWertUeber` |

---

## Wann welches Training

Am besten jeweils **nach** der passenden Einheit als Hausaufgabe — dann ist der Stoff frisch,
aber nicht mehr neu.

**Vor der Klausur:** Arbeite alle zehn Themen einmal durch, ohne in die Lösungen zu schauen.
Was danach noch rot ist, ist deine Wiederholungsliste.
