

public class Game implements ProductType {
    String releaseDate, companyName;
    double rating;

    public Game(String releaseDate, String companyName, double rating) {
        this.releaseDate = releaseDate;
        this.companyName = companyName;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Game{" +
                "releaseDate = " + releaseDate +
                ", companyName = " + companyName +
                ", rating = " + rating +
                '}';
    }
}
