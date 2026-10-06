package de.dhbw.prog1.training;

/**
 * Training 8g - eine Fuehrungskraft ist ein Festangestellter mit Bonus.
 *
 * <p>Vererbung ueber zwei Stufen. Das Grundgehalt ist in der Oberklasse {@code private} -
 * du kommst also nicht direkt heran. Tipp: {@code super.monatsgehalt()}.
 */
public class T08Fuehrungskraft extends T08Festangestellter {

    private int bonus;

    public T08Fuehrungskraft(String name, int grundgehalt, int bonus) {
        super(name, grundgehalt);
        // TODO
    }

    @Override
    public int monatsgehalt() {
        // TODO
        return 0;
    }
}
