package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/** Training 8d - ein Dreieck ist eine Form. Flaeche: Grundseite mal Hoehe durch 2, ganzzahlig. */
public class T08Dreieck extends T08Form {

    private int grundseite;
    private int hoehe;

    public T08Dreieck(int grundseite, int hoehe) {
        super("Dreieck");
        this.grundseite = grundseite;
        this.hoehe = hoehe;
    }

    @Override
    public int flaeche() {
        return grundseite * hoehe / 2;
    }
}
