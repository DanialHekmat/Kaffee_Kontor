package de.dhbw.prog1.training;

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
        // TODO
        return 0;
    }

    /**
     * Der groesste Wert. Leer ergibt 0.
     *
     * <p>Achtung: Auch wenn alle Werte negativ sind, muss der groesste herauskommen.
     */
    public static int maximum(int[] werte) {
        // TODO
        return 0;
    }

    /** Position des ersten Vorkommens, oder -1 wenn nicht enthalten. */
    public static int indexVon(int[] werte, int gesucht) {
        // TODO
        return 0;
    }

    /** Wie viele Werte sind echt groesser als die Grenze? */
    public static int anzahlGroesserAls(int[] werte, int grenze) {
        // TODO
        return 0;
    }

    /** Neues Array mit allen Werten verdoppelt. Das Original bleibt unveraendert. */
    public static int[] verdoppelt(int[] werte) {
        // TODO
        return new int[0];
    }

    /** Neues Array in umgekehrter Reihenfolge. Das Original bleibt unveraendert. */
    public static int[] umgekehrt(int[] werte) {
        // TODO
        return new int[0];
    }

    /** Ist das Array aufsteigend sortiert? Gleiche Nachbarn sind erlaubt. Leer gilt als sortiert. */
    public static boolean istSortiert(int[] werte) {
        // TODO
        return false;
    }

    /**
     * Die ersten n Werte als neues Array.
     *
     * <p>Ist n groesser als die Laenge, kommen alle Werte zurueck. Ist n 0 oder negativ, ein
     * leeres Array.
     */
    public static int[] ersteN(int[] werte, int n) {
        // TODO
        return new int[0];
    }

    /**
     * Summe der Hauptdiagonale einer quadratischen Matrix: {@code matrix[0][0] + matrix[1][1] + ...}
     */
    public static int summeDiagonale(int[][] matrix) {
        // TODO
        return 0;
    }

    // =================================================================================
    //  WEITERE AUFGABEN
    // =================================================================================

    /** Der kleinste Wert. Leer ergibt 0. */
    public static int minimum(int[] werte) {
        // TODO
        return 0;
    }

    /** Der Durchschnitt mit Nachkommastellen. Leer ergibt 0.0. */
    public static double durchschnitt(int[] werte) {
        // TODO
        return 0.0;
    }

    /** Wie oft kommt der gesuchte Wert vor? */
    public static int anzahlVorkommen(int[] werte, int gesucht) {
        // TODO
        return 0;
    }

    /** Ist der Wert enthalten? */
    public static boolean enthaelt(int[] werte, int gesucht) {
        // TODO
        return false;
    }

    /** Position des letzten Vorkommens, oder -1. Tipp: Laufe von hinten nach vorn. */
    public static int letzterIndexVon(int[] werte, int gesucht) {
        // TODO
        return 0;
    }

    /**
     * Der zweitgroesste Wert. Gleiche Werte zaehlen einzeln: Bei {5, 5, 3} ist er 5.
     * Weniger als zwei Werte ergeben 0.
     */
    public static int zweitgroesster(int[] werte) {
        // TODO
        return 0;
    }

    /**
     * Vertauscht zwei Werte <b>im uebergebenen Array</b>. Diese Methode liefert nichts zurueck -
     * sie veraendert das Array selbst. Die Positionen sind immer gueltig.
     */
    public static void vertausche(int[] werte, int i, int j) {
        // TODO
    }

    /**
     * Addiert zwei Arrays Position fuer Position zu einem neuen Array. Sind sie unterschiedlich
     * lang, zaehlt das kuerzere. {1, 2, 3} und {10, 20} ergeben {11, 22}.
     */
    public static int[] addiere(int[] a, int[] b) {
        // TODO
        return new int[0];
    }

    /**
     * Neues Array nur mit den positiven Werten (0 zaehlt nicht dazu), in der urspruenglichen
     * Reihenfolge. Tipp: Erst zaehlen, dann ein Array passender Groesse anlegen.
     */
    public static int[] nurPositive(int[] werte) {
        // TODO
        return new int[0];
    }

    /** Die Summe jeder Zeile einer Matrix, als neues Array. Zeilen duerfen unterschiedlich lang sein. */
    public static int[] zeilensummen(int[][] matrix) {
        // TODO
        return new int[0];
    }

    /** Der groesste Wert einer Matrix. Leer oder {@code null} ergibt 0. */
    public static int maximumInMatrix(int[][] matrix) {
        // TODO
        return 0;
    }
}
