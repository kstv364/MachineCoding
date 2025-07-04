package driverbillingsystem;

import java.util.*;

public class Driver {

    private String name;
    private String phone;
    private String driverId;

    private Vehicle vehicle;

    private List<Trip> trips = new ArrayList<>();

    public Driver(String name, String phone, String driverId) {
        this.name = name;
        this.phone = phone;
        this.driverId = driverId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void AddTrip(Trip trip) {
        trips.add(trip);
    }

    public List<Trip> getTrips() {
        return trips.stream().toList();
    }
}
