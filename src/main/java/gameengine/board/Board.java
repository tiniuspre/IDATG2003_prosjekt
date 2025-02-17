package gameengine.board;

import java.util.Map;

/**
 * The {@code Board} class represents the game board in the game engine.
 * It contains the state and behavior of the game board.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 */

public class Board {
  /**
   * The tiles of the board.
   */
  private Map<Integer, Tile> tiles;
  /**
   * The width of the board.
   */
  private int width;
  /**
   * The height of the board.
   */
  private int height;
}
