import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Collection<Student> students = Arrays.asList(
                new Student("Ivan", 40),
                new Student("Petr", 60),
                new Student("Olga", 70)
        );
        System.out.println(students.stream().filter(s -> s.name().charAt(0) == 'P'
                                                    && s.rate() <= 60
                                                    && s.rate() >= 40)
                                            .collect(Collectors.toList()));
    }
}
record Student(String name, int rate) {}