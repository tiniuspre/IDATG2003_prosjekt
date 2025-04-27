package snakesandladders.engine.board.tile;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JumpTest {

  private Jump jump;

  @BeforeEach
  void setUp() {
    jump = new Jump(5, 10);
  }

  @Test
  @DisplayName("Jump is created successfully with valid positions")
  void jumpCreatedSuccessfullyWithValidPositions() {
    assertEquals(5, jump.getFrom());
    assertEquals(10, jump.getTo());
  }

  @Test
  @DisplayName("Exception is thrown when starting position is negative")
  void exceptionThrownWhenStartingPositionIsNegative() {
    assertThrows(IllegalArgumentException.class, () -> new Jump(-1, 10));
  }

  @Test
  @DisplayName("Exception is thrown when ending position is negative")
  void exceptionThrownWhenEndingPositionIsNegative() {
    assertThrows(IllegalArgumentException.class, () -> new Jump(5, -10));
  }

  @Test
  @DisplayName("Starting position is updated successfully with valid input")
  void startingPositionUpdatedSuccessfullyWithValidInput() {
    jump.setFrom(8);
    assertEquals(8, jump.getFrom());
  }

  @Test
  @DisplayName("Exception is thrown when updating starting position to a negative value")
  void exceptionThrownWhenUpdatingStartingPositionToNegativeValue() {
    assertThrows(IllegalArgumentException.class, () -> jump.setFrom(-5));
  }

  @Test
  @DisplayName("Ending position is updated successfully with valid input")
  void endingPositionUpdatedSuccessfullyWithValidInput() {
    jump.setTo(15);
    assertEquals(15, jump.getTo());
  }

  @Test
  @DisplayName("Exception is thrown when updating ending position to a negative value")
  void exceptionThrownWhenUpdatingEndingPositionToNegativeValue() {
    assertThrows(IllegalArgumentException.class, () -> jump.setTo(-10));
  }
}