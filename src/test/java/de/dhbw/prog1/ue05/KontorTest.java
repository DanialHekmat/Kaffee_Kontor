package de.dhbw.prog1.ue05;

import de.dhbw.prog1.kern.Geld;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests zu Uebung 5.
 *
 * <p>Diese Datei musst du nicht veraendern - sie ist deine Selbstkontrolle.
 *
 * <p>Der auffaelligste Test steht ganz unten: Er vergleicht deine zerlegte Fassung Preis fuer
 * Preis mit dem urspruenglichen Monolithen. Genau dafuer schreibt man Tests - sie sind das
 * Sicherheitsnetz, das ein Refactoring erst verantwortbar macht.
 *
 * <p>Ein Netz ist allerdings kein Beweis. Ein ganzes Spiel endet bei ungeschickten Preisen
 * schon nach wenigen Runden im Bankrott, deshalb erreicht dieser Vergleich gar nicht jeden
 * Rechenweg. Die Tests darueber pruefen die einzelnen Methoden zusaetzlich gezielt - auch an
 * Stellen, die im Gesamtspiel nie vorkommen. Beides zusammen ergibt erst ein brauchbares Netz.
 */
@DisplayName("Uebung 5 - Aus einem Monolithen werden Methoden")
class KontorTest {

    @Nested
    @DisplayName("Stufe 1 - Basis")
    class Basis {

        @Test
        @DisplayName("Saecke fuer eine Nachfrage - immer aufgerundet")
        void saeckeWerdenAufgerundet() {
            assertEquals(7, Kontor.saeckeFuerNachfrage(525),
                    "525 Becher brauchen 7 Saecke. 6 Saecke waeren nur 480 Becher - zu wenig.");

            assertEquals(7, Kontor.saeckeFuerNachfrage(560),
                    "560 Becher gehen genau in 7 Saecke auf - hier darf NICHT auf 8 "
                            + "aufgerundet werden. Genau das leistet der Trick mit dem "
                            + "'+ BECHER_PRO_SACK - 1'.");

            assertEquals(8, Kontor.saeckeFuerNachfrage(561),
                    "Ein Becher mehr, und es braucht einen ganzen achten Sack");

            assertEquals(1, Kontor.saeckeFuerNachfrage(1),
                    "Auch fuer einen einzigen Becher muss ein ganzer Sack her");

            assertEquals(0, Kontor.saeckeFuerNachfrage(0),
                    "Ohne Nachfrage braucht es keinen Sack");
        }

        @Test
        @DisplayName("Berichtszeile wird zurueckgegeben, nicht ausgegeben")
        void berichtszeileWirdGebaut() {
            assertEquals("Runde 1 | Preis 2,50 EUR | Ergebnis 216,50 EUR | Kasse 2216,50 EUR",
                    Kontor.berichtszeile(1, 250, 21_650, 221_650),
                    "Achte auf die Leerzeichen um die senkrechten Striche. Wenn hier ein "
                            + "leerer Text ankommt, gibst du die Zeile vermutlich mit "
                            + "Konsole.zeige aus, statt sie zurueckzugeben.");

            assertEquals("Runde 30 | Preis 4,00 EUR | Ergebnis -356,00 EUR | Kasse -227,50 EUR",
                    Kontor.berichtszeile(30, 400, -35_600, -22_750),
                    "Auch negative Betraege muessen sauber dargestellt werden");
        }
    }

    @Nested
    @DisplayName("Stufe 2 - Kern")
    class Kern {

        @Test
        @DisplayName("Nachfrage - und die ueberladene Kurzfassung")
        void nachfrageWirdBerechnet() {
            assertEquals(525, Kontor.nachfrage(1, 250),
                    "Bei 2,50 EUR in Runde 1 werden 525 Becher nachgefragt");

            assertEquals(150, Kontor.nachfrage(1, 400),
                    "Bei 4,00 EUR bleiben nur noch 150 Nachfragende uebrig");

            assertEquals(400, Kontor.nachfrage(1),
                    "Ohne Preisangabe gilt der Referenzpreis von 3,00 EUR - das sind in "
                            + "Runde 1 genau 400 Becher");

            assertEquals(Kontor.nachfrage(7, 300), Kontor.nachfrage(7),
                    "Die Kurzfassung muss dasselbe liefern wie der Aufruf mit dem "
                            + "Referenzpreis. Wenn nicht, hast du die Rechnung ein zweites "
                            + "Mal hingeschrieben statt die andere Methode aufzurufen.");
        }

