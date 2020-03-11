package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

import java.util.Comparator;
import java.util.List;

public class NameCreationTest extends TestBase {


  @Test
  public void testNameCreation() throws Exception {
    List<NameData> before = app.nameHelpers().getNameList();
    NameData name = new NameData("Olga", "Eremenko", "89457653453", "ert@mail.ru", "test1");
    app.nameHelpers().createName(name);
    List<NameData> after = app.nameHelpers().getNameList();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(name);
    Comparator<? super NameData> byId = (n1, n2) -> Integer.compare(n1.getId(), n2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
