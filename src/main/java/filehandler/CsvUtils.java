package filehandler;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility class for handling CSV file operations.
 * This class should not be instantiated.
 *
 * @since 25.03.2025
 * @version 25.03.2025
 * @author jonastomren
 */
public class CsvUtils {

  private static final Logger LOGGER = Logger.getLogger(CsvUtils.class.getName());

  /**
   * Private constructor to prevent instantiation.
   * Throws IllegalStateException if called.
   */
  private CsvUtils() {
    throw new IllegalStateException("Should not be instantiated");
  }

  /**
   * Checks if a string is a valid CSV file path.
   *
   * @param path The file path to check.
   * @return True if the path is a valid CSV file path, false otherwise.
   */
  public static boolean isValidCsvPath(final String path) {
    return path != null && path.endsWith(".csv");
  }

  /**
   * Retrieves all field names of a given class, including inherited fields.
   *
   * @param clazz The class to retrieve field names from.
   * @return A list of fields from the class and its superclasses.
   */
  public static List<Field> getAllFieldNames(Class<?> clazz) {
    List<Field> fieldNames = new ArrayList<>();

    while (clazz != null) {
      fieldNames.addAll(Arrays.asList(clazz.getDeclaredFields()));
      clazz = clazz.getSuperclass();
    }
    return fieldNames;
  }

  /**
   * Creates a new file at the specified path, including any necessary parent directories.
   *
   * @param path The path where the new file should be created.
   * @return The created file.
   * @throws IOException If an I/O error occurs.
   */
  public static File createNewFile(String path) throws IOException {
    File file = new File(path);
    if (file.getParentFile().mkdirs()) {
      LOGGER.log(Level.WARNING, "Directory not found, created new directory at: " + file.getParentFile());
    }
    if (file.createNewFile()) {
      LOGGER.log(Level.WARNING, "File not found, created new file at: " + file);
    }
    return file;
  }
}