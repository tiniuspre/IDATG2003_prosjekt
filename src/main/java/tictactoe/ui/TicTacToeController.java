package tictactoe.ui;

import gameengine.grid.Marker;
import ui.util.DialogUtil;

import static constants.GameConstants.TTT_BOARD_SIZE;

/**
 * Controller binding TicTacToeGame to the JavaFX view.
 * This class handles the interaction between the game
 * logic and the user interface,
 * including updating the view, processing user moves,
 * and managing game state transitions.
 */
public class TicTacToeController {
  /**
   * The TicTacToe game instance.
   */
  private tictactoe.engine.TicTacToeGame game;
  /**
   * The JavaFX view for the game.
   */
  private TicTacToeView view;

  /**
   * Constructs a TicTacToeController with the specified game and view.
   * Initializes the controller and binds the game logic to the view.
   *
   * @param gameInst The TicTacToe game instance.
   * @param viewInst The JavaFX view for the game.
   */
  public TicTacToeController(
      final tictactoe.engine.TicTacToeGame gameInst,
      final TicTacToeView viewInst
  ) {
    setGame(gameInst);
    setView(viewInst);
    init();
  }

  /**
   * Sets the game instance for the controller.
   *
   * @param gameInst The TicTacToe game instance.
   */
  private void setGame(final tictactoe.engine.TicTacToeGame gameInst) {
    this.game = gameInst;
  }

  /**
   * Sets the view instance for the controller.
   *
   * @param viewInst The JavaFX view for the game.
   */
  private void setView(final TicTacToeView viewInst) {
    this.view = viewInst;
  }

  /**
   * Initializes the controller by setting up the view and
   * binding actions to the game logic.
   * Configures the status message and button actions for
   * the game grid.
   */
  private void init() {
    view.setStatus("Next: " + game.currentPlayer.getName());
    for (int r = 0; r < TTT_BOARD_SIZE; r++) {
      for (int c = 0; c < TTT_BOARD_SIZE; c++) {
        int rr = r;
        int cc = c;
        view.getButton(r, c).setOnAction(e -> handleMove(rr, cc));
      }
    }
  }

  /**
   * Handles a move made by the user at the specified position.
   * Updates the game state, checks for a winner or draw,
   * and updates the view accordingly.
   *
   * @param row The row index of the move.
   * @param col The column index of the move.
   */
  private void handleMove(final int row, final int col) {
    if (!game.makeMove(row, col)) {
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
      view.setStatus("Next: " + game.currentPlayer.getName());
    }
  }

  /**
   * Updates the view to reflect the current state of the game board.
   * Sets the text of each button to the corresponding marker (X, O, or empty).
   */
  private void updateView() {
    for (int r = 0; r < TTT_BOARD_SIZE; r++) {
      for (int c = 0; c < TTT_BOARD_SIZE; c++) {
        Marker m = game.getMarkerAt(r, c);
        view.getButton(r, c).setText(
            m == Marker.NONE ? "" : m == Marker.PLAYER_ONE ? "X" : "O"
        );
      }
    }
  }

  /**
   * Disables all buttons on the game grid, preventing further moves.
   * Typically called when the game ends.
   */
  private void disableAll() {
    for (int r = 0; r < TTT_BOARD_SIZE; r++) {
      for (int c = 0; c < TTT_BOARD_SIZE; c++) {
        view.getButton(r, c).setDisable(true);
      }
    }
  }
}
