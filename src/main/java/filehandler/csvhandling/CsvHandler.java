package filehandler.csvhandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * The {@code CsvHandler} class handles all writing,
 * and reading to and from the csv files.
 *
 * @since 15.03.2025
 * @version 25.03.2025
 * @author jonastomren
 */
public final class CsvHandler {
  /**
   * The path to the CSV file.
   */
  private String path = "";

  /**
   * Sets the path for the CSV file.
   *
   * @param inputPath the path to the CSV file
   * @throws IOException if an I/O error occurs
   * @throws IllegalArgumentException if the path is invalid
   */
  public void setPath(final String inputPath) throws IOException {
    if (!CsvUtils.isValidCsvPath(inputPath)) {
      throw new CsvHandlerException("Path cannot be null",Level.SEVERE);
    }
    File file = CsvUtils.createNewFile(inputPath);
    this.path = inputPath;
  }

  /**
   * Gets the path of the CSV file.
   *
   * @return the path of the CSV file
   */
  public String getPath() {
    return path;
  }

  /**
   * Writes a list of objects to a CSV file.
   *
   * @param <T> the type of objects in the list
   * @param records the list of objects to write
   * @throws IOException if an I/O error occurs
   * @throws IllegalArgumentException if the records list is null or empty
   */
  public <T> void writeToFile(final List<T> records) throws IOException {
    String filePath = getPath();
    if (records == null || records.isEmpty()) {
      throw new CsvHandlerException("Records list is empty.",Level.SEVERE);
    }
    // Creates BufferedWriter to write line by line.
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
      List<Field> fields = CsvUtils
          .getAllFields(records.getFirst().getClass());

      // Write CSV Data
      for (T record : records) {
        // Get values of fields.
        List<String> values = new ArrayList<>();
        for (Field field : fields) {
          // Set field accessible.
          field.setAccessible(true);
          try {
            // Add value to list.
            values.add(field.get(record).toString());
          } catch (IllegalAccessException e) {
            values.add(""); // Handle inaccessible fields gracefully
          }
        }
        // Write values to file.
        writer.write(String.join(",", values));
        writer.newLine();
      }
    }
  }

  /**
   * Reads a list of objects from a CSV file.
   *
   * @param <T> the type of objects in the list
   * @param type the class type of the objects to read
   * @return the list of objects read from the CSV file
   */
  public <T> List<T> readFromFile(final Class<T> type) {
    String filePath = getPath();
    List<T> records = new ArrayList<>();

    // Creates BufferedReader to read line by line.
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        // Declare regex.
        String[] values = line.split(",");
        // Get Constructor of generic class.
        T record = type.getDeclaredConstructor().newInstance();
        // Get fields of generic class.
        List<Field> fields = CsvUtils.getAllFields(type);
        // Set values to fields.
        for (int i = 0; i < fields.size(); i++) {
          Field field = fields.get(i);
          CsvUtils.setField(record, field, values[i]);
        }
        // Add record to list.
        records.add(record);
      }
    } catch (Exception e) {
      throw new CsvHandlerException(e.getMessage(),Level.SEVERE);
    }
    return records;
  }
}
