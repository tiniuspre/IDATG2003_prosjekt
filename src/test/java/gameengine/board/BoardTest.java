package gameengine.board;

import junit.framework.TestCase;
import snakesandladders.engine.SnakesAndLaddersBoard;

import static org.junit.Assert.assertThrows;

public class BoardTest extends TestCase {


  public void testSetWidth() {
    SnakesAndLaddersBoard testBoard = new SnakesAndLaddersBoard(2,3);
    assertThrows(IllegalArgumentException.class, () -> new SnakesAndLaddersBoard(-1,3));
    assertEquals(2, testBoard.getWidth());
  }

  public void testSetHeight() {
    SnakesAndLaddersBoard testBoard = new SnakesAndLaddersBoard(2,3);
    assertThrows(IllegalArgumentException.class, () -> new SnakesAndLaddersBoard(3,-1));
    assertEquals(3,testBoard.getHeight());
  }
}