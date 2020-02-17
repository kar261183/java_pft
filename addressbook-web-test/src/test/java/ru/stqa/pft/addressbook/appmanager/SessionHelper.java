package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase {


  public SessionHelper (WebDriver wd){
    super(wd);
  }

  public void login(String username, String password) {
    wd.get("http://localhost:8080/addressbook/map.php?");
    wd.findElement(By.id("LoginForm")).click();
    wd.findElement(By.xpath("//input[@name='user']")).sendKeys(username);
    wd.findElement(By.xpath("//input[@name='pass']")).sendKeys(password);
    wd.findElement(By.xpath("//input[@type='submit']")).click();
  }
}
