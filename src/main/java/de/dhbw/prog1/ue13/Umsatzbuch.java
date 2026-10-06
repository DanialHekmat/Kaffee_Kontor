package de.dhbw.prog1.ue13;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Uebung 13, Teil 2 - eine Sammlung, die etwas kann, das Arrays nicht koennen.
 *
 * <p>Bei {@link Sortenkatalog} war die Liste nur bequemer als ein Array. Eine {@link Map}
 * dagegen ist etwas grundsaetzlich anderes: Sie ordnet <b>Schluesseln Werte zu</b>.
 *
 * <p>Hier: Sortenname zu aufgelaufenem Umsatz. Mit Arrays muesstet ihr zwei davon parallel
 * fuehren - eines mit Namen, eines mit Betraegen - und beim Buchen erst den Namen suchen,
 * um den passenden Index zu finden. Genau diese Suche uebernimmt die Map, und zwar
 * unabhaengig davon, wie viele Eintraege drin sind.
 *
 * <p>{@code Map<String, Integer>} heisst: Schluessel sind Texte, Werte sind ganze Zahlen.
 *
 * <p><b>Warum {@code Integer} und nicht {@code int}?</b> In Sammlungen koennen nur Objekte
 * liegen, keine einfachen Zahlen. {@code Integer} ist die Objektfassung von {@code int}.
 * Java wandelt beim Hineinlegen und Herausholen automatisch um, sodass man es meist nicht
 * merkt - das nennt man <i>Autoboxing</i>. Ein Fallstrick bleibt: Ein fehlender Eintrag
 * liefert {@code null}, nicht 0. Wer das ungeprueft in ein {@code int} schreibt, bekommt
 * eine {@code NullPointerException}. Genau dagegen gibt es {@code getOrDefault}.
 */
public class Umsatzbuch {

    private Map<String, Integer> umsaetze = new HashMap<>();

    /**
     * Bucht einen Umsatz auf eine Sorte.
     *
     * <p>Mehrfaches Buchen auf dieselbe Sorte <b>summiert</b> sich - das Buch fuehrt keine
     * Einzelposten, sondern Staende. Das ist derselbe Unterschied wie zwischen
     * {@code setKasse} und {@code buchen} in Einheit 9.
     *
     * <p>Der uebliche Weg dafuer:
     *
     * <pre>
     *     int bisher = umsaetze.getOrDefault(sortenname, 0);
     *     umsaetze.put(sortenname, bisher + betragInCent);
     * </pre>
     *
     * <p>{@code getOrDefault} liefert den gespeicherten Wert - oder den Standardwert, wenn
     * der Schluessel noch nicht vorkommt. Damit braucht es keine Abfrage, ob es den Eintrag
     * schon gibt.
     *
     * <p>Ein {@code null} als Sortenname wird ignoriert.
     *
     * @param sortenname   Name der Sorte
     * @param betragInCent zu buchender Betrag, darf negativ sein (Gutschrift)
     */
    public void buche(String sortenname, int betragInCent) {
        // TODO Stufe 1
    }

    /**
     * Der aufgelaufene Umsatz einer Sorte.
     *
     * <p>Sorten ohne Buchung haben 0 Umsatz - nicht {@code null}, und schon gar nicht einen
     * Absturz.
     *
     * @param sortenname Name der Sorte
     * @return Umsatz in Cent, 0 wenn nichts gebucht wurde
     */
    public int umsatzFuer(String sortenname) {
        // TODO Stufe 1
        return 0;
    }

    /**
     * Alle Sorten, auf die gebucht wurde.
     *
     * <p>{@code map.keySet()} liefert die Schluessel als {@link Set} - die dritte grosse
     * Sammlungsart. Ein Set ist eine Menge: <b>jedes Element genau einmal</b>, und ohne
     * festgelegte Reihenfolge.
     *
     * <p>Dass hier ein Set herauskommt, ist kein Zufall: Ein Schluessel kann in einer Map
     * nur einmal vorkommen. Die Bauart passt zur Sache.
     *
     * <p><b>Verlasst euch nie auf die Reihenfolge eines {@code HashSet} oder einer
     * {@code HashMap}.</b> Sie ist nicht zufaellig, aber auch nicht die Einfuegereihenfolge -
     * sie ergibt sich aus den Hashwerten. Wer eine Reihenfolge braucht, nimmt
     * {@code LinkedHashMap} (Einfuegereihenfolge) oder {@code TreeMap} (sortiert).
     *
     * @return Menge der bebuchten Sortennamen
     */
    public Set<String> sorten() {
        // TODO Stufe 2
        return Set.of();
    }

    /**
     * Die Summe aller Umsaetze.
     *
     * <p>{@code map.values()} liefert alle Werte; darueber laesst sich mit {@code for-each}
     * laufen.
     *
     * @return Gesamtumsatz in Cent
     */
    public int gesamtumsatz() {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Welche Sorte hat den hoechsten Umsatz?
     *
     * <p>Bei leerem Buch gibt es keine - dann {@code null}.
     *
     * <p>Hier braucht es Schluessel und Wert gleichzeitig. Dafuer gibt es
     * {@code map.entrySet()}: eine Menge von Paaren, jedes mit {@code getKey()} und
     * {@code getValue()}.
     *
     * <pre>
     *     for (Map.Entry&lt;String, Integer&gt; eintrag : umsaetze.entrySet()) {
     *         ... eintrag.getKey() ... eintrag.getValue() ...
     *     }
     * </pre>
     *
     * <p>Bei Gleichstand darf eine beliebige der gleichauf liegenden Sorten herauskommen -
     * eine {@code HashMap} hat keine verlaessliche Reihenfolge, also waere jede andere
     * Zusage unhaltbar. Genau deshalb pruefen die Tests diesen Fall nicht auf einen
     * bestimmten Namen.
     *
     * @return Name der umsatzstaerksten Sorte, oder null bei leerem Buch
     */
    public String besteSorte() {
        // TODO Stufe 2
        return null;
    }

    @Override
    public String toString() {
        return "Umsatzbuch: " + umsaetze.size() + " Sorten";
    }
}
