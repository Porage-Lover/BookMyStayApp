/**
 * Main application class for Use Case 3.
 * Demonstrates centralized inventory management using HashMap and controlled state updates.
 *
 * @author Book My Stay Dev Team
 * @version 3.1
 */
public class UseCase3InventorySetup {

    public static void main(String[] args) {
        
        System.out.println("===============================================================");
        System.out.println("   Book My Stay App - Centralized Inventory Management         ");
        System.out.println("===============================================================");

        // 1. Initialize centralized inventory
        RoomInventory inventory = new RoomInventory();

        // 2. Initialize domain models (What a room is)
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // 3. Display initial inventory state mapped from HashMap
        System.out.println("\n--- Initial Inventory State ---");
        System.out.println(singleRoom.getRoomDetails() + " | Available: " + inventory.getAvailability(singleRoom.getRoomType()));
        System.out.println(doubleRoom.getRoomDetails() + " | Available: " + inventory.getAvailability(doubleRoom.getRoomType()));
        System.out.println(suiteRoom.getRoomDetails() + " | Available: " + inventory.getAvailability(suiteRoom.getRoomType()));

        // 4. Demonstrate controlled updates (Simulating a booking)
        System.out.println("\n[System] Simulating booking: 1 Single Room and 1 Suite Room booked...");
        
        int currentSingleCount = inventory.getAvailability("Single");
        inventory.updateAvailability("Single", currentSingleCount - 1);
        
        int currentSuiteCount = inventory.getAvailability("Suite");
        inventory.updateAvailability("Suite", currentSuiteCount - 1);

        // 5. Display updated inventory state
        System.out.println("\n--- Updated Inventory State ---");
        System.out.println(singleRoom.getRoomDetails() + " | Available: " + inventory.getAvailability(singleRoom.getRoomType()));
        System.out.println(doubleRoom.getRoomDetails() + " | Available: " + inventory.getAvailability(doubleRoom.getRoomType()));
        System.out.println(suiteRoom.getRoomDetails() + " | Available: " + inventory.getAvailability(suiteRoom.getRoomType()));

        System.out.println("\n===============================================================");
        System.out.println("Inventory operations completed securely via HashMap.");
    }
}