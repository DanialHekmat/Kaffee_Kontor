package de.dhbw.prog1.ue06;

import de.dhbw.prog1.kern.Geld;
import de.dhbw.prog1.kern.Kalkulation;
import de.dhbw.prog1.kern.Konsole;
import de.dhbw.prog1.kern.Markt;
import de.dhbw.prog1.kern.Spielregeln;

/**
 * Uebung 6 - Arrays.
 *
 * <p>Bisher hat euer Programm immer nur eine Zahl auf einmal betrachtet: den Preis dieser
 * Runde, das Ergebnis dieser Runde. Ab heute haltet ihr <b>viele Werte gleichzeitig</b> fest -
 * die ganze Preisgeschichte, alle Ergebnisse aller Preise.
 *
 * <p>Am Ende der Uebung baut ihr die Tabelle, die ihr in Uebung 2 von Hand auf Papier
 * ausgefuellt habt: Preise in den Zeilen, Runden in den Spalten, in jeder Zelle das Ergebnis.
 * Damals sechs Zeilen in einer Viertelstunde. Heute die vollstaendige Tabelle in einer
 * Millisekunde.
 *
 * <p><b>Die eine Sache, die heute schiefgeht:</b> Arrays zaehlen ab 0, Spielrunden ab 1.
 * Der Preis von Runde 1 steht also an Position 0. Fast jeder Fehler in dieser Uebung geht
 * darauf zurueck.
 *
 * <p>Diese Uebung braucht die vorherigen nicht - alles Noetige steht in {@link Markt},
 * {@link Kalkulation} und {@link Spielregeln}.
 */
public class Historie {

    // =================================================================================
    //  STUFE 1 - BASIS
    // =================================================================================

    /**
     * Sammelt die Sackpreise eines Rundenbereichs in einem Array.
     *
     * <p>Beide Grenzen zaehlen mit. Von Runde 1 bis Runde 5 sind das fuenf Werte, und das
     * Array muss genau fuenf Plaetze haben - nicht vier, nicht sechs. Die Laenge ergibt sich
     * aus {@code bisRunde - vonRunde + 1}. Das {@code + 1} ist genau die Stelle, an der es
     * schiefgeht; rechne es einmal mit kleinen Zahlen nach.
     *
     * <p>Und die zweite Falle: An Position {@code 0} des Arrays steht der Preis von Runde
     * {@code vonRunde}. Die Umrechnung lautet also {@code runde = vonRunde + index}.
     *
     * <pre>
     *     preishistorie(9, 11)  ergibt  [3800, 3700, 3500]
     *          Position:                   0     1     2
     *          Runde:                      9    10    11
     * </pre>
     *
     * @param vonRunde erste Runde, zaehlt mit
     * @param bisRunde letzte Runde, zaehlt mit
     * @return Array mit den Sackpreisen in Cent
     */
    public static int[] preishistorie(int vonRunde, int bisRunde) {
        // TODO Stufe 1
        return new int[0];
    }

    /**
     * Addiert alle Werte eines Arrays.
     *
     * <p>Hier brauchst du den Index gar nicht - nur die Werte. Genau dafuer gibt es die
     * <b>erweiterte for-Schleife</b>, auch "for-each" genannt:
     *
     * <pre>
     *     for (int wert : werte) {
     *         ...
     *     }
     * </pre>
     *
     * <p>Sprich sie als "fuer jeden Wert in werte". Sie ist kuerzer, und vor allem kann man
     * sich damit nicht mehr am Index vergreifen. Nimm sie immer, wenn du den Index nicht
     * brauchst - und den indizierten Weg, wenn doch.
     *
     * <p>Ein leeres Array ergibt 0. Das muss man nicht abfragen: Eine Schleife ueber nichts
     * laeuft null Mal, und die Summe bleibt bei ihrem Startwert.
     *
     * @param werte Array mit Zahlen
     * @return Summe aller Werte
     */
    public static int summe(int[] werte) {
        // TODO Stufe 1
        return 0;
    }


    // =================================================================================
    //  STUFE 2 - KERN
    // =================================================================================

