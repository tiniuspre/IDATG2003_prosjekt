package renderengine;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Abstract base class for any game UI.
 * Subclasses (like SnakesAndLaddersUI) should override
 * the abstract methods to provide concrete functionality.
 *
 * @author tiniuspre
 * @version 25.03.2025
 * @since 25.03.2025
 */
public abstract class AbstractGameUI extends Application {

  /**
   * Called when the JavaFX application starts.
   * This sets up the base stage and calls any required
   * initialization methods to construct the scene.
   *
   * @param primaryStage the primary stage for the application.
   */
  @Override
  public void start(final Stage primaryStage) {
    initializeUI(primaryStage);
    primaryStage.setTitle(getGameTitle());
    primaryStage.show();
  }

  /**
   * Returns the title of the game window.
   *
   * @return the title of the game window.
   */
  protected abstract String getGameTitle();

  /**
   * Sets up the UI components, layout, and scene,
   * then attaches everything to the primaryStage.
   *
   * @param primaryStage the primary stage of the application.
   */
  protected abstract void initializeUI(Stage primaryStage);
}
