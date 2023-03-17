import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Train> trains = new ArrayList<>();
        trains.add(Administrator.makeTrain(1337, 215, "Msk", "Khi", "Skh", "Krk"));
        trains.add(Administrator.makeTrain(420, 1050, "Msk", "Krk", "Pds", "Tvr"));
        trains.add(Administrator.makeTrain(69, 10500, "Msk", "Tvr", "Blg", "Spb"));

        Request request = Passenger.makeRequest("Krk", LocalDateTime.of(2023, 03, 17, 21, 45));

        List<Train> filtered = trains.stream().filter(o -> o.hasStation(request.getDestination())).toList();

        Train chosen = Passenger.pickOne(filtered);

        Passenger passenger = new Passenger();
        Cheque cheque = new Cheque(chosen);
        passenger.takeCheque(cheque);
    }
}

class Cheque {
    private int cost;
    public Cheque (Train train) {
        this.cost = train.getPrice();
    }
    public int getCost() {
        return cost;
    }
}
class Request {
    private String destination;
    private LocalDateTime departure;
    public Request (String destination, LocalDateTime departure) {
        this.destination = destination;
        this.departure = departure;
    }
    public String getDestination() {
        return destination;
    }
}
class Passenger {
    private Cheque cheque;
    public static Request makeRequest(String destination, LocalDateTime departure) {
        return new Request(destination, departure);
    }
    public static Train pickOne(List<Train> trains) {
        return trains.get(new Random(Calendar.getInstance().getTimeInMillis()).nextInt(trains.size()));
    }
    public void takeCheque(Cheque cheque) {
        this.cheque = cheque;
    }
}
class Administrator {
    public static Train makeTrain(int trainNumber, int price, String... stations) {
        return new Train(trainNumber, price, stations);
    }
}
class Train {
    private int trainNumber;
    private String [] stations;
    private int price;
    public Train(int trainNumber, int price, String... stations) {
        this.trainNumber = trainNumber;
        this.price = price;
        this.stations = stations;
    }
    public int getTrainNumber() {
        return trainNumber;
    }
    public int getPrice() {
        return price;
    }
    public boolean hasStation (String destination) {
        return Arrays.stream(stations).anyMatch(str -> str.equals(destination));
    }
}