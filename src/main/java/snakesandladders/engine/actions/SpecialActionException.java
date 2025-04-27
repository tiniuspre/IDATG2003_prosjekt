package snakesandladders.engine.actions;

import gameengine.BaseIllegalArgumentException;

import java.util.logging.Level;

/**
 * Exception thrown when an error occurs while performing a special action
 * in the game.
 *
 * @author jonastomren
 * @version 27.04.2025
 * @since 27.04.2025
 */
public class SpecialActionException extends BaseIllegalArgumentException {
  /**
   * Logger for logging errors and information.
   */
  private static final java.util.logging.Logger LOGGER =
      java.util.logging.Logger.getLogger(
          SpecialActionException.class.getName());

  /**
   * Default constructor.
   *
   * @param message The error message.
   */
  public SpecialActionException(final String message) {
    super(message);
  }

  /**
   * Constructor for the SpecialActionException class.
   *
   * @param message The error message.
   * @param level The logging level for the error.
   */
  public SpecialActionException(final String message,
                                final Level level) {
    super(message);
    LOGGER.log(level, message);
  }
}
