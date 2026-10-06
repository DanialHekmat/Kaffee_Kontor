package de.dhbw.prog1.ue10;

import de.dhbw.prog1.kern.Kaffeesorte;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests zu Uebung 10.
 *
 * <p>Diese Datei musst du nicht veraendern - sie ist deine Selbstkontrolle.
 */
@DisplayName("Uebung 10 - Vererbung und Polymorphie")
class Ue10Test {

    /** Eine gewoehnliche Sorte: 2800 / 80 = 35 ct je Becher. */
    private static Kaffeesorte haus() {
        return new Kaffeesorte("Hausmischung", 2800);
    }

    /** Bio: 3650 / 80 = 45, plus 20 Prozent = 54 ct je Becher. */
    private static BioSorte bio() {
        return new BioSorte("Bio-Hochland", 3650, 20);
    }

    /** Grosspackung: 9000 / 300 = 30 ct je Becher - trotz hoechstem Sackpreis. */
    private static Grosspackung gastro() {
        return new Grosspackung("Gastro-Mischung", 9000, 300);
    }

    @Nested
    @DisplayName("BioSorte - Stufe 1")
    class Bio {

        @Test
        @DisplayName("Geerbtes funktioniert ohne eine Zeile Code (sofort gruen - das IST der Punkt)")
        void erbtAllesAndere() {
            // Dieser Test ist gruen, sobald die Klasse ueberhaupt existiert - noch bevor du
            // eine einzige Methode ausgefuellt hast. Das ist keine Nachlaessigkeit, sondern
            // die Aussage der Einheit: Alles, was du NICHT hinschreibst, erbst du.
            BioSorte sorte = bio();

            assertEquals("Bio-Hochland", sorte.name(),
                    "name() steht in der Oberklasse und wird geerbt - du hast dafuer nichts "
                            + "geschrieben. Wenn hier null kommt, fehlt vermutlich der "
                            + "super-Aufruf im Konstruktor.");

            assertEquals(3650, sorte.einkaufspreisProSackInCent(),
                    "Auch der Einkaufspreis kommt aus der Oberklasse");
        }

        @Test
        @DisplayName("Der Aufschlag wird auf die Basis aufgeschlagen")
        void aufschlagWirdBerechnet() {
            assertEquals(54, bio().kostenProBecherInCent(),
                    "3650 / 80 ergibt 45 Cent Basis. 20 Prozent davon sind 9 Cent. "
                            + "Zusammen 54.");

            assertEquals(45, new BioSorte("Ohne Aufschlag", 3650, 0).kostenProBecherInCent(),
                    "Ohne Aufschlag bleibt es bei der Basis der Oberklasse");

            assertEquals(70, new BioSorte("Teuer", 2800, 100).kostenProBecherInCent(),
                    "2800 / 80 sind 35, plus 100 Prozent also 70");
        }

        @Test
        @DisplayName("Deckungsbeitrag rechnet automatisch mit dem Aufschlag")
        void deckungsbeitragNutztUeberschriebeneMethode() {
            assertEquals(196, bio().deckungsbeitragInCent(250),
                    "250 minus 54 ergibt 196. Bemerkenswert: deckungsbeitragInCent steht in "
                            + "der Oberklasse und wurde nicht angefasst - sie ruft aber "
                            + "kostenProBecherInCent auf, und Java nimmt dabei DEINE Fassung. "
                            + "Kommt hier 205 heraus, wurde die Basis der Oberklasse benutzt.");

            assertEquals(215, haus().deckungsbeitragInCent(250),
                    "Bei der gewoehnlichen Sorte bleibt es bei 250 minus 35");
        }

        @Test
        @DisplayName("toString - und der Beweis fuer dynamische Bindung")
        void bioAlsText() {
            assertEquals("Bio-Hochland: 36,50 EUR je Sack, 54 ct je Becher [Bio +20%]",
                    bio().toString(),
                    "Achte auf die 54: Der vordere Teil stammt aus der Oberklasse, und die "
                            + "kennt gar keinen Zertifizierungsaufschlag. Sie ruft aber "
                            + "kostenProBecherInCent auf - und Java entscheidet zur Laufzeit "
                            + "anhand des tatsaechlichen Objekts, dass deine Fassung gemeint "
                            + "ist. Steht dort 45, hast du den Text selbst zusammengebaut "
                            + "statt super.toString() zu benutzen.");
        }
    }

    @Nested
    @DisplayName("Grosspackung - Stufe 2")
    class Gross {

        @Test
        @DisplayName("Die Rechnung der Oberklasse wird vollstaendig ersetzt")
        void eigeneBechermenge() {
            assertEquals(30, gastro().kostenProBecherInCent(),
                    "9000 Cent fuer 300 Becher ergeben 30 Cent je Becher. Kommt hier 112 "
                            + "heraus, wurde noch mit den 80 Bechern aus den Spielregeln "
                            + "gerechnet.");

            assertEquals(25, new Grosspackung("XXL", 10_000, 400).kostenProBecherInCent(),
                    "10000 / 400 sind 25");
        }

