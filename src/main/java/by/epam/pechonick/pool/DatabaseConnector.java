package by.epam.pechonick.pool;

import by.epam.pechonick.exception.DatabaseConnectorException;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

public class DatabaseConnector {
  private static final String CONFIG_FILE_NAME = "message.properties";
  private static final AtomicBoolean initialized = new AtomicBoolean(false);
  private static Properties config;

  public static Connection getConnection() throws DatabaseConnectorException {
    if (!initialized.get()) {
      init();
    }

    try {
      return DriverManager.getConnection(config.getProperty("url"), config);
    } catch (SQLException e) {
      throw new DatabaseConnectorException("Database connection error: " + e.getMessage());
    }
  }

  private static void init() throws DatabaseConnectorException {
    initialized.set(true);
    URL configFile = DatabaseConnector.class.getClassLoader().getResource(CONFIG_FILE_NAME);

    if (configFile == null) {
      throw new DatabaseConnectorException("Config file (" + CONFIG_FILE_NAME + ") not found");
    }

    try (FileInputStream inputStream = new FileInputStream(configFile.getFile())) {
      DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
      config = new Properties();
      config.load(inputStream);
    } catch (IOException e) {
      throw new DatabaseConnectorException("Problem with config file: " + e.getMessage());
    } catch (SQLException e) {
      throw new DatabaseConnectorException("Database connection error: " + e.getMessage());
    }
  }
}
