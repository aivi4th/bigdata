import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String reference = args[0];
        Scanner scanner = new Scanner(System.in);
        String passwd = scanner.nextLine();

        System.out.println(passwd.equals(reference));
    }
}