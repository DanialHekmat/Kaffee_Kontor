package de.dhbw.prog1.ue05;

import de.dhbw.prog1.kern.Geld;
import de.dhbw.prog1.kern.Konsole;
import de.dhbw.prog1.kern.Markt;
import de.dhbw.prog1.kern.Spielregeln;

/**
 * Uebung 5 - Methoden.
 *
 * <p>Heute ist die Aufgabe eine andere als sonst. Du schreibst nichts Neues: Der Code
 * existiert bereits und funktioniert - in {@link KontorMonolith}, als eine einzige Methode
 * mit fuenfzig Zeilen, Variablen namens {@code x2} und der Zahl 90000 mittendrin.
 *
 * <p><b>Deine Aufgabe ist, ihn zu zerlegen.</b> Dieselbe Rechnung, verteilt auf Methoden mit
 * Namen, die sagen, was sie tun. Am Ende muss dein {@link #spieleSpiel(int)} fuer jeden
 * Verkaufspreis exakt dasselbe Ergebnis liefern wie der Monolith - die Tests pruefen genau
 * das, Preis fuer Preis.
 *
 * <p>Das ist der Alltag in der Softwareentwicklung: Nicht auf der gruenen Wiese bauen, sondern
 * bestehenden Code verbessern, ohne ihn kaputtzumachen. Man nennt das <b>Refactoring</b>.
 * Und die Tests sind dabei das Sicherheitsnetz - ohne sie waere jede Aenderung ein Blindflug.
 *
 * <p><b>Diese Uebung braucht die vorherigen nicht.</b> Alles, was du benoetigst, steht in
 * {@link Markt} und {@link Spielregeln}. Wer bei Uebung 3 oder 4 haengengeblieben ist, kann
 * hier trotzdem voll mitmachen.
 */
public class Kontor {

    // =================================================================================
    //  STUFE 1 - BASIS
    // =================================================================================

    /**
     * Wie viele Saecke braucht es, um so viele Becher auszuschenken?
     *
     * <p>Im Monolithen steht dafuer die Zeile {@code int x = (n + 79) / 80;} - ohne jede
     * Erklaerung, woher die 79 und die 80 kommen. Aufgerundet wird, weil ein halber Sack
     * niemandem hilft.
     *
     * <p>Schreib dieselbe Rechnung hier hin, aber mit {@link Spielregeln#BECHER_PRO_SACK}
     * statt der nackten Zahlen. Dann steht in der Formel, was gemeint ist.
     *
     * @param nachfrage Anzahl nachgefragter Becher
     * @return benoetigte Anzahl Saecke, aufgerundet
     */
    public static int saeckeFuerNachfrage(int nachfrage) {
        // TODO Stufe 1
        return 0;
    }

    /**
     * Baut eine Zeile des Spielberichts.
     *
     * <p>Genau in diesem Format, mit Leerzeichen um die senkrechten Striche:
     *
     * <pre>
     *     Runde 1 | Preis 2,50 EUR | Ergebnis 216,50 EUR | Kasse 2216,50 EUR
     * </pre>
     *
     * <p>Fuer die Betraege nimmst du {@link Geld#formatiere(int)}.
     *
     * <p><b>Beachte, was diese Methode nicht tut: Sie gibt nichts aus.</b> Sie liefert den
     * Text zurueck, und wer ihn braucht, gibt ihn aus. Das ist kein Detail. Eine Methode, die
     * selbst druckt, laesst sich nicht testen, nicht in eine Datei schreiben und nicht
     * wiederverwenden - man kann ihr Ergebnis nur anschauen. Eine Methode, die zurueckgibt,
     * kann all das. <b>Rechnen und Ausgeben trennen</b> ist eine der nuetzlichsten Regeln,
     * die du dieses Semester mitnimmst.
     *
     * @param runde          Rundennummer
     * @param preisInCent    Verkaufspreis dieser Runde
     * @param ergebnisInCent Veraenderung der Kasse in dieser Runde
     * @param kasseInCent    Kassenstand nach der Runde
     * @return fertig formatierte Zeile
     */
    public static String berichtszeile(int runde, int preisInCent,
                                       int ergebnisInCent, int kasseInCent) {
        // TODO Stufe 1
        return "";
    }


    // =================================================================================
    //  STUFE 2 - KERN
    // =================================================================================

