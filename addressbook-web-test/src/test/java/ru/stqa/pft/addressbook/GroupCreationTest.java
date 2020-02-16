package ru.stqa.pft.addressbook;


import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.gotoGroup();
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("test1", "test2", "test3"));
    app.submitGroupCreation();
    app.returngrouppage();
  }

  @Test
  public void testNameCreation() throws Exception {
    app.gotoName();
    app.initNameCreation(new GroupNameData("Maria", "Maeva", "+79342837462", "yurt@gmail.com"));
    app.submitNameCreation();
    app.gotoHomePage();

  }


}
