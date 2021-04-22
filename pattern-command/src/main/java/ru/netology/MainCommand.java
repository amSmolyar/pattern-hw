package ru.netology;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MainCommand {
    public static void main(String[] args) {
        CommandFromScanner scanner = new CommandFromScanner();
        List<FrogCommand> commands = new ArrayList<>();
        Frog frog = new Frog();

        while (true) {
            try {
                if (!scanner.getCommand(commands,frog)) {
                    System.out.println("\n\nПока!");
                    break;
                }
                frog.showFrogPosition();
            } catch (ParseException e) {
                System.out.println("Команда введена не верно");
            }
        }

        scanner.closeScanner();
    }
}
