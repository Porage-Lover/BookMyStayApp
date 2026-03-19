/**
 * ===========================================================================
 * MAIN CLASS - UseCase8BookingHistoryReport
 * ===========================================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * Description:
 * This class demonstrates how
 * confirmed bookings are stored
 * and reported.
 *
 * The system maintains an ordered
 * audit trail of reservations.
 *
 * @version 8.0
 */
public class UseCase8BookingHistoryReport {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("Booking History and Reporting");

        // 1. Initialize Booking History (Storage)
        BookingHistory history = new BookingHistory();

        // 2. Simulate confirming a few reservations
        Reservation res1 = new Reservation("Abhi", "Single");
        Reservation res2 = new Reservation("Subha", "Double");
        Reservation res3 = new Reservation("Vanmathi", "Suite");

        // 3. Store the confirmed reservations in history
        history.addReservation(res1);
        history.addReservation(res2);
        history.addReservation(res3);

        // 4. Initialize Reporting Service
        BookingReportService reportService = new BookingReportService();

        // 5. Generate and print the report
        reportService.generateReport(history);
    }
}