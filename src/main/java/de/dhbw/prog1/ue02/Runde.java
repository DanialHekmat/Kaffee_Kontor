package de.dhbw.prog1.ue02;

import de.dhbw.prog1.kern.Geld;
import de.dhbw.prog1.kern.Konsole;
import de.dhbw.prog1.kern.Markt;
import de.dhbw.prog1.kern.Spielregeln;

/**
 * Uebung 2 - Variablen, Datentypen, Konstanten und Rechnen.
 *
 * <p><b>So arbeitest du:</b> Ersetze jedes {@code TODO} durch deinen Code. Fuehre danach die
 * Tests aus ({@code KaffeeKontor > Tests ausfuehren}, oder auf der Kommandozeile
 * {@code mvn test}). Gruen heisst richtig. Du musst nichts abgeben, bevor alles gruen ist.
 *
 * <p>Alle Geldbetraege sind {@code int} in <b>Cent</b>. Niemals {@code double} - warum,
 * steht in {@link Geld}.
 */
public class Runde {

    // =================================================================================
    //  STUFE 1 - BASIS
    //  Diese beiden Methoden sind je eine Zeile. Ziel: der erste gruene Test.
    // =================================================================================

    /**
     * Was kostet der Einkauf?
     *
     * <p>Beispiel: 10 Saecke zu je 28,00 EUR (= 2800 Cent) kosten 280,00 EUR (= 28000 Cent).
     *
     * @param anzahlSaecke        Anzahl gekaufter Saecke Rohkaffee
     * @param preisProSackInCent  aktueller Marktpreis je Sack, in Cent
     * @return Gesamtkosten des Einkaufs in Cent
     */
    public static int einkaufskosten(int anzahlSaecke, int preisProSackInCent) {
        int x = anzahlSaecke * preisProSackInCent;
        return x;
    }

    /**
     * Was kommt in die Kasse?
     *
     * <p>Beispiel: 400 Becher zu je 3,00 EUR (= 300 Cent) ergeben 1.200,00 EUR (= 120000 Cent).
     *
     * @param verkaufteBecher       Anzahl tatsaechlich verkaufter Becher
     * @param preisProBecherInCent  gesetzter Verkaufspreis je Becher, in Cent
     * @return Erloes in Cent
     */
    public static int erloes(int verkaufteBecher, int preisProBecherInCent) {
        int e = verkaufteBecher * preisProBecherInCent;
        return e;
    }


    // =================================================================================
    //  STUFE 2 - KERN
    //  Das ist der Stoff, den du fuer die Klausur koennen musst.
    // =================================================================================

    /**
     * Wie viele Becher lassen sich aus den geroesteten Saecken zubereiten?
     *
     * <p>Benutze die Konstante {@link Spielregeln#BECHER_PRO_SACK} statt die Zahl 80 direkt
     * hinzuschreiben. Falls die Roesterei die Menge je Sack irgendwann aendert, muss der Wert
     * dann nur an einer einzigen Stelle angepasst werden.
     *
     * @param anzahlSaecke Anzahl geroesteter Saecke
     * @return Anzahl verfuegbarer Becher
     */
    public static int bechervorrat(int anzahlSaecke) {
        int b = Spielregeln.BECHER_PRO_SACK * anzahlSaecke;
        return b;
    }

    /**
     * Wie viele Becher werden wirklich verkauft?
     *
     * <p>Verkauft wird der kleinere der beiden Werte: Man kann nicht mehr verkaufen, als
     * nachgefragt wird - und auch nicht mehr, als man vorraetig hat.
     *
     * <p>Tipp: {@code Math.min(a, b)} liefert den kleineren von zwei Werten. Java bringt
     * eine Menge solcher fertigen Werkzeuge mit; sie selbst nachzubauen waere Zeitverschwendung.
     *
     * @param bechervorrat verfuegbare Becher
     * @param nachfrage    nachgefragte Becher
     * @return tatsaechlich verkaufte Becher
     */
    public static int verkaufteBecher(int bechervorrat, int nachfrage) {
        int s = Math.min(bechervorrat, nachfrage);
        return s;
    }

    /**
     * Was kostet der Rohkaffee fuer einen einzelnen Becher?
     *
     * <p><b>Achtung, hier ist eine Falle eingebaut.</b> Ein Sack zu 35,00 EUR ergibt 80 Becher.
     * 3500 geteilt durch 80 sind rechnerisch 43,75 Cent. Java rechnet mit zwei ganzen Zahlen
     * aber auch ganzzahlig und liefert <b>43</b> - der Rest wird ersatzlos abgeschnitten,
     * nicht gerundet.
     *
     * <p>Das ist hier ausdruecklich gewollt und richtig so: Wir kalkulieren vorsichtig.
     * Wichtig ist, dass du es <i>weisst</i>. Ganzzahldivision ist eine der haeufigsten
     * Fehlerquellen fuer Anfaenger, und sie faellt nicht auf, weil das Programm nicht abstuerzt -
     * es rechnet nur leise falsch.
     *
     * @param preisProSackInCent Marktpreis je Sack, in Cent
     * @return Rohstoffkosten je Becher, in Cent, abgerundet
     */
    public static int rohstoffkostenProBecherInCent(int preisProSackInCent) {
        int k = preisProSackInCent / Spielregeln.BECHER_PRO_SACK;
        return k;
    }

