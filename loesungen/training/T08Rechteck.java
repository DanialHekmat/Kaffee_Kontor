package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/** Training 8b - ein Rechteck ist eine Form. */
public class T08Rechteck extends T08Form {

    private int breite;
    private int hoehe;

    public T08Rechteck(int breite, int hoehe) {
        super("Rechteck");
        this.breite = breite;
        this.hoehe = hoehe;
    }

    @Override
    public int flaeche() {
        return breite * hoehe;
    }
}
