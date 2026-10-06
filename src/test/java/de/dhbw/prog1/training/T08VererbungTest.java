package de.dhbw.prog1.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Training 8 - Vererbung und Polymorphie")
class T08VererbungTest {

    @Test
    @DisplayName("name kommt aus der Oberklasse")
    void namen() {
        assertEquals("Rechteck", new T08Rechteck(3, 4).name(),
                "Der Name wird ueber super(...) an die Oberklasse gegeben und dort gemerkt");
        assertEquals("Quadrat", new T08Quadrat(2).name());
        assertEquals("Dreieck", new T08Dreieck(3, 4).name());
    }

    @Test
    @DisplayName("Rechteck: flaeche")
    void rechteck() {
        assertEquals(12, new T08Rechteck(3, 4).flaeche());
    }

    @Test
    @DisplayName("Quadrat: flaeche")
    void quadrat() {
        assertEquals(9, new T08Quadrat(3).flaeche());
    }

    @Test
    @DisplayName("Dreieck: flaeche, ganzzahlig")
    void dreieck() {
        assertEquals(6, new T08Dreieck(3, 4).flaeche());
        assertEquals(7, new T08Dreieck(3, 5).flaeche(), "3 * 5 / 2 ist ganzzahlig 7");
    }

    @Test
    @DisplayName("toString einmal geschrieben, fuer alle richtig")
    void textPolymorph() {
        assertEquals("Rechteck mit Flaeche 12", new T08Rechteck(3, 4).toString());
        assertEquals("Dreieck mit Flaeche 6", new T08Dreieck(3, 4).toString(),
                "toString steht nur in T08Form und ruft flaeche() auf - Java nimmt dabei die "
                        + "Fassung des tatsaechlichen Objekts");
    }

    @Test
    @DisplayName("gesamtflaeche - polymorph")
    void gesamt() {
        T08Form[] formen = {new T08Rechteck(3, 4), new T08Quadrat(3), new T08Dreieck(3, 4)};
        assertEquals(27, T08Formen.gesamtflaeche(formen), "12 + 9 + 6");
        assertEquals(0, T08Formen.gesamtflaeche(new T08Form[0]));
    }

    @Test
    @DisplayName("groesste")
    void groesste() {
        T08Form gross = new T08Rechteck(5, 5);
        T08Form[] formen = {new T08Quadrat(3), gross, new T08Dreieck(4, 4)};
        assertSame(gross, T08Formen.groesste(formen));
        assertNull(T08Formen.groesste(new T08Form[0]));
    }

    @Test
    @DisplayName("Mitarbeiter: name kommt aus der Oberklasse")
    void mitarbeiterNamen() {
        assertEquals("Anna", new T08Festangestellter("Anna", 3000).name(),
                "Der Name wird ueber super(name) an die Oberklasse gegeben");
        assertEquals("Ben", new T08Aushilfe("Ben", 40, 15).name());
        assertEquals("Cem", new T08Fuehrungskraft("Cem", 5000, 1000).name());
    }

    @Test
    @DisplayName("Festangestellter: monatsgehalt")
    void festangestellter() {
        assertEquals(3000, new T08Festangestellter("Anna", 3000).monatsgehalt());
    }

    @Test
    @DisplayName("Aushilfe: monatsgehalt = Stunden mal Stundenlohn")
    void aushilfe() {
        assertEquals(600, new T08Aushilfe("Ben", 40, 15).monatsgehalt());
    }

    @Test
    @DisplayName("Fuehrungskraft: Grundgehalt plus Bonus")
    void fuehrungskraft() {
        assertEquals(6000, new T08Fuehrungskraft("Cem", 5000, 1000).monatsgehalt(),
                "Kommt 5000 heraus, fehlt der Bonus. Kommt 1000 heraus, fehlt super.monatsgehalt()");
    }

    @Test
    @DisplayName("Fuehrungskraft ist ein Festangestellter und ein Mitarbeiter")
    void fuehrungskraftIstEin() {
        Object f = new T08Fuehrungskraft("Cem", 5000, 1000);
        assertTrue(T08Festangestellter.class.isInstance(f),
                "T08Fuehrungskraft muss von T08Festangestellter erben");
        assertTrue(T08Mitarbeiter.class.isInstance(f));
        assertEquals(6000, ((T08Mitarbeiter) f).monatsgehalt());
    }

    @Test
    @DisplayName("jahresgehalt - einmal in der Oberklasse, gilt fuer alle")
    void jahresgehalt() {
        assertEquals(36000, new T08Festangestellter("Anna", 3000).jahresgehalt());
        assertEquals(7200, new T08Aushilfe("Ben", 40, 15).jahresgehalt());
        assertEquals(72000, new T08Fuehrungskraft("Cem", 5000, 1000).jahresgehalt(),
                "jahresgehalt ruft monatsgehalt auf - und bekommt die Fassung der Unterklasse");
    }

    @Test
    @DisplayName("Mitarbeiter: toString")
    void mitarbeiterToString() {
        assertEquals("Anna: 36000 im Jahr", new T08Festangestellter("Anna", 3000).toString());
        assertEquals("Cem: 72000 im Jahr", new T08Fuehrungskraft("Cem", 5000, 1000).toString());
    }

    @Test
    @DisplayName("Personal: gesamteJahresgehaelter - Polymorphie im Array")
    void personalGesamt() {
        T08Mitarbeiter[] personal = {
                new T08Festangestellter("Anna", 3000),
                new T08Aushilfe("Ben", 40, 15),
                new T08Fuehrungskraft("Cem", 5000, 1000)
        };
        assertEquals(115200, T08Personal.gesamteJahresgehaelter(personal));
        assertEquals(0, T08Personal.gesamteJahresgehaelter(new T08Mitarbeiter[0]));
    }

    @Test
    @DisplayName("Personal: bestbezahlt")
    void personalBestbezahlt() {
        T08Mitarbeiter anna = new T08Festangestellter("Anna", 3000);
        T08Mitarbeiter cem = new T08Fuehrungskraft("Cem", 5000, 1000);
        T08Mitarbeiter ben = new T08Aushilfe("Ben", 40, 15);
        assertSame(cem, T08Personal.bestbezahlt(new T08Mitarbeiter[]{anna, cem, ben}));
        assertNull(T08Personal.bestbezahlt(new T08Mitarbeiter[0]));
    }

    @Test
    @DisplayName("Personal: bestbezahlt bei Gleichstand der Erste")
    void personalGleichstand() {
        T08Mitarbeiter anna = new T08Festangestellter("Anna", 3000);
        T08Mitarbeiter dora = new T08Festangestellter("Dora", 3000);
        assertSame(anna, T08Personal.bestbezahlt(new T08Mitarbeiter[]{anna, dora}),
                "Bei Gleichstand bleibt der Erste - vergleiche mit > statt >=");
    }
}
