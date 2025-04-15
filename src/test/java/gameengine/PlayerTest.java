package gameengine;

import gameengine.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import snakesandladders.engine.SnakesAndLaddersPlayer;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

  static Player testPlayer = new SnakesAndLaddersPlayer("test","hat");

  @Test
  @DisplayName("Test for setting player name")
  public void testTestSetName() {
    assertThrows(IllegalArgumentException.class, () -> new SnakesAndLaddersPlayer("",""));
  }

  @Test
  @DisplayName("Test for setting player position")
  public void testSetPosition() {
    testPlayer.setPosition(2);
    assertEquals(2,testPlayer.getPosition());
    assertThrows(IllegalArgumentException.class, () -> testPlayer.setPosition(-1));
  }

}