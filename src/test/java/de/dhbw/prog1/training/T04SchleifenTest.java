package de.dhbw.prog1.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.dhbw.prog1.training.T04Schleifen.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Training 4 - Schleifen")
class T04SchleifenTest {

    @Test
    @DisplayName("summeBis")
    void summeBisTest() {
        assertEquals(10, summeBis(4), "1 + 2 + 3 + 4. Kommt 6 heraus: < statt <=");
        assertEquals(1, summeBis(1));
        assertEquals(0, summeBis(0));
        assertEquals(5050, summeBis(100));
    }

    @Test
    @DisplayName("fakultaet")
    void fakultaetTest() {
        assertEquals(120, fakultaet(5));
        assertEquals(1, fakultaet(1));
        assertEquals(1, fakultaet(0), "0! ist 1 - Startwert beim Multiplizieren ist 1, nicht 0");
    }

    @Test
    @DisplayName("potenz")
    void potenzTest() {
        assertEquals(1024, potenz(2, 10));
        assertEquals(1, potenz(5, 0), "Hoch 0 ist immer 1");
        assertEquals(-27, potenz(-3, 3));
    }

    @Test
    @DisplayName("anzahlTeiler")
    void teilerTest() {
        assertEquals(6, anzahlTeiler(12));
        assertEquals(1, anzahlTeiler(1));
        assertEquals(2, anzahlTeiler(7), "Eine Primzahl hat genau zwei Teiler");
    }

    @Test
    @DisplayName("istPrimzahl")
    void primTest() {
        assertTrue(istPrimzahl(2), "2 ist die kleinste Primzahl");
        assertTrue(istPrimzahl(7));
        assertTrue(istPrimzahl(97));
        assertFalse(istPrimzahl(9));
        assertFalse(istPrimzahl(1), "1 ist keine Primzahl");
        assertFalse(istPrimzahl(0));
    }

    @Test
    @DisplayName("quersumme - while")
    void quersummeTest() {
        assertEquals(10, quersumme(1234));
        assertEquals(9, quersumme(9));
        assertEquals(0, quersumme(0));
    }

    @Test
    @DisplayName("wiederhole")
    void wiederholeTest() {
        assertEquals("ababab", wiederhole("ab", 3));
        assertEquals("x", wiederhole("x", 1));
        assertEquals("", wiederhole("x", 0));
    }

    @Test
    @DisplayName("zaehleZeichen")
    void zaehleTest() {
        assertEquals(2, zaehleZeichen("Banane", 'a'));
        assertEquals(0, zaehleZeichen("Kaffee", 'x'));
        assertEquals(0, zaehleZeichen(null, 'a'), "null darf nicht abstuerzen");
        assertEquals(3, zaehleZeichen("eee", 'e'), "Auch das letzte Zeichen zaehlt");
    }

    @Test
    @DisplayName("umkehren")
    void umkehrenTest() {
        assertEquals("cba", umkehren("abc"));
        assertEquals("a", umkehren("a"));
        assertEquals("", umkehren(""));
        assertEquals("", umkehren(null));
    }

    @Test
    @DisplayName("summeGerade")
    void summeGeradeTest() {
        assertEquals(30, summeGerade(10));
        assertEquals(20, summeGerade(9));
        assertEquals(2, summeGerade(2));
        assertEquals(0, summeGerade(1));
    }

    @Test
    @DisplayName("zaehleVokale")
    void vokaleTest() {
        assertEquals(5, zaehleVokale("Programmieren"));
        assertEquals(5, zaehleVokale("AEIOU"), "Grossbuchstaben zaehlen mit");
        assertEquals(0, zaehleVokale("xyz"));
        assertEquals(0, zaehleVokale(null));
    }

    @Test
    @DisplayName("fibonacci")
    void fibonacciTest() {
        assertEquals(0, fibonacci(0));
        assertEquals(1, fibonacci(1));
        assertEquals(1, fibonacci(2));
        assertEquals(55, fibonacci(10));
    }

    @Test
    @DisplayName("anzahlStellen")
    void stellenTest() {
        assertEquals(4, anzahlStellen(1234));
        assertEquals(1, anzahlStellen(0), "Auch 0 hat eine Stelle");
        assertEquals(1, anzahlStellen(7));
        assertEquals(3, anzahlStellen(-567));
    }

    @Test
    @DisplayName("groessteZiffer")
    void groessteZifferTest() {
        assertEquals(9, groessteZiffer(1934));
        assertEquals(2, groessteZiffer(2021));
        assertEquals(5, groessteZiffer(5));
        assertEquals(0, groessteZiffer(0));
    }

    @Test
    @DisplayName("binaer")
    void binaerTest() {
        assertEquals("0", binaer(0));
        assertEquals("1", binaer(1));
        assertEquals("101", binaer(5));
        assertEquals("1010", binaer(10), "Kommt 0101 heraus, haengst du die Ziffern hinten an statt vorn");
        assertEquals("11111111", binaer(255));
    }

    @Test
    @DisplayName("istPalindromZahl")
    void palindromZahlTest() {
        assertTrue(istPalindromZahl(12321));
        assertTrue(istPalindromZahl(1221));
        assertTrue(istPalindromZahl(7));
        assertFalse(istPalindromZahl(123));
        assertFalse(istPalindromZahl(10));
    }

    @Test
    @DisplayName("ersetzeLeerzeichen")
    void ersetzeTest() {
        assertEquals("Hallo_Welt_heute", ersetzeLeerzeichen("Hallo Welt heute"));
        assertEquals("ohne", ersetzeLeerzeichen("ohne"));
        assertEquals("", ersetzeLeerzeichen(null));
    }

    @Test
    @DisplayName("zaehleWoerter")
    void woerterTest() {
        assertEquals(2, zaehleWoerter("Hallo Welt"));
        assertEquals(3, zaehleWoerter("  viele   Leerzeichen  hier "),
                "Mehrere Leerzeichen hintereinander trennen nur ein Wortpaar");
        assertEquals(1, zaehleWoerter("eins"));
        assertEquals(0, zaehleWoerter(""));
        assertEquals(0, zaehleWoerter(null));
    }

    @Test
    @DisplayName("collatzSchritte - while")
    void collatzTest() {
        assertEquals(0, collatzSchritte(1));
        assertEquals(1, collatzSchritte(2));
        assertEquals(8, collatzSchritte(6));
        assertEquals(111, collatzSchritte(27));
    }

    @Test
    @DisplayName("kleinsterTeiler")
    void kleinsterTeilerTest() {
        assertEquals(3, kleinsterTeiler(15));
        assertEquals(7, kleinsterTeiler(49));
        assertEquals(13, kleinsterTeiler(13));
        assertEquals(2, kleinsterTeiler(2));
    }
}
