package de.dhbw.prog1.ue03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests zu Uebung 3.
 *
 * <p>Diese Datei musst du nicht veraendern - sie ist deine Selbstkontrolle.
 */
@DisplayName("Uebung 3 - Entscheidungen im Kaffee-Kontor")
class EntscheidungTest {

    /**
     * Erzeugt einen Text, der garantiert erst zur Laufzeit entsteht.
     *
     * <p>Das ist wichtig fuer die Tests zu {@code istBestaetigung}: Texte, die woertlich im
     * Quelltext stehen, legt Java in einem gemeinsamen Speicher ab, und dann funktioniert
     * sogar der falsche Vergleich mit {@code ==} zufaellig. Eine echte Benutzereingabe ist
     * aber nie so ein Text - deshalb wird hier nachgestellt, was beim Tippen wirklich passiert.
     */
    private static String wieVomBenutzerGetippt(String text) {
        return new String(text.toCharArray());
    }

    @Test
    @DisplayName("Voraussetzung: Uebung 2 ist geloest")
    void uebungZweiIstGeloest() {
        assertEquals(28_000, de.dhbw.prog1.ue02.Runde.einkaufskosten(10, 2800),
                "Uebung 3 baut auf Uebung 2 auf und verwendet deren Methoden weiter. "
                        + "Solange dieser Test rot ist, koennen auch die Tests darunter nicht "
                        + "gruen werden - loese erst Uebung 2 fertig oder uebernimm deren Musterloesung "
                        + "(README.md, Abschnitt 'Nicht fertig geworden?').");
    }

    @Nested
    @DisplayName("Stufe 1 - Basis")
    class Basis {

        @Test
        @DisplayName("Bankrott ist, wer WENIGER als null in der Kasse hat")
        void bankrottGrenzeIstExakt() {
            assertTrue(Entscheidung.istBankrott(-1),
                    "Ein Cent im Minus ist bereits zahlungsunfaehig");

            assertTrue(Entscheidung.istBankrott(-60_300),
                    "603,00 EUR im Minus sind erst recht Bankrott");

            assertFalse(Entscheidung.istBankrott(0),
                    "Genau 0,00 EUR ist knapp, aber noch KEIN Bankrott. Wenn dieser Test rot "
                            + "ist, hast du vermutlich <= statt < geschrieben.");

            assertFalse(Entscheidung.istBankrott(200_000),
                    "Mit 2000,00 EUR in der Kasse ist niemand pleite");
        }

        @Test
        @DisplayName("Die Runde wird in drei Stufen bewertet")
        void rundeWirdBewertet() {
            assertEquals("Gewinn", Entscheidung.bewerteRunde(22_400),
                    "224,00 EUR mehr in der Kasse sind ein Gewinn");

            assertEquals("Verlust", Entscheidung.bewerteRunde(-4_950),
                    "49,50 EUR weniger in der Kasse sind ein Verlust");

            assertEquals("Punktlandung", Entscheidung.bewerteRunde(0),
                    "Genau null Veraenderung ist weder Gewinn noch Verlust. Diesen Fall "
                            + "vergisst man leicht - er braucht einen eigenen Zweig.");
        }
    }

    @Nested
    @DisplayName("Stufe 2 - Kern")
    class Kern {

        @Test
        @DisplayName("Bezahlbare Saecke: Kasse und Roestkapazitaet begrenzen gemeinsam")
        void bezahlbareSaeckeBeachtenBeideGrenzen() {
            assertEquals(12, Entscheidung.maximalBezahlbareSaecke(200_000, 2800),
                    "Fuer 2000,00 EUR waeren 71 Saecke bezahlbar - aber die Roestmaschine "
                            + "schafft nur 12. Die kleinere der beiden Grenzen gilt.");

            assertEquals(3, Entscheidung.maximalBezahlbareSaecke(10_000, 2800),
                    "100,00 EUR reichen fuer 3 Saecke zu 28,00 EUR. Der Rest von 16,00 EUR "
                            + "kauft keinen vierten - Ganzzahldivision schneidet ab, und das "
                            + "ist hier genau richtig.");

            assertEquals(1, Entscheidung.maximalBezahlbareSaecke(2800, 2800),
                    "Genau der Preis eines Sacks reicht fuer genau einen Sack");

            assertEquals(0, Entscheidung.maximalBezahlbareSaecke(2799, 2800),
                    "Einen Cent zu wenig heisst: kein Sack");

            assertEquals(0, Entscheidung.maximalBezahlbareSaecke(0, 2800),
                    "Leere Kasse, kein Einkauf");

            assertEquals(0, Entscheidung.maximalBezahlbareSaecke(-5_000, 2800),
                    "Bei negativer Kasse muss 0 herauskommen, nicht eine negative Anzahl. "
                            + "Eine Anzahl Saecke kann nie kleiner als null sein.");
        }