    /**
     * Der Deckungsbeitrag je Becher: Verkaufspreis minus Rohstoffkosten.
     *
     * <p>Das ist der Betrag, den jeder verkaufte Becher zur Deckung der Fixkosten beitraegt.
     * Er sagt noch nichts ueber Gewinn aus - erst wenn genug Becher verkauft sind, um die
     * Fixkosten zu decken, wird aus dem Deckungsbeitrag Gewinn.
     *
     * <p>Tipp: Du hast oben schon eine Methode geschrieben, die die Rohstoffkosten berechnet.
     * Rufe sie hier auf, statt die Rechnung ein zweites Mal hinzuschreiben. Wenn dieselbe
     * Rechnung an zwei Stellen steht, wird eines Tages nur eine davon korrigiert.
     *
     * @param verkaufspreisInCent Verkaufspreis je Becher, in Cent
     * @param preisProSackInCent  Marktpreis je Sack, in Cent
     * @return Deckungsbeitrag je Becher, in Cent
     */
    public static int deckungsbeitragProBecherInCent(int verkaufspreisInCent,
                                                     int preisProSackInCent) {
        int db = verkaufspreisInCent - rohstoffkostenProBecherInCent(preisProSackInCent);
        return db;
    }

    /**
     * Der Kassenstand am Ende der Runde.
     *
     * <p>Rechnung: Kasse vorher, minus Einkauf, plus Erloes, minus Fixkosten
     * ({@link Spielregeln#FIXKOSTEN_PRO_RUNDE_CENT}), minus Lagerkosten fuer jeden Sack, der
     * am Rundenende noch ungeroestet im Lager liegt
     * ({@link Spielregeln#LAGERKOSTEN_PRO_SACK_CENT} je Sack).
     *
     * @param kasseVorherInCent      Kassenstand zu Rundenbeginn
     * @param einkaufskostenInCent   Kosten des Einkaufs dieser Runde
     * @param erloesInCent           Erloes dieser Runde
     * @param saeckeImLager          Saecke, die am Rundenende noch im Lager liegen
     * @return Kassenstand am Rundenende, in Cent
     */
    public static int kassenstandNachRunde(int kasseVorherInCent,
                                           int einkaufskostenInCent,
                                           int erloesInCent,
                                           int saeckeImLager) {
        int kassenstand = kasseVorherInCent - einkaufskostenInCent + erloesInCent - Spielregeln.FIXKOSTEN_PRO_RUNDE_CENT - (saeckeImLager* Spielregeln.LAGERKOSTEN_PRO_SACK_CENT);
        return kassenstand;
    }


    // =================================================================================
    //  STUFE 3 - KUER
    //  Ohne Tests, ohne Musterloesung. Fuer alle, die schneller fertig sind.
    // =================================================================================

    /**
     * Spielt eine einzelne Runde interaktiv durch und gibt einen Rundenbericht aus.
     *
     * <p><b>Aufgabe:</b> Frage Runde, Anzahl Saecke und Verkaufspreis ab, berechne mit deinen
     * Methoden von oben das Ergebnis und gib einen sauberen Bericht aus. Nutze dafuer
     * {@link Konsole} (Eingabe) und {@link Geld#formatiere(int)} (Ausgabe von Betraegen).
     *
     * <p>Den Marktpreis der Runde liefert {@link Markt#preisProSackInCent(int)}, die Nachfrage
     * beim gewaehlten Preis {@link Markt#nachfrageInBechern(int, int)}.
     *
     * <p><b>Und dann die eigentliche Frage:</b> Probiere in Runde 1 verschiedene Verkaufspreise
     * durch - 2,00 EUR, 2,50 EUR, 3,00 EUR, 3,50 EUR. Bei welchem Preis verdienst du am meisten?
     * Ist der hoechste Preis auch der beste? Notiere deine Beobachtung, wir besprechen sie
     * naechste Woche.
     */
    public static void spieleEineRunde() {
        /*Konsole.frageGanzeZahl("Runde", 1,Spielregeln.ANZAHL_RUNDEN);
        Konsole.frageGanzeZahl("Anzahl von Saecke", 1, Spielregeln.ROESTKAPAZITAET_SAECKE_PRO_RUNDE);
        int vP = Konsole.frageBetragInCent("Verkaufspreis");

        int aktuelleRunde = 1;

        int preisProSack = Markt.preisProSackInCent(aktuelleRunde);
        int nachfrage = Markt.nachfrageInBechern(aktuelleRunde, vP);

        System.out.println(preisProSack);
        System.out.println(nachfrage);

        aktuelleRunde++;

        System.out.println(aktuelleRunde);*/

        Konsole.zeige("Noch nicht gebaut - das ist die Kueraufgabe.");
    }

    public static void main(String[] args) {
        spieleEineRunde();
    }
}
