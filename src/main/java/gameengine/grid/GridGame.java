package gameengine.grid;

import gameengine.Engine;
import gameengine.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base for turn-based grid games.
 * Implements Subject for Observer pattern notifications.
 */
public abstract class GridGame extends Engine implements Subject {
  private final List<gameengine.Observer> observers = new ArrayList<>();
  protected final GridBoard board;
  protected final GridPlayer playerOne;
  protected final GridPlayer playerTwo;
  public GridPlayer currentPlayer;

  /**
   * Constructs a GridGame with board and two players.
   * @param board the grid board
   * @param p1 player one
   * @param p2 player two
   */
  public GridGame(GridBoard board, GridPlayer p1, GridPlayer p2) {
    this.board = board;
    this.playerOne = p1;
    this.playerTwo = p2;
    this.currentPlayer = p1;
  }

  /**
   * Attempts to make a move at the given cell.
   * @param row row index
   * @param col column index
   * @return true if move succeeds, false otherwise
   */
  public boolean makeMove(int row, int col) {
    if (canMove(row, col)) {
      applyMove(row, col);
      notifyObservers();
      switchPlayer();
      return true;
    }
    return false;
  }

  protected void switchPlayer() {
    currentPlayer = currentPlayer.equals(playerOne) ? playerTwo : playerOne;
  }

  /**
   * Checks if the game has a winner.
   * @return the winning player, or null if none.
   */
  public abstract GridPlayer checkWinner();

  /**
   * @return true if no more moves and no winner (draw)
   */
  public abstract boolean isDraw();

  protected abstract boolean canMove(int row, int col);
  protected abstract void applyMove(int row, int col);

  @Override
  public void registerObserver(gameengine.Observer observer) {
    observers.add(observer);
  }
  @Override
  public void removeObserver(gameengine.Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers() {
    observers.forEach(obs -> obs.update(currentPlayer));
  }
}
