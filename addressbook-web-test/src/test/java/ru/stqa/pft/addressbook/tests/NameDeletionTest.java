package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

import java.util.List;

public class NameDeletionTest extends TestBase {

  @Test
  public void testNameDeletion() throws Exception {
    if (!app.getNameHelpers().isThereAName()) {
      app.getNameHelpers().createName(new NameData("Olga", "Eremenko", "89457653453", "ert@mail.ru", "test1"));
    }
    List<NameData> before = app.getNameHelpers().getNameList();
    app.getNameHelpers().checkboxName(0);
    app.getNameHelpers().deleteName();
    List<NameData> after = app.getNameHelpers().getNameList();
    Assert.assertEquals(after.size(), before.size() - 1);
  }

}
