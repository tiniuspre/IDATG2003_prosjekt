package snakesandladders.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakesAndLaddersPlayerTest {

  static SnLPlayer testPlayer = new SnLPlayer("Jonas", "hat");

  @Test
  void setPiece() {
    assertDoesNotThrow(() -> new SnLPlayer("Jonas", "hat"));
    assertThrows(IllegalArgumentException.class, () -> new SnLPlayer("Jonas", ""));
  }

  @Test
  public void testMoveBack() {
    testPlayer.setPosition(5);
    testPlayer.moveBack(4);
    assertEquals(4,testPlayer.getPosition());
    assertThrows(IllegalArgumentException.class, () -> testPlayer.moveBack(5));
    assertThrows(IllegalArgumentException.class, () -> testPlayer.moveBack(-2));
  }

  @Test
  public void testMove() {
    testPlayer.move(3);
    assertEquals(3,testPlayer.getPosition());
    assertThrows(IllegalArgumentException.class,() -> testPlayer.move(-1));
  }
}