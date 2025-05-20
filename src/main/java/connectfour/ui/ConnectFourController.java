package connectfour.ui;

import gameengine.grid.Marker;
import ui.util.DialogUtil;
import connectfour.engine.ConnectFourGame;
import javafx.event.ActionEvent;

import static constants.GameConstants.CF_BOARD_SIZE;

/**
 * Controller binding ConnectFourGame to the JavaFX view.
 * <p>
 * This class manages the interaction between
 * the Connect Four game logic and the JavaFX user interface.
 * It handles user actions, updates
 * the view based on game state, and manages end-of-game dialogs.
 * </p>
 *
 * @author tiniuspre
 * @version 19.05.2025
 * @since 19.05.2025
 */
public class ConnectFourController {
  /**
   * The Connect Four game logic instance.
   */
  private final ConnectFourGame game;

  /**
   * The JavaFX view for Connect Four.
   */
  private final ConnectFourView view;

  /**
   * Constructs a controller, binding the given game and view.
   * Initializes the UI event handlers.
   *
   * @param gameInst the Connect Four game instance
   * @param viewInst the Connect Four view instance
   */
  public ConnectFourController(
      final ConnectFourGame gameInst,
      final ConnectFourView viewInst
  ) {
    this.game = gameInst;
    this.view = viewInst;
    init();
  }

  /**
   * Initializes the UI by setting the initial status and wiring button actions.
   */
  private void init() {
    view.setStatus("Next: " + game.getCurrentPlayer().getName());
    for (int r = 0; r < CF_BOARD_SIZE; r++) {
      for (int c = 0; c < CF_BOARD_SIZE; c++) {
        final int col = c;
        view.getButton(r, c).setOnAction(
            (ActionEvent e) -> handleMove(col)
        );
      }
    }
  }

  /**
   * Handles a move when a column button is pressed.
   * Updates the view, checks for a winner or draw,
   * and displays dialogs as needed.
   *
   * @param col the column index where the move is attempted
   */
  private void handleMove(final int col) {
    if (!game.makeMove(0, col)) {
      return;
    }
    updateView();
    var winner = game.checkWinner();
    if (winner != null) {
      view.setStatus("Winner: " + winner.getName());
      DialogUtil.info("Winner", "Winner: " + winner.getName());
      disableAll();
    } else if (game.isDraw()) {
      view.setStatus("Draw!");
      DialogUtil.info("Draw", "Draw!");
    } else {
      view.setStatus("Next: " + game.getCurrentPlayer().getName());
    }
  }

  /**
   * Updates the UI to reflect the current state of the game board.
   * Sets button text to "X", "O", or empty based on marker.
   */
  private void updateView() {
    for (int r = 0; r < CF_BOARD_SIZE; r++) {
      for (int c = 0; c < CF_BOARD_SIZE; c++) {
        Marker m = game.getMarkerAt(r, c);
        view.getButton(r, c).setText(
            m == Marker.NONE ? "" : m == Marker.PLAYER_ONE ? "X" : "O"
        );
      }
    }
  }

  /**
   * Disables all buttons on the board, preventing further moves.
   */
  private void disableAll() {
    for (int r = 0; r < CF_BOARD_SIZE; r++) {
      for (int c = 0; c < CF_BOARD_SIZE; c++) {
        view.getButton(r, c).setDisable(true);
      }
    }
  }
}
