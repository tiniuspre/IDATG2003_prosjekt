package tictactoe.ui;

import gameengine.grid.GridPlayer;
import gameengine.grid.Marker;
import javafx.scene.Parent;
import ui.util.GameScreen;

/**
 * Game screen implementation for TicTacToe.
 * Initializes game logic, view, and controller.
 *
 * @author tiniuspre
 * @version 19.05.2025
 * @since 25.03.2025
 */
public class TicTacToeApp implements GameScreen {
  /**
   * The view of the TicTacToe game screen.
   */
  private final TicTacToeView view = new TicTacToeView();

  /**
   * Constructs the TicTacToe game screen,
   * setting up players, game engine, and controller.
   */
  public TicTacToeApp() {
    // Create players for the game
    GridPlayer p1 = new GridPlayer("X", Marker.PLAYER_ONE);
    GridPlayer p2 = new GridPlayer("O", Marker.PLAYER_TWO);

    // Initialize the game engine
    tictactoe.engine.TicTacToeGame game = new tictactoe.engine.TicTacToeGame(
        p1,
        p2
    );

    // Set up the controller with the view
    new TicTacToeController(game, view);
  }

  /**
   * Returns the view of the game screen.
   *
   * @return the Parent object representing the TicTacToe view.
   */
  @Override
  public Parent getView() {
    return view;
  }
}
