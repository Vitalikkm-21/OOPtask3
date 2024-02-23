package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class proj {
    public static void main(String[] args) {
        // Создание системы управления билетами
        TicketSystem ticketSystem = new TicketSystem();

        // Добавление мероприятий
        Event event1 = new Event("Концерт", "22 февраля 2024", "Зал 'Концертный'");
        Event event2 = new Event("Театральное представление", "26 февраля 2024", "Театр 'Драма'");
        ticketSystem.addEvent(event1);
        ticketSystem.addEvent(event2);

        // Добавление билетов вручную
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Выберите куда вы пойдете: 1 - Концерт, 2 - Театральное представление, 0 - чтобы закончить покупки: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1) {
                System.out.println("Добавление билета на Концерт:");
                System.out.print("Тип билета: ");
                String ticketType = scanner.nextLine();
                System.out.print("Цена билета: ");
                double ticketPrice = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Имя покупателя: ");
                String buyerName = scanner.nextLine();

                ticketSystem.addTicket("Концерт", ticketType, ticketPrice, buyerName);
            } else if (choice == 2) {
                System.out.println("Добавление билета на Театральное представление:");
                System.out.print("Тип билета: ");
                String ticketType = scanner.nextLine();
                System.out.print("Цена билета: ");
                double ticketPrice = scanner.nextDouble();
                scanner.nextLine(); // Чтение лишнего перевода строки после ввода числа
                System.out.print("Имя покупателя: ");
                String buyerName = scanner.nextLine();

                ticketSystem.addTicket("Театральное представление", ticketType, ticketPrice, buyerName);
            } else if (choice == 0) {
                break;
            }
            else {
                System.out.print("Ошибка ввода мероприятия");
            }
        }

        System.out.println("--------");

        // Отображение информации о мероприятии и билете
        ticketSystem.showEventInfo("Концерт");
        System.out.println("--------");
        ticketSystem.showEventInfo("Театральное представление");

        System.out.println("--------");
        System.out.println("какой ID билета вывести?");
        int id_ticket = scanner.nextInt();
        ticketSystem.showTicketInfo(id_ticket);

        // Закрытие Scanner
        scanner.close();
    }
}
