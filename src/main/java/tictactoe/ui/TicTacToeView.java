package tictactoe.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import static constants.GameConstants.TTT_BOARD_SIZE;
import static constants.GameConstants.TTT_TITLE;
import static constants.UiConstants.TTT_BTN_MIN_SIZE;
import static constants.UiConstants.TTT_H_V_GAP;
import static constants.UiConstants.TTT_SPACING;

/**
 * JavaFX view for a 3×3 TicTacToe grid.
 * This class represents the graphical user interface for the TicTacToe game,
 * including the game board and status display.
 *
 * @author tiniuspre
 * @version 19.05.2025
 * @since 25.03.2025
 */
public class TicTacToeView extends VBox {
  /**
   * The status text displayed above the game board.
   * Used to show messages such as the current player's turn or the game result.
   */
  private final Text status = new Text(TTT_TITLE);

  /**
   * A 2D array of buttons representing the TicTacToe grid.
   * Each button corresponds to a cell on the game board.
   */
  private final Button[][] buttons = new Button[TTT_BOARD_SIZE][TTT_BOARD_SIZE];

  /**
   * Constructs a new TicTacToeView.
   * Initializes the layout, creates the game board, and configures the buttons.
   */
  public TicTacToeView() {
    setSpacing(TTT_SPACING);
    setAlignment(Pos.CENTER);
    GridPane board = new GridPane();
    board.setHgap(TTT_H_V_GAP);
    board.setVgap(TTT_H_V_GAP);
    board.setPadding(new Insets(TTT_SPACING));
    for (int r = 0; r < TTT_BOARD_SIZE; r++) {
      for (int c = 0; c < TTT_BOARD_SIZE; c++) {
        Button btn = new Button();
        btn.setMinSize(TTT_BTN_MIN_SIZE, TTT_BTN_MIN_SIZE);
        buttons[r][c] = btn;
        board.add(btn, c, r);
      }
    }
    getChildren().addAll(status, board);
  }

  /**
   * Retrieves the button at the specified row and column.
   *
   * @param row The row index of the button.
   * @param col The column index of the button.
   * @return The button at the specified position.
   */
  public Button getButton(final int row, final int col) {
    return buttons[row][col];
  }

  /**
   * Updates the status text displayed above the game board.
   *
   * @param msg The message to display as the status.
   */
  public void setStatus(final String msg) {
    status.setText(msg);
  }
}
