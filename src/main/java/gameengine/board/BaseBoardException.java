package gameengine.board;


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
public class BaseBoardException extends IllegalArgumentException {
  /**
   * Logger for the BaseIllegalArgumentException class.
   */
  private static final Logger LOGGER = Logger
      .getLogger(BaseBoardException.class.getName());

  /**
   * Constructor for the BaseIllegalArgumentException class.
   *
   * @param message The error message.
   */
  public BaseBoardException(String message) {
    super(message);
  }

  /**
   * Constructor for the BaseIllegalArgumentException class.
   *
   * @param message The error message.
   * @param level The level of the error message, ex. {@code Level.SEVERE}.
   */
  public BaseBoardException(String message, final Level level) {
    LOGGER.log(level, message);
  }
}
