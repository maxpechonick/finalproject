package by.epam.pechonick.dao.impl;

import by.epam.pechonick.dao.AbstractDao;
import by.epam.pechonick.exception.DaoException;
import by.epam.pechonick.model.impl.Role;
import by.epam.pechonick.model.impl.User;
import by.epam.pechonick.pool.ProxyConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao {
  private static final String SELECT_BY_PHONE = "SELECT iduser, name, surname FROM users WHERE phone = ?";
  private static final String FIND_ALL = "SELECT iduser,name,surname,mail,password,phone,role_idrole FROM users";

  public UserDao(ProxyConnection connection) {
    super(connection);
  }

  public List<User> findByPhone(String phone) {
    return null;
  }

  @Override
  public List<User> findAll() throws UnsupportedOperationException, DaoException {
    List<User> users = new ArrayList<>();

    try (Statement st = connection.createStatement()) {

      ResultSet rs = st.executeQuery(FIND_ALL);
      while (rs.next()) {

        int id = rs.getInt(1);
        String name = rs.getString(2);
        String surname = rs.getString(3);
        String mail = rs.getString(4);
        String password = rs.getString(5);
        String phone = rs.getString(6);
        int role = rs.getByte(7);
        users.add(new User(id, surname, name, mail, password, phone, new Role(role, "user")));
      }
    } catch (SQLException e) {
      throw new DaoException("Error while trying to find all users", e);
    }
    return users;
  }
}
