package testgame.engine.tiles;

/**
 * The {@code NormalTile} class represents a normal tile
 * with no extra functions in the test snakes and ladders game.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 * @see TestGameTile
 */
public class NormalTile extends TestGameTile {
  /**
   * Constructs a new {@code LadderTile} object with the
   * specified number of the tile, position x-axis,
   * position y-axis and number of the ladder top.
   *
   * @param number of the tile on the board.
   * @param posX position on the x-axis.
   * @param posY position on the y-axis.
   */
  public NormalTile(final int number, final int posX, final int posY) {
    super(number, posX, posY);
  }
}
