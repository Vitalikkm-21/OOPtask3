package src;

public class Ticket {
    private static int nextId = 1; // Статическая переменная для генерации уникального номера билета
    private int id;
    private String event;
    private String type;
    private double price;
    private String clientName;

    public Ticket(String event, String type, double price, String clientName) {
        this.id = nextId++; // Генерация уникального номера билета
        this.event = event;
        this.type = type;
        this.price = price;
        this.clientName = clientName;
    }

    // Геттеры для получения информации о билете
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
