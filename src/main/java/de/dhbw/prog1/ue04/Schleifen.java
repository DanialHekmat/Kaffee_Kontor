package de.dhbw.prog1.ue04;

import de.dhbw.prog1.kern.Konsole;
import de.dhbw.prog1.kern.Markt;
import de.dhbw.prog1.kern.Spielregeln;
import de.dhbw.prog1.ue02.Runde;
import de.dhbw.prog1.ue03.Entscheidung;

/**
 * Uebung 4 - Schleifen.
 *
 * <p>Bisher hat dein Programm eine einzelne Runde gerechnet. Jetzt laeuft das ganze Spiel:
 * 30 Runden am Stueck. Und noch etwas Groesseres passiert - der Rechner uebernimmt die Arbeit,
 * die ihr in Uebung 2 von Hand gemacht habt. Statt sechs Preise auszuprobieren, probiert
 * {@link #besterVerkaufspreis(int, int)} einundvierzig Preise durch, und zwar in Millisekunden.
 *
 * <p>Genau dafuer gibt es Schleifen: Nicht um Tipparbeit zu sparen, sondern um Dinge zu tun,
 * die von Hand nicht mehr gehen.
 *
 * <p>Voraussetzung: Uebung 2 und Uebung 3 muessen geloest sein - diese Uebung baut darauf auf.
 */
public class Schleifen {

    // =================================================================================
    //  STUFE 1 - BASIS
    // =================================================================================

    /**
     * Was kosten die Saecke in einem Rundenbereich zusammengerechnet?
     *
     * <p>Addiert die Marktpreise ({@link Markt#preisProSackInCent(int)}) von {@code vonRunde}
     * bis {@code bisRunde}. <b>Beide Grenzen zaehlen mit.</b> Der Bereich von Runde 1 bis
     * Runde 3 umfasst also drei Runden, nicht zwei.
     *
     * <p>Genau hier passiert der haeufigste Schleifenfehler ueberhaupt: {@code <} statt
     * {@code <=} in der Abbruchbedingung - und schon fehlt der letzte Wert. Solche Fehler
     * heissen "Off-by-one". Wenn dein Ergebnis um genau einen Summanden danebenliegt, weisst
     * du sofort, wo du suchen musst.
     *
     * @param vonRunde erste Runde, zaehlt mit
     * @param bisRunde letzte Runde, zaehlt ebenfalls mit
     * @return Summe der Sackpreise in Cent
     */
    public static int summeMarktpreise(int vonRunde, int bisRunde) {
        int summe = 0;
        int runde = vonRunde;
        while (runde <= bisRunde){
            //System.out.println(runde);
            summe = summe + Markt.preisProSackInCent(runde);
            //System.out.println(summe);
            runde++;
        }
        return summe;
    }

    /**
     * Was kostet ein Sack in der guenstigsten Runde des Bereichs?
     *
     * <p><b>Achtung, Startwert.</b> Wer die Merkvariable mit 0 beginnen laesst, bekommt am
     * Ende immer 0 heraus - denn kein Preis ist kleiner als null, also wird die 0 nie ersetzt.
     * Es gibt zwei saubere Loesungen: Beginne mit dem Preis der ersten Runde, oder mit
     * {@link Integer#MAX_VALUE}. Ueberleg dir, welche dir besser gefaellt und warum.
     *
     * @param vonRunde erste Runde, zaehlt mit
     * @param bisRunde letzte Runde, zaehlt mit
     * @return niedrigster Sackpreis im Bereich, in Cent
     */
    public static int guenstigsterSackpreis(int vonRunde, int bisRunde) {
        // TODO Stufe 1
        return 0;
    }


    // =================================================================================
    //  STUFE 2 - KERN
    // =================================================================================

