import java.util.ArrayList;
import java.util.List;

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
        ticketSystem.addTicket("Концерт", "Классический", 50.0, "Нурсая");
        ticketSystem.addTicket("Театральное представление", "Премиум", 100.0, "Мадина");
        System.out.println("--------");

        // Отображение информации о мероприятии и билете
        ticketSystem.showEventInfo("Концерт");
        System.out.println("--------");
        ticketSystem.showEventInfo("Театральное представление");

        System.out.println("--------");

        ticketSystem.showTicketInfo(1);
    }
}
