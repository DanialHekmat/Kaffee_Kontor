package de.dhbw.prog1.ue09;

import de.dhbw.prog1.kern.Kaffeesorte;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests zu Uebung 9.
 *
 * <p>Diese Datei musst du nicht veraendern - sie ist deine Selbstkontrolle.
 *
 * <p>Der Block "Der Referenz-Moment" ist der wichtigste. Lies dort die Fehlermeldungen
 * besonders genau - sie beschreiben ein Verhalten, das man einmal begriffen haben muss.
 */
@DisplayName("Uebung 9 - Kapselung, static und Referenzen")
class Ue09Test {

    /**
     * Erzeugt einen Text, der garantiert erst zur Laufzeit entsteht.
     *
     * <p>Dasselbe Hilfsmittel wie in Uebung 3, und aus demselben Grund: Texte, die woertlich
     * im Quelltext stehen, legt Java zusammen - dann funktioniert sogar der falsche
     * Vergleich mit {@code ==} zufaellig. Eine Suchanfrage aus einer Benutzereingabe ist
     * aber nie so ein Text. Jetzt, nach dem Referenz-Block, wisst ihr auch, warum.
     */
    private static String wieVomBenutzerGetippt(String text) {
        return new String(text.toCharArray());
    }

    @Nested
    @DisplayName("Spieler - Stufe 1")
    class SpielerBasis {

        @Test
        @DisplayName("Konstruktor setzt Name und Startkapital")
        void konstruktor() {
            Spieler schmidt = new Spieler("Schmidt");

            assertEquals("Schmidt", schmidt.name(),
                    "Der Name kommt aus dem Konstruktor. Bei null fehlt das this.");

            assertEquals(200_000, schmidt.kasseInCent(),
                    "Jeder Spieler startet mit dem Startkapital von 2000,00 EUR aus den "
                            + "Spielregeln - nicht mit 0");
        }

        @Test
        @DisplayName("buchen veraendert die Kasse, statt sie zu setzen")
        void buchen() {
            Spieler schmidt = new Spieler("Schmidt");

            schmidt.buchen(-50_000);
            assertEquals(150_000, schmidt.kasseInCent(),
                    "500,00 EUR Ausgabe: von 2000,00 bleiben 1500,00 EUR");

            schmidt.buchen(20_000);
            assertEquals(170_000, schmidt.kasseInCent(),
                    "200,00 EUR Einnahme kommen dazu. Wenn hier 20000 steht, setzt du die "
                            + "Kasse (=) statt zu buchen (+=).");
        }
    }

    @Nested
    @DisplayName("Spieler - Stufe 2")
    class SpielerKern {

        @Test
        @DisplayName("Zahlungsfaehigkeit")
        void zahlungsfaehigkeit() {
            Spieler schmidt = new Spieler("Schmidt");
            assertTrue(schmidt.istZahlungsfaehig(), "Mit Startkapital ist niemand pleite");

            schmidt.buchen(-200_000);
            assertTrue(schmidt.istZahlungsfaehig(),
                    "Genau 0,00 EUR ist knapp, aber noch zahlungsfaehig - wie in Einheit 3");

            schmidt.buchen(-1);
            assertFalse(schmidt.istZahlungsfaehig(), "Ein Cent im Minus reicht");
        }

        @Test
        @DisplayName("static: der Zaehler gehoert zur Klasse, nicht zum Objekt")
        void klassenzaehler() {
            // Absichtlich relativ geprueft: Der Zaehler lebt so lange wie das Programm und
            // wird von allen Tests geteilt. Auf einen festen Wert zu pruefen waere von der
            // Reihenfolge der Tests abhaengig - und damit unzuverlaessig. Genau das ist die
            // Schattenseite von static-Zustand.
            int vorher = Spieler.erzeugteSpieler();

            new Spieler("Erste");
            new Spieler("Zweite");

            assertEquals(vorher + 2, Spieler.erzeugteSpieler(),
                    "Nach zwei neuen Spielern muss der Zaehler um zwei hoeher stehen. "
                            + "Kommt hier immer 0 heraus, wird im Konstruktor nicht "
                            + "hochgezaehlt; kommt vorher+1 heraus, hast du den Zaehler "
                            + "vielleicht als Objektattribut ohne static angelegt.");
        }

