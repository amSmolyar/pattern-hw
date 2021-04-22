package ru.netology;

import java.text.ParseException;

public class MainFacade {
    public static void main(String[] args) {
        BinOps bins = new BinOps();

        try {
            System.out.println(bins.sum("10001","1100001"));
            System.out.println(bins.sum("1010","111"));
            System.out.println(bins.mult("0101","0100"));
            System.out.println(bins.mult("0110010","10010"));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
