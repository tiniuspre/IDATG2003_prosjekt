package filehandler.csvhandling;


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
public final class CsvUtils {
  /**
   * Logger for the CsvUtils class.
   */
  private static final Logger LOGGER = Logger
      .getLogger(CsvUtils.class.getName());

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
  public static List<Field> getAllFields(final Class<?> clazz) {
    Class<?> clazzCopy = clazz;
    List<Field> fieldNames = new ArrayList<>();

    while (clazzCopy != null && clazzCopy != Object.class) {
      Arrays.stream(clazzCopy.getDeclaredFields())
          .filter(field -> !fieldNames.contains(field))
          .forEach(fieldNames::add);
      clazzCopy = clazzCopy.getSuperclass();
    }
    return fieldNames;
  }

  /**
   * Converts a string value to the specified type.
   *
   * @param type The class type to convert to.
   * @param value The string value to convert.
   * @return The converted value.
   */
  public static Object convertValue(final Class<?> type, final String value) {
    // NOTE : Maybe add switch case if possible.
    if (type == int.class || type == Integer.class) {
      return Integer.parseInt(value);
    }
    if (type == double.class || type == Double.class) {
      return Double.parseDouble(value);
    }
    if (type == boolean.class || type == Boolean.class) {
      return Boolean.parseBoolean(value);
    }

    return value; // Default: treat as String
  }

  /**
   * Sets the value of a field in a record object.
   *
   * @param <T> The type of the record object.
   * @param record The record object to set the field value in.
   * @param field The field to set the value for.
   * @param value The value to set.
   */
  public static <T> void setField(final T record,
                                  final Field field, final String value) {
    Class<?> clazz = record.getClass();
    while (clazz != null) {
      try {
        field.setAccessible(true);

        field.set(record, convertValue(field.getType(), value));
        return;
      } catch (IllegalArgumentException | IllegalAccessException e) {
        throw new CsvHandlerException(e.getMessage(), Level.SEVERE);
      } catch (NoSuchFieldError e) {
        clazz = clazz.getSuperclass();
      }
    }
  }
}
