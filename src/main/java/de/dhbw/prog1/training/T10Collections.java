package de.dhbw.prog1.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Training 10 - Collections.
 *
 * <p>Alle Methoden, die eine Sammlung liefern, liefern eine <b>neue</b> - die uebergebene
 * bleibt unveraendert. {@code null} wird behandelt wie eine leere Liste.
 *
 * <p>Passt zu Einheit 13. Pruefe dich mit {@code T10CollectionsTest}.
 */
public class T10Collections {

    /** Summe aller Zahlen. */
    public static int summe(List<Integer> zahlen) {
        // TODO
        return 0;
    }

    /** Neue Liste mit den geraden Zahlen, in der urspruenglichen Reihenfolge. */
    public static List<Integer> geradeZahlen(List<Integer> zahlen) {
        // TODO
        return new ArrayList<>();
    }

    /** Die Woerter ohne Doppelte, als Menge. */
    public static Set<String> ohneDoppelte(List<String> woerter) {
        // TODO
        return new HashSet<>();
    }

    /** Wie viele verschiedene Zahlen enthaelt die Liste? */
    public static int anzahlVerschiedene(List<Integer> zahlen) {
        // TODO
        return 0;
    }

    /** Kommt irgendein Wort mehrfach vor? */
    public static boolean enthaeltDoppelte(List<String> woerter) {
        // TODO
        return false;
    }

    /** Wie oft kommt jedes Wort vor? Beispiel: [a, b, a] ergibt {a=2, b=1}. */
    public static Map<String, Integer> haeufigkeiten(List<String> woerter) {
        // TODO
        return new HashMap<>();
    }

    /**
     * Das haeufigste Wort. Bei Gleichstand das, das in der Liste zuerst vorkommt.
     * Leere Liste ergibt {@code null}.
     *
     * <p>Tipp: Benutze {@link #haeufigkeiten(List)} - und laufe dann in Listenreihenfolge.
     */
    public static String haeufigstesWort(List<String> woerter) {
        // TODO
        return null;
    }

    /** Neue Liste, aufsteigend nach Wortlaenge sortiert; gleich lange behalten ihre Reihenfolge. */
    public static List<String> sortiertNachLaenge(List<String> woerter) {
        // TODO
        return new ArrayList<>();
    }

    /**
     * Woerter aus a, die auch in b vorkommen - in der Reihenfolge von a und jedes nur einmal.
     *
     * <p>Beispiel: a = [x, y, x, z], b = [z, x] ergibt [x, z].
     */
    public static List<String> gemeinsame(List<String> a, List<String> b) {
        // TODO
        return new ArrayList<>();
    }

    // =================================================================================
    //  WEITERE AUFGABEN
    // =================================================================================

    /** Die Liste in umgekehrter Reihenfolge, als neue Liste. */
    public static List<String> umgekehrt(List<String> woerter) {
        // TODO
        return new ArrayList<>();
    }

    /**
     * Ohne Doppelte, aber in der Reihenfolge des ersten Auftretens - als Liste.
     *
     * <p>Tipp: Ein {@code LinkedHashSet} merkt sich die Einfuegereihenfolge.
     */
    public static List<String> ohneDoppelteGeordnet(List<String> woerter) {
        // TODO
        return new ArrayList<>();
    }

    /** Zu jedem Wort seine Laenge, in derselben Reihenfolge. */
    public static List<Integer> laengen(List<String> woerter) {
        // TODO
        return new ArrayList<>();
    }

    /** Die groesste Zahl - oder {@code null}, wenn die Liste leer ist. Darum {@code Integer} statt {@code int}. */
    public static Integer groessteZahl(List<Integer> zahlen) {
        // TODO
        return null;
    }

    /** Wie viele Woerter sind laenger als (echt groesser) die angegebene Laenge? */
    public static int zaehleLaengerAls(List<String> woerter, int laenge) {
        // TODO
        return 0;
    }

    /**
     * Gruppiert die Woerter nach ihrem ersten Buchstaben: {@code "Apfel", "Birne", "Aprikose"}
     * ergibt {@code {A=[Apfel, Aprikose], B=[Birne]}}. Leere Woerter werden uebersprungen.
     *
     * <p>Tipp: Gibt es zum Buchstaben noch keine Liste, lege eine neue an und lege sie ab.
     */
    public static Map<Character, List<String>> nachAnfangsbuchstabe(List<String> woerter) {
        // TODO
        return new HashMap<>();
    }

    /** Alle Elemente, die in a oder b (oder beiden) sind - als neue Menge. */
    public static Set<String> vereinigung(Set<String> a, Set<String> b) {
        // TODO
        return new HashSet<>();
    }

    /** Alle Elemente, die in a und in b sind - als neue Menge. a und b bleiben unveraendert. */
    public static Set<String> schnittmenge(Set<String> a, Set<String> b) {
        // TODO
        return new HashSet<>();
    }

    /** Die Summe aller Werte einer Map, z. B. aller Lagerbestaende. */
    public static int summeDerWerte(Map<String, Integer> bestand) {
        // TODO
        return 0;
    }

    /**
     * Alle Schluessel, deren Wert echt groesser als die Grenze ist - alphabetisch sortiert.
     *
     * <p>Eine {@code HashMap} hat keine Reihenfolge. Deshalb sortierst du das Ergebnis.
     */
    public static List<String> schluesselMitWertUeber(Map<String, Integer> bestand, int grenze) {
        // TODO
        return new ArrayList<>();
    }

    /**
     * Die <b>einzige</b> Methode hier, die die uebergebene Liste veraendert: Sie entfernt alle
     * Woerter, die kuerzer als minLaenge sind.
     *
     * <p>Achtung: {@code remove} innerhalb einer for-each-Schleife fuehrt zu einer
     * {@code ConcurrentModificationException}. Tipp: {@code removeIf} oder ein {@code Iterator}.
     */
    public static void entferneKurze(List<String> woerter, int minLaenge) {
        // TODO
    }
}
