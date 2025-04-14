package snakesandladders.engine.actions;

import gameengine.player.Player;
import gameengine.player.PlayerSelector;

public class Switch implements SpecialAction {

  private final PlayerSelector playerSelector;

  public Switch(final PlayerSelector playerContext) {
    this.playerSelector = playerContext;
  }

  @Override
  public void apply(final Player currentPlayer) {
    Player targetPlayer = playerSelector.selectRandomPlayer();

    int currentPlayerPosition = currentPlayer.getPosition();
    int targetPlayerPosition = targetPlayer.getPosition();

    currentPlayer.setPosition(targetPlayerPosition);
    targetPlayer.setPosition(currentPlayerPosition);

    System.out.println(currentPlayer.getName() + " switched positions with " + targetPlayer.getName() + "! " +
        currentPlayer.getName() + " is now at " + targetPlayerPosition + " and " +
        targetPlayer.getName() + " is now at " + currentPlayerPosition);
  }
}
