package src;

// ConcreteTicketBuilder.java
public class ConcreteTicketBuilder implements TicketBuilder {
    private String eventName;
    private String type;
    private double price;
    private String clientName;

    @Override
    public TicketBuilder setEventName(String eventName) {
        this.eventName = eventName;
        return this;
    }

    @Override
    public TicketBuilder setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public TicketBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public TicketBuilder setClientName(String clientName) {
        this.clientName = clientName;
        return this;
    }

    @Override
    public Ticket build() {
        return new Ticket(eventName, type, price, clientName);
    }
}