        @Test
        @DisplayName("toString beschreibt den Spieler lesbar")
        void spielerAlsText() {
            Spieler schmidt = new Spieler("Schmidt");
            assertEquals("Schmidt (2000,00 EUR)", schmidt.toString(),
                    "Name, Leerzeichen, Betrag in Klammern");

            schmidt.buchen(-50_000);
            assertEquals("Schmidt (1500,00 EUR)", schmidt.toString(),
                    "toString liest die Attribute jedes Mal neu");
        }
    }

    @Nested
    @DisplayName("Der Referenz-Moment")
    class Referenzen {

        @Test
        @DisplayName("Zwei Variablen, EIN Objekt")
        void zweiVariablenEinObjekt() {
            Spieler schmidt = new Spieler("Schmidt");

            // Diese Zeile erzeugt KEINEN neuen Spieler. Sie gibt demselben Objekt nur
            // einen zweiten Namen - so wie ein Mensch einen Spitznamen hat.
            Spieler chef = schmidt;

            chef.buchen(-50_000);

            assertEquals(150_000, schmidt.kasseInCent(),
                    "Gebucht wurde auf 'chef' - und 'schmidt' ist trotzdem aermer geworden. "
                            + "Beide Variablen zeigen auf dasselbe Objekt. Wenn hier 200000 "
                            + "steht, hat dein buchen die Kasse gar nicht veraendert.");

            assertSame(schmidt, chef,
                    "assertSame prueft mit ==, also: dasselbe Objekt im Speicher. "
                            + "Hier muss es dasselbe sein.");
        }

        @Test
        @DisplayName("Gleicher Inhalt ist nicht dasselbe Objekt")
        void gleichheitUndIdentitaet() {
            Spieler einer = new Spieler("Schmidt");

            // Der Name wird absichtlich zur Laufzeit gebaut. Sonst wuerde sogar ein
            // falsches equals mit == zufaellig funktionieren, weil Java gleiche
            // Textkonstanten aus dem Quelltext zusammenlegt.
            Spieler anderer = new Spieler(wieVomBenutzerGetippt("Schmidt"));

            assertNotSame(einer, anderer,
                    "Zweimal new heisst zwei Objekte - auch wenn dasselbe drinsteht. "
                            + "Das ist der Unterschied, ueber den ihr in Einheit 3 bei den "
                            + "Texten gestolpert seid.");

            assertTrue(einer.equals(anderer),
                    "Inhaltlich sind sie gleich: derselbe Name. Genau das soll dein equals "
                            + "feststellen. Liefert es hier false, vergleichst du "
                            + "wahrscheinlich mit == statt mit equals.");

            anderer.buchen(-50_000);
            assertEquals(200_000, einer.kasseInCent(),
                    "Und weil es zwei Objekte sind, wirkt die Buchung nur bei einem");
        }

        @Test
        @DisplayName("equals darf mit allem umgehen, auch mit null")
        void equalsIstRobust() {
            Spieler schmidt = new Spieler("Schmidt");

            assertFalse(schmidt.equals(new Spieler("Yildiz")),
                    "Verschiedene Namen sind nicht gleich");

            assertFalse(schmidt.equals(null),
                    "Ein Vergleich mit null ist erlaubt und muss false liefern - er darf "
                            + "nicht abstuerzen. Das erledigt das instanceof im Muster, "
                            + "denn null instanceof Spieler ist immer false.");

            assertFalse(schmidt.equals("Schmidt"),
                    "Ein Spieler ist kein Text, auch wenn der Name passt. Auch hier darf "
                            + "nichts abstuerzen - kein ClassCastException.");

            assertTrue(schmidt.equals(schmidt),
                    "Mit sich selbst ist jedes Objekt gleich");
        }
    }

    @Nested
    @DisplayName("Sortiment - Objekte im Array")
    class SortimentTests {

        @Test
        @DisplayName("Ein leeres Sortiment liefert null statt abzustuerzen")
        void leeresSortiment() {
            Sortiment sortiment = new Sortiment(5);

            assertEquals(0, sortiment.anzahl(), "Am Anfang ist nichts drin");

            assertNull(sortiment.guenstigste(),
                    "Ohne Sorten gibt es keine guenstigste - dann ist null die Antwort. "
                            + "Wenn hier eine ArrayIndexOutOfBoundsException oder eine "
                            + "NullPointerException fliegt, greifst du auf sorten[0] zu, "
                            + "ohne die Anzahl zu pruefen.");

            assertNull(sortiment.findeNachName("Hausmischung"),
                    "Und gefunden wird auch nichts");

            // Gegenprobe: Sonst waere dieser Test auch mit einem unbearbeiteten Geruest
            // gruen - denn das liefert von sich aus 0 und null.
            sortiment.aufnehmen(new Kaffeesorte("Hausmischung", 2800));
            assertNotNull(sortiment.guenstigste(),
                    "Sobald eine Sorte aufgenommen wurde, darf guenstigste() nicht mehr "
                            + "null liefern");
        }

