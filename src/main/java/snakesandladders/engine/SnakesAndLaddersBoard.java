package snakesandladders.engine;

import gameengine.board.Board;
import gameengine.board.Tile;
import snakesandladders.engine.tiles.NormalTile;

/**
 * The {@code TestGameBoard} class represents the game board in the test game,
 * extending the {@code Board} class.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 * @see Board
 */
public class SnakesAndLaddersBoard extends Board {
  /**
   * Constructor for the TestGameBoard class.
   *
   * @param width the width of the board.
   * @param height  the height of the board.
   */
  public SnakesAndLaddersBoard(final int width, final int height) {
    super(width, height);
  }

  /**
   * Creates the board in a "snakes and ladders" format with alternating rows,
   * the first row going from left to right,
   * the second row going from right to left, and so on.
   */
  @Override
  public void createBoard() {
    int num = 1;
    for (int row = 1; row < getHeight() + 1; row++) {
      if (row % 2 == 0) {
        for (int col = getWidth(); col > 0; col--) {
          getTiles().put(num, new NormalTile(num, col, row));
          num++;
        }
      } else {
        for (int col = 1; col < getWidth() + 1; col++) {
          getTiles().put(num, new NormalTile(num, col, row));
          num++;
        }
      }
    }
  }


  /**
   * Returns the tile object with the specified tile number.
   *
   * @param tileNumber the number of the tile.
   * @return the tile object with the specified tile number.
   * @throws IllegalArgumentException if the tile number does not exist,
   *        (is not on the board).
   */
  public Tile getTile(final int tileNumber) throws IllegalArgumentException {
    if (!getTiles().containsKey(tileNumber)) {
      throw new IllegalArgumentException("Tile number does not exist.");
    }
    return getTiles().get(tileNumber);
  }

  /**
   * Returns the size of the board.
   *
   * @return the size of the board.
   */
  public int getBoardSize() {
    return getWidth() * getHeight();
  }
}
