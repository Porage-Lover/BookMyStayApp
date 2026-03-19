import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ===========================================================================
 * CLASS - FilePersistenceService
 * ===========================================================================
 *
 * Use Case 12: Data Persistence & System Recovery
 *
 * Description:
 * This class is responsible for persisting
 * critical system state to a plain text file.
 *
 * It supports:
 * - Saving room inventory state
 * - Restoring inventory on system startup
 *
 * No database or serialization framework
 * is used in this use case.
 *
 * @version 12.0
 */
public class FilePersistenceService {

    // Known room types to iterate through during the save process
    private static final String[] KNOWN_ROOM_TYPES = {"Single", "Double", "Suite"};

    /**
     * Saves room inventory state to a file.
     *
     * Each line follows the format:
     * roomType=availableCount
     *
     * @param inventory centralized room inventory
     * @param filePath path to persistence file
     */
    public void saveInventory(RoomInventory inventory, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            
            for (String roomType : KNOWN_ROOM_TYPES) {
                int count = inventory.getAvailability(roomType);
                writer.write(roomType + "=" + count);
                writer.newLine();
            }
            
            System.out.println("Inventory saved successfully.");
            
        } catch (IOException e) {
            System.out.println("Error saving inventory to file: " + e.getMessage());
        }
    }

    /**
     * Loads room inventory state from a file.
     *
     * @param inventory centralized room inventory
     * @param filePath path to persistence file
     */
    public void loadInventory(RoomInventory inventory, String filePath) {
        File file = new File(filePath);
        
        if (!file.exists()) {
            System.out.println("No valid inventory data found. Starting fresh.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            
            // Read file line by line and parse the format "roomType=count"
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String roomType = parts[0];
                    int count = Integer.parseInt(parts[1]);
                    
                    // Restore the state into our centralized inventory
                    inventory.updateAvailability(roomType, count);
                }
            }
            
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading inventory from file: " + e.getMessage());
        }
    }
}