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

  private static final Logger LOGGER = Logger
      .getLogger(BoardLoadException.class.getName());

  public BoardLoadException(String message) {
    super(message);
  }
  public BoardLoadException(String message, Level level) {
    super(message);
    LOGGER.log(level, message);
  }
}
