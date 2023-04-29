package movie;

import movie.type.MovieType;

import java.util.ArrayList;
import java.util.List;

public class MovieBuilder {
    private final List<String> actors;
    private String title;
    private MovieType movieType;
    private String country;
    private String description;
    private String director;

    public MovieBuilder(String title, MovieType movieType) {
        this.title = title;
        this.movieType = movieType;
        this.country = "";
        this.description = "";
        this.director = "";
        this.actors = new ArrayList<>();
    }

    public MovieBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public MovieBuilder setMovieType(MovieType movieType) {
        this.movieType = movieType;
        return this;
    }

    public MovieBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public MovieBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public MovieBuilder setDirector(String director) {
        this.director = director;
        return this;
    }

    public MovieBuilder addActors(String actors) {
        this.actors.add(actors);
        return this;
    }

    public Movie build() {
        return new Movie(title, movieType, country, description, director, actors);
    }
}
