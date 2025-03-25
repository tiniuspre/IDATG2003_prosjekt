package filehandler;

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
      throw new IllegalArgumentException("Path cannot be null");
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
      throw new IllegalArgumentException("Records list is empty.");
    }

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
      List<Field> fields = CsvUtils.getAllFieldNames(records.getFirst().getClass());

      // Write CSV Header
      writer.write(String.join(",", fields.stream().map(Field::getName).toArray(String[]::new)));
      writer.newLine();

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

  // TODO: Implement read and write methods for csv files.
}