import java.util.Calendar;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Main {
    public static final int GIVEN_NUMBER = 256;
    public static final int SET_INSERTION_ATTEMPTS = 100;
    public static final Random RNG = new Random(Calendar.getInstance().getTimeInMillis());
    public static void main(String[] args) {
        Numbers numbers = new Numbers();
        IntStream.range(0, SET_INSERTION_ATTEMPTS).forEach((unused) -> numbers.add(RNG.nextInt(SET_INSERTION_ATTEMPTS*SET_INSERTION_ATTEMPTS)));

        int firstClosest = numbers.closestToGiven(GIVEN_NUMBER);
        System.out.println(firstClosest);
        numbers.remove(firstClosest);
        System.out.println(numbers.closestToGiven(GIVEN_NUMBER));
    }
}
class Numbers extends TreeSet<Integer> {
    public int closestToGiven (int given) {
        return this.lower(given) == null ? this.first() : this.higher(given) == null ? this.last() :
                Math.abs(given - this.higher(given)) < Math.abs(given - this.lower(given)) ?
                        this.higher(given) : this.lower(given);
    }
}