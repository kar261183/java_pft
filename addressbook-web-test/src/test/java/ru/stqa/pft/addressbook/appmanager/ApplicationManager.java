package ru.stqa.pft.addressbook.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.stqa.pft.addressbook.model.NameData;

public class ApplicationManager {
  WebDriver wd;

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

  protected void initN() {
    WebDriverManager.chromedriver().version("80.0.3987.106").setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-gpu");
    wd = new ChromeDriver(options);
    wd.get("http://localhost:8080/addressbook/index.php");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  protected void submitName() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  protected void fillNameForm(NameData nameData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(nameData.getFirstname());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(nameData.getLastname());
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(nameData.getHome());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(nameData.getEmail());
  }

  protected void addNewName() {
    wd.findElement(By.linkText("add new")).click();
  }

  protected void stopN() {
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

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected void deleteName() {
    wd.findElement(By.xpath("//input[@value='Delete']")).click();
  }

  protected void chekboxName() {
    wd.findElement(By.id("32")).click();
  }

  protected void homeName() {
    wd.findElement(By.linkText("home")).click();
  }
}
