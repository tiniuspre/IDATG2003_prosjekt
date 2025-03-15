package filehandler;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonhandlerTest {
  private Jsonhandler jsonHandler;
  private static final String testFilePath = "src/test/resources/json-files/test.json";

  static class TestPerson {
    public String name;
    public int age;

    public TestPerson() {
      // Constructor left intentionally empty for Jackson.
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
    Jsonhandler jsonhandler = new Jsonhandler("pretest.json");
    jsonhandler.setPath("json-files/test.json");
    assertEquals("json-files/test.json", jsonhandler.getPath());
    assertThrows(IllegalArgumentException.class, () -> jsonhandler.setPath(null));
  }


  @Test
  void writeAndReadToFile() throws IOException {
    TestPerson originalPerson = new TestPerson("Test", 20);
    ArrayList<TestPerson> testPeople = new ArrayList<>();
    testPeople.add(originalPerson);
    jsonHandler = new Jsonhandler(testFilePath);
    jsonHandler.writeToFile(testPeople);

    List<TestPerson> readPerson = jsonHandler.readFromFile(TestPerson.class);
    assertEquals(originalPerson, readPerson.getFirst());
    assertThrows(NullPointerException.class, () -> jsonHandler.readFromFile(null));
  }

}