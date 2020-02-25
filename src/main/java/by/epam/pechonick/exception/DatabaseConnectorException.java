package by.epam.pechonick.exception;

public class DatabaseConnectorException extends Exception {
  public DatabaseConnectorException() {
  }

  public DatabaseConnectorException(String message) {
    super(message);
  }

  public DatabaseConnectorException(String message, Throwable cause) {
    super(message, cause);
  }

  public DatabaseConnectorException(Throwable cause) {
    super(cause);
  }

  public DatabaseConnectorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
