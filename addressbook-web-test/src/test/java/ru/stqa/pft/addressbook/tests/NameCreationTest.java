package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.NameData;
import ru.stqa.pft.addressbook.model.Names;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class NameCreationTest extends TestBase {

  @DataProvider
  public Iterator<Object[]> validNames() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/names.xml")));
    String  xml ="";
    String line = reader.readLine();
    while (line !=null){
      xml +=line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(NameData.class);
    List<NameData> names = (List<NameData>) xstream.fromXML(xml);
    return names.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validNames")
  public void testNameCreation(NameData name) throws Exception {
    Names before = app.name().all();
    app.name().create(name);
    Names after = app.name().all();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(before.withAdded(
            name.setId(after.stream().mapToInt((n) -> n.getId()).max().getAsInt()))));
  }


}
