package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

public class NameModificationtest extends TestBase {

  @Test
  public void testNameModification(){
  app.getNameHelpers().homeName();
    if (! app.getNameHelpers().isThereAName()){
      app.getNameHelpers().createName(new NameData("Olga", "Eremenko", "89457653453", "ert@mail.ru", "test1"));
    }
  app.getNameHelpers().editName();
  app.getNameHelpers().fillNameForm(new NameData("Olga", "Eremenko", "89457653453", "ert@mail.ru", null), false);
  app.getNameHelpers().updateName();
  }
}
