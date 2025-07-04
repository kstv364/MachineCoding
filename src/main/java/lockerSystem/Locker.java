package lockerSystem;

public class Locker {
    private String lockerId;

    private Size size;
    private boolean isOccupied;
    private String packageId;

    public Locker(String lockerId, Size size) {
        this.lockerId = lockerId;
        this.size = size;
        this.isOccupied = false;
    }

    public String getLockerId() {
        return lockerId;
    }
    public Size getSize() {
        return size;
    }
    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupy(String packageId) {
        this.packageId = packageId;
        this.isOccupied = true;
    }

    public void vacate() {
        this.packageId = null;
        this.isOccupied = false;
    }
}
