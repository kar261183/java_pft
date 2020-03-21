package ru.stqa.pft.addressbook.tests;

import ru.stqa.pft.addressbook.model.NameData;

public class NamePhoneTest extends TestBase {
  NameData name = app.name().all().iterator().next();
  NameData nameInfoFromEditForm = app.name().infoFromEditForm(name);
}
