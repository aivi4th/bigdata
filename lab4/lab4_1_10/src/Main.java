import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema("some address");
        cinema.addSeance(cinema.new Seance(
                new Cinema.Film("awdwd", "awdo", 2012, 130),
                LocalDateTime.of(2023, 03, 31, 23, 55)
        ));
        cinema.addSeance(cinema.new Seance(
                new Cinema.Film("awndawd", "awd", 2021, 230),
                LocalDateTime.of(2023, 04, 01, 10, 30)
        ));

        System.out.println(Arrays.toString(cinema.getFilms()));
    }
}

class Cinema {
    private String address;
    private List<Seance> seances;
    public Cinema (String address) {
        this.address = address;
        this.seances = new ArrayList<>();
    }
    public void addSeance(Seance seance) {
        this.seances.add(seance);
    }
    public class Seance {
        private LocalDateTime start;
        private Film film;
        public Seance (Film film, LocalDateTime start) {
            this.film = film;
            this.start = start;
        }
        public Film getFilm() {
            return film;
        }
    }
    public static class Film {
        private String name;
        private String director;
        private int year;
        private int duration;
        public Film (String name, String director, int year, int duration) {
            this.name = name;
            this.director = director;
            this.year = year;
            this.duration = duration;
        }
        @Override
        public String toString() {
            return name + "\t" + year + "\t" + director + "\t" + duration;
        }
    }
    public Film[] getFilms() {
        return seances.stream().map(Seance::getFilm).toArray(Film[]::new);
    }
}