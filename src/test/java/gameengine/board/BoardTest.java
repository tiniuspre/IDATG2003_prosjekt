package gameengine.board;

import junit.framework.TestCase;
import testgame.engine.TestGameBoard;

import static org.junit.Assert.assertThrows;

public class BoardTest extends TestCase {


  public void testSetWidth() {
    TestGameBoard testBoard = new TestGameBoard(2,3);
    assertThrows(IllegalArgumentException.class, () -> new TestGameBoard(-1,3));
    assertEquals(2, testBoard.getWidth());
  }

  public void testSetHeight() {
    TestGameBoard testBoard = new TestGameBoard(2,3);
    assertThrows(IllegalArgumentException.class, () -> new TestGameBoard(3,-1));
    assertEquals(3,testBoard.getHeight());
  }
}