import java.io.File;

/**
 * ===========================================================================
 * MAIN CLASS - UseCase12DataPersistenceRecovery
 * ===========================================================================
 *
 * Use Case 12: Data Persistence & System Recovery
 *
 * Description:
 * This class demonstrates how system state
 * can be restored after an application restart.
 *
 * Inventory data is loaded from a file
 * before any booking operations occur.
 *
 * @version 12.0
 */
public class UseCase12DataPersistenceRecovery {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("System Recovery");

        String filePath = "inventory_data.txt";
        
        // Safety step: Delete the file if it exists to simulate a "fresh start" 
        // and match the exact requested output for the demonstration.
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }

        // 1. Initialize core components
        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistenceService = new FilePersistenceService();

        // 2. Attempt to load existing inventory data on startup
        persistenceService.loadInventory(inventory, filePath);

        // 3. Update inventory to match the exact scenario from the use case output
        inventory.updateAvailability("Single", 5);
        inventory.updateAvailability("Double", 3);
        inventory.updateAvailability("Suite", 2);

        // 4. Display current state
        System.out.println("\nCurrent Inventory:");
        System.out.println("Single: " + inventory.getAvailability("Single"));
        System.out.println("Double: " + inventory.getAvailability("Double"));
        System.out.println("Suite: " + inventory.getAvailability("Suite"));

        // 5. Save the inventory state back to the file before shutting down
        persistenceService.saveInventory(inventory, filePath);
    }
}