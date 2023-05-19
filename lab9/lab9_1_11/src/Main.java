import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.Random;
public class Main {
    public static final Random RNG = new Random(Calendar.getInstance().getTimeInMillis());
    public static void main(String[] args) {
        Collection<Assignement> assignements = new ArrayList<>();
        IntStream.range(0, 10).forEach(i -> assignements.add(new Assignement(i, RNG.nextInt(60,100))));
        System.out.println(assignements.stream().mapToDouble(Assignement::mark).average().orElse(0.0));
    }
}
record Assignement(int info, int mark){}