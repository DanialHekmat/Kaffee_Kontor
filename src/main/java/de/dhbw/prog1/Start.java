package de.dhbw.prog1;

import de.dhbw.prog1.kern.Geld;
import de.dhbw.prog1.kern.Konsole;
import de.dhbw.prog1.kern.Markt;
import de.dhbw.prog1.kern.Spielregeln;

/**
 * Einstiegspunkt des Kaffee-Kontors.
 *
 * <p>Von hier aus wird das gestartet, was gerade dran ist. Mit jeder Einheit kommt ein
 * Menuepunkt dazu.
 *
 * <p>Start in der IDE ueber das gruene Dreieck neben {@code main}, auf der Kommandozeile mit
 * {@code mvn exec:java}.
 */
public class Start {

    public static void main(String[] args) {
        Konsole.zeigeUeberschrift("Kaffee-Kontor");
        Konsole.zeige("Programmierung 1 - Wirtschaftsinformatik");
        Konsole.zeige();
        Konsole.zeige("Startkapital:      " + Geld.formatiere(Spielregeln.STARTKAPITAL_CENT));
        Konsole.zeige("Spieldauer:        " + Spielregeln.ANZAHL_RUNDEN + " Runden");
        Konsole.zeige("Fixkosten je Runde: " + Geld.formatiere(Spielregeln.FIXKOSTEN_PRO_RUNDE_CENT));

        Konsole.zeigeUeberschrift("Was moechtest du starten?");
        Konsole.zeige("  1  Uebung 2 - eine Runde durchrechnen");
        Konsole.zeige("  2  Uebung 3 - eine Runde mit Entscheidungen");
        Konsole.zeige("  3  Uebung 4 - 30 Runden, zwei Strategien im Vergleich");
        Konsole.zeige("  4  Uebung 5 - Spielbericht der aufgeraeumten Fassung");
        Konsole.zeige("  5  Uebung 6 - Ergebnistabelle Preise x Runden");
        Konsole.zeige("  6  Marktdaten der ersten Runden ansehen");
        Konsole.zeige("  0  Beenden");

        int wahl = Konsole.frageGanzeZahl("Auswahl", 0, 6);
        switch (wahl) {
            case 1 -> de.dhbw.prog1.ue02.Runde.spieleEineRunde();
            case 2 -> de.dhbw.prog1.ue03.Entscheidung.spieleRundeMitEntscheidungen();
            case 3 -> de.dhbw.prog1.ue04.Schleifen.vergleicheStrategien();
            case 4 -> de.dhbw.prog1.ue05.Kontor.main(new String[0]);
            case 5 -> de.dhbw.prog1.ue06.Historie.main(new String[0]);
            case 6 -> zeigeMarktdaten();
            default -> Konsole.zeige("Bis zum naechsten Mal.");
        }
    }

    /** Kleine Marktuebersicht - hilft beim Ausprobieren von Preisen. */
    private static void zeigeMarktdaten() {
        Konsole.zeigeUeberschrift("Markt der ersten 10 Runden");
        Konsole.zeige("Runde | Preis je Sack | Saison | Nachfrage bei 3,00 EUR");
        for (int runde = 1; runde <= 10; runde++) {
            String zeile = String.format(
                    "%5d | %13s | %5d%% | %6d Becher",
                    runde,
                    Geld.formatiere(Markt.preisProSackInCent(runde)),
                    Markt.saisonInProzent(runde),
                    Markt.nachfrageInBechern(runde, Spielregeln.REFERENZPREIS_BECHER_CENT));
            Konsole.zeige(zeile);
        }
    }
}
