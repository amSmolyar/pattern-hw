package ru.netology;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainSingleton {
    public static void main(String[] args) {
        UserScanner scanner = new UserScanner();
        Logger logger = Logger.getLogger();

        Random random = new Random();
        List<Integer> randomList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();

        int listSize;
        int maxValue;
        int threshold;

        logger.log("Запускаем программу");

        logger.log("Просим пользователя ввести входные данные");

        while (true) {
            try {
                listSize = scanner.scanIntData("Введите размер списка: ");
                logger.log("Пользователь захотел создать список размером " + listSize);
                break;
            } catch (ParseException e) {
                logger.log("Пользователь ввел некорректные данные");
            }
        }

        while (true) {
            try {
                maxValue = scanner.scanIntData("Введите верхнюю границу для значений: ");
                logger.log("Пользователь решил, что максимальное значение в списке будет: " + maxValue);
                break;
            } catch (ParseException e) {
                logger.log("Пользователь ввел некорректные данные");
            }
        }

        logger.log("Создаем список со случайными значениями");
        for (int ii = 0; ii < listSize; ii++) {
            randomList.add(random.nextInt(maxValue));
        }
        System.out.printf("Случайный список : ");
        writeList(randomList);

        while (true) {
            try {
                threshold = scanner.scanIntData("Введите порог фильтрации: ");
                logger.log("Пользователь решил, что порог фильтрации будет: " + threshold);
                break;
            } catch (ParseException e) {
                logger.log("Пользователь ввел некорректные данные");
            }
        }

        Filter filter = new Filter(threshold);
        logger.log("Запускаем фильтрацию");
        resultList = filter.filterOut(randomList);

        logger.log("Выводим результат на экран");
        System.out.printf("Отфильтрованный список : ");
        writeList(resultList);

        logger.log("Завершаем программу");
    }

    public static <T> void writeList(List<T> list) {
        for (T element : list) {
            System.out.printf(element + " ");
        }
        System.out.println();
    }
}
