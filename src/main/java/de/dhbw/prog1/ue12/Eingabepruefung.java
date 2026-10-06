package de.dhbw.prog1.ue12;

import de.dhbw.prog1.kern.Geld;

/**
 * Uebung 12, Teil 3 - fremde Ausnahmen abfangen.
 *
 * <p>Bis hierher habt ihr Ausnahmen vor allem als Absturz erlebt: {@code NumberFormatException},
 * wenn jemand "zwoelf" eintippt. {@code ArrayIndexOutOfBoundsException}, wenn eine Schleife zu
 * weit laeuft. {@code NullPointerException}, wenn ein Verweis ins Leere zeigt.
 *
 * <p>Diese Ausnahmen kamen nicht von euch - sie kamen aus Javas eigenen Klassen. Jetzt lernt
 * ihr, sie aufzufangen, statt sie das Programm beenden zu lassen.
 *
 * <p><b>Der Grundgedanke:</b> Eine Ausnahme ist kein Weltuntergang, sondern eine Nachricht.
 * Sie sagt "so geht es nicht weiter" - und der Aufrufer entscheidet, was daraus folgt. Bei
 * einer Benutzereingabe ist die vernuenftige Folge fast immer: nachfragen oder einen
 * sinnvollen Standardwert nehmen. Nicht: abstuerzen.
 */
public class Eingabepruefung {

    /**
     * Liest einen Geldbetrag aus einem Text - oder liefert den Standardwert.
     *
     * <p>{@link Geld#ausText(String)} kennt ihr seit Einheit 2. Es wirft eine
     * {@link IllegalArgumentException}, wenn der Text kein gueltiger Betrag ist. Genau die
     * faengt ihr hier ab.
     *
     * <pre>
     *     try {
     *         return Geld.ausText(text);
     *     } catch (IllegalArgumentException e) {
     *         return standardInCent;
     *     }
     * </pre>
     *
     * <p>Auch {@code null} muss hier heil durchgehen und den Standardwert liefern.
     *
     * @param text            zu lesender Text, darf null sein
     * @param standardInCent  Wert fuer den Fall, dass der Text unbrauchbar ist
     * @return gelesener Betrag in Cent, sonst der Standardwert
     */
    public static int leseBetragOderStandard(String text, int standardInCent) {
        // TODO Stufe 1
        return 0;
    }

    /**
     * Liest eine ganze Zahl aus einem Text - oder liefert den Standardwert.
     *
     * <p>{@code Integer.parseInt} wirft eine {@link NumberFormatException}, wenn der Text
     * keine Zahl ist. Bei {@code null} wirft es eine ganz andere Ausnahme.
     *
     * <p><b>Und hier kommt die Hierarchie ins Spiel.</b> {@code NumberFormatException} erbt
     * von {@code IllegalArgumentException}, und die wiederum von {@code RuntimeException}.
     * Ein {@code catch} faengt deshalb auch alle Unterklassen mit ab - genau wie eine Methode,
     * die eine {@code Kaffeesorte} erwartet, auch eine {@code BioSorte} annimmt. Das ist
     * dieselbe Regel wie in Einheit 10.
     *
     * <p>Praktische Folge: {@code catch (IllegalArgumentException e)} genuegt hier und faengt
     * beide Faelle. Wer zusaetzlich {@code catch (NumberFormatException e)} schreiben will,
     * muss das <b>vor</b> den allgemeineren Block setzen - andernfalls meldet der Compiler,
     * dass der zweite Block nie erreicht wird.
     *
     * <p>Vergesst das {@code trim()} nicht: " 12 " soll als 12 gelesen werden.
     *
     * @param text     zu lesender Text, darf null sein
     * @param standard Wert fuer den Fall, dass der Text unbrauchbar ist
     * @return gelesene Zahl, sonst der Standardwert
     */
    public static int leseZahlOderStandard(String text, int standard) {
        // TODO Stufe 2
        return 0;
    }

    /**
     * Prueft, ob ein Verkaufspreis im erlaubten Bereich liegt, und meldet das Problem.
     *
     * <p>Liefert {@code null}, wenn alles in Ordnung ist - sonst eine verstaendliche
     * Beschreibung:
     *
     * <ul>
     *   <li>unter 1 Cent: {@code "Preis muss mindestens 0,01 EUR betragen."}</li>
     *   <li>ueber 1000 Cent: {@code "Preis darf hoechstens 10,00 EUR betragen."}</li>
     * </ul>
     *
     * <p><b>Warum hier keine Ausnahme?</b> Weil ein ungueltiger Preis in einer
     * Eingabemaske nichts Aussergewoehnliches ist - er ist der Normalfall beim Vertippen.
     * Ausnahmen sind fuer <i>Ausnahmen</i>. Wer sie fuer den gewoehnlichen Ablauf benutzt,
     * baut Programme, die staendig Ausnahmen werfen und fangen, und das liest sich
     * furchtbar.
     *
     * <p>Das ist die Faustregel, die ihr euch merken solltet: <b>Ausnahmen fuer das
     * Unerwartete, Rueckgabewerte fuer das Erwartbare.</b>
     *
     * @param preisInCent zu pruefender Preis
     * @return Fehlerbeschreibung, oder null wenn der Preis in Ordnung ist
     */
    public static String pruefeVerkaufspreis(int preisInCent) {
        // TODO Stufe 2
        return null;
    }
}
