package src;
// Ticket.java
public class Ticket {
    private static int nextId = 1;
    private int id;
    private String event;
    private String type;
    private double price;
    private String clientName;

    public Ticket(String event, String type, double price, String clientName) {
        this.id = nextId++;
        this.event = event;
        this.type = type;
        this.price = price;
        this.clientName = clientName;
    }

    // Getters for ticket information
    public int getId() {
        return id;
    }

    public String getEvent() {
        return event;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getClientName() {
        return clientName;
    }
}
