package de.dhbw.prog1.kern;

/**
 * Der Vertrag fuer jeden Turnier-Bot.
 *
 * <p>Ein <b>Interface</b> ist kein Bauplan wie eine Klasse, sondern ein <b>Versprechen</b>:
 * "Wer sich Strategie nennt, kann diese beiden Dinge." Wie er das macht, ist seine Sache.
 * Ein Interface enthaelt deshalb ueblicherweise nur Methodenkoepfe und keine Ruempfe -
 * es sagt das Was, nicht das Wie.
 *
 * <p>Warum das hier gebraucht wird: Die Turnierleitung ({@link Turnier}) muss dreissig
 * verschiedene Bots spielen lassen, von denen sie keinen einzigen kennt - sie werden erst
 * in Einheit 11 geschrieben. Trotzdem kann sie mit jedem umgehen, weil jeder dieses
 * Versprechen einhaelt.
 *
 * <p>Das ist derselbe Gedanke wie bei der Preisliste in Einheit 10, nur eine Stufe weiter.
 * Dort mussten alle Sorten von einer gemeinsamen Oberklasse abstammen. Hier genuegt es,
 * dasselbe Versprechen zu geben - eure Strategien haben sonst nichts gemeinsam und muessen
 * auch nichts voneinander erben.
 *
 * <p>Diese Schnittstelle gehoert zum Rahmenwerk und muss nicht veraendert werden.
 */
public interface Strategie {

    /**
     * Wie heisst dieser Bot?
     *
     * <p>Der Name steht spaeter in der Turniertabelle. Nehmt euren Teamnamen.
     *
     * @return Anzeigename
     */
    String name();

    /**
     * Welchen Verkaufspreis setzt der Bot in dieser Runde?
     *
     * <p>Erlaubt sind Werte zwischen 1 und 1000 Cent. Wer darueber oder darunter liegt,
     * wird von der Turnierleitung auf den erlaubten Bereich zurechtgestutzt - das ist
     * kein Regelverstoss, aber meistens ein Denkfehler.
     *
     * @param stand alles, was ueber die Lage bekannt ist
     * @return Verkaufspreis je Becher in Cent
     */
    int verkaufspreisFuerRunde(Spielstand stand);
}
