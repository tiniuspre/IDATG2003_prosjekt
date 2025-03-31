package filehandler.csvhandling;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class CsvHandlerTest {

  @Test
  void setPath_validPath_setsPath() throws IOException {
    CsvHandler handler = new CsvHandler("src/test/resources/csv-files/test.csv");
    handler.setPath("src/test/resources/csv-files/test.csv");
    assertEquals("src/test/resources/csv-files/test.csv", handler.getPath());
  }


  @Test
  void writeToFile_validRecords_writesToFile() throws IOException {
    CsvHandler handler = new CsvHandler("src/test/resources/csv-files/test.csv");
    handler.setPath("src/test/resources/csv-files/test.csv");

    class TestRecord {
      private int id;
      private String name;

      TestRecord(int id, String name) {
        this.id = id;
        this.name = name;
      }

      TestRecord() {}
    }

    List<TestRecord> records = new ArrayList<>();
    records.add(new TestRecord(1, "Alice"));
    records.add(new TestRecord(2, "Bob"));

    handler.writeToFile(records);

    File file = new File("src/test/resources/csv-files/test.csv");
    assertTrue(file.exists());
    file.delete();
  }

  @Test
  void writeToFile_emptyRecords_throwsException() throws IOException {
    CsvHandler handler = new CsvHandler("src/test/resources/csv-files/test.csv");
    handler.setPath("src/test/resources/csv-files/test.csv");
    List<Object> records = new ArrayList<>();
    assertThrows(CsvHandlerException.class, () -> handler.writeToFile(records));
  }

}