package de.dhbw.prog1.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.dhbw.prog1.training.T02Verzweigungen.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Training 2 - Verzweigungen")
class T02VerzweigungenTest {

    /** Ein Text, der erst zur Laufzeit entsteht - wie eine echte Eingabe. */
    private static String getippt(String text) {
        return new String(text.toCharArray());
    }

    @Test
    @DisplayName("maximum")
    void maximumTest() {
        assertEquals(9, maximum(3, 9));
        assertEquals(9, maximum(9, 3));
        assertEquals(-2, maximum(-5, -2));
        assertEquals(4, maximum(4, 4));
    }

    @Test
    @DisplayName("maximumVonDrei")
    void maximumVonDreiTest() {
        assertEquals(9, maximumVonDrei(9, 3, 4), "Groesster vorn");
        assertEquals(9, maximumVonDrei(3, 9, 4), "Groesster in der Mitte");
        assertEquals(9, maximumVonDrei(3, 4, 9), "Groesster hinten");
        assertEquals(-1, maximumVonDrei(-3, -1, -2));
    }

    @Test
    @DisplayName("betrag")
    void betragTest() {
        assertEquals(5, betrag(-5));
        assertEquals(5, betrag(5));
        assertEquals(0, betrag(0));
    }

    @Test
    @DisplayName("vorzeichen - drei Faelle")
    void vorzeichenTest() {
        assertEquals("positiv", vorzeichen(12));
        assertEquals("negativ", vorzeichen(-3));
        assertEquals("null", vorzeichen(0), "Den dritten Fall vergisst man leicht");
    }

    @Test
    @DisplayName("istSchaltjahr")
    void schaltjahrTest() {
        assertTrue(istSchaltjahr(2024), "Durch 4 teilbar");
        assertFalse(istSchaltjahr(2023));
        assertFalse(istSchaltjahr(1900), "Durch 100 teilbar, aber nicht durch 400");
        assertTrue(istSchaltjahr(2000), "Durch 400 teilbar");
    }

    @Test
    @DisplayName("genauEinerWahr")
    void genauEinerTest() {
        assertTrue(genauEinerWahr(true, false));
        assertTrue(genauEinerWahr(false, true));
        assertFalse(genauEinerWahr(true, true), "Beide wahr ist nicht genau einer");
        assertFalse(genauEinerWahr(false, false));
    }

    @Test
    @DisplayName("wochentag - switch mit default")
    void wochentagTest() {
        assertEquals("Montag", wochentag(1));
        assertEquals("Donnerstag", wochentag(4));
        assertEquals("Sonntag", wochentag(7));
        assertEquals("unbekannt", wochentag(0));
        assertEquals("unbekannt", wochentag(8));
    }

    @Test
    @DisplayName("istVokal")
    void vokalTest() {
        assertTrue(istVokal('a'));
        assertTrue(istVokal('E'), "Grossbuchstaben zaehlen auch");
        assertTrue(istVokal('u'));
        assertFalse(istVokal('b'));
        assertFalse(istVokal('y'));
    }

    @Test
    @DisplayName("gleicherText - Inhalt statt Identitaet")
    void gleicherTextTest() {
        assertTrue(gleicherText(getippt("Kaffee"), getippt("Kaffee")),
                "Gleicher Inhalt, verschiedene Objekte. Kommt hier false, vergleichst du mit ==.");
        assertFalse(gleicherText(getippt("Kaffee"), getippt("Kakao")));
        assertTrue(gleicherText(null, null), "Beide null gelten als gleich");
        assertFalse(gleicherText(null, "a"), "Genau einer null - ungleich, und kein Absturz");
        assertFalse(gleicherText("a", null));
    }

    @Test
    @DisplayName("minimum")
    void minimumTest() {
        assertEquals(3, minimum(3, 9));
        assertEquals(3, minimum(9, 3));
        assertEquals(-5, minimum(-5, -2));
    }

