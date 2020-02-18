package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class NameDeletionTest extends TestBaseName {

  @Test
  public void testNameDeletion() throws Exception {
    app.homeName();
    app.chekboxName();
    app.deleteName();
  }

}
