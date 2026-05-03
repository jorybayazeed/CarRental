
public class Car {

    //  Encapsulation
    private String make;
    private String model;
    private VehicleType vehicleType;
    private CarCategory category;
    private double mpg;

    // Constructor +  Input Validation
    public Car(String make, String model, VehicleType vehicleType, CarCategory category, double mpg) {

        if (make == null || make.isEmpty()) {
            throw new IllegalArgumentException("Make cannot be empty");
        }

        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Model cannot be empty");
        }

        if (vehicleType == null) {
            throw new IllegalArgumentException("Vehicle type cannot be null");
        }

        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }

        if (!category.supports(vehicleType)) {
            throw new IllegalArgumentException("Vehicle type does not match the selected rental category");
        }

        if (mpg <= 0) {
            throw new IllegalArgumentException("MPG must be positive");
        }

        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.category = category;
        this.mpg = mpg;
    }

    // Getters 
    public String getMake() { return make; }
    public String getModel() { return model; }
    public VehicleType getVehicleType() { return vehicleType; }
    public CarCategory getCategory() { return category; }
    public double getMpg() { return mpg; }
    public int getMaxPassengers() { return category.getPassengerCapacity(); }
    public ComfortLevel getComfortLevel() { return category.getComfortLevel(); }
    public double getDailyRentalCost() { return category.getDailyRentalCost(); }

    // display data
    public void displayCar() {
        System.out.println(make + " " + model +
                " | Vehicle Type: " + vehicleType +
                " | MPG: " + mpg +
                " | Passengers: " + getMaxPassengers());
    }
}