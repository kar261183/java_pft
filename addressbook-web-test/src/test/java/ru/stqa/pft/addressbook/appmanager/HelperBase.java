package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public void click(By locator) {
    new WebDriverWait(wd, 15).until(ExpectedConditions.elementToBeClickable(locator));
    wd.findElement(locator).click();
  }

  public void waitElementPresent(By locator, int seconds) {
    new WebDriverWait(wd, seconds).until(ExpectedConditions.elementToBeClickable(locator));
  }

  protected void type(By locator, String text) {
    new WebDriverWait(wd, 3). until(ExpectedConditions.elementToBeClickable(locator));
    click(locator);
    if (text != null){
      String existingText = wd.findElement(locator).getAttribute("value");
      if (! text.equals(existingText)){
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }

  }

  protected void attach(By locator, File file) {
    new WebDriverWait(wd, 3). until(ExpectedConditions.elementToBeClickable(locator));
    if (file != null){
        wd.findElement(locator).sendKeys(file.getAbsolutePath());
      }
    }


  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  public void gotoHomePage() {
    wd.findElement(By.linkText("home")).click();
  }
}
