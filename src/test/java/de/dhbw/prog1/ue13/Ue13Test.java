package de.dhbw.prog1.ue13;

import de.dhbw.prog1.kern.Kaffeesorte;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests zu Uebung 13.
 *
 * <p>Diese Datei musst du nicht veraendern - sie ist deine Selbstkontrolle.
 *
 * <p>Der Block "Warum hashCode gebraucht wird" fuehrt den Fehler einmal vor, um den es geht.
 * Lies ihn, auch wenn er von sich aus gruen ist.
 */
@DisplayName("Uebung 13 - Collections")
class Ue13Test {

    /** 2550 / 80 = 31 ct je Becher - die guenstigste im Testsatz. */
    private static Kaffeesorte standard() {
        return new Kaffeesorte("Standard", 2550);
    }

    /** 2800 / 80 = 35 ct je Becher. */
    private static Kaffeesorte haus() {
        return new Kaffeesorte("Hausmischung", 2800);
    }

    /** 3650 / 80 = 45 ct je Becher. */
    private static Kaffeesorte bio() {
        return new Kaffeesorte("Bio-Hochland", 3650);
    }

    @Nested
    @DisplayName("Sortenkatalog - Stufe 1")
    class Katalog {

        @Test
        @DisplayName("Die Liste waechst von selbst - keine Hoechstzahl mehr")
        void listeWaechst() {
            Sortenkatalog katalog = new Sortenkatalog();

            assertEquals(0, katalog.anzahl(), "Ein neuer Katalog ist leer");

            katalog.aufnehmen(haus());
            katalog.aufnehmen(bio());
            katalog.aufnehmen(standard());

            assertEquals(3, katalog.anzahl(), "Drei Sorten aufgenommen");

            // In Uebung 9 war hier die Hoechstzahl erreicht und aufnehmen haette false
            // geliefert. Eine ArrayList waechst einfach weiter.
            for (int i = 0; i < 50; i++) {
                katalog.aufnehmen(new Kaffeesorte("Sorte " + i, 2800 + i));
            }

            assertEquals(53, katalog.anzahl(),
                    "53 Sorten - eine Liste hat keine feste Groesse. Genau das war in "
                            + "Uebung 9 die halbe Arbeit.");
        }

        @Test
        @DisplayName("null wird abgelehnt, ohne den Katalog zu vergiften")
        void nullWirdAbgelehnt() {
            Sortenkatalog katalog = new Sortenkatalog();

            katalog.aufnehmen(null);
            assertEquals(0, katalog.anzahl(),
                    "null gehoert nicht in die Sammlung - es faellt sonst erst spaeter "
                            + "beim Durchlaufen auf, an einer ganz anderen Stelle");

            katalog.aufnehmen(haus());
            assertEquals(1, katalog.anzahl(), "Eine echte Sorte kommt hinein");
        }

        @Test
        @DisplayName("Suchen nach Namen")
        void suchen() {
            Sortenkatalog katalog = new Sortenkatalog();
            Kaffeesorte hausmischung = haus();
            katalog.aufnehmen(hausmischung);
            katalog.aufnehmen(bio());

            assertSame(hausmischung, katalog.findeNachName(new String("Hausmischung")),
                    "Der Suchtext wird absichtlich zur Laufzeit gebaut. Wenn hier null "
                            + "ankommt, vergleichst du die Namen mit == statt mit equals.");

            assertNull(katalog.findeNachName("Espresso"),
                    "Was es nicht gibt, wird nicht gefunden");
        }

        @Test
        @DisplayName("Sortieren mit Comparator - und der Katalog bleibt unangetastet")
        void sortieren() {
            Sortenkatalog katalog = new Sortenkatalog();
            katalog.aufnehmen(haus());
            katalog.aufnehmen(bio());
            katalog.aufnehmen(standard());

            List<Kaffeesorte> sortiert = katalog.sortiertNachBecherpreis();

            assertEquals(3, sortiert.size(), "Alle drei Sorten sind dabei");

            assertEquals("Standard", sortiert.get(0).name(),
                    "31 ct je Becher - die guenstigste zuerst");
            assertEquals("Hausmischung", sortiert.get(1).name(), "Dann 35 ct");
            assertEquals("Bio-Hochland", sortiert.get(2).name(), "Dann 45 ct");

            // Die Reihenfolge im Katalog selbst darf sich nicht geaendert haben.
            assertSame(katalog.findeNachName("Hausmischung"),
                    katalog.findeNachName("Hausmischung"),
                    "Der Katalog ist noch benutzbar");

            assertEquals(3, katalog.anzahl(),
                    "Und enthaelt weiterhin drei Sorten - sortiertNachBecherpreis gibt eine "
                            + "Kopie zurueck, keine Sicht auf die innere Liste");
        }
    }

    @Nested
    @DisplayName("Umsatzbuch - Stufe 2")
    class Buch {

