package src;

public interface TicketBuilder {
    TicketBuilder setEventName(String eventName);
    TicketBuilder setType(String type);
    TicketBuilder setPrice(double price);
    TicketBuilder setClientName(String clientName);
    Ticket build();
}
