package solution.epam;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public Application() {
    }

    public void start() {
        List<Book> books = new ArrayList<Book>();
        Book book = Book.BookBuilder.newInstance()
                .setTitle("Introduction to the Theory of Programming Languages and Touch of Class")
                .setAuthor("Bertrand Meyer")
                .setDescription("This book is an excellent reference for understanding how to architect a language")
                .setYearOfPublication(1990).build();
        books.add(book);
        System.out.println(books);
    }


    public static void main(String[] args) {
        new Application().start();
    }
}
