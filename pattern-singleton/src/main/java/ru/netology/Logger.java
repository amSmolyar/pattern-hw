package ru.netology;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger logger;
    protected int num = 1;
    private DateFormat dateFormat;
    private Date date;

    private Logger() {
        this.num = 1;
        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        date = new Date();
    }

    public void log(String msg) {
        System.out.println("["  + dateFormat.format(date) + "   " + num++ + "]  :   " + msg);
    }

    public static Logger getLogger() {
        if (logger == null)
            logger = new Logger();
        return logger;
    }
}
