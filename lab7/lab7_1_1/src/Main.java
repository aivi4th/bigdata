import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int k = scanner.nextInt();
        scanner.nextLine();
        char symbol = scanner.nextLine().charAt(0);

        System.out.println(text.replaceAll("\\b(\\S{" + (k-1) + "})\\S(\\S*)", "$1\\" + symbol + "$2"));
    }
}