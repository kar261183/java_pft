package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.NameData;

public class NameHelpers extends HelperBase{
  public NameHelpers(WebDriver wd) {
    super(wd);
  }

  public void submitName() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillNameForm(NameData nameData, boolean creation) {
    type(By.name("firstname"), nameData.getFirstname());
    type(By.name("lastname"), nameData.getLastname());
    type(By.name("home"), nameData.getHome());
    type(By.name("email"), nameData.getEmail());

    if (creation){
      new Select(wd.findElement(By.xpath("//select[@name='new_group']"))).selectByVisibleText(nameData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.xpath("//select[@name='new_group']")));
    }
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
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }


  public void editName() {
    click(By.xpath("//table/tbody/tr[contains(@name,'entry')][1]//a[contains(@href,'edit')]"));
  }

  public void updateName() {
    click(By.xpath("//input[@name='update'][2]"));
  }


}
