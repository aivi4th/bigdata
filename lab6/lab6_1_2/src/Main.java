import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static final int MEASUREMENTS_COUNT = 42;
    public static <T, U> List<Pair<T, U>> zip(List<T> list1, List<U> list2) {
        List<Pair<T, U>> result = new ArrayList<>();
        Iterator<T> iter1 = list1.iterator();
        Iterator<U> iter2 = list2.iterator();
        while (iter1.hasNext() && iter2.hasNext()) {
            result.add(new Pair<>(iter1.next(), iter2.next()));
        }
        return result;
    }
    public static void main(String[] args) {
        Random rnd = new Random(Calendar.getInstance().getTimeInMillis());
        List<Double> current = new LinkedList<>();
        List<Double> voltage = new LinkedList<>();

        IntStream.range(0, MEASUREMENTS_COUNT).forEach(i -> {
            current.add(rnd.nextDouble());
            voltage.add(rnd.nextDouble());
        });
        Collections.sort(current);
        Collections.sort(voltage);

        double ibar = current.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        double vbar = voltage.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);

        double r = zip(current, voltage).stream().mapToDouble(pair -> (pair.first()-ibar) * (pair.second()-vbar)).sum()/
                current.stream().mapToDouble(i -> Math.pow((i-ibar), 2)).sum();
        System.out.println(r);
    }
}

record Pair<T, U>(T first, U second) {
}