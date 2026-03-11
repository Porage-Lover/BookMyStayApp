import java.util.LinkedList;
import java.util.Queue;

/**
 * Manages and orders incoming booking requests using a FIFO queue.
 * Ensures fairness by preserving the arrival order of requests.
 *
 * @author Book My Stay Dev Team
 * @version 5.0
 */
public class BookingRequestQueue {
    
    // The Queue data structure to hold pending reservations
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        // LinkedList is a standard implementation for a FIFO Queue in Java
        requestQueue = new LinkedList<>();
    }

    /**
     * Accepts a booking request and adds it to the back of the queue.
     * @param reservation The guest's booking request.
     */
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
        System.out.println("[Queue Intake] Added: " + reservation);
    }

    /**
     * Displays the current state of the queue without processing it.
     */
    public void displayPendingRequests() {
        System.out.println("\n--- Current Pending Requests (" + requestQueue.size() + " in queue) ---");
        for (Reservation req : requestQueue) {
            System.out.println(req);
        }
    }
    
    // Note: No allocation or inventory mutation methods are included here 
    // to strictly separate request intake from inventory processing.
}