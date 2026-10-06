package de.dhbw.prog1.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.dhbw.prog1.training.T06Methoden.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Training 6 - Methoden")
class T06MethodenTest {

    @Test
    @DisplayName("quadrat")
    void quadratTest() {
        assertEquals(16, quadrat(4));
        assertEquals(16, quadrat(-4));
    }

    @Test
    @DisplayName("summeDerQuadrate")
    void summeQuadrateTest() {
        assertEquals(25, summeDerQuadrate(3, 4));
        assertEquals(2, summeDerQuadrate(-1, 1));
    }

    @Test
    @DisplayName("flaeche(seite) - Quadrat")
    void flaecheQuadratTest() {
        assertEquals(25, flaeche(5));
    }

    @Test
    @DisplayName("flaeche(breite, hoehe) - ueberladen")
    void flaecheRechteckTest() {
        assertEquals(12, flaeche(3, 4));
        assertEquals(0, flaeche(0, 4));
        assertEquals(20, flaeche(4, 5));
    }

    @Test
    @DisplayName("kreisflaeche")
    void kreisTest() {
        assertEquals(Math.PI, kreisflaeche(1.0), 1e-9);
        assertEquals(4 * Math.PI, kreisflaeche(2.0), 1e-9);
    }

    @Test
    @DisplayName("begruessung(name)")
    void begruessungTest() {
        assertEquals("Hallo, Anna!", begruessung("Anna"));
    }

    @Test
    @DisplayName("begruessung(name, foermlich) - ueberladen")
    void begruessungFoermlichTest() {
        assertEquals("Guten Tag, Anna.", begruessung("Anna", true));
        assertEquals("Hallo, Anna!", begruessung("Anna", false));
    }

    @Test
    @DisplayName("ggT")
    void ggtTest() {
        assertEquals(6, ggT(12, 18));
        assertEquals(6, ggT(18, 12), "Reihenfolge egal");
        assertEquals(1, ggT(7, 5));
        assertEquals(5, ggT(0, 5));
    }

    @Test
    @DisplayName("kgV")
    void kgvTest() {
        assertEquals(12, kgV(4, 6));
        assertEquals(35, kgV(7, 5));
        assertEquals(0, kgV(0, 5), "Mit 0 ist das kgV 0 - und es wird nicht durch 0 geteilt");
    }

    @Test
    @DisplayName("istTeilerVon")
    void istTeilerVonTest() {
        assertTrue(istTeilerVon(3, 12));
        assertFalse(istTeilerVon(5, 12));
        assertFalse(istTeilerVon(0, 12), "Durch 0 teilt man nicht - und es darf nicht abstuerzen");
    }

    @Test
    @DisplayName("summeEchterTeiler")
    void summeEchterTeilerTest() {
        assertEquals(16, summeEchterTeiler(12), "1+2+3+4+6 - die 12 selbst zaehlt nicht");
        assertEquals(1, summeEchterTeiler(7));
        assertEquals(6, summeEchterTeiler(6));
    }

    @Test
    @DisplayName("istVollkommen")
    void vollkommenTest() {
        assertTrue(istVollkommen(6));
        assertTrue(istVollkommen(28));
        assertFalse(istVollkommen(12));
        assertFalse(istVollkommen(1));
    }

    @Test
    @DisplayName("durchschnitt(a, b)")
    void durchschnittZweiTest() {
        assertEquals(2.5, durchschnitt(2, 3), 1e-9, "Kommt 2.0 heraus, wurde ganzzahlig geteilt");
        assertEquals(4.0, durchschnitt(4, 4), 1e-9);
    }

    @Test
    @DisplayName("durchschnitt(a, b, c) - ueberladen")
    void durchschnittDreiTest() {
        assertEquals(2.0, durchschnitt(1, 2, 3), 1e-9);
        assertEquals(4.0 / 3, durchschnitt(1, 1, 2), 1e-9);
    }

    @Test
    @DisplayName("quaderVolumen")
    void volumenTest() {
        assertEquals(24, quaderVolumen(2, 3, 4));
        assertEquals(1, quaderVolumen(1, 1, 1));
    }

    @Test
    @DisplayName("quaderOberflaeche")
    void oberflaecheTest() {
        assertEquals(52, quaderOberflaeche(2, 3, 4));
        assertEquals(6, quaderOberflaeche(1, 1, 1));
    }

    @Test
    @DisplayName("zinsen")
    void zinsenTest() {
        assertEquals(50, zinsen(1000, 5));
        assertEquals(12, zinsen(250, 5), "12,5 ganzzahlig ist 12");
    }

    @Test
    @DisplayName("kapitalNachJahren - Zinseszins")
    void kapitalTest() {
        assertEquals(1331, kapitalNachJahren(1000, 10, 3),
                "Kommt 1300 heraus, wurden die Zinsen nicht jedes Jahr auf das neue Kapital berechnet");
        assertEquals(1000, kapitalNachJahren(1000, 10, 0));
    }

    @Test
    @DisplayName("formatiereName(vorname, nachname)")
    void nameZweiTest() {
        assertEquals("Schulz, Anna", formatiereName("Anna", "Schulz"));
    }

    @Test
    @DisplayName("formatiereName(vorname, mittelname, nachname) - ueberladen")
    void nameDreiTest() {
        assertEquals("Schulz, Anna M.", formatiereName("Anna", "Maria", "Schulz"));
        assertEquals("Meier, Tom B.", formatiereName("Tom", "Ben", "Meier"));
    }
}
