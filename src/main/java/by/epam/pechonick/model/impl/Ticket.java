package by.epam.pechonick.model.impl;

import by.epam.pechonick.model.Entity;

import java.math.BigDecimal;

public class Ticket extends Entity {
  private int ticketId;
  private BigDecimal price;
  private SeatType seatType;
  private EventType eventType;

  public Ticket(int ticketId, BigDecimal price, SeatType seatType, EventType eventType) {
    this.ticketId = ticketId;
    this.price = price;
    this.seatType = seatType;
    this.eventType = eventType;
  }

  public Ticket() {
  }

  public int getTicketId() {
    return ticketId;
  }

  public void setTicketId(int ticketId) {
    this.ticketId = ticketId;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public SeatType getSeatType() {
    return seatType;
  }

  public void setSeatType(SeatType seatType) {
    this.seatType = seatType;
  }

  public EventType getEventType() {
    return eventType;
  }

  public void setEventType(EventType eventType) {
    this.eventType = eventType;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Ticket{");
    sb.append("ticketId=").append(ticketId);
    sb.append(", price=").append(price);
    sb.append(", seatType=").append(seatType);
    sb.append(", eventType=").append(eventType);
    sb.append('}');
    return sb.toString();
  }
}
