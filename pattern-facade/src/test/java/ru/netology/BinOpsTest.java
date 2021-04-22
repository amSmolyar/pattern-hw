package ru.netology;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

public class BinOpsTest {

    @ParameterizedTest
    @ValueSource(ints = {-1000, -100, -10, -1, 0, 1, 10, 100, 1000})
    public void testSum(int arg) {
        String strArg = Integer.toString(arg,2);
        String expected = Integer.toBinaryString(arg * 2);

        assertAll("testSum",
                () -> assertDoesNotThrow(() ->
                        new BinOps().sum(strArg, strArg)),
                () -> assertTrue(() ->
                {
                    try {
                        String actual = new BinOps().sum(strArg, strArg);
                        return actual.equals(expected);
                    } catch (Exception e) {
                        return false;
                    }
                }));
    }


    @ParameterizedTest
    @ValueSource(ints = {-1000, -100, -10, -1, 0, 1, 10, 100, 1000})
    public void testMult(int arg) {
        String strArg = Integer.toString(arg,2);
        String expected = Integer.toBinaryString(arg * arg);

        assertAll("testSum",
                () -> assertDoesNotThrow(() ->
                        new BinOps().sum(strArg, strArg)),
                () -> assertTrue(() ->
                {
                    try {
                        String actual = new BinOps().mult(strArg, strArg);
                        return actual.equals(expected);
                    } catch (ParseException e) {
                        return false;
                    }
                }));
    }
}