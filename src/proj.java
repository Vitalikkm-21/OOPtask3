package src;
import java.util.Scanner;

public class proj {
    public static void main(String[] args) {
        // Creating a ticket management system
        TicketSystem ticketSystem = new TicketSystem();

        // Adding events
        Event event1 = new Event("Concert", "February 22, 2024", "Concert Hall");
        Event event2 = new Event("Theatrical Performance", "February 26, 2024", "Drama Theater");
        ticketSystem.addEvent(event1);
        ticketSystem.addEvent(event2);

        // Adding tickets manually
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Choose where you want to go: 1 - Concert, 2 - Theatrical Performance, 0 - to finish purchases: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("Adding a ticket for the Concert:");
                System.out.print("Ticket Type: ");
                String ticketType = scanner.nextLine();
                System.out.print("Ticket Price: ");
                double ticketPrice = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Buyer Name: ");
                String buyerName = scanner.nextLine();

                ticketSystem.addTicket("Concert", ticketType, ticketPrice, buyerName);
            } else if (choice == 2) {
                System.out.println("Adding a ticket for the Theatrical Performance:");
                System.out.print("Ticket Type: ");
                String ticketType = scanner.nextLine();
                System.out.print("Ticket Price: ");
                double ticketPrice = scanner.nextDouble();
                scanner.nextLine(); // Reading the extra newline after entering the number
                System.out.print("Buyer Name: ");
                String buyerName = scanner.nextLine();

                ticketSystem.addTicket("Theatrical Performance", ticketType, ticketPrice, buyerName);
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Invalid event selection.");
            }
        }

        System.out.println("--------");

        // Displaying information about events and tickets
        ticketSystem.showEventInfo("Concert");
        System.out.println("--------");
        ticketSystem.showEventInfo("Theatrical Performance");

        System.out.println("--------");
        System.out.println("Which ticket ID do you want to display?");
        int ticketId = scanner.nextInt();
        ticketSystem.showTicketInfo(ticketId);

        // Closing the Scanner
        scanner.close();
    }
}

