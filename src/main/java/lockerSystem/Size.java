package lockerSystem;

public enum Size {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE("Large");

    private final String description;

    Size(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
