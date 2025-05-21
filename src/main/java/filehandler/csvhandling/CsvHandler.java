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
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
      List<Field> fields = CsvUtils
          .getFilteredFields(records.getFirst().getClass());
      for (T record : records) {
        List<String> values = new ArrayList<>();
        for (Field field : fields) {
          field.setAccessible(true);
          try {
            values.add(field.get(record).toString());
          } catch (IllegalAccessException e) {
            values.add("");
          }
        }
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
  @Override
  public <T> List<T> readFromFile(final Class<T> type) {
    String filePath = getPath();
    List<T> records = new ArrayList<>();
    List<Field> fields = CsvUtils.getFilteredFields(type);
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] values = line.split(",");
        if (values.length != fields.size()) {
          throw new CsvHandlerException("Invalid CSV format.", Level.SEVERE);
        }
        T recordHolder = type.getDeclaredConstructor().newInstance();

        for (int i = 0; i < fields.size(); i++) {
          Field field = fields.get(i);
          CsvUtils.setField(recordHolder, field, values[i]);
        }
        records.add(recordHolder);
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

  /**
   * Reads a list of strings from a CSV file.
   *
   * @return the list of strings read from the CSV file
   */
  public List<String> readStringLineFromFile() {
    String filePath = getPath();
    List<String> records = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        records.add(line);
      }
    } catch (IOException e) {
      throw new CsvHandlerException("I/O error: "
          + e.getMessage(), Level.SEVERE);
    }
    return records;
  }
}
