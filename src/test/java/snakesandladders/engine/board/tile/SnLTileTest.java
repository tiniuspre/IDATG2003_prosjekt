package snakesandladders.engine.board.tile;

import constants.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnLTileTest {

  private SnLTile tile;

  @BeforeEach
  void setUp() {
    tile = new SnLTile(5, Constants.LADDER);
  }

  @Test
  @DisplayName("Tile type is set and retrieved correctly")
  void tileTypeSetAndRetrievedCorrectly() {
    assertEquals(Constants.LADDER, tile.getType());
  }

  @Test
  @DisplayName("Next position is set and retrieved correctly for valid ladder")
  void nextPositionSetAndRetrievedCorrectlyForValidLadder() {
    tile.setNext(10);
    assertEquals(10, tile.getNext());
  }

  @Test
  @DisplayName("Exception is thrown when next position is negative")
  void exceptionThrownWhenNextPositionIsNegative() {
    assertThrows(IllegalArgumentException.class, () -> tile.setNext(-1));
  }

  @Test
  @DisplayName("Exception is thrown when next position is invalid for ladder")
  void exceptionThrownWhenNextPositionIsInvalidForLadder() {
    assertThrows(IllegalArgumentException.class, () -> tile.setNext(3));
  }

  @Test
  @DisplayName("Exception is thrown when next position is invalid for snake")
  void exceptionThrownWhenNextPositionIsInvalidForSnake() {
    SnLTile snakeTile = new SnLTile(10, Constants.SNAKE);
    assertThrows(IllegalArgumentException.class, () -> snakeTile.setNext(15));
  }

  @Test
  @DisplayName("Next position is set and retrieved correctly for valid snake")
  void nextPositionSetAndRetrievedCorrectlyForValidSnake() {
    SnLTile snakeTile = new SnLTile(10, Constants.SNAKE);
    snakeTile.setNext(5);
    assertEquals(5, snakeTile.getNext());
  }
}