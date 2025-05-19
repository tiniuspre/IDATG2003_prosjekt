package tictactoe.ui;

import gameengine.grid.GridPlayer;
import gameengine.grid.Marker;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static constants.GameConstants.TTT_TITLE;

/**
 * Main JavaFX application for TicTacToe.
 * This class initializes the game,
 * sets up the user interface, and starts the application.
 *
 * @author tiniuspre
 * @version 19.05.2025
 * @since 25.03.2025
 */
public class TicTacToeApp extends Application {

  /**
   * Starts the JavaFX application.
   * Initializes the game logic, view,
   * and controller, and sets up the primary stage.
   *
   * @param primaryStage The primary stage for this application.
   */
  @Override
  public void start(final Stage primaryStage) {
    // Create players for the game
    GridPlayer p1 = new GridPlayer("X", Marker.PLAYER_ONE);
    GridPlayer p2 = new GridPlayer("O", Marker.PLAYER_TWO);

    // Initialize the game engine
    tictactoe.engine.TicTacToeGame game = new tictactoe.engine.TicTacToeGame(
        p1,
        p2
    );

    // Set up the view and controller
    TicTacToeView view = new TicTacToeView();
    new TicTacToeController(game, view);

    // Configure the primary stage
    primaryStage.setTitle(TTT_TITLE);
    primaryStage.setScene(new Scene(view));
    primaryStage.show();
  }

  /**
   * The main entry point for the application.
   * Launches the JavaFX application.
   *
   * @param args The command-line arguments.
   */
  public static void main(final String[] args) {
    launch(args);
  }
}
