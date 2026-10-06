package de.dhbw.prog1.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.dhbw.prog1.training.T01VariablenRechnen.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Training 1 - Variablen und Rechnen")
class T01VariablenRechnenTest {

    @Test
    @DisplayName("volleMinuten")
    void volleMinutenTest() {
        assertEquals(2, volleMinuten(125), "125 Sekunden sind 2 volle Minuten");
        assertEquals(1, volleMinuten(60), "Genau 60 Sekunden sind 1 Minute");
        assertEquals(0, volleMinuten(59), "59 Sekunden sind noch keine volle Minute");
    }

    @Test
    @DisplayName("restSekunden")
    void restSekundenTest() {
        assertEquals(5, restSekunden(125), "125 Sekunden: 2 Minuten und 5 Sekunden Rest");
        assertEquals(0, restSekunden(120), "120 Sekunden gehen glatt auf");
        assertEquals(59, restSekunden(59), "Unter einer Minute ist alles Rest");
    }

    @Test
    @DisplayName("bruttoInCent - ganzzahlige Steuer")
    void bruttoTest() {
        assertEquals(1190, bruttoInCent(1000, 19), "1000 Cent plus 19 Prozent");
        assertEquals(1188, bruttoInCent(999, 19),
                "999 * 19 / 100 sind rechnerisch 189,81 - ganzzahlig 189. Zusammen 1188.");
        assertEquals(1000, bruttoInCent(1000, 0), "Ohne Steuer bleibt es beim Netto");
    }

    @Test
    @DisplayName("durchschnitt - mit Nachkommastellen")
    void durchschnittTest() {
        assertEquals(3.5, durchschnitt(3, 4), 1e-9,
                "Kommt hier 3.0 heraus, wurde ganzzahlig geteilt. Teile durch 2.0 statt 2.");
        assertEquals(3.0, durchschnitt(2, 4), 1e-9);
        assertEquals(-0.5, durchschnitt(-2, 1), 1e-9);
    }

    @Test
    @DisplayName("istGerade - auch negativ")
    void istGeradeTest() {
        assertTrue(istGerade(4));
        assertTrue(istGerade(0), "0 ist gerade");
        assertTrue(istGerade(-4), "-4 ist gerade");
        assertFalse(istGerade(7));
        assertFalse(istGerade(-7),
                "-7 % 2 ergibt in Java -1, nicht 1. Pruefe deshalb auf == 0 statt auf == 1.");
    }

    @Test
    @DisplayName("letzteZiffer - immer positiv")
    void letzteZifferTest() {
        assertEquals(4, letzteZiffer(1234));
        assertEquals(7, letzteZiffer(-567), "Bei negativen Zahlen ist der Rest negativ - Math.abs");
        assertEquals(0, letzteZiffer(100));
    }

    @Test
    @DisplayName("rundeAufZehnerAuf")
    void rundeAufTest() {
        assertEquals(10, rundeAufZehnerAuf(1));
        assertEquals(10, rundeAufZehnerAuf(10), "Glatte Zehner bleiben, wie sie sind");
        assertEquals(20, rundeAufZehnerAuf(11));
        assertEquals(0, rundeAufZehnerAuf(0));
    }

    @Test
    @DisplayName("celsiusZuFahrenheit")
    void fahrenheitTest() {
        assertEquals(212, celsiusZuFahrenheit(100),
                "100 * 9 / 5 + 32 = 212. Kommt 132 heraus, wurde zuerst 9 / 5 gerechnet - "
                        + "das ergibt ganzzahlig 1. Erst multiplizieren, dann teilen.");
        assertEquals(32, celsiusZuFahrenheit(0));
        assertEquals(-40, celsiusZuFahrenheit(-40), "Bei -40 sind beide Skalen gleich");
        assertEquals(98, celsiusZuFahrenheit(37), "37 * 9 / 5 = 66 (ganzzahlig), plus 32 = 98");
    }

    @Test
    @DisplayName("uhrzeit - zweistellig")
    void uhrzeitTest() {
        assertEquals("08:05", uhrzeit(8, 5));
        assertEquals("23:59", uhrzeit(23, 59));
        assertEquals("00:00", uhrzeit(0, 0));
    }

    @Test
    @DisplayName("volleStunden")
    void volleStundenTest() {
        assertEquals(2, volleStunden(130));
        assertEquals(2, volleStunden(120));
        assertEquals(0, volleStunden(59));
    }

    @Test
    @DisplayName("sekundenGesamt")
    void sekundenGesamtTest() {
        assertEquals(3723, sekundenGesamt(1, 2, 3));
        assertEquals(59, sekundenGesamt(0, 0, 59));
    }

    @Test
    @DisplayName("nettoAusBrutto")
    void nettoTest() {
        assertEquals(1000, nettoAusBrutto(1190, 19));
        assertEquals(840, nettoAusBrutto(1000, 19), "100000 / 119 sind rechnerisch 840,34 - ganzzahlig 840");
        assertEquals(500, nettoAusBrutto(500, 0));
    }

    @Test
    @DisplayName("rabattierterPreis")
    void rabattTest() {
        assertEquals(1500, rabattierterPreis(2000, 25));
        assertEquals(900, rabattierterPreis(999, 10), "Der Rabatt ist ganzzahlig 99 Cent");
        assertEquals(500, rabattierterPreis(500, 0));
    }

    @Test
    @DisplayName("prozentAnteil - mit Nachkommastellen")
    void prozentTest() {
        assertEquals(25.0, prozentAnteil(1, 4), 1e-9);
        assertEquals(100.0 / 3, prozentAnteil(1, 3), 1e-9,
                "Kommt 33.0 heraus, wurde ganzzahlig gerechnet. Tipp: 100.0 statt 100");
    }

    @Test
    @DisplayName("anzahlKisten - aufgerundet")
    void kistenTest() {
        assertEquals(3, anzahlKisten(13, 6));
        assertEquals(2, anzahlKisten(12, 6), "Glatt aufgehend - keine zusaetzliche Kiste");
        assertEquals(0, anzahlKisten(0, 6));
    }

    @Test
    @DisplayName("restFlaschen")
    void restTest() {
        assertEquals(1, restFlaschen(13, 6));
        assertEquals(0, restFlaschen(12, 6));
        assertEquals(5, restFlaschen(5, 6));
    }

    @Test
    @DisplayName("zehnerstelle")
    void zehnerTest() {
        assertEquals(3, zehnerstelle(1234));
        assertEquals(6, zehnerstelle(-567));
        assertEquals(0, zehnerstelle(7));
    }

    @Test
    @DisplayName("ersterBuchstabe")
    void ersterTest() {
        assertEquals('H', ersterBuchstabe("Hallo"));
        assertEquals('x', ersterBuchstabe("x"));
    }

    @Test
    @DisplayName("initialen")
    void initialenTest() {
        assertEquals("A.S.", initialen("Anna", "Schulz"));
        assertEquals("M.M.", initialen("max", "mustermann"), "Initialen immer gross");
    }

    @Test
    @DisplayName("sekundenInJahren - long und Ueberlauf")
    void jahreTest() {
        assertEquals(31_536_000L, sekundenInJahren(1));
        assertEquals(3_153_600_000L, sekundenInJahren(100),
                "Das passt nicht in ein int. Kommt eine negative Zahl heraus, ist das "
                        + "Zwischenergebnis uebergelaufen - rechne mit 365L statt 365");
    }
}
