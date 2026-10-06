package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/**
 * Training 9b - Ausnahmen werfen und abfangen.
 *
 * <p>Passt zu Einheit 12. Pruefe dich mit {@code T09ExceptionsTest}.
 */
public class T09Exceptions {

    /**
     * Liest eine ganze Zahl; bei allem Unbrauchbaren (auch {@code null}) kommt 0 heraus.
     *
     * <p>Fange die {@code NumberFormatException} von {@code Integer.parseInt} ab.
     */
    public static int zahlOderNull(String text) {
        if (text == null) {
            return 0;
        }
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /** Ist der Text eine ganze Zahl? Leerzeichen drumherum sind erlaubt, {@code null} nicht. */
    public static boolean istZahl(String text) {
        if (text == null) {
            return false;
        }
        try {
            Integer.parseInt(text.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Teilt a durch b. Ist b gleich 0, wird eine {@link IllegalArgumentException} geworfen -
     * statt dass Java eine {@code ArithmeticException} wirft.
     */
    public static int teile(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division durch null ist nicht erlaubt.");
        }
        return a / b;
    }

    /**
     * Gibt das Alter zurueck, wenn es zwischen 0 und 150 liegt (beide eingeschlossen).
     *
     * <p>Sonst eine {@link IllegalArgumentException}, deren Meldung den falschen Wert nennt.
     */
    public static int pruefeAlter(int alter) {
        if (alter < 0 || alter > 150) {
            throw new IllegalArgumentException("Ungueltiges Alter: " + alter);
        }
        return alter;
    }

    /**
     * Liest eine ganze Zahl streng: Bei unbrauchbarem Text wird die eigene gepruefte
     * {@link T09UngueltigeEingabeException} geworfen, die den Text mitliefert.
     *
     * <p>Leerzeichen drumherum sind erlaubt. Die {@code NumberFormatException} faengst du ab und
     * wirfst stattdessen deine eigene Ausnahme.
     */
    public static int zahlStreng(String text) throws T09UngueltigeEingabeException {
        if (text == null) {
            throw new T09UngueltigeEingabeException("Keine Eingabe vorhanden.", null);
        }
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            throw new T09UngueltigeEingabeException("Keine ganze Zahl: " + text, text);
        }
    }

    /**
     * Das Element an der Position - oder der Standardwert, wenn die Position nicht existiert
     * oder das Array {@code null} ist.
     */
    public static int elementOderStandard(int[] werte, int position, int standard) {
        if (werte == null || position < 0 || position >= werte.length) {
            return standard;
        }
        return werte[position];
    }

    /**
     * Summe aller Eintraege, die sich als ganze Zahl lesen lassen. Alles andere (auch
     * {@code null}) wird uebersprungen - ohne dass die Schleife abbricht.
     */
    public static int summeGueltiger(String[] eintraege) {
        int summe = 0;
        for (String eintrag : eintraege) {
            if (eintrag == null) {
                continue;
            }
            try {
                summe += Integer.parseInt(eintrag.trim());
            } catch (NumberFormatException e) {
                // unbrauchbarer Eintrag - weiter mit dem naechsten
            }
        }
        return summe;
    }

    // =================================================================================
    //  WEITERE AUFGABEN
    // =================================================================================

    /**
     * Liefert den Text ohne Leerzeichen am Rand. Ist er {@code null} oder danach leer, wird eine
     * {@link IllegalArgumentException} geworfen.
     */
    public static String pruefeNichtLeer(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Der Text darf nicht leer sein.");
        }
        return text.trim();
    }

    /**
     * Prozentanteil, ganzzahlig: {@code teil * 100 / ganzes}. Ist ganzes 0 oder negativ, wird
     * eine {@link IllegalArgumentException} geworfen.
     */
    public static int prozent(int teil, int ganzes) {
        if (ganzes <= 0) {
            throw new IllegalArgumentException("Das Ganze muss groesser als 0 sein: " + ganzes);
        }
        return teil * 100 / ganzes;
    }

    /**
     * Die ganzzahlige Wurzel: die groesste Zahl w mit {@code w * w <= n}. 15 ergibt 3, 16 ergibt
     * 4. Negative n ergeben eine {@link IllegalArgumentException}.
     */
    public static int ganzzahligeWurzel(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Keine Wurzel aus negativen Zahlen: " + n);
        }
        int w = 0;
        while ((w + 1) * (w + 1) <= n) {
            w++;
        }
        return w;
    }

