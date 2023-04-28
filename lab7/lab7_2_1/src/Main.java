import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\b(\\S)(\\S)(?:(\\S)(?:(\\S)(?:(\\S)(?:(\\S)(?:(\\S)(?:(\\S)(?:(\\S))?)?)?)?)?)?)?\\b(?=.*?\\b((?:(?:(?:(?:(?:(?:(?:\\9)?\\8)?\\7)?\\6)?\\5)?\\4)?\\3)?\\2\\1)\\b)");
        Matcher matcher = pattern.matcher(input);

        System.out.println(matcher.results().map(MatchResult::group).collect(Collectors.toList()));
    }
}