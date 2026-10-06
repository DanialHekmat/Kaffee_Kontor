package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/**
 * Training 8h - Polymorphie: Alle Mitarbeiter in einem Array, egal welcher Art.
 *
 * <p>Pruefe dich mit {@code T08VererbungTest}.
 */
public class T08Personal {

    /** Summe aller Jahresgehaelter. */
    public static int gesamteJahresgehaelter(T08Mitarbeiter[] personal) {
        int summe = 0;
        for (T08Mitarbeiter m : personal) {
            summe += m.jahresgehalt();
        }
        return summe;
    }

    /**
     * Wer verdient im Monat am meisten? Bei Gleichstand der zuerst Genannte. Leeres Array
     * ergibt {@code null}.
     */
    public static T08Mitarbeiter bestbezahlt(T08Mitarbeiter[] personal) {
        T08Mitarbeiter bester = null;
        for (T08Mitarbeiter m : personal) {
            if (bester == null || m.monatsgehalt() > bester.monatsgehalt()) {
                bester = m;
            }
        }
        return bester;
    }
}
