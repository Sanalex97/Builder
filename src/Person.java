import java.util.Optional;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected OptionalInt age = OptionalInt.empty();
    protected Optional<String> city = Optional.empty();

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, OptionalInt age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age.orElseGet(() -> {
            System.out.println("Возраст не известен");
            return -1;
        }));
    }

    public String getCity() {
        return city.orElse(null);
    }

    public void HappyBirthday() {
        if (age.isPresent()) {
            age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    public void setAddress(String address) {
        city = Optional.ofNullable(address);
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder();
        personBuilder.setSurname(surname);
        personBuilder.setAge(1);
        personBuilder.setAddress(getCity());
        return personBuilder;
    }

    @Override
    public String toString() {
        String mes = "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'';

        if (age.isPresent()) {
            mes += " age='" + age.getAsInt() + '\'';
        }
        if (city.isPresent()) {
            mes += " city='" + city.get() + '\'';
        }
        return mes + "}'";
    }
}
