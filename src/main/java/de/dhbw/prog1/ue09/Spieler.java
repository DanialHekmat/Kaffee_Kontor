package de.dhbw.prog1.ue09;

import de.dhbw.prog1.kern.Geld;
import de.dhbw.prog1.kern.Spielregeln;

/**
 * Uebung 9, Teil 1 - Kapselung, static und der Referenz-Moment.
 *
 * <p>Ein Spieler ist eine Roesterei im Wettbewerb: Er hat einen Namen und eine Kasse.
 * Klingt nach Einheit 8 - aber diesmal geht es um drei Fragen, die dort offengeblieben sind.
 *
 * <p><b>Erstens: Warum sind die Attribute eigentlich {@code private}?</b> Waere
 * {@code kasseInCent} oeffentlich, koennte jeder von aussen {@code spieler.kasseInCent =
 * 999999999} schreiben. Die Kasse waere kein Kassenstand mehr, sondern ein Wunschzettel.
 * Kapselung heisst: Der Zustand eines Objekts aendert sich nur ueber Wege, die das Objekt
 * selbst anbietet - und diese Wege koennen pruefen, mitzaehlen und protokollieren.
 *
 * <p><b>Zweitens: Was gehoert zum Objekt, was zur Klasse?</b> Der Name gehoert zum Spieler.
 * Die Frage "wie viele Spieler wurden bisher erzeugt?" gehoert zu keinem einzelnen Spieler -
 * sie gehoert zur Klasse. Dafuer gibt es {@code static}.
 *
 * <p><b>Und drittens, die wichtigste:</b> Was passiert, wenn zwei Variablen auf dasselbe
 * Objekt zeigen? Diese Frage hat schon manchen Feierabend gekostet.
 */
public class Spieler {

    // ---------------------------------------------------------------------------------
    //  OBJEKTATTRIBUTE - jedes Objekt hat seine eigenen.
    // ---------------------------------------------------------------------------------

    private String name;
    private int kasseInCent;

    // ---------------------------------------------------------------------------------
    //  KLASSENATTRIBUT - das gibt es genau EINMAL, nicht je Objekt.
    //
    //  In Einheit 8 war "static" bei einem Attribut noch ein Fehler: Zwei Lager teilten
    //  sich einen Bestand. Hier ist es genau richtig, denn die Zahl gehoert wirklich
    //  niemandem einzelnen. Der Unterschied ist nicht die Technik, sondern die Frage:
    //  Gehoert dieser Wert zu EINEM Objekt oder zu ALLEN zusammen?
    // ---------------------------------------------------------------------------------

    private static int erzeugteSpieler = 0;

    /**
     * Erzeugt einen neuen Spieler mit dem Startkapital aus den Spielregeln.
     *
     * <p>Der Konstruktor macht hier mehr als nur Attribute fuellen: Er zaehlt auch den
     * Klassenzaehler hoch. Genau deshalb ist Kapselung nuetzlich - an diesem einen Weg ins
     * Objekt hinein kommt niemand vorbei, also stimmt die Zaehlung immer.
     *
     * @param name Name des Spielers
     */
    public Spieler(String name) {
        // TODO Stufe 1: Name setzen, Kasse auf Spielregeln.STARTKAPITAL_CENT,
        //               und erzeugteSpieler um eins erhoehen
    }

    /**
     * Der Name dieses Spielers.
     *
     * @return Name
     */
    public String name() {
        // TODO Stufe 1
        return "";
    }

    /**
     * Der aktuelle Kassenstand.
     *
     * <p>Eine reine Abfragemethode - sie liefert den Wert und aendert nichts.
     *
     * @return Kassenstand in Cent
     */
    public int kasseInCent() {
        // TODO Stufe 1
        return 0;
    }

    /**
     * Bucht einen Betrag auf die Kasse. Negative Betraege sind Ausgaben.
     *
     * <p><b>Beachte, was es hier NICHT gibt: kein {@code setKasse}.</b> Das ist Absicht.
     *
     * <p>Ein Setter sagt "schreib irgendeinen Wert hinein" und ist damit kaum besser als ein
     * oeffentliches Attribut. {@code buchen} dagegen beschreibt einen Vorgang aus der
     * Wirklichkeit: Es kommt Geld dazu oder es geht welches ab. Der Kassenstand ergibt sich
     * daraus - er wird nicht gesetzt.
     *
     * <p>Das ist die Faustregel fuer Setter: Frag dich, ob es den Vorgang "diesen Wert
     * ersetzen" in der Wirklichkeit ueberhaupt gibt. Bei einer Lieferadresse: ja. Bei einem
     * Kassenstand: nein - da gibt es Einnahmen und Ausgaben.
     *
     * @param betragInCent positiver Betrag fuer Einnahmen, negativer fuer Ausgaben
     */
    public void buchen(int betragInCent) {
        // TODO Stufe 1
    }

