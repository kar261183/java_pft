package ru.stqa.pft.addressbook.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ApplicationManager {
  WebDriver wd;

  private NameHelpers nameHelpers;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;

  public void init() {
    WebDriverManager.chromedriver().version("80.0.3987.106").setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-gpu");
    wd = new ChromeDriver(options);
    wd.get("http://localhost:8080/addressbook/edit.php");
    groupHelper = new GroupHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    nameHelpers = new NameHelpers(wd);
    sessionHelper.login("admin", "secret");
  }

  public void stop() {
    wd.quit();
  }

  public GroupHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public void initN() {
    WebDriverManager.chromedriver().version("80.0.3987.106").setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-gpu");
    wd = new ChromeDriver(options);
    wd.get("http://localhost:8080/addressbook/index.php");
    nameHelpers = new NameHelpers(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("admin", "secret");
  }

  public void stopN() {
    wd.quit();
  }

  public NameHelpers getNameHelpers() {
    return nameHelpers;
  }

  }

