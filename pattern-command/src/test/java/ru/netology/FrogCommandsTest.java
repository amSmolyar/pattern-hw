package ru.netology;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FrogCommandsTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void jumpRightCommand_doIt(int step) {
        Frog frog = new Frog();
        int startPosition = frog.getPosition();
        new FrogCommands().jumpRightCommand(frog, step).doIt();
        assertTrue(frog.getPosition() >= startPosition);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void jumpRightCommand_undo(int step) {
        Frog frog = new Frog();
        int startPosition = frog.getPosition();
        new FrogCommands().jumpRightCommand(frog, step).undo();
        assertTrue(frog.getPosition() <= startPosition);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void jumpRightCommand(int step) {
        Frog frog = new Frog();
        int startPosition = frog.getPosition();
        new FrogCommands().jumpRightCommand(frog, step).doIt();
        new FrogCommands().jumpRightCommand(frog, step).undo();
        assertTrue(frog.getPosition() == startPosition);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void jumpLeftCommand_doIt(int step) {
        Frog frog = new Frog();
        int startPosition = frog.getPosition();
        new FrogCommands().jumpLeftCommand(frog, step).doIt();
        assertTrue(frog.getPosition() <= startPosition);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void jumpLeftCommand_undo(int step) {
        Frog frog = new Frog();
        int startPosition = frog.getPosition();
        new FrogCommands().jumpLeftCommand(frog, step).undo();
        assertTrue(frog.getPosition() >= startPosition);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void jumpLeftCommand(int step) {
        Frog frog = new Frog();
        int startPosition = frog.getPosition();
        new FrogCommands().jumpLeftCommand(frog, step).doIt();
        new FrogCommands().jumpLeftCommand(frog, step).undo();
        assertTrue(frog.getPosition() == startPosition);
    }
}