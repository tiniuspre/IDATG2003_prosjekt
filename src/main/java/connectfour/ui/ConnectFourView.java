package connectfour.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import static constants.GameConstants.CF_BOARD_SIZE;
import static constants.GameConstants.CF_TITLE;
import static constants.UiConstants.CF_H_V_GAP;
import static constants.UiConstants.CF_SPACING;
import static constants.UiConstants.CF_BTN_MIN_SIZE;

/**
 * JavaFX view for a 4×4 Connect-Four grid.
 * <p>
 * This class creates the visual representation
 * of the Connect Four board using a VBox layout.
 * It displays a status message and a
 * grid of buttons representing the game cells.
 * </p>
 *
 * @author tiniuspre
 * @version 19.05.2025
 * @since 19.05.2025
 */
public class ConnectFourView extends VBox {
  /**
   * The status text displayed above
   * the board (e.g., game title or current player).
   */
  private final Text status = new Text(CF_TITLE);

  /**
   * 2D array of buttons representing the Connect Four grid cells.
   */
  private final Button[][] buttons = new Button[CF_BOARD_SIZE][CF_BOARD_SIZE];

  /**
   * Constructs the ConnectFourView,
   * initializing the status text and grid of buttons.
   * Sets up layout spacing, alignment, and button sizing.
   */
  public ConnectFourView() {
    setSpacing(CF_SPACING);
    setAlignment(Pos.CENTER);
    GridPane grid = new GridPane();
    grid.setHgap(CF_H_V_GAP);
    grid.setVgap(CF_H_V_GAP);
    grid.setPadding(new Insets(CF_SPACING));
    for (int r = 0; r < CF_BOARD_SIZE; r++) {
      for (int c = 0; c < CF_BOARD_SIZE; c++) {
        Button btn = new Button();
        btn.setMinSize(CF_BTN_MIN_SIZE, CF_BTN_MIN_SIZE);
        buttons[r][c] = btn;
        grid.add(btn, c, r);
      }
    }
    getChildren().addAll(status, grid);
  }

  /**
   * Returns the button at the specified row and column in the grid.
   *
   * @param row the row index
   * @param col the column index
   * @return the Button at the given position
   */
  public Button getButton(final int row, final int col) {
    return buttons[row][col];
  }

  /**
   * Sets the status message displayed above the board.
   *
   * @param msg the message to display
   */
  public void setStatus(final String msg) {
    status.setText(msg);
  }
}
