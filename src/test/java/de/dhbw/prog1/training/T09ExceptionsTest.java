package de.dhbw.prog1.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.dhbw.prog1.training.T09Exceptions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Training 9 - Exceptions")
class T09ExceptionsTest {

    @Test
    @DisplayName("zahlOderNull")
    void zahlOderNullTest() {
        assertEquals(42, zahlOderNull("42"));
        assertEquals(7, zahlOderNull(" 7 "));
        assertEquals(0, zahlOderNull("vier"), "Unbrauchbar ergibt 0 - kein Absturz");
        assertEquals(0, zahlOderNull(null));
    }

    @Test
    @DisplayName("istZahl")
    void istZahlTest() {
        assertTrue(istZahl("42"));
        assertTrue(istZahl("-7"));
        assertFalse(istZahl("4.2"));
        assertFalse(istZahl(""));
        assertFalse(istZahl(null));
    }

    @Test
    @DisplayName("teile - eigene Ausnahme statt ArithmeticException")
    void teileTest() {
        assertEquals(5, teile(10, 2));
        assertThrows(IllegalArgumentException.class, () -> teile(10, 0),
                "Bei 0 soll eine IllegalArgumentException fliegen");
    }

    @Test
    @DisplayName("pruefeAlter")
    void alterTest() {
        assertEquals(30, pruefeAlter(30));
        assertEquals(0, pruefeAlter(0));
        assertEquals(150, pruefeAlter(150));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> pruefeAlter(-1));
        assertTrue(e.getMessage() != null && e.getMessage().contains("-1"),
                "Die Meldung soll den falschen Wert nennen");
        assertThrows(IllegalArgumentException.class, () -> pruefeAlter(151));
    }

    @Test
    @DisplayName("Eigene Ausnahme liefert die Eingabe mit")
    void eigeneAusnahmeTest() {
        T09UngueltigeEingabeException e = new T09UngueltigeEingabeException("Test", "abc");
        assertEquals("abc", e.eingabe());
        assertEquals("Test", e.getMessage());
        assertFalse(RuntimeException.class.isInstance(e), "Sie soll eine gepruefte Ausnahme sein");
    }

    @Test
    @DisplayName("zahlStreng - wirft die eigene Ausnahme")
    void zahlStrengTest() throws Exception {
        assertEquals(17, zahlStreng(" 17 "));
        T09UngueltigeEingabeException e =
                assertThrows(T09UngueltigeEingabeException.class, () -> zahlStreng("abc"));
        assertEquals("abc", e.eingabe(), "Die Ausnahme soll die fehlerhafte Eingabe mitliefern");
        assertThrows(T09UngueltigeEingabeException.class, () -> zahlStreng(null));
    }

    @Test
    @DisplayName("elementOderStandard")
    void elementTest() {
        int[] werte = {7, 8, 9};
        assertEquals(8, elementOderStandard(werte, 1, -1));
        assertEquals(-1, elementOderStandard(werte, 3, -1), "Position 3 gibt es nicht");
        assertEquals(-1, elementOderStandard(werte, -1, -1));
        assertEquals(-1, elementOderStandard(null, 0, -1));
    }

    @Test
    @DisplayName("summeGueltiger - die Schleife bricht nicht ab")
    void summeTest() {
        assertEquals(5, summeGueltiger(new String[]{"3", "x", "4", null, "-2"}),
                "3 + 4 - 2. Unbrauchbare Eintraege werden uebersprungen, nicht die ganze Summe");
    }

    @Test
    @DisplayName("pruefeNichtLeer")
    void pruefeNichtLeerTest() {
        assertEquals("Anna", pruefeNichtLeer("  Anna "));
        assertThrows(IllegalArgumentException.class, () -> pruefeNichtLeer("   "),
                "Nur Leerzeichen gilt als leer");
        assertThrows(IllegalArgumentException.class, () -> pruefeNichtLeer(null),
                "Bei null eine IllegalArgumentException - keine NullPointerException");
    }

    @Test
    @DisplayName("prozent")
    void prozentTest() {
        assertEquals(25, prozent(1, 4));
        assertThrows(IllegalArgumentException.class, () -> prozent(1, 0));
        assertThrows(IllegalArgumentException.class, () -> prozent(1, -4));
    }

    @Test
    @DisplayName("ganzzahligeWurzel")
    void wurzelTest() {
        assertEquals(3, ganzzahligeWurzel(15));
        assertEquals(4, ganzzahligeWurzel(16));
        assertEquals(1, ganzzahligeWurzel(1));
        assertEquals(0, ganzzahligeWurzel(0));
        assertThrows(IllegalArgumentException.class, () -> ganzzahligeWurzel(-1));
    }

    @Test
    @DisplayName("zahlOderStandard")
    void zahlOderStandardTest() {
        assertEquals(42, zahlOderStandard("42", -1));
        assertEquals(-1, zahlOderStandard("vier", -1));
        assertEquals(99, zahlOderStandard(null, 99));
    }

    @Test
    @DisplayName("tagAusDatum - gueltig")
    void tagGueltig() throws T09UngueltigeEingabeException {
        assertEquals(17, tagAusDatum("17.09.2026"));
        assertEquals(1, tagAusDatum("01.01.2000"));
    }

    @Test
    @DisplayName("tagAusDatum - ungueltig mit eigener Ausnahme")
    void tagUngueltig() {
        T09UngueltigeEingabeException e = assertThrows(T09UngueltigeEingabeException.class,
                () -> tagAusDatum("xx.09.2026"), "Der Tag ist keine Zahl");
        assertEquals("xx.09.2026", e.eingabe(), "Die Ausnahme liefert die fehlerhafte Eingabe mit");
        assertThrows(T09UngueltigeEingabeException.class, () -> tagAusDatum("32.01.2026"));
        assertThrows(T09UngueltigeEingabeException.class, () -> tagAusDatum("00.01.2026"));
        assertThrows(T09UngueltigeEingabeException.class, () -> tagAusDatum("17-09-2026"));
        assertThrows(T09UngueltigeEingabeException.class, () -> tagAusDatum("7.9.2026"));
        T09UngueltigeEingabeException leer = assertThrows(T09UngueltigeEingabeException.class,
                () -> tagAusDatum(null), "Auch null ergibt die eigene Ausnahme");
        assertNull(leer.eingabe());
    }

    @Test
    @DisplayName("divisionMitRest")
    void divisionTest() {
        assertEquals("7 : 2 = 3 Rest 1", divisionMitRest(7, 2));
        assertEquals("9 : 3 = 3 Rest 0", divisionMitRest(9, 3));
        assertThrows(IllegalArgumentException.class, () -> divisionMitRest(7, 0));
    }

    @Test
    @DisplayName("anzahlUngueltiger")
    void ungueltigeTest() {
        assertEquals(2, anzahlUngueltiger(new String[]{"1", "zwei", "3", null}));
        assertEquals(0, anzahlUngueltiger(new String[]{"1", " 2 "}));
        assertEquals(0, anzahlUngueltiger(null));
    }

    @Test
    @DisplayName("mittelwert")
    void mittelwertTest() {
        assertEquals(5, mittelwert(new int[]{2, 4, 9}));
        assertThrows(IllegalArgumentException.class, () -> mittelwert(new int[0]),
                "Leer: IllegalArgumentException statt ArithmeticException");
        assertThrows(IllegalArgumentException.class, () -> mittelwert(null));
    }

    @Test
    @DisplayName("pruefeBereich - Meldung nennt die Werte")
    void bereichTest() {
        assertEquals(5, pruefeBereich(5, 1, 10));
        assertEquals(10, pruefeBereich(10, 1, 10));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> pruefeBereich(12, 1, 10));
        assertEquals("Wert 12 liegt nicht zwischen 1 und 10", e.getMessage());
        assertThrows(IllegalArgumentException.class, () -> pruefeBereich(0, 1, 10));
    }

    @Test
    @DisplayName("zeichenOderFragezeichen - vorher pruefen")
    void zeichenTest() {
        assertEquals('l', zeichenOderFragezeichen("Hallo", 2));
        assertEquals('o', zeichenOderFragezeichen("Hallo", 4));
        assertEquals('?', zeichenOderFragezeichen("Hallo", 5), "Position 5 gibt es bei 5 Zeichen nicht");
        assertEquals('?', zeichenOderFragezeichen("Hallo", -1));
        assertEquals('?', zeichenOderFragezeichen(null, 0));
    }

    @Test
    @DisplayName("summeStreng - Ausnahme weiterreichen")
    void summeStrengTest() throws T09UngueltigeEingabeException {
        assertEquals(6, summeStreng(new String[]{"1", " 2", "3"}));
        T09UngueltigeEingabeException e = assertThrows(T09UngueltigeEingabeException.class,
                () -> summeStreng(new String[]{"1", "x", "y"}));
        assertEquals("x", e.eingabe(), "Der erste unbrauchbare Eintrag bricht ab");
    }
}
