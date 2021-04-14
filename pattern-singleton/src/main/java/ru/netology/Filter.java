package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public int getTreshold() {
        return treshold;
    }

    public void setTreshold(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getLogger();
        List<Integer> result = new ArrayList<>();
        for (Integer element : source) {
            if (element >= treshold) {
                result.add(element);
                logger.log("Элемент " + element + " прошел фильтрацию");
            } else
                logger.log("Элемент " + element + " не прошел фильтрацию");
        }
        return result;
    }
}
