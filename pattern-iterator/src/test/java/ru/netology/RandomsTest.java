package ru.netology;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomsTest {

    @Test
    public void testIteratorNext() {
        Randoms randoms = new Randoms(90, 100);
        List<Integer> ints = new ArrayList<>();
        int ii = 0;
        for (int r : randoms) {
            ii++;
            ints.add(r);
            if (ii == 999) {
                break;
            }
        }
        assertThat(ints, hasItem(90));
        assertThat(ints, hasItem(100));
    }

}