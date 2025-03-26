package snakesandladders.engine.tiles;

import snakesandladders.engine.SnakesAndLaddersPlayer;
import snakesandladders.engine.actions.SnakeAction;

import java.util.List;

/**
 * The {@code SnakeTile} class represents a snake tile
 * in the test snakes and ladders game.
 *
 * @author jonastomren
 * @version 13.02.2025
 * @since 13.02.2025
 * @see SnakesAndLaddersTile
 */
public class SnakeTile extends SnakesAndLaddersTile {

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
    super(number, posX, posY, new SnakeAction(number, snakeTailNumber));
  }

  /**
   * Moves the player back to the tail of the snake.
   *
   * @param player the player to move back.
   */
  public void landOnSnake(final SnakesAndLaddersPlayer player, final List<SnakesAndLaddersPlayer> playerList) {
    this.getTileAction().landAction(player, playerList);
    System.out.println(player.getName()
        + " landed on a snake and moved back to position "
        + player.getPosition());
  }
}
