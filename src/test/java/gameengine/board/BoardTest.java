package gameengine.board;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import snakesandladders.engine.board.SnakesAndLaddersBoard;


import static org.junit.jupiter.api.Assertions.*;
class BoardTest {

  @Test
  @DisplayName("Test for setting width")
  public void testSetWidth() {
    SnakesAndLaddersBoard testBoard = new SnakesAndLaddersBoard(2,3);
    assertThrows(IllegalArgumentException.class, () -> new SnakesAndLaddersBoard(-1,3));
    assertEquals(2, testBoard.getWidth());
  }

  @Test
  @DisplayName("Test for setting height")
  public void testSetHeight() {
    SnakesAndLaddersBoard testBoard = new SnakesAndLaddersBoard(2,3);
    assertThrows(IllegalArgumentException.class, () -> new SnakesAndLaddersBoard(3,-1));
    assertEquals(3,testBoard.getHeight());
  }
}