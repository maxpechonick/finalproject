package by.epam.pechonick.dao;

import by.epam.pechonick.exception.DaoException;
import by.epam.pechonick.model.Entity;
import by.epam.pechonick.pool.ProxyConnection;

import java.util.List;

public abstract class AbstractDao<K, T extends Entity> {
  protected ProxyConnection connection;

  public AbstractDao(ProxyConnection connection) {
    this.connection = connection;
  }

  public abstract List<T> findAll() throws UnsupportedOperationException, DaoException;
}
