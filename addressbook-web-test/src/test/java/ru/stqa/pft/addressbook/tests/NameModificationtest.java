package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

import java.util.Set;

public class NameModificationtest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.name().all().size()==0) {
      app.name().create(new NameData()
              .withFirstname("Olga").withLastname("Eremenko").withHome("89457653453").withEmail("ert@mail.ru").withGroup("test1"));
    }
  }

  @Test
  public void testNameModification() {
    Set<NameData> before = app.name().all();
    NameData modifiedName = before.iterator().next();
    NameData name = new NameData()
            .withId(modifiedName.getId()).withFirstname("Olga").withLastname("Eremenko");
    app.name().modify(name);
    Set<NameData> after = app.name().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedName);
    before.add(name);
    Assert.assertEquals(before, after);
  }


}
