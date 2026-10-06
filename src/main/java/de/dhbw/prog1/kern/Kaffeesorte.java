package de.dhbw.prog1.kern;

/**
 * Eine Kaffeesorte - ab Einheit 9 Teil des Rahmenwerks.
 *
 * <p>Das ist die Klasse, die ihr in Einheit 8 gebaut habt, um zwei Abfragemethoden ergaenzt.
 * Sie ist ins Rahmenwerk gewandert, damit alle darauf aufbauen koennen - unabhaengig davon,
 * wie weit die eigene Uebung 8 gediehen ist.
 *
 * <p><b>Nicht verwechseln:</b> Eure eigene Fassung steht weiterhin in
 * {@code de.dhbw.prog1.ue08.Kaffeesorte} und bleibt dort. Geaendert wird nur die dort,
 * nie diese hier.
 *
 * <p>Diese Klasse gehoert zum Rahmenwerk und muss nicht veraendert werden.
 */
public class Kaffeesorte {

    private String name;
    private int einkaufspreisProSackInCent;

    public Kaffeesorte(String name, int einkaufspreisProSackInCent) {
        this.name = name;
        this.einkaufspreisProSackInCent = einkaufspreisProSackInCent;
    }

    /** Der Name dieser Sorte. */
    public String name() {
        return name;
    }

    /**
     * Der Einkaufspreis je Sack in Cent.
     *
     * <p>Diese Abfragemethode gab es in Einheit 8 noch nicht - und das war richtig so:
     * Damals brauchte sie niemand. Jetzt gibt es {@code Sortiment}, und das muss Sorten
     * nach Preis vergleichen koennen, ohne selbst eine Kaffeesorte zu sein. Deshalb kommt
     * die Methode jetzt dazu.
     *
     * <p>Das ist die Regel fuer Abfragemethoden: Man baut sie ein, wenn jemand sie
     * tatsaechlich braucht - nicht vorsorglich fuer jedes Attribut.
     */
    public int einkaufspreisProSackInCent() {
        return einkaufspreisProSackInCent;
    }

    /** Rohstoffkosten je Becher in Cent, abgerundet. */
    public int kostenProBecherInCent() {
        return einkaufspreisProSackInCent / Spielregeln.BECHER_PRO_SACK;
    }

    /** Deckungsbeitrag je Becher bei diesem Verkaufspreis. */
    public int deckungsbeitragInCent(int verkaufspreisInCent) {
        return verkaufspreisInCent - kostenProBecherInCent();
    }

    /** Ist diese Sorte im Einkauf teurer als die andere? */
    public boolean istTeurerAls(Kaffeesorte andere) {
        return einkaufspreisProSackInCent > andere.einkaufspreisProSackInCent;
    }

    @Override
    public String toString() {
        return name + ": "
                + Geld.formatiere(einkaufspreisProSackInCent) + " je Sack, "
                + kostenProBecherInCent() + " ct je Becher";
    }
}
