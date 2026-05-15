package ua.khpi.oop.lab11.model;

import java.util.Objects;

public class Ticket {
    private final String ticketNumber; 
    private final String passengerName; 
    private final String stopId;        
    private final double price;        

    public Ticket(String ticketNumber, String passengerName, String stopId, double price) {
        this.ticketNumber = ticketNumber;
        this.passengerName = passengerName;
        this.stopId = stopId;
        this.price = price;
    }

    public String getTicketNumber() { return ticketNumber; }
    public String getStopId() { return stopId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(ticketNumber, ticket.ticketNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketNumber);
    }

    @Override
    public String toString() {
        return String.format("Квиток №%s [%s] до зупинки %s, ціна: %.2f грн", 
                             ticketNumber, passengerName, stopId, price);
    }
}