package snakesandladders.engine.actions;

import gameengine.player.Player;
import gameengine.player.PlayerSelector;
import snakesandladders.engine.SnLGameContext;

/**
 * The {@code Switch} class represents a switch action in the
 * snakes and ladders game.
 *
 * @author jonastomren
 * @version 25.04.2025
 * @since 14.04.2025
 * @see SpecialAction
 */
public class Switch implements SpecialAction {
  /**
   * Constructs a {@code Switch} action with the specified player selector.
   *
   */
  public Switch() {
  }

  /**
   * Applies the switch action by swapping the positions of the current player
   * and a randomly selected target player.
   *
   * @param currentPlayer The player who initiates the switch action.
   */
  @Override
  public void apply(final Player currentPlayer) {
    SnLGameContext gameContext = SnLGameContext.getInstance();
    PlayerSelector playerSelector = new PlayerSelector(
        gameContext.getPlayers(), currentPlayer);
    // Select a random target player
    Player targetPlayer = playerSelector.selectRandomPlayer();

    // Get the positions of the current player and the target player
    int currentPlayerPosition = currentPlayer.getPosition();
    int targetPlayerPosition = targetPlayer.getPosition();

    // Swap the positions of the current player and the target player
    currentPlayer.setPosition(targetPlayerPosition);
    targetPlayer.setPosition(currentPlayerPosition);

    // Print the result of the switch action
    System.out.println(currentPlayer.getName()
        + " switched positions with " + targetPlayer.getName() + "! "
        + currentPlayer.getName() + " is now at "
        + targetPlayerPosition + " and "
        + targetPlayer.getName() + " is now at "
        + currentPlayerPosition);
  }
}
