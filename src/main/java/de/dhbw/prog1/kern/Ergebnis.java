package de.dhbw.prog1.kern;

/**
 * Das Abschneiden eines Bots im Turnier.
 *
 * <p>Diese Klasse gehoert zum Rahmenwerk und muss nicht veraendert werden.
 */
public class Ergebnis {

    private String name;
    private int endkasseInCent;
    private int gespielteRunden;

    public Ergebnis(String name, int endkasseInCent, int gespielteRunden) {
        this.name = name;
        this.endkasseInCent = endkasseInCent;
        this.gespielteRunden = gespielteRunden;
    }

    public String name() {
        return name;
    }

    public int endkasseInCent() {
        return endkasseInCent;
    }

    /** Wie viele Runden der Bot durchgehalten hat. Weniger als 30 heisst: Bankrott. */
    public int gespielteRunden() {
        return gespielteRunden;
    }

    public boolean istBankrott() {
        return gespielteRunden < Spielregeln.ANZAHL_RUNDEN;
    }

    @Override
    public String toString() {
        String zusatz = istBankrott()
                ? "  (bankrott in Runde " + gespielteRunden + ")"
                : "";

        return name + ": " + Geld.formatiere(endkasseInCent) + zusatz;
    }
}
