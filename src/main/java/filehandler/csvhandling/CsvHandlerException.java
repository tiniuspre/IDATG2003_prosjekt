package filehandler.csvhandling;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Exception thrown when an error occurs in the CsvHandler class.
 *
 * @since 25.03.2025
 * @version 25.03.2025
 * @author jonastomren
 */
public class CsvHandlerException extends RuntimeException {

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
