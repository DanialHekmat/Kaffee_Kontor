package de.dhbw.prog1.ue13;

import java.util.Objects;

/**
 * Uebung 13, Teil 3 - der Nachtrag aus Einheit 9.
 *
 * <p>Damals stand in {@code Spieler} ein Hinweis: "Zu einem richtigen {@code equals} gehoert
 * immer auch {@code hashCode}. Warum, ergibt erst mit {@code HashMap} einen Sinn - das holen
 * wir in Einheit 13 nach." Jetzt ist es soweit.
 *
 * <p><b>Wie eine HashMap arbeitet.</b> Sie durchsucht nicht alle Eintraege. Sie rechnet aus
 * dem Schluessel eine Zahl - den <i>Hashwert</i> - und benutzt die als Hausnummer: Dort und
 * nur dort wird nachgesehen. Deshalb ist die Suche schnell, egal wie viele Eintraege es gibt.
 *
 * <p>Und deshalb gilt zwingend: <b>Zwei Objekte, die {@code equals} sind, MUESSEN denselben
 * Hashwert liefern.</b> Sonst landen sie an verschiedenen Hausnummern, und die Map findet das
 * eine nicht, obwohl das andere schon drinsteht - sie schaut gar nicht an der richtigen
 * Stelle nach.
 *
 * <p>Wer nur {@code equals} schreibt und {@code hashCode} vergisst, baut genau diesen Fehler
 * ein. Das Tueckische daran: Alles funktioniert weiter, solange man Listen benutzt. Erst mit
 * der ersten {@code HashMap} oder dem ersten {@code HashSet} geht es schief - und dann sucht
 * man an der falschen Stelle. Euer Testsatz fuehrt den Fehler einmal vor.
 *
 * <p>Ein Kunde gilt hier als derselbe, wenn die Kundennummer stimmt. Der Name kann sich
 * aendern, die Nummer nicht.
 */
public class Kunde {

    private int kundennummer;
    private String name;

    public Kunde(int kundennummer, String name) {
        // TODO Stufe 1
    }

    public int kundennummer() {
        // TODO Stufe 1
        return 0;
    }

    public String name() {
        // TODO Stufe 1
        return "";
    }

    /**
     * Zwei Kunden sind gleich, wenn die Kundennummer uebereinstimmt.
     *
     * <p>Dasselbe Muster wie in Einheit 9 - der Name spielt keine Rolle:
     *
     * <pre>
     *     if (this == anderes) return true;
     *     if (!(anderes instanceof Kunde andererKunde)) return false;
     *     return kundennummer == andererKunde.kundennummer;
     * </pre>
     *
     * <p>Die Kundennummer ist ein {@code int}, also wird hier mit {@code ==} verglichen -
     * das ist bei einfachen Zahlen richtig. Die Regel "Texte mit equals" gilt fuer Objekte.
     */
    @Override
    public boolean equals(Object anderes) {
        // TODO Stufe 2
        return false;
    }

    /**
     * Der Hashwert - und er muss zur Gleichheit passen.
     *
     * <p><b>Die Regel:</b> Genau die Felder, die in {@code equals} verglichen werden, gehen
     * in {@code hashCode} ein. Hier also die Kundennummer, und der Name nicht.
     *
     * <p>Von Hand muss man das nicht ausrechnen - {@link Objects#hash(Object...)} erledigt es:
     *
     * <pre>
     *     return Objects.hash(kundennummer);
     * </pre>
     *
     * <p>Zwei Dinge, die oft missverstanden werden:
     * <ul>
     *   <li>Gleiche Objekte muessen denselben Hashwert haben - <b>das ist Pflicht</b>.</li>
     *   <li>Verschiedene Objekte <i>duerfen</i> denselben Hashwert haben. Das heisst
     *       <i>Kollision</i>, ist erlaubt und wird von der Map abgefangen: An derselben
     *       Hausnummer vergleicht sie dann doch noch mit {@code equals}. Ein Hashwert ist
     *       eine Vorsortierung, kein Ausweis.</li>
     * </ul>
     *
     * <p>Daraus folgt auch: {@code return 42;} waere formal <b>korrekt</b> - alle gleichen
     * Objekte haetten denselben Wert. Nur landete dann alles an derselben Hausnummer, und die
     * Map muesste wieder alles durchsuchen. Richtig, aber nutzlos.
     */
    @Override
    public int hashCode() {
        // TODO Stufe 2
        return 0;
    }

    @Override
    public String toString() {
        return "Kunde " + kundennummer + " (" + name + ")";
    }
}
