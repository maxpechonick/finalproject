package by.epam.pechonick.command.factory;

import by.epam.pechonick.command.Command;
import by.epam.pechonick.command.CommandType;
import by.epam.pechonick.command.impl.EmptyCommand;
import by.epam.pechonick.content.RequestContent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CommandFactory {
  private static final Logger LOGGER = LogManager.getLogger();
  private static final String COMMAND_PARAM = "command";

  public static Command defineCommand(RequestContent request) {
    Command current = new EmptyCommand();
    String action = request.getParameter(COMMAND_PARAM);
    if (action == null || action.isEmpty()) {
      return current;
    }
    try {
      CommandType currentEnum = CommandType.valueOf(action.toUpperCase());
      current = currentEnum.getCommand();

    } catch (IllegalArgumentException e) {
      LOGGER.error("Illegal argument " + e);
    }

    return current;
  }

}
