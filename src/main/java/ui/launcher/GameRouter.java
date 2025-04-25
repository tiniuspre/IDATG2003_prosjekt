package ui.launcher;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.GameId;
import ui.util.DialogUtil;

import java.util.Map;
import java.util.function.Supplier;

public final class GameRouter {
  // TODO : Add game implementations to the map
  // EXAMPLE: GameId.SNAKES_AND_LADDERS, () -> new edu.ntnu.games.snakesandladders.SnakesAndLaddersApp(),
  private static final Map<GameId, Supplier<Application>> GAMES = Map.of(
  );

  public static void launch(GameId id) {
    Supplier<Application> supplier = GAMES.get(id);
    if (supplier == null) {
      DialogUtil.error("Could not load game", String.valueOf(id));
      return;
    }
    Stage stage = new Stage();
    try {
      supplier.get().start(stage);
    } catch (Exception ex) {
      DialogUtil.exception("An exception occurred", ex);
    }
  }

  private GameRouter() { /* utility class */ }
}
