public class Main {
    public static void main(String[] args) {
        int sum = 0;
        int prd = 1;
        for (String num: args) {
            sum += Integer.parseInt(num);
            prd *= Integer.parseInt(num);
        }

        System.out.println("sum = " + sum);
        System.out.println("prd = " + prd);
    }
}