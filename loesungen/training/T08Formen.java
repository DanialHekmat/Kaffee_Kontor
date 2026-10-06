package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/**
 * Training 8e - Polymorphie: Methoden, die mit allen Formen arbeiten.
 *
 * <p>Hier soll kein einziges {@code instanceof} stehen.
 */
public class T08Formen {

    /** Summe aller Flaechen. Leer oder {@code null} ergibt 0. */
    public static int gesamtflaeche(T08Form[] formen) {
        if (formen == null) {
            return 0;
        }
        int summe = 0;
        for (T08Form form : formen) {
            summe += form.flaeche();
        }
        return summe;
    }

    /** Die Form mit der groessten Flaeche; bei Gleichstand die erste. Leer oder null ergibt null. */
    public static T08Form groesste(T08Form[] formen) {
        if (formen == null || formen.length == 0) {
            return null;
        }
        T08Form groesste = formen[0];
        for (T08Form form : formen) {
            if (form.flaeche() > groesste.flaeche()) {
                groesste = form;
            }
        }
        return groesste;
    }
}
