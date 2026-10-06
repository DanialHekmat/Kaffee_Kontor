package de.dhbw.prog1.ue12;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests zu Uebung 12.
 *
 * <p>Diese Datei musst du nicht veraendern - sie ist deine Selbstkontrolle.
 *
 * <p>Neu ist hier {@code assertThrows}: Damit wird geprueft, dass eine Ausnahme <b>wirklich
 * fliegt</b>. Ein Test kann also nicht nur verlangen, dass etwas funktioniert, sondern auch,
 * dass etwas zuverlaessig scheitert. Das ist oft die wichtigere Haelfte.
 */
@DisplayName("Uebung 12 - Fehlerbehandlung")
class Ue12Test {

    @Nested
    @DisplayName("NichtGenugGeldException - Stufe 1")
    class EigeneAusnahme {

        @Test
        @DisplayName("Die Ausnahme traegt Meldung und Fehlbetrag")
        void ausnahmeTraegtDaten() {
            NichtGenugGeldException e =
                    new NichtGenugGeldException("Kasse reicht nicht", 1250);

            assertEquals("Kasse reicht nicht", e.getMessage(),
                    "getMessage() kommt aus der Oberklasse Exception - dafuer sorgt der "
                            + "super-Aufruf im Konstruktor. Kommt hier null, fehlt er.");

            assertEquals(1250, e.fehlbetragInCent(),
                    "Der Fehlbetrag ist das, was eine eigene Ausnahme gegenueber einem "
                            + "schlichten false voraushat: eine Zahl zum Weiterrechnen");

            assertEquals("Es fehlen 12,50 EUR.", e.fehlbetragAlsText(),
                    "Achte auf den Punkt am Ende");
        }

        @Test
        @DisplayName("Sie ist eine gepruefte Ausnahme")
        void istGeprueft() {
            NichtGenugGeldException e = new NichtGenugGeldException("Test", 100);

            // isInstance statt instanceof: Der Compiler kann bei instanceof beweisen,
            // dass eine Exception niemals eine RuntimeException ist, und lehnt die Zeile
            // als sinnlos ab. isInstance prueft erst zur Laufzeit - nur so kann dieser
            // Test auch eine falsche Loesung ueberhaupt uebersetzen und dann bemaengeln.
            assertTrue(Exception.class.isInstance(e),
                    "Sie erbt von Exception");

            assertFalse(RuntimeException.class.isInstance(e),
                    "Aber NICHT von RuntimeException. Genau das macht sie zu einer "
                            + "geprueften Ausnahme: Java zwingt jeden Aufrufer, sich damit "
                            + "zu befassen. Wenn dieser Test rot ist, hast du vermutlich "
                            + "'extends RuntimeException' geschrieben.");
        }
    }

    @Nested
    @DisplayName("Kasse - Stufe 2")
    class KasseTests {

        @Test
        @DisplayName("Einzahlen erhoeht den Bestand")
        void einzahlen() {
            Kasse kasse = new Kasse(200_000);

            assertEquals(200_000, kasse.bestandInCent(), "Der Anfangsbestand");

            kasse.einzahlen(5_000);
            assertEquals(205_000, kasse.bestandInCent(), "50,00 EUR kommen dazu");
        }

        @Test
        @DisplayName("Ein negativer Betrag ist ein Programmierfehler - ungeprueft")
        void negativeEinzahlungFliegt() {
            Kasse kasse = new Kasse(200_000);

            IllegalArgumentException e = assertThrows(
                    IllegalArgumentException.class,
                    () -> kasse.einzahlen(-5_000),
                    "Ohne diese Pruefung koennte man ueber einzahlen(-5000) heimlich "
                            + "abbuchen. Erwartet wird eine IllegalArgumentException.");

            assertTrue(e.getMessage() != null && e.getMessage().contains("-5000"),
                    "Die Meldung soll den beanstandeten Wert nennen. 'Ungueltiger Betrag' "
                            + "hilft niemandem um drei Uhr nachts. Deine Meldung war: "
                            + e.getMessage());

            assertEquals(200_000, kasse.bestandInCent(),
                    "Und der Bestand bleibt unangetastet");
        }

