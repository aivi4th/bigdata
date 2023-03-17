import java.util.Objects;
public class Main {
    public static void main(String[] args) {
        Minute m = new Minute(42);
        Hour h = new Hour(13);
        Day d = new Day(h, m);
        d.printCurrentTime();
        System.out.println(d.getTimeOfDay());
        System.out.println(d.equals(new Day(new Hour(13), new Minute(42))));
        System.out.println(d.hashCode());
        System.out.println(d.toString());
    }
}
class Minute {
    private int minute;
    public Minute (int minute) {
        this.minute = minute%60;
    }
    public int getMinute() {
        return minute;
    }
    public void setMinute(int minute) {
        this.minute = minute%60;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Minute)) return false;
        Minute m = (Minute) o;
        return minute == m.minute;
    }
}
class Hour {
    private int hour;
    public Hour (int hour) {
        this.hour = hour%24;
    }
    public int getHour() {
        return hour;
    }
    public void setHour(int hour) {
        this.hour = hour%60;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hour)) return false;
        Hour h = (Hour) o;
        return hour == h.hour;
    }
}
class Day {
    private Hour hour;
    private Minute minute;
    public Day(Hour hour, Minute minute) {
        this.hour = hour;
        this.minute = minute;
    }
    public void printCurrentTime() {
        System.out.println("Current time is: " + hour.getHour() + ":" + minute.getMinute());
    }
    public String getTimeOfDay() {
        int hourValue = hour.getHour();
        if (hourValue >= 6 && hourValue < 12) {
            return "morning";
        } else if (hourValue >= 12 && hourValue < 18) {
            return "afternoon";
        } else if (hourValue >= 18 && hourValue < 22) {
            return "evening";
        } else {
            return "night";
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Day)) return false;
        Day day = (Day) o;
        return hour.equals(day.hour) && minute.equals(day.minute);
    }
    @Override
    public int hashCode() {
        return Objects.hash(hour, minute);
    }
    @Override
    public String toString() {
        return "Day{" +
                "hour=" + hour.getHour() +
                ", minute=" + minute.getMinute() +
                '}';
    }
}
