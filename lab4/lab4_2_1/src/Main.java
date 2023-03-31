public class Main {
    public static void main(String[] args) {
        Book [] books = new Book[3];
        books[0] = new Directory("ISBN 978-1-42-007544-1", "Klaus D. Sattler", "Handbook of Nanophysics", 2010, "CRC Press", 22);
        books[1] = new Directory("ISBN 978-1-49-870306-2", "Yury Gogotsi", "Nanomaterials Handbook", 2017, "CRC Press", 38);
        books[2] = new Encyclopedia("ISBN 978-0-08-045046-9", "Larry R. Squire", "Encyclopedia of Neuroscience", 2009, "Academic Press", 6000);

        for (Book book : books) {
            book.display();
            System.out.println();
        }
    }

}
abstract class Book {
    protected String cipher;
    protected String author;
    protected String title;
    protected int year;
    protected String publisher;
    public Book (String cipher, String author, String title, int year, String publisher) {
        this.cipher = cipher;
        this.author = author;
        this.title = title;
        this.year = year;
        this.publisher = publisher;
    }
    public abstract int rate();
    public abstract void display();
}
class Directory extends Book {
    private int hIndex;
    public Directory (String cipher, String author, String title, int year, String publisher, int hIndex) {
        super(cipher, author, title, year, publisher);
        this.hIndex = hIndex;
    }
    public int rate() {
        return this.hIndex;
    }
    public void display() {
        System.out.println("Directory");
        System.out.println("cipher: " + this.cipher);
        System.out.println("editor: " + this.author);
        System.out.println("title: " + this.title);
        System.out.println("publisher: " + this.publisher);
        System.out.println("h-Index: " + this.rate());
    }
}
class Encyclopedia extends Book {
    private int citation;
    public Encyclopedia (String cipher, String author, String title, int year, String publisher, int citation) {
        super(cipher, author, title, year, publisher);
        this.citation = citation;
    }
    public int rate() {
        return this.citation;
    }
    public void display() {
        System.out.println("Encyclopedia");
        System.out.println("cipher: " + this.cipher);
        System.out.println("editor-in-chief: " + this.author);
        System.out.println("title: " + this.title);
        System.out.println("publisher: " + this.publisher);
        System.out.println("citation count: " + this.rate());
    }
}