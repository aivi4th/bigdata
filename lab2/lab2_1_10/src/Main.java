import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        float k = scanner.nextFloat();
        switch ((-10 * k < k && k <= 5) ? 0 :
                (0 <= k && k <= 10) ? 1 :
                (5 <= k && k <= 15) ? 2 :
                (10 <= k && k <= 10 * k) ? 3 : -1) {
            case 0 -> System.out.println(k + " принадлежит интервалу (" + -10 * k + ", 5]");
            case 1 -> System.out.println(k + " принадлежит интервалу [0, 10]");
            case 2 -> System.out.println(k + " принадлежит интервалу [5, 15]");
            case 3 -> System.out.println(k + " принадлежит интервалу [10, " + 10 * k + "]");
            default -> System.out.println(k + " не принадлежит ни к одному из интервалов (" + -10 * k + ", 5], [0, 10], [5, 15], [10, " + 10 * k + "]");
        }

        String REQUEST_DATETIME = "17.02.2023 15:39";
        System.out.println("Капкин " +
                DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm ").format(LocalDateTime
                        .parse(REQUEST_DATETIME, DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))) +
                DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").format(LocalDateTime.now()));
    }
}