package tictactoe.ui;

import gameengine.grid.GridPlayer;
import gameengine.grid.Marker;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main JavaFX application for TicTacToe.
 */
public class TicTacToeApp extends Application {
  @Override
  public void start(Stage primaryStage) {
    GridPlayer p1 = new GridPlayer("X", Marker.PLAYER_ONE);
    GridPlayer p2 = new GridPlayer("O", Marker.PLAYER_TWO);
    tictactoe.engine.TicTacToeGame game = new tictactoe.engine.TicTacToeGame(p1, p2);
    TicTacToeView view = new TicTacToeView();
    new TicTacToeController(game, view);

    primaryStage.setTitle("Tic Tac Toe");
    primaryStage.setScene(new Scene(view));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
