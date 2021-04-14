package ru.netology;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonBuilderTest {

    @ParameterizedTest
    @ValueSource(strings = {"Ксения", "Анжела", "Марина", "Екатерина"})
    public void testTestSetName(String newName) {
        String expectedName = "Анна";
        String actualName = "";

        Person person = new PersonBuilder()
                .setName("Анна")
                .setName(newName)
                .setSurname("Вольф")
                .setAge(31)
                .build();

        actualName = person.getName();
        assertEquals(expectedName, actualName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Клаусс", "Штраусс", "Маусс", "Ганс"})
    public void testSetSurname(String newSurname) {
        String expectedSurname = "Вольф";
        String actualSurname = "";

        Person person = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setSurname(newSurname)
                .setAge(31)
                .build();

        actualSurname = person.getSurname();
        assertEquals(expectedSurname, actualSurname);
    }

    @ParameterizedTest
    @ValueSource(ints = {150, 200, 128, -2})
    public void testSetAge_IllegalArgumentException(int age) {
        assertThrows(IllegalArgumentException.class, () ->
                new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(age)
                .build());
    }

    @Test
    public void testBuild_withoutAge() {
        assertThrows(IllegalStateException.class, () ->
                new PersonBuilder()
                        .setName("Анна")
                        .setSurname("Вольф")
                        .build());
    }

    @Test
    public void testBuild_withoutName() {
        assertThrows(IllegalStateException.class, () ->
                new PersonBuilder()
                        .setSurname("Вольф")
                        .setAge(31)
                        .build());
    }

    @Test
    public void testBuild_withoutSurname() {
        assertThrows(IllegalStateException.class, () ->
                new PersonBuilder()
                        .setName("Анна")
                        .setAge(31)
                        .build());
    }
}