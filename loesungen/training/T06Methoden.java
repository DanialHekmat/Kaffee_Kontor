package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/**
 * Training 6 - Methoden: zerlegen, wiederverwenden, ueberladen.
 *
 * <p>Bei mehreren Aufgaben steht, welche andere Methode du aufrufen sollst. Die Tests koennen
 * das nicht pruefen - aber genau darum geht es hier: dieselbe Rechnung nur an einer Stelle.
 *
 * <p>Passt zu Einheit 5. Pruefe dich mit {@code T06MethodenTest}.
 */
public class T06Methoden {

    /** Das Quadrat einer Zahl. */
    public static int quadrat(int x) {
        return x * x;
    }

    /** a hoch 2 plus b hoch 2. Benutze {@link #quadrat(int)}. */
    public static int summeDerQuadrate(int a, int b) {
        return quadrat(a) + quadrat(b);
    }

    /** Flaeche eines Quadrats. Benutze {@link #quadrat(int)}. */
    public static int flaeche(int seite) {
        return quadrat(seite);
    }

    /** Flaeche eines Rechtecks - ueberladen: gleicher Name, andere Parameter. */
    public static int flaeche(int breite, int hoehe) {
        return breite * hoehe;
    }

    /** Flaeche eines Kreises: pi mal r hoch 2. Tipp: {@code Math.PI}. */
    public static double kreisflaeche(double radius) {
        return Math.PI * radius * radius;
    }

    /** Liefert {@code "Hallo, Anna!"} fuer den Namen Anna. */
    public static String begruessung(String name) {
        return "Hallo, " + name + "!";
    }

    /**
     * Ueberladen: foermlich ergibt {@code "Guten Tag, Anna."}, sonst dasselbe wie
     * {@link #begruessung(String)} - und dafuer rufst du genau diese Methode auf.
     */
    public static String begruessung(String name, boolean foermlich) {
        if (foermlich) {
            return "Guten Tag, " + name + ".";
        }
        return begruessung(name);
    }

    /**
     * Groesster gemeinsamer Teiler (euklidischer Algorithmus).
     *
     * <p>Solange b nicht 0 ist: merke b, setze b auf a % b, setze a auf das Gemerkte.
     * Am Ende steht das Ergebnis in a. Beispiel: ggT(12, 18) ist 6.
     */
    public static int ggT(int a, int b) {
        while (b != 0) {
            int merker = b;
            b = a % b;
            a = merker;
        }
        return a;
    }

    /**
     * Kleinstes gemeinsames Vielfaches: a * b / ggT(a, b). Benutze {@link #ggT(int, int)}.
     *
     * <p>Ist a oder b gleich 0, ist das Ergebnis 0.
     */
    public static int kgV(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return a * b / ggT(a, b);
    }

    // =================================================================================
    //  WEITERE AUFGABEN
    // =================================================================================

    /** Ist teiler ein Teiler von zahl? Der Teiler 0 ergibt immer {@code false}. */
    public static boolean istTeilerVon(int teiler, int zahl) {
        return teiler != 0 && zahl % teiler == 0;
    }

    /**
     * Summe aller echten Teiler (alle Teiler ausser der Zahl selbst). 12 ergibt 1+2+3+4+6 = 16.
     * Benutze {@link #istTeilerVon(int, int)}.
     */
    public static int summeEchterTeiler(int zahl) {
        int summe = 0;
        for (int i = 1; i < zahl; i++) {
            if (istTeilerVon(i, zahl)) {
                summe += i;
            }
        }
        return summe;
    }

    /**
     * Vollkommen ist eine Zahl, die gleich der Summe ihrer echten Teiler ist - wie 6 und 28.
     * Benutze {@link #summeEchterTeiler(int)}. Zahlen unter 2 sind nicht vollkommen.
     */
    public static boolean istVollkommen(int zahl) {
        return zahl > 1 && summeEchterTeiler(zahl) == zahl;
    }

    /** Durchschnitt zweier Zahlen mit Nachkommastellen. */
    public static double durchschnitt(int a, int b) {
        return (a + b) / 2.0;
    }

    /** Durchschnitt dreier Zahlen - ueberladen. */
    public static double durchschnitt(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    /** Volumen eines Quaders. Benutze {@link #flaeche(int, int)} fuer die Grundflaeche. */
    public static int quaderVolumen(int laenge, int breite, int hoehe) {
        return flaeche(laenge, breite) * hoehe;
    }

    /**
     * Oberflaeche eines Quaders: zweimal jede der drei Seitenflaechen. 2, 3, 4 ergibt 52.
     * Benutze {@link #flaeche(int, int)}.
     */
    public static int quaderOberflaeche(int laenge, int breite, int hoehe) {
        return 2 * (flaeche(laenge, breite) + flaeche(laenge, hoehe) + flaeche(breite, hoehe));
    }

    /** Zinsen fuer ein Jahr, ganzzahlig: {@code kapital * zinssatz / 100}. */
    public static int zinsen(int kapital, int zinssatzProzent) {
        return kapital * zinssatzProzent / 100;
    }

    /**
     * Kapital nach einigen Jahren mit Zinseszins: Jedes Jahr kommen die Zinsen dazu.
     * 1000 bei 10 Prozent nach 3 Jahren: 1100, 1210, 1331. Benutze {@link #zinsen(int, int)}.
     */
    public static int kapitalNachJahren(int kapital, int zinssatzProzent, int jahre) {
        for (int jahr = 0; jahr < jahre; jahr++) {
            kapital += zinsen(kapital, zinssatzProzent);
        }
        return kapital;
    }

    /** Name im Format {@code "Schulz, Anna"}. */
    public static String formatiereName(String vorname, String nachname) {
        return nachname + ", " + vorname;
    }

    /**
     * Ueberladen mit Mittelname: {@code "Schulz, Anna M."} - vom Mittelnamen nur der erste
     * Buchstabe mit Punkt. Benutze {@link #formatiereName(String, String)}.
     */
    public static String formatiereName(String vorname, String mittelname, String nachname) {
        return formatiereName(vorname, nachname) + " " + mittelname.charAt(0) + ".";
    }
}
