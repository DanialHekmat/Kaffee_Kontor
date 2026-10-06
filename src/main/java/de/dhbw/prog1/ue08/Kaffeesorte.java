package de.dhbw.prog1.ue08;

import de.dhbw.prog1.kern.Geld;
import de.dhbw.prog1.kern.Spielregeln;

/**
 * Uebung 8, Teil 1 - eine Kaffeesorte als Objekt.
 *
 * <p>Bisher wart ihr es gewohnt, Daten und Rechnen getrennt zu halten: Die Zahlen lagen in
 * Variablen herum, und statische Methoden rechneten damit. Ab heute gehoert beides zusammen.
 *
 * <p>Eine Kaffeesorte <b>hat</b> einen Namen und einen Einkaufspreis - das sind ihre
 * <b>Attribute</b>. Und sie <b>kann</b> etwas: ausrechnen, was ein Becher an Rohstoff kostet,
 * sich mit einer anderen Sorte vergleichen, sich selbst beschreiben. Das sind ihre Methoden.
 * Beides steht ab jetzt in derselben Klasse.
 *
 * <p>Der Unterschied zu allem bisher: Von dieser Klasse kann es <b>viele Exemplare</b> geben.
 * Jedes hat seinen eigenen Namen und seinen eigenen Preis. Solche Exemplare heissen
 * <b>Objekte</b>, und erzeugt werden sie mit {@code new}.
 *
 * <pre>
 *     Kaffeesorte haus = new Kaffeesorte("Hausmischung", 2800);
 *     Kaffeesorte bio  = new Kaffeesorte("Bio-Hochland", 3650);
 *
 *     System.out.println(haus.kostenProBecherInCent());   // 35
 *     System.out.println(bio.kostenProBecherInCent());    // 45
 * </pre>
 *
 * <p>Zweimal dieselbe Methode, zwei verschiedene Ergebnisse - weil jedes Objekt seine eigenen
 * Werte mitbringt. Genau das konnten statische Methoden nicht.
 */
public class Kaffeesorte {

    // ---------------------------------------------------------------------------------
    //  ATTRIBUTE - was ein Objekt dieser Klasse ueber sich weiss.
    //
    //  Sie sind "private": Von aussen kommt niemand direkt heran. Was mit diesen Werten
    //  geschieht, entscheidet die Klasse selbst ueber ihre Methoden. Warum das eine gute
    //  Idee ist, sehen wir naechste Woche genauer.
    //
    //  Attribute werden ausserhalb jeder Methode deklariert, direkt in der Klasse. Damit
    //  gehoeren sie zum Objekt und leben so lange wie es - anders als lokale Variablen,
    //  die am Ende ihrer Methode verschwinden.
    // ---------------------------------------------------------------------------------

    private String name;
    private int einkaufspreisProSackInCent;

    /**
     * Erzeugt eine neue Kaffeesorte.
     *
     * <p>Das hier ist der <b>Konstruktor</b>. Er heisst genau wie die Klasse, hat keinen
     * Rueckgabetyp und wird beim {@code new} aufgerufen. Seine einzige Aufgabe: die Attribute
     * mit den uebergebenen Werten fuellen.
     *
     * <p><b>Und hier kommt {@code this} ins Spiel.</b> Der Parameter heisst {@code name} und
     * das Attribut heisst auch {@code name}. Innerhalb des Konstruktors ist mit {@code name}
     * der Parameter gemeint - er verdeckt das Attribut. Mit {@code this.name} sprichst du
     * ausdruecklich das Attribut <i>dieses</i> Objekts an. Die Zuweisung lautet also:
     *
     * <pre>
     *     this.name = name;
     * </pre>
     *
     * <p>Sprich sie als "das Namensattribut dieses Objekts bekommt den Wert des Parameters".
     * Wer das {@code this} vergisst, weist den Parameter sich selbst zu - das aendert nichts,
     * und das Attribut bleibt leer. Der Compiler beschwert sich dabei nicht.
     *
     * @param name                       Name der Sorte, z. B. "Hausmischung"
     * @param einkaufspreisProSackInCent Einkaufspreis je Sack in Cent
     */
    public Kaffeesorte(String name, int einkaufspreisProSackInCent) {
        // TODO Stufe 1: beide Attribute setzen
    }

