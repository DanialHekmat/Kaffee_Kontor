package de.dhbw.prog1.training;

// MUSTERLOESUNG - erst ansehen, wenn du es selbst versucht hast.

/**
 * Training 7d - Klassen und Objekte: ein Punkt, der sich verschieben laesst.
 *
 * <p>Passt zu Einheit 8. Pruefe dich mit {@code T07KlassenTest}.
 */
public class T07Punkt {

    private int x;
    private int y;

    public T07Punkt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    /** Verschiebt <b>diesen</b> Punkt um dx und dy. */
    public void verschiebe(int dx, int dy) {
        x += dx;
        y += dy;
    }

    /** x hoch 2 plus y hoch 2 - das Quadrat des Abstands zum Ursprung (0|0). */
    public int abstandQuadratZumUrsprung() {
        return x * x + y * y;
    }

    /** Genau in diesem Format: {@code "(3|4)"}. */
    @Override
    public String toString() {
        return "(" + x + "|" + y + ")";
    }
}
