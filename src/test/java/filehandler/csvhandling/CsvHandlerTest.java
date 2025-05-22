package filehandler.csvhandling;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class CsvHandlerTest {

  static class TestRecord {
    private int id;
    private String name;

    public TestRecord() {
      // empty constructor for CSV reading
    }

    public TestRecord(int id, String name) {
      this.id = id;
      this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      TestRecord that = (TestRecord) obj;
      return id == that.id && name.equals(that.name);
    }
  }

  @Test
  void readFromFile_validCsvFile_returnsListOfObjects() {
    CsvHandler handler = new CsvHandler("src/test/resources/csv-files/test.csv");
    handler.setPath("src/test/resources/csv-files/test.csv");

    List<TestRecord> expectedRecords = new ArrayList<>();
    expectedRecords.add(new TestRecord(1, "Alice"));
    expectedRecords.add(new TestRecord(2, "Bob"));

    handler.writeToFile(expectedRecords);
    List<TestRecord> actualRecords = handler.readFromFile(TestRecord.class);

    assertEquals(expectedRecords, actualRecords);

    new File("src/test/resources/csv-files/test.csv").delete();
  }

  @Test
  void readFromFile_emptyCsvFile_returnsEmptyList() throws IOException {
    CsvHandler handler = new CsvHandler("src/test/resources/csv-files/empty.csv");
    handler.setPath("src/test/resources/csv-files/empty.csv");

    new File("src/test/resources/csv-files/empty.csv").createNewFile();
    List<Object> records = handler.readFromFile(Object.class);

    assertTrue(records.isEmpty());

    new File("src/test/resources/csv-files/empty.csv").delete();
  }

  @Test
  void readFromFile_invalidCsvFile_throwsException() throws IOException {
    CsvHandler handler = new CsvHandler("src/test/resources/csv-files/invalid.csv");
    handler.setPath("src/test/resources/csv-files/invalid.csv");

    try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/resources/csv-files/invalid.csv"))) {
      writer.write("id,name\n1,Alice\n2"); // Missing value for "name" in the second row
    }

    assertThrows(CsvHandlerException.class, () -> handler.readFromFile(Object.class));

    new File("src/test/resources/csv-files/invalid.csv").delete();
  }

  @Test
  void readStringLineFromFile_returnsAllLines() throws IOException {
    CsvHandler handler = new CsvHandler("src/test/resources/csv-files/lines.csv");
    handler.setPath("src/test/resources/csv-files/lines.csv");
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/resources/csv-files/lines.csv"))) {
      writer.write("a,b,c\n");
      writer.write("d,e,f\n");
    }
    List<String> lines = handler.readStringLineFromFile();
    assertEquals(2, lines.size());
    assertEquals("a,b,c", lines.get(0));
    assertEquals("d,e,f", lines.get(1));
    new File("src/test/resources/csv-files/lines.csv").delete();
  }

}