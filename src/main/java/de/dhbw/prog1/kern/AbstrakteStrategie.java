package de.dhbw.prog1.kern;

/**
 * Eine halbfertige Strategie - Bequemlichkeit fuer alle, die einen Bot bauen.
 *
 * <p>Jeder Bot braucht einen Namen, und jeder Bot moechte seinen Preis im erlaubten Bereich
 * halten. Das ist bei allen gleich, und es waere unsinnig, es dreissigmal abzuschreiben.
 * Also steht es hier - einmal.
 *
 * <p><b>Was eine abstrakte Klasse ist:</b> eine Klasse, von der es keine Objekte gibt.
 * {@code new AbstrakteStrategie(...)} ist verboten, und der Compiler sagt es deutlich.
 * Sie ist unfertig, und das mit Absicht: Die Methode
 * {@link #verkaufspreisFuerRunde(Spielstand)} hat hier keinen Rumpf, sondern nur einen Kopf
 * mit dem Wort {@code abstract} davor. Wer von dieser Klasse erbt, <b>muss</b> sie
 * ausfuellen - sonst ist auch die Unterklasse noch unfertig und der Compiler beschwert sich.
 *
 * <p><b>Interface oder abstrakte Klasse?</b> Die Faustregel:
 * <ul>
 *   <li>Ein <b>Interface</b> beschreibt, <i>was</i> jemand koennen muss. Es teilt kein
 *       Verhalten und keine Attribute. Man kann beliebig viele davon erfuellen.</li>
 *   <li>Eine <b>abstrakte Klasse</b> beschreibt zusaetzlich, <i>wie</i> ein Teil davon
 *       geht - sie bringt fertigen Code und Attribute mit. Erben kann man aber nur von
 *       einer einzigen.</li>
 * </ul>
 * Hier gibt es beides, und das ist ein gaengiges Gespann: das Interface als Vertrag nach
 * aussen, die abstrakte Klasse als Starthilfe fuer die, die ihn erfuellen wollen.
 *
 * <p>Ihr duerft diese Klasse benutzen - muesst aber nicht. Wer lieber direkt
 * {@code implements Strategie} schreibt, darf das; dann kuemmert er sich eben selbst um
 * Namen und Grenzen.
 *
 * <p>Diese Klasse gehoert zum Rahmenwerk und muss nicht veraendert werden.
 */
public abstract class AbstrakteStrategie implements Strategie {

    /** Kleinster im Turnier erlaubter Verkaufspreis: 1 Cent. */
    public static final int MINDESTPREIS_CENT = 1;

    /** Groesster im Turnier erlaubter Verkaufspreis: 10,00 EUR. */
    public static final int HOECHSTPREIS_CENT = 1000;

    private String name;

    protected AbstrakteStrategie(String name) {
        this.name = name;
    }

    /**
     * Der Name aus dem Konstruktor - einmal geschrieben, von allen Unterklassen geerbt.
     *
     * <p>Genau das kann ein Interface nicht: Es haette nur den Methodenkopf vorgeben
     * koennen, und jeder Bot muesste sein eigenes {@code name()} hinschreiben.
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * Stutzt einen Preis auf den erlaubten Bereich zurecht.
     *
     * <p>{@code protected} heisst: Unterklassen duerfen die Methode benutzen, der Rest der
     * Welt nicht. Das ist die dritte Sichtbarkeit neben {@code public} und {@code private},
     * und sie ist genau fuer solche Faelle gedacht - eine Hilfe fuer die eigene Verwandtschaft.
     *
     * @param preisInCent gewuenschter Preis
     * @return Preis innerhalb der erlaubten Grenzen
     */
    protected int begrenze(int preisInCent) {
        return Math.max(MINDESTPREIS_CENT, Math.min(HOECHSTPREIS_CENT, preisInCent));
    }

    /**
     * Diese Methode hat hier keinen Rumpf - sie ist {@code abstract}.
     *
     * <p>Das ist der Kern der Sache: Alles Gemeinsame steht oben, die eigentliche
     * Entscheidung bleibt offen. Wer von dieser Klasse erbt, muss sie ausfuellen.
     */
    @Override
    public abstract int verkaufspreisFuerRunde(Spielstand stand);

    @Override
    public String toString() {
        return name;
    }
}
