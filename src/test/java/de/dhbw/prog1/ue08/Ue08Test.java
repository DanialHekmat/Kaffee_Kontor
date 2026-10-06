package de.dhbw.prog1.ue08;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests zu Uebung 8.
 *
 * <p>Diese Datei musst du nicht veraendern - sie ist deine Selbstkontrolle.
 *
 * <p>Achte auf den Unterschied zu den bisherigen Tests: Hier wird nicht mehr eine Methode mit
 * Zahlen gefuettert und das Ergebnis geprueft. Hier werden <b>Objekte erzeugt</b>, mehrere
 * Aufrufe hintereinander gemacht und danach gefragt, was sich das Objekt gemerkt hat.
 */
@DisplayName("Uebung 8 - Klassen und Objekte")
class Ue08Test {

    @Nested
    @DisplayName("Kaffeesorte")
    class Sorte {

        @Test
        @DisplayName("Konstruktor und name() - Achtung bei this")
        void konstruktorSetztAttribute() {
            Kaffeesorte haus = new Kaffeesorte("Hausmischung", 2800);

            assertEquals("Hausmischung", haus.name(),
                    "Der Name muss vom Konstruktor ins Attribut uebernommen werden. Kommt "
                            + "hier null oder ein leerer Text an, fehlt vermutlich das this: "
                            + "'name = name' weist den Parameter sich selbst zu und aendert "
                            + "am Attribut nichts.");

            Kaffeesorte bio = new Kaffeesorte("Bio-Hochland", 3650);
            assertEquals("Bio-Hochland", bio.name(),
                    "Ein zweites Objekt traegt seinen eigenen Namen");
        }

        @Test
        @DisplayName("Jedes Objekt rechnet mit seinen eigenen Werten")
        void kostenProBecher() {
            Kaffeesorte haus = new Kaffeesorte("Hausmischung", 2800);
            Kaffeesorte bio = new Kaffeesorte("Bio-Hochland", 3650);

            assertEquals(35, haus.kostenProBecherInCent(),
                    "2800 Cent je Sack, geteilt durch 80 Becher, ergibt 35 Cent");

            assertEquals(45, bio.kostenProBecherInCent(),
                    "3650 geteilt durch 80 sind rechnerisch 45,625 - ganzzahlig also 45. "
                            + "Dieselbe Methode, ein anderes Ergebnis: weil sie den Preis aus "
                            + "dem Attribut ihres eigenen Objekts holt.");
        }

        @Test
        @DisplayName("Deckungsbeitrag")
        void deckungsbeitrag() {
            Kaffeesorte haus = new Kaffeesorte("Hausmischung", 2800);

            assertEquals(215, haus.deckungsbeitragInCent(250),
                    "2,50 EUR Verkaufspreis minus 35 Cent Rohstoff ergibt 2,15 EUR");

            assertEquals(-35, haus.deckungsbeitragInCent(0),
                    "Wer verschenkt, bleibt auf den Rohstoffkosten sitzen");
        }

        @Test
        @DisplayName("Eine Sorte mit einer anderen vergleichen")
        void sortenVergleich() {
            Kaffeesorte haus = new Kaffeesorte("Hausmischung", 2800);
            Kaffeesorte bio = new Kaffeesorte("Bio-Hochland", 3650);
            Kaffeesorte zweiteHaus = new Kaffeesorte("Hausmischung II", 2800);

            assertTrue(bio.istTeurerAls(haus),
                    "3650 ist teurer als 2800");

            assertFalse(haus.istTeurerAls(bio),
                    "Umgekehrt gilt es nicht - achte darauf, in welche Richtung du "
                            + "vergleichst");

            assertFalse(haus.istTeurerAls(zweiteHaus),
                    "Bei gleichem Preis ist die Antwort false: gleich teuer ist nicht teurer");
        }

        @Test
        @DisplayName("toString beschreibt die Sorte lesbar")
        void sorteAlsText() {
            Kaffeesorte haus = new Kaffeesorte("Hausmischung", 2800);

            assertEquals("Hausmischung: 28,00 EUR je Sack, 35 ct je Becher", haus.toString(),
                    "Achte auf Doppelpunkt, Komma und Leerzeichen. Wenn hier etwas wie "
                            + "'Kaffeesorte@6d06d69c' steht, hast du toString noch nicht "
                            + "ueberschrieben.");

            assertEquals("Bio-Hochland: 36,50 EUR je Sack, 45 ct je Becher",
                    new Kaffeesorte("Bio-Hochland", 3650).toString(),
                    "Auch fuer die zweite Sorte");
        }
    }

    @Nested
    @DisplayName("Lager")
    class LagerTests {

