package by.epam.pechonick.model.impl;

public enum EventType {
  CONCERT("Concert"),
  FESTIVAL("Festival"),
  DRINKING_BATTLE("Drinking Battle");
  private String value;


  EventType() {
  }

  EventType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
