package filehandler.csvhandling;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Exception thrown when an error occurs in the CsvHandler class.
 *
 * @author jonastomren
 * @version 31.03.2025
 * @since 25.03.2025
 */
public class CsvHandlerException extends RuntimeException {
  /**
   * Logger for the CsvHandlerException class.
   */
  private static final Logger LOGGER = Logger
      .getLogger(CsvHandlerException.class.getName());
  /**
   * Constructor for the CsvHandlerException class.
   *
   * @param message The error message.
   * @param level The level of the error message,
   *              example: {@code Level.SEVERE}.
   */
  public CsvHandlerException(final String message, final Level level) {
    super(message);
    LOGGER.log(level, message);
  }

  /**
   * Constructor for the CsvHandlerException class.
   *
   * @param message The error message.
   */
  public CsvHandlerException(final String message) {
    super(message);
  }
}
