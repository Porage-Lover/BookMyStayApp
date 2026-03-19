import java.util.LinkedList;
import java.util.Queue;

/**
 * Updated for Use Case 11 to include poll() and isEmpty() methods.
 * @version 11.0
 */
public class BookingRequestQueue {
    
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
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

    // New method to check if the queue is empty
    public boolean isEmpty() {
        return requestQueue.isEmpty();
    }

    // New method to retrieve and remove the head of the queue
    public Reservation poll() {
        return requestQueue.poll();
    }
}