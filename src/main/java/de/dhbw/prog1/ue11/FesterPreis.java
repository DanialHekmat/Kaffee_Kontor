package de.dhbw.prog1.ue11;

import de.dhbw.prog1.kern.Spielstand;
import de.dhbw.prog1.kern.Strategie;

/**
 * Uebung 11, Teil 1 - der einfachste denkbare Bot.
 *
 * <p>Er setzt in jeder Runde denselben Preis, egal was passiert. Damit ist er nicht besonders
 * klug - aber er ist ein vollwertiger Turnierteilnehmer, und darum geht es hier: Ihr baut zum
 * ersten Mal eine Klasse, die ein <b>Versprechen</b> einloest.
 *
 * <p>{@code implements Strategie} heisst: "Ich behaupte, ich kann alles, was in
 * {@link Strategie} steht." Der Compiler nimmt euch beim Wort. Lasst eine der beiden Methoden
 * weg, und er weist die Klasse zurueck - mit der Meldung, dass sie nicht abstrakt sein darf,
 * solange sie unfertig ist.
 *
 * <p>Beachtet den Unterschied zu {@code extends}: Ihr erbt hier <b>nichts</b>. Es gibt keine
 * fertigen Methoden zu uebernehmen, kein {@code super}, keine Attribute. Ein Interface gibt
 * nur vor, <i>was</i> zu koennen ist - das <i>Wie</i> ist vollstaendig eure Sache.
 */
public class FesterPreis implements Strategie {

    // TODO Stufe 1: zwei Attribute - der Name des Bots und der feste Preis

    /**
     * Erzeugt einen Bot, der immer denselben Preis nimmt.
     *
     * @param name        Anzeigename fuer die Turniertabelle
     * @param preisInCent der immer gleiche Verkaufspreis
     */
    public FesterPreis(String name, int preisInCent) {
        // TODO Stufe 1
    }

    /**
     * Der Anzeigename dieses Bots.
     *
     * <p>Diese Methode steht so im Interface. Ihr muesst sie schreiben, weil ein Interface
     * keinen fertigen Code mitbringt.
     */
    @Override
    public String name() {
        // TODO Stufe 1
        return "";
    }

    /**
     * Immer derselbe Preis - der Spielstand wird gar nicht angeschaut.
     *
     * <p>Das ist erlaubt. Ein Parameter, den man nicht braucht, muss nicht benutzt werden.
     *
     * @param stand die Lage, hier ohne Bedeutung
     * @return der feste Preis
     */
    @Override
    public int verkaufspreisFuerRunde(Spielstand stand) {
        // TODO Stufe 1
        return 0;
    }
}
