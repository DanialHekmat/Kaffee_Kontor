package de.dhbw.prog1.ue14;

/**
 * Uebung 14 - <b>der KI-Vorschlag. Diese Datei wird nicht veraendert.</b>
 *
 * <p>Sie ist die Antwort auf folgende Anfrage:
 *
 * <blockquote>
 * "Schreib mir eine Java-Klasse fuer die Rabattabrechnung einer Kaffeeroesterei.
 * Firmenkunden bekommen ab 20 Bechern 5 Prozent, ab 50 Bechern 10 Prozent und ab
 * 100 Bechern 15 Prozent Rabatt. Ausserdem eine Methode, die prueft, ob ein Kundentyp
 * 'premium' ist, und eine, die den Durchschnittspreis je Becher ausrechnet."
 * </blockquote>
 *
 * <p>Der Code sieht ordentlich aus. Er ist eingerueckt, hat sprechende Namen, sinnvolle
 * Kommentare und laesst sich uebersetzen. Er tut auch in den meisten Faellen das Richtige.
 *
 * <p><b>Und er enthaelt vier Fehler.</b> Drei davon habt ihr in diesem Semester selbst
 * gemacht und wurdet von einem Test darauf hingewiesen. Der vierte ist der gefaehrlichste,
 * weil er nie abstuerzt.
 *
 * <p>Eure Aufgabe steht in {@link RabattRechnerKorrigiert}.
 */
public class RabattRechner {

    /**
     * Berechnet den Rabatt in Prozent abhaengig von der Bestellmenge.
     *
     * @param anzahlBecher Anzahl bestellter Becher
     * @return Rabatt in Prozent
     */
    public static int rabattProzent(int anzahlBecher) {
        if (anzahlBecher > 100) {
            return 15;
        } else if (anzahlBecher > 50) {
            return 10;
        } else if (anzahlBecher > 20) {
            return 5;
        }
        return 0;
    }

    /**
     * Berechnet den Endpreis nach Abzug des Mengenrabatts.
     *
     * @param anzahlBecher      Anzahl bestellter Becher
     * @param preisProBecherEuro Preis je Becher in Euro
     * @return Endpreis in Euro
     */
    public static double endpreis(int anzahlBecher, double preisProBecherEuro) {
        double gesamt = anzahlBecher * preisProBecherEuro;
        double rabatt = gesamt * rabattProzent(anzahlBecher) / 100.0;

        return gesamt - rabatt;
    }

    /**
     * Prueft, ob es sich um einen Premium-Kunden handelt.
     *
     * @param kundentyp Kundentyp, z. B. "premium" oder "standard"
     * @return true bei Premium-Kunden
     */
    public static boolean istPremium(String kundentyp) {
        return kundentyp == "premium";
    }

    /**
     * Berechnet den durchschnittlichen Preis je Becher ueber mehrere Bestellungen.
     *
     * @param bestellwerteInCent Bestellwerte in Cent
     * @param becherProBestellung Becher je Bestellung
     * @return Durchschnittspreis je Becher in Cent
     */
    public static int durchschnittProBecher(int[] bestellwerteInCent, int becherProBestellung) {
        int summe = 0;

        for (int i = 0; i <= bestellwerteInCent.length - 1; i++) {
            summe += bestellwerteInCent[i];
        }

        return summe / (bestellwerteInCent.length * becherProBestellung);
    }
}
