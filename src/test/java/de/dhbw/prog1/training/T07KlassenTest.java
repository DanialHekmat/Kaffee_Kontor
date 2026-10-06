package de.dhbw.prog1.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Training 7 - Klassen und Objekte")
class T07KlassenTest {

    @Test
    @DisplayName("Zaehler: Startwert und stand")
    void zaehlerStart() {
        assertEquals(5, new T07Zaehler(5).stand(), "Der Konstruktor setzt den Startwert");
    }

    @Test
    @DisplayName("Zaehler: erhoehe")
    void zaehlerErhoehe() {
        T07Zaehler z = new T07Zaehler(5);
        z.erhoehe();
        z.erhoehe();
        assertEquals(7, z.stand(), "Zweimal erhoehen merkt sich das Objekt");
    }

    @Test
    @DisplayName("Zaehler: erhoeheUm")
    void zaehlerErhoeheUm() {
        T07Zaehler z = new T07Zaehler(5);
        z.erhoeheUm(10);
        z.erhoeheUm(-3);
        assertEquals(12, z.stand());
    }

    @Test
    @DisplayName("Zaehler: zuruecksetzen auf den Startwert, nicht auf 0")
    void zaehlerZuruecksetzen() {
        T07Zaehler z = new T07Zaehler(5);
        z.erhoeheUm(10);
        z.zuruecksetzen();
        assertEquals(5, z.stand(),
                "Zurueck auf den Startwert. Dafuer muss sich das Objekt ihn in einem eigenen "
                        + "Attribut merken.");
    }

    @Test
    @DisplayName("Zaehler: zwei Objekte sind unabhaengig")
    void zaehlerUnabhaengig() {
        T07Zaehler a = new T07Zaehler(1);
        T07Zaehler b = new T07Zaehler(100);
        a.erhoehe();
        assertEquals(2, a.stand());
        assertEquals(100, b.stand(), "Kommt hier 2, ist ein Attribut versehentlich static");
    }

    @Test
    @DisplayName("Rechteck: flaeche")
    void rechteckFlaeche() {
        assertEquals(12, new T07Rechteck(3, 4).flaeche());
    }

    @Test
    @DisplayName("Rechteck: umfang")
    void rechteckUmfang() {
        assertEquals(14, new T07Rechteck(3, 4).umfang());
    }

    @Test
    @DisplayName("Rechteck: istQuadrat")
    void rechteckQuadrat() {
        assertTrue(new T07Rechteck(5, 5).istQuadrat());
        assertFalse(new T07Rechteck(3, 4).istQuadrat());
    }

    @Test
    @DisplayName("Rechteck: toString")
    void rechteckText() {
        assertEquals("Rechteck 3x4", new T07Rechteck(3, 4).toString());
    }

    @Test
    @DisplayName("Konto: neu mit Inhaber und Kontostand 0")
    void kontoNeu() {
        T07Konto konto = new T07Konto("Anna");
        assertEquals("Anna", konto.inhaber(), "Der Konstruktor merkt sich den Inhaber");
        assertEquals(0, konto.kontostand());
    }

    @Test
    @DisplayName("Konto: einzahlen")
    void kontoEinzahlen() {
        T07Konto konto = new T07Konto("Anna");
        konto.einzahlen(100);
        konto.einzahlen(50);
        assertEquals(150, konto.kontostand());
    }

    @Test
    @DisplayName("Konto: einzahlen ignoriert 0 und negative Betraege")
    void kontoEinzahlenUngueltig() {
        T07Konto konto = new T07Konto("Anna");
        konto.einzahlen(100);
        konto.einzahlen(-30);
        konto.einzahlen(0);
        assertEquals(100, konto.kontostand(), "Eine negative Einzahlung waere eine versteckte Abhebung");
    }

    @Test
    @DisplayName("Konto: abheben mit Deckung")
    void kontoAbheben() {
        T07Konto konto = new T07Konto("Anna");
        konto.einzahlen(100);
        assertTrue(konto.abheben(40));
        assertEquals(60, konto.kontostand());
        assertTrue(konto.abheben(60), "Genau alles abheben ist erlaubt");
        assertEquals(0, konto.kontostand());
    }

    @Test
    @DisplayName("Konto: abheben ohne Deckung oder mit Unsinn scheitert")
    void kontoAbhebenUngueltig() {
        T07Konto konto = new T07Konto("Anna");
        konto.einzahlen(100);
        assertFalse(konto.abheben(101));
        assertFalse(konto.abheben(-5));
        assertFalse(konto.abheben(0));
        assertEquals(100, konto.kontostand(), "Gescheiterte Abhebungen aendern nichts");
    }

    @Test
    @DisplayName("Konto: toString")
    void kontoToString() {
        T07Konto konto = new T07Konto("Anna");
        konto.einzahlen(110);
        assertEquals("Konto Anna: 110", konto.toString());
    }

    @Test
    @DisplayName("Punkt: Konstruktor und Getter")
    void punktNeu() {
        T07Punkt p = new T07Punkt(3, 4);
        assertEquals(3, p.x());
        assertEquals(4, p.y());
    }

    @Test
    @DisplayName("Punkt: verschiebe aendert diesen Punkt")
    void punktVerschiebe() {
        T07Punkt p = new T07Punkt(3, 4);
        p.verschiebe(2, -5);
        assertEquals(5, p.x());
        assertEquals(-1, p.y());
    }

    @Test
    @DisplayName("Punkt: zwei Objekte sind unabhaengig")
    void punkteUnabhaengig() {
        T07Punkt a = new T07Punkt(1, 1);
        T07Punkt b = new T07Punkt(1, 1);
        a.verschiebe(10, 0);
        assertEquals(11, a.x());
        assertEquals(1, b.x(), "Hast du x static gemacht? Dann teilen sich alle Punkte ein x");
    }

    @Test
    @DisplayName("Punkt: abstandQuadratZumUrsprung")
    void punktAbstand() {
        assertEquals(25, new T07Punkt(3, 4).abstandQuadratZumUrsprung());
        assertEquals(25, new T07Punkt(-3, -4).abstandQuadratZumUrsprung());
    }

    @Test
    @DisplayName("Punkt: toString")
    void punktToString() {
        assertEquals("(3|4)", new T07Punkt(3, 4).toString());
        assertEquals("(-1|0)", new T07Punkt(-1, 0).toString());
    }
}
