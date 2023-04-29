import command.*;
import customer.Customer;
import customer.Rental;
import file.FileManager;
import movie.Movie;
import movie.MovieBuilder;
import movie.type.Children;
import movie.type.NewRelease;
import movie.type.Regular;
import notification.Notification;
import notification.type.HtmlCheck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.createTestListOfMovie();
        main.TestCreateCustomer();
        main.TestCommandMenu();
    }

    private void TestCreateCustomer() {
        List<Rental> rentals = List.of(
                new Rental(new MovieBuilder("Rambo", new NewRelease()).setCountry("USA").build(), 5)
        );
        Customer customer = new Customer("John Doe", rentals);
        Notification notification = new HtmlCheck().createNotification();
        notification.notify(customer.createFullInfo());
        customer.save();
    }

    private void TestCommandMenu() {
        Menu menu = new Menu(createCommandMenu());
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("0 - Просмотреть все фильмы");
            System.out.println("1 - Добавить фильм");
            System.out.println("2 - Поиск по характеристикам");
            System.out.println("9 - Выход");

            int choice = scanner.nextInt();
            if (choice == 9) {
                break;
            }

            menu.executeCommand(choice);
        }
        System.out.println("Выход из программы.");
    }

    private List<Command> createCommandMenu() {
        Command viewMovieCommand = new ViewMovieCommand();
        Command addMovieCommand = new AddMovieCommand();
        Command searchMovieCommand = new SearchMovieCommand();

        List<Command> commands = new ArrayList<>();
        commands.add(viewMovieCommand);
        commands.add(addMovieCommand);
        commands.add(searchMovieCommand);
        return commands;
    }

    private void createTestListOfMovie() {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new MovieBuilder("Rambo", new Regular()).addActors("Sylvester Stallone").build());
        movieList.add(new MovieBuilder("Lord of the Ring", new NewRelease()).setDirector("John Tolkien").build());
        movieList.add(new MovieBuilder("Harry Potter", new Children()).setCountry("USA").build());
        FileManager.saveAllMovie(movieList);
    }
}
