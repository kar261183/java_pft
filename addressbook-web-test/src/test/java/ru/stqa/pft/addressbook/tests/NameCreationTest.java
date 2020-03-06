package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

import java.util.HashSet;
import java.util.List;

public class NameCreationTest extends TestBase {


  @Test
  public void testNameCreation() throws Exception {
    List<NameData> before = app.getNameHelpers().getNameList();
    NameData name = new NameData("Olga", "Eremenko", "89457653453", "ert@mail.ru", "test1");
    app.getNameHelpers().createName(name);
    List<NameData> after = app.getNameHelpers().getNameList();
    Assert.assertEquals(after.size(), before.size() + 1);

    name.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(name);
    Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
  }

}
