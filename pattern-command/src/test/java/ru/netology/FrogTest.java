package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FrogTest {

    public static Stream<Integer> getTrueIntValues() {
        int arraySize = Frog.MAX_POSITION - Frog.MIN_POSITION + 1;
        Frog frog = new Frog();
        Integer[] intArray = new Integer[arraySize];
        int startValue = Frog.MIN_POSITION - frog.getPosition();
        for (Integer ii = 0; ii < intArray.length; ii++) {
            intArray[ii] = ii + startValue;
        }
        return Arrays.stream(intArray);
    }

    @ParameterizedTest
    @MethodSource("getTrueIntValues")
    public void jumpTest_true(int arg) {
        Frog frog = new Frog();
        assertTrue(frog.jump(arg));
    }

    public static Stream<Integer> getFalseIntValues() {
        Frog frog = new Frog();
        Integer[] intArray = new Integer[10];
        for (Integer ii = 0; ii < 5; ii++) {
            intArray[ii] = Frog.MIN_POSITION - frog.getPosition() - ii - 1;
            intArray[ii + 5] = Frog.MAX_POSITION - frog.getPosition() + ii + 1;
        }
        return Arrays.stream(intArray);
    }

    @ParameterizedTest
    @MethodSource("getFalseIntValues")
    public void jumpTest_false(int arg) {
        Frog frog = new Frog();
        assertFalse(frog.jump(arg));
    }
}