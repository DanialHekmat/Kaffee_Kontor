package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/**
 * Training 8a - Vererbung: die gemeinsame Oberklasse aller Formen.
 *
 * <p>Die Klasse ist abstrakt: Wie die Flaeche berechnet wird, weiss erst die Unterklasse.
 *
 * <p>Passt zu Einheit 10 und 11. Pruefe dich mit {@code T08VererbungTest}.
 */
public abstract class T08Form {

    private String name;

    /** Merkt sich den Namen der Form. */
    protected T08Form(String name) {
        this.name = name;
    }

    /** Der Name, z. B. {@code "Rechteck"}. */
    public String name() {
        return name;
    }

    /** Die Flaeche - jede Unterklasse rechnet anders. */
    public abstract int flaeche();

    /**
     * Genau in diesem Format: {@code "Rechteck mit Flaeche 12"}.
     *
     * <p>Rufe dafuer {@link #flaeche()} auf. Diese Methode schreibst du einmal hier - und sie
     * funktioniert fuer alle Unterklassen richtig. Warum?
     */
    @Override
    public String toString() {
        return name() + " mit Flaeche " + flaeche();
    }
}
