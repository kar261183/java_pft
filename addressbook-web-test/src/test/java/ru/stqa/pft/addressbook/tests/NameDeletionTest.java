package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

import java.util.Set;

public class NameDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.name().all().size()==0) {
      app.name().create(new NameData()
              .withFirstname("Olga").withLastname("Eremenko").withHome("89457653453").withEmail("ert@mail.ru").withGroup("test1"));
    }
  }

  @Test
  public void testNameDeletion() throws Exception {
    Set<NameData> before = app.name().all();
    NameData deletedName = before.iterator().next();
    app.name().delete(deletedName);
    Set<NameData> after = app.name().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedName);
    Assert.assertEquals(before, after);
    }

}

