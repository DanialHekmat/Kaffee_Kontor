package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/**
 * Training 7c - Klassen und Objekte: ein Konto, das sich selbst schuetzt.
 *
 * <p>Der Kontostand ist {@code private}. Von aussen aendert ihn nur, wer einzahlt oder abhebt -
 * und diese Methoden weisen Unsinn zurueck. Das ist Kapselung.
 *
 * <p>Passt zu Einheit 8. Pruefe dich mit {@code T07KlassenTest}.
 */
public class T07Konto {

    private String inhaber;
    private int kontostand;

    /** Ein neues Konto hat den Kontostand 0. */
    public T07Konto(String inhaber) {
        this.inhaber = inhaber;
    }

    public String inhaber() {
        return inhaber;
    }

    public int kontostand() {
        return kontostand;
    }

    /** Zahlt ein. Betraege von 0 oder weniger werden ignoriert. */
    public void einzahlen(int betrag) {
        if (betrag > 0) {
            kontostand += betrag;
        }
    }

    /**
     * Hebt ab, wenn der Betrag groesser als 0 ist und das Konto gedeckt ist. Liefert, ob es
     * geklappt hat. Klappt es nicht, bleibt der Kontostand unveraendert.
     */
    public boolean abheben(int betrag) {
        if (betrag <= 0 || betrag > kontostand) {
            return false;
        }
        kontostand -= betrag;
        return true;
    }

    /** Genau in diesem Format: {@code "Konto Anna: 110"}. */
    @Override
    public String toString() {
        return "Konto " + inhaber + ": " + kontostand;
    }
}