        @Test
        @DisplayName("Buchungen summieren sich auf")
        void buchungenSummieren() {
            Umsatzbuch buch = new Umsatzbuch();

            buch.buche("Hausmischung", 5_000);
            assertEquals(5_000, buch.umsatzFuer("Hausmischung"), "Erste Buchung");

            buch.buche("Hausmischung", 3_000);
            assertEquals(8_000, buch.umsatzFuer("Hausmischung"),
                    "Zweite Buchung kommt dazu - 80,00 EUR. Steht hier 3000, ueberschreibst "
                            + "du den Wert statt ihn zu erhoehen. Denk an getOrDefault.");
        }

        @Test
        @DisplayName("Unbekannte Sorten haben 0 Umsatz - und stuerzen nicht ab")
        void unbekannteSorte() {
            Umsatzbuch buch = new Umsatzbuch();

            assertEquals(0, buch.umsatzFuer("Espresso"),
                    "Ohne Buchung ist der Umsatz 0. Eine HashMap liefert fuer einen "
                            + "unbekannten Schluessel null - wer das ungeprueft in ein int "
                            + "schreibt, bekommt eine NullPointerException. Genau dagegen "
                            + "gibt es getOrDefault.");

            assertEquals(0, buch.gesamtumsatz(), "Ein leeres Buch hat keinen Umsatz");
            assertNull(buch.besteSorte(), "Und keine beste Sorte");

            // Gegenprobe: Sonst waere dieser Test auch mit einem unbearbeiteten Geruest
            // gruen - das liefert von sich aus 0 und null.
            buch.buche("Hausmischung", 5_000);
            assertEquals(5_000, buch.gesamtumsatz(), "Nach einer Buchung nicht mehr");
            assertEquals("Hausmischung", buch.besteSorte(), "Und es gibt eine beste Sorte");
        }

        @Test
        @DisplayName("keySet liefert die Sorten als Menge")
        void sortenMenge() {
            Umsatzbuch buch = new Umsatzbuch();
            buch.buche("Hausmischung", 5_000);
            buch.buche("Bio-Hochland", 12_000);
            buch.buche("Hausmischung", 3_000);

            Set<String> sorten = buch.sorten();

            assertEquals(2, sorten.size(),
                    "Zwei verschiedene Sorten - obwohl dreimal gebucht wurde. Ein Schluessel "
                            + "kommt in einer Map nur einmal vor.");

            assertTrue(sorten.contains("Hausmischung"), "Hausmischung ist dabei");
            assertTrue(sorten.contains("Bio-Hochland"), "Bio-Hochland auch");
            assertFalse(sorten.contains("Espresso"), "Espresso nicht");
        }

        @Test
        @DisplayName("Gesamtumsatz und beste Sorte")
        void auswertung() {
            Umsatzbuch buch = new Umsatzbuch();
            buch.buche("Hausmischung", 5_000);
            buch.buche("Hausmischung", 3_000);
            buch.buche("Bio-Hochland", 12_000);

            assertEquals(20_000, buch.gesamtumsatz(),
                    "80,00 plus 120,00 EUR ergeben 200,00 EUR");

            assertEquals("Bio-Hochland", buch.besteSorte(),
                    "Bio-Hochland liegt mit 120,00 EUR vorn. Hier brauchst du Schluessel "
                            + "und Wert gleichzeitig - dafuer gibt es entrySet().");
        }

        @Test
        @DisplayName("Gutschriften sind erlaubt")
        void gutschrift() {
            Umsatzbuch buch = new Umsatzbuch();
            buch.buche("Hausmischung", 5_000);
            buch.buche("Hausmischung", -2_000);

            assertEquals(3_000, buch.umsatzFuer("Hausmischung"),
                    "Ein negativer Betrag ist eine Gutschrift und wird verrechnet");
        }
    }

    @Nested
    @DisplayName("Kunde - equals und hashCode gehoeren zusammen")
    class KundeTests {

        @Test
        @DisplayName("Gleich ist, wer dieselbe Kundennummer hat")
        void gleichheit() {
            Kunde einer = new Kunde(42, "Schmidt");
            Kunde anderer = new Kunde(42, "Schmidt-Yildiz");

            assertEquals(42, einer.kundennummer(), "Die Nummer kommt aus dem Konstruktor");
            assertEquals("Schmidt", einer.name(), "Und der Name auch");

            assertTrue(einer.equals(anderer),
                    "Dieselbe Kundennummer, also derselbe Kunde - der Name darf sich "
                            + "aendern, die Nummer nicht");

            assertFalse(einer.equals(new Kunde(43, "Schmidt")),
                    "Andere Nummer, anderer Kunde - auch bei gleichem Namen");

            assertFalse(einer.equals(null), "Ein Vergleich mit null liefert false");
            assertFalse(einer.equals("42"), "Und mit einem Text ebenfalls");
        }

