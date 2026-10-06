package de.dhbw.prog1.kern;

import java.nio.charset.Charset;
import java.util.Locale;

/**
 * Prueft, ob der Rechner richtig eingerichtet ist, und sagt im Klartext, was fehlt.
 *
 * <p>Aufruf:  {@code mvn -P pruefe-setup test}
 *
 * <p>Diese Klasse gehoert zum Rahmenwerk und muss nicht veraendert werden.
 */
public final class SetupPruefung {

    private static final int BENOETIGTE_JAVA_VERSION = 21;

    public static void main(String[] args) {
        Konsole.zeigeUeberschrift("Setup-Pruefung Kaffee-Kontor");

        int probleme = 0;
        probleme += pruefeJavaVersion();
        probleme += pruefeUmlaute();
        probleme += zeigeUmgebung();

        Konsole.zeige();
        if (probleme == 0) {
            Konsole.zeige("Alles in Ordnung. Du kannst loslegen.");
        } else {
            Konsole.zeige("Es gibt " + probleme + " Punkt(e) zu klaeren - siehe oben.");
            Konsole.zeige("Bring diese Ausgabe mit in die Vorlesung, dann ist es in zwei Minuten geloest.");
        }
    }

    private static int pruefeJavaVersion() {
        int version = Runtime.version().feature();
        if (version >= BENOETIGTE_JAVA_VERSION) {
            Konsole.zeige("[ok]     Java-Version " + version);
            return 0;
        }
        Konsole.zeige("[FEHLER] Java-Version " + version + " ist zu alt.");
        Konsole.zeige("         Benoetigt wird mindestens Java " + BENOETIGTE_JAVA_VERSION + ".");
        Konsole.zeige("         In IntelliJ: Datei > Projektstruktur > Projekt > SDK > JDK herunterladen");
        return 1;
    }

    private static int pruefeUmlaute() {
        String probe = "Grösse, Röstung, Übergabe, 4,50 EUR";
        Konsole.zeige("[info]   Umlaut-Probe: " + probe);
        Konsole.zeige("         Wenn oben Kaestchen oder Fragezeichen stehen, stimmt die");
        Konsole.zeige("         Zeichenkodierung der Konsole nicht. Unter Windows hilft in der");
        Konsole.zeige("         Eingabeaufforderung:  chcp 65001");
        return 0;
    }

    private static int zeigeUmgebung() {
        Konsole.zeige("[info]   Betriebssystem:   " + System.getProperty("os.name"));
        Konsole.zeige("[info]   Standardsprache:  " + Locale.getDefault());
        Konsole.zeige("[info]   Zeichenkodierung: " + Charset.defaultCharset());
        Konsole.zeige("[info]   Arbeitsverzeichnis: " + System.getProperty("user.dir"));
        return 0;
    }

    private SetupPruefung() {
    }
}
