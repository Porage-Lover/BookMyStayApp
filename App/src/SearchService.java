/**
 * Service responsible for handling read-only access to inventory and room information.
 * Ensures that guests can view available rooms without modifying system state.
 *
 * @author Book My Stay Dev Team
 * @version 4.0
 */
public class SearchService {
    
    private RoomInventory inventory;

    /**
     * Constructor injecting the centralized inventory.
     * @param inventory The single source of truth for room counts.
     */
    public SearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    /**
     * Retrieves availability data and displays only room types with availability > 0.
     * System state remains completely unchanged.
     * * @param rooms Array of room domain objects describing the hotel's offerings.
     */
    public void searchAvailableRooms(Room[] rooms) {
        System.out.println("\n--- Search Results: Available Rooms ---");
        boolean foundAvailable = false;

        for (Room room : rooms) {
            // Retrieve availability data from the inventory
            int availableCount = inventory.getAvailability(room.getRoomType());
            
            // Validation Logic: Filter out unavailable room types
            if (availableCount > 0) {
                System.out.println(room.getRoomDetails() + " | Available: " + availableCount);
                foundAvailable = true;
            }
        }

        if (!foundAvailable) {
            System.out.println("We're sorry, there are no rooms currently available.");
        }
    }
}