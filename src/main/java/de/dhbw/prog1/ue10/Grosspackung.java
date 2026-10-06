package de.dhbw.prog1.ue10;

import de.dhbw.prog1.kern.Kaffeesorte;

/**
 * Uebung 10, Teil 2 - dieselbe Idee, ein anderer Weg.
 *
 * <p>Eine Grosspackung ist Gastronomieware: ein deutlich groesserer Sack, der entsprechend
 * mehr Becher hergibt. Der Einkaufspreis ist hoch - je Becher wird es trotzdem guenstig.
 *
 * <p>Bei {@link BioSorte} hast du auf dem Ergebnis der Oberklasse <i>weitergerechnet</i>.
 * Hier ersetzt du die Rechnung <b>vollstaendig</b>: Die 80 Becher je Sack aus den Spielregeln
 * gelten fuer diese Sorte einfach nicht. Beides sind gaengige Formen des Ueberschreibens -
 * ergaenzen und ersetzen.
 */
public class Grosspackung extends Kaffeesorte {

    private int becherProSack;

    /**
     * Erzeugt eine neue Grosspackung.
     *
     * @param name                       Name der Sorte
     * @param einkaufspreisProSackInCent Einkaufspreis je Grosspackung
     * @param becherProSack              wie viele Becher eine Packung hergibt
     */
    public Grosspackung(String name, int einkaufspreisProSackInCent, int becherProSack) {
        super(name, einkaufspreisProSackInCent);

        // TODO Stufe 2: die Bechermenge im Attribut merken
    }

    /**
     * Was kostet der Rohkaffee fuer einen Becher aus der Grosspackung?
     *
     * <p>Einkaufspreis geteilt durch die Bechermenge <b>dieser</b> Packung. Hier wird
     * {@code super} nicht gebraucht - die Rechnung der Oberklasse waere schlicht falsch.
     *
     * <p>Den Einkaufspreis holst du dir mit {@link Kaffeesorte#einkaufspreisProSackInCent()}.
     * Direkt auf das Attribut der Oberklasse kannst du nicht zugreifen: Es ist
     * {@code private}, und das gilt auch fuer Unterklassen. Vererbung heisst "kann alles, was
     * die Oberklasse kann" - nicht "darf in ihre Schubladen schauen".
     *
     * <p>Beispiel: 9000 Cent fuer 300 Becher ergeben 30 Cent je Becher.
     *
     * @return Rohstoffkosten je Becher in Cent
     */
    @Override
    public int kostenProBecherInCent() {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Beschreibung der Sorte, mit Hinweis auf die Packungsgroesse.
     *
     * <p>Genau in diesem Format:
     *
     * <pre>
     *     Gastro-Mischung: 90,00 EUR je Sack, 30 ct je Becher [300 Becher/Sack]
     * </pre>
     *
     * @return Beschreibung der Grosspackung
     */
    @Override
    public String toString() {
        // TODO Stufe 2
        return "";
    }
}
