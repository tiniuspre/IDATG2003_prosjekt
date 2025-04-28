package tictactoe.engine;

import gameengine.grid.GridGame;
import gameengine.grid.GridPlayer;
import gameengine.grid.Marker;

/**
 * Implements TicTacToe rules on a 3×3 grid.
 */
public class TicTacToeGame extends GridGame {
  private final Marker[][] state;

  public TicTacToeGame(GridPlayer p1, GridPlayer p2) {
    super(new TicTacToeBoard(), p1, p2);
    state = new Marker[board.getRows()][board.getCols()];
    for (int r = 0; r < board.getRows(); r++) {
      for (int c = 0; c < board.getCols(); c++) {
        state[r][c] = Marker.NONE;
      }
    }
  }

  @Override
  protected boolean canMove(int row, int col) {
    return row >= 0 && row < board.getRows()
        && col >= 0 && col < board.getCols()
        && state[row][col] == Marker.NONE;
  }

  @Override
  protected void applyMove(int row, int col) {
    state[row][col] = currentPlayer.getMarker();
  }

  @Override
  public gameengine.grid.GridPlayer checkWinner() {
    // rows & cols
    for (int i = 0; i < 3; i++) {
      if (rowWinner(i) != null) return rowWinner(i);
      if (colWinner(i) != null) return colWinner(i);
    }
    // diagonals
    if (state[0][0] != Marker.NONE
        && state[0][0] == state[1][1]
        && state[1][1] == state[2][2]) {
      return state[0][0] == playerOne.getMarker() ? playerOne : playerTwo;
    }
    if (state[0][2] != Marker.NONE
        && state[0][2] == state[1][1]
        && state[1][1] == state[2][0]) {
      return state[0][2] == playerOne.getMarker() ? playerOne : playerTwo;
    }
    return null;
  }

  private gameengine.grid.GridPlayer rowWinner(int r) {
    if (state[r][0] != Marker.NONE
        && state[r][0] == state[r][1]
        && state[r][1] == state[r][2]) {
      return state[r][0] == playerOne.getMarker() ? playerOne : playerTwo;
    }
    return null;
  }

  private gameengine.grid.GridPlayer colWinner(int c) {
    if (state[0][c] != Marker.NONE
        && state[0][c] == state[1][c]
        && state[1][c] == state[2][c]) {
      return state[0][c] == playerOne.getMarker() ? playerOne : playerTwo;
    }
    return null;
  }

  @Override
  public boolean isDraw() {
    if (checkWinner() != null) return false;
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        if (state[r][c] == Marker.NONE) return false;
      }
    }
    return true;
  }

  /**
   * Returns the marker at the given cell.
   */
  public Marker getMarkerAt(int row, int col) {
    if (row < 0 || row >= 3 || col < 0 || col >= 3) {
      throw new IndexOutOfBoundsException();
    }
    return state[row][col];
  }
}