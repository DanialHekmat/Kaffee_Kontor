package de.dhbw.prog1.ue08;

/**
 * Uebung 8, Teil 2 - das Rohkaffeelager.
 *
 * <p><b>Diese Klasse zeigt, wofuer es Objekte ueberhaupt gibt.</b> Eine Kaffeesorte war noch
 * ein besserer Datensatz - Werte rein, Werte raus. Ein Lager dagegen <b>merkt sich etwas</b>:
 *
 * <pre>
 *     Lager lager = new Lager(12);
 *     lager.einlagern(5);
 *     lager.einlagern(3);
 *     System.out.println(lager.bestand());   // 8
 * </pre>
 *
 * <p>Niemand hat dem Lager beim zweiten Aufruf gesagt, dass schon 5 Saecke drin sind. Es
 * weiss es selbst. Genau das konnte eine statische Methode nie: Sie beginnt bei jedem Aufruf
 * bei null und vergisst alles, sobald sie fertig ist.
 *
 * <p>Und der zweite Punkt, der genauso wichtig ist: Zwei Lager sind zwei Lager. Was ihr in
 * das eine einlagert, taucht im anderen nicht auf.
 */
public class Lager {

    // ---------------------------------------------------------------------------------
    //  ATTRIBUTE
    //
    //  Die Kapazitaet ist vorgegeben. Ein zweites Attribut fehlt noch - naemlich das,
    //  was das Lager sich merken soll. Ueberleg dir, wie es heissen muss, und ergaenze es.
    // ---------------------------------------------------------------------------------

    private int kapazitaetInSaecken;

    // TODO Stufe 1: zweites Attribut ergaenzen

    /**
     * Erzeugt ein leeres Lager mit der angegebenen Kapazitaet.
     *
     * <p>Ein frisches Lager ist leer. Das musst du nicht ausdruecklich hinschreiben - Java
     * setzt Zahlenattribute automatisch auf 0. Hinschreiben darfst du es trotzdem, es macht
     * die Absicht deutlicher.
     *
     * @param kapazitaetInSaecken wie viele Saecke hineinpassen
     */
    public Lager(int kapazitaetInSaecken) {
        // TODO Stufe 1
    }

    /**
     * Wie viele Saecke liegen gerade im Lager?
     *
     * @return aktueller Bestand
     */
    public int bestand() {
        // TODO Stufe 1
        return 0;
    }

    /**
     * Wie viele Saecke passen noch hinein?
     *
     * @return freier Platz in Saecken
     */
    public int freierPlatz() {
        // TODO Stufe 1
        return 0;
    }

    /**
     * Ist das Lager voll?
     *
     * <p>Schreib {@code return ...;} mit einem Vergleich, nicht {@code if} mit
     * {@code true}/{@code false}.
     *
     * @return true, wenn kein Platz mehr frei ist
     */
    public boolean istVoll() {
        // TODO Stufe 2
        return false;
    }

    /**
     * Legt Saecke ins Lager, soweit Platz ist.
     *
     * <p>Passen nicht alle hinein, wird eingelagert, was geht - der Rest wird nicht
     * angenommen. Zurueckgegeben wird, wie viele Saecke <b>tatsaechlich</b> hineingegangen
     * sind.
     *
     * <pre>
     *     Lager lager = new Lager(12);
     *     lager.einlagern(5);    // liefert 5,  Bestand 5
     *     lager.einlagern(10);   // liefert 7,  Bestand 12  (nur 7 passten noch)
     *     lager.einlagern(1);    // liefert 0,  Bestand 12
     * </pre>
     *
     * <p>Dieses Muster - "sag mir, was wirklich passiert ist" - ist in der Praxis ueberall
     * anzutreffen. Eine Methode, die einfach stillschweigend etwas weglaesst, ist eine
     * Fehlerquelle.
     *
     * <p>Bei einer negativen Anzahl passiert nichts, und es kommt 0 zurueck. Ohne diese
     * Abfrage koennte man ueber {@code einlagern(-3)} heimlich Saecke verschwinden lassen.
     *
     * @param anzahl gewuenschte Anzahl Saecke
     * @return tatsaechlich eingelagerte Anzahl
     */
    public int einlagern(int anzahl) {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Nimmt Saecke aus dem Lager, soweit welche da sind.
     *
     * <p>Das Gegenstueck zu {@link #einlagern(int)}: Es wird entnommen, was vorhanden ist,
     * und zurueckgegeben, wie viele Saecke <b>tatsaechlich</b> herauskamen. Der Bestand darf
     * dabei niemals negativ werden.
     *
     * <p>Bei einer negativen Anzahl passiert nichts, und es kommt 0 zurueck.
     *
     * @param anzahl gewuenschte Anzahl Saecke
     * @return tatsaechlich entnommene Anzahl
     */
    public int entnehmen(int anzahl) {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Wie sich das Lager selbst beschreibt.
     *
     * <p>Genau in diesem Format:
     *
     * <pre>
     *     Lager: 5 von 12 Saecken
     * </pre>
     *
     * @return Beschreibung des Lagers
     */
    @Override
    public String toString() {
        // TODO Stufe 2
        return "";
    }
}
