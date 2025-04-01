package filehandler.csvhandling;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

/**
 * Utility class for handling CSV file operations.
 * This class should not be instantiated.
 *
 * @author jonastomren
 * @version 31.03.2025
 * @since 25.03.2025
 */
public final class CsvUtils {
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
   * If the string value should remain a string it
   * simply returns the string.
   *
   * @param type The class type to convert to.
   * @param value The string value to convert.
   * @return The converted value.
   */
  public static Object convertValue(final Class<?> type, final String value) {
    return switch (type.getSimpleName()) {
      case "int", "Integer" -> Integer.parseInt(value);
      case "double", "Double" -> Double.parseDouble(value);
      case "boolean", "Boolean" -> Boolean.parseBoolean(value);
      case "String" -> value;
      default -> throw new CsvHandlerException("Unsupported type: " + type);
    };
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
