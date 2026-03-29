

public class Book implements ProductType {
    String authorName, language;

    public Book(String authorName, String language) {
        this.authorName = authorName;
        this.language = language;
    }

    @Override
    public String toString() {
        return "Book{" +
                "authorName = " + authorName +
                ", language = " + language +
                '}';
    }
}
