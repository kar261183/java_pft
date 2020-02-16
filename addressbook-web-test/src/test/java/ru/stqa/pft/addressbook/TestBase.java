package ru.stqa.pft.addressbook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
  public WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() {
    WebDriverManager.chromedriver().version("80.0.3987.106").setup();
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--disable-gpu");
    wd = new ChromeDriver(options);
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.get("http://localhost:8080/addressbook/map.php?");
    wd.findElement(By.id("LoginForm")).click();
    wd.findElement(By.xpath("//input[@name='user']")).sendKeys(username);
    wd.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
    wd.findElement(By.xpath("//input[@type='submit']")).click();
  }

  protected void gotoHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  protected void submitNameCreation() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  protected void initNameCreation(GroupNameData groupNameData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(groupNameData.getFirstname());
    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(groupNameData.getLastname());
    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(groupNameData.getMobile());
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(groupNameData.getEmail());
  }

  protected void gotoName() {
    wd.findElement(By.linkText("add new")).click();
  }

  protected void returngrouppage() {
    wd.findElement(By.linkText("group page")).click();
  }

  protected void submitGroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  protected void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  protected void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  protected void gotoGroup() {
    wd.findElement(By.linkText("groups")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
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

  protected void deleteSelectedGroups() {
    wd.findElement(By.xpath("(//input[@name='delete'])[2]")).click();
  }

  protected void selectGroup() {
    wd.findElement(By.name("selected[]")).click();
  }
}
