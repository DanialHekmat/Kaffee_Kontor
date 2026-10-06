package de.dhbw.prog1.ue12;

import de.dhbw.prog1.kern.Geld;

/**
 * Uebung 12, Teil 2 - eine Kasse, die sich wehrt.
 *
 * <p>In Einheit 9 hatte der Spieler eine Methode {@code buchen(betrag)}, die alles
 * geschluckt hat - auch das, was gar nicht ging. Die Kasse hier ist strenger. Sie
 * unterscheidet drei Faelle, und diese Unterscheidung ist der Kern der Einheit:
 *
 * <ol>
 *   <li><b>Alles in Ordnung</b> - die Buchung geht durch.</li>
 *   <li><b>Ein Betriebszustand, mit dem zu rechnen war</b> - das Geld reicht nicht. Dafuer
 *       gibt es {@link NichtGenugGeldException}, eine gepruefte Ausnahme. Der Aufrufer
 *       <i>muss</i> sich damit befassen.</li>
 *   <li><b>Ein Programmierfehler</b> - jemand zahlt einen negativen Betrag ein. Dafuer gibt
 *       es {@link IllegalArgumentException}, eine ungepruefte Ausnahme. Die faengt man nicht
 *       ab, die behebt man.</li>
 * </ol>
 */
public class Kasse {

    private int bestandInCent;
    private int buchungsversuche;

    /**
     * Erzeugt eine Kasse mit Anfangsbestand.
     *
     * @param startbetragInCent Anfangsbestand, darf nicht negativ sein
     */
    public Kasse(int startbetragInCent) {
        // TODO Stufe 1: Bestand setzen, Zaehler auf 0
    }

    /**
     * Der aktuelle Bestand.
     *
     * @return Bestand in Cent
     */
    public int bestandInCent() {
        // TODO Stufe 1
        return 0;
    }

    /**
     * Wie viele Abbuchungsversuche es gab - erfolgreiche wie gescheiterte.
     *
     * @return Anzahl der Versuche
     */
    public int buchungsversuche() {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Zahlt Geld ein.
     *
     * <p>Ein negativer Betrag ist kein Betriebszustand, sondern ein Fehler im aufrufenden
     * Code - sonst koennte man ueber {@code einzahlen(-5000)} heimlich abbuchen. Deshalb
     * fliegt hier eine <b>ungeprueft</b>e {@link IllegalArgumentException}:
     *
     * <pre>
     *     throw new IllegalArgumentException("Einzahlung darf nicht negativ sein: " + betrag);
     * </pre>
     *
     * <p>Beachte das {@code throw} - mit einem "w" am Ende. Das wirft die Ausnahme wirklich.
     * Das {@code throws} ohne "w" in einem Methodenkopf ist etwas anderes: Es kuendigt nur an,
     * dass es passieren <i>kann</i>. Die beiden werden regelmaessig verwechselt.
     *
     * <p>Und: Schreib in die Meldung, <b>welcher</b> Wert das Problem war. "Ungueltiger Betrag"
     * hilft niemandem um drei Uhr nachts.
     *
     * @param betragInCent einzuzahlender Betrag, nicht negativ
     * @throws IllegalArgumentException wenn der Betrag negativ ist
     */
    public void einzahlen(int betragInCent) {
        // TODO Stufe 2
    }

    /**
     * Bucht Geld ab.
     *
     * <p>Reicht der Bestand nicht, wird eine {@link NichtGenugGeldException} geworfen -
     * und der Bestand bleibt <b>unveraendert</b>. Das ist wichtiger, als es klingt: Eine
     * gescheiterte Buchung darf keine halben Spuren hinterlassen. Pruefe deshalb, bevor du
     * abziehst.
     *
     * <p>Die Meldung soll den Fehlbetrag nennen, zum Beispiel
     * {@code "Kasse reicht nicht: es fehlen 12,50 EUR"}. Den Fehlbetrag gibst du
     * ausserdem als Zahl mit, damit der Aufrufer damit rechnen kann.
     *
     * <p><b>Und jetzt {@code finally}:</b> Der Zaehler {@link #buchungsversuche()} soll
     * <i>jeden</i> Versuch mitzaehlen - den erfolgreichen wie den gescheiterten. Genau dafuer
     * gibt es den {@code finally}-Block: Er laeuft in jedem Fall, auch wenn die Methode
     * mitten im Vorgang mit einer Ausnahme verlassen wird.
     *
     * <pre>
     *     try {
     *         ... pruefen, werfen, abziehen ...
     *     } finally {
     *         buchungsversuche++;
     *     }
     * </pre>
     *
     * <p>Ein {@code try} ohne {@code catch}, nur mit {@code finally} - das ist erlaubt und
     * hier genau richtig. Die Ausnahme soll ja weiterfliegen, aufgeraeumt werden muss
     * trotzdem.
     *
     * @param betragInCent abzubuchender Betrag, nicht negativ
     * @throws IllegalArgumentException   wenn der Betrag negativ ist
     * @throws NichtGenugGeldException    wenn der Bestand nicht reicht
     */
    public void abbuchen(int betragInCent) throws NichtGenugGeldException {
        // TODO Stufe 2
    }

    /**
     * Versucht abzubuchen und meldet, ob es geklappt hat.
     *
     * <p>Diese Methode ist die <b>Grenze</b> zwischen zwei Welten: Innen wird mit Ausnahmen
     * gearbeitet, nach aussen gibt es ein schlichtes Ja oder Nein. Solche Uebergaenge braucht
     * man staendig - etwa dort, wo ein Bot entscheidet und mit Ausnahmen nichts anfangen kann.
     *
     * <pre>
     *     try {
     *         abbuchen(betragInCent);
     *         return true;
     *     } catch (NichtGenugGeldException e) {
     *         return false;
     *     }
     * </pre>
     *
     * <p><b>Achtung, gefaehrliches Muster:</b> Einen {@code catch}-Block einfach leer zu
     * lassen, ist fast immer falsch - dann verschwindet ein Problem spurlos, und man sucht
     * spaeter stundenlang. Hier ist es in Ordnung, weil das {@code false} die Information
     * weitergibt. Verschluckt wird nichts.
     *
     * <p>Eine {@link IllegalArgumentException} bei negativem Betrag wird hier <b>nicht</b>
     * abgefangen. Sie ist ein Programmierfehler und soll sichtbar bleiben.
     *
     * @param betragInCent abzubuchender Betrag
     * @return true, wenn die Buchung geklappt hat
     */
    public boolean versucheAbbuchen(int betragInCent) {
        // TODO Stufe 2
        return false;
    }

    @Override
    public String toString() {
        return "Kasse: " + Geld.formatiere(bestandInCent);
    }
}
