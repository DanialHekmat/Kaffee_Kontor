package de.dhbw.prog1.ue11;

import de.dhbw.prog1.kern.AbstrakteStrategie;
import de.dhbw.prog1.kern.Spielstand;

/**
 * Uebung 11, Teil 2 - ein Bot, der die Saison liest.
 *
 * <p>In Einheit 6 habt ihr die Ergebnistabelle ausgewertet und dabei ein Muster gefunden:
 * <b>Je staerker die Saison, desto hoeher der guenstigste Preis.</b> Der Grund war die
 * Roestkapazitaet - wenn die Menge nicht mehr wachsen kann, ist die Marge der einzige
 * verbliebene Hebel.
 *
 * <p>Dieses Muster giesst ihr jetzt in Code. Das ist der Bot, gegen den euer eigener in der
 * Kuer antreten muss.
 *
 * <p><b>Neu gegenueber Teil 1:</b> Diese Klasse erbt von {@link AbstrakteStrategie} statt das
 * Interface direkt zu erfuellen. Dadurch bekommt ihr {@code name()} geschenkt und koennt
 * {@code begrenze(...)} benutzen. Ihr muesst nur noch die eine Entscheidung treffen, die
 * wirklich eure ist.
 */
public class SaisonStrategie extends AbstrakteStrategie {

    /**
     * Erzeugt den Saison-Bot.
     *
     * <p>Der {@code super}-Aufruf reicht den Namen an die Oberklasse durch - dort wird er
     * gespeichert, und {@code name()} ist damit erledigt. Genau das kann ein Interface
     * nicht leisten.
     *
     * @param name Anzeigename fuer die Turniertabelle
     */
    public SaisonStrategie(String name) {
        super(name);
    }

    /**
     * Der Preis richtet sich nach der Nachfragelage.
     *
     * <p>Die Staffel, jeweils einschliesslich der genannten Grenze:
     * <ul>
     *   <li>ab 116 Prozent (Hochsaison): 280 Cent</li>
     *   <li>ab 104 Prozent (gute Saison): 260 Cent</li>
     *   <li>ab 96 Prozent (normal): 240 Cent</li>
     *   <li>darunter (Flaute): 220 Cent</li>
     * </ul>
     *
     * <p>Den Saisonwert holt ihr euch mit {@link Spielstand#saisonProzent()}.
     *
     * <p>Achtet auf die Reihenfolge der Zweige - das ist dieselbe Falle wie bei der
     * Rabattstaffel im Selbsttest. Wer die 96er-Abfrage nach oben stellt, gibt auch bei
     * 118 Prozent nur 240 Cent aus.
     *
     * @param stand die Lage dieser Runde
     * @return Verkaufspreis je Becher in Cent
     */
    @Override
    public int verkaufspreisFuerRunde(Spielstand stand) {
        // TODO Stufe 2
        return 0;
    }
}
