package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.NameData;

import java.util.ArrayList;
import java.util.List;

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

    if (creation) {
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
    waitElementPresent(By.xpath("//*[contains(text(),'Number of res')]"), 10);
  }

  public void checkboxName(int index) throws InterruptedException {
    wd.findElements(By.xpath("//table/tbody/tr[contains(@name,'entry')][1]//input")).get(index).click();
  }
  public void homeName() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }


  public void editName(int index) {
    wd.findElements(By.xpath("//table/tbody/tr[contains(@name,'entry')][1]//a[contains(@href,'edit')]")).get(index).click();
  }

  public void updateName() {
    click(By.xpath("//input[@name='update'][2]"));
    waitElementPresent(By.xpath("//*[contains(text(),'Number of res')]"), 35);
  }


  public void createName(NameData name) {
    addNewName();
    fillNameForm(name,true);
    submitName();
    homeName();
  }

  public boolean isThereAName() {
    return isElementPresent(By.xpath("//table/tbody/tr[contains(@name,'entry')][1]//input"));
  }

  public int getNameCount() {
    return wd.findElements(By.xpath("//table/tbody/tr[contains(@name,'entry')]")).size();
  }

  public List<NameData> getNameList() {
    List<NameData> names = new ArrayList<NameData>();
    List<WebElement> elements = wd.findElements(By.xpath("//input[@name='selected[]']"));
    for (WebElement element : elements) {
      String firstname = element.getText();
      NameData name = new NameData(firstname, null, null, null, null);
      names.add(name);
    }
    return names;
  }
  }


