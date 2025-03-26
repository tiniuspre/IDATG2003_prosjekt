package filehandler.csvhandling;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

class CsvUtilsTest {

  @Test
  void isValidCsvPath_validPath_returnsTrue() {
    assertTrue(CsvUtils.isValidCsvPath("valid/path/file.csv"));
  }

  @Test
  void isValidCsvPath_invalidPath_returnsFalse() {
    assertFalse(CsvUtils.isValidCsvPath("invalid/path/file.txt"));
  }

  @Test
  void isValidCsvPath_nullPath_returnsFalse() {
    assertFalse(CsvUtils.isValidCsvPath(null));
  }

  @Test
  void getAllFieldNames_classWithFields_returnsFieldList() {
    class TestClass {
      private int field1;
      private String field2;
    }
    List<Field> fields = CsvUtils.getAllFieldNames(TestClass.class);
    assertEquals(2, fields.size());
  }

  @Test
  void createNewFile_validPath_createsFile() throws IOException {
    File file = CsvUtils.createNewFile("src/test/resources/csv-files/test.csv");
    assertTrue(file.exists());
    file.delete();
  }

  @Test
  void convertValue_intType_returnsInteger() {
    assertEquals(123, CsvUtils.convertValue(int.class, "123"));
  }

  @Test
  void convertValue_doubleType_returnsDouble() {
    assertEquals(123.45, CsvUtils.convertValue(double.class, "123.45"));
  }

  @Test
  void convertValue_booleanType_returnsBoolean() {
    assertTrue((Boolean) CsvUtils.convertValue(boolean.class, "true"));
  }

  @Test
  void convertValue_stringType_returnsString() {
    assertEquals("test", CsvUtils.convertValue(String.class, "test"));
  }

  @Test
  void setField_validField_setsValue() throws NoSuchFieldException {
    class TestClass {
      private int field;
    }
    TestClass testObject = new TestClass();
    Field field = TestClass.class.getDeclaredField("field");
    CsvUtils.setField(testObject, field, "123");
    assertEquals(123, testObject.field);
  }
}