package de.dhbw.prog1.training;

/**
 * Training 8d - Vererbung: die gemeinsame Oberklasse aller Mitarbeiter.
 *
 * <p>Wie das Monatsgehalt entsteht, weiss erst die Unterklasse. Das Jahresgehalt dagegen
 * rechnet die Oberklasse fuer alle gleich aus.
 *
 * <p>Passt zu Einheit 10 und 11. Pruefe dich mit {@code T08VererbungTest}.
 */
public abstract class T08Mitarbeiter {

    private String name;

    protected T08Mitarbeiter(String name) {
        // TODO
    }

    public String name() {
        // TODO
        return "";
    }

    /** Das Monatsgehalt in Euro - jede Unterklasse rechnet anders. */
    public abstract int monatsgehalt();

    /** Zwoelf Monatsgehaelter. Rufe {@link #monatsgehalt()} auf. */
    public int jahresgehalt() {
        // TODO
        return 0;
    }

    /** Genau in diesem Format: {@code "Anna: 36000 im Jahr"}. */
    @Override
    public String toString() {
        // TODO
        return "";
    }
}
