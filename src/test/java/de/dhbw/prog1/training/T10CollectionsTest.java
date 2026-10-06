package de.dhbw.prog1.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static de.dhbw.prog1.training.T10Collections.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Training 10 - Collections")
class T10CollectionsTest {

    @Test
    @DisplayName("summe")
    void summeTest() {
        assertEquals(10, summe(List.of(1, 2, 3, 4)));
        assertEquals(0, summe(List.of()));
        assertEquals(0, summe(null));
    }

    @Test
    @DisplayName("geradeZahlen - neue Liste")
    void geradeTest() {
        List<Integer> original = new ArrayList<>(List.of(1, 2, 3, 4, 6));
        assertEquals(List.of(2, 4, 6), geradeZahlen(original));
        assertEquals(List.of(1, 2, 3, 4, 6), original, "Die uebergebene Liste bleibt unveraendert");
    }

    @Test
    @DisplayName("ohneDoppelte")
    void ohneDoppelteTest() {
        assertEquals(Set.of("a", "b"), ohneDoppelte(List.of("a", "b", "a")));
    }

    @Test
    @DisplayName("anzahlVerschiedene")
    void verschiedeneTest() {
        assertEquals(3, anzahlVerschiedene(List.of(1, 2, 2, 3, 1)));
        assertEquals(0, anzahlVerschiedene(List.of()));
    }

    @Test
    @DisplayName("enthaeltDoppelte")
    void doppelteTest() {
        assertTrue(enthaeltDoppelte(List.of("x", "y", "x")));
        assertFalse(enthaeltDoppelte(List.of("x", "y")));
    }

    @Test
    @DisplayName("haeufigkeiten - Map mit getOrDefault")
    void haeufigkeitenTest() {
        assertEquals(Map.of("a", 2, "b", 1), haeufigkeiten(List.of("a", "b", "a")),
                "Steht bei a eine 1, ueberschreibst du den Zaehler statt ihn zu erhoehen");
        assertEquals(Map.of(), haeufigkeiten(List.of()));
    }

    @Test
    @DisplayName("haeufigstesWort - bei Gleichstand das erste")
    void haeufigstesTest() {
        assertEquals("b", haeufigstesWort(List.of("a", "b", "b", "c")));
        assertEquals("x", haeufigstesWort(List.of("x", "y", "y", "x")),
                "Gleichstand: x kommt in der Liste zuerst vor");
        assertNull(haeufigstesWort(List.of()));
    }

    @Test
    @DisplayName("sortiertNachLaenge - stabil")
    void sortierenTest() {
        List<String> original = new ArrayList<>(List.of("bb", "a", "ccc", "dd"));
        assertEquals(List.of("a", "bb", "dd", "ccc"), sortiertNachLaenge(original),
                "bb und dd sind gleich lang und behalten ihre Reihenfolge");
        assertEquals(List.of("bb", "a", "ccc", "dd"), original, "Das Original bleibt unveraendert");
    }

    @Test
    @DisplayName("gemeinsame")
    void gemeinsameTest() {
        assertEquals(List.of("x", "z"), gemeinsame(List.of("x", "y", "x", "z"), List.of("z", "x")),
                "Reihenfolge von a, und jedes Wort nur einmal");
        assertEquals(List.of(), gemeinsame(List.of("a"), List.of("b")));
    }

    @Test
    @DisplayName("umgekehrt - neue Liste")
    void umgekehrtTest() {
        List<String> original = new ArrayList<>(List.of("a", "b", "c"));
        assertEquals(List.of("c", "b", "a"), umgekehrt(original));
        assertEquals(List.of("a", "b", "c"), original, "Die uebergebene Liste bleibt unveraendert");
        assertEquals(List.of(), umgekehrt(null));
    }

    @Test
    @DisplayName("ohneDoppelteGeordnet - Reihenfolge des ersten Auftretens")
    void ohneDoppelteGeordnetTest() {
        assertEquals(List.of("z", "a", "m"), ohneDoppelteGeordnet(List.of("z", "a", "z", "m", "a")),
                "Stimmt die Reihenfolge nicht, hat ein HashSet oder TreeSet sie veraendert");
        assertEquals(List.of(), ohneDoppelteGeordnet(null));
    }