        @Test
        @DisplayName("Gleiche Kunden MUESSEN denselben Hashwert haben")
        void hashwertPasstZurGleichheit() {
            Kunde einer = new Kunde(42, "Schmidt");
            Kunde anderer = new Kunde(42, "Schmidt-Yildiz");

            assertEquals(einer.hashCode(), anderer.hashCode(),
                    "Diese beiden sind equals - dann MUSS auch der Hashwert gleich sein. "
                            + "Sonst legt eine HashMap sie an verschiedenen Hausnummern ab "
                            + "und findet das eine nicht, obwohl das andere schon drinsteht. "
                            + "In hashCode gehoeren genau die Felder, die equals vergleicht - "
                            + "hier also die Kundennummer und NICHT der Name.");

            assertEquals(einer.hashCode(), einer.hashCode(),
                    "Und derselbe Aufruf liefert immer dasselbe");

            assertNotEquals(new Kunde(1, "A").hashCode(), new Kunde(2, "A").hashCode(),
                    "Verschiedene Kunden sollen verschiedene Hashwerte bekommen. Streng "
                            + "genommen WAERE ein immer gleicher Hashwert erlaubt - der "
                            + "Vertrag verlangt nur, dass gleiche Objekte gleiche Werte "
                            + "haben. Nur landete dann alles an derselben Hausnummer, und "
                            + "die Map muesste wieder alles durchsuchen: formal richtig, "
                            + "praktisch nutzlos. Objects.hash(kundennummer) erledigt es "
                            + "richtig.");
        }

        @Test
        @DisplayName("Im HashSet zaehlt der Kunde nur einmal")
        void imHashSet() {
            Set<Kunde> kunden = new HashSet<>();

            kunden.add(new Kunde(42, "Schmidt"));
            kunden.add(new Kunde(42, "Schmidt-Yildiz"));
            kunden.add(new Kunde(43, "Mueller"));

            assertEquals(2, kunden.size(),
                    "Zwei verschiedene Kunden - die Nummer 42 wurde nur einmal aufgenommen, "
                            + "obwohl es zwei verschiedene Objekte waren. Das klappt nur, "
                            + "wenn equals UND hashCode stimmen.");
        }

        @Test
        @DisplayName("In der HashMap findet ein gleichwertiger Schluessel den Eintrag")
        void inDerHashMap() {
            Map<Kunde, Integer> bestellungen = new HashMap<>();

            bestellungen.put(new Kunde(42, "Schmidt"), 17);

            // Ein anderes Objekt, dieselbe Nummer - und es findet den Eintrag.
            Integer gefunden = bestellungen.get(new Kunde(42, "voelliger anderer Name"));

            assertNotNull(gefunden,
                    "Ein gleichwertiger Schluessel muss den Eintrag finden. Kommt hier null, "
                            + "fehlt hashCode - die Map sucht dann an der falschen "
                            + "Hausnummer und schaut nie beim richtigen Eintrag vorbei.");

            assertEquals(17, gefunden, "Und zwar den richtigen");
        }
    }

    @Nested
    @DisplayName("Warum hashCode gebraucht wird (Vorfuehrung - schon gruen)")
    class WarumHashCode {

        /**
         * Eine absichtlich unfertige Klasse: equals ist da, hashCode fehlt.
         *
         * <p>Genau so sah {@code Spieler} in Einheit 9 aus. Damals fiel es nicht auf, weil
         * nur Arrays und Listen im Spiel waren.
         */
        private static class SchluesselOhneHashCode {

            private int nummer;

            SchluesselOhneHashCode(int nummer) {
                this.nummer = nummer;
            }

            @Override
            public boolean equals(Object anderes) {
                if (this == anderes) {
                    return true;
                }
                if (!(anderes instanceof SchluesselOhneHashCode andererSchluessel)) {
                    return false;
                }
                return nummer == andererSchluessel.nummer;
            }

            // Kein hashCode. Das ist der Fehler, den dieser Block vorfuehrt.
        }

        @Test
        @DisplayName("Ohne hashCode landet dasselbe zweimal in der Menge")
        void ohneHashCodeGehtEsSchief() {
            SchluesselOhneHashCode einer = new SchluesselOhneHashCode(1);
            SchluesselOhneHashCode anderer = new SchluesselOhneHashCode(1);

            assertTrue(einer.equals(anderer),
                    "equals sagt: Das ist dasselbe.");

            Set<SchluesselOhneHashCode> menge = new HashSet<>();
            menge.add(einer);
            menge.add(anderer);

            assertEquals(2, menge.size(),
                    "Und trotzdem liegen jetzt ZWEI Eintraege in der Menge. equals sagt "
                            + "gleich, die HashSet sagt verschieden - weil sie zuerst den "
                            + "Hashwert vergleicht, und der ist ohne eigenes hashCode fuer "
                            + "jedes Objekt anders. Sie schaut gar nicht beim richtigen "
                            + "Eintrag nach. Genau dieser Fehler passiert lautlos und faellt "
                            + "erst Wochen spaeter auf.");

            // Und zum Vergleich: mit richtigem Kunden geht es auf.
            Set<Kunde> kunden = new HashSet<>();
            kunden.add(new Kunde(1, "A"));
            kunden.add(new Kunde(1, "B"));

            assertEquals(1, kunden.size(),
                    "Mit vollstaendigem equals und hashCode dagegen: genau ein Eintrag.");
        }
    }
}
