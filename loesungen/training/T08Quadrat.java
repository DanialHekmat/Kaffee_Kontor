package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/** Training 8c - ein Quadrat ist eine Form. */
public class T08Quadrat extends T08Form {

    private int seite;

    public T08Quadrat(int seite) {
        super("Quadrat");
        this.seite = seite;
    }

    @Override
    public int flaeche() {
        return seite * seite;
    }
}
