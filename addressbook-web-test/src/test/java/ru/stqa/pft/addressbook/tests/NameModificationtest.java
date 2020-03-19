package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;
import ru.stqa.pft.addressbook.model.Names;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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
    Names before = app.name().all();
    NameData modifiedName = before.iterator().next();
    NameData name = new NameData()
            .withId(modifiedName.getId()).withFirstname("Olga").withLastname("Eremenko");
    app.name().modify(name);
    Names after = app.name().all();
    assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedName).withAdded(name)));
  }


}
