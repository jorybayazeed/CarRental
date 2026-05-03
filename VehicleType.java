public enum VehicleType {
    SUV("SUV"),
    SEDAN("Sedan"),
    TRUCK("Truck"),
    COUPE("Coupe"),
    HYBRID("Hybrid"),
    CROSSOVER("Crossover"),
    VAN_MINIVAN("Van/Minivan");

    private final String displayName;

    VehicleType(String displayName) {
        if (displayName == null || displayName.isEmpty()) {
            throw new IllegalArgumentException("Display name cannot be empty");
        }
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
