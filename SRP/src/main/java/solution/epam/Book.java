package solution.epam;


public class Book {

    private String author;

    private String authorDescription;

    private int yearOfPublication;

    private String title;

    private String description;

    public Book(BookBuilder bookBuilder) {
        this.author = bookBuilder.author;
        this.authorDescription = bookBuilder.authorDescription;
        this.yearOfPublication = bookBuilder.yearOfPublication;
        this.title = bookBuilder.title;
        this.description = bookBuilder.description;
    }


    /////

    public static class BookBuilder {
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
            return new Book(this);
        }
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
