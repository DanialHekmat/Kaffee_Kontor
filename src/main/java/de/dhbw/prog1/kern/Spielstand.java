package de.dhbw.prog1.kern;

/**
 * Alles, was eine Strategie zu Beginn einer Runde ueber die Lage weiss.
 *
 * <p>Beachtet, was hier NICHT drinsteht: nichts ueber kuenftige Runden. Eine Strategie
 * entscheidet mit dem Wissen von heute, nicht mit dem von morgen. Genau deshalb ist das
 * Turnier ueberhaupt eine Herausforderung.
 *
 * <p><b>Und beachtet die Bauform.</b> Die Schnittstelle {@link Strategie} bekommt genau
 * einen Parameter: diesen Spielstand. Man haette auch sechs einzelne Zahlen uebergeben
 * koennen. Der Unterschied zeigt sich, sobald spaeter eine siebte Information dazukommt:
 * Ein zusaetzliches Attribut hier stoert keinen einzigen Bot. Ein zusaetzlicher Parameter
 * dagegen wuerde jede Strategie im Kurs auf einen Schlag unbrauchbar machen.
 *
 * <p>Diese Klasse gehoert zum Rahmenwerk und muss nicht veraendert werden.
 */
public class Spielstand {

    private int runde;
    private int kasseInCent;
    private int sackpreisInCent;
    private int saisonProzent;
    private int letzterVerkaufspreisInCent;
    private int letzteNachfrageInBechern;

    public Spielstand(int runde, int kasseInCent, int sackpreisInCent, int saisonProzent,
                      int letzterVerkaufspreisInCent, int letzteNachfrageInBechern) {
        this.runde = runde;
        this.kasseInCent = kasseInCent;
        this.sackpreisInCent = sackpreisInCent;
        this.saisonProzent = saisonProzent;
        this.letzterVerkaufspreisInCent = letzterVerkaufspreisInCent;
        this.letzteNachfrageInBechern = letzteNachfrageInBechern;
    }

    /** Die laufende Runde, beginnend bei 1. */
    public int runde() {
        return runde;
    }

    /** Kassenstand zu Rundenbeginn, in Cent. */
    public int kasseInCent() {
        return kasseInCent;
    }

    /** Was ein Sack Rohkaffee in dieser Runde kostet, in Cent. */
    public int sackpreisInCent() {
        return sackpreisInCent;
    }

    /**
     * Die Nachfragelage dieser Runde in Prozent.
     *
     * <p>100 bedeutet normal, mehr ist Hochsaison, weniger ist Flaute.
     */
    public int saisonProzent() {
        return saisonProzent;
    }

    /** Der Preis der Vorrunde, in Cent. In Runde 1 ist er 0. */
    public int letzterVerkaufspreisInCent() {
        return letzterVerkaufspreisInCent;
    }

    /** Wie viele Becher in der Vorrunde nachgefragt wurden. In Runde 1 ist es 0. */
    public int letzteNachfrageInBechern() {
        return letzteNachfrageInBechern;
    }

    /** Ist dies die erste Runde? Dann gibt es noch keine Vorrunde. */
    public boolean istErsteRunde() {
        return runde == 1;
    }

    @Override
    public String toString() {
        return "Runde " + runde
                + " | Kasse " + Geld.formatiere(kasseInCent)
                + " | Sack " + Geld.formatiere(sackpreisInCent)
                + " | Saison " + saisonProzent + "%";
    }
}
