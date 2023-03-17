import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Year y1 = new Year(2023);
        y1.setDate(03, 01);
        y1.printDayOfWeek();

        System.out.println(Year.getDaysBetween(2024, 02, 28, 2024, 03, 01));
        System.out.println(Year.getMonthsBetween(2023, 02, 2024, 07));

        Year y2 = new Year(2023);
        y2.setDate(03, 01);
        System.out.println(y1.equals(y2));
        System.out.println(y1.toString());
        System.out.println(y1.hashCode());
    }
}
class Day {
    private int day;
    public Day(int day) {
        this.day = day;
    }
    public int getDay() {
        return day;
    }
    public void setDay(int day) {
        this.day = day;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Day)) return false;
        Day d = (Day) o;
        return day == d.getDay();
    }
}
class Month {
    private int month;
    public Month(int month) {
        this.month = month;
    }
    public int getMonth() {
        return month;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Month)) return false;
        Month m = (Month) o;
        return month == m.getMonth();
    }
}
class Year {
    private int year;
    private Month month;
    private Day day;
    public Year(int year) {
        this.year = year;
    }
    public void setDate(int month, int day) {
        this.month = new Month(month);
        this.day = new Day(day);
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public Month getMonth() {
        return month;
    }
    public Day getDay() {
        return day;
    }
    public void printDayOfWeek() {
        LocalDate date = LocalDate.of(year, month.getMonth(), day.getDay());
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        System.out.println(dayOfWeek);
    }
    public static int getDaysBetween(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) {
        LocalDate startDate = LocalDate.of(startYear, startMonth, startDay);
        LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);
        Period period = Period.between(startDate, endDate);
        return period.getDays();
    }
    public static int getMonthsBetween(int startYear, int startMonth, int endYear, int endMonth) {
        return endMonth - startMonth + 1 + (endYear - startYear) * 12;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Year)) return false;
        Year y = (Year) o;
        return year == y.getYear() && month.equals(y.getMonth()) && day.equals(y.getDay());
    }
    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
    @Override
    public String toString() {
        return "Year{" +
                "year=" + year +
                ", month=" + month.getMonth() +
                ", day=" + day.getDay() +
                '}';
    }
}
