package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NameAdressesTest extends TestBase {

  @Test
  public void testNameAdresses() {
    app.goTo().gotoHomePage();
    NameData name = app.name().all().iterator().next();
    NameData nameInfoFromEditForm = app.name().infoFromEditForm(name);

    assertThat(name.getAddress(), equalTo(nameInfoFromEditForm.getAddress()));
    assertThat(name.getAllEmail(), equalTo(mergeEmails(nameInfoFromEditForm)));
  }

  private String mergeEmails(NameData name) {
    return Arrays.asList(name.getEmail(), name.getEmail2(), name.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
            .map(NameAdressesTest::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String email) {
    return email.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

}
