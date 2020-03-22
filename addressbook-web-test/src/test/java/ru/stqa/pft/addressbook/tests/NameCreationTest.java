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
            .setFirstname("Olga")
            .setLastname("Eremenko")
            .setHomePhone("89457653453")
            .setMobilePhone("9999")
            .setWorkPhone("8888")
            .setEmail("ert@mail.ru")
            .setGroup("test1");
    app.name().create(name);
    Names after = app.name().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before.withAdded(
            name.setId(after.stream().mapToInt((n) -> n.getId()).max().getAsInt()))));
  }

}
