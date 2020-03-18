package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

import java.util.List;

public class NameDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.name().list().size()==0) {
      app.name().create(new NameData()
              .withFirstname("Olga").withLastname("Eremenko").withHome("89457653453").withEmail("ert@mail.ru").withGroup("test1"));
    }
  }

  @Test
  public void testNameDeletion() throws Exception {
    List<NameData> before = app.name().list();
    int index = 0;
    app.name().delete(index);
    List<NameData> after = app.name().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
    }

}

