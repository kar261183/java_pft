package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    if (isElementPresent(By.xpath("//h1[contains(text(),'Groups')]"))
            && wd.findElement(By.xpath("//h1[contains(text(),'Groups')]")).getText().equals("Groups")
            && isElementPresent(By.xpath("//body/div[@id='container']/div[@id='content']/form/input[1]"))) {
      return;
    }
    click(By.linkText("groups"));

  }
}


