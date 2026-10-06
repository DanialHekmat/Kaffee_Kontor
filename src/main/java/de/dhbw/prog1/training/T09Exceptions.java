package de.dhbw.prog1.training;

/**
 * Training 9b - Ausnahmen werfen und abfangen.
 *
 * <p>Passt zu Einheit 12. Pruefe dich mit {@code T09ExceptionsTest}.
 */
public class T09Exceptions {

    /**
     * Liest eine ganze Zahl; bei allem Unbrauchbaren (auch {@code null}) kommt 0 heraus.
     *
     * <p>Fange die {@code NumberFormatException} von {@code Integer.parseInt} ab.
     */
    public static int zahlOderNull(String text) {
        // TODO
        return 0;
    }

    /** Ist der Text eine ganze Zahl? Leerzeichen drumherum sind erlaubt, {@code null} nicht. */
    public static boolean istZahl(String text) {
        // TODO
        return false;
    }

    /**
     * Teilt a durch b. Ist b gleich 0, wird eine {@link IllegalArgumentException} geworfen -
     * statt dass Java eine {@code ArithmeticException} wirft.
     */
    public static int teile(int a, int b) {
        // TODO
        return 0;
    }

    /**
     * Gibt das Alter zurueck, wenn es zwischen 0 und 150 liegt (beide eingeschlossen).
     *
     * <p>Sonst eine {@link IllegalArgumentException}, deren Meldung den falschen Wert nennt.
     */
    public static int pruefeAlter(int alter) {
        // TODO
        return 0;
    }

    /**
     * Liest eine ganze Zahl streng: Bei unbrauchbarem Text wird die eigene gepruefte
     * {@link T09UngueltigeEingabeException} geworfen, die den Text mitliefert.
     *
     * <p>Leerzeichen drumherum sind erlaubt. Die {@code NumberFormatException} faengst du ab und
     * wirfst stattdessen deine eigene Ausnahme.
     */
    public static int zahlStreng(String text) throws T09UngueltigeEingabeException {
        // TODO
        return 0;
    }

    /**
     * Das Element an der Position - oder der Standardwert, wenn die Position nicht existiert
     * oder das Array {@code null} ist.
     */
    public static int elementOderStandard(int[] werte, int position, int standard) {
        // TODO
        return 0;
    }

    /**
     * Summe aller Eintraege, die sich als ganze Zahl lesen lassen. Alles andere (auch
     * {@code null}) wird uebersprungen - ohne dass die Schleife abbricht.
     */
    public static int summeGueltiger(String[] eintraege) {
        // TODO
        return 0;
    }

    // =================================================================================
    //  WEITERE AUFGABEN
    // =================================================================================

    /**
     * Liefert den Text ohne Leerzeichen am Rand. Ist er {@code null} oder danach leer, wird eine
     * {@link IllegalArgumentException} geworfen.
     */
    public static String pruefeNichtLeer(String text) {
        // TODO
        return "";
    }

    /**
     * Prozentanteil, ganzzahlig: {@code teil * 100 / ganzes}. Ist ganzes 0 oder negativ, wird
     * eine {@link IllegalArgumentException} geworfen.
     */
    public static int prozent(int teil, int ganzes) {
        // TODO
        return 0;
    }

    /**
     * Die ganzzahlige Wurzel: die groesste Zahl w mit {@code w * w <= n}. 15 ergibt 3, 16 ergibt
     * 4. Negative n ergeben eine {@link IllegalArgumentException}.
     */
    public static int ganzzahligeWurzel(int n) {
        // TODO
        return 0;
    }

    /** Liest eine ganze Zahl; bei unbrauchbarem Text (auch {@code null}) kommt standard heraus. */
    public static int zahlOderStandard(String text, int standard) {
        // TODO
        return 0;
    }

    /**
     * Der Tag aus einem Datum im Format {@code "TT.MM.JJJJ"}: {@code "17.09.2026"} ergibt 17.
     *
     * <p>Wirft die eigene {@link T09UngueltigeEingabeException} mit dem Text als Eingabe, wenn
     * der Text {@code null} ist, nicht genau 10 Zeichen lang ist, an Position 2 und 5 keinen
     * Punkt hat, der Tag keine Zahl ist oder nicht zwischen 1 und 31 liegt.
     */
    public static int tagAusDatum(String datum) throws T09UngueltigeEingabeException {
        // TODO
        return 0;
    }

    /**
     * Division mit Rest als Text: 7 und 2 ergeben {@code "7 : 2 = 3 Rest 1"}. Bei b gleich 0
     * wird eine {@link IllegalArgumentException} geworfen.
     */
    public static String divisionMitRest(int a, int b) {
        // TODO
        return "";
    }

    /**
     * Wie viele Eintraege sind keine ganze Zahl? {@code null}-Eintraege zaehlen als ungueltig,
     * ein {@code null}-Array ergibt 0. Benutze {@link #istZahl(String)}.
     */
    public static int anzahlUngueltiger(String[] texte) {
        // TODO
        return 0;
    }

    /**
     * Ganzzahliger Mittelwert. Fuer {@code null} oder ein leeres Array gibt es keinen Mittelwert:
     * Dann wird eine {@link IllegalArgumentException} geworfen.
     */
    public static int mittelwert(int[] werte) {
        // TODO
        return 0;
    }

    /**
     * Gibt den Wert zurueck, wenn er zwischen min und max liegt (beide eingeschlossen). Sonst
     * eine {@link IllegalArgumentException} mit genau dieser Meldung:
     * {@code "Wert 12 liegt nicht zwischen 1 und 10"}.
     */
    public static int pruefeBereich(int wert, int min, int max) {
        // TODO
        return 0;
    }

    /**
     * Das Zeichen an der Position. Ist der Text {@code null} oder die Position ungueltig, kommt
     * {@code '?'} heraus. Pruefe vorher - statt Ausnahmen abzufangen.
     */
    public static char zeichenOderFragezeichen(String text, int position) {
        // TODO
        return ' ';
    }

    /**
     * Summe aller Texte als Zahlen - streng: Beim ersten unbrauchbaren Eintrag wird die eigene
     * {@link T09UngueltigeEingabeException} weitergereicht. Benutze {@link #zahlStreng(String)}.
     */
    public static int summeStreng(String[] texte) throws T09UngueltigeEingabeException {
        // TODO
        return 0;
    }
}
