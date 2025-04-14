package snakesandladders.engine.actions;

import gameengine.player.Player;
import gameengine.player.PlayerSelector;
import java.util.List;
import java.util.Optional;
import snakesandladders.engine.SnakesAndLaddersBoard;
import snakesandladders.engine.SnakesAndLaddersPlayer;


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
   * The Snakes and Ladders game board.
   */
  private final SnakesAndLaddersBoard board;
  /**
   * Utility for selecting players.
   */
  private final PlayerSelector playerSelector;

  /**
   * Constructs a SpecialActionFactory with the
   * specified boardContext, playerList, and current player.
   *
   * @param boardContext The Snakes and Ladders game boardContext.
   * @param playerList The list of playerList in the game.
   * @param currentPlayer The current player in the game.
   */
  public SpecialActionFactory(final SnakesAndLaddersBoard boardContext,
                              final List<SnakesAndLaddersPlayer> playerList,
                              final Player currentPlayer) {
    this.board = boardContext;
    this.playerSelector = new PlayerSelector(playerList, currentPlayer);
  }

  /**
   * Creates a special action based on the specified action type.
   *
   * @param actionType The type of action to create
   *                  (e.g., "Ladder", "Snake", "Switch").
   * @return An Optional containing the created SpecialAction,
   *        or an empty Optional if the action type is invalid.
   */
  public Optional<SpecialAction> createSpecialAction(final String actionType) {
    return switch (actionType) {
      case "Ladder" -> Optional.of(new Ladder(board.getLadders()));
      case "Snake" -> Optional.of(new Snake(board.getSnakes()));
      case "Switch" -> Optional.of(new Switch(playerSelector));
      default -> Optional.empty();
    };
  }
}
