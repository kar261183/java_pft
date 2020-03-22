package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NamePhoneTest extends TestBase {

  @Test
  public void testNamePhones() {
    app.goTo().gotoHomePage();
    NameData name = app.name().all().iterator().next();
    NameData nameInfoFromEditForm = app.name().infoFromEditForm(name);

    assertThat(name.getAllPhones(), equalTo(mergePhones(nameInfoFromEditForm)));
  }

  private String mergePhones(NameData name) {
    return Arrays.asList(name.getHomePhone(), name.getMobilePhone(), name.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(NamePhoneTest::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
