package customer;

import file.FileManager;

import java.io.Serializable;
import java.util.List;

public class Customer implements Serializable {
    private final String name;
    private final List<Rental> rentals;
    private double totalAmount;
    private int frequentRenterPoints;

    public Customer(String name, List<Rental> rentals) {
        this.name = name;
        this.rentals = rentals;
    }

    public String getName() {
        return name;
    }

    public String createFullInfo() {
        StringBuilder result = new StringBuilder(createInfoAboutCustomer());
        for (Rental each : rentals) {
            double thisAmount = each.getAmount();
            frequentRenterPoints = each.getFrequentRenterPoint(frequentRenterPoints);
            result.append(each.movie().getTitle()).append("\t").append(thisAmount).append("\n");
            totalAmount += thisAmount;
        }
        return result.append(createInfoAboutPrice()).toString();
    }

    private String createInfoAboutCustomer() {
        return "Rental Record for " + getName() + "\n";
    }

    private String createInfoAboutPrice() {
        return "Amount owed is " + totalAmount + "\n" +
                "You earned " + frequentRenterPoints + " frequent renter points";
    }

    public void save() {
        FileManager.saveObject(this, this.getName());
    }
}