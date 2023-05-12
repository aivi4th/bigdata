import java.util.Calendar;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    static final Random RNG = new Random(Calendar.getInstance().getTimeInMillis());
    public static void main(String[] args) {
        Bank account = new Bank(RNG.nextDouble(1000.0));
        IntStream.range(0, 100).forEach((unused) -> {
            new Thread(() -> {account.deposit(RNG.nextDouble(2000.0));}).start();
            new Thread(() -> {account.withdraw(RNG.nextDouble(5000.0));}).start();
        });
    }
}
class Bank {
    private double balance;
    Bank(double balance) {
        this.balance = balance;
    }
    public synchronized void deposit(double debet) {
        this.balance += debet;
        System.out.println(this.balance);
    }
    public synchronized void withdraw(double credit) {
        if (this.balance > credit) {
            this.balance -= credit;
            System.out.println(this.balance);
        } else {
            System.out.println("Not enough money to withdraw");
        }
    }
}