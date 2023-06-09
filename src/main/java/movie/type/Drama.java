package movie.type;

import java.io.Serializable;

public class Drama implements MovieType, Serializable {
    @Override
    public double getAmount(int daysRented) {
        double result = 2;
        if (daysRented > 2) result += (daysRented - 2) * 1.5;
        return result;
    }
}
