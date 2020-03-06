package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class NameModificationtest extends TestBase {

  @Test(enabled = false)
  public void testNameModification() {
    if (!app.getNameHelpers().isThereAName()) {
      app.getNameHelpers().createName(new NameData("Olga", "Eremenko", "89457653453", "ert@mail.ru", "test1"));
    }
    List<NameData> before = app.getNameHelpers().getNameList();
    app.getNameHelpers().editName(0);
    NameData name = new NameData(before.get(0).getId(), "Olga", "Eremenko", "89457653453", "ert@mail.ru", null);
    app.getNameHelpers().fillNameForm(name, false);
    app.getNameHelpers().updateName();
    List<NameData> after = app.getNameHelpers().getNameList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(0);
    before.add(name);
    Comparator<? super NameData> byId = (n1,n2) -> Integer.compare(n1.getId(), n2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
