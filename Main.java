import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    
        Locale.setDefault(Locale.US);

        ArrayList<Car> cars = new ArrayList<>();
        RentalCalculator calculator = new RentalCalculator();

        try {
            // Add cars covering all required categories
            cars.add(new Car("Toyota", "RAV4", VehicleType.SUV, CarCategory.STANDARD, 30));
            cars.add(new Car("Toyota", "Camry", VehicleType.SEDAN, CarCategory.INTERMEDIATE, 32));
            cars.add(new Car("Ford", "F-150", VehicleType.TRUCK, CarCategory.STANDARD, 22));
            cars.add(new Car("Honda", "Civic Coupe", VehicleType.COUPE, CarCategory.ECONOMY, 31));
            cars.add(new Car("Toyota", "Prius", VehicleType.HYBRID, CarCategory.INTERMEDIATE, 52));
            cars.add(new Car("Honda", "CR-V", VehicleType.CROSSOVER, CarCategory.STANDARD, 28));
            cars.add(new Car("Honda", "Odyssey", VehicleType.VAN_MINIVAN, CarCategory.VAN, 22));

        } catch (IllegalArgumentException e) {
            // Fail Securely
            System.out.println("Error adding car: " + e.getMessage());
        }

        // Display available cars
        System.out.println("Available Cars:");
        System.out.println();

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.println("#" + (i + 1));
            car.displayCar();
            System.out.println("--------------------------------------------------------------------");
        }

        if (cars.isEmpty()) {
            System.out.println("No cars available.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        try {
            // User input
            System.out.println();

            System.out.print("Enter number of passengers: ");
            String passengersRaw = scanner.nextLine();
            int passengers = Integer.parseInt(passengersRaw);

            System.out.print("Enter rental days: ");
            String daysRaw = scanner.nextLine();
            int days = Integer.parseInt(daysRaw);

            System.out.print("Enter expected mileage: ");
            String distanceRaw = scanner.nextLine();
            double distance = Double.parseDouble(distanceRaw);

            // Find best cars
            RentalQuote[] bestQuotes =
                    calculator.findBestCars(cars, days, distance, passengers);

            if (bestQuotes.length == 0) {
                throw new IllegalArgumentException(
                        "No available car can fit the requested number of passengers.");
            }

            // Output result
            System.out.println();
            System.out.println("Best Rental Option(s):");
            System.out.println("====================================================================");

            for (RentalQuote quote : bestQuotes) {

                System.out.println(
                        quote.getCar().getMake() + " " +
                        quote.getCar().getModel()
                );

                System.out.println("Vehicle Type    : " +
                        quote.getCar().getVehicleType());

                System.out.println("Category        : " +
                        quote.getCar().getCategory());

                System.out.println("Comfort Level   : " +
                        quote.getCar().getComfortLevel());

                System.out.println("Max Passengers  : " +
                        quote.getCar().getMaxPassengers());

                System.out.printf("Rental Cost     : $%.2f%n",
                        quote.getRentalCost());

                System.out.printf("Fuel Cost       : $%.2f%n",
                        quote.getFuelCost());

                System.out.printf("Total Cost      : $%.2f%n",
                        quote.getTotalCost());

                System.out.println("--------------------------------------------------------------------");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format. Please enter numeric values only.");

        } catch (IllegalArgumentException e) {
            System.out.println("Input error: " + e.getMessage());

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());

        } finally {
            scanner.close();
        }
    }
}