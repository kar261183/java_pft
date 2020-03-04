package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

public class NameModificationtest extends TestBase {

  @Test
  public void testNameModification() {
    int before = app.getNameHelpers().getNameCount();
    if (!app.getNameHelpers().isThereAName()) {
      app.getNameHelpers().createName(new NameData("Olga", "Eremenko", "89457653453", "ert@mail.ru", "test1"));
    }
    app.getNameHelpers().editName(0);
    app.getNameHelpers().fillNameForm(new NameData("Olga", "Eremenko", "89457653453", "ert@mail.ru", null), false);
    app.getNameHelpers().updateName();
    int after = app.getNameHelpers().getNameCount();
    Assert.assertEquals(after, before);
  }
}
