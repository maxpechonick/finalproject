package by.epam.pechonick.model.impl;

public enum SeatType {
  PARTERRE("Parter"),
  BALCONY("Balcony"),
  SECTOR_A("Sector A"),
  SECTOR_B("Sector B"),
  TRIBUNE_A("Tribune A"),
  TRIBUNE_B("Tribune B"),
  FAN_ZONE("Fan Zone"),
  DANCE_FLOOR("Dance floor"),
  ROW_1("Row 1"),
  ROW_2("Row 2");

  private String value;

  SeatType() {
  }

  SeatType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}