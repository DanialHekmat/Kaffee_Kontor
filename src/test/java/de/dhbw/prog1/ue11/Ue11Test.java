package de.dhbw.prog1.ue11;

import de.dhbw.prog1.kern.Ergebnis;
import de.dhbw.prog1.kern.Spielstand;
import de.dhbw.prog1.kern.Strategie;
import de.dhbw.prog1.kern.Turnier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests zu Uebung 11.
 *
 * <p>Diese Datei musst du nicht veraendern - sie ist deine Selbstkontrolle.
 */
@DisplayName("Uebung 11 - Interfaces und abstrakte Klassen")
class Ue11Test {

    /** Baut einen Spielstand mit frei waehlbarer Saison; der Rest sind Beispielwerte. */
    private static Spielstand standMitSaison(int saisonProzent) {
        return new Spielstand(1, 200_000, 2800, saisonProzent, 0, 0);
    }

    @Nested
    @DisplayName("FesterPreis - Stufe 1")
    class Fest {

        @Test
        @DisplayName("Der Bot haelt beide Versprechen des Interface")
        void erfuelltDenVertrag() {
            FesterPreis bot = new FesterPreis("Testbot", 250);

            assertEquals("Testbot", bot.name(),
                    "name() steht im Interface und muss hier selbst geschrieben werden - "
                            + "ein Interface bringt keinen fertigen Code mit");

            assertEquals(250, bot.verkaufspreisFuerRunde(standMitSaison(100)),
                    "Der feste Preis, unabhaengig von der Lage");

            assertEquals(250, bot.verkaufspreisFuerRunde(standMitSaison(118)),
                    "Auch in der Hochsaison bleibt er stur - das ist bei diesem Bot Absicht");
        }

        @Test
        @DisplayName("Ein Bot ist ueberall einsetzbar, wo eine Strategie erwartet wird")
        void istEineStrategie() {
            // Der Typ links ist Strategie, nicht FesterPreis. Das geht, weil die Klasse
            // das Versprechen einloest - und ist die Grundlage des ganzen Turniers.
            Strategie bot = new FesterPreis("Testbot", 250);

            assertEquals("Testbot", bot.name(),
                    "Auch ueber die Schnittstelle angesprochen antwortet das Objekt");
        }

        @Test
        @DisplayName("Im Turnier ergibt 2,50 EUR dieselben 8.564,50 EUR wie in Einheit 4")
        void turnierlaufMitFestemPreis() {
            Ergebnis ergebnis = Turnier.spiele(new FesterPreis("Fest 2,50", 250));

            assertEquals(856_450, ergebnis.endkasseInCent(),
                    "Genau der Wert, den ihr in Uebung 4 mit spieleGanzesSpiel(250) "
                            + "ausgerechnet habt. Die Turnierleitung rechnet mit derselben "
                            + "Kalkulation - nur die Preisentscheidung kommt jetzt von "
                            + "einem Bot.");

            assertEquals(30, ergebnis.gespielteRunden(), "Er haelt alle 30 Runden durch");
            assertFalse(ergebnis.istBankrott(), "Und geht nicht pleite");
        }

        @Test
        @DisplayName("Ein zu teurer Bot geht bankrott - und das Turnier merkt es")
        void bankrottWirdErfasst() {
            Ergebnis ergebnis = Turnier.spiele(new FesterPreis("Fest 4,00", 400));

            assertEquals(9, ergebnis.gespielteRunden(),
                    "Bei 4,00 EUR je Becher ist die Kasse nach Runde 9 leer");

            assertTrue(ergebnis.istBankrott(), "Und das gilt als Bankrott");

            assertEquals(-22_750, ergebnis.endkasseInCent(),
                    "Mit 227,50 EUR im Minus");
        }
    }

    @Nested
    @DisplayName("SaisonStrategie - Stufe 2")
    class Saison {

        @Test
        @DisplayName("name() kommt geschenkt aus der abstrakten Klasse (sofort gruen - das IST der Punkt)")
        void nameWirdGeerbt() {
            SaisonStrategie bot = new SaisonStrategie("Saisonbot");

            assertEquals("Saisonbot", bot.name(),
                    "Fuer diese Methode habt ihr keine Zeile geschrieben - sie steht in "
                            + "AbstrakteStrategie und wurde geerbt. Genau das ist der "
                            + "Unterschied zu FesterPreis, wo ihr sie selbst bauen musstet.");
        }

