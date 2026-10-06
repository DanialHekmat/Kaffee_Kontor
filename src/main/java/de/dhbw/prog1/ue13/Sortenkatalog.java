package de.dhbw.prog1.ue13;

import de.dhbw.prog1.kern.Kaffeesorte;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Uebung 13, Teil 1 - dasselbe wie Uebung 9, nur ohne die Handarbeit.
 *
 * <p>Schlagt {@code ue09/Sortiment.java} noch einmal auf. Dort gab es ein Array, einen
 * Zaehler fuer die belegten Plaetze, eine Hoechstzahl, eine Pruefung auf Ueberlauf und die
 * staendige Sorge, nur bis {@code anzahl} und nicht bis {@code sorten.length} zu laufen.
 *
 * <p>Das alles faellt heute weg. Eine {@link List} verwaltet ihre Groesse selbst, waechst
 * bei Bedarf und kann nicht ueberlaufen. Vergleicht die beiden Klassen am Ende der Uebung -
 * das ist der beste Beleg dafuer, dass es sich lohnt, die mitgelieferten Werkzeuge zu kennen.
 *
 * <p><b>Die spitzen Klammern.</b> {@code List<Kaffeesorte>} heisst: eine Liste, in die
 * ausschliesslich Kaffeesorten passen. Das nennt man <b>Generics</b>. Der Nutzen zeigt sich
 * beim Herausholen: Was aus dieser Liste kommt, <i>ist</i> eine Kaffeesorte - ohne Nachfrage,
 * ohne Umwandlung. Und der Versuch, etwas anderes hineinzulegen, scheitert schon beim
 * Uebersetzen statt erst zur Laufzeit.
 *
 * <p>Generics selbst zu schreiben ist ein Thema fuers zweite Semester. Sie zu <i>benutzen</i>
 * ist einfach: Typ in die Klammern, fertig.
 */
public class Sortenkatalog {

    // ---------------------------------------------------------------------------------
    //  Links der Typ, rechts die Bauart. "List" ist eine Schnittstelle - genau wie
    //  Strategie in Einheit 11 -, "ArrayList" eine Klasse, die sie erfuellt.
    //
    //  Man schreibt links absichtlich die Schnittstelle: So laesst sich die Bauart spaeter
    //  austauschen, ohne dass der uebrige Code etwas merkt. Auch das ist der Gedanke aus
    //  Einheit 11, nur diesmal mit Javas eigenen Klassen.
    //
    //  Rechts genuegen die leeren Klammern <>: Java liest den Typ von links ab.
    // ---------------------------------------------------------------------------------

    private List<Kaffeesorte> sorten = new ArrayList<>();

    /**
     * Nimmt eine Sorte in den Katalog auf.
     *
     * <p>Kein Rueckgabewert und keine Hoechstzahl - die Liste waechst von selbst. Genau das
     * war in Uebung 9 die halbe Arbeit.
     *
     * <p>{@code null} wird abgelehnt, ohne etwas einzutragen. Der Grund ist derselbe wie
     * damals: Ein {@code null} in der Sammlung faellt erst spaeter auf, an einer ganz
     * anderen Stelle.
     *
     * <p>Die Methode heisst bei {@code List} {@code add}.
     *
     * @param sorte aufzunehmende Sorte, {@code null} wird ignoriert
     */
    public void aufnehmen(Kaffeesorte sorte) {
        // TODO Stufe 1
    }

    /**
     * Wie viele Sorten sind im Katalog?
     *
     * <p>Bei Sammlungen heisst das {@code size()} - nicht {@code length} wie beim Array
     * und nicht {@code length()} wie beim Text. Drei Schreibweisen fuer dieselbe Frage;
     * daran gewoehnt man sich.
     *
     * @return Anzahl der Sorten
     */
    public int anzahl() {
        // TODO Stufe 1
        return 0;
    }

    /**
     * Sucht eine Sorte anhand ihres Namens.
     *
     * <p>Wie in Uebung 9 - nur laeuft die Schleife jetzt bequem mit {@code for-each} ueber
     * die Liste, und es gibt keine Indexgrenzen mehr, die man verfehlen kann.
     *
     * <p>Namen wie immer mit {@code equals} vergleichen.
     *
     * @param gesuchterName gesuchter Sortenname
     * @return gefundene Sorte, oder null wenn es sie nicht gibt
     */
    public Kaffeesorte findeNachName(String gesuchterName) {
        // TODO Stufe 1
        return null;
    }

    /**
     * Alle Sorten, aufsteigend nach Kosten je Becher.
     *
     * <p>Der Katalog selbst bleibt dabei unveraendert - zurueckgegeben wird eine sortierte
     * <b>Kopie</b>. Das ist Absicht: Wer die innere Liste herausgibt, laesst jeden von
     * aussen daran herumaendern, und die Kapselung aus Einheit 9 waere umsonst gewesen.
     * Eine Kopie legt man mit {@code new ArrayList<>(sorten)} an.
     *
     * <p><b>Sortieren mit einem Comparator.</b> Java kann jede Liste sortieren - es muss nur
     * wissen, was "kleiner" bedeuten soll. Dafuer gibt es die Schnittstelle
     * {@link Comparator} mit genau einer Methode: Sie bekommt zwei Elemente und liefert eine
     * negative Zahl, wenn das erste vorn stehen soll, eine positive fuer umgekehrt, und 0 bei
     * Gleichstand.
     *
     * <p>Das ist genau das Muster aus Einheit 11: Java hat die Sortierlogik geschrieben,
     * lange bevor es Kaffeesorten gab - und kann sie trotzdem sortieren, weil ihr das
     * Vergleichskriterium nachliefert.
     *
     * <p>Ausgeschrieben sieht das so aus:
     *
     * <pre>
     *     kopie.sort(new Comparator&lt;Kaffeesorte&gt;() {
     *         &#64;Override
     *         public int compare(Kaffeesorte a, Kaffeesorte b) {
     *             return a.kostenProBecherInCent() - b.kostenProBecherInCent();
     *         }
     *     });
     * </pre>
     *
     * <p>Dieselbe Sache gibt es auch in Kurzform, und die wird ihr in der Praxis ueberall
     * sehen:
     *
     * <pre>
     *     kopie.sort(Comparator.comparingInt(Kaffeesorte::kostenProBecherInCent));
     * </pre>
     *
     * <p>Beide sind richtig. Nehmt, was ihr besser lesen koennt.
     *
     * <p><b>Ein Hinweis zur Subtraktion:</b> {@code a - b} als Vergleich funktioniert hier,
     * weil Becherpreise kleine Zahlen sind. Bei sehr grossen Werten kann die Differenz
     * ueberlaufen und das Vorzeichen kippen. Sauberer ist deshalb
     * {@code Integer.compare(a, b)}.
     *
     * @return neue, sortierte Liste; bei Gleichstand bleibt die Aufnahmereihenfolge
     */
    public List<Kaffeesorte> sortiertNachBecherpreis() {
        // TODO Stufe 2
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Sortenkatalog: " + anzahl() + " Sorten";
    }
}
