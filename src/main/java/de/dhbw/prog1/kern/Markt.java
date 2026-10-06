package de.dhbw.prog1.kern;

/**
 * Der Rohkaffeemarkt und das Verhalten der Kundschaft.
 *
 * <p>Der Markt ist <b>deterministisch</b>: Runde 7 hat auf jedem Rechner denselben Preis.
 * Das ist Absicht - so kann jede Loesung automatisch getestet werden, und beim Turnier am
 * Semesterende treten alle unter exakt denselben Bedingungen an. Zufall waere realistischer,
 * aber unbrauchbar zum Vergleichen.
 *
 * <p>Diese Klasse gehoert zum Rahmenwerk und muss nicht veraendert werden.
 * In Einheit 9 bauen wir sie gemeinsam zu einer Klasse mit Zustand um.
 */
public final class Markt {

    private Markt() {
        // Hilfsklasse - es werden keine Objekte davon erzeugt.
    }

    /**
     * Weltmarktpreis fuer einen Sack Rohkaffee, in Cent, je Runde.
     * Die Werte bilden einen typischen Jahresverlauf nach: Ernteschwemme im Herbst,
     * Knappheit im Fruehjahr.
     */
    private static final int[] PREIS_JE_RUNDE_CENT = {
            2800, 2750, 2900, 3050, 3200, 3150, 3400, 3650, 3800, 3700,
            3500, 3250, 3000, 2850, 2700, 2600, 2550, 2650, 2800, 3000,
            3300, 3550, 3700, 3600, 3400, 3150, 2950, 2800, 2700, 2650
    };

    /**
     * Saisonale Nachfrage in Prozent der Grundnachfrage.
     * Im Winter wird mehr Kaffee getrunken als im Hochsommer.
     */
    private static final int[] SAISON_PROZENT = {
            100, 102, 105, 108, 112, 115, 118, 115, 110, 105,
            100,  95,  90,  88,  85,  85,  88,  92,  96, 100,
            104, 108, 112, 116, 118, 114, 108, 104, 100,  98
    };

    /**
     * Liefert den Einkaufspreis fuer einen Sack Rohkaffee in der angegebenen Runde.
     *
     * @param runde Rundennummer, beginnend bei 1
     * @return Preis in Cent
     * @throws IllegalArgumentException wenn die Runde ausserhalb des Spiels liegt
     */
    public static int preisProSackInCent(int runde) {
        pruefeRunde(runde);
        return PREIS_JE_RUNDE_CENT[runde - 1];
    }

    /**
     * Liefert die saisonale Nachfrage in Prozent der Grundnachfrage.
     *
     * @param runde Rundennummer, beginnend bei 1
     * @return Wert in Prozent, z. B. 115 fuer "15 Prozent mehr als normal"
     */
    public static int saisonInProzent(int runde) {
        pruefeRunde(runde);
        return SAISON_PROZENT[runde - 1];
    }

    /**
     * Berechnet, wie viele Becher Kaffee die Kundschaft in dieser Runde kaufen moechte.
     *
     * <p>Die Nachfrage haengt von zwei Dingen ab: von der Jahreszeit und vom Preis.
     * Je 10 Cent ueber dem Referenzpreis gehen {@code NACHFRAGEAENDERUNG_JE_10_CENT} Becher
     * verloren; unter dem Referenzpreis steigt die Nachfrage entsprechend.
     * Weniger als null Becher kann niemand kaufen.
     *
     * @param runde                Rundennummer, beginnend bei 1
     * @param verkaufspreisInCent  gesetzter Preis je Becher
     * @return Anzahl nachgefragter Becher
     */
    public static int nachfrageInBechern(int runde, int verkaufspreisInCent) {
        pruefeRunde(runde);
        if (verkaufspreisInCent < 0) {
            throw new IllegalArgumentException(
                    "Ein negativer Verkaufspreis ergibt keinen Sinn: " + verkaufspreisInCent);
        }

        int saisonNachfrage = Spielregeln.GRUNDNACHFRAGE_BECHER * saisonInProzent(runde) / 100;

        int abweichungInCent = verkaufspreisInCent - Spielregeln.REFERENZPREIS_BECHER_CENT;
        int preiseffekt = abweichungInCent * Spielregeln.NACHFRAGEAENDERUNG_JE_10_CENT / 10;

        int nachfrage = saisonNachfrage - preiseffekt;
        return Math.max(0, nachfrage);
    }

    private static void pruefeRunde(int runde) {
        if (runde < 1 || runde > Spielregeln.ANZAHL_RUNDEN) {
            throw new IllegalArgumentException(
                    "Runde muss zwischen 1 und " + Spielregeln.ANZAHL_RUNDEN
                            + " liegen, war aber " + runde);
        }
    }
}
