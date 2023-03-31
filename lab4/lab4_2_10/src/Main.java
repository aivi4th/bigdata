public class Main {
    public static void main(String[] args) {
        Film[] films = new Film[3];
        films[0] = new DomesticFilm("Солярис", "Андрей Тарковский", "1972");
        films[1] = new Comedy("Осенний марафон", "Георгий Данелия", "1979", "Георгий Данелия, Олег Басилашвили");
        films[2] = new DomesticFilm("Иди и смотри", "Элем Климов", "1985");

        for (Film film : films) {
            film.display();
            System.out.println();
        }
    }
}
interface Film {
    void display();
}
class DomesticFilm implements Film {
    private String title;
    private String director;
    private String year;
    public DomesticFilm(String title, String director, String year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }
    @Override
    public void display() {
        System.out.println("Domestic Film:");
        System.out.println("Title: " + title);
        System.out.println("Director: " + director);
        System.out.println("Year: " + year);
    }
}
class Comedy extends DomesticFilm {
    private String cast;
    public Comedy(String title, String director, String year, String cast) {
        super(title, director, year);
        this.cast = cast;
    }
    @Override
    public void display() {
        System.out.println("Comedy:");
        super.display();
        System.out.println("Cast: " + cast);
    }
}