        @Test
        @DisplayName("Einkaufsmenge - Bedarf, Geld und Kapazitaet zusammen")
        void einkaufsmengeWirdBegrenzt() {
            assertEquals(7, Kontor.einkaufsmenge(1, 250, 200_000),
                    "525 Becher Nachfrage brauchen 7 Saecke, Geld und Kapazitaet reichen");

            assertEquals(3, Kontor.einkaufsmenge(1, 250, 10_000),
                    "Mit nur 100,00 EUR sind bei 28,00 EUR je Sack 3 Saecke bezahlbar - "
                            + "der Bedarf von 7 hilft nichts");

            assertEquals(12, Kontor.einkaufsmenge(1, 100, 200_000),
                    "Bei 1,00 EUR waeren 900 Becher gefragt, das braeuchte 12 Saecke - "
                            + "genau die Roestkapazitaet");

            assertEquals(12, Kontor.einkaufsmenge(7, 100, 200_000),
                    "Runde 7 ist Hochsaison: Bei 1,00 EUR werden 972 Becher nachgefragt, "
                            + "dafuer braeuchte es 13 Saecke. Die Roestmaschine schafft aber "
                            + "nur 12 - und Geld genug ist da. Wenn hier 13 herauskommt, hast "
                            + "du die Kapazitaetsgrenze beim Zerlegen verloren.");

            assertEquals(0, Kontor.einkaufsmenge(1, 250, 0),
                    "Ohne Geld wird nicht eingekauft");
        }

        @Test
        @DisplayName("Rundenergebnis - dieselben Zahlen wie in Uebung 4")
        void rundenergebnisStimmt() {
            assertEquals(21_650, Kontor.rundenergebnis(1, 250, 200_000),
                    "Bei 2,50 EUR bringt Runde 1 genau 216,50 EUR");

            assertEquals(22_400, Kontor.rundenergebnis(1, 240, 200_000),
                    "Bei 2,40 EUR sind es 224,00 EUR");

            assertEquals(-35_600, Kontor.rundenergebnis(1, 400, 200_000),
                    "Bei 4,00 EUR ein Verlust von 356,00 EUR");
        }

        @Test
        @DisplayName("Das ganze Spiel liefert die bekannten Endstaende")
        void spielLiefertBekannteWerte() {
            assertEquals(856_450, Kontor.spieleSpiel(250),
                    "Mit durchgehend 2,50 EUR stehen am Ende 8.564,50 EUR in der Kasse");

            assertEquals(842_360, Kontor.spieleSpiel(240),
                    "Mit durchgehend 2,40 EUR sind es 8.423,60 EUR");

            assertEquals(-22_750, Kontor.spieleSpiel(400),
                    "Mit 4,00 EUR ist die Roesterei nach Runde 9 pleite");
        }
    }

    @Nested
    @DisplayName("Der entscheidende Test - nichts kaputtgemacht?")
    class Gleichstand {

        @Test
        @DisplayName("Deine Fassung verhaelt sich bei JEDEM Preis wie der Monolith")
        void zerlegungAendertDasVerhaltenNicht() {
            for (int preis = 100; preis <= 500; preis += 10) {
                int vorher = KontorMonolith.spieleSpiel(preis);
                int nachher = Kontor.spieleSpiel(preis);

                assertEquals(vorher, nachher,
                        "Bei einem Verkaufspreis von " + Geld.formatiere(preis)
                                + " liefert der alte Monolith " + Geld.formatiere(vorher)
                                + ", deine zerlegte Fassung aber " + Geld.formatiere(nachher)
                                + ". Beim Aufraeumen hat sich also das Verhalten geaendert - "
                                + "und genau das darf beim Refactoring nie passieren. "
                                + "Vergleiche die Rechenschritte fuer diesen Preis Zeile fuer "
                                + "Zeile mit dem Monolithen.");
            }
        }
    }
}
