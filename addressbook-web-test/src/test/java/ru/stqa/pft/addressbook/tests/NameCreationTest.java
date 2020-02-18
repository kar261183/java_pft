package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

public class NameCreationTest extends TestBaseName {


  @Test
  public void testNameCreation() throws Exception {
    app.getNameHelpers().addNewName();
    app.getNameHelpers().fillNameForm(new NameData("Olga", "Eremenko", "89457653453", "ert@mail.ru"));
    app.getNameHelpers().submitName();
  }

}
