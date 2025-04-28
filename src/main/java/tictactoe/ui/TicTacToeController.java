package tictactoe.ui;

import gameengine.grid.Marker;
import ui.util.DialogUtil;


/**
 * Controller binding TicTacToeGame to the JavaFX view.
 */
public class TicTacToeController {
  private tictactoe.engine.TicTacToeGame game;
  private TicTacToeView view;

  public TicTacToeController(tictactoe.engine.TicTacToeGame game, TicTacToeView view) {
    setGame(game);
    setView(view);
    init();
  }

  private void setGame(tictactoe.engine.TicTacToeGame game) {
    this.game = game;
  }

  private void setView(TicTacToeView view) {
    this.view = view;
  }

  private void init() {
    view.setStatus("Next: " + game.currentPlayer.getName());
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        int rr = r, cc = c;
        view.getButton(r, c).setOnAction(e -> handleMove(rr, cc));
      }
    }
  }

  private void handleMove(int row, int col) {
    if (!game.makeMove(row, col)) return;
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

  private void updateView() {
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        Marker m = game.getMarkerAt(r, c);
        view.getButton(r, c).setText(m == Marker.NONE ? "" : m == Marker.PLAYER_ONE ? "X" : "O");
      }
    }
  }

  private void disableAll() {
    for (int r = 0; r < 3; r++)
      for (int c = 0; c < 3; c++)
        view.getButton(r, c).setDisable(true);
  }
}
