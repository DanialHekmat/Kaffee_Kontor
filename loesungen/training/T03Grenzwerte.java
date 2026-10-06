package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/**
 * Training 3 - Grenzwerte.
 *
 * <p>Jede Aufgabe hier dreht sich um dieselbe Frage: Gehoert die Grenze dazu oder nicht?
 * Lies genau: <b>"ab"</b> heisst einschliesslich, <b>"mehr als"</b> heisst ausschliesslich.
 *
 * <p>Passt zu Einheit 3. Pruefe dich mit {@code T03GrenzwerteTest}.
 */
public class T03Grenzwerte {

    /** Volljaehrig ist man ab 18. */
    public static boolean istVolljaehrig(int alter) {
        return alter >= 18;
    }

    /** Liegt der Wert zwischen min und max - beide Grenzen eingeschlossen? */
    public static boolean liegtImBereich(int wert, int min, int max) {
        return wert >= min && wert <= max;
    }

    /** Ist die Stunde gueltig? Gueltig sind 0 bis 23. */
    public static boolean istGueltigeStunde(int stunde) {
        return stunde >= 0 && stunde <= 23;
    }

    /**
     * Stutzt einen Wert auf den Bereich min bis max zurecht.
     *
     * <p>Beispiel bei 0 bis 10: 5 bleibt 5, -3 wird 0, 15 wird 10.
     */
    public static int begrenze(int wert, int min, int max) {
        if (wert < min) {
            return min;
        }
        if (wert > max) {
            return max;
        }
        return wert;
    }

    /**
     * Note zu Punkten.
     *
     * <ul>
     *   <li>ab 90: {@code "sehr gut"}</li>
     *   <li>ab 75: {@code "gut"}</li>
     *   <li>ab 60: {@code "befriedigend"}</li>
     *   <li>ab 50: {@code "ausreichend"}</li>
     *   <li>darunter: {@code "nicht bestanden"}</li>
     * </ul>
     */
    public static String note(int punkte) {
        if (punkte >= 90) {
            return "sehr gut";
        } else if (punkte >= 75) {
            return "gut";
        } else if (punkte >= 60) {
            return "befriedigend";
        } else if (punkte >= 50) {
            return "ausreichend";
        }
        return "nicht bestanden";
    }

    /**
     * Versandkosten in Cent.
     *
     * <ul>
     *   <li>ab 5000 Cent Bestellwert: versandkostenfrei (0)</li>
     *   <li>ab 2000 Cent: 295</li>
     *   <li>darunter: 495</li>
     * </ul>
     */
    public static int versandkosten(int bestellwertInCent) {
        if (bestellwertInCent >= 5000) {
            return 0;
        } else if (bestellwertInCent >= 2000) {
            return 295;
        }
        return 495;
    }

    /**
     * Temperaturstufe.
     *
     * <ul>
     *   <li>unter 0: {@code "Frost"}</li>
     *   <li>0 bis 14: {@code "kalt"}</li>
     *   <li>15 bis 24: {@code "mild"}</li>
     *   <li>ab 25: {@code "warm"}</li>
     * </ul>
     */
    public static String temperaturStufe(int grad) {
        if (grad < 0) {
            return "Frost";
        } else if (grad <= 14) {
            return "kalt";
        } else if (grad <= 24) {
            return "mild";
        }
        return "warm";
    }

    /**
     * Mengenrabatt in Prozent - <b>Achtung, hier werden "ab" und "mehr als" gemischt.</b>
     *
     * <ul>
     *   <li>ab 100 Stueck: 15</li>
     *   <li>mehr als 50 Stueck: 10</li>
     *   <li>ab 10 Stueck: 5</li>
     *   <li>darunter: 0</li>
     * </ul>
     */
    public static int rabattProzent(int menge) {
        if (menge >= 100) {
            return 15;
        } else if (menge > 50) {
            return 10;
        } else if (menge >= 10) {
            return 5;
        }
        return 0;
    }

    // =================================================================================
    //  WEITERE AUFGABEN
    // =================================================================================

    /** Kind ist, wer unter 14 ist. */
    public static boolean istKind(int alter) {
        return alter < 14;
    }

