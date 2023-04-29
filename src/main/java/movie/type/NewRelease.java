package movie.type;

import java.io.Serializable;

public class NewRelease implements MovieType, Serializable {
    @Override
    public double getAmount(int daysRented) {
        return daysRented * 3;
    }
}
