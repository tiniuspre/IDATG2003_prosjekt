package ui.exceptions;

/**
 * Exception thrown when there is an issue loading a CSS file.
 * Extends IllegalArgumentException to provide additional context for CSS-related errors.
 *
 * @author tiniuspre
 * @version 25.04.2025
 * @since 25.03.2025
 */
public class CssLoaderException extends IllegalArgumentException {

    /**
     * Constructs a new CssLoaderException with the specified detail message.
     *
     * @param message the detail message explaining the cause of the exception.
     */
    public CssLoaderException(String message) {
        super(message);
    }
}
