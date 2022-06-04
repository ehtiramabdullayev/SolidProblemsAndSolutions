package solution.epam;


public class Book {

    private final String author;

    private final String authorDescription;

    private final int yearOfPublication;

    private final String title;

    private final String description;


    public Book(String author, String authorDescription, int yearOfPublication, String title, String description) {
        this.author = author;
        this.authorDescription = authorDescription;
        this.yearOfPublication = yearOfPublication;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author=" + author +
                ", authorDescription='" + authorDescription + '\'' +
                ", yearOfPublication=" + yearOfPublication +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
