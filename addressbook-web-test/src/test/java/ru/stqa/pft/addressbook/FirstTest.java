package ru.stqa.pft.addressbook;


import org.testng.annotations.Test;

public class FirstTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    gotoGroup();
    initGroupCreation();
    fillGroupForm(new GroupData("test1", "test2", "test3"));
    submitGroupCreation();
    returngrouppage();
  }

  @Test
  public void testNameCreation() throws Exception {
    gotoName();
    initNameCreation(new GroupNameData("Maria", "Maeva", "+79342837462", "yurt@gmail.com"));
    submitNameCreation();
    gotoHomePage();

  }


}
