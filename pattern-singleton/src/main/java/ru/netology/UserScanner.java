package ru.netology;

import java.text.ParseException;
import java.util.Scanner;

public class UserScanner {
    private Scanner scan;

    public UserScanner() {
        scan = new Scanner(System.in);
    }

    public void closeScanner() {
        scan.close();
    }

    public int scanIntData(String msg) throws ParseException {
        int result;

        System.out.println(msg);

        String scanData = scan.nextLine().trim();
        result = Integer.parseInt(scanData);
        return result;
    }
}
