/**
 * Main application class for Use Case 5.
 * Demonstrates the intake of simultaneous booking requests using a FIFO queue,
 * preserving arrival order without modifying inventory state yet.
 *
 * @author Book My Stay Dev Team
 * @version 5.0
 */
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {
        
        System.out.println("===============================================================");
        System.out.println("   Book My Stay App - Booking Request Queue (FIFO)             ");
        System.out.println("===============================================================");

        // 1. Initialize the booking request queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // 2. Simulate simultaneous booking requests during peak demand
        System.out.println("\n[System] Receiving a burst of booking requests...");
        
        Reservation req1 = new Reservation("Alice Smith", "Suite");
        Reservation req2 = new Reservation("Bob Jones", "Double");
        Reservation req3 = new Reservation("Charlie Brown", "Single");
        Reservation req4 = new Reservation("Diana Prince", "Suite");

        // 3. Guests submit booking requests (added to queue in arrival order)
        bookingQueue.addRequest(req1);
        bookingQueue.addRequest(req2);
        bookingQueue.addRequest(req3);
        bookingQueue.addRequest(req4);

        // 4. Show the state of the queue waiting for allocation processing
        bookingQueue.displayPendingRequests();

        System.out.println("\n===============================================================");
        System.out.println("Requests queued successfully. Awaiting allocation processing.");
    }
}