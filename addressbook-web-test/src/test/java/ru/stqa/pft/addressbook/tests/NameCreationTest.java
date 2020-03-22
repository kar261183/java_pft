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
            .setEmail("ert@mail.ru")
            .setEmail2("fgtr@gmail.ru")
            .setEmail3("lflfrpr@mail.ru")
            .setGroup("test1")
            .setAddress("Ostrovskogo")
            .setHomePhone("44444444")
            .setMobilePhone("55555555")
            .setWorkPhone("949494949");

    app.name().create(name);
    Names after = app.name().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before.withAdded(
            name.setId(after.stream().mapToInt((n) -> n.getId()).max().getAsInt()))));
  }

}
