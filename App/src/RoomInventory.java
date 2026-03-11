import java.util.HashMap;
import java.util.Map;

/**
 * Manages and exposes room availability across the system.
 * Centralizes inventory state using a HashMap to ensure a single source of truth
 * and O(1) lookup times.
 *
 * @author Book My Stay Dev Team
 * @version 3.0
 */
public class RoomInventory {
    
    // Encapsulated data structure to hold room type as Key and availability as Value
    private Map<String, Integer> availabilityMap;

    /**
     * Initializes room availability using a constructor.
     */
    public RoomInventory() {
        availabilityMap = new HashMap<>();
        // Default inventory setup
        availabilityMap.put("Single", 5);
        availabilityMap.put("Double", 10);
        availabilityMap.put("Suite", 2);
    }

    /**
     * Retrieves current availability for a specific room type.
     * * @param roomType The type of room (e.g., "Single", "Double")
     * @return The number of available rooms, or 0 if the type doesn't exist
     */
    public int getAvailability(String roomType) {
        return availabilityMap.getOrDefault(roomType, 0);
    }

    /**
     * Controlled update to room availability.
     * * @param roomType The type of room to update
     * @param newCount The new available count
     */
    public void updateAvailability(String roomType, int newCount) {
        if (availabilityMap.containsKey(roomType)) {
            // Prevent negative inventory
            if (newCount >= 0) {
                availabilityMap.put(roomType, newCount);
            } else {
                System.out.println("Error: Inventory count cannot be negative.");
            }
        } else {
            System.out.println("Error: Room type '" + roomType + "' not found in inventory.");
        }
    }
}