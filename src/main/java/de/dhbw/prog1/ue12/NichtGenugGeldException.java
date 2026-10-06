package de.dhbw.prog1.ue12;

import de.dhbw.prog1.kern.Geld;

/**
 * Uebung 12, Teil 1 - eine eigene Ausnahme.
 *
 * <p>Wird geworfen, wenn von der Kasse mehr abgebucht werden soll, als darin ist.
 *
 * <p><b>Warum eine eigene Klasse und nicht einfach {@code false} zurueckgeben?</b> Weil ein
 * {@code false} nur sagt, <i>dass</i> es nicht ging - nicht warum, und um wie viel es fehlte.
 * Diese Ausnahme transportiert beides: eine verstaendliche Meldung und den Fehlbetrag als
 * Zahl, mit der der Aufrufer weiterrechnen kann.
 *
 * <p><b>{@code extends Exception} heisst: eine gepruefte Ausnahme</b> (englisch <i>checked</i>).
 * Java zwingt jeden Aufrufer, sich damit zu befassen - entweder mit {@code try/catch} oder
 * indem er sie selbst weiterreicht ({@code throws}). Vergisst er es, kompiliert sein Code nicht.
 *
 * <p>Die Alternative waere {@code extends RuntimeException} - eine <i>ungeprueft</i>e Ausnahme,
 * die niemand behandeln muss. Die Faustregel dazu:
 *
 * <ul>
 *   <li><b>Geprueft</b> fuer Lagen, mit denen ein aufmerksamer Aufrufer rechnen muss und auf
 *       die er sinnvoll reagieren kann. Zu wenig Geld in der Kasse ist so ein Fall - das
 *       passiert im Betrieb, und dann kauft man eben weniger ein.</li>
 *   <li><b>Ungeprueft</b> fuer Programmierfehler. Ein negativer Einzahlungsbetrag ist kein
 *       Betriebszustand, sondern ein Fehler im Code. Den faengt man nicht ab, den behebt man.</li>
 * </ul>
 */
public class NichtGenugGeldException extends Exception {

    // TODO Stufe 1: ein Attribut fuer den Fehlbetrag

    /**
     * Erzeugt die Ausnahme.
     *
     * <p>Der {@code super}-Aufruf gibt die Meldung an die Oberklasse weiter - dort wird sie
     * gespeichert, und {@code getMessage()} liefert sie spaeter zurueck. Das ist dieselbe
     * Mechanik wie in Einheit 10: Eine Ausnahme ist eine ganz gewoehnliche Klasse, die von
     * einer anderen erbt.
     *
     * @param meldung          verstaendliche Beschreibung des Problems
     * @param fehlbetragInCent wie viel zu wenig in der Kasse war
     */
    public NichtGenugGeldException(String meldung, int fehlbetragInCent) {
        super(meldung);

        // TODO Stufe 1: Fehlbetrag merken
    }

    /**
     * Wie viel Geld gefehlt hat.
     *
     * @return Fehlbetrag in Cent, immer positiv
     */
    public int fehlbetragInCent() {
        // TODO Stufe 1
        return 0;
    }

    /**
     * Eine lesbare Beschreibung fuer die Ausgabe.
     *
     * <p>Genau in diesem Format:
     *
     * <pre>
     *     Es fehlen 12,50 EUR.
     * </pre>
     *
     * <p>Fuer den Betrag nimmst du {@link Geld#formatiere(int)}.
     *
     * @return Beschreibung des Fehlbetrags
     */
    public String fehlbetragAlsText() {
        // TODO Stufe 1
        return "";
    }
}
