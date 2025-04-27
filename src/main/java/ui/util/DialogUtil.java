package ui.util;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import static constants.UiConstants.APP_NAME;

/**
 * Utility class for displaying dialog boxes
 * in a JavaFX application.
 * Provides methods for showing informational,
 * warning, error, and exception dialogs.
 *
 * This class is final and cannot be instantiated.
 * All methods are static and designed for utility purposes.
 *
 * @author tiniuspre
 * @version 25.04.2025
 * @since 25.03.2025
 */
public final class DialogUtil {

  /**
   * Private constructor to prevent instantiation of this utility class.
   */
  private DialogUtil() { }

  /**
   * Displays an informational dialog with
   * the specified header and content.
   *
   * @param header the header text of the dialog.
   * @param content the content text of the dialog.
   */
  public static void info(
      final String header, final String content
  ) {
    show(AlertType.INFORMATION, header, content, null);
  }

  /**
   * Displays a warning dialog with the specified header and content.
   *
   * @param header the header text of the dialog.
   * @param content the content text of the dialog.
   */
  public static void warn(final String header, final String content)  {
    show(AlertType.WARNING, header, content, null);
  }

  /**
   * Displays an error dialog with the specified header and content.
   *
   * @param header the header text of the dialog.
   * @param content the content text of the dialog.
   */
  public static void error(final String header, final String content) {
    show(AlertType.ERROR, header, content, null);
  }

  /**
   * Displays an error dialog for an exception
   * with the specified header and exception details.
   * Optionally prints the stack trace if the
   * PRINT_STACK_TRACE constant is true.
   *
   * @param header the header text of the dialog.
   * @param t the exception to display in the dialog.
   */
  public static void exception(final String header, final Throwable t) {
    show(AlertType.ERROR, header, t.getMessage(), t);
  }

  /**
   * Displays a dialog of the specified
   * type with the given header, content, and optional exception.
   * Runs the dialog display on the JavaFX application thread.
   *
   * @param type the type of the dialog
   *             (e.g., INFORMATION, WARNING, ERROR).
   * @param header the header text of the dialog.
   * @param content the content text of the dialog.
   * @param t the exception to display in the dialog
   *          (optional, can be null).
   */
  private static void show(
      final AlertType type,
      final String header,
      final String content,
      final Throwable t
  ) {
    Platform.runLater(() -> {
      Alert alert = new Alert(type);
      alert.setTitle(APP_NAME);
      alert.setHeaderText(header);
      alert.setContentText(content);
      alert.showAndWait();
      if (t != null) {
        t.printStackTrace();
      }
    });
  }
}
