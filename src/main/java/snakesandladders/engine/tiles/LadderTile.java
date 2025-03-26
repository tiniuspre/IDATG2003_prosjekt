package snakesandladders.engine.tiles;

import snakesandladders.engine.SnakesAndLaddersPlayer;
import snakesandladders.engine.actions.LadderAction;

/**
 * The {@code LadderTile} class represents a ladder tile
 * in the test snakes and ladders game.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 * @see SnakesAndLaddersTile
 */
public class LadderTile extends SnakesAndLaddersTile {
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

  /**
   * Moves the player to the top of the ladder.
   *
   * @param player the player to move up the ladder.
   */
  public void landOnLadder(final SnakesAndLaddersPlayer player) {
    this.getAction();
    System.out.println(player.getName()
        + " climbed a ladder to position " + player.getPosition());
  }
}
