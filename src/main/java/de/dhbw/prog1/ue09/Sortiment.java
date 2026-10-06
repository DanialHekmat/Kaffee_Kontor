package de.dhbw.prog1.ue09;

import de.dhbw.prog1.kern.Kaffeesorte;

/**
 * Uebung 9, Teil 2 - ein Array voller Objekte.
 *
 * <p>In Einheit 6 standen Zahlen in Arrays. Jetzt stehen dort <b>Objekte</b> - genauer:
 * Verweise auf Objekte. Der Unterschied ist wichtiger, als er klingt.
 *
 * <p>Ein {@code int[]} mit fuenf Plaetzen enthaelt fuenf Nullen. Ein
 * {@code Kaffeesorte[]} mit fuenf Plaetzen enthaelt fuenfmal <b>{@code null}</b> - also
 * fuenfmal "hier zeigt nichts hin". Und wer auf einem {@code null} eine Methode aufruft,
 * bekommt eine {@code NullPointerException}: die haeufigste Fehlermeldung in ganz Java.
 *
 * <p>Deshalb merkt sich diese Klasse zusaetzlich, wie viele Plaetze wirklich belegt sind,
 * und laeuft nie weiter als bis dahin.
 */
public class Sortiment {

    // ---------------------------------------------------------------------------------
    //  ATTRIBUTE
    //
    //  Ein Array von Verweisen - und die Anzahl der belegten Plaetze. Das Array ist so
    //  gross wie die Hoechstzahl; belegt ist nur der vordere Teil.
    // ---------------------------------------------------------------------------------

    private Kaffeesorte[] sorten;
    private int anzahl;

    /**
     * Erzeugt ein leeres Sortiment.
     *
     * <p>Das Array wird hier mit voller Groesse angelegt, ist aber noch komplett unbelegt -
     * an jedem Platz steht {@code null}.
     *
     * @param maximalGroesse wie viele Sorten hoechstens hineinpassen
     */
    public Sortiment(int maximalGroesse) {
        // TODO Stufe 1
    }

    /**
     * Wie viele Sorten sind im Sortiment?
     *
     * @return Anzahl belegter Plaetze
     */
    public int anzahl() {
        // TODO Stufe 1
        return 0;
    }

    /**
     * Nimmt eine Sorte ins Sortiment auf.
     *
     * <p>Abgelehnt wird sie in zwei Faellen: wenn das Sortiment voll ist - und wenn
     * {@code null} uebergeben wird. Das zweite ist kein Spitzfindigkeit: Ein {@code null}
     * im Array wuerde spaeter beim Durchlaufen eine {@code NullPointerException} ausloesen,
     * und zwar an einer ganz anderen Stelle als hier. Fehler dort abfangen, wo sie
     * entstehen, spart viel Suchen.
     *
     * @param sorte aufzunehmende Sorte
     * @return true, wenn sie aufgenommen wurde
     */
    public boolean aufnehmen(Kaffeesorte sorte) {
        // TODO Stufe 2
        return false;
    }

    /**
     * Welche Sorte ist im Einkauf am guenstigsten?
     *
     * <p>Bei Gleichstand gewinnt die zuerst aufgenommene.
     *
     * <p><b>Bei leerem Sortiment gibt es keine - dann liefert die Methode {@code null}.</b>
     * Zurueckgegebene {@code null}-Werte sind heikel: Wer das Ergebnis benutzt, ohne es zu
     * pruefen, bekommt eine {@code NullPointerException}. Deshalb steht es hier ausdruecklich
     * in der Beschreibung. Eine Methode, die {@code null} liefern kann, muss das sagen -
     * sonst findet es der Aufrufer erst zur Laufzeit heraus.
     *
     * @return guenstigste Sorte, oder null bei leerem Sortiment
     */
    public Kaffeesorte guenstigste() {
        // TODO Stufe 2
        return null;
    }

    /**
     * Sucht eine Sorte anhand ihres Namens.
     *
     * <p>Gross- und Kleinschreibung muss genau stimmen. Vergleiche die Namen mit
     * {@code equals} - jetzt weisst du auch, warum: {@code ==} wuerde fragen, ob es
     * derselbe Text im Speicher ist, und nicht, ob dasselbe drinsteht.
     *
     * @param gesuchterName gesuchter Sortenname
     * @return gefundene Sorte, oder null, wenn es sie nicht gibt
     */
    public Kaffeesorte findeNachName(String gesuchterName) {
        // TODO Stufe 2
        return null;
    }

    /**
     * Wie sich das Sortiment selbst beschreibt.
     *
     * <p>Genau in diesem Format:
     *
     * <pre>
     *     Sortiment: 2 von 5 Sorten
     * </pre>
     *
     * @return Beschreibung des Sortiments
     */
    @Override
    public String toString() {
        // TODO Stufe 2
        return "";
    }
}
