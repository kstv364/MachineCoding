package driverbillingsystem;

public class Trip {
    private final double distance;
    private final long startTime;
    private final long endTime;
    private final String tripType;
    private final String status;

    public Trip(double distance, long startTime, long endTime, String tripType, String status) {
        this.distance = distance;
        this.startTime = startTime;
        this.endTime = endTime;
        this.tripType = tripType;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public double getDistance() {
        return distance;
    }

    public String getTripType() {
        return tripType;
    }
}
