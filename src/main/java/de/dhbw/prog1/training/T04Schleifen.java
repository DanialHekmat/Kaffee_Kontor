package de.dhbw.prog1.training;

/**
 * Training 4 - Schleifen.
 *
 * <p>Passt zu Einheit 4. Pruefe dich mit {@code T04SchleifenTest}.
 */
public class T04Schleifen {

    /** Summe 1 + 2 + ... + n. Fuer n kleiner als 1 ist das Ergebnis 0. */
    public static int summeBis(int n) {
        // TODO
        return 0;
    }

    /** n! = 1 * 2 * ... * n fuer n ab 0. Es gilt 0! = 1. */
    public static int fakultaet(int n) {
        // TODO
        return 0;
    }

    /** basis hoch exponent fuer exponent ab 0 - ohne {@code Math.pow}. */
    public static int potenz(int basis, int exponent) {
        // TODO
        return 0;
    }

    /** Wie viele Teiler hat n (n ab 1)? 12 hat sechs: 1, 2, 3, 4, 6, 12. */
    public static int anzahlTeiler(int n) {
        // TODO
        return 0;
    }

    /** Ist n eine Primzahl? 0 und 1 sind keine. */
    public static boolean istPrimzahl(int n) {
        // TODO
        return false;
    }

    /**
     * Quersumme einer nicht-negativen Zahl. 1234 ergibt 10.
     *
     * <p>Hier passt {@code while}: Solange noch Ziffern da sind ...
     */
    public static int quersumme(int zahl) {
        // TODO
        return 0;
    }

    /** Wiederholt einen Text. Beispiel: "ab" dreimal ergibt "ababab". Ohne {@code repeat}. */
    public static String wiederhole(String text, int anzahl) {
        // TODO
        return "";
    }

    /**
     * Wie oft kommt ein Zeichen im Text vor? Bei {@code null} ist das Ergebnis 0.
     *
     * <p>Tipp: {@code text.length()} und {@code text.charAt(i)}.
     */
    public static int zaehleZeichen(String text, char zeichen) {
        // TODO
        return 0;
    }

    /** Kehrt einen Text um: "abc" wird "cba". {@code null} ergibt den leeren Text. */
    public static String umkehren(String text) {
        // TODO
        return "";
    }

    // =================================================================================
    //  WEITERE AUFGABEN
    // =================================================================================

    /** Summe der geraden Zahlen von 2 bis n. Fuer n = 10: 2 + 4 + 6 + 8 + 10 = 30. */
    public static int summeGerade(int n) {
        // TODO
        return 0;
    }

    /** Wie viele Vokale (a, e, i, o, u, gross oder klein) enthaelt der Text? {@code null} ergibt 0. */
    public static int zaehleVokale(String text) {
        // TODO
        return 0;
    }

    /**
     * Die n-te Fibonacci-Zahl: 0, 1, 1, 2, 3, 5, 8, ... Jede Zahl ist die Summe der beiden davor.
     *
     * <p>fibonacci(0) ist 0, fibonacci(1) ist 1, fibonacci(10) ist 55.
     */
    public static int fibonacci(int n) {
        // TODO
        return 0;
    }

    /** Wie viele Stellen hat die Zahl? 1234 hat 4, 0 hat 1, -567 hat 3. */
    public static int anzahlStellen(int zahl) {
        // TODO
        return 0;
    }

    /** Die groesste Ziffer einer nicht-negativen Zahl. 1934 ergibt 9. */
    public static int groessteZiffer(int zahl) {
        // TODO
        return 0;
    }

    /**
     * Die Zahl im Binaersystem als Text. 5 ergibt {@code "101"}, 10 ergibt {@code "1010"},
     * 0 ergibt {@code "0"}.
     *
     * <p>Tipp: Der Rest bei Division durch 2 ist die letzte Binaerziffer. Setze ihn vorn an.
     */
    public static String binaer(int zahl) {
        // TODO
        return "";
    }

    /** Liest sich die Zahl rueckwaerts genauso? 12321 ja, 123 nein. Nur nicht-negative Zahlen. */
    public static boolean istPalindromZahl(int zahl) {
        // TODO
        return false;
    }

    /**
     * Ersetzt jedes Leerzeichen durch einen Unterstrich - mit einer Schleife, ohne {@code replace}.
     * {@code null} ergibt den leeren Text.
     */
    public static String ersetzeLeerzeichen(String text) {
        // TODO
        return "";
    }

    /**
     * Wie viele Woerter enthaelt der Text? Woerter sind durch ein oder mehrere Leerzeichen
     * getrennt, auch am Anfang und Ende duerfen Leerzeichen stehen. {@code null} ergibt 0.
     *
     * <p>Tipp: Zaehle, wie oft ein Wort <i>beginnt</i> - also ein Nicht-Leerzeichen nach einem
     * Leerzeichen oder am Textanfang steht.
     */
    public static int zaehleWoerter(String text) {
        // TODO
        return 0;
    }

    /**
     * Collatz-Folge: Ist n gerade, halbiere es, sonst rechne 3 * n + 1. Wie viele Schritte
     * braucht es, bis 1 erreicht ist? (n ist mindestens 1.)
     *
     * <p>6 braucht 8 Schritte: 6, 3, 10, 5, 16, 8, 4, 2, 1. Hier passt {@code while}.
     */
    public static int collatzSchritte(int n) {
        // TODO
        return 0;
    }

    /** Der kleinste Teiler groesser als 1 (n ist mindestens 2). 15 ergibt 3, 13 ergibt 13. */
    public static int kleinsterTeiler(int n) {
        // TODO
        return 0;
    }
}
