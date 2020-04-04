package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.NameData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class NameDataGenerator {

  @Parameter(names = "-c", description = "Name count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    NameDataGenerator generator = new NameDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();

  }

  private void run() throws IOException {
    List<NameData> names = generateNames(count);
    if (format.equals("csv")) {
      saveAsCsv(names, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(names, new File(file));
    } else {
      System.out.println("Unrecognized format " + format);
    }
  }

  private void saveAsXml(List<NameData> names, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(NameData.class);
    String xml = xstream.toXML(names);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();

  }

  private void saveAsCsv(List<NameData> names, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (NameData name : names) {
      writer.write(String.format("%s;%s;%s;%s;%s;\n",
              name.getFirstname(),
              name.getLastname(),
              name.getEmail(),
              name.getAddress(),
              name.getMobilePhone()));
    }
    writer.close();
  }


  private List<NameData> generateNames(int count) {
    List<NameData> names = new ArrayList<NameData>();
    for (int i = 0; i < count; i++) {
      names.add(new NameData()
              .setFirstname(String.format("firstName %s", 1))
              .setLastname(String.format("lastName %s", 1))
              .setEmail(String.format("email %s", 1))
              .setAddress(String.format("address %s", 1))
              .setMobilePhone(String.format("mobilePhone %s", 1)));
    }
    return names;
  }
}
