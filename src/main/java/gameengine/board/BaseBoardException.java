package gameengine.board;

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
   * Constructor for the BaseIllegalArgumentException class.
   *
   * @param message The error message.
   */
  public BaseBoardException(final String message) {
    super(message);
  }

  /**
   * Default constructor.
   */
  public BaseBoardException() {
    // Default constructor
  }
}
