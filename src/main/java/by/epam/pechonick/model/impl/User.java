package by.epam.pechonick.model.impl;

import by.epam.pechonick.model.Entity;
import by.epam.pechonick.model.impl.Role;

public class User extends Entity {
  private int id;
  private String name;
  private String surname;
  private String mail;
  private String password;
  private String phone;
  private Role role;

  public User() {
  }

  public User(int id, String name, String surname, String mail, String password, String phone, Role role) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.mail = mail;
    this.password = password;
    this.phone = phone;
    this.role = role;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("User{");
    sb.append("id=").append(id);
    sb.append(", name='").append(name).append('\'');
    sb.append(", surname='").append(surname).append('\'');
    sb.append(", mail='").append(mail).append('\'');
    sb.append(", password='").append(password).append('\'');
    sb.append(", phone='").append(phone).append('\'');
    sb.append(", role=").append(role);
    sb.append('}');
    return sb.toString();
  }
}
