package de.dhbw.prog1.training;

/**
 * Training 2 - Verzweigungen und boolesche Logik.
 *
 * <p>Passt zu Einheit 3. Pruefe dich mit {@code T02VerzweigungenTest}.
 */
public class T02Verzweigungen {

    /** Die groessere von zwei Zahlen - ohne {@code Math.max}. */
    public static int maximum(int a, int b) {
        // TODO
        return 0;
    }

    /** Die groesste von drei Zahlen. Tipp: Benutze {@link #maximum(int, int)} zweimal. */
    public static int maximumVonDrei(int a, int b, int c) {
        // TODO
        return 0;
    }

    /** Der Betrag einer Zahl - ohne {@code Math.abs}. Beispiel: -5 ergibt 5. */
    public static int betrag(int zahl) {
        // TODO
        return 0;
    }

    /** Liefert {@code "positiv"}, {@code "negativ"} oder {@code "null"}. */
    public static String vorzeichen(int zahl) {
        // TODO
        return "";
    }

    /**
     * Ist das Jahr ein Schaltjahr?
     *
     * <p>Regel: durch 4 teilbar, aber nicht durch 100 - es sei denn, auch durch 400.
     * 2024 und 2000 sind Schaltjahre, 2023 und 1900 nicht.
     */
    public static boolean istSchaltjahr(int jahr) {
        // TODO
        return false;
    }

    /**
     * Genau einer der beiden Werte ist wahr - nicht keiner und nicht beide.
     */
    public static boolean genauEinerWahr(boolean a, boolean b) {
        // TODO
        return false;
    }

    /**
     * Wochentag zur Nummer: 1 ist {@code "Montag"}, 7 ist {@code "Sonntag"}.
     *
     * <p>Alles andere ergibt {@code "unbekannt"}. Hier passt {@code switch}.
     */
    public static String wochentag(int nummer) {
        // TODO
        return "";
    }

    /** Ist das Zeichen ein Vokal (a, e, i, o, u)? Gross- und Kleinschreibung egal. */
    public static boolean istVokal(char zeichen) {
        // TODO
        return false;
    }

    /**
     * Enthalten zwei Texte dasselbe?
     *
     * <p>Beide {@code null} gilt als gleich, genau einer {@code null} als ungleich.
     * Vergleiche Inhalte - nicht mit {@code ==}.
     */
    public static boolean gleicherText(String a, String b) {
        // TODO
        return false;
    }

    // =================================================================================
    //  WEITERE AUFGABEN
    // =================================================================================

    /** Die kleinere von zwei Zahlen - ohne {@code Math.min}. */
    public static int minimum(int a, int b) {
        // TODO
        return 0;
    }

    /** Die kleinste von drei Zahlen. Benutze {@link #minimum(int, int)}. */
    public static int minimumVonDrei(int a, int b, int c) {
        // TODO
        return 0;
    }

    /**
     * Der mittlere von drei Werten (der, der nach dem Sortieren in der Mitte stuende).
     *
     * <p>Beispiel: 3, 1, 2 ergibt 2. Tipp: Summe minus Groesster minus Kleinster.
     */
    public static int mittlererWert(int a, int b, int c) {
        // TODO
        return 0;
    }

    /** Ist die Zahl durch 3 oder durch 5 teilbar (oder durch beide)? */
    public static boolean istDurchDreiOderFuenfTeilbar(int zahl) {
        // TODO
        return false;
    }

    /**
     * FizzBuzz: durch 3 und 5 teilbar ergibt {@code "FizzBuzz"}, nur durch 3 {@code "Fizz"},
     * nur durch 5 {@code "Buzz"}, sonst die Zahl als Text.
     *
     * <p>Die Reihenfolge der Pruefungen entscheidet ueber das Ergebnis bei 15.
     */
    public static String fizzBuzz(int zahl) {
        // TODO
        return "";
    }

    /**
     * Jahreszeit zum Monat: 12, 1, 2 {@code "Winter"}, 3 bis 5 {@code "Fruehling"},
     * 6 bis 8 {@code "Sommer"}, 9 bis 11 {@code "Herbst"}, sonst {@code "unbekannt"}.
     *
     * <p>Tipp: Im {@code switch} darf ein {@code case} mehrere Werte haben: {@code case 12, 1, 2 ->}.
     */
    public static String jahreszeit(int monat) {
        // TODO
        return "";
    }

    /**
     * Tage im Monat. Februar hat 29 Tage im Schaltjahr, sonst 28. April, Juni, September und
     * November haben 30, die uebrigen 31. Ungueltige Monate ergeben 0.
     */
    public static int tageImMonat(int monat, boolean schaltjahr) {
        // TODO
        return 0;
    }

    /** Ist das Zeichen ein Grossbuchstabe von A bis Z? (Umlaute zaehlen hier nicht.) */
    public static boolean istGrossbuchstabe(char zeichen) {
        // TODO
        return false;
    }

    /**
     * Was tun an der Ampel? {@code "rot"} ergibt {@code "stehen"}, {@code "gelb"} ergibt
     * {@code "warten"}, {@code "gruen"} ergibt {@code "gehen"}. Alles andere, auch {@code null},
     * ergibt {@code "unbekannt"}.
     */
    public static String ampel(String farbe) {
        // TODO
        return "";
    }

    /** Zugang hat, wer Mitglied ist oder ein Ticket hat - und mindestens 16 Jahre alt ist. */
    public static boolean hatZugang(boolean istMitglied, boolean hatTicket, int alter) {
        // TODO
        return false;
    }

    /** Vergleicht zwei Zahlen: -1 wenn a kleiner, 1 wenn a groesser, 0 bei Gleichheit. */
    public static int vergleiche(int a, int b) {
        // TODO
        return 0;
    }
}
