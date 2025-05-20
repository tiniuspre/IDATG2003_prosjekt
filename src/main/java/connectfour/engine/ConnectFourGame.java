package connectfour.engine;

import gameengine.grid.GridGame;
import gameengine.grid.GridPlayer;
import gameengine.grid.Marker;

import static constants.GameConstants.CONNECT_WIN_LENGTH;

/**
 * Connect-Four game on an x,x grid.
 * Players drop markers into a colum,
 * and markers fall to the lowest available row.
 * The first player to connect exactly four markers in a row (horizontally,
 * vertically, or diagonally) wins. The game is a draw if the board is full
 * with no winner.
 *
 * @author tiniuspre
 * @version 19.05.2025
 * @since 19.05.2025
 */
public class ConnectFourGame extends GridGame {
  /**
   * The game board state.
   */
  private final Marker[][] state;

  /**
   * Constructs a new ConnectFourGame with the two specified players.
   * Initializes an empty board
   * of the dimensions provided by the board instance.
   *
   * @param p1 the first player
   * @param p2 the second player
   */
  public ConnectFourGame(final GridPlayer p1, final GridPlayer p2) {
    super(new ConnectFourBoard(), p1, p2);
    int rows = getBoard().getRows();
    int cols = getBoard().getCols();
    state = new Marker[rows][cols];
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        state[r][c] = Marker.NONE;
      }
    }
  }

  /**
   * The number of markers needed to win.
   *
   * @param row the row index of the cell
   * @param col the column index of the cell
   */
  @Override
  protected boolean canMove(final int row, final int col) {
    return col >= 0
        && col < getBoard().getCols()
        && state[0][col] == Marker.NONE;
  }

  /**
   * Applies the move to the board.
   * @param rowIgnored the row index of the cell
   * @param col the column index of the cell
   */
  @Override
  protected void applyMove(final int rowIgnored, final int col) {
    Marker m = getCurrentPlayer().getMarker();
    for (int r = getBoard().getRows() - 1; r >= 0; r--) {
      if (state[r][col] == Marker.NONE) {
        state[r][col] = m;
        return;
      }
    }
  }

  /**
   * Checks if the game has a winner.
   * @return the winning player, or null if no winner
    */
  @Override
  public GridPlayer checkWinner() {
    int rows = getBoard().getRows();
    int cols = getBoard().getCols();

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        Marker m = state[r][c];
        if (m == Marker.NONE) {
          continue;
        }
        // Check right
        if (c + CONNECT_WIN_LENGTH - 1 < cols
            && hasFourInDirection(r, c, 0, 1, m)) {
          return playerForMarker(m);
        }
        // Check down
        if (r + CONNECT_WIN_LENGTH - 1 < rows
            && hasFourInDirection(r, c, 1, 0, m)) {
          return playerForMarker(m);
        }
        // Check down-right diagonal
        if (r + CONNECT_WIN_LENGTH - 1 < rows
            && c + CONNECT_WIN_LENGTH - 1 < cols
            && hasFourInDirection(r, c, 1, 1, m)) {
          return playerForMarker(m);
        }
        // Check down-left diagonal
        if (r + CONNECT_WIN_LENGTH - 1 < rows
            && c - (CONNECT_LENGTHCONNECT_WIN_LENGTH - 1) >= 0
            && hasFourInDirection(r, c, 1, -1, m)) {
          return playerForMarker(m);
        }
      }
    }

    return null;
  }

  /**
   * Checks if the game is a draw.
   * @return true if the game is a draw, false otherwise
   */
  @Override
  public boolean isDraw() {
    // If someone has already won, it's not a draw.
    if (checkWinner() != null) {
      return false;
    }
    // Otherwise, if any column can still accept a marker, it's not a draw.
    for (int c = 0; c < getBoard().getCols(); c++) {
      if (state[0][c] == Marker.NONE) {
        return false;
      }
    }
    return true;
  }

  /**
   * Returns the marker at the given cell.
   *
   * @param row the row index
   * @param col the column index
   * @return the marker at (row, col)
   * @throws IndexOutOfBoundsException if out of bounds
   */
  public Marker getMarkerAt(final int row, final int col) {
    if (row < 0 || row >= getBoard().getRows()
        || col < 0 || col >= getBoard().getCols()) {
      throw new IndexOutOfBoundsException(
          "Cell (" + row + "," + col + ") is out of bounds.");
    }
    return state[row][col];
  }

  /**
   * Checks CONNECT_LENGTH markers in a straight line.
   *
   * @param startRow  starting row index
   * @param startCol  starting column index
   * @param dRow      row increment per step
   * @param dCol      column increment per step
   * @param marker    the marker to compare
   * @return true if exactly CONNECT_WIN_LENGTH in a row all match marker
   */
  private boolean hasFourInDirection(
      final int startRow,
      final int startCol,
      final int dRow,
      final int dCol,
      final Marker marker
  ) {
    for (int i = 1; i < CONNECT_WIN_LENGTH; i++) {
      int r = startRow + i * dRow;
      int c = startCol + i * dCol;
      if (state[r][c] != marker) {
        return false;
      }
    }
    return true;
  }

  /**
   * Maps a Marker back to its owning player.
   *
   * @param m the marker
   * @return the corresponding GridPlayer
   */
  private GridPlayer playerForMarker(final Marker m) {
    return m == getPlayerOne().getMarker()
        ? getPlayerOne()
        : getPlayerTwo();
  }
}
