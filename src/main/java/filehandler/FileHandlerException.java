package filehandler;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Exception thrown when an error occurs in the CsvHandler class.
 *
 * @since 25.03.2025
 * @version 25.03.2025
 * @author jonastomren
 */
public class FileHandlerException extends RuntimeException {
  /**
   * Logger for the CsvHandlerException class.
   */
  private static final Logger LOGGER = Logger
      .getLogger(FileHandlerException.class.getName());
  /**
   * Constructor for the CsvHandlerException class.
   *
   * @param message The error message.
   * @param level The level of the error message,
   *              example: {@code Level.SEVERE}.
   */
  public FileHandlerException(final String message, final Level level) {
    super(message);
    LOGGER.log(level, message);
  }

  /**
   * Constructor for the CsvHandlerException class.
   *
   * @param message The error message.
   */
  public FileHandlerException(final String message) {
    super(message);
  }
}
