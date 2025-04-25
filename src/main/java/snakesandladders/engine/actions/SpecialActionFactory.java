package snakesandladders.engine.actions;

import constants.Constants;
import gameengine.player.Player;
import gameengine.player.PlayerSelector;
import java.util.List;
import java.util.Optional;
import snakesandladders.engine.SnakesAndLaddersPlayer;
import snakesandladders.engine.board.tile.SnakesAndLaddersTile;


/**
 * Factory class for creating special actions in the Snakes and Ladders game.
 * This class generates specific actions
 * (e.g., Ladder, Snake, Switch) based on the action type.
 *
 * @author jonastomren
 * @version 14.04.2025
 * @since 14.04.2025
 * @see SpecialAction
 * @see Ladder
 * @see Snake
 * @see Switch
 */
public class SpecialActionFactory {

  /**
   * Utility for selecting players.
   */
  private final PlayerSelector playerSelector;

  /**
   * Constructs a SpecialActionFactory with the
   * specified boardContext, playerList, and current player.
   *
   * @param playerList The list of playerList in the game.
   * @param currentPlayer The current player in the game.
   */
  public SpecialActionFactory(final List<SnakesAndLaddersPlayer> playerList,
                              final Player currentPlayer) {
    this.playerSelector = new PlayerSelector(playerList, currentPlayer);
  }

  /**
   * Creates a special action based on the specified action type.
   *
   * @param tile The tile on which the action is to be performed.
   * @return An Optional containing the created SpecialAction,
   *        or an empty Optional if the action type is invalid.
   */
  public Optional<SpecialAction> createSpecialAction(final SnakesAndLaddersTile tile) {

    return switch (tile.getType()) {
      case (Constants.LADDER) -> Optional.of(new Ladder(tile.getNext(),tile.getPosition()));
      case (Constants.SNAKE) -> Optional.of(new Snake(tile.getNext(), tile.getPosition()));
      case (Constants.SWITCH) -> Optional.of(new Switch(playerSelector));
      default -> Optional.empty();
    };
  }
}
