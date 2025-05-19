package snakesandladders.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import snakesandladders.SnakesAndLadders;
import snakesandladders.engine.SnLPlayer;

import java.util.List;

public class SnLController {

  /**
   * The game instance.
   */
  private final SnakesAndLadders game;
  /**
   * The board UI.
   */
  private final SnLView boardUI;
  /**
   * The index of the current player.
   */
  private int currentPlayerIndex = 0;

  public SnLController(final SnLView view, final SnakesAndLadders gameInstance) {
    boardUI = view;
    game = gameInstance;
    init();
  }

  public void init() {
    boardUI.getNextTurnBtn().setOnAction(e -> handleNextTurn());
  }

  /**
   * Handles the logic for the next turn, including moving the current player,
   * updating the UI, and checking for game completion.
   */
  private void handleNextTurn() {
    if (!game.isNotFinished()) {
      boardUI.getStatusLabel().setText("Game Over! Winner: " + game.getWinner().getName());
      return;
    }

    SnLPlayer current = getCurrentPlayer();
    int roll = game.playOneTurn(current);

    boardUI.getStatusLabel().setText(current.getName()
        + " rolled a " + roll
        + " and is now at tile " + current.getPosition());

    boardUI.updatePlayers();

    if (!game.isNotFinished()) {
      boardUI.getStatusLabel().setText("Game Over! " + current.getName() + " wins!");
      return;
    }

    nextPlayer();
    boardUI.getCurrentPlayerLabel().setText("Player: " + getCurrentPlayer().getName());
  }

  /**
   * Advances to the next player in the list.
   */
  private void nextPlayer() {
    currentPlayerIndex++;
    if (currentPlayerIndex >= game.getPlayers().size()) {
      currentPlayerIndex = 0;
    }
  }

  /**
   * Returns the current player.
   *
   * @return the current player.
   */
  private SnLPlayer getCurrentPlayer() {
    List<SnLPlayer> p = game.getPlayers();
    return p.get(currentPlayerIndex);
  }
}
