package snakesandladders.engine.tiles;

import snakesandladders.engine.SnakesAndLaddersPlayer;
import snakesandladders.engine.actions.SwitchAction;

import java.util.List;

/**
 * The {@code SwitchTile} class represents a switch tile
 * in the snakes and ladders game.
 * When a player lands on this tile, they switch positions with another player.
 *
 * @version 13.02.2025
 * @since 13.02.2025
 */
public class SwitchTile extends SnakesAndLaddersTile {
  /**
   * Constructs a new {@code SwitchTile} object with the
   * specified number of the tile, position x-axis, and position y-axis.
   *
   * @param number the number of the tile on the board.
   * @param posX position on the x-axis.
   * @param posY position on the y-axis.
   */
  public SwitchTile(final int number, final int posX, final int posY) {
    super(number, posX, posY, new SwitchAction());
  }

  /**
   * Executes the action when a player lands on the switch tile.
   * The player switches positions with another player.
   *
   * @param playerToSwitch the player who landed on the switch tile.
   * @param playerList the list of all players in the game.
   */
  public void landOnSwitch(final SnakesAndLaddersPlayer playerToSwitch, final List<SnakesAndLaddersPlayer> playerList) {
    System.out.println(playerToSwitch.getName() + " landed on a switch tile and switched positions with another player.");
    this.getTileAction().landAction(playerToSwitch, playerList);
  }
}