public class Movie extends  LibraryItem{
    private final String director;
    private final int durationMovie;
    private static int numberOfMovies;

    public Movie(String title, boolean isAvailable, String director, int durationMovie) {
        super(title, isAvailable);
        this.director = director;
        this.durationMovie = durationMovie;
        numberOfMovies++;
    }

    public static int getNumberOfMovies() {
        return numberOfMovies;
    }

    @Override
    public String toString() {
        return String.format("Filmik| Tytuł: %s, Reżyser: %s, Długość filmika: %s", super.getTitle(), director, durationMovie);
    }
}
