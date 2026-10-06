package de.dhbw.prog1.kern;

/**
 * Rechnen mit Geld - und zwar richtig.
 *
 * <p>Im gesamten Kaffee-Kontor werden Geldbetraege als {@code int} in <b>Cent</b> gespeichert,
 * niemals als {@code double}. Der Grund ist einfach nachzurechnen:
 *
 * <pre>
 *     System.out.println(0.1 + 0.2);   // ergibt 0.30000000000000004
 * </pre>
 *
 * <p>Kommazahlen werden im Rechner binaer gespeichert, und 0,1 laesst sich binaer genauso wenig
 * exakt darstellen wie 1/3 im Dezimalsystem. Bei einer Buchhaltung mit tausenden Buchungen
 * summieren sich diese winzigen Fehler zu echten Differenzen. Deshalb: ganze Cent, ganze Zahlen.
 *
 * <p>Diese Klasse gehoert zum Rahmenwerk und muss nicht veraendert werden.
 */
public final class Geld {

    private Geld() {
        // Hilfsklasse - es werden keine Objekte davon erzeugt.
    }

    /**
     * Wandelt einen Centbetrag in eine lesbare Darstellung um, z. B. 450 -> "4,50 EUR".
     *
     * <p>Die Formatierung ist bewusst von Hand gebaut und nicht ueber {@code NumberFormat},
     * damit sie auf jedem Rechner identisch aussieht - unabhaengig davon, ob das Betriebssystem
     * auf Deutsch, Englisch oder Franzoesisch eingestellt ist.
     */
    public static String formatiere(int cent) {
        String vorzeichen = "";
        long betrag = cent;
        if (betrag < 0) {
            vorzeichen = "-";
            betrag = -betrag;
        }
        long euro = betrag / 100;
        long rest = betrag % 100;
        return vorzeichen + euro + "," + (rest < 10 ? "0" : "") + rest + " EUR";
    }

    /**
     * Liest einen Geldbetrag aus einem Text und liefert ihn in Cent.
     *
     * <p>Akzeptiert Komma und Punkt als Trennzeichen ("4,50" und "4.50" ergeben beide 450),
     * damit die Eingabe auf deutschen wie auf englischen Systemen gleich funktioniert.
     *
     * @throws IllegalArgumentException wenn der Text kein gueltiger Betrag ist
     */
    public static int ausText(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Kein Betrag angegeben.");
        }
        String bereinigt = text.trim().replace(".", ",").replace(" ", "");
        if (bereinigt.isEmpty()) {
            throw new IllegalArgumentException("Kein Betrag angegeben.");
        }

        boolean negativ = bereinigt.startsWith("-");
        if (negativ || bereinigt.startsWith("+")) {
            bereinigt = bereinigt.substring(1);
        }

        String euroTeil;
        String centTeil;
        int trenner = bereinigt.indexOf(',');
        if (trenner < 0) {
            euroTeil = bereinigt;
            centTeil = "00";
        } else {
            euroTeil = bereinigt.substring(0, trenner);
            centTeil = bereinigt.substring(trenner + 1);
        }
        if (euroTeil.isEmpty()) {
            euroTeil = "0";
        }
        if (centTeil.length() == 1) {
            centTeil = centTeil + "0";
        }
        if (centTeil.length() != 2) {
            throw new IllegalArgumentException(
                    "Ungueltiger Betrag: '" + text + "'. Erwartet wird z. B. 4,50");
        }

        try {
            int euro = Integer.parseInt(euroTeil);
            int cent = Integer.parseInt(centTeil);
            int gesamt = euro * 100 + cent;
            return negativ ? -gesamt : gesamt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Ungueltiger Betrag: '" + text + "'. Erwartet wird z. B. 4,50");
        }
    }
}
