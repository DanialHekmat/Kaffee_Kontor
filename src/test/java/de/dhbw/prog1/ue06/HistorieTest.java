package de.dhbw.prog1.ue06;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests zu Uebung 6.
 *
 * <p>Diese Datei musst du nicht veraendern - sie ist deine Selbstkontrolle.
 */
@DisplayName("Uebung 6 - Arrays im Kaffee-Kontor")
class HistorieTest {

    @Nested
    @DisplayName("Stufe 1 - Basis")
    class Basis {

        @Test
        @DisplayName("Preishistorie - richtige Laenge, richtige Zuordnung")
        void historieWirdGefuellt() {
            assertArrayEquals(new int[]{3800, 3700, 3500}, Historie.preishistorie(9, 11),
                    "Runde 9 bis 11 ergibt drei Werte: An Position 0 steht der Preis von "
                            + "Runde 9, an Position 2 der von Runde 11.");

            assertArrayEquals(new int[]{2800}, Historie.preishistorie(1, 1),
                    "Von Runde 1 bis Runde 1 ist genau ein Wert");

            assertArrayEquals(new int[]{2800, 2750, 2900, 3050, 3200},
                    Historie.preishistorie(1, 5),
                    "Die ersten fuenf Runden");

            assertEquals(30, Historie.preishistorie(1, 30).length,
                    "Von Runde 1 bis 30 sind es 30 Werte. Wenn hier 29 herauskommt, fehlt "
                            + "das + 1 in der Laengenberechnung.");
        }

        @Test
        @DisplayName("Summe mit for-each")
        void werteWerdenAddiert() {
            assertEquals(8450, Historie.summe(new int[]{2800, 2750, 2900}),
                    "28,00 + 27,50 + 29,00 EUR ergeben 84,50 EUR");

            assertEquals(0, Historie.summe(new int[0]),
                    "Die Summe von nichts ist null - dafuer braucht es keine Sonderabfrage, "
                            + "die Schleife laeuft einfach null Mal");

            assertEquals(93_100, Historie.summe(Historie.preishistorie(1, 30)),
                    "Alle 30 Sackpreise zusammen ergeben 931,00 EUR");
        }
    }

    @Nested
    @DisplayName("Stufe 2 - Kern")
    class Kern {

        @Test
        @DisplayName("Guenstigster Index - die Position, nicht der Preis")
        void guenstigsterIndexWirdGefunden() {
            assertEquals(1, Historie.guenstigsterIndex(new int[]{2800, 2750, 2900, 3050}),
                    "Der niedrigste Wert 2750 steht an Position 1. Wenn hier 2750 "
                            + "herauskommt, gibst du den Preis zurueck statt die Position.");

            assertEquals(16, Historie.guenstigsterIndex(Historie.preishistorie(1, 30)),
                    "Der guenstigste Preis des Spiels liegt in Runde 17 - im Array ist das "
                            + "Position 16, denn Arrays zaehlen ab 0. Wenn hier 17 "
                            + "herauskommt, hast du Position und Rundennummer verwechselt.");

            assertEquals(0, Historie.guenstigsterIndex(new int[]{2700, 2700}),
                    "Bei Gleichstand gewinnt die kleinere Position");

            assertEquals(0, Historie.guenstigsterIndex(new int[]{500}),
                    "Bei einem einzigen Wert ist es Position 0");

            int leer = assertDoesNotThrow(
                    () -> Historie.guenstigsterIndex(new int[0]),
                    "Bei einem leeren Array darf die Methode nicht abstuerzen. Wenn hier "
                            + "eine ArrayIndexOutOfBoundsException fliegt, greifst du auf "
                            + "preise[0] zu, ohne vorher die Laenge zu pruefen.");

            assertEquals(-1, leer,
                    "Ein leeres Array hat keine guenstigste Position - erwartet wird -1");
        }

