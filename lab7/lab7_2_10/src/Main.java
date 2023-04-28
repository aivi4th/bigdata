import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Matcher matcher = Pattern.compile("[^A-Za-z]+").matcher(input);
        String substr = matcher.results().map(MatchResult::group)
                .max(Comparator.comparing(String::length)).orElse("");
        System.out.println(substr);
    }
}