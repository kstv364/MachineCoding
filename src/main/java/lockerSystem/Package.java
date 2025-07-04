package lockerSystem;

public class Package {
    private String packageId;
    private String description;
    private Size size;

    public Package(String packageId, String description, Size size) {
        this.packageId = packageId;
        this.description = description;
        this.size = size;
    }

    public String getPackageId() {
        return packageId;
    }

    public String getDescription() {
        return description;
    }

    public Size getSize() {
        return size;
    }
}
