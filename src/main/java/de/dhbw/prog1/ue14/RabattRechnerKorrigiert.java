package de.dhbw.prog1.ue14;

/**
 * Uebung 14 - eure Fassung.
 *
 * <p>In {@link RabattRechner} steht, was die KI geliefert hat. Der Code ist ordentlich
 * eingerueckt, hat sprechende Namen und laesst sich uebersetzen. Er enthaelt vier Fehler.
 *
 * <p><b>Eure Aufgabe:</b> Findet sie und schreibt die Klasse hier richtig. Die Aufgabe ist
 * nicht "abschreiben und Fehler beheben" - zwei der Methoden brauchen eine andere
 * Unterschrift als im Vorschlag, weil der Fehler schon im Entwurf steckt.
 *
 * <p>Drei der vier Fehler habt ihr dieses Semester selbst gemacht und wurdet von einem Test
 * darauf hingewiesen. Der vierte ist der gefaehrlichste, weil er nie abstuerzt: Das Programm
 * laeuft, rechnet und liefert Zahlen, die fast stimmen.
 *
 * <p><b>Die Anforderung noch einmal im Klartext:</b>
 * <ul>
 *   <li>Firmenkunden bekommen <b>ab</b> 20 Bechern 5 Prozent, <b>ab</b> 50 Bechern
 *       10 Prozent, <b>ab</b> 100 Bechern 15 Prozent Rabatt. "Ab" heisst einschliesslich.</li>
 *   <li>Der Endpreis ergibt sich als Gesamtpreis minus Rabattbetrag.</li>
 *   <li>Ein Kunde ist Premium, wenn der Kundentyp {@code "premium"} lautet - unabhaengig von
 *       Gross- und Kleinschreibung und von Leerzeichen drumherum. Der Wert kommt aus einer
 *       Eingabemaske und kann fehlen.</li>
 *   <li>Der Durchschnittspreis je Becher ist der Gesamtwert geteilt durch die Gesamtzahl der
 *       Becher. Ohne Bestellungen ist er 0.</li>
 * </ul>
 *
 * <p><b>Und ein Hinweis, der genauso wichtig ist:</b> Nicht alles im Vorschlag, was
 * ungewoehnlich aussieht, ist falsch. Eine Zeile darin ist umstaendlich geschrieben und
 * trotzdem vollkommen korrekt. Wer sie "korrigiert", macht es schlimmer. Findet auch die.
 */
public class RabattRechnerKorrigiert {

    /**
     * Rabatt in Prozent, abhaengig von der Bestellmenge.
     *
     * <p>Ab 100 Bechern 15, ab 50 Bechern 10, ab 20 Bechern 5, darunter keinen.
     *
     * @param anzahlBecher Anzahl bestellter Becher
     * @return Rabatt in Prozent
     */
    public static int rabattProzent(int anzahlBecher) {
        // TODO Fehler 1
        return 0;
    }

    /**
     * Endpreis nach Abzug des Mengenrabatts, in <b>Cent</b>.
     *
     * <p>Beachtet die Unterschrift: Im Vorschlag standen hier {@code double} und Euro. Das
     * war der Fehler, der nie abstuerzt - und deshalb reicht es nicht, den Rumpf zu
     * reparieren.
     *
     * <p>Der Rabattbetrag ergibt sich als {@code gesamt * prozent / 100}, ganzzahlig.
     *
     * @param anzahlBecher        Anzahl bestellter Becher
     * @param preisProBecherInCent Preis je Becher in Cent
     * @return Endpreis in Cent
     */
    public static int endpreisInCent(int anzahlBecher, int preisProBecherInCent) {
        // TODO Fehler 2
        return 0;
    }

    /**
     * Ist das ein Premium-Kunde?
     *
     * <p>{@code "premium"} in beliebiger Schreibweise, Leerzeichen drumherum erlaubt.
     * Ein fehlender Wert ({@code null}) ist kein Premium-Kunde und darf nicht abstuerzen.
     *
     * @param kundentyp Kundentyp aus der Eingabemaske, darf null sein
     * @return true bei Premium-Kunden
     */
    public static boolean istPremium(String kundentyp) {
        // TODO Fehler 3
        return false;
    }

    /**
     * Durchschnittlicher Preis je Becher ueber mehrere Bestellungen.
     *
     * <p>Gesamtwert geteilt durch die Gesamtzahl der Becher. Ohne Bestellungen - oder wenn
     * je Bestellung null Becher angegeben sind - ist das Ergebnis 0 und <b>kein Absturz</b>.
     *
     * @param bestellwerteInCent  Bestellwerte in Cent
     * @param becherProBestellung Becher je Bestellung
     * @return Durchschnittspreis je Becher in Cent, 0 wenn nicht berechenbar
     */
    public static int durchschnittProBecher(int[] bestellwerteInCent, int becherProBestellung) {
        // TODO Fehler 4
        return 0;
    }
}
