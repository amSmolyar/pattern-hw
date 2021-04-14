package ru.netology;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PersonTest extends TestCase {

    @ParameterizedTest
    @ValueSource(strings = {"Антошка", "Мишутка", "Павлик", "Женечек"})
    public void testNewChildBuilder(String childName) {
        Person expectedChild = new PersonBuilder()
                .setName(childName)
                .setSurname("Вольф")
                .setAge(0)
                .setAddress("Сидней")
                .build();

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();

        Person actualChild = mom.newChildBuilder().setName(childName).build();

        assertEquals(expectedChild, actualChild);
    }
}