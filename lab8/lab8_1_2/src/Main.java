import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();
        IntStream.range(0,20).forEach((unused) -> {
            new Thread(() -> {
                try {
                    robot.stepLeft();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
            new Thread(() -> {
                try {
                    robot.stepRight();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        });
    }
}
class Robot {
    private Foot forwardFoot;
    public synchronized void stepLeft() throws InterruptedException {
        while (this.forwardFoot == Foot.LEFT) {
            wait();
        }
        System.out.println("LEFT");
        this.forwardFoot = Foot.LEFT;
        notifyAll();
    }
    public synchronized void stepRight() throws InterruptedException {
        while (this.forwardFoot == Foot.RIGHT) {
            wait();
        }
        System.out.println("RIGHT");
        this.forwardFoot = Foot.RIGHT;
        notifyAll();
    }
    private enum Foot {
        LEFT, RIGHT
    }
}