package snakesandladders.engine;

import snakesandladders.engine.board.SnLBoard;
import snakesandladders.engine.board.SnLBoardException;

import java.util.List;

public class SnLGameContext {
  /**
   * The current player in the game context.
   */
  private SnLPlayer currentPlayer;
  /**
   * The list of players in the game context.
   */
  private List<SnLPlayer> players;
  /**
   * The game board for the Snakes and Ladders game.
   */
  private SnLBoard board;
  /**
   * Singleton instance of the SnLGameContext.
   */
  private static SnLGameContext instance;

  /**
   * Constructor for the SnLGameContext class.
   *
   * @return The singleton instance of the SnLGameContext.
   */
  public static SnLGameContext getInstance() {
    if (instance == null) {
      instance = new SnLGameContext();
    }
    return instance;
  }

  /**
   * Gets the current Player in the game context.
   *
   * @return The current player.
   */
  public SnLPlayer getCurrentPlayer() {
    return currentPlayer;
  }

  /**
   * Sets the current player in the game context.
   *
   * @param current The current player to set.
   */
  public void setCurrentPlayer(final SnLPlayer current) {
    if (current == null) {
      throw new IllegalArgumentException("Current player cannot be null");
    }
    this.currentPlayer = current;
  }

  /**
   * Gets the list of players in the game context.
   *
   * @return The list of players.
   */
  public List<SnLPlayer> getPlayers() {
    return players;
  }

  /**
   * Sets the list of allPlayers in the game context.
   *
   * @param allPlayers The list of allPlayers to set.
   */
  public void setPlayers(final List<SnLPlayer> allPlayers) {
    if (allPlayers == null || allPlayers.isEmpty()) {
      throw new IllegalArgumentException("Players cannot be null or empty");
    }
    this.players = allPlayers;
  }

  /**
   * Gets the game board in the game context.
   *
   * @return The game board.
   */
  public SnLBoard getBoard() {
    return board;
  }

  /**
   * Sets the game currentBoard in the game context.
   *
   * @param currentBoard The game currentBoard to set.
   */
  public void setBoard(final SnLBoard currentBoard) {
    if (currentBoard == null) {
      throw new SnLBoardException("Board cannot be null");
    }
    this.board = currentBoard;
  }

}
