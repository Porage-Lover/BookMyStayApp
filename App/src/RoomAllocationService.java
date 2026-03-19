import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ===========================================================================
 * CLASS - RoomAllocationService
 * ===========================================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class is responsible for confirming
 * booking requests and assigning rooms.
 *
 * It ensures:
 * - Each room ID is unique
 * - Inventory is updated immediately
 * - No room is double-booked
 *
 * @version 6.0
 */
public class RoomAllocationService {

    /**
     * Stores all allocated room IDs to
     * prevent duplicate assignments.
     */
    private Set<String> allocatedRoomIds;

    /**
     * Stores assigned room IDs by room type.
     *
     * Key   -> Room type
     * Value -> Set of assigned room IDs
     */
    private Map<String, Set<String>> assignedRoomsByType;

    /**
     * Initializes allocation tracking structures.
     */
    public RoomAllocationService() {
        this.allocatedRoomIds = new HashSet<>();
        this.assignedRoomsByType = new HashMap<>();
    }

    /**
     * Confirms a booking request by assigning
     * a unique room ID and updating inventory.
     *
     * @param reservation booking request
     * @param inventory centralized room inventory
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRequestedRoomType();
        int currentAvailability = inventory.getAvailability(roomType);

        if (currentAvailability > 0) {
            // 1. Generate unique room ID
            String roomId = generateRoomId(roomType);

            // 2. Track the allocation to prevent double-booking
            allocatedRoomIds.add(roomId);
            assignedRoomsByType.computeIfAbsent(roomType, k -> new HashSet<>()).add(roomId);

            // 3. Immediately decrement inventory
            inventory.updateAvailability(roomType, currentAvailability - 1);

            // 4. Confirm Reservation
            System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() + ", Room ID: " + roomId);
        } else {
            System.out.println("Booking failed for Guest: " + reservation.getGuestName() + " - No " + roomType + " rooms available.");
        }
    }

    /**
     * Generates a unique room ID
     * for the given room type.
     *
     * @param roomType type of room
     * @return unique room ID
     */
    private String generateRoomId(String roomType) {
        int roomNumber = 1;
        String newRoomId;
        
        // Loop to ensure strict uniqueness against our tracking sets
        do {
            newRoomId = roomType + "-" + roomNumber;
            roomNumber++;
        } while (allocatedRoomIds.contains(newRoomId));
        
        return newRoomId;
    }
}