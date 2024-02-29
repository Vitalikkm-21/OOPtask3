# Ticket Management System

This is a simple ticket management system written in Java. It allows users to manage events and tickets for those events.

## Overview

The Ticket Management System is a Java application designed to facilitate the management of events and tickets. It provides functionalities to add events with details such as name, date, and location, as well as to add tickets for specific events. Additionally, users can view information about events and tickets, aiding in the organization and tracking of ticket sales.

## Usage

1. **Add Events**: Begin by adding events to the system. Specify the name, date, and location of each event.
2. **Add Tickets**: Once events are added, tickets can be added for these events. Provide the type, price, and buyer's name for each ticket.
3. **Display Information**: Utilize the system to display information about events and tickets. View details such as event name, date, location, ticket type, price, and buyer's name.
4. **Database Setup**: Before running the program, ensure that you have set up your PostgreSQL database. Refer to the Database Setup section for instructions.

## Dependencies

- Java Development Kit (JDK)
- PostgreSQL database server
- JDBC driver for PostgreSQL

## Structure

The project consists of the following files:

- `Event.java`: Defines the `Event` class with attributes such as name, date, and location.
- `Ticket.java`: Defines the `Ticket` class with attributes such as event, type, price, and client name.
- `TicketSystem.java`: Implements the ticket management functionalities including adding events, adding tickets, and displaying event and ticket information.
- `proj.java`: Contains the main method to run the ticket management system.

## Step-by-step using:

- Press Ctrl+Alt+Shift+S and add JBDS driver 
- Open PgAdmin and connect yout server 
- Add some info to table or just Ctrl+V this code to your PgAdmin:
```
DROP TABLE IF EXISTS tickets;
CREATE TABLE IF NOT EXISTS tickets(
    id int ,
    event varchar(60),
    type varchar(60),
    price float,
    name varchar(60)
);
SELECT * FROM tickets
```
- Work is done. You can run code
