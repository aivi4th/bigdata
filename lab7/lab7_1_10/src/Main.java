import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        char openChar = scanner.next().charAt(0);
        char closeChar = scanner.next().charAt(0);
        System.out.println(text.replaceAll("\\%c.*\\%c".formatted(openChar, closeChar), ""));
    }
}