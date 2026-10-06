package de.dhbw.prog1.ue02;

import de.dhbw.prog1.kern.Geld;
import de.dhbw.prog1.kern.Markt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests zu Uebung 2.
 *
 * <p>Diese Datei musst du nicht veraendern - sie ist deine Selbstkontrolle. Wenn ein Test rot ist,
 * lies die Fehlermeldung: Sie sagt dir im Klartext, was erwartet wurde und was herauskam.
 *
 * <p>Ausfuehren in der IDE ueber das gruene Dreieck neben der Klasse, oder auf der
 * Kommandozeile mit {@code mvn test}.
 */
@DisplayName("Uebung 2 - Eine Runde im Kaffee-Kontor")
class RundeTest {

    @Nested
    @DisplayName("Stufe 1 - Basis")
    class Basis {

        @Test
        @DisplayName("Einkaufskosten sind Anzahl mal Preis")
        void einkaufskostenWerdenMultipliziert() {
            assertEquals(28_000, Runde.einkaufskosten(10, 2800),
                    "10 Saecke zu je 28,00 EUR muessen 280,00 EUR kosten");

            assertEquals(0, Runde.einkaufskosten(0, 2800),
                    "Wer nichts einkauft, zahlt nichts");

            assertEquals(3_650, Runde.einkaufskosten(1, 3650),
                    "Ein einzelner Sack kostet genau den Marktpreis");
        }

        @Test
        @DisplayName("Erloes ist verkaufte Menge mal Verkaufspreis")
        void erloesWirdMultipliziert() {
            assertEquals(120_000, Runde.erloes(400, 300),
                    "400 Becher zu je 3,00 EUR ergeben 1.200,00 EUR Erloes");

            assertEquals(0, Runde.erloes(0, 300),
                    "Ohne Verkauf kommt nichts in die Kasse");
        }
    }

    @Nested
    @DisplayName("Stufe 2 - Kern")
    class Kern {

        @Test
        @DisplayName("Bechervorrat benutzt die Konstante BECHER_PRO_SACK")
        void bechervorratWirdAusSaeckenBerechnet() {
            assertEquals(800, Runde.bechervorrat(10),
                    "Aus 10 Saecken zu je 80 Bechern werden 800 Becher");

            assertEquals(0, Runde.bechervorrat(0),
                    "Ohne Saecke gibt es keinen Kaffee");
        }

        @Test
        @DisplayName("Verkauft wird immer der kleinere der beiden Werte")
        void esWirdNieMehrVerkauftAlsMoeglich() {
            assertEquals(400, Runde.verkaufteBecher(800, 400),
                    "Bei 800 Bechern Vorrat und nur 400 Nachfragenden bleiben 400 uebrig - "
                            + "verkauft werden 400");

            assertEquals(200, Runde.verkaufteBecher(200, 400),
                    "Bei nur 200 Bechern Vorrat koennen auch bei 400 Nachfragenden "
                            + "hoechstens 200 verkauft werden");

            assertEquals(300, Runde.verkaufteBecher(300, 300),
                    "Wenn Vorrat und Nachfrage gleich sind, wird alles verkauft");
        }

        @Test
        @DisplayName("Rohstoffkosten je Becher - Achtung, Ganzzahldivision")
        void rohstoffkostenWerdenAbgerundet() {
            assertEquals(35, Runde.rohstoffkostenProBecherInCent(2800),
                    "2800 Cent geteilt durch 80 Becher sind glatt 35 Cent");

            assertEquals(43, Runde.rohstoffkostenProBecherInCent(3500),
                    "3500 geteilt durch 80 waeren rechnerisch 43,75 Cent. Java rechnet mit "
                            + "zwei ganzen Zahlen aber ganzzahlig und schneidet den Rest ab - "
                            + "erwartet wird also 43, nicht 44. Wenn hier 44 herauskommt, hast "
                            + "du vermutlich mit double gerechnet und gerundet.");

            assertEquals(45, Runde.rohstoffkostenProBecherInCent(3650),
                    "3650 geteilt durch 80 sind 45,625 - abgeschnitten also 45");
        }

