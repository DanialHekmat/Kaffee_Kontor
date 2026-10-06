package de.dhbw.prog1.ue14;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests zu Uebung 14.
 *
 * <p>Diese Datei musst du nicht veraendern - sie ist deine Selbstkontrolle.
 *
 * <p>Der erste Block ist ungewoehnlich: Er prueft nicht, dass etwas <b>richtig</b> ist,
 * sondern haelt fest, dass der KI-Vorschlag <b>falsch</b> ist. Solche Tests schreibt man in
 * der Praxis tatsaechlich - sie halten einen bekannten Fehler fest, bis er behoben ist.
 */
@DisplayName("Uebung 14 - Den KI-Vorschlag pruefen")
class Ue14Test {

    /** Baut einen Text, der erst zur Laufzeit entsteht - wie eine echte Eingabe. */
    private static String wieVomBenutzerGetippt(String text) {
        return new String(text.toCharArray());
    }

    @Nested
    @DisplayName("Beweisstuecke - so falsch ist der Vorschlag (schon gruen)")
    class Beweise {

        @Test
        @DisplayName("Fehler 1: Bei genau 20 Bechern gibt es keinen Rabatt")
        void grenzwerteSindVerschoben() {
            assertEquals(0, RabattRechner.rabattProzent(20),
                    "Verlangt waren 5 Prozent 'ab 20 Bechern'. Der Vorschlag liefert 0, "
                            + "weil dort > statt >= steht. Derselbe Fehler wie bei der "
                            + "Rabattstaffel im Selbsttest und bei istBankrott in Einheit 3.");

            assertEquals(5, RabattRechner.rabattProzent(50),
                    "Und bei 50 Bechern nur 5 statt 10 Prozent");

            assertEquals(10, RabattRechner.rabattProzent(100),
                    "Und bei 100 Bechern nur 10 statt 15 Prozent");
        }

        @Test
        @DisplayName("Fehler 2: Der Endpreis stimmt fast - und das ist das Problem")
        void geldMitDoubleGerechnet() {
            double ergebnis = RabattRechner.endpreis(3, 0.1);

            assertNotEquals(0.3, ergebnis,
                    "Drei Becher zu je 10 Cent sollten 30 Cent kosten. Herausgekommen ist "
                            + ergebnis + ". Dieser Fehler stuerzt nie ab, erzeugt keine "
                            + "Fehlermeldung und faellt in einer Buchhaltung erst nach "
                            + "Monaten auf - wenn sich die Cent-Differenzen summiert haben. "
                            + "Einheit 2, erste Stunde.");
        }

        @Test
        @DisplayName("Fehler 3: Eine echte Eingabe wird nicht erkannt")
        void textMitGleichheitszeichenVerglichen() {
            assertTrue(RabattRechner.istPremium("premium"),
                    "Mit einer Textkonstante aus dem Quelltext geht es zufaellig gut - "
                            + "genau deshalb faellt der Fehler beim Ausprobieren nicht auf");

            assertFalse(RabattRechner.istPremium(wieVomBenutzerGetippt("premium")),
                    "Mit einer echten Eingabe dagegen nicht. Der Vorschlag vergleicht mit "
                            + "== statt mit equals. Einheit 3, verstanden in Einheit 9.");
        }

        @Test
        @DisplayName("Fehler 4: Ohne Bestellungen stuerzt es ab")
        void divisionDurchNull() {
            assertThrows(ArithmeticException.class,
                    () -> RabattRechner.durchschnittProBecher(new int[0], 10),
                    "Ein leeres Array fuehrt zur Division durch null. Einheit 6.");
        }
    }

    @Nested
    @DisplayName("Eure Fassung - Stufe 1")
    class Korrigiert1 {

        @Test
        @DisplayName("Die Grenzwerte sitzen")
        void grenzwerte() {
            assertEquals(15, RabattRechnerKorrigiert.rabattProzent(150), "Weit ueber 100");
            assertEquals(15, RabattRechnerKorrigiert.rabattProzent(100), "Genau 100");
            assertEquals(10, RabattRechnerKorrigiert.rabattProzent(99), "Knapp darunter");
            assertEquals(10, RabattRechnerKorrigiert.rabattProzent(50), "Genau 50");
            assertEquals(5, RabattRechnerKorrigiert.rabattProzent(49), "Knapp darunter");
            assertEquals(5, RabattRechnerKorrigiert.rabattProzent(20), "Genau 20");
            assertEquals(0, RabattRechnerKorrigiert.rabattProzent(19), "Darunter keiner");
            assertEquals(0, RabattRechnerKorrigiert.rabattProzent(0), "Ohne Bestellung auch nicht");
        }

