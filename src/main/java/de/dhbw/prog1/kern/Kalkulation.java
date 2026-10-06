package de.dhbw.prog1.kern;

/**
 * Die Rundenrechnung des Kaffee-Kontors - ab Einheit 6 Teil des Rahmenwerks.
 *
 * <p>Das hier ist genau die Fassung, die ihr in Einheit 5 aus dem Monolithen herausgearbeitet
 * habt. Sie ist jetzt ins Rahmenwerk gewandert, damit alle darauf aufbauen koennen -
 * unabhaengig davon, wie weit die eigenen Uebungen 2 bis 5 gediehen sind.
 *
 * <p>Schaut sie euch an: So sieht der Code aus, den ihr selbst geschrieben habt, wenn er in
 * Betrieb geht. Nichts daran ist neu.
 *
 * <p>Diese Klasse gehoert zum Rahmenwerk und muss nicht veraendert werden.
 */
public final class Kalkulation {

    private Kalkulation() {
        // Hilfsklasse - es werden keine Objekte davon erzeugt.
    }

    /** Wie viele Saecke braucht es, um so viele Becher auszuschenken? Aufgerundet. */
    public static int saeckeFuerNachfrage(int nachfrage) {
        return (nachfrage + Spielregeln.BECHER_PRO_SACK - 1) / Spielregeln.BECHER_PRO_SACK;
    }

    /** Wie viele Becher werden bei diesem Preis nachgefragt? */
    public static int nachfrage(int runde, int verkaufspreisInCent) {
        return Markt.nachfrageInBechern(runde, verkaufspreisInCent);
    }

    /** Wie viele Becher werden zum Referenzpreis nachgefragt? */
    public static int nachfrage(int runde) {
        return nachfrage(runde, Spielregeln.REFERENZPREIS_BECHER_CENT);
    }

    /**
     * Wie viele Saecke werden in dieser Runde gekauft?
     * Begrenzt durch Bedarf, Kassenstand und Roestkapazitaet.
     */
    public static int einkaufsmenge(int runde, int verkaufspreisInCent, int kasseInCent) {
        if (kasseInCent <= 0) {
            return 0;
        }

        int benoetigt = saeckeFuerNachfrage(nachfrage(runde, verkaufspreisInCent));
        int bezahlbar = kasseInCent / Markt.preisProSackInCent(runde);
        int roestbar = Spielregeln.ROESTKAPAZITAET_SAECKE_PRO_RUNDE;

        return Math.min(benoetigt, Math.min(bezahlbar, roestbar));
    }

    /**
     * Wie veraendert sich die Kasse in dieser Runde?
     *
     * @return Veraenderung in Cent, negativ bei Verlust
     */
    public static int rundenergebnis(int runde, int verkaufspreisInCent, int kasseInCent) {
        int saecke = einkaufsmenge(runde, verkaufspreisInCent, kasseInCent);

        int kosten = saecke * Markt.preisProSackInCent(runde);
        int vorrat = saecke * Spielregeln.BECHER_PRO_SACK;
        int verkauft = Math.min(vorrat, nachfrage(runde, verkaufspreisInCent));
        int erloes = verkauft * verkaufspreisInCent;

        return erloes - kosten - Spielregeln.FIXKOSTEN_PRO_RUNDE_CENT;
    }
}
