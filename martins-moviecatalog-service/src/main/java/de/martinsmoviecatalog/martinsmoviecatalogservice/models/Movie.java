package de.martinsmoviecatalog.martinsmoviecatalogservice.models;

public class Movie {

    private String movieId;
    private String movieName;

    public Movie() { //When we want Java to parse sth that is not an Object to an Object we need to provide an empty Constructor
    }

    public Movie(String movieId, String movieName) {
        this.movieId = movieId;
        this.movieName = movieName;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