    /**
     * In welcher Runde ist der Kaffee am billigsten?
     *
     * <p>Wie {@link #guenstigsterSackpreis(int, int)}, aber gesucht ist diesmal nicht der
     * Preis, sondern die <b>Rundennummer</b>. Du musst dir also beides merken: den bisher
     * besten Preis und die Runde, in der er auftrat.
     *
     * <p>Bei Gleichstand gewinnt die frueheste Runde.
     *
     * @param vonRunde erste Runde, zaehlt mit
     * @param bisRunde letzte Runde, zaehlt mit
     * @return Nummer der guenstigsten Runde
     */
    public static int guenstigsteRunde(int vonRunde, int bisRunde) {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Nach wie vielen Runden Lagerung ist ein Preisvorteil aufgezehrt?
     *
     * <p>Das ist die Frage aus Uebung 3, jetzt ausgerechnet statt geschaetzt. Wer guenstig
     * einkauft und die Saecke liegen laesst, zahlt je Sack und Runde
     * {@link Spielregeln#LAGERKOSTEN_PRO_SACK_CENT} Lagergebuehr. Irgendwann ist der
     * Preisvorteil damit vollstaendig aufgefressen.
     *
     * <p>Gesucht ist die <b>kleinste</b> Rundenzahl, ab der die Lagerkosten den Vorteil
     * erreichen oder uebersteigen. Ist der "guenstige" Preis gar nicht guenstiger, gibt es
     * nichts aufzuzehren - dann ist das Ergebnis 0.
     *
     * <p>Das ist ein Fall fuer {@code while}: Du weisst vorher nicht, wie viele Durchlaeufe
     * noetig sind. Genau darin unterscheidet sich {@code while} von {@code for} - nimm
     * {@code for}, wenn die Anzahl feststeht, und {@code while}, wenn sie sich erst ergibt.
     *
     * @param guenstigerPreisInCent niedrigerer Einkaufspreis je Sack
     * @param teurerPreisInCent     hoeherer Einkaufspreis je Sack
     * @return Anzahl Runden, niemals negativ
     */
    public static int rundenBisPreisvorteilAufgezehrt(int guenstigerPreisInCent,
                                                      int teurerPreisInCent) {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Wie veraendert sich die Kasse in dieser Runde?
     *
     * <p>Hier wird das Spiel zum ersten Mal vollstaendig durchgerechnet. Die Roesterei
     * verhaelt sich dabei vernuenftig: Sie kauft genau so viele Saecke, wie sie zum Bedienen
     * der Nachfrage braucht - nicht mehr, denn uebrige Becher sind verlorenes Geld.
     *
     * <p>Der Ablauf:
     * <ol>
     *   <li>Marktpreis und Nachfrage beim gewaehlten Verkaufspreis besorgen ({@link Markt}).</li>
     *   <li>Ausrechnen, wie viele Saecke die Nachfrage deckt - <b>aufgerundet</b>, denn ein
     *       halber Sack hilft niemandem. Der uebliche Trick dafuer:
     *       {@code (nachfrage + BECHER_PRO_SACK - 1) / BECHER_PRO_SACK}. Rechne einmal von
     *       Hand nach, warum das funktioniert.</li>
     *   <li>Auf das begrenzen, was bezahlbar und roestbar ist
     *       ({@link Entscheidung#maximalBezahlbareSaecke(int, int)}).</li>
     *   <li>Mit deinen Methoden aus Uebung 2 einkaufen, roesten, verkaufen und die Kasse
     *       fortschreiben. Es bleibt nichts im Lager liegen.</li>
     * </ol>
     *
     * <p>Zurueckgegeben wird die <b>Veraenderung</b> der Kasse, nicht der neue Kassenstand.
     * Ein negativer Wert bedeutet Verlust.
     *
     * @param runde               Rundennummer
     * @param verkaufspreisInCent gesetzter Preis je Becher
     * @param kasseInCent         Kassenstand zu Rundenbeginn
     * @return Veraenderung des Kassenstands in Cent
     */
    public static int rundenergebnis(int runde, int verkaufspreisInCent, int kasseInCent) {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Welcher Verkaufspreis bringt in dieser Runde am meisten ein?
     *
     * <p>Das ist die Maschinenfassung eures Handversuchs aus Uebung 2. Probiere alle Preise
     * von 100 Cent bis 500 Cent in Schritten von 10 Cent durch, rechne mit
     * {@link #rundenergebnis(int, int, int)} jeweils das Ergebnis aus und gib den Preis
     * zurueck, der am meisten bringt.
     *
     * <p>Bei Gleichstand gewinnt der niedrigere Preis.
     *
     * <p>Auch hier gilt der Hinweis zum Startwert: Beginne die Merkvariable fuer das beste
     * Ergebnis nicht mit 0. Es gibt Runden, in denen jeder Preis Verlust bedeutet - und dann
     * darf die Methode nicht ratlos dastehen.
     *
     * @param runde       Rundennummer
     * @param kasseInCent Kassenstand zu Rundenbeginn
     * @return bester Verkaufspreis in Cent
     */
    public static int besterVerkaufspreis(int runde, int kasseInCent) {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Spielt alle {@link Spielregeln#ANZAHL_RUNDEN} Runden mit einem festen Verkaufspreis.
     *
     * <p>Beginnt mit {@link Spielregeln#STARTKAPITAL_CENT} und schreibt die Kasse Runde fuer
     * Runde fort. Wird die Roesterei zwischendurch zahlungsunfaehig
     * ({@link Entscheidung#istBankrott(int)}), endet das Spiel sofort - dafuer ist
     * {@code break} da. Der dann erreichte Kassenstand wird zurueckgegeben.
     *
     * @param verkaufspreisInCent Preis je Becher, ueber alle Runden gleich
     * @return Kassenstand am Spielende, in Cent
     */
    public static int spieleGanzesSpiel(int verkaufspreisInCent) {
        // TODO Stufe 2
        return 0;
    }


    // =================================================================================
    //  STUFE 3 - KUER
    // =================================================================================

    /**
     * Das Experiment: Fester Preis oder mitdenken?
     *
     * <p><b>Aufgabe:</b> Vergleiche zwei Spielweisen ueber alle 30 Runden.
     * <ul>
     *   <li>Die eine haelt den Verkaufspreis stur konstant - probiere aus, welcher feste
     *       Preis am besten abschneidet.</li>
     *   <li>Die andere setzt in jeder Runde den Preis neu, den
     *       {@link #besterVerkaufspreis(int, int)} fuer diese Runde empfiehlt.</li>
     * </ul>
     * Gib beide Verlaeufe als Tabelle aus - Runde, Preis, Ergebnis, Kassenstand - und darunter
     * den Vergleich.
     *
     * <p><b>Die Frage dahinter:</b> Der beste Preis fuer Runde 1 ist nicht der beste Preis
     * fuer das ganze Spiel. Woran liegt das? Und lohnt sich das Mitdenken ueberhaupt -
     * wie gross ist der Abstand am Ende wirklich?
     *
     * <p>Was du hier baust, ist uebrigens dein erster Bot. In Einheit 11 bekommt er einen
     * Namen und tritt gegen die der anderen an.
     */
    public static void vergleicheStrategien() {
        // TODO Stufe 3 (Kuer)
        Konsole.zeige("Noch nicht gebaut - das ist die Kueraufgabe.");
    }

    public static void main(String[] args) {
        vergleicheStrategien();
    }
}