    @Test
    @DisplayName("laengen")
    void laengenTest() {
        assertEquals(List.of(5, 2, 0), laengen(List.of("Hallo", "du", "")));
        assertEquals(List.of(), laengen(null));
    }

    @Test
    @DisplayName("groessteZahl - null wenn leer")
    void groessteZahlTest() {
        assertEquals(9, groessteZahl(List.of(4, 9, 2)));
        assertEquals(-2, groessteZahl(List.of(-5, -2)), "Auch bei lauter negativen Zahlen");
        assertNull(groessteZahl(List.of()));
    }

    @Test
    @DisplayName("zaehleLaengerAls")
    void laengerAlsTest() {
        assertEquals(2, zaehleLaengerAls(List.of("Hallo", "du", "Welt", "ab"), 2), "Genau 2 zaehlt nicht");
        assertEquals(0, zaehleLaengerAls(null, 2));
    }

    @Test
    @DisplayName("nachAnfangsbuchstabe - Map mit Listen")
    void gruppierenTest() {
        Map<Character, List<String>> gruppen =
                nachAnfangsbuchstabe(List.of("Apfel", "Birne", "", "Aprikose"));
        assertEquals(Map.of('A', List.of("Apfel", "Aprikose"), 'B', List.of("Birne")), gruppen,
                "Fehlt Apfel, wurde fuer Aprikose eine neue Liste angelegt statt die vorhandene zu nehmen");
        assertTrue(nachAnfangsbuchstabe(null).isEmpty());
    }

    @Test
    @DisplayName("vereinigung")
    void vereinigungTest() {
        Set<String> a = new HashSet<>(Set.of("x", "y"));
        Set<String> b = new HashSet<>(Set.of("y", "z"));
        assertEquals(Set.of("x", "y", "z"), vereinigung(a, b));
        assertEquals(Set.of("x", "y"), a, "a bleibt unveraendert - lege eine neue Menge an");
    }

    @Test
    @DisplayName("schnittmenge")
    void schnittmengeTest() {
        Set<String> a = new HashSet<>(Set.of("x", "y", "w"));
        Set<String> b = new HashSet<>(Set.of("y", "z", "w"));
        assertEquals(Set.of("y", "w"), schnittmenge(a, b));
        assertEquals(Set.of("x", "y", "w"), a, "a bleibt unveraendert - lege eine neue Menge an");
        assertEquals(Set.of(), schnittmenge(a, new HashSet<>(Set.of("q"))));
    }

    @Test
    @DisplayName("summeDerWerte")
    void summeWerteTest() {
        assertEquals(17, summeDerWerte(Map.of("Arabica", 12, "Robusta", 5)));
        assertEquals(0, summeDerWerte(Map.of()));
        assertEquals(0, summeDerWerte(null));
    }

    @Test
    @DisplayName("schluesselMitWertUeber - sortiert")
    void schluesselTest() {
        Map<String, Integer> bestand = Map.of("Zimt", 9, "Anis", 3, "Muskat", 10, "Kardamom", 5);
        assertEquals(List.of("Muskat", "Zimt"), schluesselMitWertUeber(bestand, 5), "5 selbst zaehlt nicht");
        assertEquals(List.of("Anis", "Kardamom", "Muskat", "Zimt"), schluesselMitWertUeber(bestand, 0));
        assertEquals(List.of(), schluesselMitWertUeber(null, 0));
    }

    @Test
    @DisplayName("entferneKurze - veraendert die Liste selbst")
    void entferneKurzeTest() {
        List<String> woerter = new ArrayList<>(List.of("ab", "Hallo", "x", "Welt", "abc"));
        entferneKurze(woerter, 3);
        assertEquals(List.of("Hallo", "Welt", "abc"), woerter,
                "Die Methode gibt nichts zurueck - sie muss die uebergebene Liste aendern");
    }
}
