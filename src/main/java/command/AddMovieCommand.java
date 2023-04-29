package command;

import file.FileManager;
import movie.Movie;
import movie.MovieBuilder;
import movie.type.*;

import java.util.List;
import java.util.Scanner;

public class AddMovieCommand implements Command {
    @Override
    public void execute() {
        System.out.println("*** Add Movie Command ***");
        List<Movie> movieList = FileManager.loadAllMovie();
        movieList.add(getInfoAboutMovie());
        FileManager.saveAllMovie(movieList);
    }

    public Movie getInfoAboutMovie() {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String movieType = scanner.nextLine();
        return new MovieBuilder(title, setMovieType(movieType)).build();
    }

    public MovieType setMovieType(String movieType) {
        switch (movieType) {
            case "Regular" -> {
                return new Regular();
            }
            case "NewRelease" -> {
                return new NewRelease();
            }
            case "Children" -> {
                return new Children();
            }
            case "Drama" -> {
                return new Drama();
            }
        }
        return null;
    }
}
