package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

@XStreamAlias("name")
public class NameData {
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String lastname;
  private String homePhone;
  private String group;
  private String mobilePhone;
  private String workPhone;
  private String allPhones;
  private String address;
  private String email;
  private String email2;
  private String email3;
  private String allEmail;

  public File getPhoto() {
    return photo;
  }

  public NameData setPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  private File photo;

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

  public NameData setEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public NameData setEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public NameData setAllEmail(String allEmail) {
    this.allEmail = allEmail;
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

  public NameData setAddress(String address) {
    this.address = address;
    return this;
  }


  public int getId() {
    return id;
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

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getAllEmail() {
    return allEmail;
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

  public String getAddress() {
    return address;
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
