package snakesandladders;

import filehandler.csvhandling.CsvHandler;
import javafx.scene.Parent;
import snakesandladders.engine.SnLPlayer;
import snakesandladders.ui.SnLController;
import snakesandladders.ui.SnLView;
import ui.util.GameScreen;
import java.util.List;


/**
 * The {@code SnakesAndLaddersApp} class is the temporary main class
 * for the test snaked and ladders game.
 *
 * @author jonastomren
 * @since 13.02.2025
 * @version 20.05.2025
 * @see SnakesAndLadders
 */
public final class SnakesAndLaddersApp implements GameScreen {
  /**
   * The view for the Snakes and Ladders game.
   */
  private final SnLView view;

  /**
   * The game instance for the Snakes and Ladders game.
   */
  private final SnakesAndLadders game = new SnakesAndLadders();


  /**
   * Constructs a SnakesAndLaddersApp instance.
   *
   */
  public SnakesAndLaddersApp() {
    game.setBoard();
    addPlayers();
    view = new SnLView(game);
    if (view.isInitialized()) {
      SnLController controller = new SnLController(view, game);
    }
  }

  /**
   * Adds selected players to the game from a CSV file.
   */
  private void addPlayers() {
    CsvHandler csvHandler = new CsvHandler("player/selected_players.csv");
    List<SnLPlayer> players = csvHandler.readFromFile(SnLPlayer.class);
    for (SnLPlayer player : players) {
      game.addPlayer(player);
    }
  }

  /**
   * Returns the view for the Snakes and Ladders game.
   *
   * @return the view for the Snakes and Ladders game
   */
  @Override
  public Parent getView() {
    if (view.isInitialized()) {
      return view;
    } else {
      throw new IllegalStateException("View is not initialized, returning to main menu.");
    }
  }
}
