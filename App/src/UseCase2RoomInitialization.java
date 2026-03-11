/**
 * Main application class for Use Case 2.
 * Initializes room objects using polymorphism and tracks availability
 * using basic static variables to highlight the need for data structures later.
 *
 * @author Book My Stay Dev Team
 * @version 2.1 
 */
public class UseCase2RoomInitialization {

    public static void main(String[] args) {
        
        System.out.println("===============================================================");
        System.out.println("   Book My Stay App - Room Types & Static Availability         ");
        System.out.println("===============================================================");

        // 1. Polymorphism: Creating concrete room objects referenced by the abstract Room type
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // 2. Static Availability Representation: Hardcoded state variables
        // This highlights the limitation of not using data structures (like Lists or Maps)
        int availableSingleRooms = 5;
        int availableDoubleRooms = 10;
        int availableSuiteRooms = 2;

        // 3. Output room details and their corresponding availability
        System.out.println("\n--- Current Inventory ---");
        System.out.println(singleRoom.getRoomDetails() + " | Available: " + availableSingleRooms);
        System.out.println(doubleRoom.getRoomDetails() + " | Available: " + availableDoubleRooms);
        System.out.println(suiteRoom.getRoomDetails() + " | Available: " + availableSuiteRooms);
        
        System.out.println("\n===============================================================");
        System.out.println("System initialized successfully. Ready for booking requests.");
    }
}