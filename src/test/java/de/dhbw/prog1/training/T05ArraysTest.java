package de.dhbw.prog1.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static de.dhbw.prog1.training.T05Arrays.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Training 5 - Arrays")
class T05ArraysTest {

    @Test
    @DisplayName("summe")
    void summeTest() {
        assertEquals(12, summe(new int[]{3, 4, 5}));
        assertEquals(0, summe(new int[0]));
        assertEquals(0, summe(null));
    }

    @Test
    @DisplayName("maximum - auch bei lauter negativen Werten")
    void maximumTest() {
        assertEquals(9, maximum(new int[]{3, 9, 4}));
        assertEquals(-2, maximum(new int[]{-5, -2, -9}),
                "Kommt 0 heraus, hast du die Merkvariable mit 0 begonnen");
        assertEquals(0, maximum(new int[0]));
    }

    @Test
    @DisplayName("indexVon - Position, nicht Wert")
    void indexVonTest() {
        assertEquals(1, indexVon(new int[]{4, 8, 15, 8}, 8), "Das erste Vorkommen zaehlt");
        assertEquals(0, indexVon(new int[]{4, 8}, 4));
        assertEquals(-1, indexVon(new int[]{4, 8}, 99));
        assertEquals(-1, indexVon(null, 4));
    }

    @Test
    @DisplayName("anzahlGroesserAls - echt groesser")
    void groesserTest() {
        assertEquals(3, anzahlGroesserAls(new int[]{1, 5, 10, 5}, 4));
        assertEquals(1, anzahlGroesserAls(new int[]{1, 5, 10, 5}, 5), "Genau 5 ist nicht groesser als 5");
    }

    @Test
    @DisplayName("verdoppelt - neues Array, Original unveraendert")
    void verdoppeltTest() {
        int[] original = {1, 2, 3};
        assertArrayEquals(new int[]{2, 4, 6}, verdoppelt(original));
        assertArrayEquals(new int[]{1, 2, 3}, original, "Das Original darf nicht veraendert werden");
    }

    @Test
    @DisplayName("umgekehrt - neues Array")
    void umgekehrtTest() {
        int[] original = {1, 2, 3, 4};
        assertArrayEquals(new int[]{4, 3, 2, 1}, umgekehrt(original));
        assertArrayEquals(new int[]{1, 2, 3, 4}, original, "Das Original darf nicht veraendert werden");
        assertEquals(0, umgekehrt(null).length);
    }

    @Test
    @DisplayName("istSortiert")
    void sortiertTest() {
        assertTrue(istSortiert(new int[]{1, 2, 2, 5}), "Gleiche Nachbarn sind erlaubt");
        assertFalse(istSortiert(new int[]{1, 3, 2}));
        assertTrue(istSortiert(new int[0]));
        assertFalse(istSortiert(new int[]{2, 1}), "Auch der letzte Nachbar zaehlt");
    }

    @Test
    @DisplayName("ersteN")
    void ersteNTest() {
        assertArrayEquals(new int[]{1, 2}, ersteN(new int[]{1, 2, 3, 4}, 2));
        assertArrayEquals(new int[]{1, 2, 3}, ersteN(new int[]{1, 2, 3}, 10), "n groesser als Laenge");
        assertEquals(0, ersteN(new int[]{1, 2}, 0).length);
        assertEquals(0, ersteN(new int[]{1, 2}, -3).length);
    }

    @Test
    @DisplayName("summeDiagonale - 2D")
    void diagonaleTest() {
        assertEquals(5, summeDiagonale(new int[][]{{1, 2}, {3, 4}}));
        assertEquals(15, summeDiagonale(new int[][]{{1, 0, 0}, {0, 5, 0}, {0, 0, 9}}));
        assertEquals(0, summeDiagonale(null));
    }

    @Test
    @DisplayName("minimum")
    void minimumTest() {
        assertEquals(-2, minimum(new int[]{4, -2, 9}));
        assertEquals(5, minimum(new int[]{5, 8}), "Kommt 0 heraus, hast du die Merkvariable mit 0 begonnen");
        assertEquals(0, minimum(new int[0]));
    }

