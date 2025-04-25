package snakesandladders.engine.board;

import gameengine.board.BaseBoardException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Exception thrown when an error occurs in the
 * Snakes and Ladders board.
 *
 * @author jonastomren
 * @version 25.04.2025
 * @since 25.04.2025
 * @see BaseBoardException
 */
public class SnLBoardException extends BaseBoardException {
  /**
   * Logger for the SnLBoardException class.
   */
  private static final Logger LOGGER = Logger
      .getLogger(SnLBoardException.class.getName());

  /**
   * Constructor for the SnLBoardException class.
   *
   * @param message The error message.
   */
  public SnLBoardException(String message) {
    super(message);
  }

  /**
   * Constructor for the SnLBoardException class.
   *
   * @param message The error message.
   * @param level The level of the error message,
   */
  public SnLBoardException(String message, Level level) {
    LOGGER.log(level, message);
  }
}
