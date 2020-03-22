package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.NameData;
import ru.stqa.pft.addressbook.model.Names;

import java.util.List;

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
    type(By.xpath(link_homePhone), nameData.getHomePhone());
    type(By.xpath(link_mobilePhone), nameData.getMobilePhone());
    type(By.xpath(link_workPhone), nameData.getWorkPhone());
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
      String[] phones = wd.findElement(By.xpath(trElement + "//td[6]")).getText().split("\n");
      int id = Integer.parseInt(wd.findElement(By.xpath(trElement + "//td[1]/input")).getAttribute("id"));
      names.add(new NameData()
              .setId(id)
              .setFirstname(firstName)
              .setLastname(lastName)
              .setHomePhone(phones[0])
              .setMobilePhone(phones[1])
              .setWorkPhone(phones[2]));
    }
    return names;
  }

  String link_homePhone = "//input[@name='home']";
  String link_mobilePhone = "//input[@name='mobile']";
  String link_workPhone = "//input[@name='work']";

  public NameData infoFromEditForm(NameData name) {
    initNameModificationByTd(name.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String homePhone = wd.findElement(By.xpath(link_homePhone)).getAttribute("value");
    String mobilePhone = wd.findElement(By.xpath(link_mobilePhone)).getAttribute("value");
    String workPhone = wd.findElement(By.xpath(link_workPhone)).getAttribute("value");

    wd.navigate().back();
    return new NameData()
            .setId(name.getId())
            .setFirstname(firstname)
            .setLastname(lastname)
            .setHomePhone(homePhone)
            .setMobilePhone(mobilePhone)
            .setWorkPhone(workPhone);
  }

  private void initNameModificationByTd(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }

}



