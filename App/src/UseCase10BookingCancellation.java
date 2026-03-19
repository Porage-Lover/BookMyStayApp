/**
 * ===========================================================================
 * MAIN CLASS - UseCase10BookingCancellation
 * ===========================================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * This class demonstrates how confirmed
 * bookings can be cancelled safely.
 *
 * Inventory is restored and rollback
 * history is maintained.
 *
 * @version 10.0
 */
public class UseCase10BookingCancellation {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Booking Cancellation");

        // 1. Initialize components
        RoomInventory inventory = new RoomInventory();
        CancellationService cancellationService = new CancellationService();

        // 2. Simulate registering an existing, confirmed booking
        // (Assuming "Single-1" was already allocated to a guest previously)
        String reservationId = "Single-1";
        String roomType = "Single";
        cancellationService.registerBooking(reservationId, roomType);

        // 3. Process the cancellation request
        cancellationService.cancelBooking(reservationId, inventory);

        // 4. Display the rollback history stack
        cancellationService.showRollbackHistory();

        // 5. Verify the inventory was accurately updated
        // Default was 5, so restoring 1 should bring it to 6
        System.out.println("\nUpdated Single Room Availability: " + inventory.getAvailability(roomType));
    }
}