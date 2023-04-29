package command;

import file.FileManager;
import movie.Movie;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Scanner;

public class SearchMovieCommand implements Command {
    @Override
    public void execute() {
        System.out.println("*** Search Movie Command ***");
        receivingInformation();
    }

    private void receivingInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите характеристику для поиска (например, title): ");
        String characteristic = scanner.nextLine();
        System.out.println("Введите значения для поиска: ");
        String value = scanner.nextLine();
        findMovie(characteristic, value);
    }

    private void findMovie(String characteristic, String value) {
        List<Movie> movieList = FileManager.loadAllMovie();
        for (Movie movie : movieList) {
            if (characteristic.equals("title") && movie.getTitle().equals(value)) {
                System.out.println(movie);
            } else if (characteristic.equals("country") && movie.getCountry().equals(value)) {
                System.out.println(movie);
            }
        }
    }

    private void findMovieUsingLambda(String characteristic, String value) {
        List<Movie> movieList = FileManager.loadAllMovie();
        movieList.stream()
                .filter(movie -> {
                    try {
                        Field field = Movie.class.getDeclaredField(characteristic);
                        field.setAccessible(true);
                        Object fieldValue = field.get(movie);
                        return fieldValue.equals(value);
                    } catch (NoSuchFieldException | IllegalAccessException exception) {
                        return false;
                    }
                }).forEach(System.out::println);
    }
}