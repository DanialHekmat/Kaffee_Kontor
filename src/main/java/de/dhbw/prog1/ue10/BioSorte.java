package de.dhbw.prog1.ue10;

import de.dhbw.prog1.kern.Kaffeesorte;

/**
 * Uebung 10, Teil 1 - eine Sorte, die fast alles wie die andere macht.
 *
 * <p>Eine Bio-Sorte ist eine Kaffeesorte. Sie hat einen Namen, einen Einkaufspreis, einen
 * Deckungsbeitrag - alles wie gehabt. Nur bei den Kosten je Becher kommt etwas dazu: die
 * Zertifizierung schlaegt auf.
 *
 * <p>Man koennte die ganze Klasse abschreiben und diese eine Methode aendern. Dann gaebe es
 * dieselbe Logik zweimal, und beim naechsten Mal wuerde nur eine der beiden korrigiert.
 * Das kennt ihr aus Einheit 5.
 *
 * <p><b>Vererbung</b> loest das: {@code extends Kaffeesorte} bedeutet "diese Klasse kann alles,
 * was eine Kaffeesorte kann" - und dann schreibt man nur noch auf, was <i>anders</i> ist.
 * Vier Zeilen statt einer ganzen Klasse.
 *
 * <p>Die Kaffeesorte heisst dabei <b>Oberklasse</b>, die BioSorte <b>Unterklasse</b>. Und
 * weil jede BioSorte auch eine Kaffeesorte ist, darf sie ueberall stehen, wo eine Kaffeesorte
 * erwartet wird - in einem {@code Kaffeesorte[]} zum Beispiel. Das wird im dritten Teil
 * dieser Uebung wichtig.
 */
public class BioSorte extends Kaffeesorte {

    // Nur die zusaetzliche Eigenschaft. Name und Einkaufspreis stehen schon in der
    // Oberklasse und werden nicht noch einmal angelegt.
    private int zertifizierungsaufschlagProzent;

    /**
     * Erzeugt eine neue Bio-Sorte.
     *
     * <p>Der Aufruf {@code super(...)} ist schon da, und er <b>muss die allererste Anweisung
     * im Konstruktor sein</b> - davor darf nichts stehen, nicht einmal eine Zuweisung. Der
     * Grund ist einleuchtend: Bevor die Unterklasse ihre Ergaenzungen anbringt, muss der Teil
     * darunter fertig gebaut sein. Erst das Fundament, dann das Obergeschoss.
     *
     * <p>Ohne diese Zeile bekaemst du eine Fehlermeldung, denn die Oberklasse hat keinen
     * Konstruktor ohne Parameter - Java koennte gar nicht wissen, welchen Namen und welchen
     * Preis die Kaffeesorte darunter haben soll.
     *
     * @param name                            Name der Sorte
     * @param einkaufspreisProSackInCent      Einkaufspreis je Sack
     * @param zertifizierungsaufschlagProzent Aufschlag auf die Rohstoffkosten, in Prozent
     */
    public BioSorte(String name, int einkaufspreisProSackInCent,
                    int zertifizierungsaufschlagProzent) {
        super(name, einkaufspreisProSackInCent);

        // TODO Stufe 1: den Aufschlag im Attribut merken
    }

    /**
     * Was kostet der Rohkaffee fuer einen Becher dieser Bio-Sorte?
     *
     * <p>Wie bei jeder Kaffeesorte - plus dem Zertifizierungsaufschlag darauf.
     *
     * <p>Die Grundrechnung steht schon in der Oberklasse, und du sollst sie nicht abschreiben.
     * Mit {@code super.kostenProBecherInCent()} rufst du ausdruecklich die Fassung der
     * Oberklasse auf und rechnest auf deren Ergebnis weiter:
     *
     * <pre>
     *     int basis = super.kostenProBecherInCent();
     *     return basis + basis * zertifizierungsaufschlagProzent / 100;
     * </pre>
     *
     * <p><b>Achtung:</b> Ein Aufruf von {@code kostenProBecherInCent()} <i>ohne</i>
     * {@code super.} wuerde diese Methode hier aufrufen - also sich selbst, endlos, bis das
     * Programm mit einem {@code StackOverflowError} abbricht. Das {@code super.} ist hier
     * kein Stilmittel, sondern zwingend.
     *
     * <p>Beispiel: 3650 Cent je Sack ergeben 45 Cent Basis. Bei 20 Prozent Aufschlag sind
     * das 9 Cent mehr, also 54.
     *
     * @return Rohstoffkosten je Becher in Cent
     */
    @Override
    public int kostenProBecherInCent() {
        // TODO Stufe 1
        return 0;
    }

    /**
     * Beschreibung der Sorte, mit Hinweis auf die Zertifizierung.
     *
     * <p>Die Oberklasse kann sich schon beschreiben. Nimm ihr Ergebnis und haeng den Hinweis
     * an - genau in diesem Format:
     *
     * <pre>
     *     Bio-Hochland: 36,50 EUR je Sack, 54 ct je Becher [Bio +20%]
     * </pre>
     *
     * <p><b>Schau dir die 54 in diesem Beispiel genau an.</b> Die Beschreibung stammt aus der
     * Oberklasse, und die kennt keinen Zertifizierungsaufschlag - trotzdem stehen dort die
     * 54 und nicht die 45.
     *
     * <p>Der Grund ist der wichtigste Satz dieser Einheit: Die geerbte {@code toString} ruft
     * {@code kostenProBecherInCent()} auf, und Java entscheidet <b>zur Laufzeit anhand des
     * tatsaechlichen Objekts</b>, welche Fassung dieser Methode genommen wird - nicht anhand
     * dessen, was in der Oberklasse steht. Das nennt man <b>dynamische Bindung</b>.
     *
     * <p>Die Oberklasse benutzt damit eine Methode, die es zum Zeitpunkt ihrer Entstehung
     * noch gar nicht gab. Genau das macht Vererbung maechtig - und gelegentlich auch
     * gefaehrlich.
     *
     * @return Beschreibung der Bio-Sorte
     */
    @Override
    public String toString() {
        // TODO Stufe 2
        return "";
    }
}
