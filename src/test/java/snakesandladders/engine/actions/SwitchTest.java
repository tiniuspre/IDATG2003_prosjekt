package snakesandladders.engine.actions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import gameengine.player.PlayerSelector;
import snakesandladders.engine.SnLGameContext;
import snakesandladders.engine.SnLPlayer;

import java.util.List;

class SwitchTest {

  private Switch switchAction;
  private SnLPlayer currentPlayer;
  private SnLPlayer targetPlayer;

  @BeforeEach
  void setUp() {
    currentPlayer = new SnLPlayer("CurrentPlayer", "hat");
    targetPlayer = new SnLPlayer("TargetPlayer", "hat");
    List<SnLPlayer> players = List.of(currentPlayer, targetPlayer);
    SnLGameContext gameContext = SnLGameContext.getInstance();
    gameContext.setPlayers(players);
    gameContext.setCurrentPlayer(currentPlayer);
    switchAction = new Switch();
  }

  @Test
  @DisplayName("Positions are swapped when switch action is applied")
  void positionsAreSwappedWhenSwitchActionApplied() {
    currentPlayer.setPosition(5);
    targetPlayer.setPosition(10);

    switchAction.apply(currentPlayer);

    assertEquals(10, currentPlayer.getPosition());
    assertEquals(5, targetPlayer.getPosition());
  }

}