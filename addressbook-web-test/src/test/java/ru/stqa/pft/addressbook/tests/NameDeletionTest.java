package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;
import ru.stqa.pft.addressbook.model.Names;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class NameDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.name().all().size()==0) {
      app.name().create(new NameData()
              .setFirstname("Olga")
              .setLastname("Eremenko")
              .setHomePhone("89457653453")
              .setEmail("ert@mail.ru")
              .setGroup("test1"));
    }
  }

  @Test
  public void testNameDeletion() throws Exception {
    Names before = app.name().all();
    NameData deletedName = before.iterator().next();
    app.name().delete(deletedName);
    Names after = app.name().all();
    assertEquals(after.size(), before.size() - 1);
    assertThat(after, equalTo(before.without(deletedName)));
    }

}

