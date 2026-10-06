package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/**
 * Training 4 - Schleifen.
 *
 * <p>Passt zu Einheit 4. Pruefe dich mit {@code T04SchleifenTest}.
 */
public class T04Schleifen {

    /** Summe 1 + 2 + ... + n. Fuer n kleiner als 1 ist das Ergebnis 0. */
    public static int summeBis(int n) {
        int summe = 0;
        for (int i = 1; i <= n; i++) {
            summe += i;
        }
        return summe;
    }

    /** n! = 1 * 2 * ... * n fuer n ab 0. Es gilt 0! = 1. */
    public static int fakultaet(int n) {
        int ergebnis = 1;
        for (int i = 2; i <= n; i++) {
            ergebnis *= i;
        }
        return ergebnis;
    }

    /** basis hoch exponent fuer exponent ab 0 - ohne {@code Math.pow}. */
    public static int potenz(int basis, int exponent) {
        int ergebnis = 1;
        for (int i = 0; i < exponent; i++) {
            ergebnis *= basis;
        }
        return ergebnis;
    }

    /** Wie viele Teiler hat n (n ab 1)? 12 hat sechs: 1, 2, 3, 4, 6, 12. */
    public static int anzahlTeiler(int n) {
        int anzahl = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                anzahl++;
            }
        }
        return anzahl;
    }

    /** Ist n eine Primzahl? 0 und 1 sind keine. */
    public static boolean istPrimzahl(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Quersumme einer nicht-negativen Zahl. 1234 ergibt 10.
     *
     * <p>Hier passt {@code while}: Solange noch Ziffern da sind ...
     */
    public static int quersumme(int zahl) {
        int summe = 0;
        while (zahl > 0) {
            summe += zahl % 10;
            zahl /= 10;
        }
        return summe;
    }

    /** Wiederholt einen Text. Beispiel: "ab" dreimal ergibt "ababab". Ohne {@code repeat}. */
    public static String wiederhole(String text, int anzahl) {
        String ergebnis = "";
        for (int i = 0; i < anzahl; i++) {
            ergebnis += text;
        }
        return ergebnis;
    }

    /**
     * Wie oft kommt ein Zeichen im Text vor? Bei {@code null} ist das Ergebnis 0.
     *
     * <p>Tipp: {@code text.length()} und {@code text.charAt(i)}.
     */
    public static int zaehleZeichen(String text, char zeichen) {
        if (text == null) {
            return 0;
        }
        int anzahl = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == zeichen) {
                anzahl++;
            }
        }
        return anzahl;
    }

    /** Kehrt einen Text um: "abc" wird "cba". {@code null} ergibt den leeren Text. */
    public static String umkehren(String text) {
        if (text == null) {
            return "";
        }
        String ergebnis = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            ergebnis += text.charAt(i);
        }
        return ergebnis;
    }

    // =================================================================================
    //  WEITERE AUFGABEN
    // =================================================================================

    /** Summe der geraden Zahlen von 2 bis n. Fuer n = 10: 2 + 4 + 6 + 8 + 10 = 30. */
    public static int summeGerade(int n) {
        int summe = 0;
        for (int i = 2; i <= n; i += 2) {
            summe += i;
        }
        return summe;
    }

    /** Wie viele Vokale (a, e, i, o, u, gross oder klein) enthaelt der Text? {@code null} ergibt 0. */
    public static int zaehleVokale(String text) {
        if (text == null) {
            return 0;
        }
        int anzahl = 0;
        for (int i = 0; i < text.length(); i++) {
            char zeichen = Character.toLowerCase(text.charAt(i));
            if (zeichen == 'a' || zeichen == 'e' || zeichen == 'i' || zeichen == 'o' || zeichen == 'u') {
                anzahl++;
            }
        }
        return anzahl;
    }

    /**
     * Die n-te Fibonacci-Zahl: 0, 1, 1, 2, 3, 5, 8, ... Jede Zahl ist die Summe der beiden davor.
     *
     * <p>fibonacci(0) ist 0, fibonacci(1) ist 1, fibonacci(10) ist 55.
     */
    public static int fibonacci(int n) {
        int vorletzte = 0;
        int letzte = 1;
        for (int i = 0; i < n; i++) {
            int neu = vorletzte + letzte;
            vorletzte = letzte;
            letzte = neu;
        }
        return vorletzte;
    }

    /** Wie viele Stellen hat die Zahl? 1234 hat 4, 0 hat 1, -567 hat 3. */
    public static int anzahlStellen(int zahl) {
        zahl = Math.abs(zahl);
        int stellen = 1;
        while (zahl >= 10) {
            zahl /= 10;
            stellen++;
        }
        return stellen;
    }

    /** Die groesste Ziffer einer nicht-negativen Zahl. 1934 ergibt 9. */
    public static int groessteZiffer(int zahl) {
        int groesste = 0;
        while (zahl > 0) {
            groesste = Math.max(groesste, zahl % 10);
            zahl /= 10;
        }
        return groesste;
    }

    /**
     * Die Zahl im Binaersystem als Text. 5 ergibt {@code "101"}, 10 ergibt {@code "1010"},
     * 0 ergibt {@code "0"}.
     *
     * <p>Tipp: Der Rest bei Division durch 2 ist die letzte Binaerziffer. Setze ihn vorn an.
     */
    public static String binaer(int zahl) {
        if (zahl == 0) {
            return "0";
        }
        String ergebnis = "";
        while (zahl > 0) {
            ergebnis = (zahl % 2) + ergebnis;
            zahl /= 2;
        }
        return ergebnis;
    }

    /** Liest sich die Zahl rueckwaerts genauso? 12321 ja, 123 nein. Nur nicht-negative Zahlen. */
    public static boolean istPalindromZahl(int zahl) {
        int rest = zahl;
        int umgedreht = 0;
        while (rest > 0) {
            umgedreht = umgedreht * 10 + rest % 10;
            rest /= 10;
        }
        return umgedreht == zahl;
    }

    /**
     * Ersetzt jedes Leerzeichen durch einen Unterstrich - mit einer Schleife, ohne {@code replace}.
     * {@code null} ergibt den leeren Text.
     */
    public static String ersetzeLeerzeichen(String text) {
        if (text == null) {
            return "";
        }
        String ergebnis = "";
        for (int i = 0; i < text.length(); i++) {
            char zeichen = text.charAt(i);
            ergebnis += (zeichen == ' ') ? '_' : zeichen;
        }
        return ergebnis;
    }

    /**
     * Wie viele Woerter enthaelt der Text? Woerter sind durch ein oder mehrere Leerzeichen
     * getrennt, auch am Anfang und Ende duerfen Leerzeichen stehen. {@code null} ergibt 0.
     *
     * <p>Tipp: Zaehle, wie oft ein Wort <i>beginnt</i> - also ein Nicht-Leerzeichen nach einem
     * Leerzeichen oder am Textanfang steht.
     */
    public static int zaehleWoerter(String text) {
        if (text == null) {
            return 0;
        }
        int anzahl = 0;
        boolean imWort = false;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                if (!imWort) {
                    anzahl++;
                    imWort = true;
                }
            } else {
                imWort = false;
            }
        }
        return anzahl;
    }

    /**
     * Collatz-Folge: Ist n gerade, halbiere es, sonst rechne 3 * n + 1. Wie viele Schritte
     * braucht es, bis 1 erreicht ist? (n ist mindestens 1.)
     *
     * <p>6 braucht 8 Schritte: 6, 3, 10, 5, 16, 8, 4, 2, 1. Hier passt {@code while}.
     */
    public static int collatzSchritte(int n) {
        int schritte = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            schritte++;
        }
        return schritte;
    }

    /** Der kleinste Teiler groesser als 1 (n ist mindestens 2). 15 ergibt 3, 13 ergibt 13. */
    public static int kleinsterTeiler(int n) {
        int teiler = 2;
        while (n % teiler != 0) {
            teiler++;
        }
        return teiler;
    }
}
