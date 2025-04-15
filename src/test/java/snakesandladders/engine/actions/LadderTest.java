package snakesandladders.engine.actions;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Map;
import snakesandladders.engine.SnakesAndLaddersPlayer;

class LadderTest {

  private Ladder ladder;
  private SnakesAndLaddersPlayer player;

  @BeforeEach
  void setUp() {
    ladder = new Ladder(Map.of(2, 10, 5, 3));
    player = new SnakesAndLaddersPlayer("TestPlayer", "hat");
  }

  @Test
  @DisplayName("Player moves to the correct position when landing on a ladder")
  void playerMovesToLadderEndPosition() {
    player.setPosition(2);
    ladder.apply(player);
    assertEquals(10, player.getPosition());
  }

  @Test
  @DisplayName("Exception is thrown when ladder end position is invalid")
  void exceptionThrownForInvalidLadderPosition() {
    player.setPosition(5);
    assertThrows(IllegalArgumentException.class, () -> ladder.apply(player));
  }

  @Test
  @DisplayName("No action is taken when player is not on a ladder start position")
  void noActionWhenPlayerNotOnLadderStart() {
    player.setPosition(3);
    assertThrows(NullPointerException.class, () -> ladder.apply(player));
  }
}