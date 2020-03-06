package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;

import java.util.List;

public class NameDeletionTest extends TestBase {

  @Test(enabled = false)
  public void testNameDeletion() throws Exception {
    if (!app.nameHelpers().isThereAName()) {
      app.nameHelpers().createName(new NameData("Olga", "Eremenko", "89457653453", "ert@mail.ru", "test1"));
    }
    List<NameData> before = app.nameHelpers().getNameList();
    app.nameHelpers().checkboxName(0);
    app.nameHelpers().deleteName();
    List<NameData> after = app.nameHelpers().getNameList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(0);
    Assert.assertEquals(before, after);
    }
  }

