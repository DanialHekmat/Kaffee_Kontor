package de.dhbw.prog1.ue05;

import de.dhbw.prog1.kern.Markt;

/**
 * Das Kaffee-Kontor als eine einzige Methode - so, wie man es nicht schreibt.
 *
 * <p><b>Diese Datei veraenderst du nicht.</b> Sie ist deine Vergleichsgrundlage.
 *
 * <p>Der Code hier funktioniert einwandfrei. Er liefert fuer jeden Verkaufspreis exakt
 * dasselbe Ergebnis wie die aufgeraeumte Fassung, die du in {@link Kontor} bauen wirst.
 * Und trotzdem ist er ein Problem - lies ihn einmal durch und versuch zu beantworten:
 *
 * <ul>
 *   <li>Was bedeutet {@code t}? Was {@code x2}?</li>
 *   <li>Wo genau wird entschieden, wie viele Saecke gekauft werden?</li>
 *   <li>Die Nachfrage wird zweimal ausgerechnet. Stehen beide Rechnungen wirklich
 *       dasselbe da? Bist du sicher?</li>
 *   <li>Woher kommt die 80? Und die 90000?</li>
 *   <li>Angenommen, die Fixkosten steigen auf 950 EUR. Wie viele Stellen musst du aendern,
 *       und findest du alle?</li>
 * </ul>
 *
 * <p>Genau das ist der Punkt der heutigen Einheit. Der Code ist nicht falsch. Er ist
 * unbenutzbar - fuer alle, die nach dir damit arbeiten muessen, und fuer dich selbst
 * in drei Wochen.
 */
public final class KontorMonolith {

    private KontorMonolith() {
    }

    /**
     * Spielt das gesamte Spiel mit einem festen Verkaufspreis.
     *
     * @param p Verkaufspreis je Becher in Cent
     * @return Kassenstand am Spielende in Cent
     */
    public static int spieleSpiel(int p) {
        int k = 200000;
        for (int i = 1; i <= 30; i++) {
            int mp = Markt.preisProSackInCent(i);
            int s = Markt.saisonInProzent(i);
            int t = 400 * s / 100;
            int d = p - 300;
            int e = d * 25 / 10;
            int n = t - e;
            if (n < 0) {
                n = 0;
            }
            int x = (n + 79) / 80;
            int m;
            if (k <= 0) {
                m = 0;
            } else {
                m = k / mp;
                if (m > 12) {
                    m = 12;
                }
            }
            int a = x;
            if (a > m) {
                a = m;
            }
            int c = a * mp;
            int v = a * 80;
            if (v > n) {
                v = n;
            }
            int r = v * p;
            k = k - c + r - 90000 - 0 * 30;
            int t2 = 400 * s / 100;
            int d2 = p - 300;
            int e2 = d2 * 25 / 10;
            int x2 = t2 - e2;
            if (x2 < 0) {
                x2 = 0;
            }
            if (x2 > v && a >= 12) {
                k = k + 0;
            }
            if (k < 0) {
                break;
            }
        }
        return k;
    }
}
