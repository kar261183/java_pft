package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

public class NameCreationTest extends TestBase {


  @Test
  public void testNameCreation() throws Exception {
    int before = app.getNameHelpers().getNameCount();
    app.getNameHelpers().createName(new NameData("Olga", "Eremenko", "89457653453", "ert@mail.ru", "test1"));
    int after = app.getNameHelpers().getNameCount();
    Assert.assertEquals(after, before +1);
  }

}
