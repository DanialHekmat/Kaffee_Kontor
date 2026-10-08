package de.dhbw.prog1;

public class Methoden {
    public static void main(String[] args) {
        bedingt(2);
    }

    public static int bedingt(int x) {
        if (x < 0) {
            return 1;
        }
        return x * 2;
    }

}
