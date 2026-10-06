package de.dhbw.prog1.kern;

/**
 * Alle festen Spielwerte des Kaffee-Kontors an einer Stelle.
 *
 * <p>Solche Werte heissen <b>Konstanten</b>. Sie sind {@code static final}: es gibt sie genau
 * einmal fuer das ganze Programm ({@code static}), und sie koennen nach der Zuweisung nicht mehr
 * veraendert werden ({@code final}). Konstanten werden nach Konvention in GROSSBUCHSTABEN
 * geschrieben, mit Unterstrich zwischen den Wortteilen.
 *
 * <p>Der Sinn: Wenn in zwanzig Zeilen Code die Zahl 80 auftaucht, weiss niemand mehr, welche 80
 * gemeint ist. {@code BECHER_PRO_SACK} sagt es sofort - und laesst sich an genau einer Stelle
 * aendern, wenn die Regel sich aendert. Zahlen ohne Namen mitten im Code nennt man abwertend
 * "magische Zahlen".
 *
 * <p>Diese Klasse gehoert zum Rahmenwerk und muss nicht veraendert werden.
 */
public final class Spielregeln {

    private Spielregeln() {
        // Hilfsklasse - es werden keine Objekte davon erzeugt.
    }

    /** Startkapital der Roesterei: 2.000,00 EUR. */
    public static final int STARTKAPITAL_CENT = 200_000;

    /** Ein Spiel dauert 30 Runden. Eine Runde entspricht einer Woche. */
    public static final int ANZAHL_RUNDEN = 30;

    /** Aus einem Sack Rohkaffee entstehen 80 verkaufsfertige Becher. */
    public static final int BECHER_PRO_SACK = 80;

    /** Mehr als 12 Saecke schafft die Roestmaschine pro Runde nicht. */
    public static final int ROESTKAPAZITAET_SAECKE_PRO_RUNDE = 12;

    /**
     * Miete, Personal, Strom: 900,00 EUR pro Runde, unabhaengig vom Umsatz.
     *
     * <p>Dieser Posten ist der eigentliche Gegner im Spiel. Der Rohkaffee selbst ist billig -
     * wie in der Realitaet entscheidet nicht der Einkaufspreis ueber Gewinn oder Verlust,
     * sondern die Frage, ob genug Becher verkauft werden, um die Fixkosten zu decken.
     */
    public static final int FIXKOSTEN_PRO_RUNDE_CENT = 90_000;

    /** Lagerkosten je Sack Rohkaffee, der am Rundenende noch im Lager liegt: 0,30 EUR. */
    public static final int LAGERKOSTEN_PRO_SACK_CENT = 30;

    /** Grundnachfrage pro Runde beim Referenzpreis, in Bechern. */
    public static final int GRUNDNACHFRAGE_BECHER = 400;

    /** Preis, bei dem die Grundnachfrage gilt: 3,00 EUR pro Becher. */
    public static final int REFERENZPREIS_BECHER_CENT = 300;

    /**
     * Preiselastizitaet: Je 10 Cent, die der Becher ueber dem Referenzpreis liegt, gehen
     * 25 Becher Nachfrage verloren. Liegt der Preis darunter, steigt die Nachfrage entsprechend.
     */
    public static final int NACHFRAGEAENDERUNG_JE_10_CENT = 25;

    /** Unter diesem Kassenstand gilt die Roesterei als zahlungsunfaehig. */
    public static final int BANKROTT_GRENZE_CENT = 0;
}
