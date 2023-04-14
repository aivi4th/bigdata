import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Train [] trains = {
                new Train("Msk", 1337, LocalDateTime.of(2023, 02, 12, 22, 55),
                        4, 8, 15, 16),
                new Train("Spb", 420, LocalDateTime.of(2023, 03, 01, 12, 30),
                        7, 3, 55, 6),
                new Train("Msk", 69, LocalDateTime.of(2023, 4, 1, 7, 31),
                        0, 0, 0, 1)
        };

        System.out.println("Trains to Msk");
        for (Train train : trains) {
            if (train.getDestination() == "Msk") {
                System.out.println(train.toString());
            }
        }

        System.out.println("Trains to Msk after 2023-03-01 00:00");
        for (Train train : trains) {
            if (train.getDestination() == "Msk" && train.getDeparture().isAfter(LocalDateTime.of(2023, 3, 1, 0, 0))) {
                System.out.println(train.toString());
            }
        }

        System.out.println("Trains to Msk with general seats");
        for (Train train : trains) {
            if (train.getDestination() == "Msk" && train.getGeneralSeats() > 0) {
                System.out.println(train.toString());
            }
        }
    }
}

class Train {
    private String destination;
    private int trainNumber;
    private LocalDateTime departure;
    private int generalSeats;
    private int coupeSeats;
    private int plazkartSeats;
    private int luxSeats;
    public Train (String destination, int trainNumber, LocalDateTime departure,
                  int generalSeats, int coupeSeats, int plazkartSeats, int luxSeats) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departure = departure;
        this.generalSeats = generalSeats;
        this.coupeSeats = coupeSeats;
        this.plazkartSeats = plazkartSeats;
        this.luxSeats = luxSeats;
    }
    public Train() {

    }
    public String getDestination() {
        return this.destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public int getTrainNumber() {
        return this.trainNumber;
    }
    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }
    public LocalDateTime getDeparture() {
        return this.departure;
    }
    public void setDeparture(LocalDateTime departure) {
        if (departure.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("Departure should be after before");
        this.departure = departure;
    }
    public int getGeneralSeats() {
        return this.generalSeats;
    }
    public void setGeneralSeats(int generalSeats) {
        if (generalSeats < 0)
            throw new IllegalArgumentException("Number of seats should be more than 0");
        this.generalSeats = generalSeats;
    }
    public int getCoupeSeats() {
        return this.coupeSeats;
    }
    public void setCoupeSeats(int coupeSeats) {
        if (coupeSeats < 0)
            throw new IllegalArgumentException("Number of seats should be more than 0");
        this.coupeSeats = coupeSeats;
    }
    public int getPlazkartSeats() {
        return this.plazkartSeats;
    }
    public void setPlazkartSeats(int plazkartSeats) {
        if (plazkartSeats < 0)
            throw new IllegalArgumentException("Number of seats should be more than 0");
        this.plazkartSeats = plazkartSeats;
    }
    public int getLuxSeats() {
        return this.luxSeats;
    }
    public void setLuxSeats(int luxSeats) {
        if (luxSeats < 0)
            throw new IllegalArgumentException("Number of seats should be more than 0");
        this.luxSeats = luxSeats;
    }
    public String toString() {
        return "Train #" + this.trainNumber +
                "\tdestinated to " + this.destination +
                "\tdepartures " + this.departure +
                "\tgeneral seats " + this.generalSeats +
                "\tcoupe seats " + this.coupeSeats +
                "\tplazkart seats " + this.plazkartSeats +
                "\tlux seats " + this.luxSeats;
    }
}