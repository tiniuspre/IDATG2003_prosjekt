package tictactoe.engine;

import gameengine.grid.GridGame;
import gameengine.grid.GridPlayer;
import gameengine.grid.Marker;
import static constants.GameConstants.TTT_BOARD_SIZE;

/**
 * Implements TicTacToe rules on a 3×3 grid.
 * This class manages the game state,
 * enforces the rules, and determines the winner or draw.
 *
 * @author tiniuspre
 * @version 19.05.2025
 * @since 25.03.2025
 */
public class TicTacToeGame extends GridGame {
  /**
   * The current state of the TicTacToe board.
   * Each cell contains a marker representing
   * the state of the game at that position.
   */
  private final Marker[][] state;

  /**
   * Constructs a new TicTacToe game with the specified players.
   * Initializes the game board and sets all cells to Marker.NONE.
   *
   * @param p1 The first player.
   * @param p2 The second player.
   */
  public TicTacToeGame(final GridPlayer p1, final GridPlayer p2) {
    super(new TicTacToeBoard(), p1, p2);
    state = new Marker[getBoard().getRows()][getBoard().getCols()];
    for (int r = 0; r < getBoard().getRows(); r++) {
      for (int c = 0; c < getBoard().getCols(); c++) {
        state[r][c] = Marker.NONE;
      }
    }
  }

  /**
   * Checks if a move can be made at the specified position.
   *
   * @param row The row index of the cell.
   * @param col The column index of the cell.
   * @return True if the move is valid, false otherwise.
   */
  @Override
  protected boolean canMove(final int row, final int col) {
    return row >= 0 && row < getBoard().getRows()
        && col >= 0 && col < getBoard().getCols()
        && state[row][col] == Marker.NONE;
  }

  /**
   * Applies a move at the specified position.
   * Updates the game state with the current player's marker.
   *
   * @param row The row index of the cell.
   * @param col The column index of the cell.
   */
  @Override
  protected void applyMove(final int row, final int col) {
    state[row][col] = getCurrentPlayer().getMarker();
  }

  /**
   * Checks if there is a winner in the game.
   *
   * @return The winning player, or null if there is no winner.
   */
  @Override
  public GridPlayer checkWinner() {
    // rows & cols
    for (int i = 0; i < TTT_BOARD_SIZE; i++) {
      GridPlayer rw = rowWinner(i);
      if (rw != null) {
        return rw;
      }
      GridPlayer cw = colWinner(i);
      if (cw != null) {
        return cw;
      }
    }
    // diagonals
    if (state[0][0] != Marker.NONE
        && state[0][0] == state[1][1]
        && state[1][1] == state[2][2]) {
      return state[0][0] == getPlayerOne().getMarker()
          ? getPlayerOne() : getPlayerTwo();
    }
    if (state[0][2] != Marker.NONE
        && state[0][2] == state[1][1]
        && state[1][1] == state[2][0]) {
      return state[0][2] == getPlayerOne().getMarker()
          ? getPlayerOne() : getPlayerTwo();
    }
    return null;
  }

  /**
   * Checks if a specific row has a winner.
   *
   * @param r The row index to check.
   * @return The winning player, or null if there is no winner in the row.
   */
  private GridPlayer rowWinner(final int r) {
    if (state[r][0] != Marker.NONE
        && state[r][0] == state[r][1]
        && state[r][1] == state[r][2]) {
      return state[r][0] == getPlayerOne().getMarker()
          ? getPlayerOne() : getPlayerTwo();
    }
    return null;
  }

  /**
   * Checks if a specific column has a winner.
   *
   * @param c The column index to check.
   * @return The winning player, or null if there is no winner in the column.
   */
  private GridPlayer colWinner(final int c) {
    if (state[0][c] != Marker.NONE
        && state[0][c] == state[1][c]
        && state[1][c] == state[2][c]) {
      return state[0][c] == getPlayerOne().getMarker()
          ? getPlayerOne() : getPlayerTwo();
    }
    return null;
  }

  /**
   * Checks if the game has ended in a draw.
   *
   * @return True if the game is a draw, false otherwise.
   */
  @Override
  public boolean isDraw() {
    if (checkWinner() != null) {
      return false;
    }
    for (int r = 0; r < TTT_BOARD_SIZE; r++) {
      for (int c = 0; c < TTT_BOARD_SIZE; c++) {
        if (state[r][c] == Marker.NONE) {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Returns the marker at the specified cell.
   *
   * @param row The row index of the cell.
   * @param col The column index of the cell.
   * @return The marker at the specified cell.
   * @throws IndexOutOfBoundsException If the specified cell is out of bounds.
   */
  public Marker getMarkerAt(final int row, final int col) {
    if (row < 0 || row >= TTT_BOARD_SIZE || col < 0 || col >= TTT_BOARD_SIZE) {
      throw new IndexOutOfBoundsException(
          "Cell row is out of bounds."
              + " Row: " + row + ", Col: " + col);
    }
    return state[row][col];
  }
}
