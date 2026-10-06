package de.dhbw.prog1.kern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Ein- und Ausgabe auf der Konsole - so gebaut, dass sie unter Windows, macOS und Linux
 * identisch funktioniert.
 *
 * <p>Warum nicht einfach {@code Scanner} und {@code System.out}? Zwei Gruende:
 *
 * <ol>
 *   <li><b>Zahlenformat.</b> {@code scanner.nextDouble()} erwartet auf einem deutschen System
 *       "4,50" und auf einem englischen "4.50". Dieselbe Loesung laeuft dann beim einen
 *       Kommilitonen und wirft beim anderen eine Ausnahme. Hier wird immer als Text gelesen
 *       und selbst ausgewertet - beide Schreibweisen sind erlaubt.</li>
 *   <li><b>Umlaute.</b> Die Windows-Konsole verwendet ohne Zutun eine Zeichentabelle, in der
 *       Umlaute und das Euro-Zeichen zu Kaestchen werden. Hier wird die Ausgabe fest auf UTF-8
 *       gestellt.</li>
 * </ol>
 *
 * <p>Diese Klasse gehoert zum Rahmenwerk und muss nicht veraendert werden.
 */
public final class Konsole {

    private static final PrintStream AUSGABE =
            new PrintStream(System.out, true, StandardCharsets.UTF_8);

    private static final BufferedReader EINGABE =
            new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));

    private Konsole() {
        // Hilfsklasse - es werden keine Objekte davon erzeugt.
    }

    /** Gibt eine Zeile aus. */
    public static void zeige(String text) {
        AUSGABE.println(text);
    }

    /** Gibt eine Leerzeile aus. */
    public static void zeige() {
        AUSGABE.println();
    }

    /** Gibt eine Ueberschrift mit Trennlinie aus. */
    public static void zeigeUeberschrift(String text) {
        AUSGABE.println();
        AUSGABE.println(text);
        AUSGABE.println("-".repeat(text.length()));
    }

    /**
     * Stellt eine Frage und liest eine ganze Zahl.
     * Bei ungueltiger Eingabe wird so lange nachgefragt, bis die Eingabe stimmt.
     */
    public static int frageGanzeZahl(String frage) {
        while (true) {
            String antwort = frageText(frage);
            try {
                return Integer.parseInt(antwort.trim());
            } catch (NumberFormatException e) {
                zeige("  Das war keine ganze Zahl. Bitte noch einmal, z. B. 12");
            }
        }
    }

    /**
     * Stellt eine Frage und liest eine ganze Zahl aus einem erlaubten Bereich.
     * Beide Grenzen sind eingeschlossen.
     */
    public static int frageGanzeZahl(String frage, int min, int max) {
        while (true) {
            int wert = frageGanzeZahl(frage + " (" + min + " bis " + max + ")");
            if (wert >= min && wert <= max) {
                return wert;
            }
            zeige("  Der Wert muss zwischen " + min + " und " + max + " liegen.");
        }
    }

    /**
     * Stellt eine Frage und liest einen Geldbetrag. Das Ergebnis ist in <b>Cent</b>.
     * "4,50" und "4.50" werden beide akzeptiert.
     */
    public static int frageBetragInCent(String frage) {
        while (true) {
            String antwort = frageText(frage + " [EUR]");
            try {
                return Geld.ausText(antwort);
            } catch (IllegalArgumentException e) {
                zeige("  " + e.getMessage());
            }
        }
    }

    /** Stellt eine Ja-Nein-Frage. */
    public static boolean frageJaNein(String frage) {
        while (true) {
            String antwort = frageText(frage + " [j/n]").trim().toLowerCase();
            if (antwort.equals("j") || antwort.equals("ja")) {
                return true;
            }
            if (antwort.equals("n") || antwort.equals("nein")) {
                return false;
            }
            zeige("  Bitte j oder n eingeben.");
        }
    }

    /** Stellt eine Frage und liest die Antwort als Text. */
    public static String frageText(String frage) {
        AUSGABE.print(frage + ": ");
        AUSGABE.flush();
        try {
            String zeile = EINGABE.readLine();
            if (zeile == null) {
                // Eingabestrom zu Ende (z. B. weil das Programm ohne Konsole laeuft).
                return "";
            }
            return zeile;
        } catch (IOException e) {
            throw new IllegalStateException("Die Eingabe konnte nicht gelesen werden.", e);
        }
    }

    /** Wartet auf die Eingabetaste. */
    public static void warteAufEingabetaste() {
        frageText("Weiter mit [Enter]");
    }
}
