package driverbillingsystem;

import java.util.HashMap;

public class BillingSystem {

    HashMap<String, Driver> drivers = new HashMap<>();
    HashMap<String, Vehicle> vehicles = new HashMap<>();
    private static final double DRIVER_CANCELLATION_CHARGE = -10;
    private static final double CUSTOMER_CANCELLATION_CHARGE = 10;

    public void addDriver(String name , String phone, String driverId) {
        if (drivers.containsKey(name)) {
            System.out.println("Driver with ID " + driverId + " already exists.");
        } else {
            Driver newDriver = new Driver(name, phone, driverId);
            drivers.put(name, newDriver);
            System.out.println("Driver added: " + name + " with ID " + driverId);
        }
    }

    public void addVehicle(String vehicleNumber, String model, String Category) {
        if (vehicles.containsKey(vehicleNumber)) {
            System.out.println("Vehicle with number " + vehicleNumber + " already exists.");
        } else {
            Vehicle newVehicle = new Vehicle(vehicleNumber, model, Category);
            vehicles.put(vehicleNumber, newVehicle);
            System.out.println("Vehicle added: " + model + " with number " + vehicleNumber);
        }
    }


    public void mapDriverToVehicle(String driverName, String vehicleNumber) {
      if(!drivers.containsKey(driverName)) {
            System.out.println("Driver " + driverName + " does not exist.");
            return;
        }
        if (!vehicles.containsKey(vehicleNumber)) {
            System.out.println("Vehicle with number " + vehicleNumber + " does not exist.");
            return;
        }

        Driver driver = drivers.get(driverName);
        Vehicle vehicle = vehicles.get(vehicleNumber);

        if (driver.getVehicle() != null) {
            System.out.println("Driver " + driverName + " is already assigned to a vehicle.");
        } else {
            driver.setVehicle(vehicle);
            System.out.println("Mapped Driver " + driverName + " to Vehicle " + vehicleNumber);
        }
    }

    public void addTrip(double distance, long startTime, long endTime, String tripType, String status, String driverName) {
        if (!drivers.containsKey(driverName)) return;

        Trip trip = new Trip(distance, startTime, endTime, tripType, status);
        drivers.get(driverName).AddTrip(trip);
    }

    public String getBill(String driverName) {
        if (!drivers.containsKey(driverName)) {
            return "Driver " + driverName + " does not exist.";
        }

        Driver driver = drivers.get(driverName);
        Vehicle vehicle = driver.getVehicle();

        if (vehicle == null) {
            return "Driver " + driverName + " is not assigned to any vehicle.";
        }

        double totalBill = 0.0;
        for (Trip trip : driver.getTrips()) {
            double ratePerKm = 0.0;

            switch (vehicle.getCategory()) {
                case "ECONOMY":
                    ratePerKm = 5.0; // ₹10 per km
                    break;
                case "PREMIUM":
                    ratePerKm = 12.0; // ₹20 per km
                    break;
                case "LUXURY":
                    ratePerKm = 15.0; // ₹30 per km
                    break;
                default:
                    System.out.println("Unknown vehicle category: " + vehicle.getCategory());
                    continue;
            }

            if (trip.getStatus().equals("COMPLETED")) {
               if (trip.getTripType().equals("OUTSTATION")) {
                    ratePerKm *= 2; // Triple the rate for outstation trips
                }
                totalBill += trip.getDistance() * ratePerKm;
            } else if (trip.getStatus().equals("CANCELED_CUSTOMER")) {
                totalBill += CUSTOMER_CANCELLATION_CHARGE;
            } else if (trip.getStatus().equals("CANCELED_DRIVER")) {
                totalBill +=  DRIVER_CANCELLATION_CHARGE;
            }
        }

        return String.format("₹%.2f", totalBill);

    }
}
