package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.NameData;

public class NameDeletionTest extends TestBase {

  @Test
  public void testNameDeletion() throws Exception {
    app.getNameHelpers().homeName();
    if (! app.getNameHelpers().isThereAName()){
      app.getNameHelpers().createName(new NameData("Olga", "Eremenko", "89457653453", "ert@mail.ru", "test1"));
    }
    app.getNameHelpers().chekboxName();
    app.getNameHelpers().deleteName();
  }

}
