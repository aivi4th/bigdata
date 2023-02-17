import java.util.Scanner;

public class Main {

    public static int sumOfSquares(int num){
        int rem = 0, sum = 0;
        while (num > 0) {
            rem = num%10;
            sum = sum + (rem*rem);
            num = num/10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        for(int i : array){
            int result = i;
            while(result != 1 && result != 4){
                result = sumOfSquares(result);
            }
            if(result == 1) {
                System.out.println(i);
            }
        }
    }
}