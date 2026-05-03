public class RentalQuote {
    private final Car car;
    private final int rentalDays;
    private final double distance;
    private final double rentalCost;
    private final double fuelCost;
    private final double totalCost;

    public RentalQuote(Car car, int rentalDays, double distance, double rentalCost, double fuelCost, double totalCost) {
        if (car == null) {
            throw new IllegalArgumentException("Car cannot be null");
        }
        if (rentalDays <= 0) {
            throw new IllegalArgumentException("Rental days must be positive");
        }
        if (distance < 0) {
            throw new IllegalArgumentException("Distance cannot be negative");
        }
        if (rentalCost < 0) {
            throw new IllegalArgumentException("Rental cost cannot be negative");
        }
        if (fuelCost < 0) {
            throw new IllegalArgumentException("Fuel cost cannot be negative");
        }
        if (totalCost < 0) {
            throw new IllegalArgumentException("Total cost cannot be negative");
        }

        this.car = car;
        this.rentalDays = rentalDays;
        this.distance = distance;
        this.rentalCost = rentalCost;
        this.fuelCost = fuelCost;
        this.totalCost = totalCost;
    }

    public Car getCar() {
        return car;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double getDistance() {
        return distance;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
