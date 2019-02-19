import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main extends Object {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        ticket.number = 1234;

        Book book = new Book();
        book.author = "Mark Twen";
        book.name = "Adventure";

        Map<Ticket, Book> library = new HashMap<>();
        library.put(ticket, book);

        Ticket ticket2 = new Ticket();
        ticket2.number = 1234;

        Book twenBook = library.get(ticket2);
        System.out.println(twenBook.author);

        System.out.println(book.hashCode());
        System.out.println(new Book().hashCode());

    }
}
class Book{
    String author;
    String name;
}
class Ticket{
    int number;
    String libraryName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return number == ticket.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}