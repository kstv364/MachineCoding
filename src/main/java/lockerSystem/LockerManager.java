package lockerSystem;

import java.util.*;

public class LockerManager {
    private final Map<Size, Queue<Locker>> availableLockers = new EnumMap<>(Size.class);

    public LockerManager() {
        for (Size size : Size.values()) {
            availableLockers.put(size, new LinkedList<>());
        }
    }

    public void addLocker(Locker locker) {
        if (locker != null && locker.getSize() != null) {
            availableLockers.get(locker.getSize()).offer(locker);
        }
    }

    public String getBestLockerId(Package pkg) {
        if (pkg == null || pkg.getSize() == null) {
            return null;
        }

        for(Size size : Size.values()) {
            if (size.ordinal() >= pkg.getSize().ordinal()) {
                Queue<Locker> lockers = availableLockers.get(size);
                while (!lockers.isEmpty()) {
                    Locker locker = lockers.poll();
                    if (locker != null && !locker.isOccupied()) {
                        locker.occupy(pkg.getPackageId());
                        return locker.getLockerId(); // Return the ID of the first available locker
                    }
                }
            }
        }
        throw new NoSuchElementException("All lockers are occupied for the requested package size: " + pkg.getSize());
    }


}
