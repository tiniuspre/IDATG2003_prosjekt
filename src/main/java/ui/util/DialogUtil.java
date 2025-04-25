package ui.util;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import static constants.UiConstants.APP_NAME;
import static constants.UiConstants.PRINT_STACK_TRACE;

public final class DialogUtil {

  private DialogUtil() { }

  public static void info(String header, String content)  { show(AlertType.INFORMATION, header, content, null); }
  public static void warn(String header, String content)  { show(AlertType.WARNING, header, content, null); }
  public static void error(String header, String content) { show(AlertType.ERROR, header, content, null); }

  public static void exception(String header, Throwable t) {
    show(AlertType.ERROR, header, t.getMessage(), t);
  }

  private static void show(AlertType type, String header, String content, Throwable t) {
    Platform.runLater(() -> {
      Alert alert = new Alert(type);
      alert.setTitle(APP_NAME);
      alert.setHeaderText(header);
      alert.setContentText(content);
      alert.showAndWait();
      if (t != null && PRINT_STACK_TRACE) t.printStackTrace();
    });
  }
}
