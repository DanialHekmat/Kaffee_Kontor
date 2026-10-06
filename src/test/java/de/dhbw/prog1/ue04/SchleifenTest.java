package de.dhbw.prog1.ue04;

import de.dhbw.prog1.kern.Geld;
import de.dhbw.prog1.ue02.Runde;
import de.dhbw.prog1.ue03.Entscheidung;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests zu Uebung 4.
 *
 * <p>Diese Datei musst du nicht veraendern - sie ist deine Selbstkontrolle.
 */
@DisplayName("Uebung 4 - Schleifen im Kaffee-Kontor")
class SchleifenTest {

    @Test
    @DisplayName("Voraussetzung: Uebung 2 und 3 sind geloest")
    void vorherigeUebungenSindGeloest() {
        assertEquals(28_000, Runde.einkaufskosten(10, 2800),
                "Uebung 4 verwendet die Methoden aus Uebung 2 weiter. Solange dieser Test rot "
                        + "ist, koennen die Tests darunter nicht gruen werden. Nicht fertig geworden? "
                        + "Musterloesung uebernehmen (README.md, Abschnitt 'Nicht fertig geworden?').");

        assertEquals(12, Entscheidung.maximalBezahlbareSaecke(200_000, 2800),
                "Uebung 4 verwendet auch Uebung 3 weiter - loese zuerst Entscheidung.java "
                        + "fertig oder uebernimm deren Musterloesung (README.md).");
    }

    @Nested
    @DisplayName("Stufe 1 - Basis")
    class Basis {

        @Test
        @DisplayName("Marktpreise summieren - beide Grenzen zaehlen mit")
        void preiseWerdenAufsummiert() {
            assertEquals(2800, Schleifen.summeMarktpreise(1, 1),
                    "Von Runde 1 bis Runde 1 ist genau eine Runde - der Preis dieser Runde");

            assertEquals(8450, Schleifen.summeMarktpreise(1, 3),
                    "Runde 1 bis 3 sind 28,00 + 27,50 + 29,00 EUR = 84,50 EUR. Wenn 55,50 EUR "
                            + "herauskommt, fehlt die letzte Runde - du brauchst <= statt < in "
                            + "der Schleifenbedingung.");

            assertEquals(32_400, Schleifen.summeMarktpreise(1, 10),
                    "Die ersten zehn Runden ergeben zusammen 324,00 EUR");

            assertEquals(93_100, Schleifen.summeMarktpreise(1, 30),
                    "Ueber das ganze Spiel sind es 931,00 EUR");
        }

        @Test
        @DisplayName("Guenstigsten Preis finden - Vorsicht beim Startwert")
        void guenstigsterPreisWirdGefunden() {
            assertEquals(2750, Schleifen.guenstigsterSackpreis(1, 10),
                    "In den ersten zehn Runden ist Runde 2 mit 27,50 EUR die guenstigste. "
                            + "Wenn hier 0,00 EUR herauskommt, hast du die Merkvariable mit 0 "
                            + "begonnen - kein Preis ist kleiner als null, also wird sie nie "
                            + "ersetzt.");

            assertEquals(2550, Schleifen.guenstigsterSackpreis(1, 30),
                    "Ueber das ganze Spiel ist 25,50 EUR der niedrigste Preis");

            assertEquals(3200, Schleifen.guenstigsterSackpreis(5, 5),
                    "Bei einem Bereich aus einer einzigen Runde ist deren Preis auch der "
                            + "niedrigste");
        }
    }

    @Nested
    @DisplayName("Stufe 2 - Kern")
    class Kern {

        @Test
        @DisplayName("Nicht den Preis merken, sondern die Runde")
        void guenstigsteRundeWirdGefunden() {
            assertEquals(2, Schleifen.guenstigsteRunde(1, 10),
                    "Die guenstigste der ersten zehn Runden ist Runde 2. Wenn 2750 "
                            + "herauskommt, gibst du den Preis statt der Rundennummer zurueck.");

            assertEquals(17, Schleifen.guenstigsteRunde(1, 30),
                    "Ueber das ganze Spiel ist Runde 17 die guenstigste");

            assertEquals(9, Schleifen.guenstigsteRunde(9, 9),
                    "Ein Bereich aus einer Runde liefert genau diese Runde");
        }

