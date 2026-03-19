import java.util.LinkedList;
import java.util.Queue;

/**
 * ===========================================================================
 * MAIN CLASS - UseCase6RoomAllocation
 * ===========================================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class demonstrates how booking
 * requests are confirmed and rooms
 * are allocated safely.
 *
 * It consumes booking requests in FIFO
 * order and updates inventory immediately.
 *
 * @version 6.0
 */
public class UseCase6RoomAllocation {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Room Allocation Processing");

        // 1. Initialize Inventory and Allocation Service
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();

        // 2. Setup a standard FIFO Queue simulating the one from Use Case 5
        Queue<Reservation> bookingQueue = new LinkedList<>();
        bookingQueue.offer(new Reservation("Abhi", "Single"));
        bookingQueue.offer(new Reservation("Subha", "Single"));
        bookingQueue.offer(new Reservation("Vanmathi", "Suite"));

        // 3. Process requests in FIFO order
        while (!bookingQueue.isEmpty()) {
            Reservation currentRequest = bookingQueue.poll(); // Dequeue
            allocationService.allocateRoom(currentRequest, inventory); // Allocate
        }
    }
}