package snakesandladders.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import renderengine.AbstractGameUI;
import snakesandladders.SnakesAndLadders;
import snakesandladders.engine.SnLPlayer;

import java.util.List;

/**
 * Concrete JavaFX UI for Snakes and Ladders.
 * - Tile #1 is bottom-left
 * - One player moves per "Next Turn"
 * - Shows dice roll in a label
 *
 * @author tiniuspre
 * @version 25.03.2025
 * @since 25.03.2025
 */
public class SnakesAndLaddersUI extends AbstractGameUI {
  /**
   * The game instance.
   */
  private SnakesAndLadders game;
  /**
   * The board UI.
   */
  private SnakesAndLaddersBoardUI boardUI;
  /**
   * The status label.
   */
  private Label statusLabel;
  /**
   * The current player label.
   */
  private Label currentPlayerLabel;
  /**
   * The index of the current player.
   */
  private int currentPlayerIndex = 0;

  /**
   * Returns the title of the game.
   *
   * @return the game title.
   */
  @Override
  protected String getGameTitle() {
    return "Snakes and Ladders";
  }

  /**
   * Initializes the UI components and sets up the game.
   *
   * @param primaryStage the primary stage for this application.
   */
  @Override
  protected void initializeUI(final Stage primaryStage) {
    game = new SnakesAndLadders();
    game.setBoard(); // build the board with snakes/ladders

    // Add a couple of players for testing
    game.addPlayer("Alice", "hat");
    game.addPlayer("Bob", "car");
    game.addPlayer("Charlie", "cat");

    // Draw the board
    boardUI = new SnakesAndLaddersBoardUI(game);
    boardUI.renderBoard();

    // Side panel with current player + status
    VBox sidePanel = new VBox(10);
    sidePanel.setPrefWidth(240);

    currentPlayerLabel = new Label("Player: " + getCurrentPlayer().getName());
    sidePanel.getChildren().add(currentPlayerLabel);

    statusLabel = new Label("Snakes and Ladders!");
    sidePanel.getChildren().add(statusLabel);

    Button nextTurnBtn = new Button("Next Turn");
    nextTurnBtn.setOnAction(e -> handleNextTurn());
    sidePanel.getChildren().add(nextTurnBtn);

    // Layout
    BorderPane root = new BorderPane();
    root.setCenter(boardUI.getBoardRoot());
    root.setRight(sidePanel);

    Scene scene = new Scene(root, 950, 600);
    primaryStage.setScene(scene);
  }

  /**
   * Handles the logic for the next turn, including moving the current player,
   * updating the UI, and checking for game completion.
   */
  private void handleNextTurn() {
    if (!game.isNotFinished()) {
      statusLabel.setText("Game Over! Winner: " + game.getWinner().getName());
      return;
    }

    SnLPlayer current = getCurrentPlayer();
    int roll = game.playOneTurn(current);

    statusLabel.setText(current.getName()
        + " rolled a " + roll
        + " and is now at tile " + current.getPosition());

    boardUI.updatePlayers();

    if (!game.isNotFinished()) {
      statusLabel.setText("Game Over! " + current.getName() + " wins!");
      return;
    }

    nextPlayer();
    currentPlayerLabel.setText("Player: " + getCurrentPlayer().getName());
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
