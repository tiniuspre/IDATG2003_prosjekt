package ui.launcher;

import ui.GameId;
import ui.MainMenu;
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
 * @author tiniuspre, jonastom
 * @version 19.05.2025
 * @since 25.03.2025
 */
public final class Router {
  /**
   * The main application.
   */
  private static MainMenu mainApp;

  /**
   * A map associating game identifiers
   * with their corresponding application suppliers.
   * Each supplier is responsible for
   * providing an instance of the game application.
   */
  private static final Map<GameId, Supplier<GameScreen>> GAMES = Map.of(
      GameId.TIC_TAC_TOE, tictactoe.ui.TicTacToeApp::new,
      GameId.SETTINGS, SettingsMenu::new,
      GameId.MAIN_MENU, MainMenu::new,
      GameId.SNAKES_AND_LADDERS, snakesandladders.SnakesAndLaddersApp::new,
      GameId.CONNECT_FOUR, connectfour.ui.ConnectFourApp::new,
      GameId.PLAYER_MENU, ui.PlayerMenu::new
  );

  /**
   * Initializes the GameRouter with the main application instance.
   *
   * @param app the main application instance to be used for routing.
   */
  public static void init(final MainMenu app) {
    setMainApp(app);
  }

  /**
   * Sets the main application instance.
   *
   * @param app the main application instance to be set.
   */
  public static void setMainApp(final MainMenu app) {
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
      DialogUtil.exception("An exception occurred while launching " + id, ex);
    }
  }

  /**
   * Private constructor to prevent instantiation of this utility class.
   */
  private Router() { }
}
