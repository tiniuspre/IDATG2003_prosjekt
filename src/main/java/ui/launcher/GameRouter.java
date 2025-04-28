package ui.launcher;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.GameId;
import ui.util.DialogUtil;

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
   * A map associating game identifiers
   * with their corresponding application suppliers.
   * Each supplier is responsible for
   * providing an instance of the game application.
   */
  private static final Map<GameId, Supplier<Application>> GAMES = Map.of(
      GameId.TIC_TAC_TOE, tictactoe.ui.TicTacToeApp::new
  );

  /**
   * Launches the game associated with the specified game identifier.
   * If the game is not found, an error dialog is displayed.
   *
   * @param id the identifier of the game to be launched.
   */
  public static void launch(final GameId id) {
    Supplier<Application> supplier = GAMES.get(id);
    if (supplier == null) {
      DialogUtil.error("Could not load game", String.valueOf(id));
      return;
    }
    Stage stage = new Stage();
    try {
      supplier.get().start(stage);
    } catch (Exception ex) {
      DialogUtil.exception("An exception occurred while launching " + id, ex);
    }
  }

  /**
   * Private constructor to prevent instantiation of this utility class.
   */
  private GameRouter() { }
}
