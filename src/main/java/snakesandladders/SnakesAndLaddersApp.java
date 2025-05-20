package snakesandladders;

import javafx.scene.Parent;
import snakesandladders.ui.SnLController;
import snakesandladders.ui.SnLView;
import ui.util.GameScreen;


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
    view = new SnLView(game);
    if (view.isInitialized()) {
      SnLController controller = new SnLController(view, game);
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
    }
    throw new IllegalStateException("Game creation was cancelled.");
  }
}
