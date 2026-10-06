package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/**
 * Training 7a - Klassen und Objekte: ein Zaehler, der sich etwas merkt.
 *
 * <p>Passt zu Einheit 8. Pruefe dich mit {@code T07KlassenTest}.
 */
public class T07Zaehler {

    private int stand;
    private int startwert;

    /** Erzeugt einen Zaehler mit dem angegebenen Startwert. */
    public T07Zaehler(int startwert) {
        this.startwert = startwert;
        this.stand = startwert;
    }

    /** Der aktuelle Stand. */
    public int stand() {
        return stand;
    }

    /** Erhoeht den Stand um eins. */
    public void erhoehe() {
        stand++;
    }

    /** Erhoeht den Stand um den angegebenen Schritt. */
    public void erhoeheUm(int schritt) {
        stand += schritt;
    }

    /**
     * Setzt den Stand auf den <b>Startwert</b> zurueck - nicht auf 0.
     *
     * <p>Dafuer muss sich das Objekt den Startwert merken.
     */
    public void zuruecksetzen() {
        stand = startwert;
    }
}
