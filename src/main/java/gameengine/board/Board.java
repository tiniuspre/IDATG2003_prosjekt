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
  private int width;
  /**
   * The height of the board.
   */
  private int height;
  /**
   * Constructs a new {@code Board} object
   * with the specified inputWidth and inputHeight.
   *
   * @param inputWidth the inputWidth of the board.
   * @param inputHeight the inputHeight of the board.
   */
  public Board(final int inputWidth, final int inputHeight) {
    setWidth(inputWidth);
    setHeight(inputHeight);
  }
  /**
   * Creates the board.
   */
  public void createBoard() {
    //Creates the board
  }
  /**
   * Sets the width of the board.
   *
   * @param inputWidth the width of the board.
   * @throws IllegalArgumentException if the width is less than 0.
   */
  public void setWidth(final int inputWidth) throws IllegalArgumentException {
    if (inputWidth < 0) {
      throw new IllegalArgumentException("Invalid board width.");
    }
    this.width = inputWidth;
  }
  /**
   * Sets the height of the board.
   *
   * @param inputHeight the height of the board.
   * @throws IllegalArgumentException if the height is less than 0.
   */
  public void setHeight(final int inputHeight) throws IllegalArgumentException {
    if (inputHeight < 0) {
      throw new IllegalArgumentException("Invalid height width");
    }
    this.height = inputHeight;
  }
  /**
   * Returns the tiles of the board.
   *
   * @return the tiles of the board.
   */
  public final Map<Integer, Tile> getTiles() {
    return tiles;
  }

  /**
   * Accessor method for the width of the board.
   *
   * @return the width of the board.
   */
  public final int getWidth() {
    return width;
  }

  /**
   * Accessor method for the height of the board.
   *
   * @return the height of the board.
   */
  public final int getHeight() {
    return height;
  }
}