        @Test
        @DisplayName("Abbuchen klappt, solange genug da ist")
        void abbuchenKlappt() {
            Kasse kasse = new Kasse(200_000);

            assertDoesNotThrow(() -> kasse.abbuchen(50_000),
                    "50,00 EUR von 2000,00 EUR abzubuchen ist kein Problem");

            assertEquals(150_000, kasse.bestandInCent(), "Es bleiben 1500,00 EUR");
        }

        @Test
        @DisplayName("Reicht es nicht, fliegt die eigene Ausnahme - mit Fehlbetrag")
        void abbuchenScheitert() {
            Kasse kasse = new Kasse(100_000);

            NichtGenugGeldException e = assertThrows(
                    NichtGenugGeldException.class,
                    () -> kasse.abbuchen(112_500),
                    "1125,00 EUR von 1000,00 EUR gehen nicht");

            assertEquals(12_500, e.fehlbetragInCent(),
                    "Es fehlen genau 125,00 EUR - und die Ausnahme sagt es auch");

            assertEquals(100_000, kasse.bestandInCent(),
                    "Entscheidend: Der Bestand ist UNVERAENDERT. Eine gescheiterte Buchung "
                            + "darf keine halben Spuren hinterlassen. Wenn hier ein anderer "
                            + "Wert steht, ziehst du ab, bevor du pruefst.");
        }

        @Test
        @DisplayName("finally zaehlt jeden Versuch - auch den gescheiterten")
        void finallyZaehltImmer() {
            Kasse kasse = new Kasse(100_000);

            assertEquals(0, kasse.buchungsversuche(), "Am Anfang gab es keinen Versuch");

            assertDoesNotThrow(() -> kasse.abbuchen(30_000), "Erster Versuch: klappt");
            assertEquals(1, kasse.buchungsversuche(), "Einer gezaehlt");

            assertThrows(NichtGenugGeldException.class, () -> kasse.abbuchen(999_999),
                    "Zweiter Versuch: scheitert");

            assertEquals(2, kasse.buchungsversuche(),
                    "Und wird trotzdem gezaehlt. Genau dafuer gibt es finally: Der Block "
                            + "laeuft auch dann, wenn die Methode mit einer Ausnahme "
                            + "verlassen wird. Steht hier 1, hast du den Zaehler hinter "
                            + "dem throw stehen - dort kommt er nie an.");
        }

        @Test
        @DisplayName("versucheAbbuchen uebersetzt die Ausnahme in ein Ja oder Nein")
        void versucheAbbuchen() {
            Kasse kasse = new Kasse(100_000);

            assertTrue(kasse.versucheAbbuchen(30_000), "30,00 EUR gehen");
            assertEquals(70_000, kasse.bestandInCent(), "Und werden abgezogen");

            assertFalse(kasse.versucheAbbuchen(999_999),
                    "999999 Cent gehen nicht - aber statt einer Ausnahme kommt hier "
                            + "schlicht false zurueck");

            assertEquals(70_000, kasse.bestandInCent(),
                    "Der Bestand bleibt unveraendert");
        }

        @Test
        @DisplayName("Programmierfehler werden NICHT verschluckt")
        void programmierfehlerFliegtDurch() {
            Kasse kasse = new Kasse(100_000);

            assertThrows(IllegalArgumentException.class,
                    () -> kasse.versucheAbbuchen(-500),
                    "versucheAbbuchen faengt nur die NichtGenugGeldException ab. Ein "
                            + "negativer Betrag ist ein Programmierfehler und muss sichtbar "
                            + "bleiben. Wer hier catch (Exception e) schreibt, verschluckt "
                            + "ihn - und sucht spaeter stundenlang.");
        }
    }

    @Nested
    @DisplayName("Eingabepruefung - fremde Ausnahmen fangen")
    class Eingaben {