    /**
     * Ist der Spieler noch zahlungsfaehig?
     *
     * <p>Zahlungsfaehig ist, wer nicht unter {@link Spielregeln#BANKROTT_GRENZE_CENT} liegt.
     *
     * @return true, wenn die Kasse nicht negativ ist
     */
    public boolean istZahlungsfaehig() {
        // TODO Stufe 2
        return false;
    }

    /**
     * Wie viele Spieler wurden seit Programmstart erzeugt?
     *
     * <p>Diese Methode ist {@code static}, weil die Frage zu keinem einzelnen Spieler
     * gehoert. Aufgerufen wird sie deshalb auch nicht auf einem Objekt, sondern auf der
     * Klasse: {@code Spieler.erzeugteSpieler()}.
     *
     * <p><b>Ein ehrlicher Hinweis:</b> Solche Zaehler sind mit Vorsicht zu geniessen. Der
     * Wert lebt so lange wie das Programm und wird von allem geteilt, was mitspielt - auch
     * von den Tests untereinander. Deshalb prueft der Test nicht "es sind genau drei",
     * sondern "es sind zwei mehr als vorher". Zustand, den sich alle teilen, macht Programme
     * schwer durchschaubar; benutze {@code static} bei Attributen sparsam.
     *
     * @return Anzahl bisher erzeugter Spieler
     */
    public static int erzeugteSpieler() {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Sind zwei Spieler inhaltlich gleich?
     *
     * <p><b>Hier loest sich ein Raetsel aus Einheit 3 auf.</b> Damals lautete die Regel:
     * Texte niemals mit {@code ==} vergleichen, immer mit {@code equals}. Jetzt koennt ihr
     * verstehen, warum.
     *
     * <p>Eine Variable enthaelt bei Objekten nicht das Objekt selbst, sondern eine
     * <b>Referenz</b> - einen Verweis darauf. {@code ==} vergleicht diese Verweise: "Zeigen
     * beide auf dasselbe Objekt?" {@code equals} dagegen vergleicht, was drinsteht - aber nur,
     * wenn eine Klasse das auch festlegt. Tut sie es nicht, macht {@code equals} dasselbe wie
     * {@code ==}, und der Unterschied faellt niemandem auf, bis es zu spaet ist.
     *
     * <p>Zwei Spieler gelten hier als gleich, wenn sie denselben Namen tragen.
     *
     * <p>Der Rumpf folgt einem festen Muster, das du dir merken kannst:
     *
     * <pre>
     *     if (this == anderes) return true;                       // dasselbe Objekt
     *     if (!(anderes instanceof Spieler andererSpieler)) {      // falscher Typ oder null
     *         return false;
     *     }
     *     return name.equals(andererSpieler.name);                // Inhalte vergleichen
     * </pre>
     *
     * <p>Die zweite Zeile faengt gleich zwei Faelle ab: einen Vergleich mit etwas ganz
     * anderem - und {@code null}. Denn {@code null instanceof Spieler} ist immer
     * {@code false}. Ohne diese Zeile wuerde deine Methode bei {@code spieler.equals(null)}
     * abstuerzen, und ein Test prueft das.
     *
     * <p><b>Was hier fehlt:</b> Zu einem richtigen {@code equals} gehoert immer auch
     * {@code hashCode}. Warum, ergibt erst mit {@code HashMap} einen Sinn - das holen wir in
     * Einheit 13 nach.
     *
     * @param anderes beliebiges anderes Objekt
     * @return true, wenn es ein Spieler mit demselben Namen ist
     */
    @Override
    public boolean equals(Object anderes) {
        // TODO Stufe 2
        return false;
    }

    /**
     * Wie sich der Spieler selbst beschreibt.
     *
     * <p>Genau in diesem Format:
     *
     * <pre>
     *     Schmidt (2000,00 EUR)
     * </pre>
     *
     * @return Beschreibung des Spielers
     */
    @Override
    public String toString() {
        // TODO Stufe 2
        return "";
    }
}
