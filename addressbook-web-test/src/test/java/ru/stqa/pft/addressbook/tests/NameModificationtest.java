package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

import java.util.List;

public class NameModificationtest extends TestBase {

  @Test
  public void testNameModification() {
    if (!app.getNameHelpers().isThereAName()) {
      app.getNameHelpers().createName(new NameData("Olga", "Eremenko", "89457653453", "ert@mail.ru", "test1"));
    }
    List<NameData> before = app.getNameHelpers().getNameList();
    app.getNameHelpers().editName(0);
    app.getNameHelpers().fillNameForm(new NameData("Olga", "Eremenko", "89457653453", "ert@mail.ru", null), false);
    app.getNameHelpers().updateName();
    List<NameData> after = app.getNameHelpers().getNameList();
    Assert.assertEquals(after.size(), before.size());
  }
}
