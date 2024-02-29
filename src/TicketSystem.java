package src;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class TicketSystem {
    private List<Event> events = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();
    private TicketBuilder ticketBuilder;

    public TicketSystem() {
        this.ticketBuilder = new ConcreteTicketBuilder();
    }

    // Method to add an event
    public void addEvent(Event event) {
        events.add(event);
    }

    // Method to add a ticket
    public void addTicket(String eventName, String type, double price, String clientName) {
        Event event = findEventByName(eventName);
        if (event == null) {
            System.out.println("Event not found.");
            return;
        }

        Ticket ticket = ticketBuilder.setEventName(eventName)
                .setType(type)
                .setPrice(price)
                .setClientName(clientName)
                .build();
        tickets.add(ticket);
        System.out.println("Ticket added successfully. Ticket ID: " + ticket.getId());
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres"; // username of user
        String password = "123"; // password

        String sqlCode = "DROP TABLE IF EXISTS tickets;" +
                "CREATE TABLE IF NOT EXISTS tickets(" +
                "id int ," +
                "event varchar(60)," +
                "type varchar(60)," +
                "price float," +
                "name varchar(60)" +
                ");" +
                "INSERT INTO tickets (id, event, type, price, name) VALUES(?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sqlCode)) {
            // Insert first student
            pstmt.setInt(1, ticket.getId());
            pstmt.setString(2, eventName);
            pstmt.setString(3, type);
            pstmt.setDouble(4, price);
            pstmt.setString(5, clientName);

            pstmt.executeUpdate();


        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }

        // Database insertion logic should be added here
    }

    // Method to find an event by name
    private Event findEventByName(String eventName) {
        for (Event event : events) {
            if (event.getName().equals(eventName)) {
                return event;
            }
        }
        return null;
    }

    // Method to display event information by its name
    public void showEventInfo(String eventName) {
        Event event = findEventByName(eventName);
        if (event != null) {
            System.out.println("Event Name: " + event.getName());
            System.out.println("Date: " + event.getDate());
            System.out.println("Location: " + event.getLocation());
        } else {
            System.out.println("Event with the specified name not found.");
        }
    }

    // Method to display ticket information by its ID
    public void showTicketInfo(int ticketId) {
        Ticket ticket = findTicketById(ticketId);
        if (ticket != null) {
            System.out.println("Ticket ID: " + ticket.getId());
            System.out.println("Event: " + ticket.getEvent());
            System.out.println("Ticket Type: " + ticket.getType());
            System.out.println("Price: " + ticket.getPrice());
            System.out.println("Client Name: " + ticket.getClientName());
        } else {
            System.out.println("Ticket with the specified ID not found.");
        }
    }

    // Method to find a ticket by its ID
    private Ticket findTicketById(int ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == ticketId) {
                return ticket;
            }
        }
        return null;
    }

    // Method to find a ticket by the client's name
    private Ticket findTicketByClientName(String clientName) {
        for (Ticket ticket : tickets) {
            if (ticket.getClientName().equals(clientName)) {
                return ticket;
            }
        }
        return null;
    }
}
