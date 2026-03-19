/**
 * Main application class for Use Case 4.
 * Demonstrates read-only search operations and filtering of unavailable rooms.
 *
 * @author Book My Stay Dev Team
 * @version 4.0
 */
public class UseCase4RoomSearch {

    public static void main(String[] args) {
        
        System.out.println("===============================================================");
        System.out.println("   Book My Stay App - Room Search & Availability Check         ");
        System.out.println("===============================================================");

        // 1. Initialize centralized inventory
        RoomInventory inventory = new RoomInventory();
        
        // Simulate a scenario where Suites are completely booked out
        System.out.println("[System] Setting 'Suite' availability to 0 for demonstration...");
        inventory.updateAvailability("Suite", 0);

        // 2. Initialize domain models (What a room is)
        Room[] allRooms = {
            new SingleRoom(),
            new DoubleRoom(),
            new SuiteRoom()
        };

        // 3. Initialize Search Service (Read-Only access)
        SearchService searchService = new SearchService(inventory);

        // 4. Guest initiates a search request
        System.out.println("\n[Guest] Initiating room search...");
        searchService.searchAvailableRooms(allRooms);
        
        System.out.println("\n===============================================================");
        System.out.println("Search completed successfully without modifying system state.");
    }
}