    @Test
    @DisplayName("durchschnitt - mit Nachkommastellen")
    void durchschnittTest() {
        assertEquals(7.0 / 3, durchschnitt(new int[]{1, 2, 4}), 1e-9,
                "Kommt 2.0 heraus, wurde ganzzahlig geteilt");
        assertEquals(3.0, durchschnitt(new int[]{2, 4}), 1e-9);
        assertEquals(0.0, durchschnitt(new int[0]), 1e-9, "Leer ergibt 0 - ohne Division durch null");
    }

    @Test
    @DisplayName("anzahlVorkommen")
    void vorkommenTest() {
        assertEquals(3, anzahlVorkommen(new int[]{1, 2, 1, 3, 1}, 1));
        assertEquals(0, anzahlVorkommen(new int[]{1, 2}, 9));
        assertEquals(0, anzahlVorkommen(null, 1));
    }

    @Test
    @DisplayName("enthaelt")
    void enthaeltTest() {
        assertTrue(enthaelt(new int[]{4, 8, 15}, 15), "Auch der letzte Wert zaehlt");
        assertFalse(enthaelt(new int[]{4, 8, 15}, 16));
        assertFalse(enthaelt(null, 4));
    }

    @Test
    @DisplayName("letzterIndexVon")
    void letzterIndexTest() {
        assertEquals(3, letzterIndexVon(new int[]{4, 8, 15, 8}, 8));
        assertEquals(0, letzterIndexVon(new int[]{4, 8}, 4));
        assertEquals(-1, letzterIndexVon(new int[]{4, 8}, 99));
    }

    @Test
    @DisplayName("zweitgroesster")
    void zweitgroessterTest() {
        assertEquals(5, zweitgroesster(new int[]{3, 9, 5}));
        assertEquals(5, zweitgroesster(new int[]{5, 5, 3}), "Gleiche Werte zaehlen einzeln");
        assertEquals(3, zweitgroesster(new int[]{9, 3}));
        assertEquals(-5, zweitgroesster(new int[]{-1, -5}));
        assertEquals(0, zweitgroesster(new int[]{7}));
    }

    @Test
    @DisplayName("vertausche - veraendert das Array selbst")
    void vertauscheTest() {
        int[] werte = {1, 2, 3};
        vertausche(werte, 0, 2);
        assertArrayEquals(new int[]{3, 2, 1}, werte,
                "Die Methode gibt nichts zurueck - sie muss das uebergebene Array aendern");
    }

    @Test
    @DisplayName("addiere")
    void addiereTest() {
        assertArrayEquals(new int[]{11, 22}, addiere(new int[]{1, 2, 3}, new int[]{10, 20}));
        assertArrayEquals(new int[]{5, 7, 9}, addiere(new int[]{1, 2, 3}, new int[]{4, 5, 6}));
        assertEquals(0, addiere(null, new int[]{1}).length);
    }

    @Test
    @DisplayName("nurPositive")
    void positiveTest() {
        assertArrayEquals(new int[]{3, 5}, nurPositive(new int[]{3, -1, 0, 5, -2}),
                "0 ist nicht positiv - und das Array hat genau die passende Laenge");
        assertEquals(0, nurPositive(new int[]{-1, 0}).length);
    }

    @Test
    @DisplayName("zeilensummen - 2D")
    void zeilensummenTest() {
        assertArrayEquals(new int[]{3, 12}, zeilensummen(new int[][]{{1, 2}, {3, 4, 5}}));
        assertEquals(0, zeilensummen(null).length);
    }

    @Test
    @DisplayName("maximumInMatrix - 2D")
    void maximumMatrixTest() {
        assertEquals(9, maximumInMatrix(new int[][]{{1, 9}, {-3, 4}}));
        assertEquals(-2, maximumInMatrix(new int[][]{{-5, -2}, {-8}}),
                "Auch bei lauter negativen Werten gibt es ein Maximum");
        assertEquals(0, maximumInMatrix(null));
    }
}
