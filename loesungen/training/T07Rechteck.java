package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/**
 * Training 7b - Klassen und Objekte: ein Rechteck.
 *
 * <p>Passt zu Einheit 8. Pruefe dich mit {@code T07KlassenTest}.
 */
public class T07Rechteck {

    private int breite;
    private int hoehe;

    /** Erzeugt ein Rechteck. Denk an {@code this}. */
    public T07Rechteck(int breite, int hoehe) {
        this.breite = breite;
        this.hoehe = hoehe;
    }

    /** Breite mal Hoehe. */
    public int flaeche() {
        return breite * hoehe;
    }

    /** Zweimal Breite plus zweimal Hoehe. */
    public int umfang() {
        return 2 * breite + 2 * hoehe;
    }

    /** Sind Breite und Hoehe gleich? */
    public boolean istQuadrat() {
        return breite == hoehe;
    }

    /** Genau in diesem Format: {@code "Rechteck 3x4"}. */
    @Override
    public String toString() {
        return "Rechteck " + breite + "x" + hoehe;
    }
}
