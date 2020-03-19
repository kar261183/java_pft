package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

import java.util.Set;

public class NameCreationTest extends TestBase {


  @Test
  public void testNameCreation() throws Exception {
    Set<NameData> before = app.name().all();
    NameData name = new NameData()
            .withFirstname("Olga").withLastname("Eremenko").withHome("89457653453").withEmail("ert@mail.ru").withGroup("test1");
    app.name().create(name);
    Set<NameData> after = app.name().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    name.withId(after.stream().mapToInt((n) -> n.getId()).max().getAsInt());
    before.add(name);
    Assert.assertEquals(before, after);
  }

}
