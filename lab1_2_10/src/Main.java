import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        Map<Integer, Integer> frequencies = new LinkedHashMap<Integer, Integer>();
        for (int key : array) {
            int value = frequencies.getOrDefault(key, 0);
            frequencies.put(key, value+1);
        }

        System.out.println(frequencies.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).map(Map.Entry::getKey).collect(Collectors.toList()));

    }
}