import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int maxlen = 0, minlen = Integer.MAX_VALUE;
        String longest = "", shortest = "";

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            if (s.length() > maxlen) {
                longest = s;
                maxlen = s.length();
            }
            if (s.length() < minlen) {
                shortest = s;
                minlen = s.length();
            }
        }
        System.out.println(shortest + " " + minlen);
        System.out.println(longest + " " + maxlen);

        String REQUEST_DATETIME = "17.02.2023 15:39";
        System.out.println("Капкин " +
                DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm ").format(LocalDateTime
                        .parse(REQUEST_DATETIME, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))) +
                DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").format(LocalDateTime.now()));
    }
}