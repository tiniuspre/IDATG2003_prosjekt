package gameengine.grid;

import gameengine.Engine;
import gameengine.Subject;
import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base for turn-based grid games.
 * This class provides the core functionality for grid-based games, including
 * player management, move validation, and observer notifications.
 * Implements the Subject interface for the Observer pattern.
 *
 * @author tiniuspre
 * @version 19.05.2025
 * @since 25.03.2025
 */
public abstract class GridGame extends Engine implements Subject {

  /**
   * List of observers registered to receive game updates.
   */
  private final List<gameengine.Observer> observers = new ArrayList<>();

  /**
   * The grid board used in the game.
   */
  private final GridBoard board;

  /**
   * The first player in the game.
   */
  private final GridPlayer playerOne;

  /**
   * The second player in the game.
   */
  private final GridPlayer playerTwo;

  /**
   * The player whose turn it currently is.
   */
  private GridPlayer currentPlayer;

  /**
   * Constructs a GridGame with the specified board and players.
   *
   * @param gridBoard the grid board used in the game
   * @param p1 the first player
   * @param p2 the second player
   */
  public GridGame(
      final GridBoard gridBoard,
      final GridPlayer p1,
      final GridPlayer p2
  ) {
    this.board = gridBoard;
    this.playerOne = p1;
    this.playerTwo = p2;
    this.currentPlayer = p1;
  }

  /**
   * Attempts to make a move at the specified cell.
   * If the move is valid, it applies the move,
   * notifies observers, and switches the current player.
   *
   * @param row the row index of the cell
   * @param col the column index of the cell
   * @return true if the move is successful, false otherwise
   */
  public boolean makeMove(final int row, final int col) {
    if (canMove(row, col)) {
      applyMove(row, col);
      notifyObservers();
      switchPlayer();
      return true;
    }
    return false;
  }

  /**
   * Switches the current player to the other player.
   */
  protected void switchPlayer() {
    currentPlayer = currentPlayer.equals(playerOne) ? playerTwo : playerOne;
  }

  /**
   * Checks if the game has a winner.
   *
   * @return the winning player, or null if there is no winner
   */
  public abstract GridPlayer checkWinner();

  /**
   * Determines if the game is a draw.
   *
   * @return true if there are no more moves and no winner, false otherwise
   */
  public abstract boolean isDraw();

  /**
   * Checks if a move can be made at the specified cell.
   *
   * @param row the row index of the cell
   * @param col the column index of the cell
   * @return true if the move is valid, false otherwise
   */
  protected abstract boolean canMove(int row, int col);

  /**
   * Applies a move at the specified cell.
   *
   * @param row the row index of the cell
   * @param col the column index of the cell
   */
  protected abstract void applyMove(int row, int col);

  /**
   * Registers an observer to receive game updates.
   *
   * @param observer the observer to register
   */
  @Override
  public void registerObserver(final gameengine.Observer observer) {
    observers.add(observer);
  }

  /**
   * Removes an observer from receiving game updates.
   *
   * @param observer the observer to remove
   */
  @Override
  public void removeObserver(final gameengine.Observer observer) {
    observers.remove(observer);
  }

  /**
   * Notifies all registered observers of a game update.
   */
  @Override
  public void notifyObservers() {
    observers.forEach(obs -> obs.update(currentPlayer));
  }

  // Accessor methods

  /**
   * Gets the game board.
   *
   * @return the grid board
   */
  public GridBoard getBoard() {
    return board;
  }

  /**
   * Gets the first player.
   *
   * @return player one
   */
  public GridPlayer getPlayerOne() {
    return playerOne;
  }

  /**
   * Gets the second player.
   *
   * @return player two
   */
  public GridPlayer getPlayerTwo() {
    return playerTwo;
  }

  /**
   * Gets the current player.
   *
   * @return the player whose turn it is
   */
  public GridPlayer getCurrentPlayer() {
    return currentPlayer;
  }
}