        @Test
        @DisplayName("Durchschnitt - abgeschnitten, und ohne Division durch null")
        void durchschnittWirdBerechnet() {
            assertEquals(2816, Historie.durchschnitt(new int[]{2800, 2750, 2900}),
                    "8450 geteilt durch 3 sind rechnerisch 2816,67 - Java schneidet ab "
                            + "und liefert 2816");

            assertEquals(3103, Historie.durchschnitt(Historie.preishistorie(1, 30)),
                    "93100 geteilt durch 30 ergibt abgeschnitten 3103 Cent");

            int leer = assertDoesNotThrow(
                    () -> Historie.durchschnitt(new int[0]),
                    "Bei einem leeren Array wuerde durch null geteilt - das beendet das "
                            + "Programm mit einer ArithmeticException. Diesen Fall musst du "
                            + "vorher abfangen.");

            assertEquals(0, leer,
                    "Der Durchschnitt eines leeren Arrays ist als 0 vereinbart");
        }

        @Test
        @DisplayName("Ein Ergebnis je Preis, in derselben Reihenfolge")
        void ergebnisseWerdenZugeordnet() {
            assertArrayEquals(
                    new int[]{14_800, 22_400, 21_650, 16_000, -35_600},
                    Historie.ergebnisseFuerPreise(1, new int[]{200, 240, 250, 300, 400},
                            200_000),
                    "Zu jedem Preis das Rundenergebnis, an derselben Position. 2,40 EUR "
                            + "bringt mit 224,00 EUR am meisten, 4,00 EUR kostet 356,00 EUR.");

            assertEquals(0, Historie.ergebnisseFuerPreise(1, new int[0], 200_000).length,
                    "Ohne Preise gibt es auch keine Ergebnisse - das Array bleibt leer");
        }

        @Test
        @DisplayName("Die Tabelle: Zeilen sind Preise, Spalten sind Runden")
        void tabelleWirdAufgebaut() {
            int[][] tabelle = Historie.ergebnisTabelle(new int[]{240, 250}, 1, 3, 200_000);

            assertEquals(2, tabelle.length,
                    "Zwei Preise ergeben zwei Zeilen");

            assertEquals(3, tabelle[0].length,
                    "Runde 1 bis 3 ergibt drei Spalten. Wenn hier 2 herauskommt, fehlt "
                            + "wieder das + 1; wenn 3 statt 2 Zeilen herauskommen, hast du "
                            + "Zeilen und Spalten vertauscht.");

            assertArrayEquals(new int[]{22_400, 24_670, 23_600}, tabelle[0],
                    "Erste Zeile: Preis 2,40 EUR ueber die Runden 1 bis 3");

            assertArrayEquals(new int[]{21_650, 24_000, 25_950}, tabelle[1],
                    "Zweite Zeile: Preis 2,50 EUR ueber die Runden 1 bis 3");

            assertEquals(25_950, tabelle[1][2],
                    "Die Zelle unten rechts: Preis 2,50 EUR in Runde 3. Beachte, dass hier "
                            + "der hoehere Preis besser abschneidet als 2,40 EUR - anders als "
                            + "in Runde 1.");
        }

        @Test
        @DisplayName("Die grosse Tabelle hat die richtigen Ausmasse")
        void grosseTabelleStimmt() {
            int[] preise = {200, 220, 240, 260, 280, 300};
            int[][] tabelle = Historie.ergebnisTabelle(preise, 1, 30, 200_000);

            assertEquals(6, tabelle.length, "Sechs Preise, sechs Zeilen");
            assertEquals(30, tabelle[5].length, "Dreissig Runden, dreissig Spalten");

            assertEquals(Historie.ergebnisseFuerPreise(7, preise, 200_000)[3],
                    tabelle[3][6],
                    "Die Zelle [3][6] gehoert zum vierten Preis in Runde 7 und muss "
                            + "dasselbe liefern wie die einzelne Berechnung fuer diese Runde. "
                            + "Achte auf den Versatz: Spalte 6 ist Runde 7.");
        }
    }
}