    /**
     * Der Name dieser Sorte.
     *
     * @return Name
     */
    public String name() {
        // TODO Stufe 1
        return "";
    }

    /**
     * Was kostet der Rohkaffee fuer einen einzelnen Becher dieser Sorte?
     *
     * <p>Einkaufspreis je Sack geteilt durch {@link Spielregeln#BECHER_PRO_SACK} - wie immer
     * ganzzahlig, es wird also abgeschnitten.
     *
     * <p>Beachte: Diese Methode braucht <b>keinen Parameter</b>. Sie holt sich den Preis aus
     * dem Attribut des Objekts, auf dem sie aufgerufen wurde. Das ist der ganze Unterschied
     * zur statischen Fassung aus Uebung 2, wo der Preis noch uebergeben werden musste.
     *
     * @return Rohstoffkosten je Becher in Cent
     */
    public int kostenProBecherInCent() {
        // TODO Stufe 1
        return 0;
    }

    /**
     * Was bleibt bei diesem Verkaufspreis je Becher haengen?
     *
     * <p>Verkaufspreis minus Rohstoffkosten. Ruf dafuer die Methode oben auf, statt die
     * Rechnung noch einmal hinzuschreiben.
     *
     * @param verkaufspreisInCent Verkaufspreis je Becher
     * @return Deckungsbeitrag je Becher in Cent
     */
    public int deckungsbeitragInCent(int verkaufspreisInCent) {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Ist diese Sorte im Einkauf teurer als eine andere?
     *
     * <p>Interessant an dieser Methode ist der Parameter: Sie bekommt ein Objekt <b>derselben
     * Klasse</b> uebergeben. Innerhalb der Methode hast du damit zwei Sorten zur Hand -
     * {@code this} (die, auf der die Methode aufgerufen wurde) und {@code andere}.
     *
     * <p>Auf die privaten Attribute von {@code andere} darfst du dabei direkt zugreifen:
     * {@code private} gilt je Klasse, nicht je Objekt. Innerhalb von {@code Kaffeesorte}
     * kennst du die Innereien jeder Kaffeesorte.
     *
     * <p>Bei gleichem Preis ist die Antwort {@code false} - gleich teuer ist nicht teurer.
     *
     * @param andere die Vergleichssorte
     * @return true, wenn diese Sorte teurer ist
     */
    public boolean istTeurerAls(Kaffeesorte andere) {
        // TODO Stufe 2
        return false;
    }

    /**
     * Wie sich diese Sorte selbst beschreibt.
     *
     * <p>Genau in diesem Format:
     *
     * <pre>
     *     Hausmischung: 28,00 EUR je Sack, 35 ct je Becher
     * </pre>
     *
     * <p>Fuer den Sackpreis nimmst du {@link Geld#formatiere(int)}, fuer die Becherkosten
     * die Zahl und die Einheit " ct".
     *
     * <p><b>Warum diese Methode ausgerechnet {@code toString} heisst:</b> Jede Klasse in Java
     * hat diese Methode, auch wenn niemand sie hinschreibt - dann liefert sie etwas
     * Unleserliches wie {@code Kaffeesorte@6d06d69c}. Java ruft sie ueberall dort automatisch
     * auf, wo ein Objekt als Text gebraucht wird: bei {@code System.out.println(sorte)}, bei
     * {@code "Sorte: " + sorte} und - besonders nuetzlich - im Debugger. Wer sie sinnvoll
     * ausfuellt, bekommt das geschenkt.
     *
     * <p>Das {@code @Override} darueber ist kein Muss, aber sinnvoll: Es sagt dem Compiler,
     * dass du eine vorhandene Methode ersetzen willst. Vertippst du dich im Namen, bekommst du
     * eine Fehlermeldung statt einer Methode, die nie aufgerufen wird.
     *
     * @return Beschreibung der Sorte
     */
    @Override
    public String toString() {
        // TODO Stufe 2
        return "";
    }
}
