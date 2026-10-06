package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/**
 * Training 5 - Arrays.
 *
 * <p>Einheitliche Regel fuer alle Aufgaben: {@code null} wird behandelt wie ein leeres Array.
 *
 * <p>Passt zu Einheit 6. Pruefe dich mit {@code T05ArraysTest}.
 */
public class T05Arrays {

    /** Summe aller Werte. Leer ergibt 0. */
    public static int summe(int[] werte) {
        if (werte == null) {
            return 0;
        }
        int summe = 0;
        for (int wert : werte) {
            summe += wert;
        }
        return summe;
    }

    /**
     * Der groesste Wert. Leer ergibt 0.
     *
     * <p>Achtung: Auch wenn alle Werte negativ sind, muss der groesste herauskommen.
     */
    public static int maximum(int[] werte) {
        if (werte == null || werte.length == 0) {
            return 0;
        }
        int groesster = werte[0];
        for (int wert : werte) {
            if (wert > groesster) {
                groesster = wert;
            }
        }
        return groesster;
    }

    /** Position des ersten Vorkommens, oder -1 wenn nicht enthalten. */
    public static int indexVon(int[] werte, int gesucht) {
        if (werte == null) {
            return -1;
        }
        for (int i = 0; i < werte.length; i++) {
            if (werte[i] == gesucht) {
                return i;
            }
        }
        return -1;
    }

    /** Wie viele Werte sind echt groesser als die Grenze? */
    public static int anzahlGroesserAls(int[] werte, int grenze) {
        if (werte == null) {
            return 0;
        }
        int anzahl = 0;
        for (int wert : werte) {
            if (wert > grenze) {
                anzahl++;
            }
        }
        return anzahl;
    }

    /** Neues Array mit allen Werten verdoppelt. Das Original bleibt unveraendert. */
    public static int[] verdoppelt(int[] werte) {
        if (werte == null) {
            return new int[0];
        }
        int[] ergebnis = new int[werte.length];
        for (int i = 0; i < werte.length; i++) {
            ergebnis[i] = werte[i] * 2;
        }
        return ergebnis;
    }

    /** Neues Array in umgekehrter Reihenfolge. Das Original bleibt unveraendert. */
    public static int[] umgekehrt(int[] werte) {
        if (werte == null) {
            return new int[0];
        }
        int[] ergebnis = new int[werte.length];
        for (int i = 0; i < werte.length; i++) {
            ergebnis[i] = werte[werte.length - 1 - i];
        }
        return ergebnis;
    }

