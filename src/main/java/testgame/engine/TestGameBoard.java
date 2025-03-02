package testgame.engine;

import gameengine.board.Board;
import gameengine.board.Tile;
import testgame.engine.tiles.LadderTile;
import testgame.engine.tiles.NormalTile;
import testgame.engine.tiles.SnakeTile;

/**
 * The {@code TestGameBoard} class represents the game board in the test game.
 */
public class TestGameBoard extends Board {
  /**
   * Constructor for the TestGameBoard class.
   *
   * @param width the width of the board.
   * @param height  the height of the board.
   */
  public TestGameBoard(final int width, final int height) {
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
    for (int row = 1; row < height + 1; row++) {
      if (row % 2 == 0) {
        for (int col = width; col > 0; col--) {
          tiles.put(num, new NormalTile(num, col, row));
          num++;
        }
      } else {
        for (int col = 1; col < width + 1; col++) {
          tiles.put(num, new NormalTile(num, col, row));
          num++;
        }
      }
    }
  }

  public void addSnakeTiles() {
    tiles.put(14, new SnakeTile(14, 3, 3, 5));
    tiles.put(17, new SnakeTile(17, 6, 3, 2));
    tiles.put(31, new SnakeTile(31, 8, 4, 10));
  }

  public void addLadderTiles() {
    tiles.put(4, new LadderTile(4, 2, 3, 15));
    tiles.put(9, new LadderTile(9, 5, 2, 22));
    tiles.put(20, new LadderTile(20, 10, 3, 30));
  }

  public Tile getTile(int tileNumber) {
    if (!tiles.containsKey(tileNumber)) {
      throw new IllegalArgumentException("Tile number does not exist.");
    }
    return tiles.get(tileNumber);
  }
  public int getBoardSize() {
    return width * height;
  }
}