    @Test
    @DisplayName("minimumVonDrei")
    void minimumVonDreiTest() {
        assertEquals(3, minimumVonDrei(3, 9, 4));
        assertEquals(3, minimumVonDrei(9, 3, 4));
        assertEquals(3, minimumVonDrei(9, 4, 3));
    }

    @Test
    @DisplayName("mittlererWert")
    void mittlererTest() {
        assertEquals(2, mittlererWert(1, 2, 3));
        assertEquals(2, mittlererWert(3, 1, 2));
        assertEquals(2, mittlererWert(2, 3, 1));
        assertEquals(5, mittlererWert(5, 5, 1), "Doppelte Werte: der mittlere ist 5");
    }

    @Test
    @DisplayName("istDurchDreiOderFuenfTeilbar")
    void dreiFuenfTest() {
        assertTrue(istDurchDreiOderFuenfTeilbar(9));
        assertTrue(istDurchDreiOderFuenfTeilbar(10));
        assertTrue(istDurchDreiOderFuenfTeilbar(15));
        assertFalse(istDurchDreiOderFuenfTeilbar(7));
    }

    @Test
    @DisplayName("fizzBuzz - Reihenfolge entscheidet")
    void fizzBuzzTest() {
        assertEquals("FizzBuzz", fizzBuzz(15),
                "Kommt Fizz heraus, pruefst du 'durch 3' vor 'durch 15'");
        assertEquals("Fizz", fizzBuzz(9));
        assertEquals("Buzz", fizzBuzz(10));
        assertEquals("7", fizzBuzz(7));
    }

    @Test
    @DisplayName("jahreszeit")
    void jahreszeitTest() {
        assertEquals("Winter", jahreszeit(1));
        assertEquals("Winter", jahreszeit(12));
        assertEquals("Fruehling", jahreszeit(3));
        assertEquals("Sommer", jahreszeit(8));
        assertEquals("Herbst", jahreszeit(11));
        assertEquals("unbekannt", jahreszeit(13));
    }

    @Test
    @DisplayName("tageImMonat")
    void tageTest() {
        assertEquals(28, tageImMonat(2, false));
        assertEquals(29, tageImMonat(2, true));
        assertEquals(30, tageImMonat(4, false));
        assertEquals(31, tageImMonat(1, false));
        assertEquals(31, tageImMonat(12, true));
        assertEquals(0, tageImMonat(13, false));
    }

    @Test
    @DisplayName("istGrossbuchstabe")
    void grossTest() {
        assertTrue(istGrossbuchstabe('A'));
        assertTrue(istGrossbuchstabe('Z'));
        assertFalse(istGrossbuchstabe('a'));
        assertFalse(istGrossbuchstabe('1'));
    }

    @Test
    @DisplayName("ampel - Texte mit equals")
    void ampelTest() {
        assertEquals("stehen", ampel(getippt("rot")), "Kommt unbekannt heraus, vergleichst du mit ==");
        assertEquals("warten", ampel(getippt("gelb")));
        assertEquals("gehen", ampel(getippt("gruen")));
        assertEquals("unbekannt", ampel("blau"));
        assertEquals("unbekannt", ampel(null), "null darf nicht abstuerzen");
    }

    @Test
    @DisplayName("hatZugang - Klammern setzen")
    void zugangTest() {
        assertTrue(hatZugang(true, false, 16));
        assertTrue(hatZugang(false, true, 30));
        assertFalse(hatZugang(false, false, 30));
        assertFalse(hatZugang(true, true, 15),
                "Zu jung - auch mit Mitgliedschaft. Ohne Klammern bindet && staerker als ||");
    }

    @Test
    @DisplayName("vergleiche")
    void vergleicheTest() {
        assertEquals(-1, vergleiche(3, 5));
        assertEquals(1, vergleiche(5, 3));
        assertEquals(0, vergleiche(4, 4));
    }
}