    /**
     * Wie viele Becher werden bei diesem Preis nachgefragt?
     *
     * <p>Im Monolithen wird das an zwei Stellen ausgerechnet, mit den Zahlen 400, 300, 25 und
     * 10 mittendrin - obwohl {@link Markt#nachfrageInBechern(int, int)} genau das schon kann.
     * So entsteht doppelter Code: Jemand hat die vorhandene Methode nicht gefunden und selbst
     * losgerechnet. Beim naechsten Mal wird dann nur eine der beiden Stellen korrigiert.
     *
     * <p>Deine Fassung besteht aus einer Zeile: dem Aufruf.
     *
     * @param runde               Rundennummer
     * @param verkaufspreisInCent Preis je Becher
     * @return Anzahl nachgefragter Becher
     */
    public static int nachfrage(int runde, int verkaufspreisInCent) {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Wie viele Becher werden zum Referenzpreis nachgefragt?
     *
     * <p>Dieselbe Frage wie oben, nur ohne Preisangabe - dann gilt
     * {@link Spielregeln#REFERENZPREIS_BECHER_CENT}.
     *
     * <p>Zwei Methoden mit demselben Namen und unterschiedlichen Parametern nennt man
     * <b>Ueberladung</b>. Java erkennt an der Anzahl und den Typen der Argumente, welche
     * gemeint ist. Das ist nuetzlich fuer bequeme Kurzfassungen wie diese.
     *
     * <p><b>Wichtig:</b> Schreib die Rechnung hier nicht noch einmal hin. Diese Methode ruft
     * die andere auf und gibt den Referenzpreis mit. Sonst hast du genau das doppelte Wissen
     * gebaut, das du gerade beseitigen sollst.
     *
     * @param runde Rundennummer
     * @return Anzahl nachgefragter Becher zum Referenzpreis
     */
    public static int nachfrage(int runde) {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Wie viele Saecke werden in dieser Runde tatsaechlich gekauft?
     *
     * <p>Die Roesterei kauft, was sie zum Bedienen der Nachfrage braucht - begrenzt durch
     * das Geld in der Kasse und durch
     * {@link Spielregeln#ROESTKAPAZITAET_SAECKE_PRO_RUNDE}. Bei leerer oder negativer Kasse
     * wird nichts gekauft.
     *
     * <p>Im Monolithen ist das ueber die Variablen {@code x}, {@code m} und {@code a}
     * verteilt. Hier soll es eine Methode sein, deren Name die Frage beantwortet.
     *
     * @param runde               Rundennummer
     * @param verkaufspreisInCent Preis je Becher
     * @param kasseInCent         Kassenstand zu Rundenbeginn
     * @return Anzahl gekaufter Saecke
     */
    public static int einkaufsmenge(int runde, int verkaufspreisInCent, int kasseInCent) {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Wie veraendert sich die Kasse in dieser Runde?
     *
     * <p>Einkaufen, roesten, verkaufen, Fixkosten abziehen. Es bleibt nichts im Lager liegen.
     * Zurueckgegeben wird die <b>Veraenderung</b>, nicht der neue Stand.
     *
     * <p>Wenn du die Methoden oben fertig hast, sollte diese hier kurz sein und sich lesen
     * lassen wie eine Beschreibung des Ablaufs. Falls sie bei dir zwanzig Zeilen lang wird,
     * fehlt wahrscheinlich noch eine Zerlegung.
     *
     * @param runde               Rundennummer
     * @param verkaufspreisInCent Preis je Becher
     * @param kasseInCent         Kassenstand zu Rundenbeginn
     * @return Veraenderung des Kassenstands in Cent
     */
    public static int rundenergebnis(int runde, int verkaufspreisInCent, int kasseInCent) {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Spielt alle Runden mit festem Verkaufspreis und liefert den Endstand.
     *
     * <p>Wie in Uebung 4: Start mit {@link Spielregeln#STARTKAPITAL_CENT}, Abbruch, sobald
     * die Kasse unter {@link Spielregeln#BANKROTT_GRENZE_CENT} faellt.
     *
     * <p>Das ist die Methode, an der sich alles entscheidet: Sie muss fuer jeden Preis
     * dasselbe liefern wie {@link KontorMonolith#spieleSpiel(int)}. Die Tests probieren
     * das mit einundvierzig verschiedenen Preisen durch.
     *
     * @param verkaufspreisInCent Preis je Becher, ueber alle Runden gleich
     * @return Kassenstand am Spielende
     */
    public static int spieleSpiel(int verkaufspreisInCent) {
        // TODO Stufe 2
        return 0;
    }


    // =================================================================================
    //  STUFE 3 - KUER
    // =================================================================================

    /**
     * Der vollstaendige Spielbericht als Text.
     *
     * <p><b>Aufgabe:</b> Baue mit {@link #berichtszeile(int, int, int, int)} einen Bericht
     * ueber alle gespielten Runden zusammen und gib ihn zurueck - eine Zeile je Runde,
     * getrennt durch {@code "\n"}. Auch diese Methode gibt nichts aus; das erledigt der
     * Aufrufer.
     *
     * <p>Danach die eigentliche Kuer: <b>Zerlege den Monolithen weiter, als die Aufgabe es
     * verlangt.</b> Findest du noch etwas, das einen eigenen Namen verdient hat? Gibt es
     * Code, der gar nichts tut? (Schau dir die letzten Zeilen der Schleife im Monolithen
     * genau an.)
     *
     * <p><b>Und die Frage zum Mitnehmen:</b> Der Monolith und deine Fassung liefern exakt
     * dieselben Zahlen. Kein Anwender merkt einen Unterschied. Wofuer war die Arbeit dann
     * gut? Zwei Saetze - wir besprechen es naechste Woche.
     *
     * @param verkaufspreisInCent Preis je Becher
     * @return mehrzeiliger Bericht
     */
    public static String spielbericht(int verkaufspreisInCent) {
        // TODO Stufe 3 (Kuer)
        return "";
    }

    public static void main(String[] args) {
        int preis = Konsole.frageBetragInCent("Mit welchem Preis soll gespielt werden");
        Konsole.zeigeUeberschrift("Spielbericht");
        Konsole.zeige(spielbericht(preis));
        Konsole.zeige();
        Konsole.zeige("Endstand: " + Geld.formatiere(spieleSpiel(preis)));
    }
}
