package filehandler.csvhandling;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * The {@code CsvHandler} class handles all writing, and reading to and from the csv files.
 *
 * @since 15.03.2025
 * @version 25.03.2025
 * @author jonastomren
 */
public final class CsvHandler {

  private static final Logger LOGGER = Logger.getLogger(CsvHandler.class.getName());
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
      throw new CsvHandlerException("Path cannot be null");
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
  public <T> void writeToFile(List<T> records) throws IOException {
    String filePath = getPath();
    if (records == null || records.isEmpty()) {
      throw new CsvHandlerException("Records list is empty.");
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
      List<Field> fields = CsvUtils.getAllFieldNames(records.getFirst().getClass());

      // Write CSV Data
      for (T record : records) {
        List<String> values = new ArrayList<>();
        for (Field field : fields) {
          field.setAccessible(true);
          try {
            values.add(field.get(record).toString());
          } catch (IllegalAccessException e) {
            values.add(""); // Handle inaccessible fields gracefully
          }
        }
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
   * @throws IOException if an I/O error occurs
   */
  public <T> List<T> readFromFile(Class<T> type) throws IOException {
    String filePath = getPath();
    List<T> records = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] values = line.split(",");
        T record = type.getDeclaredConstructor().newInstance();
        List<Field> fields = CsvUtils.getAllFieldNames(type);
        for (int i = 0; i < fields.size(); i++) {
          Field field = fields.get(i);
          CsvUtils.setField(record, field, values[i]);
        }
        records.add(record);
      }
    } catch (Exception e) {
      LOGGER.severe("Error reading from file: " + e.getMessage());
      throw new CsvHandlerException(e.getMessage());
    }
    return records;
  }

  // TODO: Implement read and write methods for csv files.
}