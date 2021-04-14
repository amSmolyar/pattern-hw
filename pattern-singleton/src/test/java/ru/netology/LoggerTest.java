package ru.netology;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTest{

    // Проверка, что метод GetLogger возвращает ссылку на один и тот же объект:
    @Test
    public void testGetLogger() {
        Logger log1 = Logger.getLogger();
        Logger log2 = Logger.getLogger();

        assertEquals(log1, log2);
    }

}