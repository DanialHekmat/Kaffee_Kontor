package de.dhbw.prog1.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.dhbw.prog1.training.T03Grenzwerte.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Training 3 - Grenzwerte")
class T03GrenzwerteTest {

    @Test
    @DisplayName("istVolljaehrig - ab 18")
    void volljaehrigTest() {
        assertTrue(istVolljaehrig(18), "Genau 18 gehoert dazu - 'ab' heisst einschliesslich");
        assertTrue(istVolljaehrig(40));
        assertFalse(istVolljaehrig(17));
    }

    @Test
    @DisplayName("liegtImBereich - beide Grenzen eingeschlossen")
    void bereichTest() {
        assertTrue(liegtImBereich(5, 1, 10));
        assertTrue(liegtImBereich(1, 1, 10), "Untere Grenze gehoert dazu");
        assertTrue(liegtImBereich(10, 1, 10), "Obere Grenze gehoert dazu");
        assertFalse(liegtImBereich(0, 1, 10));
        assertFalse(liegtImBereich(11, 1, 10));
    }

    @Test
    @DisplayName("istGueltigeStunde - 0 bis 23")
    void stundeTest() {
        assertTrue(istGueltigeStunde(0));
        assertTrue(istGueltigeStunde(23));
        assertFalse(istGueltigeStunde(24), "24 Uhr gibt es nicht - das ist 0 Uhr");
        assertFalse(istGueltigeStunde(-1));
    }

    @Test
    @DisplayName("begrenze")
    void begrenzeTest() {
        assertEquals(5, begrenze(5, 0, 10));
        assertEquals(0, begrenze(-3, 0, 10));
        assertEquals(10, begrenze(15, 0, 10));
        assertEquals(10, begrenze(10, 0, 10), "Genau auf der Grenze bleibt der Wert");
    }

    @Test
    @DisplayName("note - jede Grenze einzeln")
    void noteTest() {
        assertEquals("sehr gut", note(90));
        assertEquals("gut", note(89));
        assertEquals("gut", note(75));
        assertEquals("befriedigend", note(74));
        assertEquals("befriedigend", note(60));
        assertEquals("ausreichend", note(59));
        assertEquals("ausreichend", note(50));
        assertEquals("nicht bestanden", note(49));
    }

    @Test
    @DisplayName("versandkosten")
    void versandTest() {
        assertEquals(0, versandkosten(5000), "Ab 5000 Cent versandkostenfrei - 5000 eingeschlossen");
        assertEquals(295, versandkosten(4999));
        assertEquals(295, versandkosten(2000));
        assertEquals(495, versandkosten(1999));
        assertEquals(495, versandkosten(0));
    }

    @Test
    @DisplayName("temperaturStufe")
    void temperaturTest() {
        assertEquals("Frost", temperaturStufe(-1));
        assertEquals("kalt", temperaturStufe(0), "0 Grad ist kein Frost mehr - 'unter 0'");
        assertEquals("kalt", temperaturStufe(14));
        assertEquals("mild", temperaturStufe(15));
        assertEquals("mild", temperaturStufe(24));
        assertEquals("warm", temperaturStufe(25));
    }

    @Test
    @DisplayName("rabattProzent - 'ab' und 'mehr als' gemischt")
    void rabattTest() {
        assertEquals(15, rabattProzent(100), "Ab 100 - einschliesslich");
        assertEquals(10, rabattProzent(99));
        assertEquals(10, rabattProzent(51));
        assertEquals(5, rabattProzent(50),
                "Mehr als 50 - die 50 selbst gehoert NICHT zur 10-Prozent-Stufe");
        assertEquals(5, rabattProzent(10), "Ab 10 - einschliesslich");
        assertEquals(0, rabattProzent(9));
    }

    @Test
    @DisplayName("istKind - unter 14")
    void kindTest() {
        assertTrue(istKind(13));
        assertTrue(istKind(0));
        assertFalse(istKind(14), "Genau 14 ist nicht mehr 'unter 14'");
    }

    @Test
    @DisplayName("istTeenager - 13 bis 19")
    void teenagerTest() {
        assertTrue(istTeenager(13));
        assertTrue(istTeenager(19));
        assertFalse(istTeenager(12));
        assertFalse(istTeenager(20));
    }

