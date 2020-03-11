package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class NameData {
  private int id;
  private final String firstname;
  private final String lastname;
  private final String home;
  private final String email;
  private String group;

  public NameData(String firstname, String lastname, String home, String email, String group) {
    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.lastname = lastname;
    this.home = home;
    this.email = email;
    this.group = group;
  }

  public NameData(int id, String firstname, String lastname, String home, String email, String group) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.home = home;
    this.email = email;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }


  public String getLastname() {
    return lastname;
  }

  public String getHome() {
    return home;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NameData nameData = (NameData) o;
    return id == nameData.id &&
            Objects.equals(firstname, nameData.firstname) &&
            Objects.equals(lastname, nameData.lastname);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname);
  }

  @Override
  public String toString() {
    return "NameData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }
}
