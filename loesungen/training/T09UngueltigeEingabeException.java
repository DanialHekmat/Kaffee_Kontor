package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/**
 * Training 9a - eine eigene, gepruefte Ausnahme, die die fehlerhafte Eingabe mitliefert.
 *
 * <p>Passt zu Einheit 12. Pruefe dich mit {@code T09ExceptionsTest}.
 */
public class T09UngueltigeEingabeException extends Exception {

    private String eingabe;

    public T09UngueltigeEingabeException(String meldung, String eingabe) {
        super(meldung);
        this.eingabe = eingabe;
    }

    /** Die Eingabe, die nicht verarbeitet werden konnte. */
    public String eingabe() {
        return eingabe;
    }
}
