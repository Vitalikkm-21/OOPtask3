import java.util.ArrayList;
import java.util.List;

public class TicketSystem {
    private List<Event> events = new ArrayList<>();
    private List<Ticket> tickets = new ArrayList<>();

    // Метод для добавления мероприятия
    public void addEvent(Event event) {
        events.add(event);
    }

    // Метод для добавления билета
    public void addTicket(String eventName, String type, double price, String clientName) {
        Event event = findEventByName(eventName);
        if (event == null) {
            System.out.println("Мероприятие не найдено.");
            return;
        }

        Ticket ticket = new Ticket(eventName, type, price, clientName);
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
            System.out.println("Имя покупателя: " + ticket.getClientName());
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

    // Метод для поиска билета по имени покупателя
    private Ticket findTicketByClientName(String clientName) {
        for (Ticket ticket : tickets) {
            if (ticket.getClientName() == clientName) {
                return ticket;
            }
        }
        return null;
    }
}
