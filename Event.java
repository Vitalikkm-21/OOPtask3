public class Event {

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

