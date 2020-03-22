package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NamePhoneTest extends TestBase {

  @Test
  public void testNamePhones() {
    app.goTo().gotoHomePage();
    NameData name = app.name().all().iterator().next();
    NameData nameInfoFromEditForm = app.name().infoFromEditForm(name);

    assertThat(name.getHomePhone(), equalTo(cleaned(nameInfoFromEditForm.getHomePhone())));
    assertThat(name.getMobilePhone(), equalTo(cleaned(nameInfoFromEditForm.getMobilePhone())));
    assertThat(name.getWorkPhone(), equalTo(cleaned(nameInfoFromEditForm.getWorkPhone())));
  }
  public String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
