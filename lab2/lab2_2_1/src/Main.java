import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n][n];
        Random rnd = new Random(Calendar.getInstance().getTimeInMillis());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = rnd.nextInt(-n, n+1);
            }
        }

        int k_col = scanner.nextInt();
        Arrays.sort(a, Comparator.comparingInt(o -> o[k_col]));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}