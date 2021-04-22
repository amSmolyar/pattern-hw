package ru.netology;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class IntsCalculatorTest {

    @ParameterizedTest
    @ValueSource(ints = {-100, -10, -1, 0, 10, 100, 1000})
    public void InstCalculatorTest_IllegalStateException(int arg) {
        assertAll("InstCalculatorTest_IllegalStateException",
                () -> assertDoesNotThrow(() ->
                        new IntsCalculator().sum(arg, arg)),
                () -> assertDoesNotThrow(() ->
                        new IntsCalculator().mult(arg, arg)),
                () -> assertDoesNotThrow(() ->
                        new IntsCalculator().pow(arg, arg)));
    }


    @ParameterizedTest
    @ValueSource(ints = {-100, -10, -1, 0, 10, 100, 1000})
    public void testSum(int arg) {
        int expected = arg * 2;
        int actual = new IntsCalculator().sum(arg, arg);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, -10, -1, 0, 10, 100, 1000})
    public void testMult(int arg) {
        int expected = arg * arg;
        int actual = new IntsCalculator().mult(arg, arg);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {-100, -10, -1, 0, 10})
    public void testPow_exponentaArgs(int arg) {
        double expected1 = Math.pow(2, arg);
        int expected = (int) Math.floor(expected1);
        int actual = new IntsCalculator().pow(2, arg);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {100, -10, -1, 0, 10, 100})
    public void testPow_positiveArgs(int arg) {
        double expected1 = Math.pow(arg, 2);
        int expected = (int) Math.floor(expected1);
        int actual = new IntsCalculator().pow(arg, 2);
        assertEquals(expected, actual);
    }

}