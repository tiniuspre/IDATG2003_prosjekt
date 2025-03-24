package gameengine;

import org.junit.jupiter.api.Test;
import snakesandladders.engine.SnakesAndLaddersPlayer;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

  static Player testPlayer = new SnakesAndLaddersPlayer("test","hat");

  @Test
  public void testTestSetName() {
    assertThrows(IllegalArgumentException.class, () -> new SnakesAndLaddersPlayer("",""));
  }

  @Test
  public void testSetPosition() {
    testPlayer.setPosition(2);
    assertEquals(2,testPlayer.getPosition());
    assertThrows(IllegalArgumentException.class, () -> testPlayer.setPosition(-1));
  }
  @Test
  public void testMove() {
    testPlayer.move(3);
    assertEquals(3,testPlayer.getPosition());
    assertThrows(IllegalArgumentException.class,() -> testPlayer.move(-1));
  }

}