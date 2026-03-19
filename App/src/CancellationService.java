import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * ===========================================================================
 * CLASS - CancellationService
 * ===========================================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * This class is responsible for handling
 * booking cancellations.
 *
 * It ensures that:
 * - Cancelled room IDs are tracked
 * - Inventory is restored correctly
 * - Invalid cancellations are prevented
 *
 * A stack is used to model rollback behavior.
 *
 * @version 10.0
 */
public class CancellationService {

    /** Stack that stores recently released room IDs. */
    private Stack<String> releasedRoomIds;

    /** Maps reservation ID to room type. */
    private Map<String, String> reservationRoomTypeMap;

    /** Initializes cancellation tracking structures. */
    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    /**
     * Registers a confirmed booking.
     *
     * This method simulates storing confirmation
     * data that will later be required for cancellation.
     *
     * @param reservationId confirmed reservation ID
     * @param roomType allocated room type
     */
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    /**
     * Cancels a confirmed booking and
     * restores inventory safely.
     *
     * @param reservationId reservation to cancel
     * @param inventory centralized room inventory
     */
    public void cancelBooking(String reservationId, RoomInventory inventory) {
        // Validate if the reservation actually exists
        if (reservationRoomTypeMap.containsKey(reservationId)) {
            
            // 1. Identify the room type being released
            String roomType = reservationRoomTypeMap.get(reservationId);
            
            // 2. Remove from active reservations to prevent duplicate cancellations
            reservationRoomTypeMap.remove(reservationId);
            
            // 3. Push the room ID to the rollback stack
            releasedRoomIds.push(reservationId);
            
            // 4. Increment the inventory count to restore availability
            int currentAvailability = inventory.getAvailability(roomType);
            inventory.updateAvailability(roomType, currentAvailability + 1);
            
            System.out.println("Booking cancelled successfully. Inventory restored for room type: " + roomType);
            
        } else {
            System.out.println("Cancellation failed: Invalid or missing reservation ID.");
        }
    }

    /**
     * Displays recently cancelled reservations.
     *
     * This method helps visualize rollback order.
     */
    public void showRollbackHistory() {
        System.out.println("\nRollback History (Most Recent First):");
        
        // Iterating through the stack from top to bottom (LIFO order)
        for (int i = releasedRoomIds.size() - 1; i >= 0; i--) {
            System.out.println("Released Reservation ID: " + releasedRoomIds.get(i));
        }
    }
}