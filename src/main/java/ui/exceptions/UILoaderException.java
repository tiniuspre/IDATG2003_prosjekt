package ui.exceptions;

/**
 * Exception thrown when there is an issue loading the UI.
 * Extends IllegalArgumentException to
 * provide additional context for UI-related errors.
 *
 * @author jonastomren
 * @version 27.04.2025
 * @since 27.04.2025
 */
public class UILoaderException extends IllegalArgumentException {

  /**
   * Constructs a new UILoaderException with the specified detail message.
   *
   * @param message the detail message explaining the cause of the exception.
   */
  public UILoaderException(final String message) {
    super(message);
  }
}
