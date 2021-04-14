package ru.netology;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class FilterTest {

    public List<Integer> getTestList () {
        Random random = new Random();
        List<Integer> testList = new ArrayList<>();
        for (int ii = 0; ii < 50; ii++) {
            testList.add(random.nextInt(100));
        }
        return testList;
    }

    @Test
    public void test_filter_over() {
        Filter filter = new Filter(0);
        List<Integer> expected = getTestList();
        List<Integer> actual = filter.filterOut(expected);
        assertThat("Списки не равны", actual, is(expected));
    }

    @Test
    public void test_filter_under() {
        Filter filter = new Filter(100);
        List<Integer> expected = new ArrayList<>();
        List<Integer> actual = filter.filterOut(getTestList());
        assertThat("Списки не равны", actual, is(expected));
    }
}