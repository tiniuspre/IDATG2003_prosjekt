package testgame.engine.tiles;

import testgame.engine.actions.LadderAction;

/**
 * The {@code LadderTile} class represents a ladder tile
 * in the test snakes and ladders game.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 * @see TestGameTile
 */
public class LadderTile extends TestGameTile {
  /**
   * Constructs a new {@code LadderTile} object with the
   * specified number of the tile, position x-axis,
   * position y-axis and number of the ladder top.
   *
   * @param number of the tile on the board.
   * @param posX position on the x-axis.
   * @param posY position on the y-axis.
   * @param ladderTopNumber the number of the ladder top.
   */
  public LadderTile(final int number, final int posX,
                    final int posY, final int ladderTopNumber) {
    super(number, posX, posY);
    setAction(new LadderAction(number, ladderTopNumber));
  }
}
