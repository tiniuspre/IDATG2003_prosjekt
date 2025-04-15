package snakesandladders.engine.actions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import gameengine.player.PlayerSelector;
import snakesandladders.engine.SnakesAndLaddersPlayer;

import java.util.List;

class SwitchTest {

  private Switch switchAction;
  private SnakesAndLaddersPlayer currentPlayer;
  private SnakesAndLaddersPlayer targetPlayer;

  @BeforeEach
  void setUp() {
    currentPlayer = new SnakesAndLaddersPlayer("CurrentPlayer", "hat");
    targetPlayer = new SnakesAndLaddersPlayer("TargetPlayer", "hat");
    List<SnakesAndLaddersPlayer> players = List.of(currentPlayer, targetPlayer);
    PlayerSelector playerSelector = new PlayerSelector(players, currentPlayer);
    switchAction = new Switch(playerSelector);
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