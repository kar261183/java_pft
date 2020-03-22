package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class NameData {
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String homePhone;
  private String email;
  private String group;
  private String mobilePhone;
  private String workPhone;
  private String allPhones;


  public int getId() {
    return id;
  }

  public NameData setId(int id) {
    this.id = id;
    return this;
  }

  public NameData setFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public NameData setLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public NameData setHomePhone(String home) {
    this.homePhone = home;
    return this;
  }

  public NameData setEmail(String email) {
    this.email = email;
    return this;
  }

  public NameData setGroup(String group) {
    this.group = group;
    return this;
  }

  public NameData setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public NameData setWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public NameData setAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getFirstname() {
    return firstname;
  }


  public String getLastname() {
    return lastname;
  }

  public String getHomePhone() {
    return homePhone;
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

  public String getAllPhones(){
    return allPhones;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NameData nameData = (NameData) o;
    return id == nameData.id &&
            Objects.equals(firstname, nameData.firstname) &&
            Objects.equals(lastname, nameData.lastname) &&
            Objects.equals(homePhone, nameData.homePhone) &&
            Objects.equals(mobilePhone, nameData.mobilePhone) &&
            Objects.equals(workPhone, nameData.workPhone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstname, lastname, homePhone, mobilePhone, workPhone);
  }

  @Override
  public String toString() {
    return "NameData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", home='" + homePhone + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", workPhone='" + workPhone + '\'' +
            '}';
  }



}