    /** Ist das Array aufsteigend sortiert? Gleiche Nachbarn sind erlaubt. Leer gilt als sortiert. */
    public static boolean istSortiert(int[] werte) {
        if (werte == null) {
            return true;
        }
        for (int i = 1; i < werte.length; i++) {
            if (werte[i] < werte[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Die ersten n Werte als neues Array.
     *
     * <p>Ist n groesser als die Laenge, kommen alle Werte zurueck. Ist n 0 oder negativ, ein
     * leeres Array.
     */
    public static int[] ersteN(int[] werte, int n) {
        if (werte == null || n <= 0) {
            return new int[0];
        }
        int anzahl = Math.min(n, werte.length);
        int[] ergebnis = new int[anzahl];
        for (int i = 0; i < anzahl; i++) {
            ergebnis[i] = werte[i];
        }
        return ergebnis;
    }

    /**
     * Summe der Hauptdiagonale einer quadratischen Matrix: {@code matrix[0][0] + matrix[1][1] + ...}
     */
    public static int summeDiagonale(int[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        int summe = 0;
        for (int i = 0; i < matrix.length; i++) {
            summe += matrix[i][i];
        }
        return summe;
    }

    // =================================================================================
    //  WEITERE AUFGABEN
    // =================================================================================

    /** Der kleinste Wert. Leer ergibt 0. */
    public static int minimum(int[] werte) {
        if (werte == null || werte.length == 0) {
            return 0;
        }
        int kleinster = werte[0];
        for (int wert : werte) {
            if (wert < kleinster) {
                kleinster = wert;
            }
        }
        return kleinster;
    }

    /** Der Durchschnitt mit Nachkommastellen. Leer ergibt 0.0. */
    public static double durchschnitt(int[] werte) {
        if (werte == null || werte.length == 0) {
            return 0.0;
        }
        return (double) summe(werte) / werte.length;
    }

    /** Wie oft kommt der gesuchte Wert vor? */
    public static int anzahlVorkommen(int[] werte, int gesucht) {
        if (werte == null) {
            return 0;
        }
        int anzahl = 0;
        for (int wert : werte) {
            if (wert == gesucht) {
                anzahl++;
            }
        }
        return anzahl;
    }

    /** Ist der Wert enthalten? */
    public static boolean enthaelt(int[] werte, int gesucht) {
        return indexVon(werte, gesucht) >= 0;
    }

    /** Position des letzten Vorkommens, oder -1. Tipp: Laufe von hinten nach vorn. */
    public static int letzterIndexVon(int[] werte, int gesucht) {
        if (werte == null) {
            return -1;
        }
        for (int i = werte.length - 1; i >= 0; i--) {
            if (werte[i] == gesucht) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Der zweitgroesste Wert. Gleiche Werte zaehlen einzeln: Bei {5, 5, 3} ist er 5.
     * Weniger als zwei Werte ergeben 0.
     */
    public static int zweitgroesster(int[] werte) {
        if (werte == null || werte.length < 2) {
            return 0;
        }
        int groesster = Math.max(werte[0], werte[1]);
        int zweiter = Math.min(werte[0], werte[1]);
        for (int i = 2; i < werte.length; i++) {
            if (werte[i] > groesster) {
                zweiter = groesster;
                groesster = werte[i];
            } else if (werte[i] > zweiter) {
                zweiter = werte[i];
            }
        }
        return zweiter;
    }

    /**
     * Vertauscht zwei Werte <b>im uebergebenen Array</b>. Diese Methode liefert nichts zurueck -
     * sie veraendert das Array selbst. Die Positionen sind immer gueltig.
     */
    public static void vertausche(int[] werte, int i, int j) {
        int merker = werte[i];
        werte[i] = werte[j];
        werte[j] = merker;
    }

    /**
     * Addiert zwei Arrays Position fuer Position zu einem neuen Array. Sind sie unterschiedlich
     * lang, zaehlt das kuerzere. {1, 2, 3} und {10, 20} ergeben {11, 22}.
     */
    public static int[] addiere(int[] a, int[] b) {
        if (a == null || b == null) {
            return new int[0];
        }
        int laenge = Math.min(a.length, b.length);
        int[] ergebnis = new int[laenge];
        for (int i = 0; i < laenge; i++) {
            ergebnis[i] = a[i] + b[i];
        }
        return ergebnis;
    }

    /**
     * Neues Array nur mit den positiven Werten (0 zaehlt nicht dazu), in der urspruenglichen
     * Reihenfolge. Tipp: Erst zaehlen, dann ein Array passender Groesse anlegen.
     */
    public static int[] nurPositive(int[] werte) {
        if (werte == null) {
            return new int[0];
        }
        int anzahl = anzahlGroesserAls(werte, 0);
        int[] ergebnis = new int[anzahl];
        int position = 0;
        for (int wert : werte) {
            if (wert > 0) {
                ergebnis[position] = wert;
                position++;
            }
        }
        return ergebnis;
    }

    /** Die Summe jeder Zeile einer Matrix, als neues Array. Zeilen duerfen unterschiedlich lang sein. */
    public static int[] zeilensummen(int[][] matrix) {
        if (matrix == null) {
            return new int[0];
        }
        int[] ergebnis = new int[matrix.length];
        for (int zeile = 0; zeile < matrix.length; zeile++) {
            ergebnis[zeile] = summe(matrix[zeile]);
        }
        return ergebnis;
    }

    /** Der groesste Wert einer Matrix. Leer oder {@code null} ergibt 0. */
    public static int maximumInMatrix(int[][] matrix) {
        if (matrix == null) {
            return 0;
        }
        boolean gefunden = false;
        int groesster = 0;
        for (int[] zeile : matrix) {
            for (int wert : zeile) {
                if (!gefunden || wert > groesster) {
                    groesster = wert;
                    gefunden = true;
                }
            }
        }
        return groesster;
    }
}
