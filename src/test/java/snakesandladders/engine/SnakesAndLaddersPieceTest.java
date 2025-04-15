package snakesandladders.engine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SnakesAndLaddersPieceTest {

  @Test
  @DisplayName("toString() returns correct string representation")
  void fromString() {
    assertEquals(SnakesAndLaddersPiece.HAT, SnakesAndLaddersPiece.fromString("hat"));
    assertEquals(SnakesAndLaddersPiece.BOOT, SnakesAndLaddersPiece.fromString("boot"));
    assertEquals(SnakesAndLaddersPiece.CAT, SnakesAndLaddersPiece.fromString("cat"));
    assertEquals(SnakesAndLaddersPiece.DOG, SnakesAndLaddersPiece.fromString("dog"));
    assertEquals(SnakesAndLaddersPiece.CAR, SnakesAndLaddersPiece.fromString("car"));
    assertThrows(IllegalArgumentException.class, () -> SnakesAndLaddersPiece.fromString("invalid"));
  }
}