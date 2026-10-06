package de.dhbw.prog1.ue03;

import de.dhbw.prog1.kern.Geld;
import de.dhbw.prog1.kern.Konsole;
import de.dhbw.prog1.kern.Markt;
import de.dhbw.prog1.kern.Spielregeln;
import de.dhbw.prog1.ue02.Runde;

/**
 * Uebung 3 - Verzweigungen und boolesche Logik.
 *
 * <p>In Uebung 2 hat dein Programm nur gerechnet. Jetzt lernt es zu <b>entscheiden</b>:
 * Ist genug Geld da? Ist die Roesterei pleite? War die Runde gut oder schlecht?
 *
 * <p>Wie immer: {@code TODO} ersetzen, Tests laufen lassen, gruen heisst fertig.
 * Die Methoden aus Uebung 2 darfst und sollst du hier wiederverwenden - sie stehen in
 * {@link Runde}.
 */
public class Entscheidung {

    // =================================================================================
    //  STUFE 1 - BASIS
    // =================================================================================

    /**
     * Ist die Roesterei zahlungsunfaehig?
     *
     * <p>Zahlungsunfaehig ist, wer <b>weniger</b> als {@link Spielregeln#BANKROTT_GRENZE_CENT}
     * in der Kasse hat. Ein Kassenstand von genau 0,00 EUR ist noch kein Bankrott - knapp,
     * aber nicht pleite.
     *
     * <p>Ueberleg dir gut, ob du {@code <} oder {@code <=} brauchst. Der Unterschied ist ein
     * einziges Zeichen und entscheidet ueber das Spielende. Solche Grenzfaelle sind eine der
     * haeufigsten Fehlerquellen ueberhaupt - sie heissen "Off-by-one-Fehler".
     *
     * @param kasseInCent aktueller Kassenstand
     * @return true, wenn die Roesterei pleite ist
     */
    public static boolean istBankrott(int kasseInCent) {
        // TODO Stufe 1
        return false;
    }

    /**
     * Wie ist die Runde gelaufen?
     *
     * <p>Liefert genau einen dieser drei Texte:
     * <ul>
     *   <li>{@code "Gewinn"} - wenn mehr Geld hereinkam als hinausging</li>
     *   <li>{@code "Verlust"} - wenn es andersherum war</li>
     *   <li>{@code "Punktlandung"} - wenn es genau aufgeht</li>
     * </ul>
     *
     * <p>Das ist der klassische Fall fuer {@code if / else if / else}. Achte darauf, dass
     * wirklich jeder moegliche Wert von genau einem Zweig erfasst wird.
     *
     * @param gewinnInCent Veraenderung des Kassenstands in dieser Runde
     * @return Bewertung als Text
     */
    public static String bewerteRunde(int gewinnInCent) {
        // TODO Stufe 1
        return "";
    }


    // =================================================================================
    //  STUFE 2 - KERN
    // =================================================================================

