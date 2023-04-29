package movie;


import movie.type.MovieType;

import java.io.Serializable;
import java.util.List;

public class Movie implements Serializable {
    private String title;
    private MovieType movieType;
    private String country;
    private String description;
    private String director;
    private List<String> actors;

    public Movie(String title, MovieType movieType, String country,
                 String description, String director, List<String> actors) {
        this.title = title;
        this.movieType = movieType;
        this.country = country;
        this.description = description;
        this.director = director;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription() {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public String toString() {
        return "****************************" + "\n" +
                getTitle() + "\n" +
                getMovieType().toString() + "\n" +
                getCountry() + "\n" +
                getDescription() + "\n" +
                getActors().toString() + "\n" +
                "****************************" + "\n";
    }
}
