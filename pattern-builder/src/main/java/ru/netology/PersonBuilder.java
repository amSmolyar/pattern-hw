package ru.netology;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public PersonBuilder() {
        this.name = null;
        this.surname = null;
        this.age = -1;
        this.address = null;
    }

    public PersonBuilder setName(String name) {
        if (this.name == null)
            this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        if (this.surname == null)
            this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if ((age >= 0) && (age < 127))
            this.age = age;
        else
            throw new IllegalArgumentException("Попытка ввести невозможный возраст");

        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        if ((name == null) || (surname == null) || (age == -1))
            throw new IllegalStateException("Не все данные были введены");
        return new Person(this);
    }
}
