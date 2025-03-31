package snakesandladders.engine;

import gameengine.board.Board;
import gameengine.board.Tile;
import snakesandladders.engine.tiles.NormalTile;
import snakesandladders.engine.tiles.LadderTile;
import snakesandladders.engine.tiles.SnakeTile;

/**
 * The {@code TestGameBoard} class represents the game board in the test game,
 * extending the {@code Board} class.
 *
 * @author jonastomren, tiniuspre
 * @version 25.03.2025
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
  //NOTE: Remove createBoard method when hardcoded board is added.
  @Override
  public void createBoard() {
    int tileNum = 1;
    // Loop from bottom row=1 to top row=height
    for (int row = 1; row <= getHeight(); row++) {

      boolean isEvenRow = (row % 2 == 0);

      // Odd row => left to right, even row => right to left
      if (!isEvenRow) {
        for (int col = 1; col <= getWidth(); col++) {
          Tile tile = createTile(tileNum, col, row);
          getTiles().put(tileNum, tile);
          tileNum++;
        }
      } else {
        for (int col = getWidth(); col >= 1; col--) {
          Tile tile = createTile(tileNum, col, row);
          getTiles().put(tileNum, tile);
          tileNum++;
        }
      }
    }
  }

  /**
   * Helper method to create either a NormalTile, LadderTile, or SnakeTile
   * for a given tileNum, col, row. Hardcoded for demonstration.
   * @param tileNum the number of the tile.
   * @param col the column of the tile.
   * @param row the row of the tile.
   * @return the created tile.
   * NOTE: To be replaced with file handling in the future.
   */
  private Tile createTile(final int tileNum, final int col, final int row) {
    Tile tile = new NormalTile(tileNum, col, row);

    // tile 2 to tile 22
    if (tileNum == 2) {
      tile = new LadderTile(tileNum, col, row, 22);
    } else if (tileNum == 14) {     // tile 14 to tile 7
      tile = new SnakeTile(tileNum, col, row, 7);
    }
    return tile;
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
      throw new IllegalArgumentException(
          "Tile number " + tileNumber + " does not exist."
      );
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
