package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

public class NameModificationtest extends TestBase {

  @Test
  public void testNameModification(){
  app.getNameHelpers().homeName();
  app.getNameHelpers().chekboxName();
  app.getNameHelpers().editName();
  app.getNameHelpers().fillNameForm(new NameData("Olga", "Eremenko", "89457653453", "ert@mail.ru"));
  app.getNameHelpers().updateName();
  }
}
