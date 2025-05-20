package connectfour.ui;

import javafx.scene.Parent;
import gameengine.grid.GridPlayer;
import gameengine.grid.Marker;
import ui.util.GameScreen;
import connectfour.engine.ConnectFourGame;

/**
 * Application entry point for Connect-Four.
 * <p>
 * This class initializes the Connect Four game by setting up the players,
 * game logic, and connecting the controller to the view. It implements the
 * {@link GameScreen} interface to provide the main view for the application.
 * </p>
 *
 * @author tiniuspre
 * @version 19.05.2025
 * @since 19.05.2025
 */
public class ConnectFourApp implements GameScreen {
  /**
   * The main view for the Connect Four game.
   */
  private final ConnectFourView view = new ConnectFourView();

  /**
   * Constructs the ConnectFourApp, initializing players, game logic,
   * and wiring the controller to the view.
   */
  public ConnectFourApp() {
    GridPlayer p1 = new GridPlayer("X", Marker.PLAYER_ONE);
    GridPlayer p2 = new GridPlayer("O", Marker.PLAYER_TWO);
    ConnectFourGame game = new ConnectFourGame(p1, p2);
    new ConnectFourController(game, view);
  }

  /**
   * Returns the main view for the Connect Four game.
   *
   * @return the root node of the Connect Four UI
   */
  @Override
  public Parent getView() {
    return view;
  }
}
