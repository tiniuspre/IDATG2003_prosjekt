package snakesandladders.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakesAndLaddersPlayerTest {

  static SnakesAndLaddersPlayer testPlayer = new SnakesAndLaddersPlayer("Jonas", "hat");

  @Test
  void setPiece() {
    SnakesAndLaddersPlayer player = new SnakesAndLaddersPlayer("Jonas", "hat");
    assertEquals(SnakesAndLaddersPiece.HAT.getValue(), player.getPiece());
    assertThrows(IllegalArgumentException.class, () -> new SnakesAndLaddersPlayer("Jonas", ""));
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