        @Test
        @DisplayName("Einkaufen ist nur erlaubt, wenn alle drei Bedingungen stimmen")
        void einkaufWirdVollstaendigGeprueft() {
            assertTrue(Entscheidung.darfEinkaufen(200_000, 5, 2800),
                    "5 Saecke fuer 140,00 EUR bei 2000,00 EUR Kasse - alles in Ordnung");

            assertTrue(Entscheidung.darfEinkaufen(14_000, 5, 2800),
                    "Wenn das Geld exakt reicht, ist der Einkauf erlaubt. Achte auf <= "
                            + "statt <.");

            assertFalse(Entscheidung.darfEinkaufen(200_000, 13, 2800),
                    "13 Saecke ueberschreiten die Roestkapazitaet von 12 - Geld hin oder her");

            assertFalse(Entscheidung.darfEinkaufen(200_000, 0, 2800),
                    "Null Saecke zu kaufen ist kein gueltiger Einkauf");

            assertFalse(Entscheidung.darfEinkaufen(200_000, -1, 2800),
                    "Eine negative Anzahl erst recht nicht");

            assertFalse(Entscheidung.darfEinkaufen(10_000, 5, 2800),
                    "5 Saecke kosten 140,00 EUR, in der Kasse sind nur 100,00 EUR");
        }

        @Test
        @DisplayName("Saisonlage - die Grenzwerte muessen exakt sitzen")
        void saisonWirdEingeordnet() {
            assertEquals("Hochsaison", Entscheidung.beschreibeSaison(118),
                    "118 Prozent sind klar Hochsaison");

            assertEquals("Hochsaison", Entscheidung.beschreibeSaison(110),
                    "Genau 110 ist bereits Hochsaison - die Grenze gehoert dazu");

            assertEquals("Normal", Entscheidung.beschreibeSaison(109),
                    "109 liegt eine Stufe darunter und ist normal");

            assertEquals("Normal", Entscheidung.beschreibeSaison(95),
                    "Genau 95 ist noch normal");

            assertEquals("Flaute", Entscheidung.beschreibeSaison(94),
                    "94 ist die erste Zahl, die Flaute bedeutet. Genau an solchen Uebergaengen "
                            + "brechen Verzweigungen in der Praxis - deshalb wird hier jeder "
                            + "Grenzwert einzeln geprueft.");

            assertEquals("Flaute", Entscheidung.beschreibeSaison(85),
                    "85 Prozent sind tiefste Flaute");
        }

        @Test
        @DisplayName("Menueauswahl wird mit switch uebersetzt")
        void menueWirdUebersetzt() {
            assertEquals("Einkaufen", Entscheidung.menueAktion(1), "1 bedeutet Einkaufen");
            assertEquals("Preis festlegen", Entscheidung.menueAktion(2), "2 setzt den Preis");
            assertEquals("Bericht anzeigen", Entscheidung.menueAktion(3), "3 zeigt den Bericht");
            assertEquals("Beenden", Entscheidung.menueAktion(0), "0 beendet das Programm");

            assertEquals("Unbekannt", Entscheidung.menueAktion(7),
                    "Fuer 7 gibt es keinen Menuepunkt - dafuer ist der default-Zweig da");

            assertEquals("Unbekannt", Entscheidung.menueAktion(-3),
                    "Auch mit negativen Eingaben muss das Programm umgehen koennen");
        }

        @Test
        @DisplayName("Bestaetigung: Texte werden mit equals verglichen, nicht mit ==")
        void bestaetigungWirdInhaltlichVerglichen() {
            assertTrue(Entscheidung.istBestaetigung(wieVomBenutzerGetippt("j")),
                    "'j' ist eine Zustimmung. Wenn dieser Test rot ist, hast du vermutlich "
                            + "== statt equals benutzt: Der eingegebene Text enthaelt zwar "
                            + "dasselbe, ist aber ein anderes Objekt im Speicher.");

            assertTrue(Entscheidung.istBestaetigung(wieVomBenutzerGetippt("ja")),
                    "'ja' ist ebenfalls eine Zustimmung");

            assertTrue(Entscheidung.istBestaetigung(wieVomBenutzerGetippt("Ja")),
                    "Grossschreibung darf keinen Unterschied machen - equalsIgnoreCase");

            assertTrue(Entscheidung.istBestaetigung(wieVomBenutzerGetippt("JA")),
                    "Auch komplett gross geschrieben ist es eine Zustimmung");

            assertTrue(Entscheidung.istBestaetigung(wieVomBenutzerGetippt("  ja  ")),
                    "Wer versehentlich Leerzeichen mittippt, meint trotzdem ja - trim()");

            assertFalse(Entscheidung.istBestaetigung(wieVomBenutzerGetippt("n")),
                    "'n' ist keine Zustimmung");

            assertFalse(Entscheidung.istBestaetigung(wieVomBenutzerGetippt("nein")),
                    "'nein' ist keine Zustimmung");

            assertFalse(Entscheidung.istBestaetigung(wieVomBenutzerGetippt("")),
                    "Wer nur Enter drueckt, hat nicht zugestimmt");

            assertFalse(Entscheidung.istBestaetigung(wieVomBenutzerGetippt("jaein")),
                    "'jaein' ist keine Zustimmung. Vorsicht bei startsWith - der Text muss "
                            + "vollstaendig passen.");
        }
    }
}
