package snakesandladders.engine.board;

import constants.Constants;
import gameengine.Observer;
import gameengine.player.Player;
import snakesandladders.engine.SnLGameContext;
import snakesandladders.engine.actions.SpecialActionFactory;
import snakesandladders.engine.board.tile.SnLTile;

/**
 * The {@code SnLTileChecker} class is responsible for checking the type of tile
 * the player is on and applying the corresponding action.
 *
 * @author jonastomren
 * @version 25.04.2025
 * @since 25.04.2025
 */
public class SnLTileChecker implements Observer {
  /**
   * The checking method for the tile.
   *
   * @param player the player that is on the tile.
   */
  @Override
  public void update(final Player player) {
    int playerPos = player.getPosition();
    SnLGameContext gameContext = SnLGameContext.getInstance();
    SnLTile currentTile = gameContext.getBoard().getTile(playerPos);
    // Check if the player is on a special tile and apply the action.
    checkSpecialTile(currentTile, player);
  }

  /**
   * Checks the type of tile the player is on and applies the corresponding
   * action.
   *
   * @param currentTile the current tile the player is on.
   * @param player the player that is on the tile.
   */
  public void checkSpecialTile (final SnLTile currentTile, final Player player) {
    SpecialActionFactory specialActionFactory =
        new SpecialActionFactory();
    // Checks if the player is on a special tile and applies the action.
    switch (currentTile.getType()) {
      case Constants.SNAKE, Constants.LADDER, Constants.SWITCH
          -> specialActionFactory.createSpecialAction(currentTile)
          .ifPresent(action -> action.apply(player));
      case Constants.NORMAL -> {
        // Do nothing
      }
      default -> throw new SnLBoardException("Invalid tile type.");
    }
  }
}