    @Test
    @DisplayName("istGueltigeMinute")
    void minuteTest() {
        assertTrue(istGueltigeMinute(0));
        assertTrue(istGueltigeMinute(59));
        assertFalse(istGueltigeMinute(60));
        assertFalse(istGueltigeMinute(-1));
    }

    @Test
    @DisplayName("istGueltigerMonat")
    void monatTest() {
        assertTrue(istGueltigerMonat(1));
        assertTrue(istGueltigerMonat(12));
        assertFalse(istGueltigerMonat(0));
        assertFalse(istGueltigerMonat(13));
    }

    @Test
    @DisplayName("istGueltigesDatum")
    void datumTest() {
        assertTrue(istGueltigesDatum(31, 1));
        assertFalse(istGueltigesDatum(31, 4), "Der April hat 30 Tage");
        assertTrue(istGueltigesDatum(30, 4));
        assertTrue(istGueltigesDatum(29, 2));
        assertFalse(istGueltigesDatum(30, 2));
        assertFalse(istGueltigesDatum(0, 5));
        assertFalse(istGueltigesDatum(1, 13));
        assertFalse(istGueltigesDatum(1, 0));
    }

    @Test
    @DisplayName("istWochenende")
    void wochenendeTest() {
        assertTrue(istWochenende(6));
        assertTrue(istWochenende(7));
        assertFalse(istWochenende(5));
        assertFalse(istWochenende(8), "Ungueltige Nummern sind kein Wochenende");
    }

    @Test
    @DisplayName("liegtImHalboffenenBereich - max ausgeschlossen")
    void halboffenTest() {
        assertTrue(liegtImHalboffenenBereich(1, 1, 10), "Die Untergrenze gehoert dazu");
        assertTrue(liegtImHalboffenenBereich(9, 1, 10));
        assertFalse(liegtImHalboffenenBereich(10, 1, 10), "Die Obergrenze gehoert NICHT dazu");
        assertFalse(liegtImHalboffenenBereich(0, 1, 10));
    }

    @Test
    @DisplayName("ueberschneidenSich")
    void ueberschneidungTest() {
        assertTrue(ueberschneidenSich(1, 5, 5, 9), "Beruehrung an der Grenze zaehlt");
        assertFalse(ueberschneidenSich(1, 5, 6, 9));
        assertTrue(ueberschneidenSich(3, 4, 1, 10), "Ein Bereich liegt ganz im anderen");
        assertFalse(ueberschneidenSich(6, 9, 1, 5));
    }

    @Test
    @DisplayName("bmiKategorie")
    void bmiTest() {
        assertEquals("Untergewicht", bmiKategorie(17));
        assertEquals("Normalgewicht", bmiKategorie(18));
        assertEquals("Normalgewicht", bmiKategorie(24));
        assertEquals("Uebergewicht", bmiKategorie(25));
        assertEquals("Uebergewicht", bmiKategorie(29));
        assertEquals("Adipositas", bmiKategorie(30));
    }

    @Test
    @DisplayName("parkgebuehr - 'bis einschliesslich'")
    void parkTest() {
        assertEquals(0, parkgebuehr(0));
        assertEquals(0, parkgebuehr(30), "Genau 30 Minuten sind noch frei - 'bis einschliesslich' heisst <=");
        assertEquals(200, parkgebuehr(31));
        assertEquals(200, parkgebuehr(120));
        assertEquals(500, parkgebuehr(121));
    }

    @Test
    @DisplayName("steuersatz")
    void steuerTest() {
        assertEquals(0, steuersatz(12000));
        assertEquals(20, steuersatz(12001));
        assertEquals(20, steuersatz(60000));
        assertEquals(40, steuersatz(60001));
    }

    @Test
    @DisplayName("windstaerke - jede Grenze")
    void windTest() {
        assertEquals("Windstille", windstaerke(0));
        assertEquals("leicht", windstaerke(1));
        assertEquals("leicht", windstaerke(19));
        assertEquals("maessig", windstaerke(20));
        assertEquals("maessig", windstaerke(61));
        assertEquals("Sturm", windstaerke(62));
        assertEquals("Sturm", windstaerke(117));
        assertEquals("Orkan", windstaerke(118));
    }
}
