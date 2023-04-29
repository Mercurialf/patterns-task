package customer;

import movie.Movie;
import movie.type.NewRelease;

import java.io.Serializable;

public record Rental(Movie movie, int daysRented) implements Serializable {

    public double getAmount() {
        return movie().getMovieType().getAmount(daysRented);
    }

    public int getFrequentRenterPoint(int frequentRenterPoints) {
        frequentRenterPoints++;
        if ((movie().getMovieType().getClass() == NewRelease.class) && daysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }
}