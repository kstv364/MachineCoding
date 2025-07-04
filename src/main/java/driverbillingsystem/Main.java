package driverbillingsystem;

public class Main {

    public static void main(String[] args) {

        BillingSystem billing = new BillingSystem();

        // Adding Drivers
        billing.addDriver("Sachin", "+91-9936673000", "D101");
        billing.addDriver("Ramesh", "+91-9936673011", "DL_02");
        billing.addDriver("Manjunath", "+91-9936673010", "DL_03");

        billing.addVehicle("KA-01-2222", "Maruti Suzuki", "ECONOMY");
        billing.addVehicle("KA-01-2223", "Ertiga", "PREMIUM");

        billing.mapDriverToVehicle("Ramesh", "KA-01-2222");
        billing.mapDriverToVehicle("Manjunath", "KA-01-2223");

        billing.addTrip(50, 1723116023, 1723117023, "INTRACITY", "COMPLETED", "Ramesh");
        billing.addTrip(1050, 1723116023, 1723117023, "OUTSTATION", "COMPLETED", "Ramesh");
        billing.addTrip(50, 1723116023, 1723117023, "INTRACITY", "CANCELED_CUSTOMER", "Ramesh");

        billing.addTrip(50, 1723116023, 1723117023, "OUTSTATION", "CANCELED_DRIVER", "Manjunath");
        billing.addTrip(70, 1723116023, 1723117023, "OUTSTATION", "COMPLETED", "Manjunath");

        System.out.println("Ramesh's Bill: " + billing.getBill("Ramesh"));       // Should be ₹10,560
        System.out.println("Manjunath's Bill: " + billing.getBill("Manjunath")); // Should be ₹1,670
    }
}
