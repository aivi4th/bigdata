import java.util.Arrays;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        Collection<Person> people = Arrays.asList(
                new Person("Ivan", 16, Person.Gender.MALE),
                new Person("Petr", 23, Person.Gender.MALE),
                new Person("Maria", 42, Person.Gender.FEMALE)
        );
        System.out.println(people.stream().filter(p -> p.gender() == Person.Gender.MALE)
                                        .max((p1, p2) -> Integer.compare(p1.age(), p2.age())));
    }
}
record Person(String name, int age, Gender gender) {
    public enum Gender {
        MALE,
        FEMALE,
        OTHER
    }
}