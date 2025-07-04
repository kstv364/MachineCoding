package lockerSystem;

import java.util.NoSuchElementException;

public class LockerSystem {
    public static void main(String[] args) {

        LockerManager lockerManager = new LockerManager();
        // Create lockers
        lockerManager.addLocker(new Locker("L1", Size.SMALL));
        lockerManager.addLocker(new Locker("L2", Size.MEDIUM));
        lockerManager.addLocker(new Locker("L3", Size.LARGE));
        lockerManager.addLocker(new Locker("L4", Size.MEDIUM));
        lockerManager.addLocker(new Locker("L5", Size.SMALL));
        // Create packages
        Package package1 = new Package("P1", "Books", Size.LARGE);
        Package package2 = new Package("P2", "Clothes", Size.LARGE);
        Package package3 = new Package("P3", "Electronics", Size.SMALL);
        Package package4 = new Package("P4", "Toys", Size.SMALL);
        Package package5 = new Package("P5", "Sports Equipment", Size.MEDIUM);
        // Add packages to lockers

        try {
            String lockerId1 = lockerManager.getBestLockerId(package1);
            System.out.println("Package " + package1.getPackageId() + " stored in locker " + lockerId1);
            String lockerId2 = lockerManager.getBestLockerId(package2);
            System.out.println("Package " + package2.getPackageId() + " stored in locker " + lockerId2);
            String lockerId3 = lockerManager.getBestLockerId(package3);
            System.out.println("Package " + package3.getPackageId() + " stored in locker " + lockerId3);
            String lockerId4 = lockerManager.getBestLockerId(package4);
            System.out.println("Package " + package4.getPackageId() + " stored in locker " + lockerId4);
            String lockerId5 = lockerManager.getBestLockerId(package5);
            System.out.println("Package " + package5.getPackageId() + " stored in locker " + lockerId5);
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
        }

    }
}
