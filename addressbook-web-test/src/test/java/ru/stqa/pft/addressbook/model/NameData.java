package ru.stqa.pft.addressbook.model;

public class NameData {
  private final String firstname;
  private final String lastname;
  private final String home;
  private final String email;
  private String group;

  public NameData(String firstname, String lastname, String home, String email, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.home = home;
    this.email = email;
    this.group = group;
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
}
