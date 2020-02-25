package by.epam.pechonick.command.impl;

import by.epam.pechonick.command.Command;
import by.epam.pechonick.content.RequestContent;

public class EmptyCommand implements Command {
  @Override
  public String execute(RequestContent content) {
    return null;
  }
}
