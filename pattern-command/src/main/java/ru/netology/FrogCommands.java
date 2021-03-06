package ru.netology;

import com.sun.source.tree.BreakTree;

public class FrogCommands {
    public static FrogCommand jumpRightCommand(Frog frog, int steps) {
        return new FrogCommand() {
            @Override
            public boolean doIt() {
                return frog.jump(steps);
            }

            @Override
            public boolean undo() {
                return frog.jump(-1 * steps);
            }
        };
    }

    public static FrogCommand jumpLeftCommand(Frog frog, int steps) {
        return new FrogCommand() {
            @Override
            public boolean doIt() {
                return frog.jump(-1 * steps);
            }

            @Override
            public boolean undo() {
                return frog.jump(steps);
            }
        };
    }
}
