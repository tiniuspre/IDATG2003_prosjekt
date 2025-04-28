package ui;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The UIApplication class serves as the entry point
 * and the main application class for the JavaFX application.
 *
 * <p>The only purpose of the class is to initialize the main
 * menu and hold the start method of the application.</p>
 *
 * @author jonastomren
 * @version 28.04.2025
 * @since 28.04.2025
 */
public class UIApplication extends Application {
  /**
   * The start method is the main entry point for JavaFX applications.
   *
   * @param stage the primary stage for this application.
   */
  @Override
  public void start(final Stage stage) {
    MainMenu mainMenuApp = new MainMenu();
    mainMenuApp.startMain(stage);
  }

  /**
   * The main method is the entry point of the application.
   *
   * @param args the command-line arguments.
   */
  public static void main(final String[] args) {
    launch(args);
  }
}
