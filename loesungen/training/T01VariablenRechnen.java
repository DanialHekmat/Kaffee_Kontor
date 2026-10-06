package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/**
 * Training 1 - Variablen und Rechnen.
 *
 * <p>Kleine, voneinander unabhaengige Aufgaben. Jede uebt genau eine Sache. Loese sie in
 * beliebiger Reihenfolge und pruefe dich mit {@code T01VariablenRechnenTest}.
 *
 * <p>Passt zu Einheit 2.
 */
public class T01VariablenRechnen {

    /**
     * Wie viele volle Minuten stecken in einer Anzahl Sekunden?
     *
     * <p>Beispiel: 125 Sekunden sind 2 volle Minuten.
     */
    public static int volleMinuten(int sekunden) {
        return sekunden / 60;
    }

    /**
     * Wie viele Sekunden bleiben nach den vollen Minuten uebrig?
     *
     * <p>Beispiel: 125 Sekunden sind 2 Minuten und <b>5</b> Sekunden. Tipp: der Operator {@code %}.
     */
    public static int restSekunden(int sekunden) {
        return sekunden % 60;
    }

    /**
     * Bruttobetrag aus Nettobetrag und Steuersatz, alles in ganzen Cent.
     *
     * <p>Die Steuer ergibt sich als {@code netto * satz / 100}, ganzzahlig.
     * Beispiel: 1000 Cent netto bei 19 Prozent ergeben 1190 Cent.
     */
    public static int bruttoInCent(int nettoInCent, int steuersatzProzent) {
        return nettoInCent + nettoInCent * steuersatzProzent / 100;
    }

    /**
     * Der Durchschnitt zweier ganzer Zahlen - mit Nachkommastellen.
     *
     * <p>Beispiel: Durchschnitt von 3 und 4 ist 3.5, nicht 3. Achtung: Zwei ganze Zahlen
     * werden ganzzahlig geteilt. Wie erzwingst du eine Kommazahl?
     */
    public static double durchschnitt(int a, int b) {
        return (a + b) / 2.0;
    }

    /**
     * Ist die Zahl gerade? Negative Zahlen eingeschlossen.
     *
     * <p>Beispiel: 4 und -4 sind gerade, 7 und -7 nicht.
     */
    public static boolean istGerade(int zahl) {
        return zahl % 2 == 0;
    }

    /**
     * Die letzte Ziffer einer Zahl, immer positiv.
     *
     * <p>Beispiel: 1234 ergibt 4, -567 ergibt 7. Tipp: {@code Math.abs}.
     */
    public static int letzteZiffer(int zahl) {
        return Math.abs(zahl % 10);
    }

    /**
     * Rundet eine nicht-negative Zahl auf den naechsten Zehner <b>auf</b>.
     *
     * <p>Beispiel: 1 ergibt 10, 10 bleibt 10, 11 ergibt 20, 0 bleibt 0.
     * Ohne Kommazahlen - denk an den Trick {@code (a + b - 1) / b}.
     */
    public static int rundeAufZehnerAuf(int zahl) {
        return (zahl + 9) / 10 * 10;
    }

    /**
     * Grad Celsius in Grad Fahrenheit, ganzzahlig.
     *
     * <p>Formel: {@code celsius * 9 / 5 + 32}. Beispiel: 100 ergibt 212.
     * Achte darauf, erst zu multiplizieren und dann zu teilen.
     */
    public static int celsiusZuFahrenheit(int celsius) {
        return celsius * 9 / 5 + 32;
    }

    /**
     * Uhrzeit zweistellig formatieren.
     *
     * <p>Beispiel: 8 Stunden und 5 Minuten ergeben {@code "08:05"}.
     * Tipp: {@code String.format("%02d:%02d", stunden, minuten)}.
     */
    public static String uhrzeit(int stunden, int minuten) {
        return String.format("%02d:%02d", stunden, minuten);
    }

    // =================================================================================
    //  WEITERE AUFGABEN
    // =================================================================================

    /** Wie viele volle Stunden stecken in einer Anzahl Minuten? 130 Minuten sind 2 Stunden. */
    public static int volleStunden(int minuten) {
        return minuten / 60;
    }

    /** Stunden, Minuten und Sekunden zusammen in Sekunden. 1 h 2 min 3 s sind 3723 Sekunden. */
    public static int sekundenGesamt(int stunden, int minuten, int sekunden) {
        return stunden * 3600 + minuten * 60 + sekunden;
    }

    /**
     * Nettobetrag aus Bruttobetrag und Steuersatz, ganzzahlig: {@code brutto * 100 / (100 + satz)}.
     *
     * <p>Beispiel: 1190 Cent brutto bei 19 Prozent sind 1000 Cent netto.
     */
    public static int nettoAusBrutto(int bruttoInCent, int steuersatzProzent) {
        return bruttoInCent * 100 / (100 + steuersatzProzent);
    }

    /** Preis nach Rabatt: Preis minus {@code preis * rabatt / 100}. 2000 Cent mit 25 Prozent ergeben 1500. */
    public static int rabattierterPreis(int preisInCent, int rabattProzent) {
        return preisInCent - preisInCent * rabattProzent / 100;
    }

    /**
     * Welcher Prozentanteil ist teil von ganzes - mit Nachkommastellen? 1 von 4 sind 25.0.
     *
     * <p>ganzes ist immer groesser als 0.
     */
    public static double prozentAnteil(int teil, int ganzes) {
        return teil * 100.0 / ganzes;
    }

    /** Wie viele Kisten braucht man? Aufgerundet: 13 Flaschen bei 6 je Kiste sind 3 Kisten. */
    public static int anzahlKisten(int flaschen, int flaschenJeKiste) {
        return (flaschen + flaschenJeKiste - 1) / flaschenJeKiste;
    }

    /** Wie viele Flaschen passen in keine volle Kiste mehr? 13 Flaschen bei 6 je Kiste: 1. */
    public static int restFlaschen(int flaschen, int flaschenJeKiste) {
        return flaschen % flaschenJeKiste;
    }

    /** Die Zehnerstelle einer Zahl, immer positiv. 1234 ergibt 3, -567 ergibt 6, 7 ergibt 0. */
    public static int zehnerstelle(int zahl) {
        return Math.abs(zahl / 10 % 10);
    }

    /** Das erste Zeichen eines Worts (mindestens ein Zeichen lang). Tipp: {@code charAt(0)}. */
    public static char ersterBuchstabe(String wort) {
        return wort.charAt(0);
    }

    /**
     * Initialen in Grossbuchstaben: "Anna", "Schulz" ergibt {@code "A.S."}.
     *
     * <p>Tipp: {@code Character.toUpperCase(...)}.
     */
    public static String initialen(String vorname, String nachname) {
        return Character.toUpperCase(vorname.charAt(0)) + "."
                + Character.toUpperCase(nachname.charAt(0)) + ".";
    }

    /**
     * Wie viele Sekunden haben so viele Jahre (mit 365 Tagen gerechnet)?
     *
     * <p><b>Achtung:</b> Das Ergebnis passt fuer grosse Werte nicht mehr in ein {@code int} -
     * deshalb ist der Rueckgabetyp {@code long}. Aber das allein genuegt nicht. Rechnet man
     * zuerst nur mit {@code int}, laeuft das Zwischenergebnis ueber, bevor es in das
     * {@code long} kommt. Tipp: {@code 365L}.
     */
    public static long sekundenInJahren(int jahre) {
        return jahre * 365L * 24 * 60 * 60;
    }
}
