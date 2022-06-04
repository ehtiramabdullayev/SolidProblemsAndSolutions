package solution.epam;

/**
 * @author Ehtiram Etibarovich Abdullayev on 26.08.2019
 * @project oo-principles
 */
public class BookBuilder {
    private String author;

    private String authorDescription;

    private int yearOfPublication;

    private String title;

    private String description;

    public BookBuilder() {
    }

    public static BookBuilder newInstance() {
        return new BookBuilder();
    }

    public BookBuilder setAuthor(String author) {
        this.author = author;
        return this;
    }

    public BookBuilder setAuthorDescription(String authorDescription) {
        this.authorDescription = authorDescription;
        return this;

    }

    public BookBuilder setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
        return this;

    }

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;

    }

    public BookBuilder setDescription(String description) {
        this.description = description;
        return this;

    }

    public Book build() {
        return new Book(author, authorDescription, yearOfPublication, title, description);
    }
}
