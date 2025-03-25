package snakesandladders.engine;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class SnakesAndLaddersBoardTest {

  @Test
  public void testGetTile() {
    SnakesAndLaddersBoard testGameBoard = new SnakesAndLaddersBoard(10,9);
    testGameBoard.createBoard();
    assertEquals(testGameBoard.getTiles().get(3), testGameBoard.getTile(3));
    assertThrows(IllegalArgumentException.class, () -> testGameBoard.getTile(-1));
  }
}