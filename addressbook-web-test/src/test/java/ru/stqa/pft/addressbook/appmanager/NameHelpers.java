package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.NameData;

public class NameHelpers extends HelperBase{
  public NameHelpers(WebDriver wd) {
    super(wd);
  }

  public void submitName() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillNameForm(NameData nameData) {
    type(By.name("firstname"), nameData.getFirstname());
    type(By.name("lastname"), nameData.getLastname());
    type(By.name("home"), nameData.getHome());
    type(By.name("email"), nameData.getEmail());
  }

  public void addNewName() {
    click(By.linkText("add new"));
  }

  public void deleteName() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void chekboxName() throws InterruptedException {
    click(By.xpath("//table/tbody/tr[contains(@name,'entry')][1]//input"));
  }

  public void homeName() {
    click(By.linkText("home"));
  }


  public void editName() {
    click(By.xpath("//table/tbody/tr[contains(@name,'entry')][1]//a[contains(@href,'edit')]"));
  }

  public void updateName() {
    click(By.xpath("//input[@name='update'][2]"));
  }


}