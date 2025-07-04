package driverbillingsystem;

public class Vehicle {
    private String category;
    private String model;
    private String vehicleNumber;

    public Vehicle(String vehicleNumber, String model, String category) {
        this.vehicleNumber = vehicleNumber;
        this.model = model;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
