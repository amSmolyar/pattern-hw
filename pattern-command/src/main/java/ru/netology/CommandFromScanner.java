package ru.netology;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import static ru.netology.FrogCommands.jumpLeftCommand;
import static ru.netology.FrogCommands.jumpRightCommand;

public class CommandFromScanner {
    private Scanner scan;
    private int curCommand;

    public CommandFromScanner() {
        scan = new Scanner(System.in);
        curCommand = -1;
    }

    public void closeScanner() {
        scan.close();
    }

    public boolean getCommand(List<FrogCommand> list, Frog frog) throws ParseException {
        String scanData;

        System.out.println("Выберите команду из списка: " +
                "\n     +N  -   прыгни на N шагов вправо;" +
                "\n     -N  -   прыгни на N шагов влево;" +
                "\n     <<  -   Undo (отмени последнюю команду); " +
                "\n     >>  -   Redo (повтори отмененную команду); " +
                "\n     !!  -   повтори последнюю команду; " +
                "\n     0  -   выход ");
        scanData = scan.nextLine().trim();

        if (scanData.equals("0"))
            return false;

        detectCommand(list, frog, scanData);
        return true;
    }

    public void detectCommand(List<FrogCommand> list, Frog frog, String scanData) {
        FrogCommand cmd;
        int step;

        switch (scanData) {
            case "<<":
                if (curCommand < 0)
                    System.out.println("Нечего отменять");
                else {
                    list.get(curCommand).undo();
                    curCommand--;
                }
                break;
            case ">>":
                if (curCommand == (list.size() - 1)) {
                    System.out.println("Нечего повторять");
                } else {
                    curCommand++;
                    list.get(curCommand).doIt();
                }
                break;
            case "!!":
                if (curCommand < 0)
                    System.out.println("Нечего повторять");
                else {
                    removeElements(list, curCommand);
                    cmd = list.get(curCommand);
                    list.add(cmd);
                    cmd.doIt();
                    curCommand++;
                }
                break;
            default:
                if (scanData.startsWith("-")) {
                    removeElements(list, curCommand);
                    step = Integer.parseInt(scanData.substring(1));
                    if (jumpLeftCommand(frog, step).doIt()) {
                        cmd = jumpLeftCommand(frog, step);
                        list.add(cmd);
                        curCommand++;
                    }
                } else if (scanData.startsWith("+")) {
                    removeElements(list, curCommand);
                    step = Integer.parseInt(scanData.substring(1));
                    if (jumpRightCommand(frog, step).doIt()) {
                        cmd = jumpRightCommand(frog, step);
                        list.add(cmd);
                        curCommand++;
                    }
                } else
                    System.out.println("Команда введена не верно");

                break;
        }
    }

    private void removeElements(List<FrogCommand> list, int index) {
        if (index < (list.size() - 1)) {
            for (int ii = (index + 1); ii < list.size(); ii++) {
                list.remove(ii);
            }
        }
    }

}
