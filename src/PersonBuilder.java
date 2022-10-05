import java.util.OptionalInt;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String city;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String city) {
        this.city = city;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalArgumentException("Данные заполнены не полностью");
        } else if (age <= 0) {
            throw new IllegalArgumentException("Возраст заполнен не корректно");
        }

        Person person;
        person = new Person(name, surname, OptionalInt.of(age));
        if (city != null) {
            person.setAddress(city);
        }
        return person;
    }
}

