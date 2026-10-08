package de.dhbw.prog1.ue02;

import de.dhbw.prog1.kern.Geld;
import de.dhbw.prog1.kern.Konsole;
import de.dhbw.prog1.kern.Markt;
import de.dhbw.prog1.kern.Spielregeln;

/**
 * MUSTERLOESUNG Uebung 2 - erst nach der Einheit ansehen.
 *
 * <p>Zum Vergleichen: Diese Datei ueber
 * {@code src/main/java/de/dhbw/prog1/ue02/Runde.java} kopieren, dann laufen alle Tests gruen.
 *
 * <p>Die Kommentare erklaeren nicht nur, <i>was</i> hier steht, sondern <i>warum</i> es so
 * geschrieben ist. Genau darauf kommt es an - der reine Rechenweg ist der einfache Teil.
 */
public class Runde {

    // =================================================================================
    //  STUFE 1 - BASIS
    // =================================================================================

    public static int einkaufskosten(int anzahlSaecke, int preisProSackInCent) {
        return anzahlSaecke * preisProSackInCent;
    }

    public static int erloes(int verkaufteBecher, int preisProBecherInCent) {
        return verkaufteBecher * preisProBecherInCent;
    }


    // =================================================================================
    //  STUFE 2 - KERN
    // =================================================================================

    public static int bechervorrat(int anzahlSaecke) {
        // Die Konstante statt der Zahl 80: Wenn die Roestmenge sich aendert, wird sie an
        // genau einer Stelle geaendert - in Spielregeln.
        return anzahlSaecke * Spielregeln.BECHER_PRO_SACK;
    }

    public static int verkaufteBecher(int bechervorrat, int nachfrage) {
        // Math.min ist hier deutlich lesbarer als eine Verzweigung: Die Zeile sagt woertlich,
        // was gemeint ist - "der kleinere von beiden".
        return Math.min(bechervorrat, nachfrage);
    }

    public static int rohstoffkostenProBecherInCent(int preisProSackInCent) {
        // Bewusst Ganzzahldivision: Beide Operanden sind int, also rechnet Java ganzzahlig
        // und schneidet den Rest ab. 3500 / 80 ergibt 43, nicht 43,75 und nicht 44.
        // Fuer eine Kostenkalkulation ist das Abschneiden unproblematisch; entscheidend ist,
        // dass es eine bewusste Entscheidung ist und kein Versehen.
        return preisProSackInCent / Spielregeln.BECHER_PRO_SACK;
    }

    public static int deckungsbeitragProBecherInCent(int verkaufspreisInCent,
                                                     int preisProSackInCent) {
        // Wiederverwendung statt Wiederholung: Die Rechnung fuer die Rohstoffkosten steht
        // nur an einer Stelle. Haette man sie hier abgeschrieben, muesste man bei einer
        // Aenderung daran denken, beide Stellen anzupassen - und genau das vergisst man.
        return verkaufspreisInCent - rohstoffkostenProBecherInCent(preisProSackInCent);
    }

    public static int kassenstandNachRunde(int kasseVorherInCent,
                                           int einkaufskostenInCent,
                                           int erloesInCent,
                                           int saeckeImLager) {
        int lagerkosten = saeckeImLager * Spielregeln.LAGERKOSTEN_PRO_SACK_CENT;

        // Eine Zwischenvariable mit sprechendem Namen kostet nichts und macht die Zeile
        // darunter lesbar. Alles in eine einzige lange Zeile zu quetschen ist kein Vorteil.
        return kasseVorherInCent
                - einkaufskostenInCent
                + erloesInCent
                - Spielregeln.FIXKOSTEN_PRO_RUNDE_CENT
                - lagerkosten;
    }


    // =================================================================================
    //  STUFE 3 - KUER
    // =================================================================================

    public static void spieleEineRunde() {
        Konsole.zeigeUeberschrift("Eine Runde im Kaffee-Kontor");

        int runde = Konsole.frageGanzeZahl("Welche Runde", 1, Spielregeln.ANZAHL_RUNDEN);

        int marktpreis = Markt.preisProSackInCent(runde);
        Konsole.zeige("Ein Sack Rohkaffee kostet diese Runde " + Geld.formatiere(marktpreis) + ".");
        Konsole.zeige("Die Saison liegt bei " + Markt.saisonInProzent(runde) + " Prozent.");
        Konsole.zeige();

        int saecke = Konsole.frageGanzeZahl(
                "Wie viele Saecke roestest du", 0, Spielregeln.ROESTKAPAZITAET_SAECKE_PRO_RUNDE);
        int verkaufspreis = Konsole.frageBetragInCent("Was soll ein Becher kosten");

        int kosten = einkaufskosten(saecke, marktpreis);
        int vorrat = bechervorrat(saecke);
        int nachfrage = Markt.nachfrageInBechern(runde, verkaufspreis);
        int verkauft = verkaufteBecher(vorrat, nachfrage);
        int einnahmen = erloes(verkauft, verkaufspreis);
        int kasse = kassenstandNachRunde(Spielregeln.STARTKAPITAL_CENT, kosten, einnahmen, 0);

        Konsole.zeigeUeberschrift("Rundenbericht");
        Konsole.zeige("Eingekauft:        " + saecke + " Saecke fuer " + Geld.formatiere(kosten));
        Konsole.zeige("Zubereitet:        " + vorrat + " Becher");
        Konsole.zeige("Nachgefragt:       " + nachfrage + " Becher");
        Konsole.zeige("Verkauft:          " + verkauft + " Becher");
        if (vorrat > verkauft) {
            Konsole.zeige("  -> " + (vorrat - verkauft) + " Becher bleiben uebrig. Zu viel geroestet.");
        }
        if (nachfrage > vorrat) {
            Konsole.zeige("  -> " + (nachfrage - vorrat) + " Kunden gehen leer aus. Zu wenig geroestet.");
        }
        Konsole.zeige("Deckungsbeitrag:   "
                + Geld.formatiere(deckungsbeitragProBecherInCent(verkaufspreis, marktpreis))
                + " je Becher");
        Konsole.zeige("Erloes:            " + Geld.formatiere(einnahmen));
        Konsole.zeige("Fixkosten:         "
                + Geld.formatiere(Spielregeln.FIXKOSTEN_PRO_RUNDE_CENT));
        Konsole.zeige("Kasse danach:      " + Geld.formatiere(kasse));
        Konsole.zeige("Veraendert um:     "
                + Geld.formatiere(kasse - Spielregeln.STARTKAPITAL_CENT));
    }

    public static void main(String[] args) {
        spieleEineRunde();
    }
}
