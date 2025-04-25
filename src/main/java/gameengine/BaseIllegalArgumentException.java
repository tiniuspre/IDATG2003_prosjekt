package gameengine;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Exception thrown when an IllegalArgumentException
 * occurs in the game engine.
 *
 * @author jonastomren
 * @version 25.04.2025
 * @since 25.04.2025
 */
public class BaseIllegalArgumentException extends IllegalArgumentException {
  /**
   * Logger for the BaseIllegalArgumentException class.
   */
  private static final Logger LOGGER = Logger
      .getLogger(BaseIllegalArgumentException.class.getName());

  /**
   * Constructor for the BaseIllegalArgumentException class.
   *
   * @param message The error message.
   */
  public BaseIllegalArgumentException(String message) {
    super(message);
  }

  /**
   * Constructor for the BaseIllegalArgumentException class.
   *
   * @param message The error message.
   * @param level The level of the error message, ex. {@code Level.SEVERE}.
   */
  public BaseIllegalArgumentException(String message, final Level level) {
    LOGGER.log(level, message);
  }
}
