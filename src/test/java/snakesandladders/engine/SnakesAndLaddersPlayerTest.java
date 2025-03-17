package snakesandladders.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakesAndLaddersPlayerTest {

  @Test
  void setPiece() {
    SnakesAndLaddersPlayer player = new SnakesAndLaddersPlayer("Jonas", "hat");
    assertEquals(SnakesAndLaddersPiece.HAT.getValue(), player.getPiece());
    assertThrows(IllegalArgumentException.class, () -> new SnakesAndLaddersPlayer("Jonas", ""));
  }
}