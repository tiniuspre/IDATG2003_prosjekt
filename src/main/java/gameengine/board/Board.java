package gameengine.board;

import java.util.HashMap;
import java.util.Map;

/**
 * The {@code Board} class represents the game board in the game engine.
 * It contains the state and behavior of the game board.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 */

public abstract class Board {
  /**
   * The tiles of the board.
   */
  private final Map<Integer, Tile> tiles = new HashMap<>();
  /**
   * The width of the board.
   */
  private final int width;
  /**
   * The height of the board.
   */
  private final int height;
  /**
   * Constructs a new {@code Board} object
   * with the specified inputWidth and inputHeight.
   *
   * @param inputWidth the inputWidth of the board.
   * @param inputHeight the inputHeight of the board.
   */
  public Board(final int inputWidth, final int inputHeight) {
    this.width = inputWidth;
    this.height = inputHeight;
  }
  /**
   * Creates the board.
   */
  public void createBoard() {
    //Creates the board
  }
}