        @Test
        @DisplayName("Preisvorteil gegen Lagerkosten aufrechnen")
        void preisvorteilWirdAufgezehrt() {
            assertEquals(42, Schleifen.rundenBisPreisvorteilAufgezehrt(2550, 3800),
                    "Der Vorteil betraegt 12,50 EUR je Sack, die Lagerung kostet 0,30 EUR je "
                            + "Runde. Nach 41 Runden sind erst 12,30 EUR aufgezehrt, nach 42 "
                            + "Runden 12,60 EUR - gesucht ist die erste Runde, in der der "
                            + "Vorteil weg ist, also 42.");

            assertEquals(10, Schleifen.rundenBisPreisvorteilAufgezehrt(2700, 3000),
                    "3,00 EUR Vorteil bei 0,30 EUR je Runde sind nach genau 10 Runden "
                            + "aufgebraucht - hier geht es glatt auf");

            assertEquals(0, Schleifen.rundenBisPreisvorteilAufgezehrt(2800, 2800),
                    "Ohne Preisunterschied gibt es nichts aufzuzehren");

            assertEquals(0, Schleifen.rundenBisPreisvorteilAufgezehrt(3000, 2800),
                    "Wenn der angeblich guenstige Preis hoeher ist, ist das Ergebnis 0 - und "
                            + "keine Endlosschleife. Pruefe das ab, bevor du zu zaehlen "
                            + "anfaengst.");
        }

        @Test
        @DisplayName("Eine Runde vollstaendig durchrechnen")
        void rundenergebnisStimmt() {
            assertEquals(21_650, Schleifen.rundenergebnis(1, 250, 200_000),
                    "Bei 2,50 EUR werden in Runde 1 genau 525 Becher nachgefragt. Dafuer "
                            + "braucht es 7 Saecke (aufgerundet), das ergibt 216,50 EUR Plus.");

            assertEquals(22_400, Schleifen.rundenergebnis(1, 240, 200_000),
                    "Bei 2,40 EUR sind es 224,00 EUR Plus - das ist der beste Wert der Runde");

            assertEquals(-35_600, Schleifen.rundenergebnis(1, 400, 200_000),
                    "Bei 4,00 EUR kaufen nur noch 150 Leute. Der Erloes deckt die Fixkosten "
                            + "nicht mehr: 356,00 EUR Verlust.");
        }

        @Test
        @DisplayName("Den besten Preis maschinell suchen")
        void besterPreisWirdGefunden() {
            int bester = Schleifen.besterVerkaufspreis(1, 200_000);

            assertEquals(240, bester,
                    "In Runde 1 bringt 2,40 EUR am meisten ein. Genau das habt ihr in "
                            + "Uebung 2 von Hand gesucht - hier probiert die Schleife alle 41 "
                            + "Preise von 1,00 bis 5,00 EUR in einem Wimpernschlag durch. "
                            + "Herausgekommen ist " + Geld.formatiere(bester) + ".");

            assertEquals(240, Schleifen.besterVerkaufspreis(2, 200_000),
                    "In Runde 2 ist es ebenfalls 2,40 EUR");
        }

        @Test
        @DisplayName("Das ganze Spiel ueber 30 Runden")
        void ganzesSpielLaeuftDurch() {
            assertEquals(856_450, Schleifen.spieleGanzesSpiel(250),
                    "Mit durchgehend 2,50 EUR stehen am Ende 8.564,50 EUR in der Kasse");

            assertEquals(842_360, Schleifen.spieleGanzesSpiel(240),
                    "Mit durchgehend 2,40 EUR sind es 8.423,60 EUR - interessanterweise "
                            + "weniger, obwohl 2,40 EUR in Runde 1 der bessere Preis war. "
                            + "Warum das so ist, besprechen wir.");
        }

        @Test
        @DisplayName("Bei Bankrott wird die Schleife abgebrochen")
        void spielEndetBeiBankrott() {
            int endstand = Schleifen.spieleGanzesSpiel(400);

            assertEquals(-22_750, endstand,
                    "Mit 4,00 EUR je Becher ist die Roesterei nach Runde 9 zahlungsunfaehig "
                            + "und das Spiel endet dort - mit " + Geld.formatiere(-22_750)
                            + " in der Kasse. Wenn ein anderer Wert herauskommt, laeuft deine "
                            + "Schleife trotz Bankrott weiter: Dafuer ist break da.");

            assertTrue(Entscheidung.istBankrott(endstand),
                    "Der Endstand muss tatsaechlich ein Bankrott sein");
        }
    }
}