        @Test
        @DisplayName("Aufnehmen - bis es voll ist")
        void aufnehmen() {
            Sortiment sortiment = new Sortiment(2);

            assertTrue(sortiment.aufnehmen(new Kaffeesorte("Hausmischung", 2800)),
                    "Die erste Sorte passt");
            assertTrue(sortiment.aufnehmen(new Kaffeesorte("Bio-Hochland", 3650)),
                    "Die zweite auch");
            assertEquals(2, sortiment.anzahl(), "Jetzt sind zwei drin");

            assertFalse(sortiment.aufnehmen(new Kaffeesorte("Espresso", 3200)),
                    "Die dritte passt nicht mehr");
            assertEquals(2, sortiment.anzahl(),
                    "Und darf die Anzahl auch nicht erhoehen - sonst laeuft dein Array "
                            + "beim naechsten Durchlauf ueber");
        }

        @Test
        @DisplayName("null wird abgelehnt, bevor es Schaden anrichtet")
        void nullWirdAbgelehnt() {
            Sortiment sortiment = new Sortiment(5);

            assertFalse(sortiment.aufnehmen(null),
                    "null ist keine Kaffeesorte");

            assertEquals(0, sortiment.anzahl(),
                    "Ein null im Array wuerde spaeter beim Durchlaufen eine "
                            + "NullPointerException ausloesen - und zwar an einer ganz "
                            + "anderen Stelle als hier. Deshalb wird es sofort abgefangen.");

            // Gegenprobe: Eine echte Sorte muss dagegen angenommen werden.
            assertTrue(sortiment.aufnehmen(new Kaffeesorte("Hausmischung", 2800)),
                    "Abgelehnt wird nur null - eine echte Sorte kommt hinein");
            assertEquals(1, sortiment.anzahl(), "Und wird mitgezaehlt");
        }

        @Test
        @DisplayName("Die guenstigste Sorte finden")
        void guenstigsteFinden() {
            Sortiment sortiment = new Sortiment(5);
            Kaffeesorte haus = new Kaffeesorte("Hausmischung", 2800);
            Kaffeesorte bio = new Kaffeesorte("Bio-Hochland", 3650);
            Kaffeesorte billig = new Kaffeesorte("Standard", 2550);

            sortiment.aufnehmen(haus);
            sortiment.aufnehmen(bio);
            sortiment.aufnehmen(billig);

            assertSame(billig, sortiment.guenstigste(),
                    "Gesucht ist das Objekt selbst, nicht eine Kopie. assertSame prueft "
                            + "mit ==, es muss also genau das Objekt zurueckkommen, das "
                            + "aufgenommen wurde.");
        }

        @Test
        @DisplayName("Nach Namen suchen")
        void nachNamenSuchen() {
            Sortiment sortiment = new Sortiment(5);
            Kaffeesorte haus = new Kaffeesorte("Hausmischung", 2800);
            sortiment.aufnehmen(haus);
            sortiment.aufnehmen(new Kaffeesorte("Bio-Hochland", 3650));

            assertSame(haus, sortiment.findeNachName(wieVomBenutzerGetippt("Hausmischung")),
                    "Der Name passt, also kommt genau dieses Objekt zurueck. Der Suchtext "
                            + "wird hier absichtlich erst zur Laufzeit gebaut - wie eine "
                            + "echte Benutzereingabe. Wenn hier null ankommt, vergleichst du "
                            + "die Namen mit == statt mit equals.");

            assertNull(sortiment.findeNachName(wieVomBenutzerGetippt("Espresso")),
                    "Was es nicht gibt, wird nicht gefunden - dann null");

            assertNull(sortiment.findeNachName(wieVomBenutzerGetippt("hausmischung")),
                    "Gross- und Kleinschreibung muss genau stimmen");
        }

        @Test
        @DisplayName("toString beschreibt das Sortiment lesbar")
        void sortimentAlsText() {
            Sortiment sortiment = new Sortiment(5);
            sortiment.aufnehmen(new Kaffeesorte("Hausmischung", 2800));
            sortiment.aufnehmen(new Kaffeesorte("Bio-Hochland", 3650));

            assertEquals("Sortiment: 2 von 5 Sorten", sortiment.toString(),
                    "Achte auf Doppelpunkt und Leerzeichen");
        }
    }
}