    /**
     * Wie viele Saecke kann die Roesterei diese Runde hoechstens kaufen?
     *
     * <p>Zwei Grenzen gelten gleichzeitig, und die kleinere gewinnt:
     * <ul>
     *   <li>Das Geld in der Kasse reicht nur fuer eine bestimmte Anzahl.</li>
     *   <li>Mehr als {@link Spielregeln#ROESTKAPAZITAET_SAECKE_PRO_RUNDE} schafft die
     *       Roestmaschine ohnehin nicht.</li>
     * </ul>
     *
     * <p>Bei leerer oder negativer Kasse sind es null Saecke. Denk daran: Ganzzahldivision
     * schneidet ab - und das ist hier genau richtig, denn einen halben Sack gibt es nicht.
     *
     * @param kasseInCent        aktueller Kassenstand
     * @param preisProSackInCent Marktpreis je Sack
     * @return hoechstmoegliche Anzahl Saecke, niemals negativ
     */
    public static int maximalBezahlbareSaecke(int kasseInCent, int preisProSackInCent) {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Darf dieser Einkauf getaetigt werden?
     *
     * <p>Erlaubt ist er nur, wenn <b>alle drei</b> Bedingungen zutreffen:
     * <ol>
     *   <li>Es wird mindestens ein Sack gekauft.</li>
     *   <li>Die Roestkapazitaet wird nicht ueberschritten.</li>
     *   <li>Das Geld in der Kasse reicht fuer den gesamten Einkauf.</li>
     * </ol>
     *
     * <p>Das ist der Einsatzzweck von {@code &&}. Und noch ein Hinweis zur Formulierung:
     * Schreib {@code return bedingung;} statt
     * {@code if (bedingung) { return true; } else { return false; }} - das Zweite ist eine
     * umstaendliche Art, dasselbe zu sagen.
     *
     * @param kasseInCent        aktueller Kassenstand
     * @param anzahlSaecke       gewuenschte Anzahl Saecke
     * @param preisProSackInCent Marktpreis je Sack
     * @return true, wenn der Einkauf zulaessig ist
     */
    public static boolean darfEinkaufen(int kasseInCent, int anzahlSaecke,
                                        int preisProSackInCent) {
        // TODO Stufe 2
        return false;
    }

    /**
     * Wie ist die Nachfragelage in dieser Runde?
     *
     * <p>Abhaengig vom Saisonwert (in Prozent, siehe {@link Markt#saisonInProzent(int)}):
     * <ul>
     *   <li>110 und mehr: {@code "Hochsaison"}</li>
     *   <li>95 bis 109: {@code "Normal"}</li>
     *   <li>unter 95: {@code "Flaute"}</li>
     * </ul>
     *
     * <p>Die Grenzen sind eingeschlossen, wo es dasteht. Genau bei 110 ist also schon
     * Hochsaison, genau bei 95 noch Normal. Die Tests pruefen diese Grenzfaelle einzeln -
     * das ist kein Schikane, sondern die Stelle, an der solche Methoden in der Praxis brechen.
     *
     * @param saisonProzent Saisonwert in Prozent
     * @return Beschreibung der Nachfragelage
     */
    public static String beschreibeSaison(int saisonProzent) {
        // TODO Stufe 2
        return "";
    }

    /**
     * Uebersetzt eine Menueauswahl in die zugehoerige Aktion.
     *
     * <ul>
     *   <li>1 -> {@code "Einkaufen"}</li>
     *   <li>2 -> {@code "Preis festlegen"}</li>
     *   <li>3 -> {@code "Bericht anzeigen"}</li>
     *   <li>0 -> {@code "Beenden"}</li>
     *   <li>alles andere -> {@code "Unbekannt"}</li>
     * </ul>
     *
     * <p>Hier bietet sich {@code switch} an: Wenn ein einzelner Wert gegen mehrere feste
     * Moeglichkeiten geprueft wird, ist das lesbarer als eine Kette aus {@code else if}.
     * Benutze die Pfeilschreibweise:
     *
     * <pre>
     *     return switch (wahl) {
     *         case 1 -&gt; "Einkaufen";
     *         ...
     *         default -&gt; "Unbekannt";
     *     };
     * </pre>
     *
     * <p>Der {@code default}-Zweig ist nicht optional gemeint: Ein Programm muss auch auf
     * Eingaben antworten, mit denen niemand gerechnet hat.
     *
     * @param wahl eingegebene Zahl
     * @return Name der Aktion
     */
    public static String menueAktion(int wahl) {
        // TODO Stufe 2
        return "";
    }

    /**
     * Hat die Benutzerin zugestimmt?
     *
     * <p>Als Zustimmung gelten {@code "j"} und {@code "ja"} - unabhaengig von Gross- und
     * Kleinschreibung und von Leerzeichen davor oder dahinter. Alles andere ist keine
     * Zustimmung, auch ein leerer Text.
     *
     * <p><b>Achtung, die wichtigste Falle dieser Einheit.</b> Texte werden in Java
     * <b>niemals</b> mit {@code ==} verglichen. {@code ==} fragt "sind das dieselben zwei
     * Objekte im Speicher?" und nicht "steht dasselbe drin?". Bei Texten, die direkt im
     * Quelltext stehen, geht das manchmal zufaellig gut - bei Texten, die erst zur Laufzeit
     * entstehen, etwa aus einer Benutzereingabe, geht es zuverlaessig schief. Und genau
     * darum geht es hier.
     *
     * <p>Richtig ist {@code equals(...)}, hier praktischerweise
     * {@code equalsIgnoreCase(...)}. Leerzeichen entfernst du vorher mit {@code trim()}.
     *
     * @param eingabe Text, den die Benutzerin eingegeben hat
     * @return true bei Zustimmung
     */
    public static boolean istBestaetigung(String eingabe) {
        // TODO Stufe 2
        return false;
    }


    // =================================================================================
    //  STUFE 3 - KUER
    // =================================================================================

    /**
     * Spielt eine Runde mit echten Entscheidungen.
     *
     * <p><b>Aufgabe:</b> Baue die Runde aus Uebung 2 so um, dass das Programm mitdenkt:
     * <ul>
     *   <li>Vor dem Einkauf anzeigen, wie viele Saecke ueberhaupt bezahlbar sind
     *       ({@link #maximalBezahlbareSaecke(int, int)}).</li>
     *   <li>Den Einkauf ablehnen, wenn {@link #darfEinkaufen(int, int, int)} false liefert -
     *       mit einer Meldung, die sagt <i>warum</i>.</li>
     *   <li>Die Saisonlage im Klartext ausgeben.</li>
     *   <li>Am Ende die Runde bewerten und pruefen, ob die Roesterei pleite ist.</li>
     * </ul>
     *
     * <p><b>Und zum Nachdenken:</b> In Runde 9 kostet ein Sack 38,00 EUR, in Runde 17 nur
     * 25,50 EUR. Waere es klug, in Runde 17 auf Vorrat zu kaufen? Was spricht dagegen?
     * (Ein Blick auf {@link Spielregeln#LAGERKOSTEN_PRO_SACK_CENT} und die Roestkapazitaet
     * hilft.) Zwei Saetze genuegen, wir besprechen es naechste Woche - dann koennen wir es
     * mit Schleifen auch ausrechnen.
     */
    public static void spieleRundeMitEntscheidungen() {
        // TODO Stufe 3 (Kuer)
        Konsole.zeige("Noch nicht gebaut - das ist die Kueraufgabe.");
    }

    public static void main(String[] args) {
        spieleRundeMitEntscheidungen();
    }
}
