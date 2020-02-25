package by.epam.pechonick.service;

import by.epam.pechonick.dao.impl.UserDao;
import by.epam.pechonick.exception.ConnectionPoolException;
import by.epam.pechonick.exception.DaoException;
import by.epam.pechonick.model.impl.User;
import by.epam.pechonick.pool.ConnectionPool;
import by.epam.pechonick.pool.ProxyConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class UserService {
  private static final Logger LOGGER = LogManager.getLogger();

  public List<User> findAll() {
    List<User> users = new ArrayList<>();
    try (ProxyConnection connection = ConnectionPool.getInstance().getConnection()) {
      UserDao userDao = new UserDao(connection);
      users = userDao.findAll();
    } catch (ConnectionPoolException e) {
      LOGGER.error("Connection pool error: ", e);
    } catch (DaoException e) {
      LOGGER.error("Dao Exception: ", e);
    }
    return users;
  }
}
