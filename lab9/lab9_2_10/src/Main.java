import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(4, 8, 15, 16, 23, 42);
        System.out.println(numbers.stream()
                .filter(number -> number > 10)
                .reduce(0, Integer::sum));
    }
}