package ru.netology;

import java.text.ParseException;

public class BinOps {
    public String sum(String a, String b) throws ParseException {
        int intA = Integer.parseInt(a, 2);
        int intB = Integer.parseInt(b, 2);

        return Integer.toBinaryString(intA + intB);
    }

    public String mult(String a, String b) throws ParseException {
        int intA = Integer.parseInt(a, 2);
        int intB = Integer.parseInt(b, 2);

        return Integer.toBinaryString(intA * intB);
    }
}
