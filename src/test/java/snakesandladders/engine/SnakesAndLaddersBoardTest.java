package snakesandladders.engine;

import junit.framework.TestCase;

import static org.junit.Assert.assertThrows;

public class SnakesAndLaddersBoardTest extends TestCase {


  public void testGetTile() {
    SnakesAndLaddersBoard testGameBoard = new SnakesAndLaddersBoard(10,9);
    testGameBoard.createBoard();
    assertEquals(testGameBoard.getTiles().get(3), testGameBoard.getTile(3));
    assertThrows(IllegalArgumentException.class, () -> testGameBoard.getTile(-1));
  }
}