        @Test
        @DisplayName("toString mit Packungsgroesse")
        void gastroAlsText() {
            assertEquals("Gastro-Mischung: 90,00 EUR je Sack, 30 ct je Becher "
                            + "[300 Becher/Sack]",
                    gastro().toString(),
                    "Auch hier stammt der vordere Teil aus der Oberklasse");
        }
    }

    @Nested
    @DisplayName("Preisliste - Polymorphie")
    class Liste {

        @Test
        @DisplayName("Der hoechste Sackpreis ist der niedrigste Becherpreis")
        void guenstigsteWirdPolymorphGefunden() {
            Kaffeesorte gastroSorte = gastro();
            Kaffeesorte[] sorten = {haus(), bio(), gastroSorte};

            assertSame(gastroSorte, Preisliste.guenstigsteProBecher(sorten),
                    "Je Becher: 35, 54 und 30 Cent - die Grosspackung gewinnt, obwohl ihr "
                            + "Sack mit 90,00 EUR mit Abstand der teuerste ist. Wer die "
                            + "Sackpreise vergleicht statt kostenProBecherInCent, bekommt "
                            + "hier die Hausmischung.");
        }

        @Test
        @DisplayName("Leeres Array liefert null")
        void leereListe() {
            assertNull(Preisliste.guenstigsteProBecher(new Kaffeesorte[0]),
                    "Ohne Sorten gibt es keine guenstigste");

            assertEquals(0, Preisliste.anzahlUeber(new Kaffeesorte[0], 40),
                    "Und nichts zu zaehlen");

            assertEquals("", Preisliste.alsListe(new Kaffeesorte[0]),
                    "Und nichts aufzulisten");

            // Gegenprobe: Sonst waere dieser Test auch mit einem unbearbeiteten Geruest
            // gruen - denn das liefert von sich aus null, 0 und den leeren Text.
            Kaffeesorte[] eine = {haus()};
            assertSame(eine[0], Preisliste.guenstigsteProBecher(eine),
                    "Bei genau einer Sorte ist diese auch die guenstigste");
            assertEquals(1, Preisliste.anzahlUeber(eine, 30),
                    "Und mit 35 Cent liegt sie ueber 30");
        }

        @Test
        @DisplayName("Zaehlen oberhalb einer Grenze")
        void zaehlenUeberGrenze() {
            Kaffeesorte[] sorten = {haus(), bio(), gastro()};

            assertEquals(1, Preisliste.anzahlUeber(sorten, 40),
                    "Von 35, 54 und 30 Cent liegt nur die Bio-Sorte ueber 40");

            assertEquals(2, Preisliste.anzahlUeber(sorten, 30),
                    "Ueber 30 liegen 35 und 54 - die Grosspackung mit genau 30 nicht, "
                            + "denn gefragt ist echtes 'mehr als'");

            assertEquals(0, Preisliste.anzahlUeber(sorten, 100),
                    "Ueber 100 Cent liegt keine");
        }

        @Test
        @DisplayName("Jede Sorte beschreibt sich selbst richtig")
        void listeNutztJeweilsEigenesToString() {
            Kaffeesorte[] sorten = {haus(), bio(), gastro()};
            String liste = Preisliste.alsListe(sorten);

            String[] zeilen = liste.split("\n");

            assertEquals(3, zeilen.length,
                    "Drei Sorten, drei Zeilen - getrennt durch \\n");

            assertEquals("Hausmischung: 28,00 EUR je Sack, 35 ct je Becher", zeilen[0],
                    "Die gewoehnliche Sorte ohne Zusatz");

            assertTrue(zeilen[1].endsWith("[Bio +20%]"),
                    "Die Bio-Sorte mit ihrem Aufschlag - obwohl alsListe gar nicht weiss, "
                            + "dass es Bio-Sorten gibt. Zeile war: " + zeilen[1]);

            assertTrue(zeilen[2].endsWith("[300 Becher/Sack]"),
                    "Und die Grosspackung mit ihrer Bechermenge. Genau das ist Polymorphie: "
                            + "ein Aufruf, drei Verhalten. Zeile war: " + zeilen[2]);
        }

        @Test
        @DisplayName("Die Liste funktioniert auch mit Sorten, die es noch nicht gab")
        void funktioniertMitNeuenArten() {
            // Eine vierte Art, hier im Test erfunden - Preisliste kennt sie nicht und
            // wurde fuer sie nicht geaendert. Trotzdem wird sie richtig behandelt.
            Kaffeesorte probe = new Kaffeesorte("Probe", 4000) {
                @Override
                public int kostenProBecherInCent() {
                    return 5;
                }
            };

            Kaffeesorte[] sorten = {haus(), probe, gastro()};

            assertSame(probe, Preisliste.guenstigsteProBecher(sorten),
                    "Mit 5 Cent je Becher ist die neue Art die guenstigste. Preisliste "
                            + "musste dafuer nicht angefasst werden - sie fragt einfach jede "
                            + "Sorte und bekommt die richtige Antwort. Das ist der eigentliche "
                            + "Gewinn von Polymorphie.");
        }
    }
}
