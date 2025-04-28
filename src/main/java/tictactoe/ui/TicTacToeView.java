package tictactoe.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * JavaFX view for a 3×3 TicTacToe grid.
 */
public class TicTacToeView extends VBox {
  private final Text status = new Text("Tic Tac Toe");
  private final Button[][] buttons = new Button[3][3];

  public TicTacToeView() {
    setSpacing(10);
    setAlignment(Pos.CENTER);
    GridPane board = new GridPane();
    board.setHgap(5);
    board.setVgap(5);
    board.setPadding(new Insets(10));
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        Button btn = new Button();
        btn.setMinSize(60, 60);
        buttons[r][c] = btn;
        board.add(btn, c, r);
      }
    }
    getChildren().addAll(status, board);
  }

  public Button getButton(int row, int col) {
    return buttons[row][col];
  }

  public void setStatus(String msg) {
    status.setText(msg);
  }
}