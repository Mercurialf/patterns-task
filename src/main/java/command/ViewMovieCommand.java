package command;

import file.FileManager;
import movie.Movie;

import java.util.List;

public class ViewMovieCommand implements Command {
    @Override
    public void execute() {
        System.out.println("*** View Movie Command ***");
        List<Movie> movieList = FileManager.loadAllMovie();
        for (Movie movie : movieList) {
            System.out.println(movie);
        }
    }
}