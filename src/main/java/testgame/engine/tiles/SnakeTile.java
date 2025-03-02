package testgame.engine.tiles;

import testgame.engine.actions.SnakeAction;

/**
 * The {@code SnakeTile} class represents a snake tile
 * in the test snakes and ladders game.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 * @see TestGameTile
 */
public class SnakeTile extends TestGameTile {
  /**
   * Constructs a new {@code LadderTile} object with the
   * specified number of the tile, position x-axis,
   * position y-axis and number of the ladder top.
   *
   * @param number of the tile on the board.
   * @param posX position on the x-axis.
   * @param posY position on the y-axis.
   * @param snakeTailNumber the number of the snake tail (bottom).
   */
  public SnakeTile(final int number, final int posX,
                   final int posY, final int snakeTailNumber) {
    super(number, posX, posY);
    setAction(new SnakeAction(number, snakeTailNumber));
  }
}