        @Test
        @DisplayName("Betrag lesen - oder den Standardwert nehmen")
        void betragLesen() {
            assertEquals(450, Eingabepruefung.leseBetragOderStandard("4,50", 300),
                    "Ein gueltiger Betrag wird gelesen");

            assertEquals(450, Eingabepruefung.leseBetragOderStandard("4.50", 300),
                    "Punkt statt Komma geht auch - das erledigt Geld.ausText");

            assertEquals(300, Eingabepruefung.leseBetragOderStandard("zwoelf", 300),
                    "Unsinn ergibt den Standardwert statt eines Absturzes");

            assertEquals(300, Eingabepruefung.leseBetragOderStandard("", 300),
                    "Ein leerer Text ebenso");

            assertEquals(300, Eingabepruefung.leseBetragOderStandard(null, 300),
                    "Und null darf die Methode auch nicht umbringen");
        }

        @Test
        @DisplayName("Zahl lesen - die Ausnahmehierarchie faengt beide Faelle")
        void zahlLesen() {
            assertEquals(12, Eingabepruefung.leseZahlOderStandard("12", 5),
                    "Eine gueltige Zahl");

            assertEquals(12, Eingabepruefung.leseZahlOderStandard("  12  ", 5),
                    "Mit Leerzeichen drumherum - trim() nicht vergessen");

            assertEquals(5, Eingabepruefung.leseZahlOderStandard("zwoelf", 5),
                    "Unsinn ergibt den Standardwert. Integer.parseInt wirft dabei eine "
                            + "NumberFormatException - die erbt von IllegalArgumentException, "
                            + "ein catch auf die Oberklasse faengt sie also mit.");

            assertEquals(5, Eingabepruefung.leseZahlOderStandard(null, 5),
                    "Bei null wirft parseInt eine andere Ausnahme - auch die muss "
                            + "abgefangen oder vorher abgeprueft werden");

            assertEquals(-7, Eingabepruefung.leseZahlOderStandard("-7", 5),
                    "Negative Zahlen sind gueltig und werden gelesen");
        }

        @Test
        @DisplayName("Preispruefung meldet per Rueckgabewert, nicht per Ausnahme")
        void preispruefung() {
            assertNull(Eingabepruefung.pruefeVerkaufspreis(250),
                    "2,50 EUR ist in Ordnung - dann gibt es nichts zu melden");

            assertNull(Eingabepruefung.pruefeVerkaufspreis(1),
                    "Genau 1 Cent ist noch erlaubt");

            assertNull(Eingabepruefung.pruefeVerkaufspreis(1000),
                    "Und genau 10,00 EUR auch");

            assertEquals("Preis muss mindestens 0,01 EUR betragen.",
                    Eingabepruefung.pruefeVerkaufspreis(0),
                    "0 Cent ist zu wenig");

            assertEquals("Preis darf hoechstens 10,00 EUR betragen.",
                    Eingabepruefung.pruefeVerkaufspreis(1001),
                    "Ein Cent ueber der Grenze ist zu viel");
        }
    }

    @Nested
    @DisplayName("Assertions - und warum sie hier nicht hingehoeren")
    class Assertions {

        @Test
        @DisplayName("In Tests sind Assertions an - beim normalen Start nicht")
        void assertionsSindNurHierAn() {
            // Der Trick: Die Zuweisung in der assert-Zeile passiert nur, wenn Assertions
            // ueberhaupt ausgefuehrt werden. Sonst wird die ganze Zeile uebersprungen.
            boolean assertionsAktiv = false;
            assert (assertionsAktiv = true);

            assertTrue(assertionsAktiv,
                    "Maven schaltet Assertions fuer Tests ein. Startet ihr dasselbe "
                            + "Programm normal, sind sie AUS - dann wird die assert-Zeile "
                            + "einfach uebersprungen. Genau deshalb darf man mit assert "
                            + "niemals Benutzereingaben pruefen: Im Betrieb passiert dann "
                            + "gar nichts. Dafuer sind Ausnahmen da. Assertions sind fuer "
                            + "interne Annahmen, von denen ihr ueberzeugt seid.");
        }
    }
}
