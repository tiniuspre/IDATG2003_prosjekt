package gameengine;

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
   * Constructor for the BaseIllegalArgumentException class.
   *
   * @param message The error message.
   */
  public BaseIllegalArgumentException(String message) {
    super(message);
  }

  /**
   * Default constructor.
   */
  public BaseIllegalArgumentException() {
    // Default constructor
  }
}
