package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.NameData;

public class NameHelpers {
  private WebDriver wd;

  public NameHelpers(WebDriver wd) {
    this.wd = wd;
  }

  public void submitName() {
    clickN(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void clickN(By locator) {
    wd.findElement(locator).click();
  }

  public void fillNameForm(NameData nameData) {
    typeN(By.name("firstname"), nameData.getFirstname());
    typeN(By.name("lastname"), nameData.getLastname());
    typeN(By.name("home"), nameData.getHome());
    typeN(By.name("email"), nameData.getEmail());
  }

  public void typeN(By locatorN, String textN) {
    clickN(locatorN);
    wd.findElement(locatorN).clear();
    wd.findElement(locatorN).sendKeys(textN);
  }

  public void addNewName() {
    clickN(By.linkText("add new"));
  }

  public void deleteName() {
    clickN(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
  }

  public void chekboxName() {
    clickN(By.xpath("//table/tbody/tr[contains(@name,'entry')][1]//input"));
  }

  public void homeName() {
    clickN(By.linkText("home"));
  }


  public void editName() {
    clickN(By.xpath("//table/tbody/tr[contains(@name,'entry')][1]//a[contains(@href,'edit')]"));
  }

  public void updateName() {
    clickN(By.xpath("//input[@name='update'][2]"));
  }


}
