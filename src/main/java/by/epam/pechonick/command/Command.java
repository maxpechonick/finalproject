package by.epam.pechonick.command;

import by.epam.pechonick.content.RequestContent;
import by.epam.pechonick.exception.CommandException;

public interface Command {
  String execute(RequestContent content) throws CommandException;
}
