import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String input = "lorem ipsum dolor sit amet";
        String longestSubstring = "";

        for (char c : input.toCharArray()) {
            Pattern pattern = Pattern.compile("%c.*%c".formatted(c, c));
            Matcher matcher = pattern.matcher(input);
            if (matcher.find() && longestSubstring.length() < matcher.group().length()) {
                longestSubstring = matcher.group();
            }
        }

        System.out.println(input.replaceFirst(longestSubstring, ""));
    }
}