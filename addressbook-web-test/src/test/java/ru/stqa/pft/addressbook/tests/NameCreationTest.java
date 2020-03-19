package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;
import ru.stqa.pft.addressbook.model.Names;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NameCreationTest extends TestBase {


  @Test
  public void testNameCreation() throws Exception {
    Names before = app.name().all();
    NameData name = new NameData()
            .withFirstname("Olga").withLastname("Eremenko").withHome("89457653453").withEmail("ert@mail.ru").withGroup("test1");
    app.name().create(name);
    Names after = app.name().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before.withAdded(
            name.withId(after.stream().mapToInt((n) -> n.getId()).max().getAsInt()))));
  }

}
