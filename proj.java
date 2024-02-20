import java.util.ArrayList;
import java.util.List;

// Класс для представления мероприятий
class Event {
    private String name;
    private String date;
    private String location;

    public Event(String name, String date, String location) {
        this.name = name;
        this.date = date;
        this.location = location;
    }

    // Геттеры для получения информации о мероприятии
    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }
}

// Класс для представления билетов
class Ticket {
    private static int nextId = 1; // Статическая переменная для генерации уникального номера билета
    private int id;
    private String event;
    private String type;
    private double price;

    public Ticket(String event, String type, double price) {
        this.id = nextId++; // Генерация уникального номера билета
        this.event = event;
        this.type = type;
        this.price = price;
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
}

// Класс для управления системой билетов
class TicketSystem {
    private List<Event> events = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    // Метод для добавления мероприятия
    public void addEvent(Event event) {
        events.add(event);
    }

    // Метод для добавления билета
    public void addTicket(String eventName, String type, double price) {
        Event event = findEventByName(eventName);
        if (event == null) {
            System.out.println("Мероприятие не найдено.");
            return;
        }

        Ticket ticket = new Ticket(eventName, type, price);
        tickets.add(ticket);
        System.out.println("Билет успешно добавлен. Номер билета: " + ticket.getId());
    }

    // Метод для поиска мероприятия по имени
    private Event findEventByName(String eventName) {
        for (Event event : events) {
            if (event.getName().equals(eventName)) {
                return event;
            }
        }
        return null;
    }

    // Метод для отображения информации о мероприятии по его имени
    public void showEventInfo(String eventName) {
        Event event = findEventByName(eventName);
        if (event != null) {
            System.out.println("Название мероприятия: " + event.getName());
            System.out.println("Дата: " + event.getDate());
            System.out.println("Место: " + event.getLocation());
        } else {
            System.out.println("Мероприятие с указанным именем не найдено.");
        }
    }

    // Метод для отображения информации о билете по его ID
    public void showTicketInfo(int ticketId) {
        Ticket ticket = findTicketById(ticketId);
        if (ticket != null) {
            System.out.println("Номер билета: " + ticket.getId());
            System.out.println("Мероприятие: " + ticket.getEvent());
            System.out.println("Тип билета: " + ticket.getType());
            System.out.println("Цена: " + ticket.getPrice());
        } else {
            System.out.println("Билет с указанным номером не найден.");
        }
    }

    // Метод для поиска билета по его ID
    private Ticket findTicketById(int ticketId) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == ticketId) {
                return ticket;
            }
        }
        return null;
    }
}

public class proj {
    public static void main(String[] args) {
        // Создание системы управления билетами
        TicketSystem ticketSystem = new TicketSystem();

        // Добавление мероприятий
        Event event1 = new Event("Концерт", "20 февраля 2024", "Зал 'Концертный'");
        Event event2 = new Event("Театральное представление", "25 февраля 2024", "Театр 'Драма'");
        ticketSystem.addEvent(event1);
        ticketSystem.addEvent(event2);

        // Добавление билетов
        ticketSystem.addTicket("Концерт", "Классический", 50.0);
        ticketSystem.addTicket("Театральное представление", "Премиум", 100.0);
        System.out.println("--------");

        // Отображение информации о мероприятии и билете
        ticketSystem.showEventInfo("Концерт");
        System.out.println("--------");
        ticketSystem.showEventInfo("Театральное представление");

        System.out.println("--------");

        ticketSystem.showTicketInfo(1);
    }
}
