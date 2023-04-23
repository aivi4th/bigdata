import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static final Integer AUTOMOBILE_COUNT = 42;
    public static final Random RNG = new Random(Calendar.getInstance().getTimeInMillis());
    public static void main(String[] args) {
        LinkedList<Automobile> automobiles = new LinkedList<>();
        IntStream.range(0, AUTOMOBILE_COUNT).forEach((unused) -> automobiles.add(new Automobile(RNG.nextDouble(), RNG.nextDouble())));
        automobiles.sort(Comparator.comparing(Automobile::startingPosition));

        long count = IntStream.range(0, automobiles.size())
                .flatMap(i -> IntStream.range(i + 1, automobiles.size())
                        .filter(j -> automobiles.get(j).velocity() < automobiles.get(i).velocity()))
                .count();
        System.out.println(count);
    }
}
record Automobile(double startingPosition, double velocity) {}