    /**
     * An welcher Position steht der niedrigste Preis?
     *
     * <p>Gesucht ist die <b>Position im Array</b>, nicht der Preis und nicht die Rundennummer.
     * Wer die Runde braucht, rechnet sie beim Aufrufer zurueck.
     *
     * <p>Hier hilft for-each nicht weiter - du brauchst den Index, also die klassische
     * Schleife mit {@code array.length}.
     *
     * <p>Bei Gleichstand gewinnt die kleinere Position. Ist das Array leer, gibt es keine
     * Position; dann ist das Ergebnis {@code -1}. Diesen Fall musst du abfragen, sonst
     * greifst du auf {@code preise[0]} zu, das es nicht gibt - und bekommst eine
     * {@code ArrayIndexOutOfBoundsException}.
     *
     * @param preise Array mit Preisen
     * @return Position des niedrigsten Preises, oder -1 bei leerem Array
     */
    public static int guenstigsterIndex(int[] preise) {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Der Durchschnitt aller Werte.
     *
     * <p>Summe geteilt durch Anzahl - und wie immer bei zwei ganzen Zahlen wird abgeschnitten,
     * nicht gerundet. Bei den Preisen der ersten drei Runden (8450 Cent zusammen) sind das
     * 2816 Cent, nicht 2816,67.
     *
     * <p><b>Ein leeres Array ergibt 0.</b> Das musst du abfragen, und zwar nicht aus
     * Ordnungsliebe: Teilen durch die Laenge eines leeren Arrays heisst Teilen durch null,
     * und das beendet dein Programm mit einer {@code ArithmeticException}. Solche Faelle
     * vorher abzufangen ist keine Kuer, sondern Handwerk.
     *
     * @param werte Array mit Zahlen
     * @return Durchschnitt, abgerundet, oder 0 bei leerem Array
     */
    public static int durchschnitt(int[] werte) {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Rechnet fuer eine Runde mehrere Verkaufspreise durch.
     *
     * <p>Zu jedem Preis das Rundenergebnis, in derselben Reihenfolge. Aus einem Array mit
     * fuenf Preisen wird also ein Array mit fuenf Ergebnissen. Das Rundenergebnis liefert
     * {@link Kalkulation#rundenergebnis(int, int, int)}.
     *
     * <p>Hier brauchst du den Index in beiden Arrays gleichzeitig - Eingabe und Ausgabe
     * stehen an derselben Position. Das ist ein Muster, das dir staendig begegnen wird.
     *
     * @param runde        Rundennummer
     * @param preiseInCent zu pruefende Verkaufspreise
     * @param kasseInCent  Kassenstand, fuer jeden Preis derselbe
     * @return Array mit den Ergebnissen, gleiche Laenge wie {@code preiseInCent}
     */
    public static int[] ergebnisseFuerPreise(int runde, int[] preiseInCent, int kasseInCent) {
        // TODO Stufe 2
        return new int[0];
    }

    /**
     * Die vollstaendige Ergebnistabelle: Preise mal Runden.
     *
     * <p>Das Ergebnis ist ein <b>zweidimensionales Array</b> - eine Tabelle. Eine Zeile je
     * Preis, eine Spalte je Runde:
     *
     * <pre>
     *     tabelle[preisIndex][rundenIndex]
     * </pre>
     *
     * <p>Ein zweidimensionales Array in Java ist in Wahrheit ein Array von Arrays:
     * {@code tabelle[0]} ist selbst wieder ein Array, naemlich die erste Zeile.
     * Entsprechend ist {@code tabelle.length} die Anzahl der Zeilen und
     * {@code tabelle[0].length} die Anzahl der Spalten.
     *
     * <p>Beispiel fuer zwei Preise und die Runden 1 bis 3:
     *
     * <pre>
     *     ergebnisTabelle(new int[]{240, 250}, 1, 3, 200000)
     *
     *                Runde 1   Runde 2   Runde 3
     *     2,40 EUR    22400     24670     23600
     *     2,50 EUR    21650     24000     25950
     * </pre>
     *
     * <p>Jede Zelle wird unabhaengig gerechnet, immer mit demselben Kassenstand. Es ist also
     * keine Verlaufsrechnung, sondern eine Vergleichstabelle: "Was waere, wenn ich in dieser
     * Runde diesen Preis nehme?"
     *
     * <p>Schau dir die letzte Spalte des Beispiels an. In Runde 3 ist ploetzlich der hoehere
     * Preis besser. Das ist keine Rundungslaune - darauf kommen wir in der Kuer zurueck.
     *
     * @param preiseInCent zu pruefende Verkaufspreise, ergeben die Zeilen
     * @param vonRunde     erste Runde, zaehlt mit
     * @param bisRunde     letzte Runde, zaehlt mit
     * @param kasseInCent  Kassenstand, fuer jede Zelle derselbe
     * @return Tabelle mit den Ergebnissen
     */
    public static int[][] ergebnisTabelle(int[] preiseInCent, int vonRunde, int bisRunde,
                                          int kasseInCent) {
        // TODO Stufe 2
        return new int[0][0];
    }


    // =================================================================================
    //  STUFE 3 - KUER
    // =================================================================================

    /**
     * Die Ergebnistabelle als lesbarer Text.
     *
     * <p><b>Aufgabe:</b> Gib die Tabelle so aus, dass man sie am Bildschirm lesen kann -
     * mit einer Kopfzeile fuer die Runden und einer Beschriftung je Zeile mit dem Preis.
     * {@link String#format(String, Object...)} hilft beim Ausrichten der Spalten,
     * {@link Geld#formatiere(int)} bei den Betraegen. Wie immer: zurueckgeben, nicht ausgeben.
     *
     * <p><b>Und dann die Auswertung.</b> Bau die Tabelle fuer die Preise 2,00 / 2,20 / 2,40 /
     * 2,60 / 2,80 / 3,00 EUR ueber alle 30 Runden und such je Spalte den besten Preis heraus.
     *
     * <ul>
     *   <li>Ist es immer derselbe Preis?</li>
     *   <li>In welchen Runden weicht er ab - und was haben diese Runden gemeinsam?
     *       (Ein Blick auf {@link Markt#saisonInProzent(int)} hilft.)</li>
     *   <li>Warum ist in einer Hochsaison-Runde der <i>hoehere</i> Preis der bessere,
     *       obwohl dann doch weniger Leute kaufen?</li>
     * </ul>
     *
     * <p>Die letzte Frage ist die interessante. Zwei Saetze genuegen - sie sind zugleich die
     * halbe Bauanleitung fuer euren Turnier-Bot.
     *
     * @param preiseInCent Verkaufspreise
     * @param vonRunde     erste Runde
     * @param bisRunde     letzte Runde
     * @param kasseInCent  Kassenstand je Zelle
     * @return mehrzeilige Tabelle
     */
    public static String tabelleAlsText(int[] preiseInCent, int vonRunde, int bisRunde,
                                        int kasseInCent) {
        // TODO Stufe 3 (Kuer)
        return "";
    }

    public static void main(String[] args) {
        int[] preise = {200, 220, 240, 260, 280, 300};
        Konsole.zeigeUeberschrift("Ergebnistabelle");
        Konsole.zeige(tabelleAlsText(preise, 1, 10, Spielregeln.STARTKAPITAL_CENT));
    }
}
