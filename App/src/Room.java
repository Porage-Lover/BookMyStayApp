/**
 * Abstract class representing a generic hotel room.
 * Encapsulates common properties shared across all room types.
 *
 * @author Book My Stay Dev Team
 * @version 2.0
 */
public abstract class Room {
    private String roomType;
    private int numberOfBeds;
    private double pricePerNight;
    private double roomSizeSqm;

    public Room(String roomType, int numberOfBeds, double pricePerNight, double roomSizeSqm) {
        this.roomType = roomType;
        this.numberOfBeds = numberOfBeds;
        this.pricePerNight = pricePerNight;
        this.roomSizeSqm = roomSizeSqm;
    }

    public String getRoomType() { return roomType; }
    public int getNumberOfBeds() { return numberOfBeds; }
    public double getPricePerNight() { return pricePerNight; }
    public double getRoomSizeSqm() { return roomSizeSqm; }

    /**
     * Provides a formatted string of the room's details.
     * @return String containing room attributes.
     */
    public String getRoomDetails() {
        return String.format("%-12s | Beds: %d | Size: %5.1f sqm | Price: $%.2f/night", 
                             roomType, numberOfBeds, roomSizeSqm, pricePerNight);
    }
}