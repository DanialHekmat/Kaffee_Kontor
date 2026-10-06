package de.dhbw.prog1.turnier;

import de.dhbw.prog1.kern.AbstrakteStrategie;
import de.dhbw.prog1.kern.Ergebnis;
import de.dhbw.prog1.kern.Geld;
import de.dhbw.prog1.kern.Konsole;
import de.dhbw.prog1.kern.Spielstand;
import de.dhbw.prog1.kern.Strategie;
import de.dhbw.prog1.kern.Turnier;
import de.dhbw.prog1.ue11.FesterPreis;
import de.dhbw.prog1.ue11.SaisonStrategie;

/**
 * Das Turnier - Einheit 15.
 *
 * <p><b>Fuer den Dozenten:</b> Die abgegebenen Bots liegen im Paket
 * {@code de.dhbw.prog1.turnier}. Trag sie unten in {@code teilnehmer} ein und starte diese
 * Klasse. Mehr ist nicht zu tun.
 *
 * <p>Die drei Vergleichsbots bleiben immer im Feld - sie geben der Tabelle einen Massstab.
 * Wer den Rundenoptimierer schlaegt, hat wirklich etwas gefunden.
 *
 * <p><b>Vor dem Turnier nicht vergessen:</b> die Turnierdaten einspielen
 * ({@code Einheit_15/turniermarkt/Markt.java}). Sonst gewinnt, wer die Uebungszahlen
 * auswendig gelernt hat.
 */
public class Turnierleitung {

    /**
     * Der Massstab: probiert fuer die laufende Runde alle Preise durch und nimmt den besten.
     *
     * <p>Das ist genau {@code besterVerkaufspreis} aus Uebung 4 in Botform - und vollkommen
     * regelkonform, denn es benutzt ausschliesslich die aktuelle Runde. Wer diesen Bot
     * schlaegt, hat mehr gefunden als die naheliegende Loesung.
     */
    private static class Rundenoptimierer extends AbstrakteStrategie {

        Rundenoptimierer() {
            super("-- Rundenoptimierer (Massstab)");
        }

        @Override
        public int verkaufspreisFuerRunde(Spielstand stand) {
            int bestesErgebnis = Integer.MIN_VALUE;
            int besterPreis = 100;

            for (int preis = 100; preis <= 500; preis += 10) {
                int ergebnis = de.dhbw.prog1.kern.Kalkulation.rundenergebnis(
                        stand.runde(), preis, stand.kasseInCent());

                if (ergebnis > bestesErgebnis) {
                    bestesErgebnis = ergebnis;
                    besterPreis = preis;
                }
            }

            return begrenze(besterPreis);
        }
    }

    public static void main(String[] args) {
        Strategie[] teilnehmer = {

                // ---- Vergleichsbots, bleiben immer im Feld ----------------------------
                new FesterPreis("-- Fester Preis 2,50 (Massstab)", 250),
                new SaisonStrategie("-- Saisonstrategie (Massstab)"),
                new Rundenoptimierer(),

                // ---- Abgegebene Bots hier eintragen -----------------------------------
                // new BotKoffeinkartell(),
                // new BotRoestfrisch(),
                // new BotDieVierRichtigen(),
        };

        Konsole.zeigeUeberschrift("Kaffee-Kontor - Turnier");
        Konsole.zeige(teilnehmer.length + " Teilnehmer, " + 30 + " Runden, gleiche Startbedingungen.");
        Konsole.zeige();
        Konsole.zeige(Turnier.tabelle(teilnehmer));

        Konsole.zeige();
        Konsole.zeigeUeberschrift("Auswertung");

        Ergebnis[] rangliste = Turnier.rangliste(teilnehmer);
        Ergebnis sieger = rangliste[0];

        Konsole.zeige("Sieger: " + sieger.name()
                + " mit " + Geld.formatiere(sieger.endkasseInCent()));

        int bankrotte = 0;
        for (Ergebnis ergebnis : rangliste) {
            if (ergebnis.istBankrott()) {
                bankrotte++;
            }
        }

        Konsole.zeige("Bankrott gegangen: " + bankrotte + " von " + rangliste.length);
    }
}
