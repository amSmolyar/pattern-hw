package ru.netology;

public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;

    protected int position;

    public Frog() {
        position = 5;
    }

    public int getPosition() {
        return position;
    }

    public boolean jump(int steps) {
        if ((position + steps > MAX_POSITION) || (position + steps < MIN_POSITION))
            return false;

        position += steps;
        return true;
    }

    public void showFrogPosition() {
        System.out.println("\n\n");
        for (int ii = MIN_POSITION; ii <= MAX_POSITION; ii++) {
            if (position == ii)
                System.out.printf(" frog ");
            else
                System.out.printf(" xxxx ");
        }
        System.out.println("\n\n");
    }
}