        @Test
        @DisplayName("Die Preisstaffel - Grenzwerte muessen exakt sitzen")
        void preisstaffel() {
            SaisonStrategie bot = new SaisonStrategie("Saisonbot");

            assertEquals(280, bot.verkaufspreisFuerRunde(standMitSaison(118)),
                    "118 Prozent sind Hochsaison");
            assertEquals(280, bot.verkaufspreisFuerRunde(standMitSaison(116)),
                    "Genau 116 gehoert schon zur obersten Stufe");

            assertEquals(260, bot.verkaufspreisFuerRunde(standMitSaison(115)),
                    "115 liegt eine Stufe darunter");
            assertEquals(260, bot.verkaufspreisFuerRunde(standMitSaison(104)),
                    "Genau 104 gehoert zur 260er-Stufe");

            assertEquals(240, bot.verkaufspreisFuerRunde(standMitSaison(103)),
                    "103 ist normale Lage");
            assertEquals(240, bot.verkaufspreisFuerRunde(standMitSaison(96)),
                    "Genau 96 ist noch normal");

            assertEquals(220, bot.verkaufspreisFuerRunde(standMitSaison(95)),
                    "95 ist die erste Zahl, die als Flaute gilt. Kommt hier 240 heraus, "
                            + "stehen deine Zweige in der falschen Reihenfolge.");
            assertEquals(220, bot.verkaufspreisFuerRunde(standMitSaison(85)),
                    "85 Prozent sind tiefste Flaute");
        }

        @Test
        @DisplayName("Mitdenken zahlt sich aus: 8.698,40 EUR statt 8.564,50 EUR")
        void saisonSchlaegtFestpreis() {
            int saison = Turnier.spiele(new SaisonStrategie("Saisonbot")).endkasseInCent();
            int fest = Turnier.spiele(new FesterPreis("Fest 2,50", 250)).endkasseInCent();

            assertEquals(869_840, saison,
                    "Die Saisonstrategie erreicht 8.698,40 EUR");

            assertTrue(saison > fest,
                    "Und liegt damit vor dem besten festen Preis. Der Unterschied betraegt "
                            + (saison - fest) + " Cent.");
        }
    }

    @Nested
    @DisplayName("Turnier - Polymorphie in Reinform")
    class TurnierTests {

        @Test
        @DisplayName("Die Rangliste sortiert nach Endkasse")
        void ranglisteWirdSortiert() {
            Strategie[] teilnehmer = {
                    new FesterPreis("Pleitegeier", 400),
                    new FesterPreis("Solide", 250),
                    new SaisonStrategie("Saisonbot")
            };

            Ergebnis[] rangliste = Turnier.rangliste(teilnehmer);

            assertEquals(3, rangliste.length, "Drei Teilnehmer, drei Ergebnisse");
            assertEquals("Saisonbot", rangliste[0].name(), "Bester: die Saisonstrategie");
            assertEquals("Solide", rangliste[1].name(), "Danach der feste Preis");
            assertEquals("Pleitegeier", rangliste[2].name(), "Und ganz hinten der Bankrott");
        }

        @Test
        @DisplayName("Unsinnige Preise werden zurechtgestutzt (prueft das Rahmenwerk, nicht deinen Code)")
        void preiseWerdenBegrenzt() {
            // Ein Bot, der einen negativen Preis nennt. Ohne Begrenzung wuerde die
            // Marktberechnung eine Ausnahme werfen und das ganze Turnier abbrechen.
            Strategie unsinn = new Strategie() {
                @Override
                public String name() {
                    return "Chaosbot";
                }

                @Override
                public int verkaufspreisFuerRunde(Spielstand stand) {
                    return -500;
                }
            };

            Ergebnis ergebnis = assertDoesNotThrow(() -> Turnier.spiele(unsinn),
                    "Die Turnierleitung muss auch mit einem kaputten Bot umgehen koennen");

            assertEquals("Chaosbot", ergebnis.name(), "Und ihn trotzdem werten");
        }

        @Test
        @DisplayName("Turnier kennt Bots, die es beim Bauen nicht gab (prueft das Rahmenwerk)")
        void funktioniertMitUnbekanntenBots() {
            // Diese Strategie entsteht hier im Test. Turnier.java wurde nie geaendert und
            // weiss nichts von ihr - trotzdem kann sie antreten. Genau dafuer gibt es
            // Schnittstellen.
            Strategie neuartig = new Strategie() {
                @Override
                public String name() {
                    return "Gerade erfunden";
                }

                @Override
                public int verkaufspreisFuerRunde(Spielstand stand) {
                    // Teurer Rohkaffee, hoeherer Verkaufspreis.
                    return stand.sackpreisInCent() / 12;
                }
            };

            Ergebnis ergebnis = Turnier.spiele(neuartig);

            assertEquals("Gerade erfunden", ergebnis.name(),
                    "Die Turnierleitung fragt einfach nach dem Namen - welche Klasse "
                            + "dahintersteckt, ist ihr gleichgueltig");

            assertTrue(ergebnis.gespielteRunden() >= 1,
                    "Und laesst sie mitspielen");
        }

        @Test
        @DisplayName("Die Tabelle ist lesbar")
        void tabelleWirdGebaut() {
            Strategie[] teilnehmer = {
                    new FesterPreis("Solide", 250),
                    new SaisonStrategie("Saisonbot")
            };

            String tabelle = Turnier.tabelle(teilnehmer);
            String[] zeilen = tabelle.split("\n");

            assertEquals(2, zeilen.length, "Zwei Teilnehmer, zwei Zeilen");

            assertTrue(zeilen[0].contains("Saisonbot"),
                    "Der Sieger steht oben. Zeile war: " + zeilen[0]);

            assertTrue(zeilen[0].contains("8698,40"),
                    "Mit seinem Ergebnis. Zeile war: " + zeilen[0]);
        }
    }
}