        @Test
        @DisplayName("Deckungsbeitrag ist Verkaufspreis minus Rohstoffkosten")
        void deckungsbeitragWirdBerechnet() {
            assertEquals(265, Runde.deckungsbeitragProBecherInCent(300, 2800),
                    "Bei 3,00 EUR Verkaufspreis und 35 Cent Rohstoffkosten bleiben "
                            + "2,65 EUR Deckungsbeitrag je Becher");

            assertEquals(157, Runde.deckungsbeitragProBecherInCent(200, 3500),
                    "Bei 2,00 EUR Verkaufspreis und 43 Cent Rohstoffkosten bleiben 1,57 EUR");
        }

        @Test
        @DisplayName("Kassenstand: Kasse minus Einkauf plus Erloes minus Fix- und Lagerkosten")
        void kassenstandWirdVollstaendigBerechnet() {
            int ergebnis = Runde.kassenstandNachRunde(200_000, 28_000, 120_000, 5);
            assertEquals(201_850, ergebnis,
                    "2000,00 - 280,00 + 1200,00 - 900,00 Fixkosten - 5 x 0,30 Lagerkosten "
                            + "ergibt 2018,50 EUR. Herausgekommen ist " + Geld.formatiere(ergebnis)
                            + ". Fehlen vielleicht die Lagerkosten?");
        }

        @Test
        @DisplayName("Ein schlechtes Geschaeft darf die Kasse ins Minus ziehen")
        void kassenstandDarfNegativWerden() {
            int ergebnis = Runde.kassenstandNachRunde(50_000, 30_000, 10_000, 10);
            assertEquals(-60_300, ergebnis,
                    "500,00 - 300,00 + 100,00 - 900,00 - 10 x 0,30 ergibt -603,00 EUR. "
                            + "Die Methode soll nicht bei null abbrechen - ob das Bankrott "
                            + "bedeutet, entscheiden wir erst in Einheit 3.");
        }
    }

    @Nested
    @DisplayName("Zusammenspiel mit dem Rahmenwerk")
    class Zusammenspiel {

        @Test
        @DisplayName("Eine vollstaendige Runde 1 laesst sich durchrechnen")
        void vollstaendigeRundeMitMarktdaten() {
            int runde = 1;
            int verkaufspreis = 250;

            int marktpreis = Markt.preisProSackInCent(runde);
            int nachfrage = Markt.nachfrageInBechern(runde, verkaufspreis);

            assertEquals(2800, marktpreis,
                    "In Runde 1 kostet ein Sack laut Markt 28,00 EUR");
            assertEquals(525, nachfrage,
                    "Bei 2,50 EUR liegt der Preis 50 Cent unter dem Referenzpreis, "
                            + "die Nachfrage steigt daher von 400 auf 525 Becher");

            int saecke = 7;
            int kosten = Runde.einkaufskosten(saecke, marktpreis);
            int vorrat = Runde.bechervorrat(saecke);
            int verkauft = Runde.verkaufteBecher(vorrat, nachfrage);
            int einnahmen = Runde.erloes(verkauft, verkaufspreis);
            int kasse = Runde.kassenstandNachRunde(200_000, kosten, einnahmen, 0);

            assertEquals(525, verkauft,
                    "7 Saecke ergeben 560 Becher, nachgefragt werden 525 - verkauft werden 525");
            assertEquals(131_250, einnahmen,
                    "525 Becher zu 2,50 EUR ergeben 1.312,50 EUR");
            assertEquals(221_650, kasse,
                    "2000,00 - 196,00 Einkauf + 1312,50 Erloes - 900,00 Fixkosten "
                            + "ergibt 2216,50 EUR");
        }
    }
}
