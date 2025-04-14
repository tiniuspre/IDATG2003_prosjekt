package snakesandladders.engine.actions;

import gameengine.player.Player;
import gameengine.player.PlayerSelector;
import snakesandladders.engine.SnakesAndLaddersBoard;

import java.util.List;
import java.util.Optional;

public class SpecialActionFactory {

  private final SnakesAndLaddersBoard board;

  private final PlayerSelector playerSelector;

  public SpecialActionFactory(SnakesAndLaddersBoard board, List<Player> players, Player currentPlayer) {
    this.board = board;
    this.playerSelector = new PlayerSelector(players, currentPlayer);
  }

  public Optional<SpecialAction> createSpecialAction(String actionType) {
    return switch (actionType) {
      case "Ladder" -> Optional.of(new Ladder());
      case "Snake" -> Optional.of(new Snake());
      case "Switch" -> Optional.of(new Switch(playerSelector));
      default -> Optional.empty();
    };
  }
}
