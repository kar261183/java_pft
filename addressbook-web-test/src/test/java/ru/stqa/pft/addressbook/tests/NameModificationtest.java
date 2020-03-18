package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

import java.util.Comparator;
import java.util.List;

public class NameModificationtest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    if (app.name().list().size()==0) {
      app.name().create(new NameData()
              .withFirstname("Olga").withLastname("Eremenko").withHome("89457653453").withEmail("ert@mail.ru").withGroup("test1"));
    }
  }

  @Test
  public void testNameModification() {
    List<NameData> before = app.name().list();
    int index = 0;
    NameData name = new NameData()
            .withId(before.get(index).getId()).withFirstname("Olga").withLastname("Eremenko");
    app.name().modify(index, name);
    List<NameData> after = app.name().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(name);
    Comparator<? super NameData> byId = (n1,n2) -> Integer.compare(n1.getId(), n2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


}
