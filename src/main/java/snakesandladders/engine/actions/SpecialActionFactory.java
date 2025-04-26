package snakesandladders.engine.actions;

import constants.Constants;
import java.util.Optional;
import snakesandladders.engine.board.tile.SnLTile;


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
   * Constructs a SpecialActionFactory with the
   * specified boardContext, playerList, and current player.
   *
   */
  public SpecialActionFactory() {
  }

  /**
   * Creates a special action based on the specified action type.
   *
   * @param tile The tile on which the action is to be performed.
   * @return An Optional containing the created SpecialAction,
   *        or an empty Optional if the action type is invalid.
   */
  public Optional<SpecialAction> createSpecialAction(
      final SnLTile tile) {

    return switch (tile.getType()) {
      case (Constants.LADDER) -> Optional.of(
          new Ladder(tile.getNext(), tile.getPosition()));
      case (Constants.SNAKE) -> Optional.of(
          new Snake(tile.getNext(), tile.getPosition()));
      case (Constants.SWITCH) -> Optional.of(
          new Switch());
      default -> Optional.empty();
    };
  }
}
