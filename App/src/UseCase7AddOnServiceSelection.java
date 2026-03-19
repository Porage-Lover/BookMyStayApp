/**
 * ===========================================================================
 * MAIN CLASS - UseCase7AddOnServiceSelection
 * ===========================================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * This class demonstrates how optional
 * services can be attached to a confirmed
 * booking.
 *
 * Services are added after room allocation
 * and do not affect inventory.
 *
 * @version 7.0
 */
public class UseCase7AddOnServiceSelection {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Add-On Service Selection");

        // 1. Initialize the Add-On Manager
        AddOnServiceManager manager = new AddOnServiceManager();
        
        // 2. Mocking a confirmed reservation ID from previous use case
        String confirmedReservationId = "Single-1";

        // 3. Guest selects services
        Service spaService = new Service("Spa", 1000.0);
        Service pickupService = new Service("Airport Pickup", 500.0);

        // 4. Attach services to the reservation
        manager.addService(confirmedReservationId, spaService);
        manager.addService(confirmedReservationId, pickupService);

        // 5. Calculate and display total add-on cost
        double totalAddOnCost = manager.calculateTotalServiceCost(confirmedReservationId);
        
        System.out.println("Reservation ID: " + confirmedReservationId);
        System.out.println("Total Add-On Cost: " + totalAddOnCost);
    }
}