    /** Teenager ist, wer 13 bis 19 Jahre alt ist - beide Grenzen eingeschlossen. */
    public static boolean istTeenager(int alter) {
        return alter >= 13 && alter <= 19;
    }

    /** Ist die Minute gueltig? Gueltig sind 0 bis 59. */
    public static boolean istGueltigeMinute(int minute) {
        return minute >= 0 && minute <= 59;
    }

    /** Ist der Monat gueltig? Gueltig sind 1 bis 12. */
    public static boolean istGueltigerMonat(int monat) {
        return monat >= 1 && monat <= 12;
    }

    /**
     * Ist das Datum gueltig? Monat 1 bis 12, Tag ab 1 und hoechstens so viele Tage, wie der
     * Monat hat: Februar 29, April, Juni, September und November 30, sonst 31.
     *
     * <p>Das Schaltjahr wird hier nicht geprueft - der 29. Februar gilt immer als gueltig.
     */
    public static boolean istGueltigesDatum(int tag, int monat) {
        if (monat < 1 || monat > 12 || tag < 1) {
            return false;
        }
        int maximum = 31;
        if (monat == 2) {
            maximum = 29;
        } else if (monat == 4 || monat == 6 || monat == 9 || monat == 11) {
            maximum = 30;
        }
        return tag <= maximum;
    }

    /** Ist heute Wochenende? Tag 6 (Samstag) und 7 (Sonntag). Alles andere nicht - auch ungueltige Nummern. */
    public static boolean istWochenende(int tagNummer) {
        return tagNummer == 6 || tagNummer == 7;
    }

    /**
     * Liegt der Wert im halboffenen Bereich - min eingeschlossen, max <b>ausgeschlossen</b>?
     *
     * <p>So sind in Java die Positionen eines Arrays: von 0 bis ausschliesslich length.
     */
    public static boolean liegtImHalboffenenBereich(int wert, int min, int max) {
        return wert >= min && wert < max;
    }

    /**
     * Ueberschneiden sich die Bereiche a1 bis a2 und b1 bis b2 (Grenzen eingeschlossen)?
     *
     * <p>Es gilt immer a1 &lt;= a2 und b1 &lt;= b2. Auch eine Beruehrung an einer Grenze zaehlt.
     */
    public static boolean ueberschneidenSich(int a1, int a2, int b1, int b2) {
        return a1 <= b2 && b1 <= a2;
    }

    /**
     * BMI-Kategorie (ganzzahlig): unter 18 {@code "Untergewicht"}, 18 bis 24
     * {@code "Normalgewicht"}, 25 bis 29 {@code "Uebergewicht"}, ab 30 {@code "Adipositas"}.
     */
    public static String bmiKategorie(int bmi) {
        if (bmi < 18) {
            return "Untergewicht";
        } else if (bmi <= 24) {
            return "Normalgewicht";
        } else if (bmi <= 29) {
            return "Uebergewicht";
        }
        return "Adipositas";
    }

    /**
     * Parkgebuehr in Cent: bis einschliesslich 30 Minuten frei (0), bis einschliesslich 120
     * Minuten 200, mehr als 120 Minuten 500.
     */
    public static int parkgebuehr(int minuten) {
        if (minuten <= 30) {
            return 0;
        } else if (minuten <= 120) {
            return 200;
        }
        return 500;
    }

    /**
     * Steuersatz in Prozent: bis einschliesslich 12000 Euro 0, bis einschliesslich 60000
     * Euro 20, mehr als 60000 Euro 40.
     */
    public static int steuersatz(int einkommen) {
        if (einkommen <= 12000) {
            return 0;
        } else if (einkommen <= 60000) {
            return 20;
        }
        return 40;
    }

    /**
     * Windstaerke: unter 1 km/h {@code "Windstille"}, 1 bis 19 {@code "leicht"}, 20 bis 61
     * {@code "maessig"}, 62 bis 117 {@code "Sturm"}, ab 118 {@code "Orkan"}.
     */
    public static String windstaerke(int kmh) {
        if (kmh < 1) {
            return "Windstille";
        } else if (kmh <= 19) {
            return "leicht";
        } else if (kmh <= 61) {
            return "maessig";
        } else if (kmh <= 117) {
            return "Sturm";
        }
        return "Orkan";
    }
}
