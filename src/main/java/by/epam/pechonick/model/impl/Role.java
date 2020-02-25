package by.epam.pechonick.model.impl;

import by.epam.pechonick.model.Entity;

public class Role extends Entity {
  private int idRole;
  private String description;

  public Role() {
  }

  public Role(int idRole, String description) {
    this.idRole = idRole;
    this.description = description;
  }

  public int getIdRole() {
    return idRole;
  }

  public void setIdRole(byte idRole) {
    this.idRole = idRole;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Role{");
    sb.append("idRole=").append(idRole);
    sb.append(", description='").append(description).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
