package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.NameData;
import ru.stqa.pft.addressbook.model.Names;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NameHelpers extends HelperBase {
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

  public void delete() {
    click(By.xpath("//input[@value='Delete']"));
    wd.switchTo().alert().accept();
    waitElementPresent(By.xpath("//*[contains(text(),'Number of res')]"), 10);
  }

  public void checkbox(int index) throws InterruptedException {
    wd.findElements(By.xpath("//table/tbody/tr[contains(@name,'entry')][1]//input")).get(index).click();
  }

  public void checkboxById(int id) throws InterruptedException {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void homeName() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  private void editNameById(int id) {
    wd.findElement(By.xpath("//img[@alt='Edit']")).click();

  }

  public void modify(NameData name) {
    editNameById(name.getId());
    fillNameForm(name, false);
    updateName();
  }


  public void updateName() {
    click(By.xpath("//input[@name='update'][2]"));
    waitElementPresent(By.xpath("//*[contains(text(),'Number of res')]"), 35);
  }


  public void create(NameData name) {
    addNewName();
    fillNameForm(name, true);
    submitName();
    homeName();
  }

  public void delete(NameData name) throws InterruptedException {
    checkboxById(name.getId());
    delete();
  }

  public Names all() {
    Names names = new Names();
    List<WebElement> elements = wd.findElements(By.xpath("//table/tbody/tr[contains(@name,'entry')]"));
    for (int i = 0; i < elements.size(); i++) {
      String trElement = "//table/tbody/tr[contains(@name,'entry')][" + (i + 1) + "]";
      String firstName = wd.findElement(By.xpath(trElement + "//td[3]")).getText();
      String lastName = wd.findElement(By.xpath(trElement + "//td[2]")).getText();
      int id = Integer.parseInt(wd.findElement(By.xpath(trElement + "//td[1]/input")).getAttribute("id"));
      names.add(new NameData().withId(id).withFirstname(firstName).withLastname(lastName));
    }
    return names;
  }

}



