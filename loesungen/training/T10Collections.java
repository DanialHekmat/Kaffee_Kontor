package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

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
        if (zahlen == null) {
            return 0;
        }
        int summe = 0;
        for (int zahl : zahlen) {
            summe += zahl;
        }
        return summe;
    }

    /** Neue Liste mit den geraden Zahlen, in der urspruenglichen Reihenfolge. */
    public static List<Integer> geradeZahlen(List<Integer> zahlen) {
        List<Integer> ergebnis = new ArrayList<>();
        if (zahlen == null) {
            return ergebnis;
        }
        for (int zahl : zahlen) {
            if (zahl % 2 == 0) {
                ergebnis.add(zahl);
            }
        }
        return ergebnis;
    }

    /** Die Woerter ohne Doppelte, als Menge. */
    public static Set<String> ohneDoppelte(List<String> woerter) {
        if (woerter == null) {
            return new HashSet<>();
        }
        return new HashSet<>(woerter);
    }

    /** Wie viele verschiedene Zahlen enthaelt die Liste? */
    public static int anzahlVerschiedene(List<Integer> zahlen) {
        if (zahlen == null) {
            return 0;
        }
        return new HashSet<>(zahlen).size();
    }

    /** Kommt irgendein Wort mehrfach vor? */
    public static boolean enthaeltDoppelte(List<String> woerter) {
        if (woerter == null) {
            return false;
        }
        return new HashSet<>(woerter).size() < woerter.size();
    }

    /** Wie oft kommt jedes Wort vor? Beispiel: [a, b, a] ergibt {a=2, b=1}. */
    public static Map<String, Integer> haeufigkeiten(List<String> woerter) {
        Map<String, Integer> ergebnis = new HashMap<>();
        if (woerter == null) {
            return ergebnis;
        }
        for (String wort : woerter) {
            ergebnis.put(wort, ergebnis.getOrDefault(wort, 0) + 1);
        }
        return ergebnis;
    }

    /**
     * Das haeufigste Wort. Bei Gleichstand das, das in der Liste zuerst vorkommt.
     * Leere Liste ergibt {@code null}.
     *
     * <p>Tipp: Benutze {@link #haeufigkeiten(List)} - und laufe dann in Listenreihenfolge.
     */
    public static String haeufigstesWort(List<String> woerter) {
        if (woerter == null || woerter.isEmpty()) {
            return null;
        }
        Map<String, Integer> zaehlung = haeufigkeiten(woerter);
        String bestes = woerter.get(0);
        for (String wort : woerter) {
            if (zaehlung.get(wort) > zaehlung.get(bestes)) {
                bestes = wort;
            }
        }
        return bestes;
    }

    /** Neue Liste, aufsteigend nach Wortlaenge sortiert; gleich lange behalten ihre Reihenfolge. */
    public static List<String> sortiertNachLaenge(List<String> woerter) {
        List<String> ergebnis = new ArrayList<>();
        if (woerter == null) {
            return ergebnis;
        }
        ergebnis.addAll(woerter);
        ergebnis.sort((a, b) -> Integer.compare(a.length(), b.length()));
        return ergebnis;
    }

    /**
     * Woerter aus a, die auch in b vorkommen - in der Reihenfolge von a und jedes nur einmal.
     *
     * <p>Beispiel: a = [x, y, x, z], b = [z, x] ergibt [x, z].
     */
    public static List<String> gemeinsame(List<String> a, List<String> b) {
        List<String> ergebnis = new ArrayList<>();
        if (a == null || b == null) {
            return ergebnis;
        }
        Set<String> inB = new HashSet<>(b);
        for (String wort : a) {
            if (inB.contains(wort) && !ergebnis.contains(wort)) {
                ergebnis.add(wort);
            }
        }
        return ergebnis;
    }

    // =================================================================================
    //  WEITERE AUFGABEN
    // =================================================================================

    /** Die Liste in umgekehrter Reihenfolge, als neue Liste. */
    public static List<String> umgekehrt(List<String> woerter) {
        List<String> ergebnis = new ArrayList<>();
        if (woerter == null) {
            return ergebnis;
        }
        for (int i = woerter.size() - 1; i >= 0; i--) {
            ergebnis.add(woerter.get(i));
        }
        return ergebnis;
    }

    /**
     * Ohne Doppelte, aber in der Reihenfolge des ersten Auftretens - als Liste.
     *
     * <p>Tipp: Ein {@code LinkedHashSet} merkt sich die Einfuegereihenfolge.
     */
    public static List<String> ohneDoppelteGeordnet(List<String> woerter) {
        if (woerter == null) {
            return new ArrayList<>();
        }
        return new ArrayList<>(new LinkedHashSet<>(woerter));
    }

    /** Zu jedem Wort seine Laenge, in derselben Reihenfolge. */
    public static List<Integer> laengen(List<String> woerter) {
        List<Integer> ergebnis = new ArrayList<>();
        if (woerter == null) {
            return ergebnis;
        }
        for (String wort : woerter) {
            ergebnis.add(wort.length());
        }
        return ergebnis;
    }

    /** Die groesste Zahl - oder {@code null}, wenn die Liste leer ist. Darum {@code Integer} statt {@code int}. */
    public static Integer groessteZahl(List<Integer> zahlen) {
        if (zahlen == null || zahlen.isEmpty()) {
            return null;
        }
        int groesste = zahlen.get(0);
        for (int zahl : zahlen) {
            groesste = Math.max(groesste, zahl);
        }
        return groesste;
    }

    /** Wie viele Woerter sind laenger als (echt groesser) die angegebene Laenge? */
    public static int zaehleLaengerAls(List<String> woerter, int laenge) {
        if (woerter == null) {
            return 0;
        }
        int anzahl = 0;
        for (String wort : woerter) {
            if (wort.length() > laenge) {
                anzahl++;
            }
        }
        return anzahl;
    }

    /**
     * Gruppiert die Woerter nach ihrem ersten Buchstaben: {@code "Apfel", "Birne", "Aprikose"}
     * ergibt {@code {A=[Apfel, Aprikose], B=[Birne]}}. Leere Woerter werden uebersprungen.
     *
     * <p>Tipp: Gibt es zum Buchstaben noch keine Liste, lege eine neue an und lege sie ab.
     */
    public static Map<Character, List<String>> nachAnfangsbuchstabe(List<String> woerter) {
        Map<Character, List<String>> gruppen = new HashMap<>();
        if (woerter == null) {
            return gruppen;
        }
        for (String wort : woerter) {
            if (wort.isEmpty()) {
                continue;
            }
            char buchstabe = wort.charAt(0);
            List<String> gruppe = gruppen.get(buchstabe);
            if (gruppe == null) {
                gruppe = new ArrayList<>();
                gruppen.put(buchstabe, gruppe);
            }
            gruppe.add(wort);
        }
        return gruppen;
    }

    /** Alle Elemente, die in a oder b (oder beiden) sind - als neue Menge. */
    public static Set<String> vereinigung(Set<String> a, Set<String> b) {
        Set<String> ergebnis = new HashSet<>(a);
        ergebnis.addAll(b);
        return ergebnis;
    }

    /** Alle Elemente, die in a und in b sind - als neue Menge. a und b bleiben unveraendert. */
    public static Set<String> schnittmenge(Set<String> a, Set<String> b) {
        Set<String> ergebnis = new HashSet<>(a);
        ergebnis.retainAll(b);
        return ergebnis;
    }

    /** Die Summe aller Werte einer Map, z. B. aller Lagerbestaende. */
    public static int summeDerWerte(Map<String, Integer> bestand) {
        if (bestand == null) {
            return 0;
        }
        int summe = 0;
        for (int wert : bestand.values()) {
            summe += wert;
        }
        return summe;
    }

    /**
     * Alle Schluessel, deren Wert echt groesser als die Grenze ist - alphabetisch sortiert.
     *
     * <p>Eine {@code HashMap} hat keine Reihenfolge. Deshalb sortierst du das Ergebnis.
     */
    public static List<String> schluesselMitWertUeber(Map<String, Integer> bestand, int grenze) {
        List<String> ergebnis = new ArrayList<>();
        if (bestand == null) {
            return ergebnis;
        }
        for (Map.Entry<String, Integer> eintrag : bestand.entrySet()) {
            if (eintrag.getValue() > grenze) {
                ergebnis.add(eintrag.getKey());
            }
        }
        ergebnis.sort(null);
        return ergebnis;
    }

    /**
     * Die <b>einzige</b> Methode hier, die die uebergebene Liste veraendert: Sie entfernt alle
     * Woerter, die kuerzer als minLaenge sind.
     *
     * <p>Achtung: {@code remove} innerhalb einer for-each-Schleife fuehrt zu einer
     * {@code ConcurrentModificationException}. Tipp: {@code removeIf} oder ein {@code Iterator}.
     */
    public static void entferneKurze(List<String> woerter, int minLaenge) {
        woerter.removeIf(wort -> wort.length() < minLaenge);
    }
}
