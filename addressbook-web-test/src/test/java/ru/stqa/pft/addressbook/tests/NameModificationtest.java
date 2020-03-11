package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

import java.util.Comparator;
import java.util.List;

public class NameModificationtest extends TestBase {

  @Test
  public void testNameModification() {
    if (!app.nameHelpers().isThereAName()) {
      app.nameHelpers().createName(new NameData("Olga", "Eremenko", "89457653453", "ert@mail.ru", "test1"));
    }
    List<NameData> before = app.nameHelpers().getNameList();
    app.nameHelpers().editName(0);
    NameData name = new NameData(before.get(0).getId(), "Olga", "Eremenko", "89457653453", "ert@mail.ru", null);
    app.nameHelpers().fillNameForm(name, false);
    app.nameHelpers().updateName();
    List<NameData> after = app.nameHelpers().getNameList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(0);
    before.add(name);
    Comparator<? super NameData> byId = (n1,n2) -> Integer.compare(n1.getId(), n2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
