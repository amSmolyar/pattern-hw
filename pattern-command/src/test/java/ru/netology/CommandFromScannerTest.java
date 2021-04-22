package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.FrogCommands.jumpLeftCommand;
import static ru.netology.FrogCommands.jumpRightCommand;

class CommandFromScannerTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void detectCommand_rightJump_doIt(int step) {
        Frog frog = new Frog();
        List<FrogCommand> frogCommandsList = new ArrayList<>();

        int expected = frog.getPosition();
        if (frog.getPosition() + step <= Frog.MAX_POSITION)
            expected = frog.getPosition() + step;

        new CommandFromScanner().detectCommand(frogCommandsList, frog, "+" + step);
        int actual = frog.getPosition();
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void detectCommand_leftJump_doIt(int step) {
        Frog frog = new Frog();
        List<FrogCommand> frogCommandsList = new ArrayList<>();

        int expected = frog.getPosition();
        if (frog.getPosition() - step >= Frog.MIN_POSITION)
            expected = frog.getPosition() - step;

        new CommandFromScanner().detectCommand(frogCommandsList, frog, "-" + step);
        int actual = frog.getPosition();
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void detectCommand_rightUndo(int step) {
        Frog frog = new Frog();
        List<FrogCommand> frogCommandsList = new ArrayList<>();

        int expected = frog.getPosition();

        CommandFromScanner cmdFromScan = new CommandFromScanner();
        cmdFromScan.detectCommand(frogCommandsList, frog, "+" + step);
        cmdFromScan.detectCommand(frogCommandsList, frog, "<<");
        int actual = frog.getPosition();
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void detectCommand_leftUndo(int step) {
        Frog frog = new Frog();
        List<FrogCommand> frogCommandsList = new ArrayList<>();

        int expected = frog.getPosition();

        CommandFromScanner cmdFromScan = new CommandFromScanner();
        cmdFromScan.detectCommand(frogCommandsList, frog, "-" + step);
        cmdFromScan.detectCommand(frogCommandsList, frog, "<<");
        int actual = frog.getPosition();
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void detectCommand_rightRedo(int step) {
        Frog frog = new Frog();
        List<FrogCommand> frogCommandsList = new ArrayList<>();

        int expected = frog.getPosition();
        if (frog.getPosition() + step <= Frog.MAX_POSITION)
            expected = frog.getPosition() + step;

        CommandFromScanner cmdFromScan = new CommandFromScanner();
        cmdFromScan.detectCommand(frogCommandsList, frog, "+" + step);
        cmdFromScan.detectCommand(frogCommandsList, frog, "<<");
        cmdFromScan.detectCommand(frogCommandsList, frog, ">>");
        int actual = frog.getPosition();
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void detectCommand_leftRedo(int step) {
        Frog frog = new Frog();
        List<FrogCommand> frogCommandsList = new ArrayList<>();

        int expected = frog.getPosition();
        if (frog.getPosition() - step >= Frog.MIN_POSITION)
            expected = frog.getPosition() - step;

        CommandFromScanner cmdFromScan = new CommandFromScanner();
        cmdFromScan.detectCommand(frogCommandsList, frog, "-" + step);
        cmdFromScan.detectCommand(frogCommandsList, frog, "<<");
        cmdFromScan.detectCommand(frogCommandsList, frog, ">>");
        int actual = frog.getPosition();
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void detectCommand_rightRepeat(int step) {
        Frog frog = new Frog();
        List<FrogCommand> frogCommandsList = new ArrayList<>();

        int expected = frog.getPosition();
        for (int ii = 0; ii < 2; ii++) {
            if (expected + step <= Frog.MAX_POSITION)
                expected = expected + step;
        }

        CommandFromScanner cmdFromScan = new CommandFromScanner();
        cmdFromScan.detectCommand(frogCommandsList, frog, "+" + step);
        cmdFromScan.detectCommand(frogCommandsList, frog, "!!");
        int actual = frog.getPosition();
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void detectCommand_leftRepeat(int step) {
        Frog frog = new Frog();
        List<FrogCommand> frogCommandsList = new ArrayList<>();

        int expected = frog.getPosition();
        for (int ii = 0; ii < 2; ii++) {
            if (expected - step >= Frog.MIN_POSITION)
                expected = expected - step;
        }

        CommandFromScanner cmdFromScan = new CommandFromScanner();
        cmdFromScan.detectCommand(frogCommandsList, frog, "-" + step);
        cmdFromScan.detectCommand(frogCommandsList, frog, "!!");
        int actual = frog.getPosition();
        assertEquals(expected,actual);
    }


}