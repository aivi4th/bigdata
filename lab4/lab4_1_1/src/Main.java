import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        City zel = new City("Zelenograd");
        zel.addProspect(zel.new GeoObject("Panfilovsky",
                new City.GPSCoordinates(55.9884, 37.1993),
                new City.GPSCoordinates(55.9863, 37.2123)));
        zel.addProspect(zel.new GeoObject("Moskovsky",
                new City.GPSCoordinates(55.9869, 37.1933),
                new City.GPSCoordinates(55.9818, 37.2062)));
        zel.addProspect(zel.new GeoObject("Tsentralny",
                new City.GPSCoordinates(55.9914, 37.2084),
                new City.GPSCoordinates(55.9828, 37.2045)));
        zel.addStreet(zel.new GeoObject("Akademika Valieva",
                new City.GPSCoordinates(55.9812, 37.1964),
                new City.GPSCoordinates(55.9854, 37.1918)));
        zel.addStreet(zel.new GeoObject("Junosti",
                new City.GPSCoordinates(55.9856, 37.1942),
                new City.GPSCoordinates(55.9784, 37.1936)));
        zel.addSquare(zel.new GeoObject("Junosti",
                new City.GPSCoordinates(55.9827, 37.1915),
                new City.GPSCoordinates(55.9826, 37.1903),
                new City.GPSCoordinates(55.9815, 37.1903),
                new City.GPSCoordinates(55.9816, 37.1915)));

        System.out.println("Zelenograd prospects:");
        System.out.println(zel.prospects.toString());
        System.out.println("Zelenograd streets:");
        System.out.println(zel.streets.toString());
        System.out.println("Zelenograd squares:");
        System.out.println(zel.squares.toString());
    }
}

class City {
    public String name;
    public List<GeoObject> prospects;
    public List<GeoObject> streets;
    public List<GeoObject> squares;
    public City (String name) {
        this.name = name;
        this.prospects = new ArrayList<>();
        this.streets = new ArrayList<>();
        this.squares = new ArrayList<>();
    }
    public void addProspect (GeoObject prospect) {
        this.prospects.add(prospect);
    }
    public void addStreet (GeoObject street) {
        this.streets.add(street);
    }
    public void addSquare (GeoObject square) {
        this.squares.add(square);
    }
    class GeoObject {
        public String name;
        private GPSCoordinates [] coordinates;
        public GeoObject (String name, GPSCoordinates... coordinates) {
            this.name = name;
            this.coordinates = coordinates;
        }
        @Override
        public String toString() {
            return this.name + " " + Arrays.toString(this.coordinates);
        }
    }
    public static class GPSCoordinates {
        public double latitude;
        public double longitude;
        public GPSCoordinates (double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
        @Override
        public String toString() {
            return "lat " + latitude + " lon " + longitude;
        }
    }
}