package de.dhbw.prog1.ue11;

import de.dhbw.prog1.kern.AbstrakteStrategie;
import de.dhbw.prog1.kern.Geld;
import de.dhbw.prog1.kern.Konsole;
import de.dhbw.prog1.kern.Spielstand;
import de.dhbw.prog1.kern.Strategie;
import de.dhbw.prog1.kern.Turnier;

/**
 * Uebung 11, Kuer - <b>euer Turnier-Bot.</b>
 *
 * <p>Hier gibt es keine Tests und keine Musterloesung. Diese Klasse ist euer Beitrag zum
 * Turnier in Einheit 15, und sie soll sich von allen anderen unterscheiden.
 *
 * <p><b>Das Ziel:</b> mehr in der Kasse als {@link SaisonStrategie}. Die schafft 8.698,40 EUR.
 *
 * <p><b>Die Regeln:</b>
 * <ul>
 *   <li>Entscheidet nur mit dem, was im {@link Spielstand} steht. In die Zukunft zu schauen
 *       ist im Turnier zwecklos - dort laufen andere Marktdaten als hier im Uebungsbetrieb,
 *       und die kennt niemand vorher.</li>
 *   <li>Der Bot muss ohne Eingaben auskommen und darf nichts ausgeben. Er wird dreissigmal
 *       aufgerufen und soll eine Zahl liefern, sonst nichts.</li>
 *   <li>Bankrott zaehlt. Wer in Runde 9 pleitegeht, landet hinter jedem, der durchhaelt.</li>
 * </ul>
 *
 * <p><b>Ideen, in aufsteigender Muehe:</b>
 * <ul>
 *   <li>Die Saisonstaffel verfeinern - sind 280 Cent in der Hochsaison wirklich das Optimum?
 *       Probiert 290 oder 300.</li>
 *   <li>Den Sackpreis einbeziehen. In Einheit 6 gab es Runden, die aus dem Saisonmuster
 *       fielen - dort war der Rohkaffee teuer. Teurer Einkauf spricht fuer einen hoeheren
 *       Verkaufspreis.</li>
 *   <li>Aus der Vorrunde lernen: {@link Spielstand#letzteNachfrageInBechern()} verraet, ob
 *       ihr zuletzt mehr haettet verkaufen koennen, als die Roestmaschine schafft. Wenn ja,
 *       war der Preis zu niedrig.</li>
 *   <li>Vorsichtig werden, wenn die Kasse knapp wird. Ein bankrotter Bot gewinnt nie.</li>
 * </ul>
 *
 * <p>Ausprobieren koennt ihr euren Bot jederzeit ueber die {@code main}-Methode unten -
 * sie laesst ihn gegen die beiden Vergleichsbots antreten.
 */
public class EigeneStrategie extends AbstrakteStrategie {

    public EigeneStrategie(String name) {
        super(name);
    }

    /**
     * Eure Entscheidung.
     *
     * <p>Der Startpunkt hier ist absichtlich schlecht: ein fester Preis, der die Lage
     * ignoriert. Damit landet ihr sicher hinter der Saisonstrategie.
     *
     * @param stand die Lage dieser Runde
     * @return Verkaufspreis je Becher in Cent
     */
    @Override
    public int verkaufspreisFuerRunde(Spielstand stand) {
        // TODO Kuer: hier entsteht euer Bot.
        //
        // begrenze(...) stammt aus AbstrakteStrategie und haelt den Preis im erlaubten
        // Bereich. Benutzt es, wenn ihr rechnet - sonst rutscht euch schnell ein
        // unsinniger Wert durch.
        return begrenze(300);
    }

    /**
     * Probelauf: euer Bot gegen die beiden Vergleichsbots.
     *
     * <p>Startet diese Methode, so oft ihr wollt. Sie ist eure Trainingsrunde.
     */
    public static void main(String[] args) {
        Strategie[] teilnehmer = {
                new FesterPreis("Fester Preis 2,50", 250),
                new SaisonStrategie("Saisonstrategie"),
                new EigeneStrategie("Unser Bot")
        };

        Konsole.zeigeUeberschrift("Probelauf");
        Konsole.zeige(Turnier.tabelle(teilnehmer));
        Konsole.zeige();
        Konsole.zeige("Zu schlagen: " + Geld.formatiere(
                Turnier.spiele(new SaisonStrategie("Saisonstrategie")).endkasseInCent()));
    }
}