        @Test
        @DisplayName("Der Endpreis rechnet in ganzen Cent")
        void endpreis() {
            assertEquals(2_500, RabattRechnerKorrigiert.endpreisInCent(10, 250),
                    "10 Becher zu 2,50 EUR ohne Rabatt");

            assertEquals(4_750, RabattRechnerKorrigiert.endpreisInCent(20, 250),
                    "20 Becher: 50,00 EUR minus 5 Prozent");

            assertEquals(21_250, RabattRechnerKorrigiert.endpreisInCent(100, 250),
                    "100 Becher: 250,00 EUR minus 15 Prozent");

            assertEquals(9_374, RabattRechnerKorrigiert.endpreisInCent(33, 299),
                    "98,67 EUR minus 5 Prozent. Der Rabatt betraegt rechnerisch 4,9335 EUR, "
                            + "ganzzahlig also 493 Cent - genau wie in Selbsttest 1.");

            assertEquals(30, RabattRechnerKorrigiert.endpreisInCent(3, 10),
                    "Und der Fall, an dem der Vorschlag scheiterte: drei Becher zu 10 Cent "
                            + "sind exakt 30 Cent. Keine Nachkommastellen, keine Ueberraschung.");
        }
    }

    @Nested
    @DisplayName("Eure Fassung - Stufe 2")
    class Korrigiert2 {

        @Test
        @DisplayName("Premium wird zuverlaessig erkannt")
        void premium() {
            assertTrue(RabattRechnerKorrigiert.istPremium(wieVomBenutzerGetippt("premium")),
                    "Eine echte Eingabe muss erkannt werden - der Text wird hier absichtlich "
                            + "zur Laufzeit gebaut");

            assertTrue(RabattRechnerKorrigiert.istPremium("Premium"), "Grossschreibung egal");
            assertTrue(RabattRechnerKorrigiert.istPremium("  PREMIUM  "), "Leerzeichen egal");

            assertFalse(RabattRechnerKorrigiert.istPremium("standard"), "Andere Typen nicht");
            assertFalse(RabattRechnerKorrigiert.istPremium(""), "Leerer Text nicht");

            boolean beiNull = assertDoesNotThrow(
                    () -> RabattRechnerKorrigiert.istPremium(null),
                    "Ein fehlender Wert darf nicht abstuerzen - er kommt aus einer "
                            + "Eingabemaske und kann fehlen");

            assertFalse(beiNull, "Und gilt nicht als Premium");
        }

        @Test
        @DisplayName("Der Durchschnitt rechnet - und stuerzt nicht ab")
        void durchschnitt() {
            assertEquals(200, RabattRechnerKorrigiert.durchschnittProBecher(
                            new int[]{1_000, 2_000, 3_000}, 10),
                    "6000 Cent auf 30 Becher sind 200 Cent je Becher");

            int ohneBestellungen = assertDoesNotThrow(
                    () -> RabattRechnerKorrigiert.durchschnittProBecher(new int[0], 10),
                    "Ohne Bestellungen darf es nicht krachen");

            assertEquals(0, ohneBestellungen, "Sondern 0 liefern");

            int ohneBecher = assertDoesNotThrow(
                    () -> RabattRechnerKorrigiert.durchschnittProBecher(new int[]{1_000}, 0),
                    "Und bei null Bechern je Bestellung ebenso wenig");

            assertEquals(0, ohneBecher, "Auch hier 0");
        }

        @Test
        @DisplayName("Der Koeder: die umstaendliche Zeile war korrekt")
        void koeder() {
            int[] werte = {1_000, 2_000, 3_000};

            assertEquals(RabattRechner.durchschnittProBecher(werte, 10),
                    RabattRechnerKorrigiert.durchschnittProBecher(werte, 10),
                    "Bei gueltigen Eingaben liefern Vorschlag und Korrektur dasselbe. Die "
                            + "Schleife mit 'i <= length - 1' sah nach einem Off-by-one aus, "
                            + "ist aber genau dasselbe wie 'i < length'. Umstaendlich, ja - "
                            + "falsch, nein. Wer sie korrigiert, baut den Fehler erst ein.");
        }
    }
}
