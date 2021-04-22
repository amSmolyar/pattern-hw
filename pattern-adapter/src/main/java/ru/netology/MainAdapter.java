package ru.netology;

public class MainAdapter {
    public static void main(String[] args) {
        Ints calc = new IntsCalculator();
        System.out.println(calc.sum(10,9));
        System.out.println(calc.mult(-3,4));
        System.out.println(calc.pow(2,10));
    }
}
