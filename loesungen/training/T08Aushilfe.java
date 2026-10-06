package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/** Training 8f - eine Aushilfe bekommt Stunden mal Stundenlohn. */
public class T08Aushilfe extends T08Mitarbeiter {

    private int stunden;
    private int stundenlohn;

    public T08Aushilfe(String name, int stunden, int stundenlohn) {
        super(name);
        this.stunden = stunden;
        this.stundenlohn = stundenlohn;
    }

    @Override
    public int monatsgehalt() {
        return stunden * stundenlohn;
    }
}
