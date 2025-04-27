package ui.launcher;

import ui.GameId;
import ui.MainMenuApp;
import ui.SettingsMenu;
import ui.exceptions.UILoaderException;
import ui.util.DialogUtil;
import ui.util.GameScreen;

import java.util.Map;
import java.util.function.Supplier;

/**
 * Utility class responsible for routing
 * and launching games based on their identifiers.
 * Provides a centralized mechanism to
 * manage game initialization and execution.
 *
 * @author tiniuspre
 * @version 25.04.2025
 * @since 25.03.2025
 */
public final class GameRouter {
  /**
   * The main application.
   */
  private static MainMenuApp mainApp;

  /**
   * A map associating game identifiers
   * with their corresponding application suppliers.
   * Each supplier is responsible for
   * providing an instance of the game application.
   */
  private static final Map<GameId, Supplier<GameScreen>> GAMES = Map.of(
      // TODO : Add game implementations to the map
      // EXAMPLE: GameId.SNAKES_AND_LADDERS,
      // () -> new edu.ntnu.games.snakesandladders.SnakesAndLaddersApp(),
      GameId.SETTINGS,
      SettingsMenu::new
  );

  /**
   * Initializes the GameRouter with the main application instance.
   *
   * @param app the main application instance to be used for routing.
   */
  public static void init(final MainMenuApp app) {
    setMainApp(app);
  }

  /**
   * Sets the main application instance.
   *
   * @param app the main application instance to be set.
   */
  public static void setMainApp(final MainMenuApp app) {
    if (app == null) {
      throw new UILoaderException("Main application cannot be null");
    }
    mainApp = app;
  }

  /**
   * Launches the game associated with the specified game identifier.
   * If the game is not found, an error dialog is displayed.
   *
   * @param id the identifier of the game to be launched.
   */
  public static void launch(final GameId id) {
    Supplier<GameScreen> supplier = GAMES.get(id);
    if (supplier == null) {
      DialogUtil.error("Could not load game", String.valueOf(id));
      return;
    }
    try {
      GameScreen game = supplier.get();
      mainApp.switchTo(game);
    } catch (Exception ex) {
      DialogUtil.exception("An exception occurred", ex);
    }
  }

  /**
   * Private constructor to prevent instantiation of this utility class.
   */
  private GameRouter() { }
}
