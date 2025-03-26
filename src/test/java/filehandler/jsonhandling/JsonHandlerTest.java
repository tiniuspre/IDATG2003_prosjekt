package filehandler.jsonhandling;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonHandlerTest {
  private JsonHandler jsonHandler;
  private static final String testFilePath = "src/test/resources/json-files/json_handler_test.json";

  static class TestPerson {
    public String name;
    public int age;

    @JsonCreator // Constructor for Jackson
    public TestPerson() {
    }

    public TestPerson(String name, int age) {
      this.name = name;
      this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (obj == null || obj.getClass() != this.getClass()) {
        return false;
      }
      TestPerson testPerson = (TestPerson) obj;
      return name.equals(testPerson.name) && age == testPerson.age;
    }
  }

  @Test
  void setPath() {
    JsonHandler jsonhandler = new JsonHandler("pretest.json");
    jsonhandler.setPath("json-files/test.json");
    assertEquals("json-files/test.json", jsonhandler.getPath());
    assertThrows(IllegalArgumentException.class, () -> jsonhandler.setPath(null));
  }


  @Test
  void writeAndReadToFile() throws IOException {
    TestPerson originalPerson = new TestPerson("Test", 20);
    ArrayList<TestPerson> testPeople = new ArrayList<>();
    testPeople.add(originalPerson);
    jsonHandler = new JsonHandler(testFilePath);
    jsonHandler.writeToFile(testPeople);

    List<TestPerson> readPerson = jsonHandler.readFromFile(TestPerson.class);
    assertEquals(originalPerson, readPerson.getFirst());
    assertThrows(NullPointerException.class, () -> jsonHandler.readFromFile(null));
  }

  @AfterAll
  static void tearDown() {
    JsonHandler jsonHandler = new JsonHandler(testFilePath);
    jsonHandler.deleteFile();
  }
}