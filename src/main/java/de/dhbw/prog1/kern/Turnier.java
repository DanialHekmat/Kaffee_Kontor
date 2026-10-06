package de.dhbw.prog1.kern;

/**
 * Die Turnierleitung.
 *
 * <p><b>Lest diese Klasse einmal ganz durch und sucht nach dem Namen einer einzigen
 * Strategie.</b> Ihr werdet keinen finden. Diese Klasse laesst Bots gegeneinander antreten,
 * die es zum Zeitpunkt ihrer Entstehung noch gar nicht gab und von denen sie nichts weiss -
 * ausser dass jeder das Versprechen aus {@link Strategie} einhaelt.
 *
 * <p>Genau das ist der Sinn von Schnittstellen. In Einheit 10 hat die Preisliste dasselbe
 * mit Kaffeesorten gemacht; hier geht es um Verhalten statt um Daten.
 *
 * <p>Diese Klasse gehoert zum Rahmenwerk und muss nicht veraendert werden.
 */
public final class Turnier {

    private Turnier() {
        // Hilfsklasse - es werden keine Objekte davon erzeugt.
    }

    /**
     * Laesst eine Strategie ein vollstaendiges Spiel spielen.
     *
     * <p>Ablauf je Runde: Der Bot bekommt den Spielstand, nennt einen Preis, und die
     * Turnierleitung rechnet mit {@link Kalkulation} aus, was dabei herauskommt. Faellt die
     * Kasse ins Minus, ist das Spiel fuer diesen Bot vorbei.
     *
     * <p>Ein Preis ausserhalb des erlaubten Bereichs wird zurechtgestutzt statt als Fehler
     * behandelt - ein Bot soll das Turnier nicht sprengen koennen.
     *
     * @param strategie der antretende Bot
     * @return sein Ergebnis
     */
    public static Ergebnis spiele(Strategie strategie) {
        int kasse = Spielregeln.STARTKAPITAL_CENT;
        int letzterPreis = 0;
        int letzteNachfrage = 0;
        int gespielteRunden = 0;

        for (int runde = 1; runde <= Spielregeln.ANZAHL_RUNDEN; runde++) {
            Spielstand stand = new Spielstand(
                    runde,
                    kasse,
                    Markt.preisProSackInCent(runde),
                    Markt.saisonInProzent(runde),
                    letzterPreis,
                    letzteNachfrage);

            // Hier steht der ganze Trick: ein Aufruf, und jeder Bot antwortet anders.
            int gewuenscht = strategie.verkaufspreisFuerRunde(stand);

            int preis = Math.max(AbstrakteStrategie.MINDESTPREIS_CENT,
                    Math.min(AbstrakteStrategie.HOECHSTPREIS_CENT, gewuenscht));

            kasse += Kalkulation.rundenergebnis(runde, preis, kasse);
            gespielteRunden = runde;

            letzterPreis = preis;
            letzteNachfrage = Kalkulation.nachfrage(runde, preis);

            if (kasse < Spielregeln.BANKROTT_GRENZE_CENT) {
                break;
            }
        }

        return new Ergebnis(strategie.name(), kasse, gespielteRunden);
    }

    /**
     * Laesst alle Bots antreten und sortiert sie nach Endkasse, absteigend.
     *
     * <p>Bei Gleichstand behaelt der zuerst genannte Bot den besseren Platz.
     *
     * @param strategien die Teilnehmer
     * @return Ergebnisse in Rangfolge
     */
    public static Ergebnis[] rangliste(Strategie[] strategien) {
        Ergebnis[] ergebnisse = new Ergebnis[strategien.length];

        for (int i = 0; i < strategien.length; i++) {
            ergebnisse[i] = spiele(strategien[i]);
        }

        // Sortieren von Hand: Wir suchen wiederholt den Besten aus dem Rest und tauschen
        // ihn nach vorn. Bequemer geht es ab Einheit 13 mit einem Comparator.
        for (int i = 0; i < ergebnisse.length - 1; i++) {
            int besterIndex = i;

            for (int j = i + 1; j < ergebnisse.length; j++) {
                if (ergebnisse[j].endkasseInCent() > ergebnisse[besterIndex].endkasseInCent()) {
                    besterIndex = j;
                }
            }

            if (besterIndex != i) {
                Ergebnis merker = ergebnisse[i];
                ergebnisse[i] = ergebnisse[besterIndex];
                ergebnisse[besterIndex] = merker;
            }
        }

        return ergebnisse;
    }

    /**
     * Die Rangliste als lesbare Tabelle, eine Zeile je Bot.
     *
     * @param strategien die Teilnehmer
     * @return mehrzeilige Tabelle
     */
    public static String tabelle(Strategie[] strategien) {
        Ergebnis[] rangliste = rangliste(strategien);
        StringBuilder text = new StringBuilder();

        for (int platz = 0; platz < rangliste.length; platz++) {
            if (platz > 0) {
                text.append("\n");
            }

            text.append(String.format("%2d. %s", platz + 1, rangliste[platz]));
        }

        return text.toString();
    }
}
