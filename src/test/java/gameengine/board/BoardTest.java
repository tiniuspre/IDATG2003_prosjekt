package gameengine.board;

import org.junit.jupiter.api.Test;
import snakesandladders.engine.SnakesAndLaddersBoard;


import static org.junit.jupiter.api.Assertions.*;
class BoardTest {

  @Test
  public void testSetWidth() {
    SnakesAndLaddersBoard testBoard = new SnakesAndLaddersBoard(2,3);
    assertThrows(IllegalArgumentException.class, () -> new SnakesAndLaddersBoard(-1,3));
    assertEquals(2, testBoard.getWidth());
  }

  @Test
  public void testSetHeight() {
    SnakesAndLaddersBoard testBoard = new SnakesAndLaddersBoard(2,3);
    assertThrows(IllegalArgumentException.class, () -> new SnakesAndLaddersBoard(3,-1));
    assertEquals(3,testBoard.getHeight());
  }
}