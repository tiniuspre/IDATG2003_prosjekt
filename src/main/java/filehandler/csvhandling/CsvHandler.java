package filehandler.csvhandling;

import filehandler.AbstractFileHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
 * @author jonastomren, tiniuspre
 * @version 21.05.2025
 * @since 15.03.2025
 */
public final class CsvHandler extends AbstractFileHandler {
  /**
   * Constructor for the CsvHandler class.
   *
   * @param inputPath the path of the csv file.
   */
  public CsvHandler(final String inputPath) {
    super(inputPath);
  }

  /**
   * Writes a list of objects to a CSV file.
   *
   * @param <T> the type of objects in the list
   * @param records the list of objects to write
   * @throws CsvHandlerException if an I/O error occurs.
   * @throws IllegalArgumentException if the records list is null or empty
   */
  public <T> void writeToFile(final List<T> records) {
    String filePath = getPath();
    if (records == null || records.isEmpty()) {
      throw new CsvHandlerException("Records list is empty.", Level.SEVERE);
    }
    // Creates BufferedWriter to write line by line.
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
      // Get fields of class.
      List<Field> fields = CsvUtils
          .getFilteredFields(records.getFirst().getClass());
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
    } catch (IOException e) {
      throw new CsvHandlerException("I/O error: "
          + e.getMessage(), Level.SEVERE);
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
    List<Field> fields = CsvUtils.getFilteredFields(type);

    // Creates BufferedReader to read line by line.
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        // Declare regex.
        String[] values = line.split(",");
        // Check if line has correct number of values.
        if (values.length != fields.size()) {
          throw new CsvHandlerException("Invalid CSV format.", Level.SEVERE);
        }
        // Get Constructor of generic class.
        T record = type.getDeclaredConstructor().newInstance();
        // Get fields of generic class.

        for (int i = 0; i < fields.size(); i++) {
          Field field = fields.get(i);
          CsvUtils.setField(record, field, values[i]);
        }
        // Add record to list.
        records.add(record);
      }
    } catch (Exception e) {
      throw new CsvHandlerException(e.getMessage(), Level.SEVERE);
    }
    return records;
  }

  /**
   * Adds a list of strings to a CSV file.
   * @param values the list of strings to add
   */
  public void addStringToFile(final List<String> values) {
    String filePath = getPath();
    try (BufferedWriter writer = new BufferedWriter(
        new FileWriter(filePath, true))) {
      writer.write(String.join(",", values));
      writer.newLine();
    } catch (IOException e) {
      throw new CsvHandlerException("I/O error: "
          + e.getMessage(), Level.SEVERE);
    }
  }
}
