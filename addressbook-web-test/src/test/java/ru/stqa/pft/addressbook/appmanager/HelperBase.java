package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public void click(By locator) {
    new WebDriverWait(wd, 3).until(ExpectedConditions.elementToBeClickable(locator));
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    new WebDriverWait(wd, 3).until(ExpectedConditions.elementToBeClickable(locator));
    if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (! text.equals(existingText))
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
    }
  }
}