    /** Liest eine ganze Zahl; bei unbrauchbarem Text (auch {@code null}) kommt standard heraus. */
    public static int zahlOderStandard(String text, int standard) {
        if (text == null) {
            return standard;
        }
        try {
            return Integer.parseInt(text.trim());
        } catch (NumberFormatException e) {
            return standard;
        }
    }

    /**
     * Der Tag aus einem Datum im Format {@code "TT.MM.JJJJ"}: {@code "17.09.2026"} ergibt 17.
     *
     * <p>Wirft die eigene {@link T09UngueltigeEingabeException} mit dem Text als Eingabe, wenn
     * der Text {@code null} ist, nicht genau 10 Zeichen lang ist, an Position 2 und 5 keinen
     * Punkt hat, der Tag keine Zahl ist oder nicht zwischen 1 und 31 liegt.
     */
    public static int tagAusDatum(String datum) throws T09UngueltigeEingabeException {
        if (datum == null || datum.length() != 10 || datum.charAt(2) != '.' || datum.charAt(5) != '.') {
            throw new T09UngueltigeEingabeException("Kein Datum im Format TT.MM.JJJJ: " + datum, datum);
        }
        int tag;
        try {
            tag = Integer.parseInt(datum.substring(0, 2));
        } catch (NumberFormatException e) {
            throw new T09UngueltigeEingabeException("Der Tag ist keine Zahl: " + datum, datum);
        }
        if (tag < 1 || tag > 31) {
            throw new T09UngueltigeEingabeException("Den Tag gibt es nicht: " + datum, datum);
        }
        return tag;
    }

    /**
     * Division mit Rest als Text: 7 und 2 ergeben {@code "7 : 2 = 3 Rest 1"}. Bei b gleich 0
     * wird eine {@link IllegalArgumentException} geworfen.
     */
    public static String divisionMitRest(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division durch null ist nicht erlaubt.");
        }
        return a + " : " + b + " = " + (a / b) + " Rest " + (a % b);
    }

    /**
     * Wie viele Eintraege sind keine ganze Zahl? {@code null}-Eintraege zaehlen als ungueltig,
     * ein {@code null}-Array ergibt 0. Benutze {@link #istZahl(String)}.
     */
    public static int anzahlUngueltiger(String[] texte) {
        if (texte == null) {
            return 0;
        }
        int anzahl = 0;
        for (String text : texte) {
            if (!istZahl(text)) {
                anzahl++;
            }
        }
        return anzahl;
    }

    /**
     * Ganzzahliger Mittelwert. Fuer {@code null} oder ein leeres Array gibt es keinen Mittelwert:
     * Dann wird eine {@link IllegalArgumentException} geworfen.
     */
    public static int mittelwert(int[] werte) {
        if (werte == null || werte.length == 0) {
            throw new IllegalArgumentException("Ohne Werte gibt es keinen Mittelwert.");
        }
        int summe = 0;
        for (int wert : werte) {
            summe += wert;
        }
        return summe / werte.length;
    }

    /**
     * Gibt den Wert zurueck, wenn er zwischen min und max liegt (beide eingeschlossen). Sonst
     * eine {@link IllegalArgumentException} mit genau dieser Meldung:
     * {@code "Wert 12 liegt nicht zwischen 1 und 10"}.
     */
    public static int pruefeBereich(int wert, int min, int max) {
        if (wert < min || wert > max) {
            throw new IllegalArgumentException("Wert " + wert + " liegt nicht zwischen " + min + " und " + max);
        }
        return wert;
    }

    /**
     * Das Zeichen an der Position. Ist der Text {@code null} oder die Position ungueltig, kommt
     * {@code '?'} heraus. Pruefe vorher - statt Ausnahmen abzufangen.
     */
    public static char zeichenOderFragezeichen(String text, int position) {
        if (text == null || position < 0 || position >= text.length()) {
            return '?';
        }
        return text.charAt(position);
    }

    /**
     * Summe aller Texte als Zahlen - streng: Beim ersten unbrauchbaren Eintrag wird die eigene
     * {@link T09UngueltigeEingabeException} weitergereicht. Benutze {@link #zahlStreng(String)}.
     */
    public static int summeStreng(String[] texte) throws T09UngueltigeEingabeException {
        int summe = 0;
        for (String text : texte) {
            summe += zahlStreng(text);
        }
        return summe;
    }
}
