package snakesandladders.engine.actions;

import gameengine.board.TileAction;
import java.util.List;
import java.util.Random;
import snakesandladders.engine.SnakesAndLaddersPlayer;


/**
 * The {@code SwitchAction} class represents the action,
 * of a ladder in the test snakes and ladders game.
 *
 * @author jonastomren
 * @version 26.03.2025
 * @since 26.03.2025
 * @see TileAction
 */
public class SwitchAction implements TileAction<SnakesAndLaddersPlayer,
    List<SnakesAndLaddersPlayer>> {
  /**
   * Constructor for SwitchAction class.
   */
  public SwitchAction() {
  }


  /**
   * Switches the landing player with a random player.
   *
   * @param playerToSwitch the parameter.
   * @param listOfPlayers list of players.
   */
  @Override
  public void landAction(final SnakesAndLaddersPlayer playerToSwitch,
                         final List<SnakesAndLaddersPlayer> listOfPlayers) {
    Random random = new Random();
    int randomPlayer;
    do {
      randomPlayer = random.nextInt(listOfPlayers.size());
    } while (listOfPlayers.get(randomPlayer).equals(playerToSwitch));
    SnakesAndLaddersPlayer playerToSwitchWith = listOfPlayers.get(randomPlayer);
    int temp = playerToSwitch.getPosition();
    playerToSwitch.setPosition(playerToSwitchWith.getPosition());
    playerToSwitchWith.setPosition(temp);
    System.out.println(playerToSwitch.getName() + " is now at position "
        + playerToSwitch.getPosition() + " and "
        + playerToSwitchWith.getName()
        + " is now at position " + playerToSwitchWith.getPosition());
  }
}
