package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class NameData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String home;
  private String email;
  private String group;
  private String mobilePhone;
  private String workPhone;


  public int getId() {
    return id;
  }

  public NameData withId(int id) {
    this.id = id;
    return this;
  }

  public NameData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public NameData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public NameData withHome(String home) {
    this.home = home;
    return this;
  }

  public NameData withEmail(String email) {
    this.email = email;
    return this;
  }

  public NameData withGroup(String group) {
    this.group = group;
    return this;
  }

  public NameData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public NameData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
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

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
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
            ", home='" + home + '\'' +
            ", email='" + email + '\'' +
            ", group='" + group + '\'' +
            '}';
  }



}
