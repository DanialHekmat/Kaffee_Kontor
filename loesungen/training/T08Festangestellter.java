package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/** Training 8e - ein Festangestellter bekommt jeden Monat sein Grundgehalt. */
public class T08Festangestellter extends T08Mitarbeiter {

    private int grundgehalt;

    public T08Festangestellter(String name, int grundgehalt) {
        super(name);
        this.grundgehalt = grundgehalt;
    }

    @Override
    public int monatsgehalt() {
        return grundgehalt;
    }
}
