public enum CarCategory {
    ECONOMY(45.0, 4, ComfortLevel.POOR),
    INTERMEDIATE(50.0, 4, ComfortLevel.MEDIUM),
    STANDARD(55.0, 5, ComfortLevel.GOOD),
    VAN(70.0, 7, ComfortLevel.MEDIUM);

    private final double dailyRentalCost;
    private final int passengerCapacity;
    private final ComfortLevel comfortLevel;

    CarCategory(double dailyRentalCost, int passengerCapacity, ComfortLevel comfortLevel) {
        if (dailyRentalCost <= 0) {
            throw new IllegalArgumentException("Daily rental cost must be positive");
        }
        if (passengerCapacity <= 0) {
            throw new IllegalArgumentException("Passenger capacity must be positive");
        }
        if (comfortLevel == null) {
            throw new IllegalArgumentException("Comfort level cannot be null");
        }

        this.dailyRentalCost = dailyRentalCost;
        this.passengerCapacity = passengerCapacity;
        this.comfortLevel = comfortLevel;
    }

    public double getDailyRentalCost() {
        return dailyRentalCost;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public ComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    public boolean supports(VehicleType vehicleType) {
        if (vehicleType == null) {
            return false;
        }

        switch (this) {
            case ECONOMY:
                return vehicleType == VehicleType.COUPE;
            case INTERMEDIATE:
                return vehicleType == VehicleType.SEDAN || vehicleType == VehicleType.HYBRID;
            case STANDARD:
                return vehicleType == VehicleType.TRUCK
                        || vehicleType == VehicleType.CROSSOVER
                        || vehicleType == VehicleType.SUV;
            case VAN:
                return vehicleType == VehicleType.VAN_MINIVAN;
            default:
                return false;
        }
    }
}
