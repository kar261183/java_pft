package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class NameDeletionTest extends TestBase {

  @Test
  public void testNameDeletion() throws Exception {
    app.getNameHelpers().homeName();
    app.getNameHelpers().chekboxName();
    app.getNameHelpers().deleteName();
  }

}
