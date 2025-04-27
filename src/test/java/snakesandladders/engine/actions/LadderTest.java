package snakesandladders.engine.actions;

import gameengine.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import snakesandladders.engine.SnLPlayer;

import static org.junit.jupiter.api.Assertions.*;

class LadderTest {

  private Ladder ladder;
  private Player player;

  @BeforeEach
  void setUp() {
    ladder = new Ladder(10, 2);
    player = new SnLPlayer("TestPlayer", "CAR");
  }

  @Test
  @DisplayName("Player position is updated correctly when landing on a ladder")
  void playerPositionUpdatedCorrectlyWhenLandingOnLadder() {
    player.setPosition(2);
    ladder.apply(player);
    assertEquals(10, player.getPosition());
  }

  @Test
  @DisplayName("Exception is thrown when ladder end position is invalid")
  void exceptionThrownWhenLadderEndPositionIsInvalid() {
    assertThrows(SpecialActionException.class, () -> new Ladder(5, 10));
  }

  @Test
  @DisplayName("Exception is thrown when player position does not match ladder start position")
  void exceptionThrownWhenPlayerPositionDoesNotMatchLadderStartPosition() {
    player.setPosition(3);
    assertThrows(NullPointerException.class, () -> ladder.apply(player));
  }
}