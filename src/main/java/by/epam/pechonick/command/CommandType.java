package by.epam.pechonick.command;

import by.epam.pechonick.command.impl.LoginCommand;

public enum  CommandType {
  LOGIN(new LoginCommand());

  private Command command;
  CommandType(Command command){
    this.command=command;
  }

  public Command getCommand(){
    return command;
  }
}
