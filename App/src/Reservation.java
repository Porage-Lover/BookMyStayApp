/**
 * Represents a guest's intent to book a room.
 * This acts as the data packet that will be queued for processing.
 *
 * @author Book My Stay Dev Team
 * @version 5.0
 */
public class Reservation {
    private String guestName;
    private String requestedRoomType;

    public Reservation(String guestName, String requestedRoomType) {
        this.guestName = guestName;
        this.requestedRoomType = requestedRoomType;
    }

    public String getGuestName() { 
        return guestName; 
    }
    
    public String getRequestedRoomType() { 
        return requestedRoomType; 
    }

    @Override
    public String toString() {
        return String.format("Reservation Request -> Guest: %-15s | Room Type: %s", guestName, requestedRoomType);
    }
}