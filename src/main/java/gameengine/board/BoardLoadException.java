package gameengine.board;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Exception thrown when an error occurs while loading a board.
 *
 * @author jonastomren
 * @version 27.04.2025
 * @since 27.04.2025
 */
public class BoardLoadException extends BaseBoardException {
  /**
   * Logger for logging errors and information.
   */
  private static final Logger LOGGER = Logger
      .getLogger(BoardLoadException.class.getName());

  /**
   * Default constructor.
   *
   * @param message The error message.
   */
  public BoardLoadException(final String message) {
    super(message);
  }

  /**
   * Constructor for the BoardLoadException class.
   *
   * @param message The error message.
   * @param level  The logging level for the error.
   */
  public BoardLoadException(final String message, final Level level) {
    super(message);
    LOGGER.log(level, message);
  }
}
