package filehandler.csvhandling;

/**
 * Exception thrown when an error occurs in the CsvHandler class.
 *
 * @since 25.03.2025
 * @version 25.03.2025
 * @author jonastomren
 */
public class CsvHandlerException extends RuntimeException {
  /**
   * Constructor for the CsvHandlerException class.
   *
   * @param message The error message.
   */
  public CsvHandlerException(final String message) {
    super(message);
  }
}
