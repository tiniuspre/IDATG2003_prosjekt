package filehandler.jsonhandling;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Exception thrown when an error occurs in the JSONHandler class.
 *
 * @author jonastomren
 * @version 31.03.2025
 * @since 24.03.2025
 */
public class JsonHandlerException extends RuntimeException {
  /**
   * Logger for JsonHandlerException class.
   */
  public static final Logger LOGGER = Logger
      .getLogger(JsonHandlerException.class.getName());
  /**
   * Constructor for the JsonHandlerException class.
   *
   * @param message The error message.
   */
  public JsonHandlerException(final String message) {
    super(message);
  }

  /**
   * Constructor for the JsonHandlerException class.
   *
   * @param message The error message.
   * @param level The level of the error message.
   */
  public JsonHandlerException(final String message, final Level level) {
    super(message);
    LOGGER.log(level, message);
  }
}
