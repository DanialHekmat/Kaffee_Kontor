package de.dhbw.prog1.ue10;

import de.dhbw.prog1.kern.Kaffeesorte;

/**
 * Uebung 10, Teil 3 - <b>hier zahlt sich die ganze Sache aus.</b>
 *
 * <p>Die Methoden hier bekommen ein {@code Kaffeesorte[]}. Darin duerfen gewoehnliche
 * Kaffeesorten stehen, Bio-Sorten und Grosspackungen - alles gemischt, denn jede von ihnen
 * <i>ist</i> eine Kaffeesorte.
 *
 * <p>Und jetzt der Punkt: <b>In dieser Klasse steht kein einziges {@code if}, das nach der
 * Art der Sorte fragt.</b> Es wird schlicht {@code sorte.kostenProBecherInCent()} aufgerufen,
 * und jedes Objekt antwortet auf seine Weise. Java sucht zur Laufzeit die passende Fassung
 * heraus.
 *
 * <p>Das nennt man <b>Polymorphie</b> - Vielgestaltigkeit. Der praktische Nutzen: Wenn naechste
 * Woche eine vierte Sortenart dazukommt, aendert sich an dieser Klasse <b>nichts</b>. Sie
 * funktioniert mit Sorten, die es heute noch gar nicht gibt.
 *
 * <p>Vergleicht das mit dem, was ihr ohne Vererbung tun muesstet: eine Kette aus
 * {@code if (istBio) ... else if (istGrosspackung) ...}, und zwar in jeder einzelnen Methode,
 * die mit Sorten arbeitet. Bei jeder neuen Art muesstet ihr alle diese Ketten finden und
 * ergaenzen.
 */
public class Preisliste {

    /**
     * Welche Sorte ist je Becher am guenstigsten?
     *
     * <p><b>Je Becher</b> - nicht je Sack. Das ist ein Unterschied, der hier sichtbar wird:
     * Die Grosspackung hat mit Abstand den hoechsten Sackpreis und ist trotzdem die
     * guenstigste je Becher. Wer die Sackpreise vergleicht, bekommt die falsche Antwort.
     *
     * <p>Bei Gleichstand gewinnt die zuerst genannte Sorte. Bei einem leeren Array gibt es
     * keine - dann {@code null}.
     *
     * @param sorten zu vergleichende Sorten
     * @return guenstigste Sorte je Becher, oder null bei leerem Array
     */
    public static Kaffeesorte guenstigsteProBecher(Kaffeesorte[] sorten) {
        // TODO Stufe 2
        return null;
    }

    /**
     * Wie viele Sorten kosten je Becher <b>mehr</b> als die angegebene Grenze?
     *
     * <p>Echtes "mehr als": Wer genau auf der Grenze liegt, zaehlt nicht mit.
     *
     * @param sorten        zu pruefende Sorten
     * @param grenzeInCent  Grenzwert je Becher
     * @return Anzahl der Sorten oberhalb der Grenze
     */
    public static int anzahlUeber(Kaffeesorte[] sorten, int grenzeInCent) {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Die Preisliste als mehrzeiliger Text.
     *
     * <p>Eine Zeile je Sorte, getrennt durch {@code "\n"}, jeweils die Beschreibung der
     * Sorte. Bei einem leeren Array kommt ein leerer Text heraus.
     *
     * <p>Auch hier arbeitet die Polymorphie fuer dich: Du rufst schlicht {@code toString()}
     * auf - oder haengst die Sorte mit {@code +} an einen Text an, was dasselbe bewirkt -
     * und jede Sorte beschreibt sich selbst richtig. Eine gewoehnliche Sorte ohne Zusatz,
     * eine Bio-Sorte mit ihrem Aufschlag, eine Grosspackung mit ihrer Bechermenge.
     *
     * @param sorten aufzulistende Sorten
     * @return mehrzeilige Preisliste
     */
    public static String alsListe(Kaffeesorte[] sorten) {
        // TODO Stufe 2
        return "";
    }
}
