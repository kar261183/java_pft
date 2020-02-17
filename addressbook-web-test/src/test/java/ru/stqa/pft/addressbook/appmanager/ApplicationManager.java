package ru.stqa.pft.addressbook.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ApplicationManager {
  private WebDriver wd;

  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;

  public void init() {
    WebDriverManager.chromedriver().version("80.0.3987.106").setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-gpu");
    groupHelper = new GroupHelper(wd);
    wd = new ChromeDriver(options);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }


  public void gotoHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  public void submitNameCreation() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }


  public void gotoName() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void stop() {
    wd.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public GroupHelper getGroupHelper() {
    return groupHelper = new GroupHelper(wd);
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }
}
