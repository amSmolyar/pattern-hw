package ru.netology;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age = -1;
    protected String address;

    private Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    private Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    private Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.name;
        this.surname = personBuilder.surname;
        this.age = personBuilder.age;
        this.address = personBuilder.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public boolean hasAge() {
        if (this.age == -1)
            return false;
        else
            return true;
    }

    public boolean hasAddress() {
        if (this.address == null)
            return false;
        else
            return true;
    }

    public void happyBirthday() {
        if (hasAge())
            age++;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAge(0)
                .setAddress(address);
    }

    @Override
    public String toString() {
        return "\n{Person: " +
                "\n     name: " + name + "," +
                "\n     surname: " + surname + "," +
                "\n     age: " + age + "," +
                "\n     address: " + address +
                "\n}";
    }

    @Override
    public int hashCode() {
        return (age + name.hashCode() + surname.hashCode() + address.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if ((o == null) || (o.getClass() != this.getClass()))
            return false;

        Person that = (Person) o;

        if (that.getName().equals(name) &&
                that.getSurname().equals(surname) &&
                that.getAge() == age &&
                that.getAddress().equals(address))
            return true;
        else
            return false;
    }


}