        @Test
        @DisplayName("Ein frisches Lager ist leer")
        void frischesLager() {
            Lager lager = new Lager(12);

            assertEquals(0, lager.bestand(), "Am Anfang liegt nichts drin");
            assertEquals(12, lager.freierPlatz(), "Also ist alles frei");
            assertFalse(lager.istVoll(), "Und voll ist es erst recht nicht");
        }

        @Test
        @DisplayName("Das Lager merkt sich, was hineingelegt wurde")
        void lagerMerktSichDenBestand() {
            Lager lager = new Lager(12);

            assertEquals(5, lager.einlagern(5),
                    "Fuenf Saecke passen problemlos hinein");

            assertEquals(3, lager.einlagern(3),
                    "Drei weitere auch");

            assertEquals(8, lager.bestand(),
                    "Und jetzt liegen 8 Saecke drin. Niemand hat dem Lager beim zweiten "
                            + "Aufruf gesagt, dass schon 5 da waren - es weiss es selbst. "
                            + "Genau dafuer gibt es Objekte. Kommt hier 3 heraus, "
                            + "ueberschreibst du den Bestand statt ihn zu erhoehen.");

            assertEquals(4, lager.freierPlatz(), "Von 12 Plaetzen sind noch 4 frei");
        }

        @Test
        @DisplayName("Es passt nur hinein, was hineinpasst")
        void lagerLaeuftNichtUeber() {
            Lager lager = new Lager(12);
            lager.einlagern(5);

            assertEquals(7, lager.einlagern(10),
                    "Es wurden 10 angeboten, aber nur 7 passten noch - zurueckgegeben wird, "
                            + "was wirklich hineingegangen ist");

            assertEquals(12, lager.bestand(), "Jetzt ist es randvoll");
            assertTrue(lager.istVoll(), "Und meldet das auch");
            assertEquals(0, lager.freierPlatz(), "Kein Platz mehr");

            assertEquals(0, lager.einlagern(1),
                    "In ein volles Lager geht nichts mehr");
            assertEquals(12, lager.bestand(),
                    "Und der Bestand darf die Kapazitaet niemals ueberschreiten");
        }

        @Test
        @DisplayName("Entnehmen, aber nicht ins Minus")
        void entnehmenBegrenzt() {
            Lager lager = new Lager(12);
            lager.einlagern(9);

            assertEquals(3, lager.entnehmen(3), "Drei von neun - kein Problem");
            assertEquals(6, lager.bestand(), "Es bleiben sechs");

            assertEquals(6, lager.entnehmen(20),
                    "Es wurden 20 verlangt, aber nur 6 waren da - mehr kann niemand "
                            + "herausnehmen");

            assertEquals(0, lager.bestand(),
                    "Das Lager ist leer. Der Bestand darf nie negativ werden.");

            assertEquals(0, lager.entnehmen(1),
                    "Aus einem leeren Lager kommt nichts");
        }

        @Test
        @DisplayName("Negative Mengen aendern nichts")
        void negativeMengen() {
            Lager lager = new Lager(12);
            lager.einlagern(5);

            assertEquals(0, lager.einlagern(-3),
                    "Eine negative Einlagerung wird abgelehnt");
            assertEquals(5, lager.bestand(),
                    "Ohne diese Abfrage koennte man ueber einlagern(-3) heimlich Saecke "
                            + "verschwinden lassen");

            assertEquals(0, lager.entnehmen(-3),
                    "Eine negative Entnahme ebenso");
            assertEquals(5, lager.bestand(),
                    "Sonst liesse sich ueber entnehmen(-3) Ware aus dem Nichts erzeugen");
        }

        @Test
        @DisplayName("Zwei Lager sind zwei Lager")
        void objekteSindUnabhaengig() {
            Lager hamburg = new Lager(12);
            Lager bremen = new Lager(20);

            hamburg.einlagern(7);

            assertEquals(7, hamburg.bestand(), "In Hamburg liegen 7 Saecke");

            assertEquals(0, bremen.bestand(),
                    "In Bremen liegt nichts. Jedes Objekt hat sein eigenes Gedaechtnis - "
                            + "wenn hier 7 herauskommt, hast du das Attribut versehentlich "
                            + "static gemacht. Dann gaebe es den Bestand nur EINMAL fuer "
                            + "alle Lager der Welt.");

            assertEquals(20, bremen.freierPlatz(),
                    "Und Bremen hat seine eigene Kapazitaet");
        }

        @Test
        @DisplayName("toString beschreibt das Lager lesbar")
        void lagerAlsText() {
            Lager lager = new Lager(12);
            lager.einlagern(5);

            assertEquals("Lager: 5 von 12 Saecken", lager.toString(),
                    "Achte auf Doppelpunkt und Leerzeichen");

            lager.entnehmen(5);
            assertEquals("Lager: 0 von 12 Saecken", lager.toString(),
                    "toString liest die Attribute jedes Mal neu - es darf nichts "
                            + "Festgeschriebenes darin stehen");
        }
    }
}
